package com.infy.workflixbackend42.service;


import com.infy.workflixbackend42.dto.LoginDTO;
import com.infy.workflixbackend42.entity.Login;
import com.infy.workflixbackend42.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface LoginService {
    public LoginDTO authenticateLogin(String username, String password) throws WorkflixException;

    public List<Login> getAllLogins();

    public String registerNewLogin(LoginDTO loginDTO) throws WorkflixException;


}