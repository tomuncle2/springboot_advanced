package com.caidi.springbootadvanced.config;

import com.caidi.springbootadvanced.filter.MyFilter;
import com.caidi.springbootadvanced.interceptor.MyInterceptor;
import com.caidi.springbootadvanced.listener.MyListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*配置mvc*/
@SpringBootConfiguration
public class MyWebMvcConfig implements WebMvcConfigurer {

    //自定义的拦截器
    @Autowired
    private MyInterceptor myInterceptor;


    @Autowired
    private MyFilter myFilter;

    @Autowired
    private MyListener myListener;


    /**注册自定义拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/**");
    }

    /**注册自定义过滤器 过滤器链：添加先后顺序，依次执行*/
    @SuppressWarnings(value = {"rawtypes", "unchecked"})
    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean filterRegistrationBean  = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(myFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    /**注册自定义监听器 appcontext session servlet*/
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletListenerRegistrationBean listenerRegist() {
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(myListener);
        System.out.println("listener");
        return servletListenerRegistrationBean;
    }

    /**跨域访问设置 所有域名 所有头 所有方法*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods("POST","GET");
    }

    /**日期处理*/
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    /**URI到视图的映射*/
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addRedirectViewController("/testview","/test.html");
//    }
}
