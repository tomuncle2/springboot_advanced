/**
 * Copyright (C), 2015-2019, 江小白酒业有限公司
 * FileName: MyListener
 * Author:   蔡迪
 * Date:     2019/4/23 16:55
 * Description: 之定义过滤器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.caidi.springbootadvanced.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈之定义过滤器〉
 *
 * @author Administrator
 * @create 2019/4/23
 * @since 1.0.0
 */
@Component
public class MyFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Author 蔡迪
     * @Description //初始化方法
     * @Date 16:56 2019/4/23
     * @Param [filterConfig]
     * @return void
     **/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @Author 蔡迪
     * @Description //过滤器链
     * @Date 16:57 2019/4/23
     * @Param [servletRequest, servletResponse, filterChain]
     * @return void
     **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest)servletRequest;
        String url = hrequest.getRequestURL().toString();
        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) servletResponse);
        //重定向
        //wrapper.sendRedirect("/login");
        logger.info("自定义过滤器测试： "+this.getClass().getName());
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     * @Author 蔡迪
     * @Description //销毁方法
     * @Date 16:56 2019/4/23
     * @Param []
     * @return void
     **/
    @Override
    public void destroy() {

    }
}