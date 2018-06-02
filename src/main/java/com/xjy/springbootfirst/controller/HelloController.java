package com.xjy.springbootfirst.controller;

import com.xjy.springbootfirst.pojo.Person;
import com.xjy.springbootfirst.pojo.vo.PersonQueryVo;
import com.xjy.springbootfirst.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/116:35
 * @Description:
 * @Modified By:
 */
@RestController
public class HelloController {
    @Value("${cupSize}")
    private Integer cupSize;
    @Value("${content}")
    private String content;
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public String say(){
        return content+girlProperties.getCupSize()+girlProperties.getAge();
    }
    //这种方式校验规则可以生效
    @PostMapping(value = "/person")
    public String ok(@Valid Person person, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return "error";
        }
        System.out.println(person.getAge()+"-"+person.getName() );
        return "ok";
    }

    //注解不能继承，因此失效，解决方法就是只能在业务层多个if来判断过滤
    @PostMapping(value = "/person2")
    public String ok2(@Valid PersonQueryVo personQueryVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return "error";
        }
        System.out.println(personQueryVo.getPersonCustom().getAge()+"==="+personQueryVo.getPersonCustom().getName());
        return "ok";
    }
}