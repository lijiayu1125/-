package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.po.Sponsor;
import com.quzhexiaoyuan.po.Student;
import com.quzhexiaoyuan.po.User;


public interface UserDao {

    //判断用户在数据库中是否存在，存在返回true，不存在返回false
    public boolean userIsExist(String username);

    //用户登录，返回用户身份，1为学生，2为活动举办方
    public User userLogin(String username,String password);

    //用户注册，注册成功返回User,注册失败返回null
    public User userRegister(String username,String password,int type);

}
