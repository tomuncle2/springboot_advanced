/**
 * Copyright (C), 2015-2019, 江小白酒业有限公司
 * FileName: ForEach
 * Author:   蔡迪
 * Date:     2019/4/25 13:40
 * Description: java8增强foreach
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.caidi.springbootadvanced.jdk8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈java8增强foreach〉
 *
 * @author Administrator
 * @create 2019/4/25
 * @since 1.0.0
 */
public class ForEach {
    public static void main(String[] args) {
//      List<? extends Object> list = new ArrayList<>();
        //List<? super String> list = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("dsds");list.add("zxcvf");list.add("dsdvcx");list.add("cxctr");

        //java8forEach
        list.forEach((item)->{
            System.out.println(item);
        });


        //java8stream
        list.stream().forEach(item->{
            System.out.println(item);
            System.out.printf("xx");
        });

        list.stream().forEach(System.out::println);

        //迭代器
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String element = it.next();
            if(false){
                it.remove();
            }
        }
    }

}