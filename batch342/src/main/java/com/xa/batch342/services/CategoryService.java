package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.Category;

public interface CategoryService {
    Category createCategory(String name, String description);

    Category updateCategory(Long id, String name, String description);

    void deleteCategory(Long id);

    Category getCategory(Long id);

    List<Category> getCategories();
}
