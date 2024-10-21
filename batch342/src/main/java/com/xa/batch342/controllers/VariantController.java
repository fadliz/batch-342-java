package com.xa.batch342.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.dtos.requests.VariantRequestDto;
import com.xa.batch342.entities.Category;
import com.xa.batch342.entities.Variant;
import com.xa.batch342.repositories.CategoryRepository;
import com.xa.batch342.repositories.VariantRepository;
import com.xa.batch342.services.impl.VariantServiceImpl;
import com.xa.batch342.utils.SlugUtils;

@Controller
@RequestMapping("/variant")
public class VariantController {

    @Autowired
    VariantServiceImpl variantService;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    VariantRepository variantRepository;

    @GetMapping("")
    public ModelAndView getVariant() {
        ModelAndView view = new ModelAndView("variant/index");
        List<Category> categories = categoryRepository.findAll();
        List<Variant> variants = variantRepository.findAll();
        view.addObject("category", categories);
        view.addObject("variants", variants);
        view.addObject("title", "Master Variant");
        return view;
    }

    @PostMapping("")
    public String saveVariant(@RequestBody VariantRequestDto variantRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        if (variantRequestDto.getSlug() == null) {
            variantRequestDto.setSlug(SlugUtils.toSlug(variantRequestDto.getName()));
        }
        Variant variant = modelMapper.map(variantRequestDto, Variant.class);
        variantService.createVariant(variant);
        return "redirect:/variant";
    }
}