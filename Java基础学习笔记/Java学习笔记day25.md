#### 25.1Properties集合类

##### 25.1.1Properties集合的注意事项

Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。

特点：

1、Hashtable的子类，map集合中的方法都可以用。

2、该集合没有泛型。键值都是字符串。

3、它是一个可以持久化的属性集。键值可以存储到集合中，也可以存储到持久化的设备(硬盘、U盘、光盘)上。键值的来源也可以是持久化的设备。

4、有和流技术相结合的方法。

##### 25.1.2Properties集合类的方法

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml6168\wps1.jpg)

~~~java
package cn.itcast.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
 *  集合对象Properties类,继承Hashtable,实现Map接口
 *  可以和IO对象结合使用,实现数据的持久存储
 */
public class PropertiesDemo {
	public static void main(String[] args)throws IOException {
		function_2();
	}
	/*
	 * Properties集合的特有方法store
	 * store(OutputStream out)
	 * store(Writer w)
	 * 接收所有的字节或者字符的输出流,将集合中的键值对,写回文件中保存
	 */
	public static void function_2()throws IOException{
		Properties pro = new Properties();
		pro.setProperty("name", "zhangsan");
		pro.setProperty("age", "31");
		pro.setProperty("email", "123456789@163.com");
		FileWriter fw = new FileWriter("c:\\pro.properties");
		//键值对,存回文件,使用集合的方法store传递字符输出流
		pro.store(fw, "");
		fw.close();
	}
	
	/*
	 * Properties集合特有方法 load
	 * load(InputStream in)
	 * load(Reader r)
	 * 传递任意的字节或者字符输入流
	 * 流对象读取文件中的键值对,保存到集合
	 */
	public static void function_1()throws IOException{
		Properties pro = new Properties();
		FileReader fr = new FileReader("c:\\pro.properties");
		//调用集合的方法load,传递字符输入流
		pro.load(fr);
		fr.close();
		System.out.println(pro);
	}
	
	/*
	 * 使用Properties集合,存储键值对
	 * setProperty等同与Map接口中的put
	 * setProperty(String key, String value)
	 * 通过键获取值, getProperty(String key)
	 */
	public static void function(){
		Properties pro = new Properties();
		pro.setProperty("a", "1");
		pro.setProperty("b", "2");
		pro.setProperty("c", "3");
		System.out.println(pro);
		
		String value = pro.getProperty("c");
		System.out.println(value);
		
		//方法stringPropertyNames,将集合中的键存储到Set集合,类似于Map接口的方法keySet
		Set<String> set = pro.stringPropertyNames();
		for(String key : set){
			System.out.println(key+"..."+pro.getProperty(key));
		}
	}
}

~~~

#### 25.2对象的序列化和反序列化

##### 25.2.1ObjectOutputStream和ObjectInputStream

~~~java
package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 *  IO流对象,实现对象Person序列化,和反序列化
 *  ObjectOutputStream 写对象,实现序列化
 *  ObjectInputStream 读取对象,实现反序列化
 *  Person类的静态数据类型，不能序列化
 *  因为静态和类有关，和对象无关
 */
public class ObjectStreamDemo {
	public static void main(String[] args)throws IOException, ClassNotFoundException {
//		writeObject();
		readObject();
	}
	/*
	 * ObjectInputStream
	 * 构造方法:ObjectInputStream(InputStream in)
	 * 传递任意的字节输入流,输入流封装文件,必须是序列化的文件
	 * Object readObject()  读取对象
	 */
	public static void readObject() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("c:\\person.txt");
		//创建反序列化流,构造方法中,传递字节输入流
		ObjectInputStream ois = new ObjectInputStream(fis);
		//调用反序列化流的方法 readObject()读取对象
		Object obj =ois.readObject();
		System.out.println(obj);
		ois.close();
	}
	
	/*
	 * ObjectOutputStream
	 * 构造方法: ObjectOutputStream(OutputSteam out)
	 * 传递任意的字节输出流
	 * void writeObject(Object obj)写出对象的方法
	 */
	public static void writeObject() throws IOException{
		//创建字节输出流,封装文件
		FileOutputStream fos = new FileOutputStream("c:\\person.txt");
		//创建写出对象的序列化流的对象,构造方法传递字节输出流
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p = new Person("lisi",25);
		//调用序列化流的方法writeObject,写出对象
		oos.writeObject(p);
		oos.close();
	}
}

~~~

##### 25.2.2序列化接口Serializable

标记型接口

当一个对象要能被序列化，这个对象所属的类必须实现Serializable接口。否则会发生异常NotSerializableException异常。

需要序列化的类要实现Serializable接口

~~~java
public class Person implements Serializable{
}
~~~





##### 25.2.3ClassNotFoundException异常

反序列化的时候，需要类的class文件。

##### 25.2.4transient关键字

用来修饰类的成员变量，使其不被序列化。

~~~java
private transient int age;
~~~

##### 25.2.5序列化中序列号冲突问题

序列化之后，更改了Persno类中的成员变量的权限，导致序列号不同，反序列失败

![1559297163434](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559297163434.png)

##### 25.2.6序列化中自定义的序列号

在类中粘贴以下代码  不让改序列号

~~~java
static final long serialVersionUID = 42L;
~~~

#### 25.3打印流特性

##### 25.3PrintWriter和自动刷新

