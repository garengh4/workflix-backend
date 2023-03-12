package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.ProfileDTO;
import com.infy.workflixbackend2.entity.Profile;
import com.infy.workflixbackend2.exception.GeneralException;

import java.util.Set;

public interface ProfileService {
    public String createProfile(ProfileDTO profileDTO) throws GeneralException;
    public String deletingProfile(String userProfileId) throws GeneralException;
    public String updateProfile(String userProfileId, String firstName, String lastName) throws GeneralException;
    public Set<ProfileDTO> getProfilesByEmail(String emailId) throws GeneralException;

    static ProfileDTO profileDTOFrom(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setUserProfileId(profile.getUserProfileId());
        profileDTO.setEmailId(profile.getEmailId());
        profileDTO.setUserFirstName(profile.getUserFirstName());
        profileDTO.setUserLastName(profile.getUserLastName());
        return profileDTO;
    }
}
