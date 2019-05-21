package com.caidi.springbootadvanced.service;

import com.caidi.springbootadvanced.domain.MybaitsUser;

import java.util.List;

public interface MybaitsUserService {
    List<MybaitsUser> listMybatisUser();

    List<MybaitsUser> getMybatisUser(Integer id);

    int remove(Integer id);

    int update(MybaitsUser mybaitsUser);

    int insert(MybaitsUser mybaitsUser);
}
