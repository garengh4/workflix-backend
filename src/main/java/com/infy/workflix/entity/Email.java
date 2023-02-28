package com.infy.workflix.entity;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name ="email")
public class Email {
    @Id
    private String emailId;

    private String passwords;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "emailId")
    private Set<Profile> profiles;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public Set<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<Profile> profiles) {
        this.profiles = profiles;
    }
}
