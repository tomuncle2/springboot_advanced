package com.caidi.springbootadvanced.dao.dbone;

import org.springframework.stereotype.Repository;

@Repository
public interface MyDao<MybaitsUser> extends BaseMapper<MybaitsUser> {
}
