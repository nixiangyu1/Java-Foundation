#### 23.1字节流

##### 23.1.1字节输出流OutputStream

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10056\wps6.jpg)

~~~java

package cn.itcast.demo;
/*
 *  字节输出流
 *    java.io.OutputStream 所有字节输出流的超类
 *    作用: 从Java程序,写出文件
 *    字节: 这样流每次只操作文件中的1个字节
 *    写任意文件
 *    
 *    方法都是写文入的方法
 *    write(int b) 写入1个字节
 *    write(byte[] b) 写入字节数组
 *    write(byte[] b,int,int)写入字节数组,int 开始写入的索引, int 写几个
 *    close() 方法,关闭流对象,释放与次流相关的资源
 *    
 *    流对象,操作文件的时候, 自己不做,依赖操作系统
 */
public class OutputStreamDemo {

}

~~~

##### 23.1.2字节输出流FileOutputStream写字节

~~~java
package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 *   FileOutputStream
 *   写入数据文件,学习父类方法,使用子类对象
 *   
 *   子类中的构造方法: 作用:绑定输出的输出目的
 *     参数:
 *       File    封装文件
 *       String  字符串的文件名
 *   
 *   流对象使用步骤
 *     1. 创建流子类的对象,绑定数据目的
 *     2. 调用流对象的方法write写
 *     3. close释放资源
 *     
 *    流对象的构造方法,可以创建文件,如果文件存在,直接覆盖
 */
public class FileOutputStreamDemo {
	public static void main(String[] args)throws IOException {
		FileOutputStream fos = new FileOutputStream("c:\\a.txt");
		//流对象的方法write写数据
		//写1个字节
		fos.write(97);
		
		//写字节数组
		byte[] bytes = {65,66,67,68};
		fos.write(bytes);
		
		//写字节数组的一部分,开始索引,写几个
		fos.write(bytes, 1, 2);
		 
		//写入字节数组的简便方式
		//写字符串
		fos.write("hello".getBytes());

		//关闭资源
		fos.close();
		
	}
}

~~~

##### 23.1.3文件的续写和换行符号

~~~java
package cn.itcast.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  FileOutputStream 文件的续写和换行问题
 *  续写: FileOutputStream构造方法, 的第二个参数中,加入true
 *  在文件中,写入换行,符号换行  \r\n
 *  \r\n 可以写在上一行的末尾, 也可以写在下一行的开头
 */
public class FileOutputStreamDemo1 {
	public static void main(String[] args)throws IOException {
		File file = new File("c:\\b.txt");
		FileOutputStream fos = new FileOutputStream(file,true);
		fos.write("hello\r\n".getBytes());
		fos.write("world".getBytes());
		fos.close();
	}
}
~~~

##### 23.1.4IO中的异常处理

~~~java
package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 *   IO流的异常处理
 *   try catch finally
 *   
 *   细节:
 *     1. 保证流对象变量,作用域足够
 *     2. catch里面,怎么处理异常
 *         输出异常的信息,目的看到哪里出现了问题
 *         停下程序,从新尝试
 *     3. 如果流对象建立失败了,需要关闭资源吗
 *         new 对象的时候,失败了,没有占用系统资源
 *         释放资源的时候,对流对象判断null
 *         变量不是null,对象建立成功,需要关闭资源
 */
public class FileOutputStreamDemo3 {
	public static void main(String[] args) {
		//try 外面声明变量,try 里面建立对象
		FileOutputStream fos = null;
		try{
			fos = new FileOutputStream("s:\\a.txt");
			fos.write(100);
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("文件写入失败,重试");
		}finally{
			try{
				if(fos!=null)
			      fos.close();
			}catch(IOException ex){
				throw new RuntimeException("关闭资源失败");
			}
		}
	}
}

~~~

##### 23.1.5字节输入流InputStream

~~~java
package cn.itcast.demo1;
/*
 *   字节输入流
 *     java.io.InputStream 所有字节输入流的超类
 *   作用: 读取任意文件,每次只读取1个字节
 *   读取的方法  read
 *     int  read() 读取1个字节
 *     int  read(byte[] b) 读取一定量的字节,存储到数组中
 */
public class InputStreamDemo {

}
~~~

##### 23.1.6字节输入流FileInputStream读取字节

~~~java
package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.IOException;

/*
 *  FileInputStream读取文件
 *  
 *  构造方法: 为这个流对象绑定数据源
 *  
 *    参数: 
 *      File 类型对象
 *      String 对象
 *   输入流读取文件的步骤
 *     1. 创建字节输入流的子类对象
 *     2. 调用读取方法read读取
 *     3. 关闭资源
 *     
 *     read()方法,
 *       read()执行一次,就会自动读取下一个字节
 *       返回值,返回的是读取到的字节, 读取到结尾返回-1
 */
public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("c:\\a.txt");
		//读取一个字节,调用方法read 返回int
		//使用循环方式,读取文件,  循环结束的条件  read()方法返回-1
		int len = 0;//接受read方法的返回值
	
		while( (len = fis.read()) != -1){
			System.out.print((char)len);
		}
    	//关闭资源
		fis.close();
	}
}

/*
 * int i = fis.read();
		System.out.println(i);
		
		i = fis.read();
		System.out.println(i);
		
		i = fis.read();
		System.out.println(i);
		
		i = fis.read();
		System.out.println(i);
 */

~~~

##### 23.1.7FileInputStream读取字节数组

~~~java
package cn.itcast.demo1;

import java.io.FileInputStream;
import java.io.IOException;

