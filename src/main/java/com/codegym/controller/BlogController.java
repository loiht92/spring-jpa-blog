package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.BlogService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Page<Category> findAll(Pageable pageable){
        return categoryService.findAll(pageable);
    }

    @GetMapping
    public ModelAndView showFormBlog(@RequestParam("search")Optional<String> search, Pageable pageable){
        Page<Blog> blogs;
        if (search.isPresent()){
            blogs = blogService.findAllByBloggers(search.get(), pageable);
        }else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreateBlog(){
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("message","create blog successfully !");
        return "redirect:/blog";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditFormBlog(@PathVariable Long id){
        Optional<Blog> blog = blogService.findById(id);
        if (blog.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());
            return modelAndView;
        }
        else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit")
    public String editBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("message", "edit blog successfully !");
        return "redirect:/blog";
    }

}
