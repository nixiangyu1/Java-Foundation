package cn.itcast.jdbcutils;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * ʹ��DBCPʵ�����ݿ�����ӳ�
 * ���ӳ����ã��Զ�����
 * �������������
 * �������ݿ����ӳ��������ã��Զ���
 */
public class JDBCUtils {
	//������BasicDataSource�����
	private static BasicDataSource datasource = new BasicDataSource();
	
	
	//��̬����飬����BasicDataSource�����е����ã��Զ���
	static {
	datasource.setDriverClassName("com.mysql.jdbc.Driver");
	datasource.setUrl("jdbc:mysql://localhost:3306/mybase");
	datasource.setUsername("root");
	datasource.setPassword("123");
	datasource.setInitialSize(10);//��ʼ��������
	datasource.setMaxActive(8);//�����������
	datasource.setMaxIdle(5);//��������
	datasource.setMinIdle(1);//��С������
	}
	//���徲̬����������BasicDataSource��Ķ���
	public static DataSource getDataSource() {
		return datasource;
	}
}
