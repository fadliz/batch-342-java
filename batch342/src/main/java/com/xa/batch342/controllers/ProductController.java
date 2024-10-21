package com.xa.batch342.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.dtos.requests.ProductRequestDto;
import com.xa.batch342.entities.Category;
import com.xa.batch342.entities.Product;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.repositories.ProductRepository;
import com.xa.batch342.services.impl.ProductServiceImpl;
import com.xa.batch342.utils.SlugUtils;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("")
    public ModelAndView getProduct() {
        ModelAndView view = new ModelAndView("product/index");
        List<Category> categories = categoryRepository.findAll();
        List<Product> products = productRepository.findAll();
        view.addObject("category", categories);
        view.addObject("products", products);
        view.addObject("title", "Master Product");
        return view;
    }

    @PostMapping("")
    public String saveProduct(@RequestBody ProductRequestDto productRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        if (productRequestDto.getSlug() == null) {
            productRequestDto.setSlug(SlugUtils.toSlug(productRequestDto.getName()));
        }

        Product product = modelMapper.map(productRequestDto, Product.class);
        productService.createProduct(product);
        return "redirect:/product";
    }
}
