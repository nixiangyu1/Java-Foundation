package cn.itcast.demo02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo02 {

	public static void main(String[] args) throws IOException {
		BufferedReader bfr = new BufferedReader(new FileReader("e:\\abc.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("e:\\fgh.txt"),true);
		String len=null;
		while((len=bfr.readLine())!=null) {
			pw.println(len);
		}
		pw.close();
	}

}
