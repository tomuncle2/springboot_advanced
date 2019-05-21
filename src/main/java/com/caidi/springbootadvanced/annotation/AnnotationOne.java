package com.caidi.springbootadvanced.annotation;



import java.lang.annotation.*;
import com.caidi.springbootadvanced.enums.Colors;
@Documented
@Target(value={ElementType.FIELD,ElementType.TYPE})
@Retention(value=RetentionPolicy.RUNTIME)
@Inherited
public @interface AnnotationOne {

    public String[] sex() default "";

    public Colors colors() default Colors.RED;

    public Colors[] colorss() default {Colors.RED,Colors.BLACK};

    //ElementType[] type();
}
