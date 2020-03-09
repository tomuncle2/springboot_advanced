//package com.caidi.springbootadvanced.component.aspect;
//
//import com.caidi.springbootadvanced.annotation.NoRepeatSubmit;
//import com.caidi.springbootadvanced.domain.Result;
//import com.caidi.springbootadvanced.util.RedisLock;
//import com.caidi.springbootadvanced.util.RequestUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.UUID;
//
//
//@Component
//@Aspect
//@Slf4j
//public class RepeatSubmitAspect {
//    @Autowired
//    private RedisLock redisLock;
//
//    // springaop目前只能切入方法
//    @Pointcut(value="@annotation(noRepeatSubmits)")
//    public void pointHere(NoRepeatSubmit noRepeatSubmits){
//
//    }
//
//    @Around(value = "pointHere(noRepeatSubmit)")
//    public Object noRepeatSubmitAspect(NoRepeatSubmit noRepeatSubmit, ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        // 方法切点的参数
//        Object[] objects = proceedingJoinPoint.getArgs();
//        // 是否开始重复提交验证
//        boolean  effective = noRepeatSubmit.effective();
//        // 判定时间
//        long locktime = noRepeatSubmit.repeatSubmitTime();
//        //
//        HttpServletRequest httpServletRequest = RequestUtils.getRequest();
//        String token = httpServletRequest.getHeader("Authorization");
//        String url = httpServletRequest.getRequestURL().toString();
//        // 按照某种规则生成key
//        String key = token+url;
//        String clientId = getClientId();
//
//        boolean isSuccess = redisLock.tryLock(key, clientId, locktime/1000);
//        log.info("tryLock key = [{}], clientId = [{}]", key, clientId);
//
//        if (isSuccess) {
//            log.info("tryLock success, key = [{}], clientId = [{}]", key, clientId);
//            // 获取锁成功
//            Object result;
//
//            try {
//                // 执行进程
//                result = proceedingJoinPoint.proceed();
//            } finally {
//                // 解锁
//                redisLock.releaseLock(key, clientId);
//                log.info("releaseLock success, key = [{}], clientId = [{}]", key, clientId);
//            }
//
//            return result;
//
//        } else {
//            // 获取锁失败，认为是重复提交的请求
//            log.info("tryLock fail, key = [{}]", key);
//            return  Result.failure("200","重复请求，请稍后再试");
//        }
//
//    }
//
//    private String getKey(String token, String path) {
//        return token + path;
//    }
//
//    private String getClientId() {
//        return UUID.randomUUID().toString();
//    }
//
//}
