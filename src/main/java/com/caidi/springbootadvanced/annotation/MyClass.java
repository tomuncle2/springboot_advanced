/**
 * Copyright (C), 2015-2019, 江小白酒业有限公司
 * FileName: MyClass
 * Author:   蔡迪
 * Date:     2019/4/19 10:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.caidi.springbootadvanced.annotation;


import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


/**
 * 〈自定义注解测试〉<br>
 * 〈〉
 *
 * @author Administrator
 * @create 2019/4/19
 * @since 1.0.0
 */
@TestA(value ={ElementType.FIELD})
public class MyClass {
    @TestA(value ={ElementType.FIELD})
    public  static ElementType[] e;
    @TestA(value ={ElementType.FIELD})
    public static void main(String[] args) {
        System.out.println("");
        ElementType[] elementTypes = {ElementType.FIELD,ElementType.METHOD};
        ElementType[] elementTypesss = new ElementType[]{};
        MyClass myClass = new MyClass();
//        for(int i = 0;i<=myClass.e.length;i++){
//            System.out.println(myClass.e[i].name());
//        }
        Class classz = myClass.getClass();
        Field[] entityFields = classz.getDeclaredFields();
        for (Field field : entityFields) {
            //判断是否加入注解 失败
            if (field.isAnnotationPresent(TestA.class)) {
                TestA testA = field.getAnnotation(TestA.class);
                System.out.println(testA.value()+" : ");
            }
        }

    }
}

class Tt{
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class classz = myClass.getClass();
        Field[] entityFields = classz.getDeclaredFields();
        Method[] me = classz.getMethods();
        for (Field field : entityFields) {
            if (field.isAnnotationPresent(TestA.class)) {
                TestA testA = field.getAnnotation(TestA.class);
                System.out.println(testA.value()+" : ");
            }
        }
    }
}