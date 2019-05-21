package com.caidi.springbootadvanced.annotation;

import java.lang.annotation.*;
/**
 * @Author 蔡迪
 * @Description //自定义注解
 * @Date 10:40 2019/4/19
 * @Param
 * @return
 **/
@Documented
@Target(value={ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Inherited//是否子类可以继承
public @interface TestA {
    ElementType[] value();
}
