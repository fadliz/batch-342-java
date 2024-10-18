package com.xa.batch342.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.batch342.dtos.requests.ProductRequestDto;
import com.xa.batch342.entities.Product;
import com.xa.batch342.services.impl.ProductServiceImpl;
import com.xa.batch342.utils.SlugUtils;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
            @RequestBody ProductRequestDto productRequestDto) {
        if (productRequestDto.getSlug() == null) {
            productRequestDto.setSlug(SlugUtils.toSlug(productRequestDto.getName()));
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            Product product = modelMapper.map(productRequestDto, Product.class);
            return ResponseEntity.ok(productService.updateProduct(id, product));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Product> saveProduct(@RequestBody ProductRequestDto productRequestDto) {
        // LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        if (productRequestDto.getSlug() == null) {
            productRequestDto.setSlug(SlugUtils.toSlug(productRequestDto.getName()));
        }
        try {
            Product product = modelMapper.map(productRequestDto, Product.class);
            return ResponseEntity.ok(productService.createProduct(product));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
