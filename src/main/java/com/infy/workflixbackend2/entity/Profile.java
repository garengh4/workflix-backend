package com.infy.workflixbackend2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_profile")
public class Profile {
    @Id
    private String userProfileId;
    private String userFirstName;
    private String userLastName;

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

