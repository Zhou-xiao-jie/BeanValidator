package com.atxiaojie.beanvalidator.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: IAnnotationParser
 * @Description: 注解解析器枚举
 * @author: zhouxiaojie
 * @date: 2022/2/17 18:46
 * @Version: V1.0.0
 */
public enum AnnotationParserEnum {

    DATA_FORMAT(1,"com.atxiaojie.beanvalidator.parser.impl.DateFormatParser"),
    NOT_EMPTY(2, "com.atxiaojie.beanvalidator.parser.impl.NotEmptyParser");

    private int value;
    private String clazz;

    AnnotationParserEnum(int value, String clazz) {
        this.value = value;
        this.clazz = clazz;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public static Map<Integer, String> getAllClazz() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (AnnotationParserEnum msgEnum : AnnotationParserEnum.values()) {
            map.put(msgEnum.getValue(), msgEnum.getClazz());
        }
        return map;
    }
}
