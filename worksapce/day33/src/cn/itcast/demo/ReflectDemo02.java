package cn.itcast.demo;

import java.lang.reflect.Constructor;

public class ReflectDemo02 {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo.Person");
		Constructor con = c.getConstructor(String.class,int.class);
		Object obj=con.newInstance("уехЩ",18);
		System.out.println(obj);
	}
}
