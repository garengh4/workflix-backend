package com.infy.workflix.dto;

import javax.validation.constraints.NotNull;

public class FileDTO {

    private long fileId;

    @NotNull (message = "{file.name.absent}")
    private String fileName;

    @NotNull (message = "{file.owner.absent}")
    private String userProfileId;

    private String descriptions;

    @NotNull (message ="{file.category.name.absent")
    private String categoryName;

    @NotNull (message = "{file.data.absent}")
    private byte[] fileData;

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

    public String getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(String userProfileId) {
        this.userProfileId = userProfileId;
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

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }
}
