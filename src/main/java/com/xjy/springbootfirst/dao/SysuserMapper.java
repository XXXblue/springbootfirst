package com.xjy.springbootfirst.dao;


import com.xjy.springbootfirst.pojo.Sysuser;

public interface SysuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    Sysuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);
}