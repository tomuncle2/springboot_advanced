package com.caidi.springbootadvanced.service.impl;

import com.caidi.springbootadvanced.dao.dbone.MyDao;
import com.caidi.springbootadvanced.domain.MybaitsUser;
import com.caidi.springbootadvanced.service.RedisService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    private MyDao myDao;

    @Override
    public List<MybaitsUser> listMybatisUser() {
        Example example = new Example(MybaitsUser.class);
        //排序对象
        Example.OrderBy orderBy = example.orderBy("uid");
        orderBy.desc();
        List<MybaitsUser> mybaitsUsers = myDao.selectByExample(example);
        return mybaitsUsers;
    }
}
