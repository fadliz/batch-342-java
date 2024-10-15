package com.xa.batch342.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.Category;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.utils.SlugUtils;


@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public ModelAndView getCategory() {
        ModelAndView view = new ModelAndView("category/index");
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        view.addObject("title", "Master Category");
        return view;
    }

    @PostMapping("")
    public String saveCategory(@ModelAttribute Category category) {
        category.setSlug(SlugUtils.toSlug(category.getName()));
        categoryRepository.save(category);
        return "redirect:/category";
    }
}
