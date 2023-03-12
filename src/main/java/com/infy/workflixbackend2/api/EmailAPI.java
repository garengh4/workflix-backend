package com.infy.workflixbackend2.api;

import com.infy.workflixbackend2.dto.EmailDTO;
import com.infy.workflixbackend2.exception.GeneralException;
import com.infy.workflixbackend2.service.EmailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

@CrossOrigin
@RequestMapping(value = "/login-api")
@RestController
@Validated
public class EmailAPI {

    @Autowired
    private EmailService emailService;



    @Autowired
    private Environment environment;

    static Log logger = LogFactory.getLog(EmailAPI.class);


    @PostMapping(value = "/login")
    public ResponseEntity<EmailDTO> authenticateEmail(@Valid @RequestBody EmailDTO emailDTO) throws GeneralException {

        logger.info("USER TRYING TO LOGIN, VALIDATING CREDENTIALS. USER EMAIL ID: " + emailDTO.getEmailId());
        EmailDTO emailDTOFromDB = emailService.authenticateEmail(emailDTO.getEmailId(), emailDTO.getPassword());
        logger.info("USER LOGIN SUCCESS, USER EMAIL: " + emailDTOFromDB.getEmailId());
        return new ResponseEntity<>(emailDTOFromDB, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerEmail(@Valid @RequestBody EmailDTO emailDTO) throws GeneralException{

        logger.info("USER TRYING TO REGISTER. USER EMAIL ID: " + emailDTO.getEmailId());
        String registeredWithEmailID = emailService.registerNewEmail(emailDTO);
        registeredWithEmailID = environment.getProperty("EmailAPI.USER_REGISTRATION_SUCCESS") + registeredWithEmailID;
        return new ResponseEntity<>(registeredWithEmailID,HttpStatus.OK);
    }

    @PutMapping(value = "/{emailId:.+}/password/")
    public ResponseEntity<String> changePassword (@PathVariable @Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message = "{invalid.email.format}") String emailId,
                                                  @RequestBody EmailDTO emailDTO) throws GeneralException{
        logger.info("USER TRYING TO CHANCE PASSWORD. USER EMAIL ID: "+ emailId);
        emailService.changePassword(emailId, emailDTO.getPassword(),emailDTO.getNewPassword());
        String updateSuccessful = environment.getProperty("EmailAPI.CHANGE_PASSWORD_SUCCESS");
        return new ResponseEntity<>(updateSuccessful,HttpStatus.OK);

    }
}
