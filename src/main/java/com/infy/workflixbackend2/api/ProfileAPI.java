//package com.infy.workflixbackend2.api;
//import com.infy.workflixbackend2.dto.ProfileDTO;
//import com.infy.workflixbackend2.exception.WorkflixException;
//import com.infy.workflixbackend2.service.ProfileService;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import javax.validation.constraints.Email;
//import java.util.Set;
//
//@CrossOrigin
//@RequestMapping(value = "/profile-api")
//@RestController
//@Validated
//public class ProfileAPI {
//
//    @Autowired
//    private ProfileService profileService;
//
//    @Autowired
//    private Environment environment;
//
//
//    static Log logger = LogFactory.getLog(ProfileAPI.class);
//
//    @PostMapping(value = "/create-profile")
//    public ResponseEntity<String> createProfile() throws WorkflixException {
//        String msg =null;
//        return new ResponseEntity<>(msg, HttpStatus.OK);
//    }
//
//    @PutMapping(value ="/{userProfileId}/update-profile")
//    public ResponseEntity<String> updateProfile(@PathVariable String userProfileId, @RequestBody @Valid ProfileDTO profileDTO) throws WorkflixException {
//        logger.info("USER TRYING TO CHANGE PROFILE INFORMATION. USER PROFILE ID: "+ userProfileId);
//        String updateSuccessful = profileService.updateProfile(userProfileId,profileDTO.getUserFirstName(),profileDTO.getUserLastName());
//        updateSuccessful = environment.getProperty("ProfileAPI.PROFILE_UPDATE_SUCCESS") + updateSuccessful;
//        return new ResponseEntity<>(updateSuccessful,HttpStatus.OK);
//
//    }
//
//    @DeleteMapping(value = "/{userProfileId}/delete-profile")
//    public ResponseEntity<String> deleteProfile(@PathVariable String userProfileId) throws WorkflixException {
//        logger.info("DELETING PROFILE: "+ userProfileId);
//        profileService.deletingProfile(userProfileId);
//        String deleteSuccess = environment.getProperty("ProfileAPI.PROFILE_DELETE_SUCCESS");
//        return new ResponseEntity<>(deleteSuccess,HttpStatus.OK);
//    }
//
//    @GetMapping(value = "{emailId}/profiles")
//    public ResponseEntity<Set<ProfileDTO>> getProfilesByEmail(@PathVariable("emailId") @Email(message = "{invalid.email.format}") String emailId)
//            throws WorkflixException {
//        return new ResponseEntity<Set<ProfileDTO>>(profileService.getProfilesByEmail(emailId),HttpStatus.OK);
//    }
//}
