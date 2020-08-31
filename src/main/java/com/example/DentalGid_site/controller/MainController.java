package com.example.DentalGid_site.controller;


import com.example.DentalGid_site.domain.*;
import com.example.DentalGid_site.repos.*;
import com.example.DentalGid_site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class MainController {


    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    DopCategoryRepo dopCategoryRepo;
    @Autowired
    ManufRepo manufRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    UserDeviceRepo userDeviceRepo;
    @Autowired
    UserService userService;

    private Map<String, String> getHeadersInfo(HttpServletRequest request) {

        Map<String, String> map = new HashMap<String, String>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            System.out.println(key);
            String value = request.getHeader(key);
            System.out.println(value);
        }

        return map;
    }


    @GetMapping("/")
    public String greeting(@RequestParam (required = false) String filter,
                           @RequestParam (required = false) String filter_manuf,
                           Model model, org.apache.catalina.servlet4preview.http.HttpServletRequest request)
    {
        String retu = "greeting";

            Iterable<Product> products = productRepo.findAll();
            String m = "";
            if (filter_manuf != null){
                m = filter_manuf;
                Optional<Manufacturer> manufacturer = manufRepo.findById(Long.valueOf(filter_manuf));
                products = productRepo.findByManufacturerAndNameContaining(manufacturer, filter);
            }else {
                m = "";
                if(filter != null){
                    products = productRepo.findByNameContaining(filter);
                } else {
                    products = productRepo.findAll();
                }
            }

            model.addAttribute("categories", categoryRepo.findAll());
            model.addAttribute("dopcategories", dopCategoryRepo.findAll());
            model.addAttribute("manufacturers", manufRepo.findAll());
            model.addAttribute("finds_p", 0);
            model.addAttribute("products", products);
//        } else {
//            HttpSession session = request.getSession();
//            session.invalidate();
//            SecurityContextHolder.clearContext();
//            retu="/logout";
//        }

      //  getHeadersInfo(request);

        return retu;
    }
    @PostMapping("/add")
    public String addcookie(@RequestParam (required = false) String filter,
                            @RequestParam (required = false) String filter_manuf,
                            @RequestParam String kolvo,
                            @RequestParam("productId") Product product, HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        Iterable<Product> products = productRepo.findAll();
        if (filter != null && !filter.isEmpty()){
            products = productRepo.findByNameContaining(filter);
        }
        String[][] pr = new String[1][2];

        pr[0][0]= String.valueOf(product.getId());
        pr[0][1]=kolvo;
System.out.println(pr[0][0]);
        System.out.println(pr[0][1]);


        Cookie cookie = new Cookie(pr[0][0], pr[0][1]);
        request.setAttribute("product", pr);
        response.setCharacterEncoding("UTF-8");
        model.addAttribute("categories", categoryRepo.findAll());
        model.addAttribute("dopcategories", dopCategoryRepo.findAll());
        model.addAttribute("manufacturers", manufRepo.findAll());
        model.addAttribute("products", products);
        response.addCookie(cookie);
        return "greeting";
    }


@GetMapping("/{category}")
public String categ(@PathVariable Category category, Model model){
   // Iterable<Product> products = categoryRepo.findById(category.getId());
   List<Dop_category> dopCategory = dopCategoryRepo.findByCategory_Id(category.getId());
   System.out.println(dopCategory.size());
   // Set<Product> products = dopCategory.get(3).getProductsSet();
   // System.out.println(products.size());
   //Set<Product> products = dopCategoryRepo.findByCategory_Id(category.getId());
    model.addAttribute("categories", categoryRepo.findAll());
    model.addAttribute("dopcategories", dopCategoryRepo.findAll());
    model.addAttribute("manufacturers", manufRepo.findAll());
    model.addAttribute("finds", dopCategory);
    model.addAttribute("products", productRepo.findAll());
    model.addAttribute("finds_p", 1);

        return "greeting";
}

    @GetMapping("/menu")
    public String main(Model model) {
        model.addAttribute("roles", Role.values());

        return "menu";
    }
    @GetMapping("o_nas")
    public String main1(Model model){


        return "o_nas";
    }
    @GetMapping("/test")
    public String test(Float filter_min, String filter_max, Model model){
//        if (!filter_min.isEmpty() && !filter_max.isEmpty()){
            Float min = Float.valueOf(filter_min);
            Float max = Float.valueOf(filter_max);
//        } else {
//            Float min = Float.valueOf(0);
//            Float max = Float.valueOf(0);
//        }

System.out.println("min = "+min+" max = "+max);

        List<Product> products = productRepo.findProductByPriceParams(min, max);
        int kolvp = products.size();
        model.addAttribute("products", products);
        model.addAttribute("kolvo", kolvp);



        return "test";
    }








}
