package cn.itcast.demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//�������Map����   ����ֵ����

public class MapDemo02 {

	public static void main(String[] args) {
		Map <String,Integer> map = new HashMap<String,Integer>();
			map.put("������", 99);
			map.put("������", 13);
			Set<String> set = map.keySet();
			Iterator<String> it = set.iterator();
			while(it.hasNext()) {
				String key = it.next();
				Integer value=map.get(key);
				System.out.println(key+" "+value);
			}
		}

}


