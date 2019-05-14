package cn.itcast.demo07;

import java.util.ArrayList;
import java.util.Random;

/*
 * �������������
 * 1.�������ϣ���Student����洢��������
 * 2.��������ѧ������Ϣ
 * 	���洢�������е�Student�����������
 * 3.���ѧ��
 * 	���������Ϊ��������������������������
 */
public class CallName {

	public static void main(String[] args) {
		ArrayList<Student> array=new ArrayList<Student>();
		addStudent(array);
		printStudent(array);
		randomStudent(array);
		
	}
	
	
	/*
	 * ���巽��������ѧ����Ϣ
	 * ��������
	 */
	public static void printStudent(ArrayList<Student> array) {
		for(int i=0;i<array.size();i++) {
			Student s=array.get(i);
			System.out.println(s.getName()+"  "+s.getAge());
		}
	}
	
	
	/*
	 * ���������ѧ����Ϣ
	 */
	
	public static void randomStudent(ArrayList<Student> array) {
		Random ra=new Random();
		int index=ra.nextInt(array.size());
		Student s=array.get(index);
		System.out.println(s.getName());
	}
	
	/*
	 * ���巽�����洢Student���󣬵�������
	 */
	public static void addStudent(ArrayList<Student> array) {
		Student s1=new Student();
		s1.setName("��һ");
		s1.setAge(11);
		
		Student s2=new Student();
		s2.setName("���");
		s2.setAge(12);
		
		Student s3=new Student();
		s3.setName("����");
		s3.setAge(13);
		
		Student s4=new Student();
		s4.setName("����");
		s4.setAge(14);
		
		Student s5=new Student();
		s5.setName("����");
		s5.setAge(15);
		
		array.add(s1);
		array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
	}
}
