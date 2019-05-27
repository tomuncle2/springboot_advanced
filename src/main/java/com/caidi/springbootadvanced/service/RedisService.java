package com.caidi.springbootadvanced.service;

import com.caidi.springbootadvanced.domain.MybaitsUser;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public interface RedisService {

      MybaitsUser saveAndCache(MybaitsUser mybaitsUser);

       int save(MybaitsUser mybaitsUser);

      List<MybaitsUser> listMybatisUser();


      List<MybaitsUser> getMybatisUser(Integer id);


      int remove(Integer id);


       MybaitsUser update(MybaitsUser mybaitsUser);


      int insert(MybaitsUser mybaitsUser);

      public int removeAll();
}
