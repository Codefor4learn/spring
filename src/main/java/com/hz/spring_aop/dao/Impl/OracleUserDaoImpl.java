package com.hz.spring_aop.dao.Impl;

import com.hz.spring_aop.dao.UserDao;
import com.hz.spring_aop.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository("oracleUserDao")
public class OracleUserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser sysUser) {
        System.out.println("Oracle插入用户");
    }
}
