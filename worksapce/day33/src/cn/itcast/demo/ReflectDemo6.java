package cn.itcast.demo;

import java.lang.reflect.Method;

public class ReflectDemo6 {
	public static void main(String[] args) throws Exception {
		Class c=Class.forName("cn.itcast.demo.Person");
		Object obj = c.newInstance();
//		Method[] methods=c.getMethods();
//		for(Method m:methods) {
//			System.out.println(m);
//		}
		Method method=c.getMethod("eat");
		//ʹ��Method���еķ��������л�õ�eat����
		method.invoke(obj);
	}
}
