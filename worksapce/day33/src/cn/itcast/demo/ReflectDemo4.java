package cn.itcast.demo;

import java.lang.reflect.Constructor;

public class ReflectDemo4 {
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("cn.itcast.demo.Person");
		//getDeclaredConstructor()	获取所有的构造方法，包括私有方法
		Constructor con=c.getDeclaredConstructor(int.class,String.class);
		System.out.println(con);
		con.setAccessible(true);
		Object obj=con.newInstance(18,"张三");
		System.out.println(obj);
	}
}
