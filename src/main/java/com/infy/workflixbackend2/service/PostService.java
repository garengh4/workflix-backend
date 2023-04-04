package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.PostDTO;
import com.infy.workflixbackend2.entity.Post;
import com.infy.workflixbackend2.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PostService {
    public List<PostDTO> showAllPosts() throws WorkflixException ;
    public void createPost(PostDTO postDTO) throws WorkflixException ;
    public PostDTO readSinglePost(Long id) throws WorkflixException;
    public String updatePost(Long postId,String newTitle,String newContent)throws WorkflixException;
    public String deletePost(Long postId)throws WorkflixException;
    public PostDTO mapFromPostToDTO(Post post);
    public Post mapFromDTOToPost(PostDTO postDTO);

}
