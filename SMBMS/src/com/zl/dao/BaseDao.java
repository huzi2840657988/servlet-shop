package com.zl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.zl.util.ConfigUtil;


public class BaseDao {
	private static ConfigUtil cfu =ConfigUtil.getInstance();
	
	static {
		
		try {
			Class.forName(cfu.getPropertyValue("jdbc.driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("加载驱动类出错");
		}
	}
	private static String url = cfu.getPropertyValue("jdbc.connection.url");
	private static String user = cfu.getPropertyValue("jdbc.connection.user");
	private static String password = cfu.getPropertyValue("jdbc.connection.password");

	
	public Connection getConnection() {
		Connection resultCon = null;
		try {
			resultCon = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultCon;
	}

	public void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void close(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
