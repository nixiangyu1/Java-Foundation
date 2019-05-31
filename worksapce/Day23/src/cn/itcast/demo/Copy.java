package cn.itcast.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		FileInputStream fis= null;
		FileOutputStream fos=null;
		try {
			//建立两个流的丢向，绑定数据源和数据目的
			fis=new FileInputStream("E:\\2019JAVA学习\\Java基础\\worksapce\\"
					+ "Day23\\src\\cn\\itcast\\demo\\abc.txt");
			fos=new FileOutputStream("E:\\2019JAVA学习\\Java基础\\worksapce\\"
					+ "Day23\\src\\cn\\itcast\\demo\\bcd.txt");
			int len=0;
			while((len=fis.read())!=-1) {
				fos.write(len);
			}
		}catch(IOException ex) {
			System.out.println(ex);
			throw new RuntimeException("文件复制失败");
		}finally {
			try {
				if(fos!=null)
					fos.close();
			}catch(IOException ex) {
				throw new RuntimeException("释放资源失败");
			}finally {
				try {
						if(fis!=null)
							fis.close();
				}catch(IOException ex) {
					throw new RuntimeException("释放资源失败");
				}
			}
		}
	}

}
