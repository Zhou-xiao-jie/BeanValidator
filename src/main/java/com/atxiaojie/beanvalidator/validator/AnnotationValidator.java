package com.atxiaojie.beanvalidator.validator;

import com.atxiaojie.beanvalidator.enums.AnnotationParserEnum;
import com.atxiaojie.beanvalidator.parser.IAnnotationParser;
import com.atxiaojie.beanvalidator.result.ValidateResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @ClassName: AnnotationValidator
 * @Description: 注解校验器
 * @author: zhouxiaojie
 * @date: 2022/2/17 19:24
 * @Version: V1.0.0
 */
public class AnnotationValidator {

    private static final Logger log = Logger.getLogger(AnnotationValidator.class.getName());

    private final static List<IAnnotationParser> PARSER_LIST = new ArrayList<IAnnotationParser>();

    static {
        if(AnnotationParserEnum.values().length > 0){
            for(AnnotationParserEnum type : AnnotationParserEnum.values()){
                PARSER_LIST.add(getInstance(type.getValue()));
            }
        }
    }

    /**
     * @MethodsName: validate
     * @Description 遍历所有字段，用所有解析器进行校验，如果校验失败，则终止校验返回结果，如果校验成功，同样返回校验结果
     * @Author zhouxiaojie
     * @Date 19:26 2022/2/17
     * @Param [t]
     * @return com.atxiaojie.beanvalidator.result.ValidateResult
     **/
    public static <T> ValidateResult validate(T t){
        ValidateResult result = null;
        for (Field f : t.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            Object value = null;
            try {
                value = f.get(t);
            } catch (IllegalArgumentException e) {
                log.log(Level.SEVERE, "Exception", e);
            } catch (IllegalAccessException e) {
                log.log(Level.SEVERE, "Exception", e);
            }
            for (IAnnotationParser va : PARSER_LIST) {
                result = va.validate(f, value);
                if(!result.getValid()){
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * @MethodsName: getInstance
     * @Description 利用clazz创建对象
     * @Author zhouxiaojie
     * @Date 22:11 2022/2/17
     * @Param [value]
     * @return com.atxiaojie.beanvalidator.parser.IAnnotationParser
     **/
    public static IAnnotationParser getInstance(Integer value){
        IAnnotationParser inter = null;
        Map<Integer, String> allClazz = AnnotationParserEnum.getAllClazz();
        String clazz = allClazz.get(value);
        if (value !=null) {
            try {
                try {
                    //调用无参构造器创建实例
                    inter = (IAnnotationParser) Class.forName(clazz).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return inter;
    }

    /**
     * @MethodsName: register
     * @Description 注册解析器
     * @Author zhouxiaojie
     * @Date 19:26 2022/2/17
     * @Param [parser]
     * @return void
     **/
    public static void register(IAnnotationParser parser){
        PARSER_LIST.add(parser);
    }
}
