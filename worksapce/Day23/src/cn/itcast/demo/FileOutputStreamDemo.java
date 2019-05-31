package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("E:\\2019JAVA学习\\Java基础\\worksapce\\"
				+ "Day23\\src\\cn\\itcast\\demo\\abc.txt ");
		//流对象的方法write
		fos.write('1');
		fos.write('0');
		fos.write('0');
		fos.close();
	}
}
