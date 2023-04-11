package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.CategoryDTO;
import com.infy.workflixbackend42.dto.PostDTO;
import com.infy.workflixbackend42.entity.Category;
import com.infy.workflixbackend42.entity.InputFile;
import com.infy.workflixbackend42.entity.Post;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service(value ="categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(CategoryDTO categoryDTO)throws WorkflixException {
       Optional<Category> categoryOptional= Optional.ofNullable(categoryRepository.
               findByCategoryNameAndProfileId(categoryDTO.getCategoryName(),categoryDTO.getProfileId()));
       if(categoryOptional.isPresent()){
           throw new WorkflixException("CategoryService.CATEGORY_NAME_ALREADY_IN_USE");
       }
        Category category=this.mapFromDTOToCategory(categoryDTO);
        categoryRepository.save(category);
    }


    public List<CategoryDTO> getCategoryByProfileId(String profileId) throws WorkflixException{
       List<Category> categoryList= categoryRepository.findByProfileId(profileId);
       if(categoryList.isEmpty()){
           throw new WorkflixException("CategoryService.CATEGORY_NOT_FOUND");
       }
       return categoryList.stream().map(this::mapFromCategoryToDTO).collect(toList());
    }


    public CategoryDTO mapFromCategoryToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setProfileId(category.getProfileId());
        categoryDTO.setCategoryId(category.getCategoryId());
        return categoryDTO;
    }
    public Category mapFromDTOToCategory(CategoryDTO categoryDTO){
        Category category=new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setProfileId(categoryDTO.getProfileId());
        return category;
    }



}
