package com.caidi.springbootadvanced.controller;

import com.caidi.springbootadvanced.domain.MybaitsUser;
import com.caidi.springbootadvanced.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "cache/v1")
public class RedisController {

    @Resource
    private RedisService redisService;

    @GetMapping(value = "listAllMybatisuser")
    public List<MybaitsUser> listAllMybatisuser(){
        List<MybaitsUser> list =  redisService.listMybatisUser();
        return list;
    }

    @GetMapping(value = "saveMybatisuser")
    public Object saveMybatisuser(){
        MybaitsUser mybaitsUser = new MybaitsUser();
        mybaitsUser.setUsername("浩克2号");
        mybaitsUser.setPassword("5594924343");
        mybaitsUser.setEnabled(1);
        return redisService.saveAndCache(mybaitsUser);
    }
}
