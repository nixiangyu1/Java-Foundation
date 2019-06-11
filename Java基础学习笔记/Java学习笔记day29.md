####  29.1JDBC连接数据库

JDBC操作数据库的步骤
	1.注册驱动
	    告知JVM使用的是哪一个数据库的驱动
	2.获得连接
	   使用JDBC中的类,完成对MySQL数据库的连接
	3.获得语句执行平台
	  通过连接对象获取对SQL语句的执行者对象
	4.执行sql语句
	  使用执行者对象,向数据库执行SQL语句
	  获取到数据库的执行后的结果
	5.处理结果
	6.释放资源  一堆close()

##### 29.1.1执行insert语句获取结果集  增删改用executeUpdate

~~~java
package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
	JDBC操作数据库的步骤
	1.注册驱动
	    告知JVM使用的是哪一个数据库的驱动
	2.获得连接
	   使用JDBC中的类,完成对MySQL数据库的连接
	3.获得语句执行平台
	  通过连接对象获取对SQL语句的执行者对象
	4.执行sql语句
	  使用执行者对象,向数据库执行SQL语句
	  获取到数据库的执行后的结果
	5.处理结果
	6.释放资源  一堆close()
 */
public class JDBCDemo {
	public static void main(String[] args)throws ClassNotFoundException,SQLException{
		//1.注册驱动 反射技术,将驱动类加入到内容
		// 使用java.sql.DriverManager类静态方法 registerDriver(Driver driver)
		// Diver是一个接口,参数传递,MySQL驱动程序中的实现类
		//DriverManager.registerDriver(new Driver());
		//驱动类源代码,注册2次驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//2.获得数据库连接  DriverManager类中静态方法
		//static Connection getConnection(String url, String user, String password)  
		//返回值是Connection接口的实现类,在mysql驱动程序
		//url: 数据库地址  jdbc:mysql://连接主机IP:端口号//数据库名字
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username="root";
		String password="123";
		Connection con = DriverManager.getConnection(url, username, password);
		
		//3.获得语句执行平台, 通过数据库连接对象,获取到SQL语句的执行者对象
		// con对象调用方法   Statement createStatement() 获取Statement对象,将SQL语句发送到数据库
		// 返回值是 Statement接口的实现类对象,,在mysql驱动程序
		Statement stat = con.createStatement();
		//	4.执行sql语句
		// 通过执行者对象调用方法执行SQL语句,获取结果
		// int executeUpdate(String sql)  执行数据库中的SQL语句, insert delete update
		// 返回值int,操作成功数据表多少行
		int row = stat.executeUpdate
				("INSERT INTO sort(sname,sprice,sdesc) VALUES('汽车用品',50000,'疯狂涨价')");
		System.out.println(row);
		
		//6.释放资源  一堆close()
		stat.close();
		con.close();
	}
}
~~~

##### 29.1.2执行select语句获取结果集 查询用executeQuery

~~~java
 package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 *  JDBC技术,查询数据表,获取结果集
 */
public class JDBCDemo1 {
	public static void main(String[] args) throws Exception{
		//1. 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2. 获取连接对象
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username="root";
		String password="123";
		Connection con = DriverManager.getConnection(url, username, password);
		//3 .获取执行SQL 语句对象
		Statement stat = con.createStatement();
		// 拼写查询的SQL
		String sql = "SELECT * FROM sort";
		//4. 调用执行者对象方法,执行SQL语句获取结果集
		// ResultSet executeQuery(String sql)  执行SQL语句中的select查询
		// 返回值ResultSet接口的实现类对象,实现类在mysql驱动中
		ResultSet rs = stat.executeQuery(sql);
		//5 .处理结果集
		// ResultSet接口方法 boolean next() 返回true,有结果集,返回false没有结果集
		while(rs.next()){
			//获取每列数据,使用是ResultSet接口的方法 getXX方法参数中,建议写String列名
			System.out.println(rs.getInt("sid")+"   "+rs.getString("sname")+
					"   "+rs.getDouble("sprice")+"   "+rs.getString("sdesc"));
		}
		
		rs.close();
		stat.close();
		con.close();
	}
}
~~~

#### 29.2SQL注入攻击

###### 29.2.1模拟攻击

~~~JAVA
package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 *  Java程序实现用户登录,用户名和密码,数据库检查
 *  演示被别人注入攻击
 */
public class JDBCDemo2 {
	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stat = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();
		String pass = sc.nextLine();
		
