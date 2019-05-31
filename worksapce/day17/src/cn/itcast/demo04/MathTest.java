package cn.itcast.demo04;
//Math的方法
public class MathTest {
	public static void main(String[] args) {
		function_3();
	}
	//绝对值
	public static void function() {
		double i = -1.0;
		double j=Math.abs(i);
		System.out.println(j);
	}
	//返回大于或等于参数的最小整数
	public static void function_1() {
		double i=5.2;
		double j=Math.ceil(i);
		System.out.println(j);
	}
	public static void function_2() {
		double i=5.2;
		double j=Math.floor(i);
		System.out.println(j);
	}
	public static void function_3() {
		double i=5.2;
		double j=Math.round(i);
		System.out.println(j);
	}
	
}