package cn.itcast.demo;

import java.lang.reflect.Constructor;

public class ReflectDemo4 {
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("cn.itcast.demo.Person");
		//getDeclaredConstructor()	��ȡ���еĹ��췽��������˽�з���
		Constructor con=c.getDeclaredConstructor(int.class,String.class);
		System.out.println(con);
		con.setAccessible(true);
		Object obj=con.newInstance(18,"����");
		System.out.println(obj);
	}
}
