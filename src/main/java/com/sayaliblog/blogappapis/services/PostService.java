package com.sayaliblog.blogappapis.services;

import com.sayaliblog.blogappapis.entities.Post;
import com.sayaliblog.blogappapis.payloads.PostDto;

import java.util.List;

public interface PostService {
    //create post
    PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
//    PostDto updatePost(PostDto postDto,Integer postid);
    void deletePost(Integer postid);
    List<Post> getPostsByCategory(Integer categoryid);
    PostDto getPostById(Integer postid);
    List<Post> getAllPosts();
    List<Post> getPostsByUser(Integer userId);
    List<Post> searchPosts(String keyword);

}
