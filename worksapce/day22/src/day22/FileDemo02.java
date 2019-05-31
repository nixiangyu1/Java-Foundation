package day22;

import java.io.File;

public class FileDemo02 {
	public static void main(String[] args) throws Exception{
		function_3();
	}
	public static void function() {
		File[] fileArr = File.listRoots();
		for(File f:fileArr) {
			System.out.println(f);
		}
	}
	public static void function_1() {
		File file = new File("d://");
		File[] fileArr= file.listFiles();
		for(File f:fileArr) {
			System.out.println(f);
		}
	}
	public static void function_2() {
		File file = new File("d://");
		String[] strArr = file.list();
		for(String s : strArr) {
			System.out.println(s);
		}
	}
	public static void function_3() {
		File file =new File("d://");
		File[] fileArr = file.listFiles(new MyFilter());
		for(File f:fileArr) {
			System.out.println(f);
		}
		
	}
}
