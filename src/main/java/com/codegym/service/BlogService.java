package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    @Query("select b from Blog b where b.bloggers like %:bloggers%")
    Page<Blog> findAllByBloggers(String bloggers, Pageable pageable);

    Page<Blog> findAllByCategory(Category category, Pageable pageable);
}
