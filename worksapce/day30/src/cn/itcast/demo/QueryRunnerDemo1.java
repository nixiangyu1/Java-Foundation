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
 * queryRunner数据查询操作
 * 
 */
public class QueryRunnerDemo1 {
	private static Connection con =JDBCUtilsConfig.getConnection();
	public static void main(String[] args) throws SQLException {
//		arrayHandler();  //将结果集第一行，以对象数组的方式输出
		
//		arrayListHander();//将结果集每一行，以集合对象数组的方式输出
//		beanHandler();     //将结果集第一行，以对象的方式输出
//		beanListHandler();  //将结果集第一行，以对象集合的方式输出
//		columnListHandler();  //将结果集的第一列，以对象集合的方式输出
//		scalarHandler();       //将结果集有多少条数据，以long型输出
//		mapHandler();         //将结果集中的第一行数据，以Map的形式输出
		mapListHandler();
	}
	/*
	 * 结果集第八种处理方法，MapListHandler
	 * 将结果集每一行存储到Map集合，键：列名，值：数据
	 * Map集合过多，存储到List集合
	 */
	public static void mapListHandler()throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT  * FROM sort";
		//调用方法query,传递结果集实现类MapListHandler
		//返回值List集合, 存储的是Map集合
		List<Map<String,Object>> list = qr.query(con, sql, new MapListHandler());
		//遍历集合list
		for( Map<String,Object> map : list ){
			for(String key : map.keySet()){
				System.out.print(key+"..."+map.get(key));
			}
			System.out.println();
		}
		
	}
	
	/*
	 * 结果集的第七种处理方法，MapHandler
	 * 将集合第一行的数据，封装Map集合中
	 */
	public static void mapHandler()throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM sort";
		//调用方法query，传递结果集实现类
		Map<String,Object> map=qr.query(con, sql,new MapHandler());
		System.out.println(map);
	}
	
	
	/*
	 * 结果集第六种处理方法，ScalarHandler
	 * 对于查询后，只有1个结果,用来获取表格有多少条数据
	 */
	public static void scalarHandler()throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT COUNT(*) FROM sort";
		//调用方法query，传递结果集实现类
		long count=qr.query(con, sql,new ScalarHandler<Long>());
		System.out.println(count);
	}
	
	
	/*
	 * 结果集第五种处理方法，ColumnListHandler
	 * 结果集，指定列的数据，存储到List集合，用来获取某一列数据
	 * List<Object> 每个列数据类型不同
	 */
	public static void columnListHandler() throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM sort";
		//调用query，传递结果集实现类ColumnListHander
		//实现类构造方法中，使用字符串的列名
		List<Object> list=qr.query(con, sql, new ColumnListHandler<Object>("sname"));
		for(Object obj:list) {
			System.out.println(obj);
		}
	}
	
	
	/*
	 * 结果集第四种处理方法，BeanListHandler
	 * 将数据结果集的每一行数据，封装成JavaBean对象，用来获取所有数据
	 * 多个JavaBean对象封装到List集合中
	 */
	public static void beanListHandler() throws SQLException{
		QueryRunner qr = new QueryRunner()	;
		String sql ="SELECT * FROM sort";
		//调用方法获取结果集
		
		List<Sort> list = qr.query(con, sql, new BeanListHandler<Sort>(Sort.class));
		// Sort.class意思是获取Sort的类型。
		for(Sort sort:list) {
			System.out.println(sort);
		}
		DbUtils.closeQuietly(con);
	}
	
	
	
	
	/*
	 * 结果集的第三种方法,BeanHandler
	 * 将结果集的第一行数据，封装成JavaBean对象也就是这里的Sort类的对象
	 * 注意:被封装成数据到JavaBean对象，Sort类必须有空参构造
	 * 
	 */
	public static void beanHandler() throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM sort";
		//调用方法，结果集实现类BeanHandler
		Sort s=qr.query(con, sql,new BeanHandler<Sort>(Sort.class));
		// Sort.class意思是获取Sort的类型。
		System.out.println(s);
		DbUtils.closeQuietly(con);
	}
	
	
	/*
	 * 结果集第二种处理方法,ArrayListHander
	 * 将结果集的每一行,封装到对象数组中，出现很多对象数组
	 * 对象数组储存到List集合中
	 */
	public static void arrayListHander() throws SQLException{
		QueryRunner qr=new QueryRunner();
		String sql="SELECT * FROM sort";
		//方法返回值 每行是一个对象数组
		List<Object[]> result=qr.query(con, sql, new ArrayListHandler());
		//集合遍历
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
	 * 将结果集的第一行存储到对象数组中 Object[]
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
