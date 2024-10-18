package com.xa.batch342.controllers;

import java.util.List;

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

import com.xa.batch342.dtos.requests.VariantRequestDto;
import com.xa.batch342.entities.Variant;
import com.xa.batch342.services.impl.VariantServiceImpl;
import com.xa.batch342.utils.SlugUtils;

@RestController
@RequestMapping("/api/variant")
public class VariantRestController {

    @Autowired
    VariantServiceImpl variantService;

    @GetMapping("")
    public ResponseEntity<List<Variant>> getVariants() {
        return ResponseEntity.ok(variantService.getVariants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variant> getVariantById(@PathVariable Long id) {
        return ResponseEntity.ok(variantService.getVariant(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Variant> updateVariant(@PathVariable Long id,
            @RequestBody VariantRequestDto variantRequestDto) {
        if (variantRequestDto.getSlug() == null) {
            variantRequestDto.setSlug(SlugUtils.toSlug(variantRequestDto.getName()));
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        try {
            Variant variant = modelMapper.map(variantRequestDto, Variant.class);
            return ResponseEntity.ok(variantService.updateVariant(id, variant));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable Long id) {
        variantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<Variant> saveVariant(@RequestBody VariantRequestDto variantRequestDto) {
        // LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        if (variantRequestDto.getSlug() == null) {
            variantRequestDto.setSlug(SlugUtils.toSlug(variantRequestDto.getName()));
        }
        try {
            Variant variant = modelMapper.map(variantRequestDto, Variant.class);
            return ResponseEntity.ok(variantService.createVariant(variant));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