		//执行SQL语句,数据表,查询用户名和密码,如果存在,登录成功,不存在登录失败
		String sql = "SELECT * FROM users WHERE username='"+user+"' AND PASSWORD='"+pass+"'";
		System.out.println(sql);
		ResultSet rs = stat.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString("username")+"   "+rs.getString("password"));
		}
		
		rs.close();
		stat.close();
		con.close();
	}
}

~~~

###### 29.2.2解决方法

~~~java
package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
 *  Java程序实现用户登录,用户名和密码,数据库检查
 *  防止注入攻击
 *  Statement接口实现类,作用执行SQL语句,返回结果集
 *  有一个子接口PreparedStatement  (SQL预编译存储,多次高效的执行SQL) 
 *  PreparedStatement的实现类数据库的驱动中,如何获取接口的实现类
 *  
 *  是Connection数据库连接对象的方法
 *  PreparedStatement prepareStatement(String sql) 
          
 */
public class JDBCDemo3 {
	public static void main(String[] args)throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, username, password);
		Scanner sc = new Scanner(System.in);
		String user = sc.nextLine();
		String pass = sc.nextLine();
		
		//执行SQL语句,数据表,查询用户名和密码,如果存在,登录成功,不存在登录失败
		String sql = "SELECT * FROM users WHERE username=? AND PASSWORD=?";
		//调用Connection接口的方法prepareStatement,获取PrepareStatement接口的实现类
		//方法中参数,SQL语句中的参数全部采用问号占位符
		PreparedStatement pst =  con.prepareStatement(sql);
		System.out.println(pst);
		//调用pst对象set方法,设置问号占位符上的参数
		pst.setObject(1, user);
		pst.setObject(2, pass);
		
		//调用方法,执行SQL,获取结果集
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("username")+"   "+rs.getString("password"));
		}
		
		rs.close();
		pst.close();
		con.close();
	}
}

~~~

#### 29.3PrepareStatement借口预编译操作

##### 29.3.1修改数据

~~~java
package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 *  使用PrepareStatement接口,实现数据表的更新操作
 */
public class JDBCDemo {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username="root";
		String password="123";
		Connection con = DriverManager.getConnection(url, username, password);	
		
		//拼写修改的SQL语句,参数采用?占位
		String sql = "UPDATE sort SET sname=?,sprice=? WHERE sid=?";
		//调用数据库连接对象con的方法prepareStatement获取SQL语句的预编译对象
		PreparedStatement pst = con.prepareStatement(sql);
		//调用pst的方法setXXX设置?占位
		pst.setObject(1, "汽车美容");
		pst.setObject(2, 49988);
		pst.setObject(3, 7);
		//调用pst方法执行SQL语句
		pst.executeUpdate();
		
		pst.close();
		con.close();
	}
}

~~~

##### 29.3.2查询数据

~~~java
package cn.itcast.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 *  PrepareStatement接口实现数据表的查询操作
 */
public class JDBCDemo1 {
	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/mybase";
		String username="root";
		String password="123";
		Connection con = DriverManager.getConnection(url, username, password);	
		
		String sql = "SELECT * FROM sort";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		//调用pst对象的方法,执行查询语句,Select
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("sid")+"  "+rs.getString("sname")+"  "+rs.getString("sprice")+"  "+rs.getString("sdesc"));
		}
		rs.close();
		pst.close();
		con.close();
	}
}
~~~

#### 29.4JDBC的工具类和测试

 ~~~java
package cn.itcast.jdbcutil;
/*
 *  实现JDBC的工具类
 *  定义方法,直接返回数据库的连接对象
 *  
 *  写关闭方法
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private JDBCUtils(){}
	private static Connection con ;
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mybase";
			String username="root";
			String password="123";
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception ex){
			throw new RuntimeException(ex+"数据库连接失败");
		}
	}
	
	/*
	 * 定义静态方法,返回数据库的连接对象
	 */
	public static Connection getConnection(){
		return con;
	}
	
	
	public static void close(Connection con,Statement stat){
		 
		 if(stat!=null){
			 try{
				 stat.close();
			 }catch(SQLException ex){}
		 }
		 
		 if(con!=null){
			 try{
				 con.close();
			 }catch(SQLException ex){}
		 }
		 
	}
	
	
	public static void close(Connection con,Statement stat , ResultSet rs){
		 if(rs!=null){
			 try{
				 rs.close();
			 }catch(SQLException ex){}
		 }
		 
		 if(stat!=null){
			 try{
				 stat.close();
			 }catch(SQLException ex){}
		 }
		 
		 if(con!=null){
			 try{
				 con.close();
			 }catch(SQLException ex){}
		 }
		 
	}
}
 ~~~

~~~java
package cn.itcast.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.itcast.jdbcutil.JDBCUtils;

