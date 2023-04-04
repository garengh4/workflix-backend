package com.infy.workflixbackend2.security;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AuthRequest {
    @NotNull @Email @Length(min = 5, max = 50)
    private String loginId;

    @NotNull @Length(min = 6, max = 20)
    private String password;

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
}