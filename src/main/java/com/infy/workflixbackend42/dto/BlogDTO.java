package com.infy.workflixbackend42.dto;

public class BlogDTO {
    private Long blogId;
    private String content;
    private String title;
    private Long categoryId;

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setCategoryId(Long categoryId) {this.categoryId=categoryId;}

    public Long getCategoryId() {return categoryId;}


}
