package cn.itcast.demo07;

import java.util.ArrayList;
import java.util.Random;

/*
 * 随机点名器案例
 * 1.建立集合，将Student对象存储到集合中
 * 2.总览所有学生的信息
 * 	将存储到集合中的Student对象遍历出来
 * 3.随机学生
 * 	随机数，作为索引，到集合中区查找找匀速
 */
public class CallName {

	public static void main(String[] args) {
		ArrayList<Student> array=new ArrayList<Student>();
		addStudent(array);
		printStudent(array);
		randomStudent(array);
		
	}
	
	
	/*
	 * 定义方法，总览学生信息
	 * 遍历集合
	 */
	public static void printStudent(ArrayList<Student> array) {
		for(int i=0;i<array.size();i++) {
			Student s=array.get(i);
			System.out.println(s.getName()+"  "+s.getAge());
		}
	}
	
	
	/*
	 * 随机数生成学生信息
	 */
	
	public static void randomStudent(ArrayList<Student> array) {
		Random ra=new Random();
		int index=ra.nextInt(array.size());
		Student s=array.get(index);
		System.out.println(s.getName());
	}
	
	/*
	 * 定义方法，存储Student对象，到集合中
	 */
	public static void addStudent(ArrayList<Student> array) {
		Student s1=new Student();
		s1.setName("李一");
		s1.setAge(11);
		
		Student s2=new Student();
		s2.setName("李二");
		s2.setAge(12);
		
		Student s3=new Student();
		s3.setName("李三");
		s3.setAge(13);
		
		Student s4=new Student();
		s4.setName("李四");
		s4.setAge(14);
		
		Student s5=new Student();
		s5.setName("李五");
		s5.setAge(15);
		
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
	}
}
