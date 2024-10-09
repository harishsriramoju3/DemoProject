package com.thrivexcorp.prepview.service.impl;

import com.thrivexcorp.prepview.entity.User;
import com.thrivexcorp.prepview.entity.UserPrincipal;
import com.thrivexcorp.prepview.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        if(!user.isPresent()){
            System.out.println(String.format("User not found with username %s", username));
            throw new UsernameNotFoundException("User not found");
        }
        return new UserPrincipal(user.get());
    }
}
