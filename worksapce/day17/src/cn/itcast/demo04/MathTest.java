package cn.itcast.demo04;
//Math�ķ���
public class MathTest {
	public static void main(String[] args) {
		function_3();
	}
	//����ֵ
	public static void function() {
		double i = -1.0;
		double j=Math.abs(i);
		System.out.println(j);
	}
	//���ش��ڻ���ڲ�������С����
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