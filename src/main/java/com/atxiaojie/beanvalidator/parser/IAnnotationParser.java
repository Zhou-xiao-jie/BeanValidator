package com.atxiaojie.beanvalidator.parser;

import com.atxiaojie.beanvalidator.result.ValidateResult;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @ClassName: IAnnotationParser
 * @Description: 校验框架注解解析器接口，实现该接口构建解析器，理论上每一个注解都会对应一个解析器， 解析器需要在校验器中注册使用
 * @author: zhouxiaojie
 * @date: 2022/2/17 18:46
 * @Version: V1.0.0
 */
public interface IAnnotationParser {

    /**
     * @MethodsName: validate
     * @Description 校验一个字段f的值是否符合基于value的某一个规则，并且把校验结果保存在ValidateResult中返回
     * @Author zhouxiaojie
     * @Date 19:10 2022/2/17
     * @Param [f, value]
     * @return com.atxiaojie.beanvalidator.result.ValidateResult
     **/
    public ValidateResult validate(Field f, Object value);
}
