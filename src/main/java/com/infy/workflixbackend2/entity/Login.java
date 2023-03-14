package com.infy.workflixbackend2.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name ="login")
public class Login {
    @Id
    @Column(name = "login_id")
    private String loginId;
    @Column(name="password")
    private String password;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "login_id")
//    private List<Profile> loginProfiles;

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

//    public List<Profile> getLoginProfiles() {
//        return loginProfiles;
//    }
//
//    public void setLoginProfiles(List<Profile> loginProfiles) {
//        this.loginProfiles = loginProfiles;
//    }
}