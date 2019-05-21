package com.caidi.springbootadvanced.service;

import com.caidi.springbootadvanced.domain.MybaitsUser;

import java.util.List;

public interface RedisService {
     List<MybaitsUser> listMybatisUser();
}
