package cn.itcast.demo04;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTest {
	public static void main(String[] args) throws Exception {
		function();
	}
	/*
	 * 计算出生到现在多少岁了
	 */
	public static void function() throws Exception {
		System.out.println("请输入您的出生日期(格式：yyyy-MM-dd)");
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
