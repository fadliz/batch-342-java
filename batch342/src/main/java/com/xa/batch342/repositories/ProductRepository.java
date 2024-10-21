package com.xa.batch342.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.batch342.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByCategoryIsDeletedFalse();
    List<Product> findByCategoryIdAndCategoryIsDeletedFalse(Long categoryId);
}
