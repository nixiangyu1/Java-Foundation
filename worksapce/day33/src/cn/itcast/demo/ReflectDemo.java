package cn.itcast.demo;

import java.lang.reflect.Constructor;

/*
 * 通过反射获取class文件中的构造方法，运行构造方法
 * 通过构造方法，创建杜希昂
 * 		获取class
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception{
		Class c =Class.forName("cn.itcast.demo.Person");
		//使用class文件，获取类中的构造方法
		//getConstructors()获取class文件对象中的所有共的构造方法
//	    Constructor[] cons=c.getConstructors();
//	    for(Constructor con:cons) {
//	    	System.out.println(con);
//	    }
		Constructor con=c.getConstructor();
		Object obj=con.newInstance();
		System.out.println(obj.toString());
	}
}
