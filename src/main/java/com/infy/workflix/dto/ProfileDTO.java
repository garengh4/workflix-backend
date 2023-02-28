package com.infy.workflix.dto;

import com.infy.workflix.entity.File;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class ProfileDTO {

    @NotNull
    @Pattern(regexp = "[A-Za-z0-9-_]{1,50}", message = "{invalid.user.profile.id.format}")
    private String userProfileId;

    @NotNull
    private String userFirstName;

    @NotNull
    private String userLastName;

    @Valid
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
