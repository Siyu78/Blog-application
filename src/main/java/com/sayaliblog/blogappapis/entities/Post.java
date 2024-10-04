package com.sayaliblog.blogappapis.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Post
{
    @Id
    private Long post_id;
    private String title;
    private String content;
    private String image;

}
