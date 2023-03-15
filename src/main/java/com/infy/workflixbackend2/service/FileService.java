package com.infy.workflixbackend2.service;


import com.infy.workflixbackend2.dto.FileDTO;
import com.infy.workflixbackend2.entity.InputFile;
import com.infy.workflixbackend2.exception.WorkflixException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
public interface FileService {
    public String uploadFile(MultipartFile file, String categoryName, String descriptions, String profileId) throws WorkflixException;
    public FileDTO getFileByFileId(long fileId) throws WorkflixException;
    public FileDTO getFileByFileName (String fileName) throws WorkflixException;
    public String updateFileName (String oldFileName, String newFileName) throws WorkflixException;
    public Set<FileDTO> getFilesByUserProfileId (String userProfileId) throws WorkflixException;
    public Set<FileDTO> getFilesByCategoryName (String categoryName) throws WorkflixException;
    public String deleteFile (String fileName) throws WorkflixException;
    static FileDTO fileDTOFrom(InputFile file) {
        FileDTO fileDTO = new FileDTO(file.getFileName(), file.getFileUrl());

        fileDTO.setFileId(file.getFileId());
        fileDTO.setCategoryName(file.getCategoryName());
        fileDTO.setUserProfileId(file.getUserProfileId());
        fileDTO.setDescriptions(file.getDescriptions());
        return fileDTO;
    }


}
