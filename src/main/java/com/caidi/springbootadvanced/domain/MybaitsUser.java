package com.caidi.springbootadvanced.domain;


import lombok.Data;
import lombok.Getter;


@Data
@Getter
public class MybaitsUser {

    private Integer uid;

    private  String username;

    private  String password;

    private Integer enabled;
}
