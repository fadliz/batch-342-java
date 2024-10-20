package com.xa.batch342.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xa.batch342.entities.Variant;
import com.xa.batch342.repositories.VariantRepository;
import com.xa.batch342.utils.SlugUtils;


@Controller
@RequestMapping("/variant")
public class VariantController {

    @Autowired
    VariantRepository variantRepository;

    @GetMapping("")
    public ModelAndView getVariant() {
        ModelAndView view = new ModelAndView("variant/index");
        List<Variant> variants = variantRepository.findAll();
        view.addObject("variants", variants);
        view.addObject("title", "Master Variant");
        return view;
    }

    @PostMapping("")
    public String saveVariant(@ModelAttribute Variant variant) {
        variant.setSlug(SlugUtils.toSlug(variant.getName()));
        variantRepository.save(variant);
        return "redirect:/variant";
    }
}