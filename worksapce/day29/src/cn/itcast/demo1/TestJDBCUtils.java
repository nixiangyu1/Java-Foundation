package cn.itcast.demo1;

import java.sql.Connection;

import cn.itcast.JDBCUtil.JDBCUtilsConfig;

public class TestJDBCUtils {

	public static void main(String[] args) {
		Connection con=JDBCUtilsConfig.getConnection();
		System.out.println(con);
	}

}
