package day22;

import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		File dir =new File("E:\\2019JAVAѧϰ\\Java����");
		getAllDir(dir);
	}
	public static void getAllDir(File dir) {
		
		File[] fileArr =dir.listFiles(new MyJavaFilter());
		for(File f:fileArr) {
			if(f.isDirectory()) {
				getAllDir(f);
			}else {
				System.out.println(f);
			}
		}
	}
}
/*
 * File[] fileArr= dir.listFiles();
		for(File f:fileArr) {
			if(f.isDirectory()) {
				getAllDir(f);
			}else {
				
				System.out.println(f);
 * 
 * 
 * 
 * 
 */