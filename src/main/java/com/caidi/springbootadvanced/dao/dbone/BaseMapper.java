package com.caidi.springbootadvanced.dao.dbone;

import org.apache.poi.ss.formula.functions.T;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T> extends MySqlMapper<T>, Mapper<T> {
}
