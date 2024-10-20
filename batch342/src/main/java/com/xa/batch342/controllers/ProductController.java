package com.xa.batch342.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.Product;
import com.xa.batch342.repositories.ProductRepository;
import com.xa.batch342.utils.SlugUtils;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("")
    public ModelAndView getProduct() {
        ModelAndView view = new ModelAndView("product/index");
        List<Product> products = productRepository.findAll();
        view.addObject("products", products);
        view.addObject("title", "Master Product");
        return view;
    }

    @PostMapping("")
    public String saveProduct(@ModelAttribute Product product) {
        product.setSlug(SlugUtils.toSlug(product.getName()));
        productRepository.save(product);
        return "redirect:/product";
    }
}
