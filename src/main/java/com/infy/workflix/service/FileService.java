package com.infy.workflix.service;

import com.infy.workflix.dto.FileDTO;
import com.infy.workflix.exception.WorkflixException;

import java.util.Set;

public interface FileService {

    public String uploadFile(FileDTO fileDTO) throws WorkflixException;
    public FileDTO getFileByFileId(long fileId) throws WorkflixException;
    public FileDTO getFileByFileName (String fileName) throws WorkflixException;
    public String updateFileName (String oldFileName, String newFileName) throws WorkflixException;
    public Set<FileDTO> getFilesByUserProfileId (String userProfileId) throws WorkflixException;
    public Set<FileDTO> getFilesByCategoryName (String categoryName) throws WorkflixException;
    public String deleteFile (String fileName) throws WorkflixException;

}
