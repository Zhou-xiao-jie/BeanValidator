package com.atxiaojie.beanvalidator.validator;

import com.atxiaojie.beanvalidator.rule.Rule;
import com.atxiaojie.beanvalidator.rule.impl.AnnotationRule;

/**
 * @ClassName: Validator
 * @Description: 通用校验器，使用单例模式
 * @author: zhouxiaojie
 * @date: 2022/2/17 20:19
 * @Version: V1.0.0
 */
public enum Validator {

    INSTANCE;

    /**
     * 是否有效
     */
    private Boolean valid = true;

    /**
     * 错误信息
     */
    private String message;

    public Validator validate(Rule rule) {
        if(this.valid){
            this.valid = rule.valid();
            this.message = rule.getMessage();
        }
        return this;
    }

    public Validator validateAnnotation(Object o){
        return validate(new AnnotationRule(o));
    }

    public Validator NotEmpty(Object fieldValue, String fieldName) {
        if(this.valid){
            if(fieldValue == null || fieldValue.toString().length() == 0){
                this.valid = false;
                this.message = fieldName + "不能为空";
            }
        }
        return this;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
