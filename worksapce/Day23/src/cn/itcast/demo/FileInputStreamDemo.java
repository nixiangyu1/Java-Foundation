package cn.itcast.demo;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("E:\\2019JAVAÑ§Ï°\\Java»ù´¡\\worksapce\\"
				+ "Day23\\src\\cn\\itcast\\demo\\abc.txt");
		byte[] b= new byte[2];
		
		
		int len=0;
		while((len=fis.read(b))!=-1) {
			System.out.print(new String(b,0,len));
		}
		
	}
}
