package cn.itcast.demo;

import java.util.ArrayList;

//对集合中的元素进行排序
public class homework02 {
	public static void main(String[] args) {
		ArrayList<String> list =new ArrayList<String>();
		list.add("d");
		list.add("f");
		list.add("a");
		list.add("b");
		list.add("a");
		list.add("b");
		sort(list);
		System.out.println(list);
		
	}
	//定义方法  冒泡排序 
	public static void sort(ArrayList<String> list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i;j<list.size()-1;j++) {
				char[] c1=list.get(i).toCharArray();
				char[] c2=list.get(j+1).toCharArray();
				if(c1[0]>c2[0]) {
					String temp=list.get(i).toString();
					list.set(i, list.get(j+1));
					list.set(j+1,temp);
				}
				
			}
		}
	}
}
