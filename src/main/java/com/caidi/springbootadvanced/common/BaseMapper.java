package com.caidi.springbootadvanced.common;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/*
注意这个basedao不能被扫描到，否者报错
*/
public interface BaseMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
