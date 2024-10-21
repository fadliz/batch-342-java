package com.xa.batch342.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.Category;
import com.xa.batch342.entities.Product;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.repositories.ProductRepository;
import com.xa.batch342.utils.SlugUtils;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    
    @GetMapping("")
    public ModelAndView getProduct() {
        ModelAndView view = new ModelAndView("product/index");
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        view.addObject("products", products);
        view.addObject("categories", categories);
        view.addObject("title", "Master Product");
        return view;
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("product/form");
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        view.addObject("product", new Product());
        return view;
    }
    
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Product product, BindingResult result) {
        if (!result.hasErrors()) {
            product.setSlug(SlugUtils.toSlug(product.getName()));
            productRepository.save(product);
        }
        return new ModelAndView("redirect:/product");
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("product/form");
        Product product = productRepository.findById(id).orElse(null);
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        view.addObject("product", product);
        return view;
    }
    
    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("product/deleteForm");
        Product product = productRepository.findById(id).orElse(null);
        view.addObject("product", product);
        return view;
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") Long id) {
        productRepository.deleteById(id);
        return new ModelAndView("redirect:/product");
    }
    
}
