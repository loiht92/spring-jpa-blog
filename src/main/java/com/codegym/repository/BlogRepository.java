package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BlogRepository extends PagingAndSortingRepository<Blog, Long> {

    Page<Blog> findAllByBloggers(String loggers, Pageable pageable);

    Page<Blog> findAllByCategory(Category category, Pageable pageable);

}
