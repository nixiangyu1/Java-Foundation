package cn.itcast.demo03;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
//HashMap��key��value����ʹ�û�����������
/*
 * LinkedHashMap�̳�HashMap
 * ��֤�ĵ�����˳��
 */
public class LinkedHashMapDemo01 {
	public static void main(String[] args) {
		LinkedHashMap<String, String> link=new LinkedHashMap<String,String>();
		link.put("������", "21");
		link.put("������","21");
		link.put("�񱦱�","13");
		System.out.println(link);

	}
}
