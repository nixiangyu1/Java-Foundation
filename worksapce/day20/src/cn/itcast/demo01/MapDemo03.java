package cn.itcast.demo01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//通过键值对方法遍历map
public class MapDemo03 {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1,"abc");
		map.put(2,"bcd");
		map.put(3, "cde");
		Set<Map.Entry<Integer,String>> set = map.entrySet();
		Iterator <Map.Entry<Integer,String>> it = set.iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, String> entry= it.next();
			Integer key = entry.getKey();
			String value= entry.getValue();
			System.out.println(key+" "+value);
		}
	}
}
