package cn.itcast.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		function_2 ();
	}
	// 
	public static void function_2() throws IOException{
		Properties pro = new Properties();
		pro.setProperty("name", "张三");
		pro.setProperty("age", "31");
		pro.setProperty("email", "123456@qq.com");
		FileWriter fw = new FileWriter("e:\\pro.properties");
		pro.store(fw, "abc");
		fw.close();
		
	}
	
	//Properties集合的特有方法load(InputStream)
	public static void function_1() throws IOException {
		Properties pro = new Properties();
		FileReader fr = new FileReader("e:\\pro.properties");
		//调用集合的方法load,传递字符输入流
		pro.load(fr);
		fr.close();
		System.out.println(pro);
	}

}
