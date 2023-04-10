package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    List<Category> findByProfileId(String profileId);

    Category findByCategoryNameAndProfileId(String categoryName, String profileId);
}
