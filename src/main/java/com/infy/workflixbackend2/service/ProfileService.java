package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.ProfileDTO;
import com.infy.workflixbackend2.entity.Profile;
import com.infy.workflixbackend2.exception.WorkflixException;

import java.util.Set;

public interface ProfileService {
    public String createProfile(ProfileDTO profileDTO) throws WorkflixException;
    public String deletingProfile(String userProfileId) throws WorkflixException;
    public String updateProfile(String userProfileId, String firstName, String lastName) throws WorkflixException;
    public Set<ProfileDTO> getProfilesByEmail(String emailId) throws WorkflixException;
}
