package com.example.DentalGid_site.controller;


import com.example.DentalGid_site.domain.*;
import com.example.DentalGid_site.repos.*;
import com.example.DentalGid_site.service.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/myAccount")
public class MyAccountController {


@Autowired
private UserRepo userRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoRepo userInfoRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private OrderProductRepo orderProductRepo;

    User user_autent = new User();


    @GetMapping
    public String gr(Model model){
        User user_autent = userService.findAuthUser();

        model.addAttribute("user", user_autent);
        return "myAccount";
    }
    @PostMapping
    public String gr(   @RequestParam String surname,
                        @RequestParam String name,
                        @RequestParam String middlename,
                        @RequestParam String phone,
                        @RequestParam String email,
                        @RequestParam Map<String, String> form,
                        @RequestParam("userId") User user, Model model ){


        UserInfo userInfo = new UserInfo();
        userInfo.setSurname(surname);
        userInfo.setName(name);
        userInfo.setMiddlename(middlename);
        System.out.println(phone);
        userInfo.setPhone(phone);
        user.setEmail(email);
        userInfo.setUser(user);
        System.out.println("------------------MyA-Post------------------------------------");

        userRepo.save(user);
       // userInfoRepo.save(userInfo);
        model.addAttribute("user", user);
        return "myAccount";
    }

    @GetMapping("orders")
    public String greeting(Model model)
    {
        user_autent = userService.findAuthUser();
        List<Order> orders = orderRepo.findByUser(user_autent);
        model.addAttribute("orders", orders);
        return "orders";
    }
    @GetMapping("orders/{order}")
    public String productEditForm(@PathVariable Order order, Model model){

       // Order order = orderRepo.findByUser(user_autent);
        List<OrderProduct> orderProducts = orderProductRepo.findByOrder(order);
        model.addAttribute("orderProducts", orderProducts);
        model.addAttribute("danni", order);
        System.out.println("___________________order/order________________________________");

        return "orderInfo";
    }










}
