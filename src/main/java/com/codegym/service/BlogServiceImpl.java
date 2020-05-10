package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;

public class BlogServiceImpl implements BlogService{
    @Autowired
    BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByBloggers(String loggers, Pageable pageable) {
        return blogRepository.findAllByBloggers(loggers, pageable);
    }

    @Override
    public Page<Blog> findAllByCategory(Category category, Pageable pageable) {
        return blogRepository.findAllByCategory(category, pageable);
    }
}