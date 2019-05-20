package com.caidi.springbootadvanced.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;
/*pagehelper 为mybatis添加分页插件 */
@Configuration
@MapperScan(value="com.caidi.springbootadvanced.dao.dbone")
public class MybatisConfig {
    @Bean
    public PageHelper getPageHepler(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        //参数合理化
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    //连接池
    @Bean(name = "dataSourceFinanceSource")
    @ConfigurationProperties(prefix = "spring.datasource.financesource")
    @Primary
    public DataSource DataSourceFinanceSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

    @Primary
    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // registrationBean.addInitParameter("allow", "127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)
        //registrationBean.addInitParameter("deny", ""); // IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("loginUsername", "user");
        registrationBean.addInitParameter("loginPassword", "password");
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

    @Primary
    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息.
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }

    @Primary
    @Bean(name = "sqlSessionFactoryFinanceSource")
    public SqlSessionFactory sqlSessionFactoryOne(@Qualifier("dataSourceFinanceSource") DataSource dataSource)throws Exception{
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //bean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        bean.setDataSource(dataSource);
        bean.setMapperLocations(resolver.getResources("classpath*:mybatis/dbone/*.xml"));
        bean.setTypeAliasesPackage("com.caidi.springbootadvanced.domain");
        //分页插件
//        Properties properties = new Properties();
//        properties.setProperty("helperDialect", "mysql");
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");
//        properties.setProperty("reasonable", "true");
//        Interceptor interceptor = new PageInterceptor();
//        interceptor.setProperties(properties);
//        bean.setPlugins(new Interceptor[] {interceptor});
        return bean.getObject();
    }

    @Primary
    @Bean(name = "dataSourceTransactionManagerFinanceSource")
    public DataSourceTransactionManager dataSourceTransactionManagerOne(@Qualifier("dataSourceFinanceSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "sqlSessionTemplateFinanceSource")
    public SqlSessionTemplate sqlSessionTemplateOne(@Qualifier("sqlSessionFactoryFinanceSource") SqlSessionFactory sqlSessionFactory)throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
