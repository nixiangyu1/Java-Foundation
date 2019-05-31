package cn.itcast.demo02;

import java.io.FileReader;
import java.io.IOException;

/*
 * 
 */
public class ReaderDemo  {
	public static void main(String[] args) throws IOException {
		FileReader fr= new FileReader("E:\\2019JAVAÑ§Ï°\\Java»ù´¡\\worksapce\\"
				+ "Day23\\src\\cn\\itcast\\demo\\abc.txt");
		int len=0;
		while((len=fr.read())!=-1) {
			System.out.print((char)len);
		}
		fr.close();
	}
}
