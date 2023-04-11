package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.PostDTO;
import com.infy.workflixbackend42.entity.Post;
import com.infy.workflixbackend42.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostService {

    public void createPost(PostDTO postDTO) throws WorkflixException ;
    public PostDTO readSinglePost(Long id) throws WorkflixException;
    public String updatePost(Long postId,String newTitle,String newContent)throws WorkflixException;
    public String deletePost(Long postId)throws WorkflixException;
    public PostDTO mapFromPostToDTO(Post post) throws WorkflixException;
    public Post mapFromDTOToPost(PostDTO postDTO) throws WorkflixException;

    List<PostDTO> getPostByCategoryId(Long categoryId) throws WorkflixException;
}
