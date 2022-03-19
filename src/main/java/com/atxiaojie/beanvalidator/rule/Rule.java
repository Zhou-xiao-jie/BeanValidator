package com.atxiaojie.beanvalidator.rule;

/**
 * @ClassName: Rule
 * @Description: 校验规则，用于扩展校验规则
 * @author: zhouxiaojie
 * @date: 2022/2/17 18:46
 * @Version: V1.0.0
 */
public interface Rule {

    /**
     * @MethodsName: getMessage
     * @Description 错误信息
     * @Author zhouxiaojie
     * @Date 19:20 2022/2/17
     * @Param []
     * @return java.lang.String
     **/
    public String getMessage();

    /**
     * @MethodsName: valid
     * @Description 是否通过
     * @Author zhouxiaojie
     * @Date 19:21 2022/2/17
     * @Param []
     * @return java.lang.Boolean
     **/
    public Boolean valid();
}
