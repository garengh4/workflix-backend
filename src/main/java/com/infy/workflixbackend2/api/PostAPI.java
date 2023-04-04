package com.infy.workflixbackend2.api;

import com.infy.workflixbackend2.dto.PostDTO;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.service.PostService;
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

    @GetMapping(value="post/all")
    public ResponseEntity<List<PostDTO>> showAllPosts() throws WorkflixException {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping(value="post/Id/{postId}/")
    public ResponseEntity<PostDTO> getSinglePost(@PathVariable Long postId)throws WorkflixException {
        return new ResponseEntity<>(postService.readSinglePost(postId), HttpStatus.OK);
    }
    @PutMapping(value="post/update/{postId}")
    public ResponseEntity<String> updatePost (@PathVariable Long postId,@RequestParam("newTitle") String newTitle,
                                              @RequestParam("newContent") String newContent)throws WorkflixException{
        String msg= postService.updatePost(postId,newTitle,newContent);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
    @DeleteMapping(value = "post/delete/{postId}/")
        public ResponseEntity<String> deletePost (@PathVariable Long postId) throws WorkflixException {
            String msg = postService.deletePost(postId);
            return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}
