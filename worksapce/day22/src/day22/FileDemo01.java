package day22;

import java.io.File;
import java.io.IOException;

public class FileDemo01 {

	public static void main(String[] args) throws Exception {
		function();
	}
	public static void function() throws Exception {
		File file = new File("e:\\11ganme");
		System.out.println(file);
		File file1= new File(file,"helloword");
		System.out.println(file1);
		boolean b = file1.createNewFile();
		System.out.println(b);
	}
}
