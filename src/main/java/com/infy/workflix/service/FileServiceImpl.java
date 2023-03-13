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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
        Optional<InputFile> optionalFiles = Optional.of(fileRepository.findByFileId(fileId));
        InputFile file = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));
        FileDTO fileDTO=FileService.fileDTOFrom(file);
        return fileDTO;
    }

    @Override
    public FileDTO getFileByFileName(String fileName) throws WorkflixException {
        Optional<InputFile> optionalFiles = Optional.of(fileRepository.findByFileName(fileName));
        InputFile file = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));
        FileDTO fileDTO=FileService.fileDTOFrom(file);
        return fileDTO;
    }

    @Override
    public String updateFileName(String oldFileName, String newFileName) throws WorkflixException{
        Optional<InputFile> optionalFiles = Optional.of(fileRepository.findByFileName(oldFileName));
        InputFile file = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));
        file.setFileName(newFileName);
        String newUrl = dataBucketUtil.updateFile(oldFileName,newFileName);
        file.setFileUrl(newUrl);
        return newFileName+" updated!";
    }
    @Override
    public Set<FileDTO> getFilesByUserProfileId(String userProfileId) throws WorkflixException {
        Optional<Set<InputFile>> optionalFiles = Optional.of(fileRepository.findByUserProfileId(userProfileId));
        Set<InputFile> fileList = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));

        Set<FileDTO> fileDTO = fileList
                .stream()
                .map((file) -> FileService.fileDTOFrom(file))
                .collect(Collectors.toSet());
        return fileDTO;
    }

    @Override
    public Set<FileDTO> getFilesByCategoryName(String categoryName) throws WorkflixException {
        Optional<Set<InputFile>> optionalFiles = Optional.of(fileRepository.findByCategoryName(categoryName));
        Set<InputFile> fileList = optionalFiles.orElseThrow(() -> new WorkflixException("FileService.FILE_NOT_FOUND"));

        Set<FileDTO> fileDTO = fileList
                .stream()
                .map((file) -> FileService.fileDTOFrom(file))
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
}

