package com.caidi.springbootadvanced.domain;


import lombok.Data;
import lombok.Getter;

import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Getter
@Table(name="user")
public class MybaitsUser {

    @Id
    private Integer uid;

    private  String username;

    private  String password;

    private Integer enabled;
}
