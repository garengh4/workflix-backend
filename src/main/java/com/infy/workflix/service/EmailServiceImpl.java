package com.infy.workflix.service;

import com.infy.workflix.dto.EmailDTO;
import com.infy.workflix.entity.Email;
import com.infy.workflix.dto.ProfileDTO;
import com.infy.workflix.exception.WorkflixException;
import com.infy.workflix.repository.EmailRepository;
import com.infy.workflix.repository.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service(value = "emailService")
@Transactional
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;
//    private ProfileRepository profileRepository;

    @Override
    public EmailDTO authenticateEmail (String emailId, String password) throws WorkflixException {
        EmailDTO emailDTO = null;

        Optional< Email> optionalEmail = emailRepository.findById(emailId.toLowerCase());
        Email email = optionalEmail.orElseThrow(() -> new WorkflixException("EmailService.USER_NOT_FOUND"));

        if(!password.equals(email.getPasswords())){
            throw new WorkflixException("EmailService.INVALID_CREDENTIALS");
        }

        emailDTO = new EmailDTO();
        emailDTO.setEmailId(email.getEmailId());
        emailDTO.setPassword(email.getPasswords());

        return emailDTO;
    }

    @Override
    public String registerNewEmail (EmailDTO emailDTO) throws WorkflixException {
        String registeredWithEmailId = null;

        boolean isEmailAvailable = emailRepository.findById(emailDTO.getEmailId().toLowerCase()).isEmpty();
        if(isEmailAvailable){
            Email email = new Email();
            email.setEmailId(emailDTO.getEmailId());
            email.setPasswords(emailDTO.getPassword());
            emailRepository.save(email);
            registeredWithEmailId = email.getEmailId();
        }else{
            throw new WorkflixException("EmailService.EMAIL_ID_ALREADY_IN_USE");
        }
        return registeredWithEmailId;
    }

    @Override
    public void changePassword(String emailId, String currentPassword, String newPassword) throws WorkflixException{

        Optional< Email> optionalEmail = emailRepository.findById(emailId.toLowerCase());
        Email email = optionalEmail.orElseThrow(() -> new WorkflixException("EmailService.USER_NOT_FOUND"));

        if(!currentPassword.equals(email.getPasswords())){
            throw new WorkflixException("EmailService.INVALID_CREDENTIALS");
        }
        if(currentPassword.equals(newPassword)){
            throw new WorkflixException("EmailService.SAME_PASSWORD");
        }
        email.setPasswords(newPassword);

    }

//    @Override
//    public Set<ProfileDTO> getProfileByEmailId (String emailId) throws WorkflixException{
//        Set<ProfileDTO> profileDTO = null;
////        Optional<Set<Profile>> optionalProfile = profileRepository.findByEmailId(emailId.toLowerCase());
////        Set<Profile> profile = optionalProfile.orElseThrow(() -> new WorkflixException("EmailService.PROFILE_NOT_FOUND"));
////        profileDTO = new ProfileDTO();
////        set profile dto variable from profile
//
//        return profileDTO;
//
//    }
}
