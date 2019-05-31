package cn.itcast.demo03;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//HashMap的key和value不能使用基本数据类型
/*
 * LinkedHashMap继承HashMap
 * 保证的迭代的顺序
 */
public class LinkedHashMapDemo01 {
	public static void main(String[] args) {
		LinkedHashMap<String, String> link=new LinkedHashMap<String,String>();
		link.put("倪翔宇", "21");
		link.put("刘淑媛","21");
		link.put("旭宝宝","13");
		System.out.println(link);

	}
}
