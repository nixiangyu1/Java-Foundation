package cn.itcast.demo06;

public class Person {
	private int age;
	
	
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	
	/*
	 * 定义方法:比较是否同龄人，是就返回true，不是就返回false
	 * 谁和谁比，我自己和别人比
	 * 方法的返回值  true  false
	 * 方法的参数：别人
	 */
	public boolean compare(Person p) {
		//自己和别人比年龄，自己是this.p
		return this.age==p.age;
	}
}
