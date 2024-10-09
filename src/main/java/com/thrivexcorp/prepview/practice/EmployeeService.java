package com.thrivexcorp.prepview.practice;

import com.thrivexcorp.prepview.entity.User;
import com.thrivexcorp.prepview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    UserService userService;


    public List<User> getUsers(){
        return null;
    }

}
