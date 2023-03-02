package com.infy.workflix.api;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.service.ProfileService;
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
@RequestMapping(value = "/profile-api")
@RestController
@Validated
public class ProfileAPI {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    static Log logger = LogFactory.getLog(ProfileAPI.class);

    @PostMapping(value = "/create-profile")
    public ResponseEntity<String> createProfile() throws WorkflixException{
        String msg =null;
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @PutMapping(value ="/{userProfileId}/update-profile")
    public ResponseEntity<String> updateProfile(@PathVariable String userProfileId, @RequestBody @Valid ProfileDTO profileDTO) throws WorkflixException{
        logger.info("USER TRYING TO CHANGE PROFILE INFORMATION. USER PROFILE ID: "+ userProfileId);
        String updateSuccessful = profileService.updateProfile(userProfileId,profileDTO.getUserFirstName(),profileDTO.getUserLastName());
        updateSuccessful = environment.getProperty("ProfileAPI.PROFILE_UPDATE_SUCCESS") + updateSuccessful;
        return new ResponseEntity<>(updateSuccessful,HttpStatus.OK);

    }

    @DeleteMapping(value = "/{userName}/delete-profile")
    public ResponseEntity<String> deleteProfile() throws WorkflixException{
        String msg =null;
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @GetMapping(value = "{emailId}/profiles")
    public ResponseEntity<Set<ProfileDTO>> getProfilesByEmail() throws WorkflixException{
        Set<ProfileDTO> profiles = null;

        return new ResponseEntity<>(profiles,HttpStatus.OK);
    }


}
