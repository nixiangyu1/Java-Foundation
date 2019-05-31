package cn.itcast.demo01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("3");
		set.add("5");
		set.add("2");
		set.add("4");
		for(String s:set) {
			System.out.println(s);
		}
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
