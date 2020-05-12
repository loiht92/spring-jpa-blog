package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryAPIController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/api/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
        }

    }
}
