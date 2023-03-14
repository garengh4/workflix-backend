package com.infy.workflixbackend2.api;

import com.infy.workflixbackend2.dto.LoginDTO;
import com.infy.workflixbackend2.entity.Login;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.service.LoginService;
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
import java.util.List;

@CrossOrigin
@RequestMapping(value = "/login-api")
@RestController
@Validated
public class LoginAPI {

    @Autowired
    private LoginService loginService;

    @Autowired
    private Environment environment;

    static Log logger = LogFactory.getLog(LoginAPI.class);

    @PostMapping(value = "/login")
    public ResponseEntity<LoginDTO> authenticateLogin(@Valid @RequestBody LoginDTO loginDTO) throws WorkflixException {

        logger.info("USER TRYING TO LOGIN, VALIDATING CREDENTIALS. USER LOGIN ID: " + loginDTO.getLoginId());
        LoginDTO loginDTOFromDB = loginService.authenticateLogin(loginDTO.getLoginId(), loginDTO.getPassword());
        return new ResponseEntity<>(loginDTOFromDB, HttpStatus.OK);
    }

    @GetMapping
    public List<Login> allLogins(){
        return loginService.getAllLogins();
    }

    @PostMapping(value = "/register")
    public ResponseEntity<String> registerLogin(@Valid @RequestBody LoginDTO loginDTO) throws WorkflixException{

        logger.info("USER TRYING TO REGISTER. USER LOGIN ID: " + loginDTO.getLoginId());
        String registeredWithLoginID = loginService.registerNewLogin(loginDTO);
        registeredWithLoginID = environment.getProperty("LoginAPI.USER_REGISTRATION_SUCCESS") + registeredWithLoginID;
        return new ResponseEntity<>(registeredWithLoginID,HttpStatus.OK);
    }

}
