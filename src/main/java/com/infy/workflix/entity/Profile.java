package com.infy.workflix.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user_profile")
public class Profile {
    @Id
    private String userProfileId;
    private String userFirstName;
    private String userLastName;

    private String emailId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="userProfileId")
    private Set<InputFile> files;

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

    public Set<InputFile> getFiles() {
        return files;
    }

    public void setFiles(Set<InputFile> files) {
        this.files = files;
    }
}
