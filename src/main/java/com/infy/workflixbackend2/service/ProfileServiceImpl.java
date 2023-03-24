package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.ProfileDTO;
import com.infy.workflixbackend2.entity.Login;
import com.infy.workflixbackend2.entity.Profile;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.repository.LoginRepository;
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
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public String createProfile(ProfileDTO profileDTO) throws WorkflixException {
        loginRepository.findById(profileDTO.getLoginId()).orElseThrow(
                () -> new WorkflixException("LoginService.USER_NOT_FOUND")
        );

        Profile profile = new Profile();
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setLoginId(profileDTO.getLoginId());
        profile.setProfileId(profileDTO.getProfileId());
        profile = profileRepository.save(profile);
        String registeredWithProfileId = profile.getProfileId();
        return registeredWithProfileId;
    }

    @Override
    public String deleteProfile(String profileId) throws WorkflixException {
        Profile profile = profileRepository.findById(profileId).orElseThrow(
                () -> new WorkflixException("ProfileService.PROFILE_NOT_FOUND")
        );
        profileRepository.delete(profile);
        return profileId;
    }

    @Override
    public List<ProfileDTO> getProfiles(String loginId) throws WorkflixException {
        Login login = loginRepository.findById(loginId).orElseThrow(
                () -> new WorkflixException("LoginService.USER_NOT_FOUND")
        );

        List<ProfileDTO> profileDTOs = login.getLoginProfiles().stream().map(e -> {
            ProfileDTO profileDTO = new ProfileDTO();
            profileDTO.setProfileId(e.getProfileId());
            profileDTO.setFirstName(e.getFirstName());
            profileDTO.setLastName(e.getLastName());
            profileDTO.setLoginId(e.getLoginId());
            return profileDTO;
        }).collect(Collectors.toList());
        return profileDTOs;
    }
}