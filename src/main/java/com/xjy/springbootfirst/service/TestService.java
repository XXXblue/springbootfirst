package com.xjy.springbootfirst.service;

import com.xjy.springbootfirst.pojo.Sysuser;
import org.springframework.stereotype.Service;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/219:55
 * @Description:
 * @Modified By:
 */
public interface TestService {
    public Sysuser getUserById();
    public void addUser();
}
