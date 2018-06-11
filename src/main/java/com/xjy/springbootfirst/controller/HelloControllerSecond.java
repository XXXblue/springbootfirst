package com.xjy.springbootfirst.controller;

import com.xjy.springbootfirst.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/1119:01
 * @Description:
 * @Modified By:
 */
@Controller
public class HelloControllerSecond {

    //测试freemaker
    @RequestMapping(value = "/test4")
    public String test4(ModelMap modelMap){
        //freemaker渲染失败
        Person person  = new Person();
        person.setName("kkk");
        modelMap.put("person",person);
        return "hello";
    }
}
