package com.infy.workflixbackend2.dto;

import javax.persistence.Column;
import java.time.Instant;

public class PostDTO {
    private Long postId;
    private String content;
    private String title;
    private CategoryDTO categoryDTO;

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
    public void setCategoryId(CategoryDTO categoryDTO) {this.categoryDTO=categoryDTO;}

    public CategoryDTO getCategoryDTO() {return categoryDTO;}


}
