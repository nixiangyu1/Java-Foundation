package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;

//���巽��ͳ�Ƽ�����ָ��Ԫ�س��ֵĴ�������"a" 3,"b" 2,"c" 1
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
	
	//ʵ�ַ������������
	public static String function(ArrayList<String> list,String s) {
		Iterator<String> it =list.iterator();
		int count=0;
		while(it.hasNext()) {
			if(it.next().equals(s)) {
				count++;
			}
		}
		
		return list+"��"+s+"��"+count+"��";
				
	}
}
