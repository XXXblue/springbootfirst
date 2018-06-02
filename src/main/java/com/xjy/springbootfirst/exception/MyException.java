package com.xjy.springbootfirst.exception;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/29:55
 * @Description:
 * @Modified By:
 */


import com.xjy.springbootfirst.enums.ResultEnum;

/**
 * 这里之所以要继承Runtimeexception是因为runtimeException才会事务回滚，Exception不会
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
