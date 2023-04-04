package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.CategoryDTO;
import com.infy.workflixbackend2.entity.Category;
import com.infy.workflixbackend2.exception.WorkflixException;

import java.util.List;

public interface CategoryService {
    public void createCategory(String categoryName,String profileId) throws WorkflixException ;
    public List<CategoryDTO> getAll() throws WorkflixException ;
    public CategoryDTO mapFromCategoryToDTO(Category category);
}
