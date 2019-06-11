package cn.itcast.demo;

import java.lang.reflect.Method;

public class ReflectDemo7 {
	public static void main(String[] args) throws Exception{
		Class c=Class.forName("cn.itcast.demo.Person");
		Object obj=c.newInstance();
		Method method=c.getMethod("sleep", String.class,int.class,double.class);
		System.out.println(method);
		//����Method��ķ���invoke����sleep����
		method.invoke(obj, "����",100,888.44);
	}
}
