package cn.itcast.homework;

import java.math.BigDecimal;
import java.util.ArrayList;

/*
 *  用循环实现不死神兔
	故事得从西元1202年说起，话说有一位意大利青年，名叫斐波那契。
	在他的一部著作中提出了一个有趣的问题：假设一对刚出生的小兔一个月后就能长成大兔，
	再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，一年内没有发生死亡，
	问：一对刚出生的兔子，一年内繁殖成多少对兔子?
	
	 1 1 2 3 5 8 13 21
 */
public class homework1 {

	public static void main(String[] args) {
		function_1();
	}
	//12个月繁衍多少只
	public static void function() {
		int[] arr =new int[12];
		arr[0]=1;
		arr[1]=1;
		int number=0;
		for(int i=2;i<arr.length;i++) {
			arr[i]=arr[i-1]+arr[i-2];
			
		}
		System.out.println(arr[11]);
	}
	//100个月繁衍多少只
	public static void function_1() {
		ArrayList <BigDecimal> arr=new ArrayList<BigDecimal>();
		BigDecimal a=new BigDecimal(1);
		BigDecimal b=new BigDecimal(2);
		arr.add(a);
		arr.add(b);
		for(int i=2;i<100;i++) {
			BigDecimal c1=arr.get(i-1);
			BigDecimal c2=arr.get(i-2);
			BigDecimal c3=c1.add(c2);
			arr.add(c3);		
		}
		System.out.println(arr.get(99));
		
	}
}
