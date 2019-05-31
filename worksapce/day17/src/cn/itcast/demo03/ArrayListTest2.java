package cn.itcast.demo03;

import java.util.Arrays;

public class ArrayListTest2 {
	public static void main(String[] args) {
		int[] arr= {23,66,22,33,11,66,23,43,234,23};
		function(arr);
		
	}
	public static void function(int[] arr) {
		Arrays.sort(arr);
		int[] result =new int[3];
		System.arraycopy(arr, 0,result, 0, 3);
		System.out.println(Arrays.toString(result));
	}
}
