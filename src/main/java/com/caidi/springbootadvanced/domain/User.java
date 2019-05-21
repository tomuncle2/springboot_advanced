package com.caidi.springbootadvanced.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
@Getter
@Setter
@ToString
public class User {
    @Id
    @Column(name = "uid")
    private Integer uid;
    @Column(name = "username")
    private  String username;
    @Column(name = "password")
    private  String password;
    @Column(name = "enabled")
    private Integer enabled;
}
