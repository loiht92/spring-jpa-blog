package com.codegym.model;

import org.springframework.web.bind.annotation.PutMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category { // Chu de

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    public Category(){
    }

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

    //@OneToMany(targetEntity = Blog.class, mappedBy = "category", fetch = FetchType.EAGER) //
    //private List<Blog> blogs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Blog> getBlogs() {
//        return blogs;
//    }
//
//    public void setBlogs(List<Blog> blogs) {
//        this.blogs = blogs;
//    }
}