package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 连接池jar包中，定义好一个类BasicDataSource
 */
public class DataSoruceDemo {
	public static void main(String[] args)  {
		//创建DataSource接口的实现类对象
		//实现类
		BasicDataSource dataSource = new BasicDataSource();
		//连接数据库的4个最基本信息，通过对象方法setxxx设置
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/mybase");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		try {
		Connection con = dataSource.getConnection();
		System.out.println(con);
		}catch(SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("数据库连接失败 ");
		}
	}
}
 