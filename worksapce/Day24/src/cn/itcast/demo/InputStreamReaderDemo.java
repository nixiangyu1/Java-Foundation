package cn.itcast.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderDemo {

	public static void main(String[] args) throws IOException {
		readGBK();
		readUTF();
	}
	/*
	 * 采用UTF-8编码表,读取文件Utf
	 */
	public static void readUTF() throws IOException {
		FileInputStream fis = new FileInputStream("e:\\utf.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		char[] ch = new char[1024];
		int len= isr.read(ch);
		System.out.println(new String(ch,0,len));
		isr.close();
	}
	
	
	/*
	 * 采用系统默认的编码表，读取GBK文件
	 */
	public static void readGBK() throws IOException{
		FileInputStream fis = new FileInputStream("e:\\utf.txt");
		InputStreamReader isr = new InputStreamReader(fis);
		char[] ch = new char[1024];
		int len= isr.read(ch);
		System.out.println(new String(ch,0,len));
		isr.close();
	}
}
