package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    @Query("select b from Blog b order by b.bloggers desc")
    Page<Blog> findAll(Pageable pageable);

    //Them restful
    List<Blog> findAll();

    Iterable<Blog> findAllByCategory(Category category);

    Optional<Blog> findById(Long id);

    void save(Blog blog);

    void remove(Long id);

    @Query("select b from Blog b where b.bloggers like %:bloggers%")
    Page<Blog> findAllByBloggers(String bloggers, Pageable pageable);

    Page<Blog> findAllByOrderByNameDesc(Pageable pageable);

    Page<Blog> findAllByCategory(Category category, Pageable pageable);
}
