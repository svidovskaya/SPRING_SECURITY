package com.example.DentalGid_site.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.DentalGid_site.domain.User;
import com.example.DentalGid_site.domain.UserDevice;
import com.example.DentalGid_site.repos.UserDeviceRepo;
import com.example.DentalGid_site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class XClacksOverhead implements Filter {

    public static final String X_CLACKS_OVERHEAD = "X-Clacks-Overhead";
    @Autowired
    UserDeviceRepo userDeviceRepo;



    @Override
    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println(request.getHeader("referer"));
        if (request.getHeader("referer") == null || request.getHeader("referer").indexOf("localhost:8082") >0 ){

        }else if(request.getHeader("referer").indexOf("login")>=0){
//            response.sendRedirect("/login");
        } else {
            String user_agent = request.getHeader("user-agent");
            System.out.println(user_agent);
            String[] danni_user_agent = user_agent.split("\\) ");
            System.out.println(danni_user_agent.length);
            String[] danni_op_sys = danni_user_agent[0].split("\\(");
            System.out.println(danni_op_sys[1]);
            String[] danni_op_sys1 = danni_op_sys[1].split("; ");
            System.out.println(danni_op_sys1[1]);
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            Object obj = auth.getPrincipal();

            if (obj.equals("anonymousUser")){
                System.out.println("non");
            } else{
                String username = "";
                username = ((UserDetails) obj).getUsername();
//            String a = auth.getPrincipal().toString();
                UserDevice userDevice = userDeviceRepo.findAllByUsername(username);
                if (userDevice.getOp_sys().indexOf(danni_op_sys1[0])>=0 && userDevice.getOp_sys().indexOf(danni_op_sys1[2])>=0){

                }else {
                    response.sendRedirect("/login?logout");
                }
            }

          //
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(FilterConfig arg0) throws ServletException {}

}
