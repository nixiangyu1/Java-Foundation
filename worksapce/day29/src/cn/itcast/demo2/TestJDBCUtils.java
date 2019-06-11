package cn.itcast.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcast.JDBCUtil.JDBCUtils;

public class TestJDBCUtils {
	public static void main(String[] args)throws Exception {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT sname FROM sort");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("sname"));
		}
		JDBCUtils.close(con, pst, rs);
	}
}
