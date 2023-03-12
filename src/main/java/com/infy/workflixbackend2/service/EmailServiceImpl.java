package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.EmailDTO;
import com.infy.workflixbackend2.entity.Email;
import com.infy.workflixbackend2.exception.GeneralException;
import com.infy.workflixbackend2.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service(value = "emailService")
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;
//    private ProfileRepository profileRepository;

    @Override
    public EmailDTO authenticateEmail (String emailId, String password) throws GeneralException {
        EmailDTO emailDTO = null;

        Optional<Email> optionalEmail = emailRepository.findById(emailId.toLowerCase());
        Email email = optionalEmail.orElseThrow(() -> new GeneralException("EmailService.USER_NOT_FOUND"));

        if(!password.equals(email.getPasswords())){
            throw new GeneralException("EmailService.INVALID_CREDENTIALS");
        }

        emailDTO = new EmailDTO();
        emailDTO.setEmailId(email.getEmailId());
        emailDTO.setPassword(email.getPasswords());

        return emailDTO;
    }

    @Override
    public String registerNewEmail (EmailDTO emailDTO) throws GeneralException {
        String registeredWithEmailId = null;

        boolean isEmailAvailable = emailRepository.findById(emailDTO.getEmailId().toLowerCase()).isEmpty();
        if(isEmailAvailable){
            Email email = new Email();
            email.setEmailId(emailDTO.getEmailId());
            email.setPasswords(emailDTO.getPassword());
            emailRepository.save(email);
            registeredWithEmailId = email.getEmailId();
        }else{
            throw new GeneralException("EmailService.EMAIL_ID_ALREADY_IN_USE");
        }
        return registeredWithEmailId;
    }

    @Override
    public void changePassword(String emailId, String currentPassword, String newPassword) throws GeneralException{

        Optional< Email> optionalEmail = emailRepository.findById(emailId.toLowerCase());
        Email email = optionalEmail.orElseThrow(() -> new GeneralException("EmailService.USER_NOT_FOUND"));

        if(!currentPassword.equals(email.getPasswords())){
            throw new GeneralException("EmailService.INVALID_CREDENTIALS");
        }
        if(currentPassword.equals(newPassword)){
            throw new GeneralException("EmailService.SAME_PASSWORD");
        }
        email.setPasswords(newPassword);

    }


}