package com.xa.batch342.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xa.batch342.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
