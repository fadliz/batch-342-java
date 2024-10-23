package com.xa.batch342.controllers;

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

import com.xa.batch342.dtos.requests.CategoryRequestDto;
import com.xa.batch342.entities.Category;
import com.xa.batch342.services.impl.CategoryServiceImpl;
import com.xa.batch342.utils.SlugUtils;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping("")
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,
            @RequestBody CategoryRequestDto categoryRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        if (categoryRequestDto.getSlug() == null) {
            categoryRequestDto.setSlug(SlugUtils.toSlug(categoryRequestDto.getName()));
        }
        try {
            Category category = modelMapper.map(categoryRequestDto, Category.class);
            return ResponseEntity.ok(categoryService.updateCategory(id, category));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Category> saveCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
        // LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        if (categoryRequestDto.getSlug() == null) {
            categoryRequestDto.setSlug(SlugUtils.toSlug(categoryRequestDto.getName()));
        }
        try {
            Category category = modelMapper.map(categoryRequestDto, Category.class);
            return ResponseEntity.ok(categoryService.createCategory(category));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
