package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.dao.UserDao;
import com.quzhexiaoyuan.po.User;
import com.quzhexiaoyuan.utils.DbUtils;
import jakarta.servlet.http.HttpServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao_Imp extends HttpServlet implements UserDao  {
    private static final long serialVersionUID = 1L;

    private String action;
    //查询用户是否存在

    @Override
    public boolean userIsExist(String username) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from user where username=?;";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;//存在该用户
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,preparedStatement,resultSet);
        }
        return false;

    }


    //用户登录，返回用户身份，1为学生，2为活动举办方
    @Override
    public User userLogin(String username, String password) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        String sql = "select * from user where username = ? and password = ?;";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setType(resultSet.getInt("type"));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DbUtils.closeConnection(conn,preparedStatement,resultSet);
        }

        return null; //密码或用户名错误
    }


    //用户注册，注册成功返回User,注册失败返回null,还没有写进数据库中，需要根据实际身份继续完善信息后写进数据库中
    @Override
    public User userRegister(String username, String password,int type) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        //判断数据库中是否存在该用户
        if(userIsExist(username)){//
            user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setType(type);

            if (type == 1){
                StudentDao_Imp studentDaoImp = new StudentDao_Imp();
                studentDaoImp.studentInformation()
            }
        }

        return null;
    }
}
