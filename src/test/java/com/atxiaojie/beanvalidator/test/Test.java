package com.atxiaojie.beanvalidator.test;

import com.atxiaojie.beanvalidator.result.ValidateResult;
import com.atxiaojie.beanvalidator.rule.impl.AnnotationRule;
import com.atxiaojie.beanvalidator.validator.Validator;

import static com.atxiaojie.beanvalidator.validator.AnnotationValidator.validate;

/**
 * @ClassName: Test
 * @Description: 测试类
 * @author: zhouxiaojie
 * @date: 2022/2/17 19:30
 * @Version: V1.0.0
 */
public class Test {
    public static void main(String[] args) {

        User user = new User();
        user.setName("wzj");
        user.setBirthday("2022-02-17-1");
        //AnnotationValidator.register(new DateFormatParser());
        ValidateResult result = validate(user);
        if(result.getValid()){
            System.out.println("校验通过");
        }else{
            System.out.println(result.getMessage());
        }

//        Validator v = Validator.INSTANCE.NotEmpty(user.getName(), "姓名").NotEmpty(user.getBirthday(), "生日");
//        if(v.getValid()){
//            System.out.println("校验通过");
//        }else{
//            System.out.println(v.getMessage());
//        }

//        Validator info = Validator.INSTANCE.validate(new AnnotationRule(user)).validate(new AnnotationRule(new User()));
//        if(info.getValid()){
//            System.out.println("校验通过");
//        }else{
//            System.out.println(info.getMessage());
//        }
    }
}
