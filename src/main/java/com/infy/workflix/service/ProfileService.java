package com.infy.workflix.service;

import com.infy.workflix.dto.FileDTO;
import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.entity.Profile;
import com.infy.workflix.exception.WorkflixException;

import java.util.Set;

public interface ProfileService {

    public String createProfile(ProfileDTO profileDTO) throws WorkflixException;
    public String deletingProfile(String userProfileId) throws WorkflixException;
    public String updateProfile(String userProfileId, String firstName, String lastName) throws WorkflixException;
    public Set<ProfileDTO> getProfilesByEmail(String emailId) throws WorkflixException;

    static ProfileDTO profileDTOFrom(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setUserProfileId(profile.getUserProfileId());
        profileDTO.setEmailId(profile.getEmailId());
        profileDTO.setUserFirstName(profile.getUserFirstName());
        profileDTO.setUserLastName(profile.getUserLastName());

        profile.setFiles(profile.getFiles());//Might need to look at this more carefully

//        FileDTO fileDTO = new FileDTO();
//        profile.getFiles().stream().forEach((file) -> fileDTO.setFileId(file.getFileId()));
//        profile.getFiles().stream().forEach((file) -> fileDTO.setFileData(file.getFileData()));
//        profile.getFiles().stream().forEach((file) -> fileDTO.setUserProfileId(file.getUserProfileId()));


        return profileDTO;
    }

}
