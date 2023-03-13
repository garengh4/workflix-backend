package com.infy.workflix.service;

import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.entity.Profile;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service (value ="profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public String createProfile(ProfileDTO profileDTO) throws WorkflixException{
        String registeredWithProfileId = null;

        boolean isProfileAvailable = profileRepository.findById(profileDTO.getUserProfileId()).isEmpty();
        if(isProfileAvailable){
            Profile profile = new Profile();
            profile.setUserProfileId(profileDTO.getUserProfileId());
            profile.setUserFirstName(profileDTO.getUserFirstName());
            profile.setUserLastName(profileDTO.getUserLastName());
            profile.setEmailId(profileDTO.getEmailId());
            profileRepository.save(profile);
            registeredWithProfileId = profile.getUserProfileId();
        }else{
            throw new WorkflixException("profileService.PROFILE_ID_ALREADY_IN_USE");
        }
        return registeredWithProfileId;
    }

    @Override
    public String deletingProfile(String userProfileId) throws WorkflixException{

        Profile profile = profileRepository.findById(userProfileId).orElseThrow(
                () -> new WorkflixException("ProfileService.PROFILE_NOT_FOUND")
        );
        profileRepository.delete(profile);
        return userProfileId;
    }

    @Override
    public String updateProfile(String userProfileId, String firstName, String lastName) throws WorkflixException{
        String profileCreated = null;

        Optional<Profile> optional = profileRepository.findById(userProfileId.toLowerCase());
        Profile profile = optional.orElseThrow(()-> new WorkflixException("ProfileService.PROFILE_NOT_FOUND"));

        profile.setUserFirstName(firstName);
        profile.setUserLastName(lastName);

        profileCreated= userProfileId;
        return profileCreated;
    }

    @Override
    public Set<ProfileDTO> getProfilesByEmail(String emailId) throws WorkflixException {
        Optional<List<Profile>> optionalProfiles = Optional.of(profileRepository.findByEmailId(emailId)); //toLowerCase() ? Probably not.
        List<Profile> profiles = optionalProfiles.orElseThrow(() -> new WorkflixException("EmailService.PROFILE_NOT_FOUND"));

        Set<ProfileDTO> profilesDTO = profiles
                .stream()
                .map((profile) -> ProfileService.profileDTOFrom(profile))
                .collect(Collectors.toSet());

        return profilesDTO;
    }


}
