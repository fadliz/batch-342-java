package com.xa.batch342.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.Product;
import com.xa.batch342.repositories.ProductRepository;
import com.xa.batch342.services.ProductService;
import com.xa.batch342.utils.SlugUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProductOpt = productRepository.findById(id);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(product.getName());
            if (product.getSlug() != null) {
                existingProduct.setSlug(product.getSlug());
            } else {
                existingProduct.setSlug(SlugUtils.toSlug(product.getName()));
            }
            existingProduct.setModifiedBy(product.getModifiedBy());
            existingProduct.setCategoryId(product.getCategoryId());
            return productRepository.save(existingProduct);
        } else {
            throw new RuntimeException("Product not found");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

}
