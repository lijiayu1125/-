package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.po.Student;
import com.quzhexiaoyuan.po.User;

import java.util.ArrayList;

public interface StudentDao {

    //获取所有学生用户的信息，用ArrayList返回
    public ArrayList<Student> queryAllStudent();

    //完善学生信息,用户注册后，调用该方法,信息完善成功返回true，失败返回false
    public boolean studentInformation(String stunum, String stuName, String major, int time, User user);

    //修改学生信息，修改成功返回true,失败返回false
    public boolean alterStudent(String stunum,String stuName,String major,int time);

    //查询学生个人信息，用User返回
    public User queryKeyStudent(String username);
}
