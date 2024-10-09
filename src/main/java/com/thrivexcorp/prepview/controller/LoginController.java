package com.thrivexcorp.prepview.controller;

import com.thrivexcorp.prepview.entity.LoginRequest;
import com.thrivexcorp.prepview.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;


@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
        System.out.println("login request");
        return userService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @GetMapping("/csrf-token")
    public CsrfToken gerCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
