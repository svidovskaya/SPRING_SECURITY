package com.example.DentalGid_site.service;

import com.example.DentalGid_site.domain.Role;
import com.example.DentalGid_site.domain.User;
import com.example.DentalGid_site.domain.UserDevice;
import com.example.DentalGid_site.repos.UserDeviceRepo;
import com.example.DentalGid_site.repos.UserInfoRepo;
import com.example.DentalGid_site.repos.UserRepo;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MailSender mailSender;
    @Autowired
    PasswordEncoder passwordEncoder;


//
//    public String find(HttpServletRequest request){
//        String user_agent = request.getHeader("user-agent");
//        System.out.println(user_agent.indexOf("YANDEX"));
//        System.out.println(user_agent);
//        //_____________________________________________________________________________
//        String[] danni_user_agent = user_agent.split("\\) ");
//        System.out.println(danni_user_agent.length);
//        String[] danni_op_sys = danni_user_agent[0].split("\\(");
//        System.out.println(danni_op_sys[1]);
//        return danni_op_sys[1];
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepo.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return false;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
//        UserDevice userDevice = new UserDevice();
//        userDevice.setUsername(user.getUsername());
//        String op_sys = find(request);
//        userDevice.setOp_sys(op_sys);
//        userDeviceRepo.save(userDevice);

        if (!StringUtils.isEmpty(user.getEmail())) {
            String message = String.format(
                    "Привет, %s! \n" +
                            "Добро пожаловать на сайт DentalGid! \n " +
                            "Для подтверждения почты перейди по ссылке: link: http://localhost:8080/activate/%s",
                    user.getUsername(),
                    user.getActivationCode()
            );

            mailSender.send(user.getEmail(), "Activation code", message);
        }

        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepo.findByActivationCode(code);

        if (user == null) {
            return false;
        }

        user.setActivationCode(null);


        userRepo.save(user);

        return true;
    }

    public User findAuthUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object obj = auth.getPrincipal();
        String username = "";

        if (obj instanceof UserDetails) {
            username = ((UserDetails) obj).getUsername();
        } else {
            username = obj.toString();
        }

        User u = userRepo.findByUsername(username);
        return u;
    }

}
