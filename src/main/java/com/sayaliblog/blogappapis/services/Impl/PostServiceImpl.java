package com.sayaliblog.blogappapis.services.Impl;

import com.sayaliblog.blogappapis.entities.Category;
import com.sayaliblog.blogappapis.entities.Post;
import com.sayaliblog.blogappapis.entities.User;
import com.sayaliblog.blogappapis.exceptions.ResourceNotFoundException;
import com.sayaliblog.blogappapis.payloads.CategoryDto;
import com.sayaliblog.blogappapis.payloads.PostDto;
import com.sayaliblog.blogappapis.repositories.CategoryRepo;
import com.sayaliblog.blogappapis.repositories.PostRepo;
import com.sayaliblog.blogappapis.repositories.UserRepo;
import com.sayaliblog.blogappapis.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepo postrepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
        Category category=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
        Post post =this.modelMapper.map(postDto, Post.class);
        post.setImage("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);
        Post addPost=this.postrepo.save(post);
        //this.modelMapper.map(addPost, PostDto.class);
        return this.modelMapper.map(addPost, PostDto.class);
    }

    @Override
    public void deletePost(Integer postid) {
        Post post1 =this.postrepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("Post","postid",postid));
        this.postrepo.delete(post1);
    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryid) {
        return List.of();
    }

    @Override
    public PostDto getPostById(Integer postid) {
        Post post1 = this.postrepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("Post","postid",postid));
        return this.modelMapper.map(post1, PostDto.class);
    }

    @Override
    public List<Post> getAllPosts() {

        List<Post> post1 = this.postrepo.findAll();
        List<PostDto> postDtos= post1.stream().map((cate)->this.modelMapper.map(cate, PostDto.class)).collect(Collectors.toList());
       // List<CategoryDto> categoryDtos= category.stream().map((cate)->this.modelMapper.map(cate,CategoryDto.class)).collect(Collectors.toList());
        return post1;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return List.of();
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return List.of();
    }
}
