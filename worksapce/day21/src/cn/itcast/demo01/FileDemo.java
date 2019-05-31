package cn.itcast.demo01;

import java.io.File;

public class FileDemo {
	public static void main(String[] args) {
		//File类的静态成员变量
		//与系统有关的路径分配
		String separator=File.pathSeparator;	
		System.out.println(separator);
		
		//
		separator=File.separator;
		System.out.println(separator);
	}
}
