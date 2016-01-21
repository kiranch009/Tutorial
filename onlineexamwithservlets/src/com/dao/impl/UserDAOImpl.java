package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.beans.User;
import com.beans.UserAddress;
import com.dao.UserDao;
import com.utils.JDBCUtils;

public class UserDAOImpl implements UserDao
{

    public static final String SQL_CHECK_USER = "select * from user where login_id=? and login_password=?";

    @Override
    public User getUser(String userName, String password)
    {
    	
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(SQL_CHECK_USER);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            User user = null;
            while (rs.next())
            {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setLoginId(rs.getString("login_id"));
                user.setQualification(rs.getString("qualification"));
                user.setEmailId(rs.getString("email_id"));
                user.setMobile(rs.getString("mobile"));
                return user;
            }
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeResultSet(rs);
			JDBCUtils.closeStatement(pstmt);
			JDBCUtils.closeConnection(conn);
		}
		return null;
    }

    @Override
    public void saveUser(User user)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public Integer saveUserAddress(UserAddress userAddress)
    {
        // TODO Auto-generated method stub
        return null;

    }

    @Override
    public UserAddress getUserAddress(Integer addressId)
    {
        return null;
    }

}
