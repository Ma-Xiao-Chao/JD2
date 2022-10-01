package com.qf.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Tools {
    private static String URL;
    private static String USERNAME;
    private static String PASSWORD;

    static {
//            创建对象
        Properties properties = new Properties();
//            加载文件
        InputStream is = Tools.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
//            获得值
        URL = properties.getProperty("url");
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");

        //加载驱动
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获得连接
    public static Connection getconnection() {
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭连接
    public static void close(Connection conn, Statement statement, ResultSet res) {

        try {
            if (res != null) {
                res.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
