package cn.itcast.demo04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {
	public static void main(String[] args) throws Exception {
		function();
	}
	/*
	 * ������������ڶ�������
	 */
	public static void function() throws Exception {
		System.out.println("���������ĳ�������(��ʽ��yyyy-MM-dd)");
		String birthdayString =new Scanner(System.in).next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthdayDate = sdf.parse(birthdayString);
		Date todayDate=new Date();
		long birthdaySecond=birthdayDate.getTime();
		long todaySecond=todayDate.getTime();
		long second=todaySecond-birthdaySecond;
		System.out.println(second/1000/60/60/24/365);
	}
}
