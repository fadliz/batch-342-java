package com.xa.batch342.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.batch342.entities.Variant;
import com.xa.batch342.repositories.VariantRepository;
import com.xa.batch342.services.VariantService;
import com.xa.batch342.utils.SlugUtils;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VariantServiceImpl implements VariantService {

    @Autowired
    private VariantRepository variantRepository;

    @Override
    public Variant createVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    @Override
    public void deleteVariant(Long id) {
        variantRepository.deleteById(id);
    }

    @Override
    public Variant getVariant(Long id) {
        return variantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found"));
    }

    @Override
    public List<Variant> getVariants() {
        return variantRepository.findByProductCategoryIsDeletedFalse();
    }

    @Override
    public Variant updateVariant(Long id, Variant variant) {
        Optional<Variant> existingVariantOpt = variantRepository.findById(id);
        if (existingVariantOpt.isPresent()) {
            Variant existingVariant = existingVariantOpt.get();
            existingVariant.setName(variant.getName());
            if (variant.getSlug() != null) {
                existingVariant.setSlug(variant.getSlug());
            } else {
                existingVariant.setSlug(SlugUtils.toSlug(variant.getName()));
            }
            existingVariant.setDescription(variant.getDescription());
            existingVariant.setPrice(variant.getPrice());
            existingVariant.setStock(variant.getStock());
            existingVariant.setModifiedBy(variant.getModifiedBy());
            existingVariant.setProductId(variant.getProductId());
            return variantRepository.save(existingVariant);
        } else {
            throw new RuntimeException("Variant not found");
        }
    }

}
