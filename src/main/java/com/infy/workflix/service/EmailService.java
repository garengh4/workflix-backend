package com.infy.workflix.service;

import com.infy.workflix.dto.EmailDTO;
import com.infy.workflix.exception.WorkflixException;


public interface EmailService {

    public EmailDTO authenticateEmail(String emailId,String password) throws WorkflixException;
    public String registerNewEmail(EmailDTO emailDTO) throws WorkflixException;
    public void changePassword(String emailId, String currentPassword, String newPassword) throws WorkflixException;
//    Set<ProfileDTO> getProfileByEmailId (String emailId) throws WorkflixException;
}
