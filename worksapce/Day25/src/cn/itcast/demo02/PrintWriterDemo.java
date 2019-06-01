package cn.itcast.demo02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/*
 * ´òÓ¡Á÷
 * 	PrintStream
 *  PrintWriter
 *  
 */
public class PrintWriterDemo {
	public static void main(String[] args) throws FileNotFoundException {
		function();
	}
	public static void function() throws FileNotFoundException {
		File file = new File("e:\\1.txt");
		PrintWriter pw= new PrintWriter(file);
		pw.println(100);
		pw.print(123);
		pw.close();
	}
}
