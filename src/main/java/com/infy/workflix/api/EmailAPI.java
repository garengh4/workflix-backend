package com.infy.workflix.api;

import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.workflix.dto.EmailDTO;
import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.service.EmailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

//import other classes here and annotation

@CrossOrigin
@RequestMapping(value = "/login-api")
@RestController
@Validated
public class EmailAPI {

    @Autowired
    private EmailService emailService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Environment environment;

    static Log logger = LogFactory.getLog(EmailAPI.class);

    @PostMapping(value = "/login")
    public ResponseEntity<EmailDTO> authenticateEmail(@Valid @RequestBody EmailDTO emailDTO) throws WorkflixException{

        logger.info("USER TRYING TO LOGIN, VALIDATING CREDENTIALS. USER EMAIL ID: " + emailDTO.getEmailId());
        EmailDTO emailDTOFromDB = emailService.authenticateEmail(emailDTO.getEmailId(), emailDTO.getPassword());
        logger.info("USER LOGIN SUCCESS, USER EMAIL: " + emailDTOFromDB.getEmailId());
        return new ResponseEntity<>(emailDTOFromDB,HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerEmail(@Valid @RequestBody EmailDTO emailDTO) throws WorkflixException{

        logger.info("USER TRYING TO REGISTER. USER EMAIL ID: " + emailDTO.getEmailId());
        String registeredWithEmailID = emailService.registerNewEmail(emailDTO);
        registeredWithEmailID = environment.getProperty("EmailAPI.USER_REGISTRATION_SUCCESS") + registeredWithEmailID;
        return new ResponseEntity<>(registeredWithEmailID,HttpStatus.OK);
    }

    @PutMapping(value = "/{emailId:.+}/password/")
    public ResponseEntity<String> changePassword (@PathVariable @Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message = "{invalid.email.format}") String emailId,
                                                  @RequestBody EmailDTO emailDTO) throws WorkflixException{
        logger.info("USER TRYING TO CHANCE PASSWORD. USER EMAIL ID: "+ emailId);
        emailService.changePassword(emailId, emailDTO.getPassword(),emailDTO.getNewPassword());
        String updateSuccessful = environment.getProperty("EmailAPI.CHANGE_PASSWORD_SUCCESS");
        return new ResponseEntity<>(updateSuccessful,HttpStatus.OK);

    }

//    @GetMapping(value = "/email/{emailId:.+}/profiles/")
//    public ResponseEntity<Set<ProfileDTO>> getProfileFromEmailId(@Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message = "{invalid.email.format}") String emailId)
//            throws WorkflixException {
//        logger.info("USER TRYING TO GET PROFILE. USER EMAIL ID: "+ emailId);
//        Set<ProfileDTO> profileDTOS= emailService.getProfileByEmailId(emailId);
//        return new ResponseEntity<>(profileDTOS, HttpStatus.OK);
//    }
}
