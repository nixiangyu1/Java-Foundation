#### 22.1IO概述

当需要把内存中的数据存储到持久化设备上这个动作称为输出（写）Output操作。

当把持久设备上的数据读取到内存中的这个动作称为输入（读）Input操作。

因此我们把这种输入和输出动作称为IO操作。

#### 22.2File类

用来操作系统中的文件，文件夹和路径。

##### 22.2.1File类静态的成员变量

~~~java
package cn.itcast.demo;

import java.io.File;

/*
 *  java.io.File
 *    将操作系统中的,文件,目录(文件夹),路径,封装成File对象
 *    提供方法,操作系统中的内容
 *    File与系统无关的类
 *    文件 file
 *    目录 directory
 *    路径 path
 */
public class FileDemo {
	public static void main(String[] args) {
		//File类静态成员变量
		//与系统有关的路径分隔符
		String separator = File.pathSeparator;
		System.out.println(separator);// 是一个分号,目录的分割   Linux :
		
		//与系统有关的默认名称分隔符
		separator = File.separator;
		System.out.println(separator);// 向右 \  目录名称分割  Linux / 
	}
}

~~~

##### 22.2.2File类的构造方法

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10056\wps3.jpg)

~~~java
package cn.itcast.demo;

import java.io.File;

/*
 *  File类的构造方法
 *  三种重载形式
 */
public class FileDemo1 {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 *  File(File parent,String child)
	 *  传递路径,传递File类型父路径,字符串子路径
	 *  好处: 父路径是File类型,父路径可以直接调用File类方法
	 */
	public static void function_2(){
		File parent = new File("d:");
		File file = new File(parent,"eclipse");
		System.out.println(file);
	}
	
	/*
	 *  File(String parent,String child)
	 *  传递路径,传递字符串父路径,字符串子路径
	 *  好处: 单独操作父路径和子路径
	 */
	public static void function_1(){
		File file = new File("d:","eclipse");
		System.out.println(file);
	}
	
	/*
	 *  File(String pathname)
	 *  传递路径名: 可以写到文件夹,可以写到一个文件
	 *  c:\\abc   c:\\abc\\Demo.java
	 *  将路径封装File类型对象
	 */
	public static void function(){
		File file = new File("d:\\eclipse");
		System.out.println(file);
	}
}

~~~

##### 22.2.3相对路径和绝对路径

绝对路径：在系统中具有唯一性  d:\\windows\eclipse

   				http://www.baidu.com

相对路径: 表示的是路径之间的相对关系

​				d:\\develop\Java\\jdk1.7.0_72\\bin

​				d:\\develop\\Java\\jre7

路径之间的关系

​		Java	父目录是D：\\develop

​		Java 	子目录是:jdk1.7.0_72 和jre7

父目录是 唯一性的

子目录是可以多个

##### 22.2.4File类的构造方法

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10056\wps2.jpg)

##### 22.2.5File类文件和文件夹的创建删除

 ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10056\wps4.jpg)

用mkdirs（)可以创建出多层目录

~~~java
package cn.itcast.demo;

import java.io.File;
import java.io.IOException;

/*
 *  File类的创建和删除功能
 *  文件或者是目录
 */
public class FileDemo2 {
	public static void main(String[] args)throws IOException {
		function_2();
	}
	/*
	 *  File类的删除功能
	 *  boolean delete()
	 *  删除的文件或者是文件夹,在File构造方法中给出
	 *  删除成功返回true,删除失败返回false
	 *  删除方法,不走回收站,直接从硬盘中删除
	 *  删除有风险,运行需谨慎
	 */
	public static void function_2(){
		File file = new File("c:\\a.txt");
		boolean b = file.delete();
		System.out.println(b);
	}
	
	/*
	 *  File创建文件夹功能
	 *  boolean mkdirs() 创建多层文件夹
	 *  创建的路径也在File构造方法中给出
	 *  文件夹已经存在了,不在创建
	 */
	public static void function_1(){
		File file = new File("c:\\abc");
		boolean b = file.mkdirs();
		System.out.println(b);
	}
	
	
	/*
	 *  File创建文件的功能
	 *  boolean createNewFile()
	 *  创建的文件路径和文件名,在File构造方法中给出
	 *  文件已经存在了,不在创建
	 */
	public static void function()throws IOException{
		File file = new File("c:\\a.txt");
		boolean b = file.createNewFile();
		System.out.println(b);
	}
}

~~~

##### 22.2.6File类的获取

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10056\wps5.jpg)

##### 22.2.7File类判断功能

~~~java
package cn.itcast.demo;

import java.io.File;

/*
 *  File类的判断功能
 */
public class FileDemo4 {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 *  File判断功能
	 *  boolean isDirectory()
	 *  判断File构造方法中封装的路径是不是文件夹
	 *  如果是文件夹,返回true,不是文件返回false
	 *  
	 *  boolean isFile()
	 *  判断File构造方法中封装的路径是不是文件
	 */
	public static void function_1(){
		File file = new File("d:\\eclipse\\eclipse.exe");
		if(file.exists()){
			boolean b = file.isDirectory();
			System.out.println(b);
		}
	}
	
	/*
	 *  File判断功能
	 *  boolean exists()
	 *  判断File构造方法中封装路径是否存在
	 *  存在返回true,不存在返回false
	 */
	public static void function(){
		File file = new File("src");
		boolean b = file.exists();
		System.out.println(b);
	}
}
~~~