/*
 *  FileInputStream读取文件
 *   读取方法  int read(byte[] b) 读取字节数组
 *   数组作用: 缓冲的作用, 提高效率
 *   read返回的int,表示什么含义 读取到多少个有效的字节数
 */
public class FileInputStreamDemo1 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("c:\\a.txt");
		//创建字节数组
		byte[] b = new byte[1024];
		
		int len = 0 ;
		while( (len = fis.read(b)) !=-1){
			System.out.print(new String(b,0,len));
		}
		fis.close();
	}
}
/*
 * 
		int len = fis.read(b);
		System.out.println(new String(b));//ab
		System.out.println(len);//2
		
		len = fis.read(b);
		System.out.println(new String(b));//cd
		System.out.println(len);//2
		
		len = fis.read(b);
		System.out.println(new String(b));//ed
		System.out.println(len);//1
		
		len = fis.read(b);
		System.out.println(new String(b));//ed
		System.out.println(len);//-1
		*/

~~~

##### 23.1.8字节流复制文件读取单个字节

~~~java
package cn.itcast.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  将数据源 c:\\a.txt
 *  复制到 d:\\a.txt  数据目的
 *  字节输入流,绑定数据源
 *  字节输出流,绑定数据目的
 *  
 *  输入,读取1个字节
 *  输出,写1个字节
 */
public class Copy {
	public static void main(String[] args) {
		//定义两个流的对象变量
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			//建立两个流的对象,绑定数据源和数据目的
			fis = new FileInputStream("c:\\t.zip");
			fos = new FileOutputStream("d:\\t.zip");
			//字节输入流,读取1个字节,输出流写1个字节
			int len = 0 ;
			while((len = fis.read())!=-1){
				fos.write(len);
			}
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("文件复制失败");
		}finally{
			try{
				if(fos!=null)
					fos.close();
			}catch(IOException ex){
				throw new RuntimeException("释放资源失败");
			}finally{
				try{
					if(fis!=null)
						fis.close();
				}catch(IOException ex){
					throw new RuntimeException("释放资源失败");
				}
			}
		}
	}
}

~~~

##### 23.1.9字节流复制文件读取字节数组

~~~java
package cn.itcast.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  字节流复制文件
 *   采用数组缓冲提高效率
 *   字节数组
 *   FileInputStream 读取字节数组
 *   FileOutputStream 写字节数组
 */
public class Copy_1 {
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try{
			fis = new FileInputStream("c:\\t.zip");
			fos = new FileOutputStream("d:\\t.zip");
			//定义字节数组,缓冲
			byte[] bytes = new byte[1024*10];
			//读取数组,写入数组
			int len = 0 ; 
			while((len = fis.read(bytes))!=-1){
				fos.write(bytes, 0, len);
			}
		}catch(IOException ex){
			System.out.println(ex);
			throw new RuntimeException("文件复制失败");
		}finally{
			try{
				if(fos!=null)
					fos.close();
			}catch(IOException ex){
				throw new RuntimeException("释放资源失败");
			}finally{
				try{
					if(fis!=null)
						fis.close();
				}catch(IOException ex){
					throw new RuntimeException("释放资源失败");
				}
			}
		}
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}
}

~~~

#### 23.2字符流

##### 23.2.1字符输出流写文本FileWrite类

~~~java
package cn.itcast.demo2;

import java.io.FileWriter;
import java.io.IOException;

/*
 *   字符输出流
 *     java.io.Writer 所有字符输出流的超类
 *   写文件,写文本文件
 *   
 *   写的方法 write
 *     write(int c) 写1个字符
 *     write(char[] c)写字符数组
 *     write(char[] c,int,int)字符数组一部分,开始索引,写几个
 *     write(String s) 写入字符串
 *     
 *   Writer类的子类对象 FileWriter
 *   
 *   构造方法:  写入的数据目的
 *     File 类型对象
 *     String 文件名
 *     
 *   字符输出流写数据的时候,必须要运行一个功能,刷新功能
 *   flush()
 */
public class WriterDemo {
	public static void main(String[] args) throws IOException{
		FileWriter fw = new FileWriter("c:\\1.txt");
		
		//写1个字符
		fw.write(100);
		fw.flush();
		
		//写1个字符数组
		char[] c = {'a','b','c','d','e'};
		fw.write(c);
		fw.flush();
		
		//写字符数组一部分
		fw.write(c, 2, 2);
		fw.flush();
		
		//写如字符串
		fw.write("hello");
		fw.flush();
		
		fw.close();
	}
}

~~~

##### 23.2.2字符输入流读取文本FileReader类 

~~~java
package cn.itcast.demo2;

import java.io.FileReader;
import java.io.IOException;

/*
 *  字符输入流读取文本文件,所有字符输入流的超类
 *    java.io.Reader
 *  专门读取文本文件
 *  
 *  读取的方法 : read()
 *   int read() 读取1个字符
 *   int read(char[] c) 读取字符数组
 *   
 *   Reader类是抽象类,找到子类对象 FileReader
 *   
 *   构造方法: 绑定数据源
 *     参数:
 *        File  类型对象
 *        String文件名
 */
public class ReaderDemo {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("c:\\1.txt");
		/*int len = 0 ;
		while((len = fr.read())!=-1){
			System.out.print((char)len);
		}*/
		char[] ch = new char[1024];
		int len = 0 ;
		while((len = fr.read(ch))!=-1){
			System.out.print(new String(ch,0,len));
		}
		
		fr.close();
	}
}
~~~

