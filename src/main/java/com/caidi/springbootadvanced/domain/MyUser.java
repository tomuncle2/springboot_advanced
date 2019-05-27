package com.caidi.springbootadvanced.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name="myuser")
@Data
public class MyUser implements Serializable {

    private static final long serialVersionUID = -6172467030187274439L;

    @Id
    private Integer uid;

    private  String username;

    private  String password;

    private Integer enabled;

    private Timestamp insertedTime;
}
