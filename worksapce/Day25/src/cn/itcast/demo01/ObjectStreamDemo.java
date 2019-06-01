package cn.itcast.demo01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * IO流对象，实现对象Person序列化，反序列化
 */
public class ObjectStreamDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		function_1();
	}
	//
	public static void function_1() throws IOException, ClassNotFoundException {
		FileInputStream fis= new FileInputStream("e:\\abc.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj=ois.readObject();
		System.out.println(obj);
		ois.close();
	}
	
	
	
	//
	public static void function() throws IOException{
		FileOutputStream fos = new FileOutputStream("e:\\abc.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Person p = new Person("李磊",22);
		oos.writeObject(p);
		oos.close();
	}
}
