package com.infy.workflixbackend42.api;

import com.infy.workflixbackend42.dto.ProfileDTO;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.service.ProfileService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/profile-api")
@RestController
@Validated
public class ProfileAPI {
    static Log logger = LogFactory.getLog(ProfileAPI.class);

    @Autowired
    private ProfileService profileService;

    @Autowired
    private Environment environment;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createProfile(@RequestBody ProfileDTO profileDTO) throws WorkflixException {
        return new ResponseEntity<>(profileService.createProfile(profileDTO), HttpStatus.OK);

    }
    @GetMapping(value = "/profiles/{loginId}")
    public ResponseEntity<List<ProfileDTO>> getProfiles(@PathVariable("loginId") String loginId) throws WorkflixException{
        List<ProfileDTO> profileDTOList = profileService.getProfiles(loginId);
        return new ResponseEntity<List<ProfileDTO>>(profileDTOList, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{profileId}")
    public ResponseEntity<String> deleteProfile(@PathVariable String profileId) throws WorkflixException{
        logger.info("DELETING PROFILE: "+ profileId);
        profileService.deleteProfile(profileId);
        String deleteSuccess = environment.getProperty("ProfileAPI.PROFILE_DELETE_SUCCESS");
        return new ResponseEntity<>(deleteSuccess,HttpStatus.OK);
    }

}