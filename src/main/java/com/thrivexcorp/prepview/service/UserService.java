package com.thrivexcorp.prepview.service;

import com.thrivexcorp.prepview.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    String authenticate(String email, String password);

    List<User> getAllUsers();
}
