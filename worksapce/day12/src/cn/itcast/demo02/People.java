package cn.itcast.demo02;

public class People {
	String name;
	int age;
	public People(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAge() {
		return this.age;
	}
	public void getAge(int age) {
		this.age=age;
	}
}
