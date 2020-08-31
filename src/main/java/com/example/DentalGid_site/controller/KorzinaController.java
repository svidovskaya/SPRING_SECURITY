package com.example.DentalGid_site.controller;


import com.example.DentalGid_site.domain.*;
import com.example.DentalGid_site.repos.*;
import com.example.DentalGid_site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/korzina")
public class KorzinaController {
    @Autowired
    private DopCategoryRepo dopCategoryRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ManufRepo manufRepo;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
            private OrderProductRepo orderProductRepo;
    Set<OrderProduct> orderProducts = new HashSet<>();
    Float summ= Float.valueOf(0);



    User user_autent = new User();
    User user_d = new User();
    String danni_user[] = new String[8];
    Order order = new Order();
    int k=0;




    @GetMapping
    public String prodList(HttpServletRequest request, HttpServletResponse response, Model model){
        Set<OrderProduct> orderProducts = new HashSet<>();
        user_autent = userService.findAuthUser();
        Cookie cookies[];
        cookies = request.getCookies();
        //Iterable<Product> products = productRepo.findAll();
Set<Optional<Product>> products = new HashSet<>();
        int k=0;
        for (int i=0; i<cookies.length; i++){
            if (cookies[i].getName().equals("JSESSIONID")){} else {
                if (!cookies[i].getValue().equals("0")) {
                    OrderProduct orderProduct = new OrderProduct();
                    Long id_pr = Long.parseLong(cookies[i].getName());
                    orderProduct.setKolvo(Integer.parseInt(cookies[i].getValue()));
                    Optional<Product> np = productRepo.findById(id_pr);
                    orderProduct.setProduct(np.get());
                    orderProduct.setPrice(np.get().getPrice());
                    orderProducts.add(orderProduct);






                }
            }


        }

        System.out.println("----------------------get------"+k);
        model.addAttribute("products", orderProducts);
       // orderProducts.clear();




        return "korzina";
    }
    @PostMapping
    public String prodList_d(@RequestParam("productId") Product product,
                             @RequestParam String next,
                             @RequestParam String kolvo, HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
       String pr = "redirect:korzina";
        if (next.equals("Удалить")){
            Long id_del = product.getId();
            String id_del_str = String.valueOf(id_del);
            orderProducts.clear();
            Cookie cookies[];
            cookies = request.getCookies();
            Cookie cookie = new Cookie(id_del_str, "0");
            response.addCookie(cookie);
            cookies = request.getCookies();
            //Iterable<Product> products = productRepo.findAll();
            Set<Optional<Product>> products = new HashSet<>();
            String[] kolvo_pr = new String[k];
            for(int i=0; i<k; i++){
                kolvo_pr[i] = kolvo;
                System.out.println(kolvo_pr[i]);
            }

            for (int i=0; i<cookies.length; i++){

                if (cookies[i].getName().equals("JSESSIONID") ){} else {
                    if (!cookies[i].getValue().equals("0")) {

                        OrderProduct orderProduct = new OrderProduct();
                        Long id_pr = Long.parseLong(cookies[i].getName());
                        orderProduct.setKolvo(Integer.parseInt(cookies[i].getValue()));
                        Optional<Product> np = productRepo.findById(id_pr);
                        orderProduct.setProduct(np.get());
                        orderProduct.setPrice(np.get().getPrice());
                        orderProducts.add(orderProduct);

                    }
                }
            }

            model.addAttribute("products", orderProducts);


        }
        if (next.equals("Изменить")){
            Long id_del = product.getId();
            String id_del_str = String.valueOf(id_del);


            Cookie cookies[];
            cookies = request.getCookies();

            for (int i=0; i<cookies.length; i++){
                if (cookies[i].getName().equals("JSESSIONID") ){} else {
                    if (!cookies[i].getValue().equals("0")) {
                        if (cookies[i].getName().equals(id_del_str)){
                            Cookie cookie = new Cookie(id_del_str, kolvo);
                            response.addCookie(cookie);
                        }

//                        OrderProduct orderProduct = new OrderProduct();
//                        Long id_pr = Long.parseLong(cookies[i].getName());
//                        orderProduct.setKolvo(Integer.parseInt(cookies[i].getValue()));
//                        Optional<Product> np = productRepo.findById(id_pr);
//                        orderProduct.setProduct(np.get());
//                        orderProduct.setPrice(np.get().getPrice());
//                        orderProducts.add(orderProduct);

                    }
                }
            }

            cookies = request.getCookies();




            model.addAttribute("user", user_autent);


        }

       return pr;
    }
    @GetMapping("2")
    public String ord(Model model){

        orderProducts.clear();
        model.addAttribute("user", user_autent);




        return "korzina2";
    }
    @PostMapping("2")
    public String ord2( @RequestParam String surname,
                        @RequestParam String name,
                        @RequestParam String middlename,
                        @RequestParam String phone,
                        @RequestParam String email,
                        @RequestParam String dostavka,
                        @RequestParam String dostavka_adr,
                        @RequestParam String oplata,
                        @RequestParam Map<String, String> form,
                        Model model){

        danni_user[0] = surname;
        danni_user[1] = name;
        danni_user[2] = middlename;
        danni_user[3] = phone;
        danni_user[4] = email;
        danni_user[5] = dostavka;
        danni_user[6] = dostavka_adr;
        danni_user[7] = oplata;

        return "redirect:3";
    }
    @GetMapping("3")
    public String ord3(HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println("--------------4--------------");
        UserInfo ui = new UserInfo();
        ui.setSurname(danni_user[0]);
        ui.setName(danni_user[1]);
        ui.setMiddlename(danni_user[2]);
        ui.setPhone(danni_user[3]);
        user_autent.setUserInfo(ui);
        user_autent.setEmail(danni_user[4]);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setDostavka_method(danni_user[5]);
        orderInfo.setDostavka_adr(danni_user[6]);
        orderInfo.setOpl_method(danni_user[7]);

        order.setUser(user_autent);
        order.setOrderInfo(orderInfo);
        order.setOrdr_st("new");


        Cookie cookies[];
        cookies = request.getCookies();
        for (int i=0; i<cookies.length; i++){
            if (cookies[i].getName().equals("JSESSIONID")){} else {
                if (!cookies[i].getValue().equals("0")) {
                    OrderProduct orderProduct = new OrderProduct();
                    Long id_pr = Long.parseLong(cookies[i].getName());
                    orderProduct.setOrder(order);
                    orderProduct.setKolvo(Integer.parseInt(cookies[i].getValue()));
                    Optional<Product> np = productRepo.findById(id_pr);
                    orderProduct.setProduct(np.get());
                    orderProduct.setPrice(np.get().getPrice());
                    summ+= orderProduct.getPrice()*orderProduct.getKolvo();
                    orderProducts.add(orderProduct);
                }
            }
        }
        order.setOrdr_summa(summ);


        model.addAttribute("orderProducts", orderProducts);
       model.addAttribute("danni", order);


        return "korzina3";
    }
    @PostMapping("3")

    public String ord3p(Model model, HttpServletRequest request, HttpServletResponse response){
        int proverka = 0;
        String str = "korzina4";
        if (user_autent.getActivationCode().equals(" ")){
            System.out.println("--------------3--------------");
            model.addAttribute("danni", danni_user);
            model.addAttribute("user", user_autent);
            userRepo.save(user_autent);
            order.setOrdr_summa(summ);
            orderRepo.save(order);
            orderProductRepo.saveAll(orderProducts);
        } else {
            str = "korzina5";
        }

//        Cookie cookies[];
//        cookies = request.getCookies();
//
//
//
//        for (int i=0; i<cookies.length; i++){
//            if (cookies[i].getName().equals("JSESSIONID")){} else {
//                Cookie cookie = new Cookie(cookies[i].getName(), "0");
//                response.addCookie(cookie);
//            }
//        }

        return str;
    }
    @GetMapping("4")
    public String ord4(Model model){

        return "korzina4";
    }
    @GetMapping("5")
    public String ord5(Model model){

        return "korzina5";
    }



}
