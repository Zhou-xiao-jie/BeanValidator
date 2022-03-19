package com.atxiaojie.beanvalidator.test;

import com.atxiaojie.beanvalidator.annotation.DateFormat;
import com.atxiaojie.beanvalidator.annotation.NotEmpty;

/**
 * @ClassName: User
 * @Description: TODO
 * @author: zhouxiaojie
 * @date: 2022/2/17 19:32
 * @Version: V1.0.0
 */
public class User {

    private Long id;

    @NotEmpty(fieldName="姓名")
    private String name;

    @NotEmpty(fieldName = "生日")
    @DateFormat(fieldName="生日", format="yyyy-MM-dd", message = "格式不正确")
    private String birthday;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
