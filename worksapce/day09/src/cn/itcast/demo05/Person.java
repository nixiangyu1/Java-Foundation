package cn.itcast.demo05;
/*
 * �������ˣ�
 *  	���ԣ�����������
 *  	������˵��
 *  
 *  
 *  ˽�л����е�����(��Ա����)������д��Ӧ��get/set����
 *  �����Զ�����࣬�Զ���ĳ�Ա������Ӧ��˽�л����ṩget/set
 *  
 */
public class Person {
	private String name;
	private int age;
	
	//set����������name,age��ֵ
	public void setAge(int a) {
		age=a;
	}
	public void setName(String n) {
		name=n;
	}
	
	//get����������name,age��ȡֵ
	public int getAge() {
		return age;
		
	}
	public String getName() {
		return name;
		
	}
	
	public void speak() {
		System.out.println("����˵��"+name+"..."+age);
	}
}
