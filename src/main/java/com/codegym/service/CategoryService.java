package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    @Query("select c from Category c where c.name like %:name%")
    Page<Category> findAllByCategoryName(String name, Pageable pageable);

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
}
