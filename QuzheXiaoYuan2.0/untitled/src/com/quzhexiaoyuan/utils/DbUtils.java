package com.quzhexiaoyuan.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DbUtils {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        InputStream resourceAsStream = DbUtils.class.getClassLoader().getResourceAsStream("db.properties");

        Properties p = new Properties();
        try {
            p.load(resourceAsStream);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");

            //加载驱动
            Class.forName(driver);
            System.out.println("驱动加载成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获得连接对象
    public static Connection getConnection(){
        try {
            System.out.println("数据库连接成功！");
            return DriverManager.getConnection(url,username,password);
        } catch (SQLException throwables) {
            System.out.println("数据库连接失败！");
            throwables.printStackTrace();
        }
        return null;
    }

    //释放资源
    public static void closeConnection(Connection conn, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
                resultSet = null;
            }
            if(statement != null){
                statement.close();
                statement = null;
            }
            if(conn != null){
                conn.close();
                conn = null;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
