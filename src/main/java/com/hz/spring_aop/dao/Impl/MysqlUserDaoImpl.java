package com.hz.spring_aop.dao.Impl;

import com.hz.spring_aop.dao.UserDao;
import com.hz.spring_aop.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository("mysqlUserDao")
public class MysqlUserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser sysUser) {
        System.out.println("Mysql插入用户");
    }
}
