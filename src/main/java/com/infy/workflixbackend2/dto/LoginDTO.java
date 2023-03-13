package com.infy.workflixbackend2.dto;



import com.infy.workflixbackend2.entity.Profile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

public class LoginDTO {
    private String loginId;
    private String password;
    private List<ProfileDTO> loginProfilesDTO;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<ProfileDTO> getLoginProfilesDTO() {
        return loginProfilesDTO;
    }

    public void setLoginProfilesDTO(List<ProfileDTO> loginProfilesDTO) {
        this.loginProfilesDTO = loginProfilesDTO;
    }
}
