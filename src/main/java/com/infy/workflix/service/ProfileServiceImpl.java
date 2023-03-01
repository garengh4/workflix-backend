package com.infy.workflix.service;

import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String deletingProfile(String userName) throws WorkflixException{
        String msg = null;
        return msg;
    }

    @Override
    public String updateProfile(String userName, String firstName, String lastName){
        String msg = null;
        return msg;
    }

    @Override
    public Set<ProfileDTO> getProfilesByEmail(String emailId){
        Set<ProfileDTO> profiles = null;

        return profiles;
    }


}
