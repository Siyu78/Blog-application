package com.sayaliblog.blogappapis.controllers;

import com.sayaliblog.blogappapis.payloads.PostDto;
import com.sayaliblog.blogappapis.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Post")
public class PostController {
    @Autowired
    private PostService postService;
    //create
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@PathVariable int userId, @PathVariable int categoryId, @RequestBody PostDto postDto) {
        PostDto createPost= postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

}
