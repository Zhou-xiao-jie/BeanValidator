package com.atxiaojie.beanvalidator.rule.impl;

import com.atxiaojie.beanvalidator.result.ValidateResult;
import com.atxiaojie.beanvalidator.rule.Rule;
import com.atxiaojie.beanvalidator.validator.AnnotationValidator;

/**
 * @ClassName: AnnotationRule
 * @Description: 使用AnnotationValidator的校验规则
 * @author: zhouxiaojie
 * @date: 2022/2/17 19:21
 * @Version: V1.0.0
 */
public class AnnotationRule implements Rule {

    private String message;
    private Object object;

    public AnnotationRule(Object o) {
        this.object = o;
    }

    public String getMessage() {
        return message;
    }

    public Boolean valid() {
        ValidateResult result = AnnotationValidator.validate(this.object);
        this.message = result.getMessage();
        return result.getValid();
    }
}
