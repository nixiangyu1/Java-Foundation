package cn.itcast.demo02;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo01 {
//HashMap集合的存储与遍历
	public static void main(String[] args) {
		HashMap <Person,String> map = new HashMap<Person,String>();
		map.put(new Person("nixiangyu",16), "中国");
		map.put(new Person("liushuyuan",13), "贵阳");
		map.put(new Person("liushuyuan",13), "贵阳");
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
		map_1.put("贵阳", new Person("刘淑媛",21));
		map_1.put("张家港", new Person("倪翔宇",21));
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
