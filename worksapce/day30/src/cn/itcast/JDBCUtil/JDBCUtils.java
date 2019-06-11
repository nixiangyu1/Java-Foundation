package cn.itcast.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private JDBCUtils() {
	}

	private static Connection con;
	static {
		try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username="root";
		String password="";
		con = DriverManager.getConnection(url, username, password);
		}catch(Exception ex) {
			throw new RuntimeException(ex+"���ݿ�����ʧ��");
		}
	}

	public static Connection getConnection() {
		return con;
	}
	public static void close(Connection con,Statement stat,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException ex) {
				
			}
		}
		if(stat!=null) {
			try {
				stat.close();
			}catch(SQLException ex) {
				
			}
		}
		if(con!=null) {
			try {
				con.close();
			}catch(SQLException ex) {
				
			}
		}
		
		
	}
}
