/**
 * Copyright (C), 2015-2019, 江小白酒业有限公司
 * FileName: MethodReference
 * Author:   蔡迪
 * Date:     2019/4/25 10:51
 * Description: 方法引用
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.caidi.springbootadvanced.jdk8;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉<br> 
 * 〈方法引用2〉
 *语法:
 * @author Administrator
 * @create 2019/4/25
 * @since 1.0.0
 */
public class MethodReference {


    public static void main(String[] args) {
        String[] s = new String[]{"d","ds","dds"};
        //lambda表达式 方法的引用   Comparator接口的引用
        //Arrays.sort(s,(s1,s2)->{return s1.compareTo(s2);});
        Arrays.sort(s,String::compareTo);
        for(String ss:s){
            System.out.println(ss);
        }


       // System.out.println(Arrays.stream(s).forEach(s));
      //Class o =  System.out::println;
    }

    //interface com
}