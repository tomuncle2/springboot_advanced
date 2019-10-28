package com.caidi.springbootadvanced.domain;

import lombok.Data;
import lombok.Getter;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Getter
@Table(name="user")
public class MybaitsUser implements Serializable{

    private static final long serialVersionUID = -5378000797578675250L;

    @Id
    private Integer uid;

    private  String username;

    private  String password;

    private Integer enabled;
}
