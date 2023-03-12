package com.infy.workflixbackend2.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ProfileDTO {

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9-_]{1,50}", message = "{invalid.user.profile.id.format}")
    private String userProfileId;

    @NotNull
    private String userFirstName;

    @NotNull
    private String userLastName;

    @NotNull
    private String emailId;

    public String getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(String userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

}