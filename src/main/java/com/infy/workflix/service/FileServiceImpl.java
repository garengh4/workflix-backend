package com.infy.workflix.service;

import com.infy.workflix.dto.FileDTO;
import com.infy.workflix.entity.InputFile;
import com.infy.workflix.exception.FileWriteException;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.repository.FileRepository;
import com.infy.workflix.utility.DataBucketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Path;
import java.util.Set;

@Service (value ="fileService")
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private DataBucketUtil dataBucketUtil;

    @Override
    public String uploadFile(MultipartFile file, String categoryName, String descriptions, String profileId) throws WorkflixException {

            String originalFileName = file.getOriginalFilename();
            Path path = new File(originalFileName).toPath();
            FileDTO fileDTO;
            try {
               // String contentType = Files.probeContentType(path);
                fileDTO= dataBucketUtil.uploadFile(file, originalFileName);
            } catch (Exception e) {
                throw new FileWriteException("Error occurred while uploading");
            }
       InputFile inputFile=new InputFile();
        inputFile.setFileName(fileDTO.getFileName());
        inputFile.setFileUrl(fileDTO.getFileUrl());
        inputFile.setCategoryName(categoryName);
        inputFile.setDescriptions(descriptions);
        inputFile.setUserProfileId(profileId);
        fileRepository.save(inputFile);
        return fileDTO.getFileUrl();
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

