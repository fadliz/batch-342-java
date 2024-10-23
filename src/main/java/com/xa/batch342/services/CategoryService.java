package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.Category;

public interface CategoryService {
    Category createCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    Category getCategory(Long id);

    List<Category> getCategories();
}
