package com.thrivexcorp.prepview.practice;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {

    private Long id;
    private String name;
    private String email;
    private Long salary;

    public Employee(Long id, String name, String email, Long salary) {
        this.id = id;
        this.name = name;
        this.email  = email;
        this.salary = salary;
    }
}
