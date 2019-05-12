package com.caidi.springbootadvanced.service.impl;


import com.caidi.springbootadvanced.dao.MyJPACrudDao;
import com.caidi.springbootadvanced.dao.MyJPADao;
import com.caidi.springbootadvanced.domain.User;
import com.caidi.springbootadvanced.service.JPAService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class JPAServiceImpl implements JPAService {

    @Resource
    private MyJPADao myJPADao;

    @Resource
    private MyJPACrudDao myJPACrudDao;

    @Override
    public void saveUser() {

    }

    @Override
    public void removeUser() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public User getUser(Integer uid) {
        return null;
    }

    @Override
    public List<User> listUser() {
        Iterable<User> u= myJPACrudDao.findAll();
        Iterable<User> i= myJPADao.findAll();
        List<User> list = new ArrayList<>();
        Iterator<User> it = u.iterator();
        while(it.hasNext()){
            list.add(it.next());
        }
        return list;
    }
}
