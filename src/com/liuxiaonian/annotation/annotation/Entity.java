package com.liuxiaonian.annotation.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Entity {
    //注解name属性，没有默认值, 使用时必须设置该属性
    String name();

    //注解tableName属性，默认值为"",表示可以不设置该属性
    String tableName() default "";
}
