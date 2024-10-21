package com.xa.batch342.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xa.batch342.entities.Variant;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Long>{
    // List<Variant> findByProductCategoryIsDeletedFalse();
}
