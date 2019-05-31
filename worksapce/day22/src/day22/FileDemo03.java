package day22;

import java.io.File;

public class FileDemo03 {

	public static void main(String[] args) {
		File dir = new File("E:\\2019JAVAÑ§Ï°\\Java»ù´¡");
		getAllDir(dir);
	}
	public static void getAllDir(File dir) {
		File[] fileArr= dir.listFiles();
		for(File f:fileArr) {
			if(f.isDirectory()) {
				getAllDir(f);
			}else {
				
				System.out.println(f);
			}
		}
	}
}
