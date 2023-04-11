package com.infy.workflixbackend42.entity;



import javax.persistence.*;

@Entity
@Table(name = "files")
public class InputFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long fileId;
    private String fileName;

    private String profileId;
    private String descriptions;
    private String categoryName;
    private String fileUrl;
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