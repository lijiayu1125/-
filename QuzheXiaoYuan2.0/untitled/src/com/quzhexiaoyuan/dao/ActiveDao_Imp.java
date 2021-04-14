package com.quzhexiaoyuan.dao;

import com.quzhexiaoyuan.dao.ActiveDao;
import com.quzhexiaoyuan.po.Acitve;
import com.quzhexiaoyuan.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ActiveDao_Imp implements ActiveDao {


    @Override
    public ArrayList<Acitve> queryAllActive() {
        Connection conn = DbUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select * from active;";
        return null;
    }

    @Override
    public boolean insertActive(String activeName, String activeContent, String activeType, String activeplace, String activeTime, int activeGive, int activelimit) {
        return false;
    }

    @Override
    public boolean deleteActive(String activeName) {
        return false;
    }

    @Override
    public ArrayList<Acitve> queryKeyActive(String keyWord) {
        return null;
    }
}
