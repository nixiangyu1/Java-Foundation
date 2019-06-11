package cn.itcast.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 * 定义集合类，泛型String
 * 要求向集合中添加Integer类型
 * 
 */
public class ReflectTest {
	public static void main(String[] args) throws Exception, SecurityException {
		ArrayList<String> array = new ArrayList<String>();
		array.add("a");
		Class c=ArrayList.class;
		Method method=c.getMethod("add", Object.class);
		method.invoke(array, 150);
		method.invoke(array, 250);
		method.invoke(array, 350);
		System.out.println(array);
	}
}