public class TestJDBCUtils {
	public static void main(String[] args)throws Exception {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT sname FROM sort");
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("sname"));
		}
		JDBCUtils.close(con, pst, rs);
		/*List list = new XXXX()
		 * while(rs.next()){
			Sort s = new Sort(rs.getInt("")......);
			list.add(s);
		}
		 * */
	}
}

~~~

##### 29.4.1数据表数据存储对象

~~~java
package cn.itcast.demo3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.JDBCUtil.JDBCUtils;
import cn.itcast.domain.Sort;

/*
 * JDBC读取数表sort,每行数据封装到Sort类的对象中
 * 很多个Sort类对象，存储到List集合中
 */
public class JDBCDemo {
	public static void main(String[] args) throws Exception{
		//使用JDBC工具类，直接获取数据库连接对象
		Connection con=JDBCUtils.getConnection();
		//连接获取数据库SQL语句执行者对象
		PreparedStatement pst = con.prepareStatement("SELECT * FROM sort");
		ResultSet rs = pst.executeQuery();
		//创建集合对象
		List<Sort> list = new ArrayList<Sort>();
		while(rs.next()) {
			//获取到每个列数据，封装到Sort对象中
			Sort s = new Sort(rs.getInt("sid"),rs.getString("sname"),rs.getDouble("sprice"),rs.getString("sdesc"));
			list.add(s);
		}
		//遍历List集合
		for(Sort s:list) {
			System.out.println(s);
		}
		JDBCUtils.close(con, pst, rs);
	}
}
~~~

#### 29.5properties配置文件

##### 29.5.1properties文件的创建和编写

在src文件夹下面新建文件File , 文件名为database.proerties

~~~java
dirverClass=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybase
username=root
password=null
~~~

##### 29.5.2加载配置文件

~~~java
package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/*
 * 加载properties配置文件
 * IO读取文件，键值对存储到集合
 * 从集合中以键值对方式获取数据库的连接信息，
 */
public class PropertiesDemo {
	public static void main(String[] args) throws Exception {
		//使用类的加载器
		InputStream in = PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
		System.out.println(in);
		Properties pro = new Properties();
		pro.load(in);
		System.out.println(pro);
//		FileInputStream fis = new FileInputStream("database.properties");
//		System.out.println(fis);
	}
}
~~~

##### 29.5.3通过配置文件连接数据库

新建配置文件database.properties

~~~java
driverClass=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/mybase
username=root
password=123
~~~

通过类加载器class.getClassLoader().getResourceAsStream调用配置文件，获得一个inputstream流

调用Properties集合的load方法，将inputstream流以键值对的形式存放

调用Properties集合的方法getProperties获取配置信息

通过配置信息注册驱动，获取数据库连接，获取SQL语句执行者对象，执行sql语句

~~~java
package cn.itcast.demo1;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 加载properties配置文件
 * IO读取文件，键值对存储到集合
 * 从集合中以键值对方式获取数据库的连接信息，
 */
public class PropertiesDemo {
	public static void main(String[] args) throws Exception {
		//使用类的加载器
		InputStream in=PropertiesDemo.class.getClassLoader().getResourceAsStream("database.properties");
		System.out.println(in);
		Properties pro = new Properties();
		pro.load(in);
		//获取集合中的键值对
		String driverClass =pro.getProperty("driverClass");
		String url = pro.getProperty("url");
		String username = pro.getProperty("username");
		String password= pro.getProperty("password");
        //1.注册驱动 反射技术,将驱动类加入到内容
		Class.forName(driverClass);
        //2.获得数据库连接  DriverManager类中静态方法
		Connection con =DriverManager.getConnection(url,username,password);
		System.out.println(con);
	}
}
~~~

29.5.4通过配置文件写链接数据库的工具类

~~~java
package cn.itcast.JDBCUtil;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/*
 * 编写JDBC的工具类，获取数据库的连接
 * 采用读取配置文件的方式
 * 读取配置文件，获取连接，执行一次，static{}
 */
public class JDBCUtilsConfig {
	private static Connection con;
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;
	
	static {
		try {
		ReadConfig();
		Class.forName(driverClass);
		con =DriverManager.getConnection(url,username,password);
		}catch(Exception ex) {
			throw new RuntimeException("数据库连接失败");
		}
		
	}
	private static  void ReadConfig() throws Exception{
		InputStream in =JDBCUtilsConfig.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro= new Properties();
		pro.load(in);
		driverClass =pro.getProperty("driverClass");
		url = pro.getProperty("url");
		username = pro.getProperty("username");
		password= pro.getProperty("password");
	}
	public static Connection getConnection() {
		return con;
	}
}
~~~

