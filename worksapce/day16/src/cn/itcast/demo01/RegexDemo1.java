package cn.itcast.demo01;

public class RegexDemo1 {
	public static void main(String[] args) {
//		split_1(); 
//		split_2(); 
		replaceAll_1();
	}
	
	
	/*
	 * String类方法split对字符串进行切割
	 * 12-25-36-98 按照-对字符串进行切割
	 */
	public static void split_1() {
		String str="12-25-36-98 ";
		String[] strArr= str.split("-");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	
	/*
	 * String类方法split对字符串进行切割
	 * 12   25   36  98按照空格切割字符串
	 */
	public static void split_2() {
		String str="12   25   36  98 ";
		String[] strArr= str.split(" +");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	
	/*
	 * String类方法split对字符串进行切割
	 * 192.168.105.27按照空格切割字符串
	 * .在正则表达式里面代表任意字符
	 * 所以用转义\\
	 * 
	 */
	public static void split_3() {
		String str="92.168.105.27";
		String[] strArr= str.split("\\.");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	/*
	 * "Hello12345World6789012"将数字替换掉
	 * String类方法replaceAll(正则规则，替换后的新字符串)
	 */
	public static void replaceAll_1() {
		String str = "Hello12345World6789012";
		str=str.replaceAll("[\\d+]", "*");
		System.out.println(str);
	}
}
	