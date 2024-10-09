package com.thrivexcorp.prepview.controller;

import com.thrivexcorp.prepview.entity.User;
import com.thrivexcorp.prepview.repository.UserRepository;
import com.thrivexcorp.prepview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("all")
    public List<User> getUsers(){
       return userService.getAllUsers();
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }



}
