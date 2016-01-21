package com.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
	private static BasicDataSource dataSource;
	
	static{
		dataSource=new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/online_exam");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
	
	}
	
	public static Connection getConnection() throws SQLException
	{
		return dataSource.getConnection();
	}
}
