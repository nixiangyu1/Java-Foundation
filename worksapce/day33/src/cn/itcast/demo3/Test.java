package cn.itcast.demo3;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws Exception{
		//IO读取配置文件
		FileReader r= new FileReader("config.properties");
		//创建集合对象
		Properties pro = new Properties();
		pro.load(r);
		r.close();
		//通过键获取值
		String className=pro.getProperty("className");
		String methodName=pro.getProperty("methodName");
		Class c = Class.forName(className);
		Object obj = c.newInstance();
		Method method =c.getMethod(methodName);
		method.invoke(obj);
	}
}
