package com.thrivexcorp.prepview.entity;


import lombok.Data;
import lombok.Getter;


@Getter
@Data
public class LoginRequest {

    private String username;
    private String password;

}
