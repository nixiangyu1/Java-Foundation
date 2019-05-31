package cn.itcast.demo01;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("E:\\2019JAVA学习\\Java基础\\worksapce\\Day23\\src\\cn\\itcast\\demo\\abc.txt");
		//写一个字符
		fw.write(100);
		fw.flush();
		
		//写一个字符数组
		char[] c = {'a','b','c'};
		fw.write(c);
		//写入字符数组的一部分
		fw.write(c,0,2);
		fw.close();
	}

}
