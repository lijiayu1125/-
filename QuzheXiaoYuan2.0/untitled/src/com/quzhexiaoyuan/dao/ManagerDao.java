package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.po.Sponsor;
import com.quzhexiaoyuan.po.Student;

import java.util.ArrayList;

public interface ManagerDao {

    //获取用户身份,若存在则返回该用户的身份，不存在则返回-1
    public int getUserType(String username);

    //获取所有学生用户的信息，用ArrayList返回
    public ArrayList<Student> queryAllStudent();

    //获取所有活动举办方的信息，用ArrayList返回
    public ArrayList<Sponsor> queryAllSponsor();

    //删除用户信息，删除成功返回true,失败则返回false
    public boolean deleteUser();

    //修改用户信息，修改成功返回true,失败则返回false
    public boolean alterUser();
}
