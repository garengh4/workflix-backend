package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.LoginDTO;
import com.infy.workflixbackend2.exception.WorkflixException;

public interface LoginService {
    public LoginDTO authenticateLogin(String username, String password) throws WorkflixException;
    public String registerNewLogin(LoginDTO loginDTO) throws WorkflixException;
}
