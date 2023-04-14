package com.infy.workflixbackend42.service;

import com.infy.workflixbackend42.dto.BlogDTO;
import com.infy.workflixbackend42.entity.Blog;
import com.infy.workflixbackend42.entity.Category;
import com.infy.workflixbackend42.exception.WorkflixException;
import com.infy.workflixbackend42.repository.CategoryRepository;
import com.infy.workflixbackend42.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service(value = "postService")
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public String createBlog(BlogDTO blogDTO) throws WorkflixException {
        Blog blog = mapFromDTOToBlog(blogDTO);
        blogRepository.save(blog);
        return blogDTO.getTitle()+" create successfully!";
    }


    public BlogDTO readSingleBlog(Long blogId) throws WorkflixException {
        Blog blog = blogRepository.findById(blogId).orElseThrow(
                () -> new WorkflixException("PostService.POST_NOT_FOUND"));
        return mapFromBlogToDTO(blog);
    }
    public List<BlogDTO> getBlogByCategoryId(Long categoryId) throws WorkflixException{
       Category category=categoryRepository.findById(categoryId).orElseThrow(
               ()->new WorkflixException("CategoryService.CATEGORY_NOT_FOUND")
       );
        List<Blog> blogList = blogRepository.findByCategoryId(categoryId);
        List<BlogDTO> blogDTOList =new ArrayList<>();
       for(Blog blog : blogList){
           blogDTOList.add(mapFromBlogToDTO(blog));
       }
       return blogDTOList;
    }

    public String updateBlog(Long blogId, String newTitle, String newContent)throws WorkflixException{
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new WorkflixException("BlogService.BLOG_NOT_FOUND"));
        blog.setTitle(newTitle);
        blog.setContent(newContent);
        return newTitle+" updated!";
    }
    public String deleteBlog(Long blogId)throws WorkflixException{
        Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new WorkflixException("BlogService.BLOG_NOT_FOUND"));
        blogRepository.delete(blog);
        return "delete successfully!";
    }

    public BlogDTO mapFromBlogToDTO(Blog blog) throws WorkflixException{
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setBlogId(blog.getBlogId());
        blogDTO.setCategoryId(blog.getCategoryId());
        blogDTO.setTitle(blog.getTitle());
        blogDTO.setContent(blog.getContent());
        return blogDTO;
    }

    public Blog mapFromDTOToBlog(BlogDTO blogDTO) throws WorkflixException{
        Blog blog = new Blog();
        blog.setTitle(blogDTO.getTitle());
        blog.setContent(blogDTO.getContent());
        blog.setCategoryId(blogDTO.getCategoryId());
        return blog;
    }
}