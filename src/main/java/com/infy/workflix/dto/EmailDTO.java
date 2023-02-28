package com.infy.workflix.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class EmailDTO {

    @NotNull(message = "{email.absent}")
    @Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z.]+",message = "{invalid.email.format}")
    private String emailId;

    @NotNull(message = "{password.absent}")
    @Pattern(regexp = ".*[A-Z]+.*", message = "{invalid.password.format.uppercase}")
    @Pattern(regexp = ".*[a-z]+.*", message = "{invalid.password.format.lowercase}")
    @Pattern(regexp = ".*[0-9]+.*", message = "{invalid.password.format.number}")
    @Pattern(regexp = ".*[^a-zA-Z0-9].*", message = "{invalid.password.format.specialcharacter}")
    private String password;
    private String newPassword;
    @Valid
    private Set<ProfileDTO> profiles;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public Set<ProfileDTO> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<ProfileDTO> profiles) {
        this.profiles = profiles;
    }
}
