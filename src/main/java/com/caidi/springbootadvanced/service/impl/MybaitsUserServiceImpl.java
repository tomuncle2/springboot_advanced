package com.caidi.springbootadvanced.service.impl;

import com.caidi.springbootadvanced.dao.dbone.MyDao;
import com.caidi.springbootadvanced.domain.MybaitsUser;
import com.caidi.springbootadvanced.service.MybaitsUserService;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class MybaitsUserServiceImpl implements MybaitsUserService {

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

    @Override
    public List<MybaitsUser> getMybatisUser(Integer id) {
        ConcurrentMap concurrentMapCache = new ConcurrentHashMap();
        Example example = new Example(MybaitsUser.class);
        //排序对象
        Example.OrderBy orderBy = example.orderBy("uid");
       // Example.Criterion criterion = example.createCriteria();

        //条件对象
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uid",id);
        List<MybaitsUser> mybaitsUsers = myDao.selectByExample(example);
        return mybaitsUsers;
    }

    @Override
    public int remove(Integer id) {
        Example example = new Example(MybaitsUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uid",id);
        myDao.deleteByExample(example);
        return 1;
    }

    @Override
    public int update(MybaitsUser mybaitsUser) {
        Example example = new Example(MybaitsUser.class);
        myDao.updateByPrimaryKeySelective(mybaitsUser);
        return 1;
    }

    @Override
    public int insert(MybaitsUser mybaitsUser) {
        /**/
        myDao.insert(mybaitsUser);
        return 1;
    }
}
