package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("E:\\2019JAVAѧϰ\\Java����\\worksapce\\"
				+ "Day23\\src\\cn\\itcast\\demo\\abc.txt ");
		//������ķ���write
		fos.write('1');
		fos.write('0');
		fos.write('0');
		fos.close();
	}
}
