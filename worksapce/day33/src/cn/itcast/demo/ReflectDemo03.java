package cn.itcast.demo;

public class ReflectDemo03 {
	public static void main(String[] args) throws Exception {
		Class c=Class.forName("cn.itcast.demo.Person");
		//Class类中定义方法，
		Object obj=c.newInstance();
		System.out.println(obj);
	}
}
