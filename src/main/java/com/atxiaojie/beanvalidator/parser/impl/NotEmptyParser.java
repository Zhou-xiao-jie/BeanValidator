package com.atxiaojie.beanvalidator.parser.impl;

import com.atxiaojie.beanvalidator.annotation.NotEmpty;
import com.atxiaojie.beanvalidator.parser.IAnnotationParser;
import com.atxiaojie.beanvalidator.result.ValidateResult;

import java.lang.reflect.Field;

/**
 * @ClassName: NotEmptyParser
 * @Description: 不能为空校验器
 * @author: zhouxiaojie
 * @date: 2022/2/17 18:46
 * @Version: V1.0.0
 */
public class NotEmptyParser implements IAnnotationParser{

    /**
     * @MethodsName: validate
     * @Description 校验不能为空
     * @Author zhouxiaojie
     * @Date 19:10 2022/2/17
     * @Param [f, value]
     * @return com.atxiaojie.beanvalidator.result.ValidateResult
     **/
    public ValidateResult validate(Field f, Object value) {
        ValidateResult result = new ValidateResult();
        if(f.isAnnotationPresent(NotEmpty.class)){
            NotEmpty notNull = f.getAnnotation(NotEmpty.class);
            if(value == null || value.toString().length() == 0){
                result.setMessage(notNull.fieldName() + notNull.message());
            }
        }
        return result;
    }

}
