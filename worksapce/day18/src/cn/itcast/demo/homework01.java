package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;

//定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1
public class homework01 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("b");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("c");
		list.add("d");
		list.add("d");
		
		
		
		
		
		String s=function(list,"a");
		System.out.println(s);
	}
	
	//实现方法，计算个数
	public static String function(ArrayList<String> list,String s) {
		Iterator<String> it =list.iterator();
		int count=0;
		while(it.hasNext()) {
			if(it.next().equals(s)) {
				count++;
			}
		}
		
		return list+"中"+s+"有"+count+"个";
				
	}
}
