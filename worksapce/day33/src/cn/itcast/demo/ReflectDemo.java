package cn.itcast.demo;

import java.lang.reflect.Constructor;

/*
 * ͨ�������ȡclass�ļ��еĹ��췽�������й��췽��
 * ͨ�����췽����������ϣ��
 * 		��ȡclass
 */
public class ReflectDemo {
	public static void main(String[] args) throws Exception{
		Class c =Class.forName("cn.itcast.demo.Person");
		//ʹ��class�ļ�����ȡ���еĹ��췽��
		//getConstructors()��ȡclass�ļ������е����й��Ĺ��췽��
//	    Constructor[] cons=c.getConstructors();
//	    for(Constructor con:cons) {
//	    	System.out.println(con);
//	    }
		Constructor con=c.getConstructor();
		Object obj=con.newInstance();
		System.out.println(obj.toString());
	}
}
