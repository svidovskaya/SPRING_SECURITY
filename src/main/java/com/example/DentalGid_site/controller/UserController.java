package com.example.DentalGid_site.controller;

import com.example.DentalGid_site.domain.Role;
import com.example.DentalGid_site.domain.User;
import com.example.DentalGid_site.domain.UserInfo;
import com.example.DentalGid_site.repos.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepo.findAll());
        return "userList";
    }
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam String surname,
            @RequestParam String name,
            @RequestParam String middlename,
            @RequestParam String phone,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ){
        user.setUsername(username);
        UserInfo userInfo = new UserInfo();
        userInfo.setSurname(surname);
        userInfo.setName(name);
        userInfo.setMiddlename(middlename);
        userInfo.setPhone(phone);
        userInfo.setUser(user);
      //  user.setUserInfo(userInfo);
//System.out.println("----------------------------------------------------------------------");
//System.out.println(user.getUserInfo().getName());
//System.out.println("----------------------------------------------------------------------");

        Set<String> roles = Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        user.getRoles().clear();

        for (String key: form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepo.save(user);
        System.out.println("---------------------------2-------------------------------------------");
    //    System.out.println(user.getUserInfo().getName());
        System.out.println("----------------------------2------------------------------------------");
        return "redirect:/user";
    }
}
