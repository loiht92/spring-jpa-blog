package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogAPIController {
    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/api/blogs", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> findAllByBlog() {
        List<Blog> blogs = blogService.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/api/blogs/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> viewBlog(@PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
        if (!blog.isPresent()){
            return new ResponseEntity<Blog>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<Blog>(blog.get(),HttpStatus.OK);
        }
    }

}
