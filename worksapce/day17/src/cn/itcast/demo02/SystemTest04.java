package cn.itcast.demo02;

import java.util.Arrays;

public class SystemTest04 {
	public static void main(String[] args) {
		function_1();
	}
	
	//��֤forѭ����ӡ����1-9999����Ҫʹ�õ�ʱ�䣨���룩
	public static void function() {
		long start =System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start));
	}
	
	/*
	 * ��src������ǰ3��Ԫ�أ����Ƶ�dest�����ǰ3��λ����
		����Ԫ��ǰ��src����Ԫ��[1,2,3,4,5]��dest����Ԫ��[6,7,8,9,10]
		����Ԫ�غ�src����Ԫ��[1,2,3,4,5]��dest����Ԫ��[1,2,3,9,10]
	 */
	public static void function_1() {
		int[] src= {1,2,3,4,5};
		int[] dest= {6,7,8,9,10};
		System.arraycopy(src, 0, dest, 0, 3);
		System.out.println(Arrays.toString(dest));
		
	}
}
