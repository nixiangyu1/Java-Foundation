package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.JDBCUtil.JDBCUtilsConfig;

/*
 * 使用QueryRunner类，实现对数据表的
 * insert delete updata
 * 
 */
public class QueryRunnerDemo {
	private static Connection con =JDBCUtilsConfig.getConnection();

	public static void main(String[] args) throws SQLException {
//		insert();
//		update();
		delete();
	}
	public static void delete() throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "DELETE FROM sort Where sid=?";
		int row=qr.update(con,sql,8);
		System.out.println(row);
		DbUtils.closeQuietly(con);
		
	}
	public static void update() throws SQLException {
		QueryRunner qr= new QueryRunner();
		String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
		Object[] params = {"花卉",100.55,"情人节礼物",4};
		int row=qr.update(con,sql,params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
	public static void insert() throws SQLException {
		//创建QueryRunner类对象
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO sort (sname,sprice,sdesc) VALUES (?,?,?)";
		//调用QueryRunner类的方法update执行SQL语句
		//将三个？占位符卸载数组中
		Object[] params = {"体育用品","289.32","购买体育用品"};
		int row=qr.update(con,sql,params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
}
