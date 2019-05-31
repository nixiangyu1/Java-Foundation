package cn.itcast.demo01;

import java.io.File;

/*
 * File类的构造方法
 * 三种重载形式
 */
public class FileDemo01 {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * 
	 */
	public static void function() {
		File file = new File("E:\\11game");
		System.out.println(file);
	}
	public static void function_1() {
		 File file = new File("c:","windows");
		 System.out.println(file);
	}
}
