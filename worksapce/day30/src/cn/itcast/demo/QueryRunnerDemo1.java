package cn.itcast.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.management.Query;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.JDBCUtil.JDBCUtilsConfig;
import cn.itcast.domain.Sort;

/*
 * queryRunner���ݲ�ѯ����
 * 
 */
public class QueryRunnerDemo1 {
	private static Connection con =JDBCUtilsConfig.getConnection();
	public static void main(String[] args) throws SQLException {
//		arrayHandler();  //���������һ�У��Զ�������ķ�ʽ���
		
//		arrayListHander();//�������ÿһ�У��Լ��϶�������ķ�ʽ���
//		beanHandler();     //���������һ�У��Զ���ķ�ʽ���
//		beanListHandler();  //���������һ�У��Զ��󼯺ϵķ�ʽ���
//		columnListHandler();  //��������ĵ�һ�У��Զ��󼯺ϵķ�ʽ���
//		scalarHandler();       //��������ж��������ݣ���long�����
//		mapHandler();         //��������еĵ�һ�����ݣ���Map����ʽ���
		mapListHandler();
	}
	/*
	 * ������ڰ��ִ�������MapListHandler
	 * �������ÿһ�д洢��Map���ϣ�����������ֵ������
	 * Map���Ϲ��࣬�洢��List����
	 */
	public static void mapListHandler()throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT  * FROM sort";
		//���÷���query,���ݽ����ʵ����MapListHandler
		//����ֵList����, �洢����Map����
		List<Map<String,Object>> list = qr.query(con, sql, new MapListHandler());
		//��������list
		for( Map<String,Object> map : list ){
			for(String key : map.keySet()){
				System.out.print(key+"..."+map.get(key));
			}
			System.out.println();
		}
		
	}
	
	/*
	 * ������ĵ����ִ�������MapHandler
	 * �����ϵ�һ�е����ݣ���װMap������
	 */
	public static void mapHandler()throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM sort";
		//���÷���query�����ݽ����ʵ����
		Map<String,Object> map=qr.query(con, sql,new MapHandler());
		System.out.println(map);
	}
	
	
	/*
	 * ����������ִ�������ScalarHandler
	 * ���ڲ�ѯ��ֻ��1�����,������ȡ����ж���������
	 */
	public static void scalarHandler()throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT COUNT(*) FROM sort";
		//���÷���query�����ݽ����ʵ����
		long count=qr.query(con, sql,new ScalarHandler<Long>());
		System.out.println(count);
	}
	
	
	/*
	 * ����������ִ�������ColumnListHandler
	 * �������ָ���е����ݣ��洢��List���ϣ�������ȡĳһ������
	 * List<Object> ÿ�����������Ͳ�ͬ
	 */
	public static void columnListHandler() throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM sort";
		//����query�����ݽ����ʵ����ColumnListHander
		//ʵ���๹�췽���У�ʹ���ַ���������
		List<Object> list=qr.query(con, sql, new ColumnListHandler<Object>("sname"));
		for(Object obj:list) {
			System.out.println(obj);
		}
	}
	
	
	/*
	 * ����������ִ�������BeanListHandler
	 * �����ݽ������ÿһ�����ݣ���װ��JavaBean����������ȡ��������
	 * ���JavaBean�����װ��List������
	 */
	public static void beanListHandler() throws SQLException{
		QueryRunner qr = new QueryRunner()	;
		String sql ="SELECT * FROM sort";
		//���÷�����ȡ�����
		
		List<Sort> list = qr.query(con, sql, new BeanListHandler<Sort>(Sort.class));
		// Sort.class��˼�ǻ�ȡSort�����͡�
		for(Sort sort:list) {
			System.out.println(sort);
		}
		DbUtils.closeQuietly(con);
	}
	
	
	
	
	/*
	 * ������ĵ����ַ���,BeanHandler
	 * ��������ĵ�һ�����ݣ���װ��JavaBean����Ҳ���������Sort��Ķ���
	 * ע��:����װ�����ݵ�JavaBean����Sort������пղι���
	 * 
	 */
	public static void beanHandler() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM sort";
		//���÷����������ʵ����BeanHandler
		Sort s=qr.query(con, sql,new BeanHandler<Sort>(Sort.class));
		// Sort.class��˼�ǻ�ȡSort�����͡�
		System.out.println(s);
		DbUtils.closeQuietly(con);
	}
	
	
	/*
	 * ������ڶ��ִ�����,ArrayListHander
	 * ���������ÿһ��,��װ�����������У����ֺܶ��������
	 * �������鴢�浽List������
	 */
	public static void arrayListHander() throws SQLException{
		QueryRunner qr=new QueryRunner();
		String sql="SELECT * FROM sort";
		//��������ֵ ÿ����һ����������
		List<Object[]> result=qr.query(con, sql, new ArrayListHandler());
		//���ϱ���
		for(Object[] objs:result) {
			for(Object obj:objs) {
				System.out.print(obj+"  ");
			}
			System.out.println();
		}
		DbUtils.closeQuietly(con);
	}
	
	
	/*
	 * ArrayHandler
	 * ��������ĵ�һ�д洢������������ Object[]
	 * 
	 */
	public static void arrayHandler() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql ="SELECT * FROM sort";
		Object[] result=qr.query(con, sql,new ArrayHandler());
		for(Object obj:result) {
			System.out.print(obj);
		}	
		DbUtils.closeQuietly(con);
	}
}
