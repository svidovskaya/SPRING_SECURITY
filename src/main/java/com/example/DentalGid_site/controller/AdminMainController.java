package com.example.DentalGid_site.controller;


import com.example.DentalGid_site.domain.Order;
import com.example.DentalGid_site.domain.OrderProduct;
import com.example.DentalGid_site.domain.Product;
import com.example.DentalGid_site.domain.Role;
import com.example.DentalGid_site.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/panel")
public class AdminMainController {


    @Autowired
    OrderRepo orderRepo;
    @Autowired
    ProductRepo productRepo;
    @GetMapping
    public String m(Model model){

        return "panelAdmin";
    }
    @GetMapping("ordrs")
    public String greeting(Model model)
    {
        System.out.println("___________________panel______________________________");
        List<Order> orders = orderRepo.findAll();
        System.out.println(orders.size());
        model.addAttribute("orders", orders);
        return "ordersList";
    }
    @GetMapping("products")
    public String greet(Model model)
    {
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "productList";
    }
    @GetMapping("{product}/delete")
    public String productDelete(@PathVariable Product product, Model model){
        productRepo.delete(product);
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "productList";
    }








}
