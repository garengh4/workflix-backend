package com.infy.workflix.service;

import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.entity.Profile;
import com.infy.workflix.exception.WorkflixException;

import java.util.Set;

public interface ProfileService {

    public String createProfile(ProfileDTO profileDTO) throws WorkflixException;
    public String deletingProfile(String userProfileId) throws WorkflixException;
    public String updateProfile(String userProfileId, String firstName, String lastName) throws WorkflixException;
    public Set<ProfileDTO> getProfilesByEmail(String emailId) throws WorkflixException;

}
