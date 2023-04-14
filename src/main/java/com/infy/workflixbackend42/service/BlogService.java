package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.BlogDTO;
import com.infy.workflixbackend42.entity.Blog;
import com.infy.workflixbackend42.exception.WorkflixException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BlogService {

    public String createBlog(BlogDTO blogDTO) throws WorkflixException ;
    public BlogDTO readSingleBlog(Long id) throws WorkflixException;
    public String updateBlog(Long blogId, String newTitle, String newContent)throws WorkflixException;
    public String deleteBlog(Long blogId)throws WorkflixException;
    public BlogDTO mapFromBlogToDTO(Blog blog) throws WorkflixException;
    public Blog mapFromDTOToBlog(BlogDTO blogDTO) throws WorkflixException;

    List<BlogDTO> getBlogByCategoryId(Long categoryId) throws WorkflixException;
}
