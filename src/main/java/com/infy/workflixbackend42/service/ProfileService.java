package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.ProfileDTO;
import com.infy.workflixbackend42.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProfileService {

    public String createProfile(ProfileDTO profileDTO) throws WorkflixException;

    public String deleteProfile(String profileId) throws WorkflixException;

    public List<ProfileDTO> getProfiles(String loginId) throws WorkflixException;
}

