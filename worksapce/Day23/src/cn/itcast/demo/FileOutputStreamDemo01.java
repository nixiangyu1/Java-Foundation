package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;
/*
 * ϸ��
 */
public class FileOutputStreamDemo01 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		// try ��������������try���潨������
		try {
			fos = new FileOutputStream("E:\\2019JAVAѧϰ\\Java����\\worksapce\\Day23\\" + "src\\cn\\itcast\\demo\\abc.txt");
			fos.write(100);

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			throw new RuntimeException("�ļ�д��ʧ��");
		} finally {
			try {
				if(fos!=null)
				fos.close();
			} catch (IOException ex) {
				throw new RuntimeException("�ر�ϵͳ��Դʧ��");
			}
		}
	}
}
