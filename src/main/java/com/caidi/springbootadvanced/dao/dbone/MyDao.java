package com.caidi.springbootadvanced.dao.dbone;

import com.caidi.springbootadvanced.common.BaseMapper;
import com.caidi.springbootadvanced.domain.MybaitsUser;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDao extends BaseMapper<MybaitsUser> {
}
