package com.hz.spring_aop.service.Impl;

import com.hz.spring_aop.dao.UserDao;
import com.hz.spring_aop.domain.SysUser;
import com.hz.spring_aop.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource(name = "mysqlUserDao")
    UserDao userDao = null;

    @Override
    public void insertUser(SysUser user){
        userDao.insertUser(user);
    }
}
