package com.infy.workflixbackend42.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "category_name")
    private String categoryName;

    @Column(name="profile_id")
    private String profileId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Post> posts;

    public Long getCategoryId() {return categoryId;}

    public void setCategoryId(Long categoryId) {this.categoryId = categoryId;}
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String  categoryName) {
        this.categoryName =  categoryName;
    }
    public String getProfileId() {return profileId;}

    public void setProfileId(String profileId) {this.profileId = profileId;}


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }






}