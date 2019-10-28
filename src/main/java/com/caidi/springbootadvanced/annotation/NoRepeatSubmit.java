package com.caidi.springbootadvanced.annotation;

import java.lang.annotation.*;

/**自定义注解*/
@Documented
@Target(value = {ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
public @interface NoRepeatSubmit {
    // 判定重复提交时间范围 单位：毫秒
    long repeatSubmitTime() default 2000;

    // 是否开始防重提交
    boolean effective() default true;
}
