package cn.itcast.demo02;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HomeWork {

	public static void main(String[] args) {
		FileReader fr=null;
		FileWriter fw=null;
		try {
			fr= new FileReader("E:\\2019JAVAѧϰ\\Java����\\worksapce\\"
					+ "Day23\\src\\cn\\itcast\\demo\\abc.txt");
			fw=new FileWriter("E:\\2019JAVAѧϰ\\Java����\\worksapce\\"
					+ "Day23\\src\\cn\\itcast\\demo\\bcd.txt");
			char[] cbuf= new char[1024];
			int len=0;
			while((len=fr.read(cbuf))!=-1) {
				fw.write(cbuf,0,len);
				fw.flush();
			}
		}catch(IOException ex){
			 System.out.println(ex);
			 throw new RuntimeException("����ʧ��");
		}finally {
			 try {
				 if(fw!=null) {
					 fw.close();
				 }
			 }catch(IOException ex) {
				 throw new RuntimeException("�ͷ���Դʧ��");
			 }finally {
				 try {
					 if(fr!=null) {
						 fr.close();
					 }
				 }catch(IOException ex) {
					 throw new RuntimeException("�ͷ���Դʧ��");
				 }
			 }
		}
		
	}

}
