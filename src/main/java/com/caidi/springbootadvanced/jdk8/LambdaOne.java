/**
 * Copyright (C), 2015-2019, 江小白酒业有限公司
 * FileName: LambdaOne
 * Author:   蔡迪
 * Date:     2019/4/24 11:37
 * Description: 拉姆达表达式学习
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.caidi.springbootadvanced.jdk8;


/**
 * 〈一句话功能简述1.〉<br>
 * 〈java8拉姆达表达式学习〉
 *取代匿名内部类(残缺的闭包)
 *
 * @author Administrator
 * @create 2019/4/24
 * @since 1.0.0
 */
public class LambdaOne {

    //成员变量不用定义为final
    private static int bbb = 777;

    public static void main(String[] args) {
    int aaa = 7;
    //改变值会报错。局部变量必须是final的
    //aaa=6;
        bbb=1234;
        /***
         * @Author 蔡迪
         * @Descriptio
         * 可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
         *
         * ·可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
         *
         * ·可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
         *
         * ·可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
         * @Date 16:59 2019/4/24
         * @Param [args]
         * @return void
         **/
        LambdaOne lambdaOne = new LambdaOne();

        //无参数
        NoOneParam noOneParam = ()-> {return 5;};

        //无参数  引用外层局部变量
        NoOneParam noOneParams = ()-> {return LambdaOne.bbb;};

        //无参数  引用外层局部变量
        NoOneParam noOneParamss = ()-> { bbb=666;return bbb;};
        //一个参数不需要括号
        OneParam oneParam = a-> {return a;};
        //参数类型声明
        MathOperation addition = (int a,int b)->{return a + b;};

        //参数不用类型声明
        MathOperation subtraction = (a,b)->{return a - b;};

        //接口中的返回语句
        MathOperation multiplication = (int a,int b)->{ return a * b;};

        //接口中的返回语句
        MathOperation multiplications = (int a,int b)-> a * b;


        VoidMethodInterface voidMethodInterface = (String message)->{ System.out.println("hello: "+message);};
        System.out.println("noOneParams: " + noOneParams.operation());
        System.out.println("noOneParamss: " + noOneParamss.operation());
        System.out.println(addition.operation(3,7));
        System.out.println(addition.operation(aaa,7));
        voidMethodInterface.operation("fdfdfd");

    }


    interface MathOperation{
        int operation(int a,int b);
        default int ooc(int a){return 4;}
    }

    interface OneParam{
        int operation(int a);
    }
    interface NoOneParam{
        int operation();
    }

    interface VoidMethodInterface{
        void operation(String message);
    }

}

/**
 * @Author 蔡迪
 * @Description //测试jdk8接口新特性
 * @Date 14:53 2019/4/24
 * @Param
 * @return
 **/
interface  JdkNewInterface{
    int operation(int a,int b);
    default int ooc(int a){return a*10;}
}

/**
 * @Author 蔡迪
 * @Description //实现类可以继承接口默认的方法，类似抽象类
 * @Date 15:01 2019/4/24
 * @Param
 * @return
 **/
class JdkNewInterfaceImpl implements JdkNewInterface {

    @Override
    public int operation(int a, int b) {
        return 0;
    }

    public void play(){
        System.out.println(this.ooc(10));
    }

    public static void main(String[] args) {
        new JdkNewInterfaceImpl().play();
    }
}