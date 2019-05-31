package cn.itcast.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  �ļ����Ʒ�ʽ,�ֽ���,һ��4����ʽ
 *  1. �ֽ�����д�����ֽ�                    6406 ����
 *  2. �ֽ�����д�ֽ�����                    15    ����  OK
 *  3. �ֽ�������������д�����ֽ�     156   ����
 *  4. �ֽ�������������д�ֽ�����     73     ����  OK
 */
public class Copy {

	public static void main(String[] args) throws IOException {
		copy_3(new File("e:\\p.pptx"),new File("e:\\t.pptx"));
	}
	//1. �ֽ�����д�����ֽ� 
	public static void copy_1(File src,File desc) throws IOException{
		long s= System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos= new FileOutputStream(desc);
		int len=0;
		while((len=fis.read())!=-1) {
			fos.write(len);
		}
		fos.close();
		fis.close();
		long e= System.currentTimeMillis();
		System.out.println(e-s);
	}
	//2. �ֽ�����д�ֽ�����
	public static void copy_2(File src,File desc) throws IOException{
		long s=System.currentTimeMillis();
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos=new FileOutputStream(desc);
		int len=0;
		byte[] bytes= new byte[1024];
		while((len=fis.read(bytes))!=-1) {
			fos.write(bytes, 0, len);
		}
		fos.close();
		fis.close();
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}
	//3.�ֽ�������������д�����ֽ�
	public static void copy_3(File src,File desc) throws IOException{
		long s=System.currentTimeMillis();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos= new BufferedOutputStream(new FileOutputStream(desc));
		
		int len=0;
		while((len=bis.read())!=-1) {
			bos.write(len);
		}
		
		bos.close();
		bis.close();
		long e = System.currentTimeMillis();
		System.out.println(e-s);
	}
}
