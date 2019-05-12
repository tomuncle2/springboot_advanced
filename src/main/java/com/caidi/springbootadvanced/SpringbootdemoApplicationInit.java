package com.caidi.springbootadvanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/*
打war包需要继承springboot初始化类，springboot自动生成，运行类
以替代spring传统项目的web.xml(tomcat等容器读取)
 */
//@EnableScheduling spring自带自动任务需要开启
@EnableCaching //开启缓存
@SpringBootApplication(exclude = {QuartzAutoConfiguration.class})
//扫描包下面的持久化类 QuartzAutoConfiguration.class
//@MapperScan(basePackages={"com.caidi.springbootadvanced.MybatisDao.*"})
public class SpringbootdemoApplicationInit extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //return super.configure(builder);
        return builder.sources(SpringbootdemoApplicationInit.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplicationInit.class,args);
    }
}
