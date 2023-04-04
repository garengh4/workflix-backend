package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.PostDTO;
import com.infy.workflixbackend2.entity.Post;
import com.infy.workflixbackend2.entity.Profile;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service(value = "postService")
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    public List<PostDTO> showAllPosts() throws WorkflixException {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDTO).collect(toList());
    }

    public void createPost(PostDTO postDTO) throws WorkflixException {
        Post post = mapFromDTOToPost(postDTO);
        postRepository.save(post);
    }


    public PostDTO readSinglePost(Long postId) throws WorkflixException {
        Post post = postRepository.findById(postId).orElseThrow(() -> new WorkflixException("PostService.POST_NOT_FOUND"));
        return mapFromPostToDTO(post);
    }

    public String updatePost(Long postId,String newTitle,String newContent)throws WorkflixException{
        Post post = postRepository.findById(postId).orElseThrow(() -> new WorkflixException("PostService.POST_NOT_FOUND"));
        post.setTitle(newTitle);
        post.setContent(newContent);
        post.setUpdatedOn(Instant.now());
        return newTitle+" updated!";
    }
    public String deletePost(Long postId)throws WorkflixException{
        Post post = postRepository.findById(postId).orElseThrow(() -> new WorkflixException("PostService.POST_NOT_FOUND"));
        postRepository.delete(post);
        return "delete successfully!";
    }

    public PostDTO mapFromPostToDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(post.getPostId());
        postDTO.setCategoryId(post.getCategoryId());
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        postDTO.setCreatedOn(post.getCreatedOn());
        postDTO.setUpdatedOn(post.getUpdatedOn());
        return postDTO;
    }

    public Post mapFromDTOToPost(PostDTO postDTO){
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setCreatedOn(Instant.now());
        post.setUpdatedOn(Instant.now());
        post.setCategoryId(postDTO.getCategoryId());
        return post;
    }
}