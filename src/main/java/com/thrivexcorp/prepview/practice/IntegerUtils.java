package com.thrivexcorp.prepview.practice;

import com.thrivexcorp.prepview.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

 class IntegerUtils {

    @Autowired
    private UserServiceImpl userService;


    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,2,3,5,6,7,8,10);
        //filterEvenNumbers(numbers);
        calculateSum(numbers);
        sortEmployeesByName();
    }

    private static void calculateSum(List<Integer> numbers) {
        Integer sum = numbers.stream().reduce(0,Integer::sum);
        //Integer sum = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }

    public static void filterEvenNumbers(List<Integer> list){
        List<Integer> filteredListStream = list.stream().filter(i -> i%2 == 0).toList();
        List<Integer> filteredListCollectors = list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        //System.out.println(filteredListStream.add(3));
        System.out.println(filteredListCollectors.add(3));
    }

    private static void findMaxNumber(List<Integer> numbers) {
        Integer sum = numbers.stream().reduce(0,Integer::sum);
        //Integer sum = numbers.stream().mapToInt(i -> i).sum();
        System.out.println(sum);
    }

    private static void sortEmployeesByName(){

    }





}
