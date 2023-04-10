package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.Category;
import com.infy.workflixbackend2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByCategoryId(Category categoryId);
}
