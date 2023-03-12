package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.EmailDTO;
import com.infy.workflixbackend2.exception.GeneralException;

public interface EmailService {
    public EmailDTO authenticateEmail(String emailId, String password) throws GeneralException;
    public String registerNewEmail(EmailDTO emailDTO) throws GeneralException;
    public void changePassword(String emailId, String currentPassword, String newPassword) throws GeneralException;
}
