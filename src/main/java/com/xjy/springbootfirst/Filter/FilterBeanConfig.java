package com.xjy.springbootfirst.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/215:13
 * @Description:  配置filter
 * @Modified By:
 */
@Configuration
public class FilterBeanConfig {
    @Bean
    public FilterRegistrationBean logFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //配置拦截器
        filterRegistrationBean.setFilter(new LogFilter());
        List<String> urList = new ArrayList<>();
        //配置拦截规则
        urList.add("*");
        filterRegistrationBean.setUrlPatterns(urList);
        return filterRegistrationBean;
    }
}
