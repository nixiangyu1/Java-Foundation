package cn.itcast.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		FileInputStream fis= null;
		FileOutputStream fos=null;
		try {
			//�����������Ķ��򣬰�����Դ������Ŀ��
			fis=new FileInputStream("E:\\2019JAVAѧϰ\\Java����\\worksapce\\"
					+ "Day23\\src\\cn\\itcast\\demo\\abc.txt");
			fos=new FileOutputStream("E:\\2019JAVAѧϰ\\Java����\\worksapce\\"
					+ "Day23\\src\\cn\\itcast\\demo\\bcd.txt");
			int len=0;
			while((len=fis.read())!=-1) {
				fos.write(len);
			}
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("�ļ�����ʧ��");
		}finally {
			try {
				if(fos!=null)
					fos.close();
			}catch(IOException ex) {
				throw new RuntimeException("�ͷ���Դʧ��");
			}finally {
				try {
						if(fis!=null)
							fis.close();
				}catch(IOException ex) {
					throw new RuntimeException("�ͷ���Դʧ��");
				}
			}
		}
	}

}
