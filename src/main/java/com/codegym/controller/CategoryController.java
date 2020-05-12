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
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @ModelAttribute("blog")
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

    @GetMapping("/create")
    public ModelAndView showCreateFormCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createCategory(@ModelAttribute("category") Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("message", "create category successfully !");
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditFormCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/edit");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        }
        else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("category") Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("category", "edit category successfully !");
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteFormCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/delete");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error");
        }
    }

    @PostMapping("/delete")
    public String deleteCategory(@ModelAttribute("category") Category category, RedirectAttributes redirect){
        categoryService.remove(category.getId());
        redirect.addFlashAttribute("message", "delete category successfully !");
        return "redirect:/category";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCategory(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/view");
            modelAndView.addObject("category", category.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error");
        }
    }
}
















