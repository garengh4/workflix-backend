package com.infy.workflixbackend42.dto;



import java.util.List;

public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
    private List<PostDTO> posts;
    private String profileId;
    public Long getCategoryId(){return categoryId;}

    public void setCategoryId(Long categoryId) { this.categoryId=categoryId;}

    public  void setPosts(List<PostDTO> posts) {this.posts=posts;}

    public void setProfileId(String profileId) {this.profileId=profileId;}

    public void setCategoryName(String categoryName) {this.categoryName=categoryName;}

    public String getCategoryName() {return categoryName;}

    public String getProfileId() {return profileId;}
}
