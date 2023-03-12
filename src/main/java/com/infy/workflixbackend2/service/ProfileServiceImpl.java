package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.ProfileDTO;
import com.infy.workflixbackend2.entity.Profile;
import com.infy.workflixbackend2.exception.GeneralException;
import com.infy.workflixbackend2.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value ="profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public String createProfile(ProfileDTO profileDTO) throws GeneralException {
        String msg = null;
        return msg;
    }

    @Override
    public String deletingProfile(String userProfileId) throws GeneralException{

        Profile profile = profileRepository.findById(userProfileId).orElseThrow(
                () -> new GeneralException("ProfileService.PROFILE_NOT_FOUND")
        );
        profileRepository.delete(profile);
        return userProfileId;
    }

    @Override
    public String updateProfile(String userProfileId, String firstName, String lastName) throws GeneralException{
        String profileCreated = null;

        Optional<Profile> optional = profileRepository.findById(userProfileId.toLowerCase());
        Profile profile = optional.orElseThrow(()-> new GeneralException("ProfileService.PROFILE_NOT_FOUND"));

        profile.setUserFirstName(firstName);
        profile.setUserLastName(lastName);

        profileCreated= userProfileId;
        return profileCreated;
    }

    @Override
    public Set<ProfileDTO> getProfilesByEmail(String emailId) throws GeneralException {
        Optional<List<Profile>> optionalProfiles = Optional.of(profileRepository.findByEmailId(emailId)); //toLowerCase() ? Probably not.
        List<Profile> profiles = optionalProfiles.orElseThrow(() -> new GeneralException("EmailService.PROFILE_NOT_FOUND"));

        Set<ProfileDTO> profilesDTO = profiles
                .stream()
                .map((profile) -> ProfileService.profileDTOFrom(profile))
                .collect(Collectors.toSet());

        return profilesDTO;
    }


}