package com.hz.spring_aop.dao;

import com.hz.spring_aop.domain.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    public void insertUser(SysUser sysUser);
}
