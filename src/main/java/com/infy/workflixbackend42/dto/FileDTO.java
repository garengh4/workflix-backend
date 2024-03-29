package com.infy.workflixbackend42.dto;

import javax.validation.constraints.NotNull;


public class FileDTO {
    private long fileId;
    @NotNull(message = "{file.name.absent}")
    private String fileName;
    @NotNull(message = "{file.owner.absent}")
    private String profileId;
    private String descriptions;
    @NotNull(message = "{file.category.name.absent")
    private String categoryName;
    private String fileUrl;
    public FileDTO(String fileName, String fileUrl) {
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }


    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
