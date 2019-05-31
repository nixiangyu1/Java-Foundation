package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterDemo {

	public static void main(String[] args) throws IOException {
		writeGBK();
		WriteUTF();
	}
	/*
	 * 转换流对象OutputStreamWriter写文本
	 * 采用UTF-8编码表写入
	 */
	public static void WriteUTF() throws IOException {
		FileOutputStream fos = new FileOutputStream("e:\\utf.txt");
		OutputStreamWriter osw= new OutputStreamWriter(fos, "UTF-8");
		osw.write("你好");
		osw.flush();
		osw.close();
	}
	
	public static void writeGBK() throws IOException {
		//创建字节输出流，绑定数据文件
		FileOutputStream fos =new FileOutputStream("e:\\abc.txt");
		//创建转换流对象，构造方法，绑定字节输出流,使用GBK码表
		OutputStreamWriter osw= new OutputStreamWriter(fos);
		//转换流写数据
		osw.write("你好");
		osw.flush();
		osw.close();
	}
}
