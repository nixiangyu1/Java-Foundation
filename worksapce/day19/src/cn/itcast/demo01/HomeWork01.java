package cn.itcast.demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class HomeWork01 {
	public static void main(String[] args) {
	//定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1*/
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		list.add("d");
		System.out.println(frequency(list, "a"));	// 3
		System.out.println(frequency(list, "b"));	// 2
		System.out.println(frequency(list, "c"));	// 1
		System.out.println(frequency(list, "d"));	// 5
		System.out.println(frequency(list, "xxx"));	// 0
	}
	
	public static int frequency(List<String> list,String s) {
		int  count =0 ;
		for(String thisStr:list) {
			if(thisStr.equals(s)) {
				count++;
			}
		}
		
		
		
		return count;
	}
}
