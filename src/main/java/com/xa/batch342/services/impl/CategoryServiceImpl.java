package com.xa.batch342.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.Category;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.services.CategoryService;
import com.xa.batch342.utils.SlugUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) { // Generate the slug from name
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<Category> existingCategoryOpt = categoryRepository.findById(id);
        if (existingCategoryOpt.isPresent()) {
            Category existingCategory = existingCategoryOpt.get();
            if (category.getSlug() != null) {
                existingCategory.setSlug(category.getSlug());
            } else {
                existingCategory.setSlug(SlugUtils.toSlug(category.getName()));
            }
            existingCategory.setName(category.getName());
            existingCategory.setModifiedBy(category.getModifiedBy());
            return categoryRepository.save(existingCategory);
        } else {
            throw new RuntimeException("Category not found");
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id); 
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
