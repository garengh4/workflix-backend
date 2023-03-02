package com.infy.workflix.service;

import com.infy.workflix.dto.FileDTO;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.repository.FileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service (value ="fileService")
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public String uploadFile(FileDTO fileDTO) throws WorkflixException {
        String msg = null;
        return msg;
    }

    @Override
    public FileDTO getFileByFileId(long fileId) throws WorkflixException {
        FileDTO fileDTO = null;
        return fileDTO;
    }

    @Override
    public FileDTO getFileByFileName(String fileName) throws WorkflixException {
        FileDTO fileDTO = null;
        return fileDTO;
    }

    @Override
    public String updateFileName(String oldFileName, String newFileName) throws WorkflixException{
        String msg = null;
        return msg;
    }
    @Override
    public Set<FileDTO> getFilesByUserProfileId(String userProfileId) throws WorkflixException {
        Set<FileDTO> fileDTOS = null;
        return fileDTOS;
    }

    @Override
    public Set<FileDTO> getFilesByCategoryName(String categoryName) throws WorkflixException {
        Set<FileDTO> fileDTOS = null;
        return fileDTOS;
    }

    @Override
    public String deleteFile(String fileName) throws WorkflixException {
        String msg = null;
        return msg;
    }
}

