package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.FileDTO;
import com.infy.workflixbackend2.entity.InputFile;
import com.infy.workflixbackend2.exception.FileWriteException;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.repository.FileRepository;
import com.infy.workflixbackend2.utility.DataBucketUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service(value ="fileService")
@Transactional
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private DataBucketUtil dataBucketUtil;
    @Override
    public String uploadFile(MultipartFile file, String categoryName, String descriptions, String profileId) throws WorkflixException {

            String originalFileName = file.getOriginalFilename();
           Optional<InputFile> optionalFiles= Optional.ofNullable(fileRepository.findByFileName(originalFileName));
           if(optionalFiles.isPresent()){
               throw new WorkflixException("FileService.FILE_NAME_ALREADY_IN_USE");
            }
            FileDTO fileDTO;
            try {
                fileDTO= dataBucketUtil.uploadFile(file, originalFileName);
            } catch (Exception e) {
                throw new FileWriteException("Error occurred while uploading");
            }
       InputFile inputFile=new InputFile();
        inputFile.setFileName(fileDTO.getFileName());
        inputFile.setFileUrl(fileDTO.getFileUrl());
        inputFile.setCategoryName(categoryName);
        inputFile.setDescriptions(descriptions);
        inputFile.setProfileId(profileId);
        fileRepository.save(inputFile);
        return fileDTO.getFileUrl();
    }

    @Override
    public FileDTO getFileByFileId(long fileId) throws WorkflixException {
        Optional<InputFile> optionalFiles = Optional.of(fileRepository.findByFileId(fileId));
        InputFile file = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));
        FileDTO fileDTO=fileDTOFrom(file);
        return fileDTO;
    }

    @Override
    public FileDTO getFileByFileName(String fileName) throws WorkflixException {
        Optional<InputFile> optionalFiles = Optional.of(fileRepository.findByFileName(fileName));
        InputFile file = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));
        FileDTO fileDTO=fileDTOFrom(file);
        return fileDTO;
    }

    @Override
    public String updateFileName(String oldFileName, String newFileName) throws WorkflixException{
        Optional<InputFile> optionalFiles = Optional.of(fileRepository.findByFileName(oldFileName));
        InputFile file = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));
        Optional<InputFile> optionalNewFiles= Optional.ofNullable(fileRepository.findByFileName(newFileName));
        if(optionalNewFiles.isPresent()){
            throw new WorkflixException("FileService.FILE_NAME_ALREADY_IN_USE");
        }
        file.setFileName(newFileName);
        String newUrl = dataBucketUtil.updateFile(oldFileName,newFileName);
        file.setFileUrl(newUrl);
        return newFileName+" updated!";
    }
    @Override
    public Set<FileDTO> getFilesByProfileId(String profileId) throws WorkflixException {
        Optional<Set<InputFile>> optionalFiles = Optional.of(fileRepository.findByProfileId(profileId));
        Set<InputFile> fileList = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));

        Set<FileDTO> fileDTO = fileList
                .stream()
                .map((file) -> fileDTOFrom(file))
                .collect(Collectors.toSet());
        return fileDTO;
    }

    @Override
    public Set<FileDTO> getFilesByCategoryName(String categoryName) throws WorkflixException {
        Optional<Set<InputFile>> optionalFiles = Optional.of(fileRepository.findByCategoryName(categoryName));
        Set<InputFile> fileList = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));

        Set<FileDTO> fileDTO = fileList
                .stream()
                .map((file) -> fileDTOFrom(file))
                .collect(Collectors.toSet());
        return fileDTO;
    }

    @Override
    public String deleteFile(String fileName) throws WorkflixException {
        Optional<InputFile> optionalFiles = Optional.of(fileRepository.findByFileName(fileName));
        InputFile file = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));
        fileRepository.delete(file);
        String msg=dataBucketUtil.deleteFile(fileName);
        return fileName+msg;
    }
    public FileDTO fileDTOFrom(InputFile file) {
        FileDTO fileDTO = new FileDTO(file.getFileName(), file.getFileUrl());

        fileDTO.setFileId(file.getFileId());
        fileDTO.setCategoryName(file.getCategoryName());
        fileDTO.setProfileId(file.getProfileId());
        fileDTO.setDescriptions(file.getDescriptions());
        return fileDTO;
    }

}