package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.LoginDTO;
import com.infy.workflixbackend2.entity.Login;
import com.infy.workflixbackend2.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LoginService {
    public LoginDTO authenticateLogin(String username, String password) throws WorkflixException;

    public List<Login> getAllLogins();

    public String registerNewLogin(LoginDTO loginDTO) throws WorkflixException;


}
