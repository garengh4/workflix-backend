package com.infy.workflixbackend2.repository;

import com.infy.workflixbackend2.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
