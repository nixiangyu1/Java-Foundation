#### 30.1DButils工具类

DButils是JDBC的简化开发工具包

Dbutils三个核心功能介绍

- QueryRunner中提供对sql语句操作的API.
- ResultSetHandler接口，用于定义select操作后，怎样封装结果集.
- DbUtils类，它就是一个工具类,定义了关闭资源与事务处理的方法

##### 30.1.1QueryRunner类实现update修改数据



~~~JAVA
package cn.itcast.demo2;

import java.lang.Character.UnicodeBlock;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.itcast.jdbcutil.JDBCUtilsConfig;

/*
 *  使用QueryRunner类,实现对数据表的
 *  insert delete update
 *  调用QueryRunner类的方法 update (Connection con,String sql,Object...param)
 *  Object...param 可变参数,Object类型,SQL语句会出现?占位符
 *  数据库连接对象,自定义的工具类传递
 */
public class QueryRunnerDemo {
	private static Connection con = JDBCUtilsConfig.getConnection();
	public static void main(String[] args)throws SQLException {
//		insert();
//		update();
		delete();
	}
	/*
	 *  定义方法,使用QueryRunner类的方法delete将数据表的数据删除
	 */
	public static void delete()throws SQLException{
		//创建QueryRunner类对象
		QueryRunner qr = new QueryRunner();	
		//写删除的SQL语句
		String sql = "DELETE FROM sort WHERE sid=?";
		//调用QueryRunner方法update
		int row = qr.update(con, sql, 8);
		System.out.println(row);
		/*
		 *  判断insert,update,delete执行是否成功
		 *  对返回值row判断
		 *  if(row>0) 执行成功
		 */
		DbUtils.closeQuietly(con);
	}
	
	/*
	 *  定义方法,使用QueryRunner类的方法update将数据表的数据修改
	 */
	public static void update()throws SQLException{
		//创建QueryRunner类对象
		QueryRunner qr = new QueryRunner();	
		//写修改数据的SQL语句
		String sql = "UPDATE sort SET sname=?,sprice=?,sdesc=? WHERE sid=?";
		//定义Object数组,存储?中的参数
		Object[] params = {"花卉",100.88,"情人节玫瑰花",4};
		//调用QueryRunner方法update
		int row = qr.update(con, sql, params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
	
	
	/*
	 * 定义方法,使用QueryRunner类的方法update向数据表中,添加数据
	 */
	public static void insert()throws SQLException{
		//创建QueryRunner类对象
		QueryRunner qr = new QueryRunner();
		String sql = "INSERT INTO sort (sname,sprice,sdesc)VALUES(?,?,?)";
		//将三个?占位符的实际参数,写在数组中
		Object[] params = {"体育用品",289.32,"购买体育用品"};
		//调用QueryRunner类的方法update执行SQL语句
		int row = qr.update(con, sql, params);
		System.out.println(row);
		DbUtils.closeQuietly(con);
	}
}

~~~

##### 30.1.2QueryRunner实现查询操作

query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) ，用来完成表数据的查询操作

**ResultSetHandler结果集处理类**

| ArrayHandler      | 将结果集中的第一条记录封装到一个Object[]数组中，数组中的每一个元素就是这条记录中的每一个字段的值 |
| ----------------- | ------------------------------------------------------------ |
| ArrayListHandler  | 将结果集中的每一条记录都封装到一个Object[]数组中，将这些数组在封装到List集合中。 |
| BeanHandler       | 将结果集中第一条记录封装到一个指定的javaBean中。             |
| BeanListHandler   | 将结果集中每一条记录封装到指定的javaBean中，将这些javaBean在封装到List集合中 |
| ColumnListHandler | 将结果集中指定的列的字段值，封装到一个List集合中             |
| ScalarHandler     | 它是用于单数据。例如select count(*) from 表操作。            |
| MapHandler        | 将结果集第一行封装到Map集合中,Key 列名, Value 该列数据       |
| MapListHandler    | 将结果集第一行封装到Map集合中,Key 列名, Value 该列数据,Map集合存储到List集合 |

~~~java
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

~~~

#### 30.2DBCP连接池

![1559641926550](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559641926550.png)

##### 30.2.1BasicDataSource类的使用

~~~java
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
~~~

##### 30.2.2常见的配置

![1559644737137](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559644737137.png)

##### 30.2.3实现数据库连接池工具类

~~~java
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
    private JDBCUtils(){}
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
~~~



~~~java
package cn.itcast.demo;
/*
 *  测试写好的工具类,
 *  提供的是一个DataSource接口的数据源
 *  QueryRunner类构造方法,接收DataSource接口的实现类
 *  后面,调用方法update,query,无需传递他们Connection连接对象
 */

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import cn.itcast.jdbcutils.JDBCUtils;
public class QueryRunnerDemo{
    public static void main(String[] args) {
    	select();
	}
	//定义2个方法,实现数据表的添加,数据表查询
	//QueryRunner类对象,写在类成员位置
	private static QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource()); 
	
	//数据表查询
	public static void select(){
		String sql = "SELECT * FROM sort";
		try{
		List<Object[]> list = qr.query(sql, new ArrayListHandler());
		for(Object[] objs : list){
			for(Object obj : objs){
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
		}catch(SQLException ex){
			throw new RuntimeException("数据查询失败");
		}
	}
	
	//数据表添加数据
	public static void insert(){
		String sql = "INSERT INTO sort (sname,sprice,sdesc)VALUES(?,?,?)";
		Object[] params = {"水果",100.12,"刚刚上市的核桃"};
		try{
			int row = qr.update(sql, params);
			System.out.println(row);
		}catch(SQLException ex){
			throw new RuntimeException("数据添加失败");
		}
	}
	
}

~~~

