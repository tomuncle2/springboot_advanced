package com.caidi.springbootadvanced;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;


/*
实现CommandLineRunner  启动时可以初始化run方法
 */
//@SpringBootApplication(exclude = {QuartzAutoConfiguration.class})
//@EnableScheduling
//@EnableCaching
//@ConditionalOnClass
public class SpringbootdemoApplication implements CommandLineRunner{

//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(SpringbootdemoApplication.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        app.run(args);
//        //SpringApplication.run(SpringbootdemoApplication.class, args);
//    }

    /**
     * springboot启动初始化方法
     * */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("springboot启动初始化数据=========");
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootdemoApplication.class);
        app.run(args);
    }
}
