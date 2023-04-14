package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.CategoryDTO;
import com.infy.workflixbackend42.entity.Category;
import com.infy.workflixbackend42.exception.WorkflixException;

import java.util.List;

public interface CategoryService {
    public String createCategory(CategoryDTO categoryDTO) throws WorkflixException ;

    public List<CategoryDTO> getCategoryByProfileId(String profileId) throws WorkflixException;
    public CategoryDTO mapFromCategoryToDTO(Category category);
    public Category mapFromDTOToCategory(CategoryDTO categoryDTO);
}
