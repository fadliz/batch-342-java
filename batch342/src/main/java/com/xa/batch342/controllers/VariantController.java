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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.Category;
import com.xa.batch342.entities.Product;
import com.xa.batch342.entities.Variant;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.repositories.ProductRepository;
import com.xa.batch342.repositories.VariantRepository;
import com.xa.batch342.utils.SlugUtils;

@Controller
@RequestMapping("/variant")
public class VariantController {

    // @Autowired
    // VariantServiceImpl variantService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    VariantRepository variantRepository;
    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public ModelAndView getProduct() {
        ModelAndView view = new ModelAndView("variant/index");
        List<Variant> variants = variantRepository.findAll();
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        view.addObject("variants", variants);
        view.addObject("products", products);
        view.addObject("categories", categories);
        view.addObject("title", "Master Variant");
        return view;
    }

    @GetMapping("/products/{categoryId}")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @GetMapping("/form")
    public ModelAndView form() {
        ModelAndView view = new ModelAndView("variant/form");
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        view.addObject("products", products);
        view.addObject("variant", new Variant());
        return view;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Variant variant, BindingResult result) {
        if (!result.hasErrors()) {
            variant.setSlug(SlugUtils.toSlug(variant.getName()));
            variantRepository.save(variant);
        }
        return new ModelAndView("redirect:/variant");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView view = new ModelAndView("variant/form");
        Variant variant = variantRepository.findById(id).orElse(null);
        List<Product> products = productRepository.findAll();
        List<Category> categories = categoryRepository.findAll();
        view.addObject("categories", categories);
        view.addObject("products", products);
        view.addObject("variant", variant);
        return view;
    }

    @GetMapping("/deleteForm/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id) {
        ModelAndView view = new ModelAndView("variant/deleteForm");
        Variant variant = variantRepository.findById(id).orElse(null);
        view.addObject("variant", variant);
        return view;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable("id") Long id) {
        variantRepository.deleteById(id);
        return new ModelAndView("redirect:/variant");
    }
}