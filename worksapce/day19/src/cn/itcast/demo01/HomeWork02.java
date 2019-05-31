package cn.itcast.demo01;

import java.util.ArrayList;
import java.util.List;

//对添加到集合中的元素排序
public class HomeWork02 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("b");
		list.add("f");
		list.add("e");
		list.add("c");
		list.add("a");
		list.add("d");
		sort(list);
		System.out.println(list);	// a, b, c, d, e, f
	}
	public static void sort(List<String> list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i;j<list.size()-1;j++) {
				if(list.get(i).toCharArray()[0]>list.get(j+1).toCharArray()[0]) {
					String temp=list.get(i).toString();
					list.set(i, list.get(j+1).toString());
					list.set(j+1, temp);
					
					
				}
			}
		}
	}
}
