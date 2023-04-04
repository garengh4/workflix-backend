package com.infy.workflixbackend2.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;
    @Column(name = "category_name")
    private String categoryName;

    @Column(name="profile_id")
    private String profileId;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private List<Post> posts;

    public Long getCategory_id() {return category_id;}

    public void setCategory_id(Long category_id) {this.category_id = category_id;}
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
