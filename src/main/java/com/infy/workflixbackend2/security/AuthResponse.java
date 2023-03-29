package com.infy.workflixbackend2.security;

public class AuthResponse {
    private String loginId;
    private String accessToken;

    public AuthResponse() { }

    public AuthResponse(String email, String accessToken) {
        this.loginId = email;
        this.accessToken = accessToken;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
