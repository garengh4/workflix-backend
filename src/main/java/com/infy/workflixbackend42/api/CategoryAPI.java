package com.infy.workflixbackend42.api;

import com.infy.workflixbackend42.dto.CategoryDTO;
import com.infy.workflixbackend42.dto.FileDTO;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.service.CategoryService;
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
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) throws WorkflixException {
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value="/category/{profileId}")
    public ResponseEntity<List<CategoryDTO>> getCategoryByProfileId(@PathVariable String profileId) throws WorkflixException {
        List<CategoryDTO> categoryDTOList = categoryService.getCategoryByProfileId(profileId);
        return new ResponseEntity<>(categoryDTOList,HttpStatus.OK);
    }


}
