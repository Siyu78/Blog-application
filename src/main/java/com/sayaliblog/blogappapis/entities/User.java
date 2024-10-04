package com.sayaliblog.blogappapis.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name="user")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
   private Integer id;
    @Column(name="user_name",nullable=false,length = 100)
   private String name;
    @Column
   private String email;
    @Column
   private String password;
    @Column
   private String about;
}
