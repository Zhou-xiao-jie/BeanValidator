package com.atxiaojie.beanvalidator.parser.impl;

import com.atxiaojie.beanvalidator.annotation.DateFormat;
import com.atxiaojie.beanvalidator.parser.IAnnotationParser;
import com.atxiaojie.beanvalidator.result.ValidateResult;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @ClassName: DateFormatParser
 * @Description: 日期格式校验器
 * @author: zhouxiaojie
 * @date: 2022/2/17 20:07
 * @Version: V1.0.0
 */
public class DateFormatParser implements IAnnotationParser {

    /**
     * @MethodsName: validate
     * @Description 校验日期格式
     * @Author zhouxiaojie
     * @Date 20:08 2022/2/17
     * @Param [f, value]
     * @return com.atxiaojie.beanvalidator.result.ValidateResult
     **/
    public ValidateResult validate(Field f, Object value) {
        ValidateResult result = new ValidateResult();
        if(f.isAnnotationPresent(DateFormat.class)){
            DateFormat dateFormat = f.getAnnotation(DateFormat.class);
            try {
                if(value != null){
                    SimpleDateFormat format = new SimpleDateFormat(dateFormat.format());
                    format.parse(value.toString());
                }
            } catch (ParseException e) {
                result.setMessage(dateFormat.fieldName() + dateFormat.message());
            }
        }
        return result;
    }
}
