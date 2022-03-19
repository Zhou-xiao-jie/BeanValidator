package com.atxiaojie.beanvalidator.parser.impl;

import com.atxiaojie.beanvalidator.parser.ConstraintValidator;
import com.atxiaojie.beanvalidator.result.ValidateResult;

import java.lang.annotation.Annotation;

/**
 * @ClassName: AbstractConstraintValidator
 * @Description: TODO
 * @author: zhouxiaojie
 * @date: 2022/2/23 15:56
 * @Version: V1.0.0
 */
public abstract class AbstractConstraintValidator<A extends Annotation, T> implements ConstraintValidator<A, T> {

    public A annotation;

    public void initialize(A annotation) {
        this.annotation = annotation;
    }

    public ValidateResult validate(T t) {
        return null;
    }
}
