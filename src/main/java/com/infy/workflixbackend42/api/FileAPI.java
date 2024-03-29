package com.infy.workflixbackend42.api;

import com.infy.workflixbackend42.dto.FileDTO;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.service.FileService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@CrossOrigin
@RequestMapping(value = "/file-api")
@RestController
@Validated
public class FileAPI {
    @Autowired
    private FileService fileService;
    @Autowired
    private Environment environment;


    static Log logger = LogFactory.getLog(ProfileAPI.class);
    @PostMapping(value= "/upload",consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("category") String categoryName,
                                             @RequestParam("descriptions") String descriptions, @RequestParam("profileId") String profileId ) throws WorkflixException{
        String msg=fileService.uploadFile(file,categoryName,descriptions,profileId);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @GetMapping(value="file/Id/{fileId}/")
    public ResponseEntity<FileDTO> getFileByFileId(@PathVariable long fileId) throws WorkflixException {
        FileDTO fileDTO = fileService.getFileByFileId(fileId);
        return new ResponseEntity<>(fileDTO,HttpStatus.OK);
    }

    @GetMapping(value="file/name/{fileName}/")
    public ResponseEntity<FileDTO> getFileByFileName (@PathVariable String fileName) throws WorkflixException{
        FileDTO fileDTO = fileService.getFileByFileName(fileName);
        return new ResponseEntity<>(fileDTO,HttpStatus.OK);
    }

    @PutMapping(value="file/update/{fileName}")
    public ResponseEntity<String> updateFileName (@PathVariable String fileName,@RequestParam("newFileName") String newFileName)throws WorkflixException{
        String msg=fileService.updateFileName(fileName,newFileName);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping(value = "files/userProfile/{profileId}/")
    public ResponseEntity<Set<FileDTO>> getFilesByProfileId (@PathVariable String profileId) throws WorkflixException {
        return new ResponseEntity<>(fileService.getFilesByProfileId(profileId), HttpStatus.OK);
    }

    @GetMapping(value = "files/categoryName/{categoryName}/")
    public ResponseEntity<Set<FileDTO>> getFilesByCategoryName (@PathVariable String categoryName) throws WorkflixException {
        return new ResponseEntity<>(fileService.getFilesByCategoryName(categoryName), HttpStatus.OK);
    }

    @DeleteMapping(value = "file/delete/{fileName}/")
    public ResponseEntity<String> deleteFile (@PathVariable String fileName) throws WorkflixException {
        String msg = fileService.deleteFile(fileName);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}