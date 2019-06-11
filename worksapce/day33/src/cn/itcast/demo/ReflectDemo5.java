package cn.itcast.demo;

import java.lang.reflect.Field;

public class ReflectDemo5 {
	public static void main(String[] args) throws Exception {
		Class c=Class.forName("cn.itcast.demo.Person");
		Object obj = c.newInstance();
//		Field[] fields=c.getFields();
//		for(Field f:fields) {
//			System.out.println(f);
//		}
		Field field=c.getField("name");
		field.set(obj, "ÍõÎå");
		System.out.println(obj);
	}
}
