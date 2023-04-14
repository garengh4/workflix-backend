package com.infy.workflixbackend42.api;

import com.infy.workflixbackend42.dto.BlogDTO;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/blog-api")
@RestController
@Validated
public class BlogAPI {

    @Autowired
    private BlogService blogService;

    @PostMapping(value= "/create")
    public ResponseEntity<String> createBlog(@RequestBody BlogDTO blogDTO) throws WorkflixException {
       String msg= blogService.createBlog(blogDTO);
        return new ResponseEntity(msg,HttpStatus.OK);
    }


    @GetMapping(value="/blog/Id/{blogId}")
    public ResponseEntity<BlogDTO> getSinglePost(@PathVariable Long blogId)throws WorkflixException {
        BlogDTO blogDTO = blogService.readSingleBlog(blogId);
        return new ResponseEntity<>(blogDTO,HttpStatus.OK);
    }
    @GetMapping(value="/blog/category/{categoryId}")
    public ResponseEntity<List<BlogDTO>> getPostByCategoryId(@PathVariable Long categoryId)throws WorkflixException {
        List<BlogDTO> blogDTOList = blogService.getBlogByCategoryId(categoryId);
        return new ResponseEntity<>(blogDTOList,HttpStatus.OK);
    }
    @PutMapping(value="/blog/update/{blogId}")
    public ResponseEntity<String> updatePost (@PathVariable Long blogId,@RequestParam("newTitle") String newTitle,
                                              @RequestParam("newContent") String newContent)throws WorkflixException{
        String msg= blogService.updateBlog(blogId,newTitle,newContent);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
    @DeleteMapping(value = "/blog/delete/{blogId}")
        public ResponseEntity<String> deletePost (@PathVariable Long blogId) throws WorkflixException {
            String msg = blogService.deleteBlog(blogId);
            return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
