package com.caidi.springbootadvanced.service;

import com.caidi.springbootadvanced.domain.MybaitsUser;
import java.util.List;

/**
 * mybatis dao的service
 */
public interface UserService {
    MybaitsUser insert(MybaitsUser user);

    List<MybaitsUser> listUsers();

    List<MybaitsUser> listUser();

    MybaitsUser getUser(Integer id);
}
