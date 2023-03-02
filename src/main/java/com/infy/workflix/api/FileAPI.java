package com.infy.workflix.api;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.workflix.dto.FileDTO;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.service.FileService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@RequestMapping(value = "/file-api")
@RestController
@Validated
public class FileAPI {

    @Autowired
    private FileService fileService;

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    static Log logger = LogFactory.getLog(ProfileAPI.class);

    @PostMapping(value= "/upload")
    public ResponseEntity<String> uploadFile(@Valid @RequestBody FileDTO fileDTO) throws WorkflixException{
        String msg=null;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping(value="file/Id/{fileId}/")
    public ResponseEntity<FileDTO> getFileByFileId(@PathVariable long fileId) throws WorkflixException{
        FileDTO fileDTO = null;
        return new ResponseEntity<>(fileDTO,HttpStatus.OK);
    }

    @GetMapping(value="file/name/{fileName}/")
    public ResponseEntity<FileDTO> getFileByFileName (@PathVariable String fileName) throws WorkflixException{
        FileDTO fileDTO = null;
        return new ResponseEntity<>(fileDTO,HttpStatus.OK);
    }

    @PutMapping(value="file/update/{fileName}")
    public ResponseEntity<String> updateFileName (@PathVariable String fileName, @RequestBody String newFileName){
        String msg = null;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping(value="files/userProfile/{userProfileId}/")
    public ResponseEntity<Set<FileDTO>> getFilesByUserProfileId(@PathVariable String userProfileId) throws WorkflixException{
        Set<FileDTO> fileDTOS = null;
        return new ResponseEntity<>(fileDTOS,HttpStatus.OK);
    }

    @GetMapping(value="files/categoryName/{categoryName}/")
    public ResponseEntity<Set<FileDTO>> getFilesByCategoryName(@PathVariable String categoryName) throws WorkflixException{
        Set<FileDTO> fileDTOS = null;
        return new ResponseEntity<>(fileDTOS,HttpStatus.OK);
    }

    @DeleteMapping(value="file/delete/{fileName}/")
    public ResponseEntity<String> deleteFile (@PathVariable String fileName) throws WorkflixException{
        String msg=null;
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

}
