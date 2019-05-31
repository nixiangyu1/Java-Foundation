package cn.itcast.demo02;

import java.util.Arrays;

public class SystemTest04 {
	public static void main(String[] args) {
		function_1();
	}
	
	//验证for循环打印数字1-9999所需要使用的时间（毫秒）
	public static void function() {
		long start =System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start));
	}
	
	/*
	 * 将src数组中前3个元素，复制到dest数组的前3个位置上
		复制元素前：src数组元素[1,2,3,4,5]，dest数组元素[6,7,8,9,10]
		复制元素后：src数组元素[1,2,3,4,5]，dest数组元素[1,2,3,9,10]
	 */
	public static void function_1() {
		int[] src= {1,2,3,4,5};
		int[] dest= {6,7,8,9,10};
		System.arraycopy(src, 0, dest, 0, 3);
		System.out.println(Arrays.toString(dest));
		
	}
}
