package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("blogs")
    public Page<Blog> findAll(Pageable pageable){
        return blogService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showFormCategory(@RequestParam("search")Optional<String> search, Pageable pageable){
        Page<Category> categories;
        if (search.isPresent()){
            categories = categoryService.findAllByCategoryName(search.get(), pageable);
        }else {
            categories = categoryService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/category/list");
        modelAndView.addObject("category", categories);
        return modelAndView;
    }

}
