package com.infy.workflixbackend2.service;

import com.infy.workflixbackend2.dto.CategoryDTO;
import com.infy.workflixbackend2.dto.PostDTO;
import com.infy.workflixbackend2.entity.Category;
import com.infy.workflixbackend2.entity.Post;
import com.infy.workflixbackend2.entity.Profile;
import com.infy.workflixbackend2.exception.WorkflixException;
import com.infy.workflixbackend2.repository.CategoryRepository;
import com.infy.workflixbackend2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service(value = "postService")
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public void createPost(PostDTO postDTO) throws WorkflixException {
        Post post = mapFromDTOToPost(postDTO);
        postRepository.save(post);
    }


    public PostDTO readSinglePost(Long postId) throws WorkflixException {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new WorkflixException("PostService.POST_NOT_FOUND"));
        return mapFromPostToDTO(post);
    }
    public List<PostDTO> getPostByCategoryId(Long categoryId) throws WorkflixException{
       Category category=categoryRepository.findById(categoryId).orElseThrow(
               ()->new WorkflixException("CategoryService.CATEGORY_NOT_FOUND")
       );
        List<Post> postList= postRepository.findByCategoryId(category);
        List<PostDTO> postDTOList=new ArrayList<>();
       for(Post post:postList){
           postDTOList.add(mapFromPostToDTO(post));
       }
       return postDTOList;
    }

    public String updatePost(Long postId,String newTitle,String newContent)throws WorkflixException{
        Post post = postRepository.findById(postId).orElseThrow(() -> new WorkflixException("PostService.POST_NOT_FOUND"));
        post.setTitle(newTitle);
        post.setContent(newContent);
        return newTitle+" updated!";
    }
    public String deletePost(Long postId)throws WorkflixException{
        Post post = postRepository.findById(postId).orElseThrow(() -> new WorkflixException("PostService.POST_NOT_FOUND"));
        postRepository.delete(post);
        return "delete successfully!";
    }

    public PostDTO mapFromPostToDTO(Post post) throws WorkflixException{
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(post.getPostId());
        CategoryDTO categoryDTO=new CategoryDTO();
        Category category= categoryRepository.findById(post.getCategoryId().getCategoryId()).orElseThrow(
                ()->new WorkflixException("CategoryService.CATEGORY_NOT_FOUND")
        );
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setCategoryName(category.getCategoryName());
        categoryDTO.setProfileId(category.getProfileId());
        postDTO.setCategoryId(categoryDTO);
        postDTO.setTitle(post.getTitle());
        postDTO.setContent(post.getContent());
        return postDTO;
    }

    public Post mapFromDTOToPost(PostDTO postDTO) throws WorkflixException{
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        CategoryDTO categoryDTO=postDTO.getCategoryDTO();
        Category category= categoryRepository.findById(categoryDTO.getCategoryId()).orElseThrow(
                ()->new WorkflixException("CategoryService.CATEGORY_NOT_FOUND")
        );
        post.setCategoryId(category);
        return post;
    }
}