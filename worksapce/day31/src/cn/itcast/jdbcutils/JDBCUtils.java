package cn.itcast.jdbcutils;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 使用DBCP实现数据库的连接池
 * 连接池配置，自定义类
 * 最基本四项完整
 * 对于数据库连接池其他配置，自定义
 */
public class JDBCUtils {
	//创建出BasicDataSource类对象
	private static BasicDataSource datasource = new BasicDataSource();
	
	
	//静态代码块，对象BasicDataSource对象中的配置，自定义
	static {
	datasource.setDriverClassName("com.mysql.jdbc.Driver");
	datasource.setUrl("jdbc:mysql://localhost:3306/mybase");
	datasource.setUsername("root");
	datasource.setPassword("123");
	datasource.setInitialSize(10);//初始化连接数
	datasource.setMaxActive(8);//最大连接数量
	datasource.setMaxIdle(5);//最大空闲数
	datasource.setMinIdle(1);//最小空心数
	}
	//定义静态方法，返回BasicDataSource类的对象
	public static DataSource getDataSource() {
		return datasource;
	}
}
