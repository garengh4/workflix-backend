package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.CategoryDTO;
import com.infy.workflixbackend2.dto.PostDTO;
import com.infy.workflixbackend2.entity.Category;
import com.infy.workflixbackend2.entity.InputFile;
import com.infy.workflixbackend2.entity.Post;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.repository.CategoryRepository;
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
    @Autowired
    private PostService postService;

    public void createCategory(String categoryName,String profileId)throws WorkflixException {
        Category category=new Category();
        category.setCategoryName(categoryName);
        category.setProfileId(profileId);
        categoryRepository.save(category);
    }

    public List<CategoryDTO> getAll() throws WorkflixException {
        return categoryRepository.findAll()
                .stream()
                .map(this::mapFromCategoryToDTO)
                .collect(toList());
    }


    public CategoryDTO mapFromCategoryToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        List<Post> postList=category.getPosts();
        List<PostDTO> postDTOList=postList.stream().map(post->postService.mapFromPostToDTO(post)).collect(toList());
        categoryDTO.setPosts(postDTOList);
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setProfileId(category.getProfileId());
        return categoryDTO;
    }



}
