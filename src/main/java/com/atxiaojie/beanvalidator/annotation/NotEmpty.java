package com.atxiaojie.beanvalidator.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: NotEmpty
 * @Description: 不能为空注解定义
 * @author: zhouxiaojie
 * @date: 2022/2/17 18:46
 * @Version: V1.0.0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty{

    /**
     * @MethodsName: fieldName
     * @Description 字段名称
     * @Author zhouxiaojie
     * @Date 19:17 2022/2/17
     * @Param []
     * @return java.lang.String
     **/
    public String fieldName();

    /**
     * @MethodsName: message
     * @Description 提示语
     * @Author zhouxiaojie
     * @Date 19:17 2022/2/17
     * @Param []
     * @return java.lang.String
     **/
    public String message() default "不能为空";
}
