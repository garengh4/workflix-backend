package com.infy.workflix.service;

import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.entity.Profile;
import com.infy.workflix.exception.WorkflixException;

import java.util.Set;

public interface ProfileService {

    public String createProfile(ProfileDTO profileDTO) throws WorkflixException;
    public String deletingProfile(String userName) throws WorkflixException;
    public String updateProfile(String userName, String firstName, String lastName);
    public Set<ProfileDTO> getProfilesByEmail(String emailId);

}
