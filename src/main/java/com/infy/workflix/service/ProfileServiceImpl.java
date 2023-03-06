package com.infy.workflix.service;

import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.entity.Profile;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service (value ="profileService")
@Transactional
public class ProfileServiceImpl implements ProfileService{

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public String createProfile(ProfileDTO profileDTO) throws WorkflixException{
        String msg = null;
        return msg;
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
    public Set<ProfileDTO> getProfilesByEmail(String emailId) throws WorkflixException{
        Set<ProfileDTO> profiles = null;

        return profiles;
    }


}
