package cn.itcast.demo03;

import java.util.Arrays;

/*
 * 练习一：定义一个方法，接收一个数组，
 *     数组中存储10个学生考试分数，
 *     该方法要求返回考试分数最低的后三名考试分数。
 */
public class ArrayListTest {
	public static void main(String[] args) {
		double[] arr= {12,33,22,44,55};
		double[] result=function(arr);
		String s=Arrays.toString(result);
		System.out.println(s);
	}
	
	//定义方法
	public static double[] function(double[] arr) {
		double[] result=new double[3];
		Arrays.sort(arr);//对数组进行排序
		System.arraycopy(arr, 0, result, 0, 3);
		return result;
	}
}
