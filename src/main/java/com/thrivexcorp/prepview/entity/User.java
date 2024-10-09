package com.thrivexcorp.prepview.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "uid")
    private UUID uid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "salary")
    private Long salary;

//    public String getName() {
//        return name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getPassword() {
//        return password;
//    }

    @Column(name = "password")
    private String password;

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;


    // Method to set the createdAt field automatically
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
}
