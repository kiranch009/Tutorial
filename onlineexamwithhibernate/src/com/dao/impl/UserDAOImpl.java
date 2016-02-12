package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.beans.User;
import com.beans.UserAddress;
import com.dao.UserDao;
import com.utils.JDBCUtils;
@Repository
public class UserDAOImpl implements UserDao {

	@Autowired
	private DataSource dataSource;

	public static final String SQL_CHECK_USER = "select * from user where login_id=? and login_password=?";
	
	private static final String SQL_UPDATE_USER="update user set user_name=?,login_id=?,qualification=?,email_id=?,mobile=?,dob=? where user_id=?";

	@Override
	public User getUser(String userName, String password) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL_CHECK_USER);
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setLoginId(rs.getString("login_id"));
				user.setQualification(rs.getString("qualification"));
				user.setEmailId(rs.getString("email_id"));
				user.setMobile(rs.getString("mobile"));
				user.setDob(rs.getDate("dob"));
				
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
	public void updateUser(User user) {
		Connection conn = null;
		
		
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE_USER);
			pstmt.setString(1, user.getUserName());
			pstmt.setString(2, user.getLoginId());
			pstmt.setString(3, user.getQualification());
			pstmt.setString(4, user.getEmailId());
			pstmt.setString(5, user.getMobile());
			pstmt.setDate(6, new Date(user.getDob().getTime()));
			pstmt.setInt(7, user.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException ex) {
			throw new RuntimeException(ex);
		} finally {
			JDBCUtils.closeStatement(pstmt);
			JDBCUtils.closeConnection(conn);
		}
			
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer saveUserAddress(UserAddress userAddress) {
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public UserAddress getUserAddress(Integer addressId) {
		return null;
	}

	

}
