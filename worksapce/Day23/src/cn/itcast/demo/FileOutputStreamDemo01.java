package cn.itcast.demo;

import java.io.FileOutputStream;
import java.io.IOException;
/*
 * 细节
 */
public class FileOutputStreamDemo01 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		// try 外面声明变量，try里面建立对象
		try {
			fos = new FileOutputStream("E:\\2019JAVA学习\\Java基础\\worksapce\\Day23\\" + "src\\cn\\itcast\\demo\\abc.txt");
			fos.write(100);

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			throw new RuntimeException("文件写入失败");
		} finally {
			try {
				if(fos!=null)
				fos.close();
			} catch (IOException ex) {
				throw new RuntimeException("关闭系统资源失败");
			}
		}
	}
}
