package cn.itcast.homework;

import java.math.BigDecimal;
import java.util.ArrayList;

/*
 *  ��ѭ��ʵ�ֲ�������
	���µô���Ԫ1202��˵�𣬻�˵��һλ��������꣬����쳲�������
	������һ�������������һ����Ȥ�����⣺����һ�Ըճ�����С��һ���º���ܳ��ɴ��ã�
	�ٹ�һ���¾�������һ��С�ã����Ҵ˺�ÿ���¶���һ��С�ã�һ����û�з���������
	�ʣ�һ�Ըճ��������ӣ�һ���ڷ�ֳ�ɶ��ٶ�����?
	
	 1 1 2 3 5 8 13 21
 */
public class homework1 {

	public static void main(String[] args) {
		function_1();
	}
	//12���·��ܶ���ֻ
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
	//100���·��ܶ���ֻ
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
