package com.infy.workflix.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name = "user_profile")
public class Profile {

    @Id
    private String userProfileId;
    private String userFirstName;
    private String userLastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name ="user_profile_id")
    private Set<File> files;

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

    public Set<File> getFiles() {
        return files;
    }

    public void setFiles(Set<File> files) {
        this.files = files;
    }
}
