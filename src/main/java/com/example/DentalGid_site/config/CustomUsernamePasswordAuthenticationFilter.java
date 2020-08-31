package com.example.DentalGid_site.config;

import com.example.DentalGid_site.domain.UserDevice;
import com.example.DentalGid_site.repos.UserDeviceRepo;
import com.example.DentalGid_site.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private static final Log LOG = LogFactory.getLog(CustomUsernamePasswordAuthenticationFilter.class);

    private static final String ERROR_MESSAGE = "Something went wrong while parsing /login request body";

    private final ObjectMapper objectMapper = new ObjectMapper();
   @Autowired
   UserDeviceRepo userDeviceRepo;

    public CustomUsernamePasswordAuthenticationFilter() {
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        String user_agent = request.getHeader("user-agent");
        String[] danni_user_agent = user_agent.split("\\) ");
        String[] danni_op_sys = danni_user_agent[0].split("\\(");
        String[] danni_op_sys1 = danni_op_sys[1].split("; ");
        System.out.println("jnfkjdsnfkjdnsckjnkjndkjsnckjdsnckjdnckd");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        UserDevice userDevice = userDeviceRepo.findAllByUsername(username);
        if (userDevice.getOp_sys().indexOf(danni_op_sys1[0])>=0 && userDevice.getOp_sys().indexOf(danni_op_sys1[3])>=0){
            System.out.println("jnfkjdsnfkjdnsckjnkjndkjsnckjdsnckjdnckd");
            getAuthenticationManager().authenticate(authentication);
        } else {
            System.out.println("jnfkjdsnfkjdnsckjnkjndkjsnckjdsnckjdnckd");
        }

        return this.getAuthenticationManager().authenticate(authentication);
    }
}
