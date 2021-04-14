package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.po.Sponsor;
import com.quzhexiaoyuan.po.User;
import com.quzhexiaoyuan.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SponsorDao_Imp implements SponsorDao {

    //获取所有活动举办方的信息，用ArrayList返回
    @Override
    public ArrayList<Sponsor> queryAllSponsor() {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from sponsor;";
        ArrayList<Sponsor> results = new ArrayList<Sponsor>();

        try {
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Sponsor sponsor = new Sponsor();
                sponsor.setAssociationName(resultSet.getString("association_name"));
                sponsor.setIntroduction(resultSet.getString("introduction"));
                sponsor.setCharge(resultSet.getString("charge"));
                sponsor.setPhoneNum(resultSet.getString("phonenum"));
                results.add(sponsor);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeConnection(conn,preparedStatement,resultSet);
        }

        return results;
    }

    //完善活动举办方信息,用户注册后，调用该方法,信息完善成功返回true，失败返回false
    @Override
    public boolean sponsorInformation(String associationName, String introduction, String charge, String phoneNum, User user) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql_user_insert = "insert into user value(null,?,?,?);";
        String sql_sponsor_insert = "insert into sponsor value(?,?,?,?,?);";

        try {
            preparedStatement = conn.prepareStatement(sql_user_insert,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setInt(3,user.getType());
            preparedStatement.executeQuery();
            resultSet =  preparedStatement.getGeneratedKeys();

            //获取主键，将用户表编号和活动举办方表编号联系在一起，便于查询
            if (!resultSet.next()){
                System.err.println("获取主键失败");
            }
            final int CUSTOMER_ID_COLUMN_INDEX = 1;
            int num = resultSet.getInt(CUSTOMER_ID_COLUMN_INDEX);

            preparedStatement = conn.prepareStatement(sql_sponsor_insert);
            preparedStatement.setInt(1,num);//编号
            preparedStatement.setString(2,associationName);//社团名
            preparedStatement.setString(3,introduction);//简介
            preparedStatement.setString(4,charge);//负责人
            preparedStatement.setString(5,phoneNum);//联系方式

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

    //修改活动举办方信息，修改成功返回true，失败返回false
    @Override
    public boolean alterSponsor(String associationName, String introduction, String charge, String phoneNum) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "update sponsor set association_name=?,introduction=?,charge=?,phonenum=? where association_name=?;";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,associationName);
            preparedStatement.setString(2,introduction);
            preparedStatement.setString(3,charge);
            preparedStatement.setString(4,phoneNum);
            preparedStatement.setString(5,associationName);

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

    //查询活动举办方个人信息，用User返回
    @Override
    public User queryKeyStudent(String username) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Sponsor user = null;
        String sql = "select * from sponsor s inner join user u on s.id=u.id where username=?;";

        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new Sponsor();
                user.setAssociationName(resultSet.getString("association_name"));//社团名
                user.setIntroduction(resultSet.getString("introduction"));//社团简介
                user.setCharge(resultSet.getString("charge"));//负责人
                user.setPhoneNum(resultSet.getString("phonenum"));//联系方式
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
