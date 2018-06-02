package com.xjy.springbootfirst.service.impl;

import com.xjy.springbootfirst.dao.SysuserMapper;
import com.xjy.springbootfirst.pojo.Sysuser;
import com.xjy.springbootfirst.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: XBlue
 * @Date: Create in 2018/6/219:55
 * @Description:
 * @Modified By:
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private SysuserMapper sysuserMapper;

    @Override
    public Sysuser getUserById() {
        return sysuserMapper.selectByPrimaryKey(1);
    }

    @Override
    @Transactional
    public void addUser() {
        Sysuser sysuser = new Sysuser();
        sysuser.setUsername("第一");
        sysuser.setUserid("dy");
        sysuser.setGroupid(1);
        sysuserMapper.insertSelective(sysuser);
//        int i = 1/0;
    }
}
