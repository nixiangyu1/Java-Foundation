package cn.itcast.demo01;

public class IntegerDemo01 {
	public static void main(String[] args) {
		function();
		function_1();
		
	}
	//��String��ת��int��
	public static void function() {
	  String s="110";
	  int i = Integer.parseInt(s);
	  System.out.println(i);
	}
	
	//��int��ת��String
	public static void function_1() {
		int i =4;
		String s=Integer.toString(i,2);
		System.out.println(s);
	}
	
}

