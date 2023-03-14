package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.LoginDTO;
import com.infy.workflixbackend2.entity.Login;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service(value = "loginService")
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public LoginDTO authenticateLogin (String username, String password) throws WorkflixException {
        Login loginEntry = loginRepository.findById(username).orElseThrow(
                () -> new WorkflixException("LoginService.USER_NOT_FOUND")
        );
        if (!password.equals(loginEntry.getPassword())) {
            throw new WorkflixException("LoginService.INVALID_CREDENTIALS");        }

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setLoginId(username);
        loginDTO.setPassword(password);
//        List<ProfileDTO> profileDTOList = loginEntry.getLoginProfiles().stream().map(e -> {
//            ProfileDTO profileDTO = new ProfileDTO();
//            profileDTO.setProfileId(e.getProfileId());
//            profileDTO.setLoginId(e.getLoginId()); //check
//            profileDTO.setFirstName(e.getFirstName());
//            profileDTO.setLastName(e.getLastName());
//            return profileDTO;
//        }).collect(Collectors.toList());
//        loginDTO.setLoginProfilesDTO(profileDTOList);

        return loginDTO;
    }

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
            newlogin.setPassword(loginDTO.getPassword());
            loginRepository.save(newlogin);
        }
        return loginDTO.getLoginId();
    }
}