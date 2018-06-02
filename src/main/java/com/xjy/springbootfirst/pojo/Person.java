package com.xjy.springbootfirst.pojo;

import com.sun.xml.internal.ws.api.model.MEP;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/119:56
 * @Description:
 * @Modified By:
 */
public class Person {
    @NotBlank(message = "名字不能空")
    private String name;
    @NotNull(message = "年龄不能空")
    @Min(value = 18,message = "太小了")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
