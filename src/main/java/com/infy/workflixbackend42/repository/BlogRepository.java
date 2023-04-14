package com.infy.workflixbackend42.repository;

import com.infy.workflixbackend42.entity.Blog;
import com.infy.workflixbackend42.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    List<Blog> findByCategoryId(Long categoryId);
}
