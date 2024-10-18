package com.xa.batch342.services;

import java.util.List;

import com.xa.batch342.entities.Variant;

public interface VariantService {
    Variant createVariant(Variant variant);

    Variant updateVariant(Long id, Variant variant);

    void deleteVariant(Long id);

    Variant getVariant(Long id);

    List<Variant> getVariants();
}
