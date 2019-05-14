package cn.itcast.demo05;
/*
 * 类描述人：
 *  	属性：姓名和年龄
 *  	方法：说话
 *  
 *  
 *  私有化所有的属性(成员变量)，必须写对应的get/set方法
 *  凡是自定义的类，自定义的成员变量，应该私有化，提供get/set
 *  
 */
public class Person {
	private String name;
	private int age;
	
	//set方法，变量name,age赋值
	public void setAge(int a) {
		age=a;
	}
	public void setName(String n) {
		name=n;
	}
	
	//get方法，变量name,age获取值
	public int getAge() {
		return age;
		
	}
	public String getName() {
		return name;
		
	}
	
	public void speak() {
		System.out.println("人在说话"+name+"..."+age);
	}
}
