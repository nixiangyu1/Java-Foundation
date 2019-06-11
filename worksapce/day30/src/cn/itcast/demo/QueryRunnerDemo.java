package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.JDBCUtil.JDBCUtilsConfig;

/*
 * ʹ��QueryRunner�࣬ʵ�ֶ����ݱ��
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
		Object[] params = {"����",100.55,"���˽�����",4};
		int row=qr.update(con,sql,params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
	public static void insert() throws SQLException {
		//����QueryRunner�����
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO sort (sname,sprice,sdesc) VALUES (?,?,?)";
		//����QueryRunner��ķ���updateִ��SQL���
		//��������ռλ��ж��������
		Object[] params = {"������Ʒ","289.32","����������Ʒ"};
		int row=qr.update(con,sql,params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
}
