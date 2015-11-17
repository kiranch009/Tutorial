package com.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.beans.User;
import com.dao.UserDAO;

@Repository
public class UserDAOImpl implements UserDAO
{

    public static final String SQL_CHECK_USER = "select * from user where login_id=? and login_password=?";

    @Override
    public User getUser(String userName, String password)
    {
        Connection conn=null;
        PreparedStatement pstmt = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam", "root", "root");
            pstmt = conn.prepareStatement(SQL_CHECK_USER);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
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

        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return null;

    }

}
