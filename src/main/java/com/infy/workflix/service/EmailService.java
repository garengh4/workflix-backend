package com.infy.workflix.service;

import com.infy.workflix.dto.EmailDTO;
import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.Set;


public interface EmailService {

    EmailDTO authenticateEmail(String emailId,String password) throws WorkflixException;
    String registerNewEmail(EmailDTO emailDTO) throws WorkflixException;
    void changePassword(String emailId, String currentPassword, String newPassword) throws WorkflixException;
//    Set<ProfileDTO> getProfileByEmailId (String emailId) throws WorkflixException;
}
