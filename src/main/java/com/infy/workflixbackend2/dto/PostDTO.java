package com.infy.workflixbackend2.dto;

import javax.persistence.Column;
import java.time.Instant;

public class PostDTO {
    private Long postId;
    private String content;
    private String title;
    private Instant createdOn;
    private Instant updatedOn;
    private Long categoryId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
    public Instant getCreatedOn() {
        return createdOn;
    }
    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }


    public void setCategoryId(Long categoryId) {this.categoryId=categoryId;
    }

    public Long getCategoryId() {return categoryId;}


}
