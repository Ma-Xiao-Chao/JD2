package com.qf.util;

import java.sql.*;

public class BaseDaoPlus {
    //    采用单例设计模式处理参数文件读取问题，通过Properties的getProperty（）方法加载指定的key的值
    final static String DRIVER = Env.getInstance().getProperty("driver");
    final static String URL = Env.getInstance().getProperty("url");
    final static String USERNAME = Env.getInstance().getProperty("username");
    final static String PASSWORD = Env.getInstance().getProperty("password");
    protected Connection connection = null;
    protected PreparedStatement pstmt = null;
    protected ResultSet rs = null;

    static{//通过静态块确保驱动只加载一次
        try {
            Class.forName(DRIVER);//1
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //    获取连接，并赋值给成员变量

    /**
     * 复习限定词
     * public  公共
     * protected  子类可见
     * default   同包子类可见
     * private   私有
     */
    public  void getConnection(){
        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    //   释放资源
    public  void closeAll(){
        try {//7
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(connection!=null) connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
