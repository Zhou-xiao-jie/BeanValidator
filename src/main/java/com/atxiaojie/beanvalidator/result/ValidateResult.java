package com.atxiaojie.beanvalidator.result;

/**
 * @ClassName: ValidateResult
 * @Description: 校验返回结果实体
 * @author: zhouxiaojie
 * @date: 2022/2/17 19:03
 * @Version: V1.0.0
 */
public class ValidateResult {

    /**
     * 是否通过
     */
    private Boolean valid;

    /**
     * 错误信息
     */
    private String message;

    public ValidateResult() {
        this.valid = true;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.valid = false;
        this.message = message;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
