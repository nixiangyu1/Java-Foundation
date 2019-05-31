package cn.itcast.copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *  文件复制方式,字节流,一共4个方式
 *  1. 字节流读写单个字节                    6406 毫秒
 *  2. 字节流读写字节数组                    15    毫秒  OK
 *  3. 字节流缓冲区流读写单个字节     156   毫秒
 *  4. 字节流缓冲区流读写字节数组     73     毫秒  OK
 */
public class Copy {

	public static void main(String[] args) throws IOException {
		copy_3(new File("e:\\p.pptx"),new File("e:\\t.pptx"));
	}
	//1. 字节流读写单个字节 
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
	//2. 字节流读写字节数组
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
	//3.字节流缓冲区流读写单个字节
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
