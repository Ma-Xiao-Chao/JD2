package com.qf.dao.impl;

import com.qf.util.Tools;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

//父类,封装所有jdbc步骤
public class BaseDao {
    private Connection conn;
    private PreparedStatement pStatement;
    private ResultSet res;


    // 增删改
    public int modify(String sql, Object... parm) {
        try {
            conn = Tools.getconnection();
            //预编译
            pStatement = conn.prepareStatement(sql);
            //假如parm值非空,遍历---占位符赋值
            for (int i = 0; i < parm.length; i++) {
                pStatement.setObject(i + 1, parm[i]);
            }
            //执行sql,获得结果集
            int result = pStatement.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Tools.close(conn, pStatement, res);
        }
        return 0;
    }


    //查询--多个
    public <T> List<T> selectAll(String sql, Class clazz, Object... parm) {
        ArrayList<T> list = new ArrayList<T>();
        try {
            conn = Tools.getconnection();
            //预编译
            pStatement = conn.prepareStatement(sql);
            //假如parm值非空,遍历---占位符赋值
            for (int i = 0; i < parm.length; i++) {
                pStatement.setObject(i + 1, parm[i]);
            }
            //执行sql,获得结果集
            res = pStatement.executeQuery();
            //结果集元数据--字段信息
            ResultSetMetaData metaData = res.getMetaData();
            int count = metaData.getColumnCount();//结果集列数
            while (res.next()) {
                //反射创建实例
                Object obj = clazz.newInstance();
                //逐列取值
                for (int i = 1; i <= count; i++) {
                    String label = metaData.getColumnLabel(i);//字段名
                    //类型的类对象
                    Class type = clazz.getDeclaredField(label).getType();
                    //方法名字d
                    String methodName = "set" + label.substring(0, 1).toUpperCase() + label.substring(1);
                    //获得方法 --setxxx
                    Method method = clazz.getDeclaredMethod(methodName, type);
                    //调用方法
                    method.invoke(obj, res.getObject(label));
                }
                list.add((T) obj);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Tools.close(conn, pStatement, res);
        }
        return null;
    }

    //查询--一行
    public <T> T selectOne(String sql, Class clazz, Object... parm) {
        try {
            conn = Tools.getconnection();
            //预编译
            pStatement = conn.prepareStatement(sql);
            //假如parm值非空,遍历---占位符赋值
            for (int i = 0; i < parm.length; i++) {
                pStatement.setObject(i + 1, parm[i]);
            }
            //执行sql,获得结果集
            res = pStatement.executeQuery();
            //结果集元数据--字段信息
            ResultSetMetaData metaData = res.getMetaData();
            int count = metaData.getColumnCount();//结果集列数
            //反射创建实例
            Object obj = clazz.newInstance();
            if (res.next()) {
                //逐列取值
                for (int i = 1; i <= count; i++) {
                    String label = metaData.getColumnLabel(i);//获得第几列字段名
                    //类的属性类型的类对象
                    Class type = clazz.getDeclaredField(label).getType();
                    //方法名字
                    String methodName = "set" + label.substring(0, 1).toUpperCase() + label.substring(1);
                    //获得方法 --setxxx
                    Method method = clazz.getDeclaredMethod(methodName, type);
                    //调用方法
                    method.invoke(obj, res.getObject(label));
                }
                return (T) obj;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Tools.close(conn, pStatement, res);
        }
        return null;
    }
}
