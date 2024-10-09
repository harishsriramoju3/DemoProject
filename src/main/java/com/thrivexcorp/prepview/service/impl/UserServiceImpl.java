package com.thrivexcorp.prepview.service.impl;

import com.thrivexcorp.prepview.entity.User;
import com.thrivexcorp.prepview.repository.UserRepository;
import com.thrivexcorp.prepview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // You can add validation or other business logic here
        user.setUid(UUID.randomUUID());
        return userRepository.save(user);
    }

    @Override
    public String authenticate(String email, String password) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(email);
        } else {
            return "fail";
        }
//        Optional<User> user = userRepository.findByEmail(email);
//        return user.isPresent() && user.get().getPassword().equals(password);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users =  userRepository.findAll();

        //sort by name
//        List<User> withComparing = users.stream().sorted(Comparator.comparing(User::getName).thenComparing()).toList();
//        System.out.println("withComparing" + withComparing);
//        Collections.sort(users, (o1,o2 ) -> o1.getName().compareTo(o2.getName()));
//        System.out.println("withCompareTo"+ users);

        //comparing by salary
//        List<User> withComparing = users.stream().sorted(Comparator.comparingLong(User::getSalary).reversed()).toList();
//        System.out.println("withComparing" + withComparing);
//        Collections.sort(users, (o1,o2 ) -> o1.getSalary() > o2.getSalary() ? -1 : (o1.getSalary() < o2.getSalary() ? 1 : 0));
//        System.out.println("withCompareTo"+ users);
//        return withComparing;

        //distinct objects by email
        //users.stream().distinct().toList();
        return users.stream().filter(distinctByKey(User::getEmail)).toList();

    }


   public <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtracter){
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtracter.apply(t));
   }





//    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
//        Set<Object> seen = ConcurrentHashMap.newKeySet();
//        return t -> seen.add(keyExtractor.apply(t));
//    }

}
