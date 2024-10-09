package com.thrivexcorp.prepview.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("")
public class ViewController {

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
        // This corresponds to a login.html file in your templates folder
    }
}