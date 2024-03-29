package com.infy.workflixbackend42.api;

import com.infy.workflixbackend42.dto.PostDTO;
import com.infy.workflixbackend42.entity.Category;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/post-api")
@RestController
@Validated
public class PostAPI {

    @Autowired
    private PostService postService;

    @PostMapping(value= "/create")
    public ResponseEntity createPost(@RequestBody PostDTO postDTO) throws WorkflixException {
        postService.createPost(postDTO);
        return new ResponseEntity(HttpStatus.OK);
    }


    @GetMapping(value="/post/Id/{postId}")
    public ResponseEntity<PostDTO> getSinglePost(@PathVariable Long postId)throws WorkflixException {
        PostDTO postDTO=postService.readSinglePost(postId);
        return new ResponseEntity<>(postDTO,HttpStatus.OK);
    }
    @GetMapping(value="/post/category/{categoryId}")
    public ResponseEntity<List<PostDTO>> getPostByCategoryId(@PathVariable Long categoryId)throws WorkflixException {
        List<PostDTO> postDTOList=postService.getPostByCategoryId(categoryId);
        return new ResponseEntity<>(postDTOList,HttpStatus.OK);
    }
    @PutMapping(value="/post/update/{postId}")
    public ResponseEntity<String> updatePost (@PathVariable Long postId,@RequestParam("newTitle") String newTitle,
                                              @RequestParam("newContent") String newContent)throws WorkflixException{
        String msg= postService.updatePost(postId,newTitle,newContent);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
    @DeleteMapping(value = "/post/delete/{postId}/")
        public ResponseEntity<String> deletePost (@PathVariable Long postId) throws WorkflixException {
            String msg = postService.deletePost(postId);
            return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
