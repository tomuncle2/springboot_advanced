/**
 * Copyright (C), 2015-2019, 江小白酒业有限公司
 * FileName: MyListener
 * Author:   蔡迪
 * Date:     2019/4/23 17:23
 * Description: 自定义监听器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.caidi.springbootadvanced.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自定义监听器（session监听器）〉
 *
 * @author Administrator
 * @create 2019/4/23
 * @since 1.0.0
 */
@Component
public class MyListener implements HttpSessionListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("创建session");
        System.out.println("创建session");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("销毁session");
        System.out.println("销毁session");
    }
}