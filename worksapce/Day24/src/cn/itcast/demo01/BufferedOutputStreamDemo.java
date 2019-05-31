package cn.itcast.demo01;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("e:\\buffer.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		bos.write(55);
		byte[] bytes = "HelloWorld".getBytes();
		bos.write(bytes);
		bos.close();
	}

} 
