package cn.itcast.demo01;

public class IntegerDemo01 {
	public static void main(String[] args) {
		function();
		function_1();
		
	}
	//将String型转成int型
	public static void function() {
	  String s="110";
	  int i = Integer.parseInt(s);
	  System.out.println(i);
	}
	
	//将int型转成String
	public static void function_1() {
		int i =4;
		String s=Integer.toString(i,2);
		System.out.println(s);
	}
	
}

