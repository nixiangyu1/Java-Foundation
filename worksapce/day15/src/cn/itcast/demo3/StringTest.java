package cn.itcast.demo3;

public class StringTest {
	public static void main(String[] args) {
		String s1 = new String(); //创建String对象，字符串中没有内容
		
		byte[] bys = new byte[]{97,98,99,100};
		String s2 = new String(bys); // 创建String对象，把数组元素作为字符串的内容
		String s3 = new String(bys, 1, 3); //创建String对象，把一部分数组元素作为字符串的内容，参数offset为数组元素的起始索引位置，参数length为要几个元素
			
		char[] chs = new char[]{'a','b','c','d','e','f'};
		String s4 = new String(chs); //创建String对象，把数组元素作为字符串的内容
		String s5 = new String(chs, 0, 3);//创建String对象，把一部分数组元素作为字符串的内容，参数offset为数组元素的起始索引位置，参数count为要几个元素

		String s6 = new String("abc"); //创建String对象，字符串内容为abc
		System.out.println(s4);
	}
}
