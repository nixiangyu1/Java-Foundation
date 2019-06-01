package cn.itcast.demo03;

import org.apache.commons.io.FilenameUtils;

public class Commons_IODemo {

	public static void main(String[] args) {
		function();
	}
/*
 * FilenameUtils类的方法
 * static Stirng getExtension
 */
	public static void function() {
		String name= FilenameUtils.getExtension("abc.java");
		System.out.println(name);
	}
}
