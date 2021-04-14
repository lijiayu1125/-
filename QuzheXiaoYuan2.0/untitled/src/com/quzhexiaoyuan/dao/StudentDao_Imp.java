package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.dao.StudentDao;
import com.quzhexiaoyuan.po.Student;
import com.quzhexiaoyuan.po.User;
import com.quzhexiaoyuan.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDao_Imp implements StudentDao {

    //获取所有学生用户的信息，用ArrayList返回
    @Override
    public ArrayList<Student> queryAllStudent() {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from student;";
        ArrayList<Student> results = new ArrayList<Student>();

        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Student student = new Student();
                student.setStunum(resultSet.getString("studentnum"));
                student.setStuName(resultSet.getString("stuname"));
                student.setMajor(resultSet.getString("major"));
                student.setTime(resultSet.getInt("time"));
                results.add(student);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,preparedStatement,resultSet);
        }
        return results;
    }


    //完善学生信息,用户注册后，调用该方法,信息完善成功返回true，失败返回false
    @Override
    public boolean studentInformation(String stunum, String stuName, String major, int time,User user) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql_user_insert = "insert into user value(null,?,?,?);";
        String sql_student_insert = "insert into student value(?,?,?,?,?);";

        try {
            preparedStatement = conn.prepareStatement(sql_user_insert,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getType());
            preparedStatement.executeUpdate();
            resultSet =  preparedStatement.getGeneratedKeys();

            //获取主键，将用户表编号和学生表编号联系在一起，便于查询
            if (!resultSet.next()){
                System.err.println("获取主键失败");
            }
            final int CUSTOMER_ID_COLUMN_INDEX = 1;
            int num = resultSet.getInt(CUSTOMER_ID_COLUMN_INDEX);

            preparedStatement = conn.prepareStatement(sql_student_insert);
            preparedStatement.setInt(1,num);//编号
            preparedStatement.setString(2,stunum);//学号
            preparedStatement.setString(3,stuName);//学生姓名
            preparedStatement.setString(4,major);//专业
            preparedStatement.setInt(5,0);//时长

            int check = preparedStatement.executeUpdate();
            if(check > 0){
                return true;//写入数据库成功
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,preparedStatement,resultSet);
        }
        return false;
    }

    //修改学生信息，修改成功返回true,失败返回false
    @Override
    public boolean alterStudent(String stunum, String stuName, String major, int time) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "update student set studentnum=?,stuname=?,major=?,time=? where studentnum=?;";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,stunum);
            preparedStatement.setString(2,stuName);
            preparedStatement.setString(3,major);
            preparedStatement.setInt(4,time);
            preparedStatement.setString(5,stunum);

            int check = preparedStatement.executeUpdate();
            if(check > 0){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,preparedStatement,resultSet);
        }

        return false;
    }

    //查询学生个人信息，用User返回
    @Override
    public User queryKeyStudent(String username) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Student user = null;
        String sql = "select * from student s inner join user u on s.id=u.id where username=?;";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new Student();
                user.setStunum(resultSet.getString("studentnum"));//学号
                user.setStuName(resultSet.getString("stuname"));//姓名
                user.setMajor(resultSet.getString("major"));//专业
                user.setTime(resultSet.getInt("time"));//时长
                return user;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,preparedStatement,resultSet);
        }

        return null;
    }
}
