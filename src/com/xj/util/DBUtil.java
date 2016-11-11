package com.xj.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBUtil {
	
	private static final DBUtil util = new DBUtil();
	
	private DBUtil() {
		
	}
	
	public static DBUtil getInstance() {
		return util;
	}
	
	private String className = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://123.206.210.137/SaleSupportCms_db";
	private String user = "xjtuse";
	private String password = "123";
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Connection getConnection() {
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	//增、删、改操作
	public void update(String sql, List<Object> params) {
		try {
			ps = conn.prepareStatement(sql);
			if(params!=null && params.size()>0) {
				for(int i=0;i<params.size();i++) {
					ps.setObject(i+1, params.get(i));
				}
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查询操作
	public ResultSet query(String sql, List<Object> params) {
		try {
			ps = conn.prepareStatement(sql);
			if(params!=null && params.size()>0) {
				for(int i=0;i<params.size();i++) {
					ps.setObject(i+1, params.get(i));
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	//关闭连接
	public void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
