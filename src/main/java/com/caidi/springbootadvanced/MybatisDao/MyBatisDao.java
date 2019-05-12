package com.caidi.springbootadvanced.MybatisDao;

import org.apache.ibatis.annotations.*;
import com.caidi.springbootadvanced.domain.MybaitsUser;
import java.util.List;

/*
mybatis添加的注解,
将dao交给spring管理
目的是减少xml的编写，
实现接口实现类。并注入spring容器
 */
@Mapper
public interface MyBatisDao{
    @Insert(value = "insert into user (uid,username,password,enabled) values(#{uid},#{username},#{password},#{enabled})")
    //主键生成策略
    @Options(useGeneratedKeys=true,keyProperty = "uid",keyColumn = "uid")
    int insert(MybaitsUser user);

    @Select(value="select * from user")
    List<MybaitsUser> listUser();

    @Select(value="select * from user where uid = #{uid}")
    MybaitsUser getUser(@Param(value="uid") Integer uid);

    //结合mybatis.xml
    List<MybaitsUser> listUsers();
}
