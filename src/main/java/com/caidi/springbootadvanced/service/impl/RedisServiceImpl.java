package com.caidi.springbootadvanced.service.impl;

import com.caidi.springbootadvanced.dao.dbone.MyBatisDao;
import com.caidi.springbootadvanced.dao.dbone.MyDao;
import com.caidi.springbootadvanced.domain.MybaitsUser;
import com.caidi.springbootadvanced.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private MyDao myDao;

    @Resource
    private MyBatisDao myBatisDao;

    /*
    先查询key是否存在存在就不会执行方法，否者执行方法 返回值会被作为value缓存
    * */
    @Override
    @Cacheable(value = {"redisManagerOne"},key = "targetClass + methodName")
    public List<MybaitsUser> listMybatisUser() {
        Example example = new Example(MybaitsUser.class);
        //排序对象
        Example.OrderBy orderBy = example.orderBy("uid");
        orderBy.desc();
        List<MybaitsUser> mybaitsUsers = myDao.selectByExample(example);
        log.info("存入了缓存");
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

    /*
    删除
     */
    @Override
    @CacheEvict(value = {"redisManagerOne"},key = "targetClass + methodName+#id")
    public int remove(Integer id) {
        Example example = new Example(MybaitsUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uid",id);
        myDao.deleteByExample(example);
        return 1;
    }

    @Override
    @CacheEvict(value = {"redisManagerOne"},key = "targetClass + methodName+#id")
    public int removeAll() {
        myDao.deleteByExample("");
        return 1;
    }

    /*
    方法一定会被执行，且会被缓存 主要用于更新
     */
    @Override
    @CachePut(value = {"redisManagerOne"},key = "targetClass + methodName")
    public MybaitsUser update(MybaitsUser mybaitsUser) {
        MybaitsUser mybatisUser1 = myDao.selectByPrimaryKey(mybaitsUser);
        if(null!=mybatisUser1){
            myDao.updateByPrimaryKeySelective(mybaitsUser);
        }
        return mybatisUser1;
    }

    @Override
    public int insert(MybaitsUser mybaitsUser) {
        /**/
        myDao.insert(mybaitsUser);
        return 1;
    }



    //若key重复则会报错
    @Cacheable(value={"redisManagerOne"},key = "targetClass + methodName+#p0.uid")
    public MybaitsUser saveAndCache(MybaitsUser mybaitsUser) {
        //mybaitsUser.setUid(UUID.randomUUID());
        log.info("存入缓存 key: rediskey2 value:reer434");
        //stringRedisTemplate.opsForValue().append("rediskey2","reer434");
        myBatisDao.insert(mybaitsUser);
        return mybaitsUser;
    }


    public int save(MybaitsUser mybaitsUser) {
        /**/
        //mybaitsUser.setUid(UUID.randomUUID());
        log.info("存入缓存 key: rediskey2 value:reer434");
        //stringRedisTemplate.opsForValue().set(mybaitsUser.getUsername()+ System.currentTimeMillis(),"reer434");
        //十分钟
        redisTemplate.opsForValue().set(mybaitsUser.getUsername()+ System.currentTimeMillis(),"reer434",10,TimeUnit.HOURS);
        return 1;
    }

}
