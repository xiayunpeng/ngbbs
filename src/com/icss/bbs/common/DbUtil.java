package com.icss.bbs.common;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库连接工厂
 * @author Administrator
 *
 */
public class DbUtil {
	
	
	public static Connection getConnection() throws Exception {
						
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/bbs";
		String user = "root";
		String password = "123456";
		
		Connection conn = DriverManager.getConnection(url, user,password);
		return conn;
		
	}
}