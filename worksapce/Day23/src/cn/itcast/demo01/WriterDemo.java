package cn.itcast.demo01;

import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {

	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("E:\\2019JAVAѧϰ\\Java����\\worksapce\\Day23\\src\\cn\\itcast\\demo\\abc.txt");
		//дһ���ַ�
		fw.write(100);
		fw.flush();
		
		//дһ���ַ�����
		char[] c = {'a','b','c'};
		fw.write(c);
		//д���ַ������һ����
		fw.write(c,0,2);
		fw.close();
	}

}
