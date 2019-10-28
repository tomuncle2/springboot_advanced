package com.caidi.springbootadvanced.component.aspect;

import com.caidi.springbootadvanced.util.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
@Slf4j
public class RepeatSubmitAspect {
    private RedisLock redisLock;

    @Before("")
}
