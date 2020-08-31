package com.example.DentalGid_site.controller;

import com.example.DentalGid_site.domain.Category;
import com.example.DentalGid_site.domain.Product;
import com.example.DentalGid_site.repos.CategoryRepo;
import com.example.DentalGid_site.repos.DopCategoryRepo;
import com.example.DentalGid_site.repos.ManufRepo;
import com.example.DentalGid_site.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private DopCategoryRepo dopCategoryRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ManufRepo manufRepo;


    @GetMapping
    public String prodList(Model model){

        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("dopcategories", dopCategoryRepo.findAll());



        return "new_productList";
    }
    @GetMapping("{product}")
    public String productEditForm(@PathVariable Product product, Model model){
        model.addAttribute("product", product);
        model.addAttribute("manufacturers", manufRepo.findAll());
        model.addAttribute("categorys", categoryRepo.findAll());
        model.addAttribute("dopcategories", dopCategoryRepo.findAll());

        return "productInfo";
    }




}
