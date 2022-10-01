package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.pojo.CartItem;
import com.qf.pojo.OrderInfo;
import com.qf.util.BaseDaoPlus;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

public class OrderDaoImpl extends BaseDaoPlus implements OrderDao {

//    @Override
//    public int cart2db(OrderInfo orderInfo) {
//        String sql="INSERT INTO orderinfo VALUES(?,?,?,?,?,?,?,?)";
//        return modify(sql,orderInfo.getOid(),orderInfo.getUsid(),orderInfo.getAddress(),orderInfo.getPhone(),orderInfo.getZip(),orderInfo.getStatus()
//        ,orderInfo.getAcceptName(),orderInfo.getZprice());
//

    @Override
    public boolean cart2db(OrderInfo orderInfo, Collection<CartItem> cartItem) {
        try {
            getConnection();
            connection.setAutoCommit(false);
            //1info
            String sql = "INSERT INTO orderinfo VALUES(?,?,?,?,?,?,?,?)";
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, 0);
            pstmt.setInt(2, orderInfo.getUsid());
            pstmt.setString(3, orderInfo.getAddress());
            pstmt.setString(4, orderInfo.getPhone());
            pstmt.setString(5, orderInfo.getZip());
            pstmt.setInt(6, orderInfo.getStatus());
            pstmt.setString(7, orderInfo.getAcceptName());
            pstmt.setFloat(8, orderInfo.getZprice());
            int i = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            int oid =0;
            if(rs.next()){
//                获取上面写订单得主键
                oid = rs.getInt(1);
            }
            //          2  写入orderDetail表
            String sql1 = "insert into orderDetail(odid,gid,num,currprice,oid) values(?,?,?,?,?)";
            PreparedStatement pstmt1 = connection.prepareStatement(sql1);
            for (CartItem item: cartItem ) {
                pstmt1.setInt(1,0);
                pstmt1.setInt(2,item.getGoods().getGid());
                pstmt1.setInt(3,item.getNum());
                pstmt1.setFloat(4,item.getGoods().getPrice());
                pstmt1.setInt(5,oid);//将订单得主键id赋予订单详情，作为外键用
                pstmt1.executeUpdate();
            }
            connection.commit();//手动提交以上所有操作
            return true;
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }
        return false;
    }
}
