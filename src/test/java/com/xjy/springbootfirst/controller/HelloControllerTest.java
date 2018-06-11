package com.xjy.springbootfirst.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/520:36
 * @Description: 测试模块
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class HelloControllerTest {
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }
    @Test
    public void getHello() throws Exception {
        //一般这种前端测试没必要写代码，用postman即可
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
//                期望返回是200响应
                .andExpect(MockMvcResultMatchers.status().isOk())
//                打印出一些请求响应信息
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}