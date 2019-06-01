package cn.itcast.demo03;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Commons_IODemo01 {

	public static void main(String[] args) throws IOException {
		function();
	}
	/*
	 * FileUtilsπ§æﬂ¿€
	 * 
	 */
	public static void function() throws IOException {
	
		String s = FileUtils.readFileToString(new File("e:\\abc.txt"));
		System.out.println(s);
	}
	
}
