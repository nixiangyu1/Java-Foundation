package cn.itcast.demo02;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo01 {
//HashMap���ϵĴ洢�����
	public static void main(String[] args) {
		HashMap <Person,String> map = new HashMap<Person,String>();
		map.put(new Person("nixiangyu",16), "�й�");
		map.put(new Person("liushuyuan",13), "����");
		map.put(new Person("liushuyuan",13), "����");
		System.out.println(map);
		for(Person key:map.keySet()) {
			String value=map.get(key);
			System.out.println(key+" "+value);
		}
		for(Map.Entry<Person, String> entry:map.entrySet()) {
			Person key =entry.getKey();
			String value=entry.getValue();
			System.out.println(key+" "+value);
		}
		
		
		HashMap<String,Person> map_1 = new HashMap<String,Person>();
		map_1.put("����", new Person("������",21));
		map_1.put("�żҸ�", new Person("������",21));
		for(String key:map_1.keySet()) {
			Person value=map_1.get(key);
			System.out.println(key+" "+value);
		}
		for(Map.Entry<String, Person> entry:map_1.entrySet()) {
			String key=entry.getKey();
			Person value=entry.getValue();
			System.out.println(key+ " "+ value);
		}
	}

}
