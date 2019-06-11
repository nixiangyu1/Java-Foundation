package cn.itcast.demo3;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
	public static void main(String[] args) throws Exception{
		//IO��ȡ�����ļ�
		FileReader r= new FileReader("config.properties");
		//�������϶���
		Properties pro = new Properties();
		pro.load(r);
		r.close();
		//ͨ������ȡֵ
		String className=pro.getProperty("className");
		String methodName=pro.getProperty("methodName");
		Class c = Class.forName(className);
		Object obj = c.newInstance();
		Method method =c.getMethod(methodName);
		method.invoke(obj);
	}
}