~~~java
package cn.itcast.demo2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 *  打印流
 *    PrintStream
 *    PrintWriter
 *  打印流的特点:
 *   1. 此流不负责数据源,只负责数据目的
 *   2. 为其他输出流,添加功能
 *   3. 永远不会抛出IOException
 *      但是,可能抛出别的异常
 *   
 *   两个打印流的方法,完全一致
 *    构造方法,就是打印流的输出目的端
 *    PrintStream
 *       构造方法,接收File类型,接收字符串文件名,接收字节输出流OutputStream
 *    PrintWriter  
 *       构造方法,接收File类型,接收字符串文件名,接收字节输出流OutputStream, 接收字符输出流Writer
 *   
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws  IOException {
		function_3();

	}
	/* 
	 * 打印流,可以开启自动刷新功能
	 * 满足2个条件:
	 *   1. 输出的数据目的必须是流对象
	 *       OutputStream  Writer
	 *   2. 必须调用println,printf,format三个方法中的一个,启用自动刷新
	 */
	public static void function_3()throws  IOException{
		//File f = new File("XXX.txt");
		FileOutputStream fos = new FileOutputStream("c:\\5.txt");
		PrintWriter pw = new PrintWriter(fos,true);
		pw.println("i");
		pw.println("love");
		pw.println("java");
		pw.close();
	}
	
	/*
	 * 打印流,输出目的,是流对象
	 * 可以是字节输出流,可以是字符的输出流
	 * OutputStream  Writer
	 */
	public static void function_2() throws IOException{
	//	FileOutputStream fos = new FileOutputStream("c:\\3.txt");
		FileWriter fw = new FileWriter("c:\\4.txt");
		PrintWriter pw = new PrintWriter(fw);
		pw.println("打印流");
		pw.close();
	}
	/*
	 * 打印流,输出目的,String文件名
	 */
	public static void function_1() throws FileNotFoundException{
		PrintWriter pw = new PrintWriter("c:\\2.txt");
		pw.println(3.5);
		pw.close();
	}
	
	/*
	 * 打印流,向File对象的数据目的写入数据
	 * 方法print println  原样输出
	 * write方法走码表
	 */
	public static void function() throws FileNotFoundException{
		File file = new File("c:\\1.txt");
		PrintWriter pw = new PrintWriter(file);
		pw.println(true);
		pw.write(100);
		pw.close();
	}
}

~~~

##### 25.4打印流复制文件

~~~JAVA
package cn.itcast.demo2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 打印流实现文本复制
 *   读取数据源  BufferedReader+File 读取文本行
 *   写入数据目的 PrintWriter+println 自动刷新
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException{
		BufferedReader bfr = new BufferedReader(new FileReader("c:\\a.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("d:\\a.txt"),true);
		String line = null;
		while((line = bfr.readLine())!=null){
			pw.println(line);
		}
		pw.close();
		bfr.close();
	}
}

~~~

#### 25.5commons-io工具类

导入classpath

加入classpath的第三方jar包内的class文件才能在项目中使用

创建lib文件夹

将commons-io.jar拷贝到lib文件夹

右键点击commons-io.jar，Build Path→Add to Build Path

##### 25.5.1FilenameUtils的方法

~~~java
package cn.itcast.demo3;

import org.apache.commons.io.FilenameUtils;

public class Commons_IODemo {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 * FilenameUtils类的方法
	 * static boolean isExtension(String filename,String extension)
	 * 判断文件名的后缀是不是extension
	 */
	public static void function_2(){
		boolean b = FilenameUtils.isExtension("Demo.java", "java");
		System.out.println(b);
	}
	
	/*
	 * FilenameUtils类的方法
	 * static String getName(String filename)
	 * 获取文件名
	 */
	public static void function_1(){
		String name = FilenameUtils.getName("c:\\windows\\");
		System.out.println(name);
	}
	
	/*
	 * FilenameUtils类的方法
	 * static String getExtension(String filename)
	 * 获取文件名的扩展名
	 */
	 public static void function(){
		 String name = FilenameUtils.getExtension("c:\\windows");
		 System.out.println(name);
	 }
}

~~~

##### 25.5.2FileUtils的方法

 ~~~java
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Commons_IODemo1 {
	public static void main(String[] args)throws IOException {
		function_3();
	}
	/*
	 * FileUtils工具类方法
	 * static void copyDirectoryToDirectory(File src,File desc)
	 * 复制文件夹
	 */
	public static void function_3() throws IOException{
		FileUtils.copyDirectoryToDirectory(new File("d:\\demo"), new File("c:\\"));
	}
	
	/*
	 * FileUtils工具类的方法
	 * static void copyFile(File src,File desc)
	 * 复制文件
	 */
	public static void function_2() throws IOException{
		FileUtils.copyFile(new File("c:\\k.jpg"),new File("d:\\k.jpg"));
	}
	
	/*
	 * FileUtils工具类的方法
	 * static void writeStringToFile(File src,String date)
	 * 将字符串直接写到文件中
	 */
	public static void function_1() throws IOException{
		FileUtils.writeStringToFile(new File("c:\\b.txt"),"我爱Java编程");
	}
	
	/*
	 * FileUtils工具类的方法
	 * static String readFileToString(File src)读取文本,返回字符串
	 */
	 public static void function() throws IOException{
		 String s = FileUtils.readFileToString(new File("c:\\a.txt"));
		 System.out.println(s);
	 }
}
 ~~~

