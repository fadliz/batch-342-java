package com.xa.batch342.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.Category;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.utils.SlugUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(String name, String description) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setSlug(SlugUtils.toSlug(name)); // Generate the slug from name
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, String name, String description) {
        Optional<Category> existingCategoryOpt = categoryRepository.findById(id);
        if (existingCategoryOpt.isPresent()) {
            Category existingCategory = existingCategoryOpt.get();
            existingCategory.setName(name);
            existingCategory.setDescription(description);
            existingCategory.setSlug(SlugUtils.toSlug(name)); // Update the slug if name changes
            return categoryRepository.save(existingCategory);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
