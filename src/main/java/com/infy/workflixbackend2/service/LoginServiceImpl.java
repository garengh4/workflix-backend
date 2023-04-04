package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.LoginDTO;
import com.infy.workflixbackend2.entity.Login;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service(value = "loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    private BCryptPasswordEncoder bcryptEncoder =  new BCryptPasswordEncoder();

    @Override
    public List<Login> getAllLogins() {
        return loginRepository.findAll();
    }

    @Override
    public String registerNewLogin(LoginDTO loginDTO) throws WorkflixException {

        Optional<Login> isLoginAvailable = loginRepository.findById(loginDTO.getLoginId());

        if (isLoginAvailable.isPresent()) {
            throw new WorkflixException("LoginService.LOGIN_ID_ALREADY_IN_USE");
        } else {
            Login newlogin = new Login();
            newlogin.setLoginId(loginDTO.getLoginId());
            newlogin.setPassword(bcryptEncoder.encode(loginDTO.getPassword()));
            loginRepository.save(newlogin);
        }
        return loginDTO.getLoginId();
    }
}