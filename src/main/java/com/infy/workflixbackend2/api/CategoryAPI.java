package com.infy.workflixbackend2.api;

import com.infy.workflixbackend2.dto.CategoryDTO;
import com.infy.workflixbackend2.dto.FileDTO;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/category-api")
@RestController
@Validated
public class CategoryAPI {
    @Autowired
    private CategoryService categoryService;

    @PostMapping(value= "/create")
    public ResponseEntity<CategoryDTO> createCategory(@RequestParam String categoryName,@RequestParam String profileId) throws WorkflixException {
        categoryService.createCategory(categoryName,profileId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value="/category")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() throws WorkflixException {
        List<CategoryDTO> categoryDTOList = categoryService.getAll();
        return new ResponseEntity<>(categoryDTOList,HttpStatus.OK);
    }



}
