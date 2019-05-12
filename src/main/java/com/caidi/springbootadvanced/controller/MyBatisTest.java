package com.caidi.springbootadvanced.controller;

import com.caidi.springbootadvanced.domain.MybaitsUser;
import com.caidi.springbootadvanced.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("mybatis/v1")
public class MyBatisTest {

    @Autowired
    private UserService userService;

    @GetMapping(value="insert")
    MybaitsUser insert(MybaitsUser user){
        MybaitsUser mybaitsUser = userService.insert(user);
        return mybaitsUser;
    }

    @GetMapping(value="list")
    List<MybaitsUser> listUser(){
        List<MybaitsUser> listUser =  userService.listUser();
        return listUser;
    }

    @GetMapping(value="lists")
    List<MybaitsUser> listUsers(){
        List<MybaitsUser> listUsers =  userService.listUsers();
        System.out.println(listUsers);
        return listUsers;
    }

    @GetMapping(value="get")
    MybaitsUser getUser(Integer id){
        return  userService.getUser(id);
    }
}
