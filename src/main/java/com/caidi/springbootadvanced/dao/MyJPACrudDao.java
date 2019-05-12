package com.caidi.springbootadvanced.dao;

import com.caidi.springbootadvanced.domain.User;
import org.springframework.data.repository.CrudRepository;

/*
继承crud接口
 */
public interface MyJPACrudDao extends CrudRepository<User,Integer> {
}
