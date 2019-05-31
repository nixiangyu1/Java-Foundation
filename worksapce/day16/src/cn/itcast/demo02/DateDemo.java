package cn.itcast.demo02;

import java.util.Date;

/*
 * ʱ���������
 * 	 java.util.Date
 * 
 * ������ 1000����=1��
 * 
 * �����0�㣺
 * 		System.currentTimeMillis()����ֵlong���Ͳ���
 * 		��ȡ��ǰ���ڵĺ���ֵ	
 * 		ʱ��ԭ��;��Ԫ1970��1��1��,��ҹ0:0:0   ����ֵ����0
 * 	
 * ��Ҫ:ʱ������ڵļ���,������������ֵ
 *    XXX-XXX-XX= ����
 */
public class DateDemo {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time);
		function();
		function_1();
		function_2();
		function_3();
	}
	/*
	 * Date�෽��setTime(long)���ݺ���ֵ
	 * �����ڶ������õ�ָ������ֵ��
	 * ����ֵת�����ڶ���
	 */
	public static void function_3() {
		Date date=new Date();
		System.out.println(date);
		
		date.setTime(0);
		System.out.println(date);
	}
	/*
	 * 	Date�෽��getTime() ����ֵlong
	 * 	����ֵ�Ǻ���ֵ
	 */
	public static void function_2() {
		Date date=new Date();
		long time = date.getTime();
		System.out.println(time);
	}
	
	/*
	 * Date���long�����Ĺ��췽��
	 * Date(long)��ʾ����ֵ
	 * ���ݺ���ֵ��������ֵת�ɶ�Ӧ�����ڶ���
	 */
	public static void function_1() {
		Date date =new Date(0);
		System.out.println(date);
	}
	
	
	
	/*
	 * Date��ղ������췽��
	 * ��ȡ�����ǵ�ǰ����ϵͳ�е�ʱ�������
	 */
	public static void function() {
		Date date =new Date();
		System.out.println(date);
	}
}