##### 22.2.8File类list获取功能

~~~java
package cn.itcast.demo1;

import java.io.File;

/*
 *  File类获取功能
 *  list
 *  listFiles
 */
public class FileDemo {
	public static void main(String[] args) {
		function_2();
	}
	public static void function_2(){
		//获取系统中的所有根目录
		File[] fileArr = File.listRoots();
		for(File f : fileArr){
			System.out.println(f);
		}
	}
	
	/*
	 *  File类的获取功能
	 *  File[] listFiles()
	 *  获取到,File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
	 *  返回的是目录或者文件的全路径
	 */
	public static void function_1(){
		File file = new File("d:\\eclipse");
		File[] fileArr = file.listFiles();
		for(File f : fileArr){
			System.out.println(f);
		}
	}
	
	/*
	 *  File类的获取功能
	 *  String[] list()
	 *  获取到,File构造方法中封装的路径中的文件和文件夹名 (遍历一个目录)
	 *  返回只有名字
	 */
	public static void function(){
		File file = new File("c:");
		String[] strArr = file.list();
		System.out.println(strArr.length);
		for(String str : strArr){
			System.out.println(str);
		}
	}
}

~~~

##### 22.2.9文件过滤器FileFilter

~~~java
 package cn.itcast.demo1;

import java.io.File;

/*
 *  File类的获取,文件获取过滤器
 *  遍历目录的时候,可以根据需要,只获取满足条件的文件
 *  遍历目录方法 listFiles()重载形式
 *  listFiles(FileFilter filter)接口类型
 *  传递FileFilter接口的实现类
 *  自定义FileFilter接口实现类,重写抽象方法,
 *  接口实现类对象传递到遍历方法listFiles
 */
public class FileDemo1 {
	public static void main(String[] args) {
		File file = new File("c:\\demo");
		File[] fileArr = file.listFiles(new MyFilter());
		for(File f : fileArr){
			System.out.println(f);
		}
	}
}

~~~

~~~JAVA
package cn.itcast.demo1;

import java.io.File;
import java.io.FileFilter;

/*
 *  自定义过滤器
 *  实现FileFilter接口,重写抽象方法
 */
public class MyFilter implements FileFilter{
	public boolean accept(File pathname)  {
		/*
		 * pathname 接受到的也是文件的全路径
		 * c:\\demo\\1.txt
		 * 对路径进行判断,如果是java文件,返回true,不是java文件,返回false
		 * 文件的后缀结尾是.java
		 */
		//String name = pathname.getName();
		return pathname.getName().endsWith(".java");
		
	}
}
~~~

##### 22.2.10递归遍历全目录

~~~java
package cn.itcast.demo2;

import java.io.File;

/*
 *  对一个目录的下的所有内容,进行完全的遍历
 *  编程技巧,方法的递归调用,自己调用自己
 */
public class FileDemo {
	public static void main(String[] args) {
		File dir = new File("d:\\eclipse");
		getAllDir(dir);
	}
	/*
	 *  定义方法,实现目录的全遍历
	 */
	public static void getAllDir(File dir){
		System.out.println(dir);
		//调用方法listFiles()对目录,dir进行遍历
		File[] fileArr = dir.listFiles();
		for(File f : fileArr){
			//判断变量f表示的路径是不是文件夹
			if(f.isDirectory()){
				//是一个目录,就要去遍历这个目录
				//本方法,getAllDir,就是给个目录去遍历
				//继续调用getAllDir,传递他目录
				getAllDir(f);
			}else{
				System.out.println(f);
			}
		}
	}
}
~~~

#### 22.3递归概念和注意事项

方法的递归调用

​	方法自己调用自己

适用于，方法中运算的主体不变，但是运行的时候，参与运行的方法参数会变化

**注意:**

​		递归一定要有出口，必须可以让程序停下来

​		递归次数不能多

​		构造方法，禁止递归

 ~~~java
package cn.itcast.demo2;
/*
 *  方法的递归调用
 *    方法自己调用自己
 *  适合于,方法中运算的主体不变,但是运行的时候,参与运行的方法参数会变化
 *  注意:
 *     递归一定要有出口, 必须可以让程序停下
 *     递归次数不能过多
 *     构造方法,禁止递归
 */
public class DiGuiDemo {
	public static void main(String[] args) {
		/*int sum = getSum(3);
		System.out.println(sum);*/
		System.out.println(getJieCheng(5));
		System.out.println(getFBNQ(12));
	}
	/*
	 *  方法递归,计算斐波那契数列
	 *  
	 */
	public static int getFBNQ(int month){
		if( month == 1)
			return 1;
		if( month == 2)
			return 1;
		return getFBNQ(month-1)+getFBNQ(month-2);
	}
	
	/* 
	 *  计算阶乘 5!
	 *   5*4*3*2*1
	 */
	public static int getJieCheng(int n){
		if ( n == 1)
			return 1;
		return n * getJieCheng(n-1);
	}
			
	/*
	 *  计算 1+2+3+100和 = 5050
	 *  计算规律:
	 *    n+(n-1)+(n-2)
	 *    100+(100-1)+(99-1)+...1
	 */
	public static int getSum(int n){
		if( n == 1)
			return 1;
		return n + getSum(n-1);
	}
	
}
 ~~~

