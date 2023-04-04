package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.CategoryDTO;
import com.infy.workflixbackend2.dto.ProfileDTO;
import com.infy.workflixbackend2.entity.Category;
import com.infy.workflixbackend2.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public interface ProfileService {

    public String createProfile(ProfileDTO profileDTO) throws WorkflixException;
    public String deleteProfile(String profileId) throws WorkflixException;
    public List<ProfileDTO> getProfiles(String loginId) throws WorkflixException;


}

