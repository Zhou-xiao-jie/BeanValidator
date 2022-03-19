package com.atxiaojie.beanvalidator.parser;

import com.atxiaojie.beanvalidator.result.ValidateResult;

import java.lang.annotation.Annotation;

/**
 * @ClassName: AbstractConstraintValidator
 * @Description: 约束验证器接口
 * @author: zhouxiaojie
 * @date: 2022/2/23 10:15
 * @Version: V1.0.0
 */
public interface ConstraintValidator<A extends Annotation, T> {

    void initialize(A annotation);

    ValidateResult validate(T t);
}
