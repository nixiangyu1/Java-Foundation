#### 19.1List接口

三个特点：有序，索引，可以重复元素

List接口的常用子类有：

ArrayList集合

LinkedList集合

##### 19.1.1接口中常用的方法

![1558694142117](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558694142117.png)

~~~java
package cn.itcast.demo;

import java.util.ArrayList;
import java.util.List;

/*
 *  List接口派系, 继承Collection接口
 *    下面有很多实现类
 *  List接口特点: 有序,索引,可以重复元素
 *    实现类, ArrayList, LinkedList
 *    
 *  List接口中的抽象方法,有一部分方法和他的父接口Collection是一样
 *  List接口的自己特有的方法, 带有索引的功能
 */
public class ListDemo {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 *  E set(int index, E)
	 *  修改指定索引上的元素
	 *  返回被修改之前的元素
	 */
	public static void function_2(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		Integer i = list.set(0, 5);
		System.out.println(i);
		System.out.println(list);
	}
	
	/*
	 *  E remove(int index)
	 *  移除指定索引上的元素
	 *  返回被删除之前的元素
	 */
	public static void function_1(){
		List<Double> list = new ArrayList<Double>();
		list.add(1.1);
		list.add(1.2);
		list.add(1.3);
		list.add(1.4);
		
		Double d = list.remove(0);
		System.out.println(d);
		System.out.println(list);
	}
	
	/*
	 *  add(int index, E)
	 *  将元素插入到列表的指定索引上
	 *  带有索引的操作,防止越界问题
	 *  java.lang.IndexOutOfBoundsException
	 *     ArrayIndexOutOfBoundsException
	 *     StringIndexOutOfBoundsException
	 */
	public static void function(){
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		System.out.println(list);
		
		list.add(1, "itcast");
		System.out.println(list);
	}
}
~~~

##### 19.1.2迭代器的并发修改异常

~~~java
package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 *  迭代器的并发修改异常 java.util.ConcurrentModificationException
 *  就是在遍历的过程中,使用了集合方法修改了集合的长度,不允许的
 */
public class ListDemo1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("abc1");
		list.add("abc2");
		list.add("abc3");
		list.add("abc4");
		
		//对集合使用迭代器进行获取,获取时候判断集合中是否存在 "abc3"对象
		//如果有,添加一个元素 "ABC3"
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String s = it.next();
			//对获取出的元素s,进行判断,是不是有"abc3"
			if(s.equals("abc3")){
				list.add("ABC3");
			}
			System.out.println(s);
		}
	}
}

~~~

##### 19.1.3List集合存储数据的结构

常用结构：堆栈，队列，数组，链表

堆栈：先进后出

队列：先进先出

数组：查找快，增删慢

链表：查找慢，增删快

##### 19.1.4ArrayList集合的自身特点

数组结构

不安全的，运行速度比较快

##### 19.1.5LinkedList集合的自身特点

链表结构

线程不同步，不安全，运行速度比较快

 ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml41028\wps2.jpg)

~~~java
package cn.itcast.demo;

import java.util.LinkedList;

/*
 *  LinkedList 链表集合的特有功能
 *    自身特点: 链表底层实现,查询慢,增删快
 *  
 *  子类的特有功能,不能多态调用
 */
public class LinkedListDemo {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 *  E removeFirst() 移除并返回链表的开头
	 *  E removeLast() 移除并返回链表的结尾
	 */
	public static void function_3(){
		LinkedList<String> link = new LinkedList<String>();
		link.add("1");
		link.add("2");
		link.add("3");
		link.add("4");
		
		String first = link.removeFirst();
		String last = link.removeLast();
		System.out.println(first);
		System.out.println(last);
	
		System.out.println(link);
	}
	
	/*
	 * E getFirst() 获取链表的开头
	 * E getLast() 获取链表的结尾
	 */
	public static void function_2(){
		LinkedList<String> link = new LinkedList<String>();
		link.add("1");
		link.add("2");
		link.add("3");
		link.add("4");
	
		if(!link.isEmpty()){
			String first = link.getFirst();
			String last = link.getLast();
			System.out.println(first);
			System.out.println(last);
		}
	}
	
	public static void function_1(){
		LinkedList<String> link = new LinkedList<String>();
		link.addLast("a");
		link.addLast("b");
		link.addLast("c");
		link.addLast("d");
		
		link.addFirst("1");
		link.addFirst("2");
		link.addFirst("3");
		System.out.println(link);
	}
	
	/*
	 *  addFirst(E) 添加到链表的开头
	 *  addLast(E) 添加到链表的结尾
	 */
	public static void function(){
		LinkedList<String> link = new LinkedList<String>();
		
		link.addLast("heima");
		
		link.add("abc");
		link.add("bcd");
		
		link.addFirst("itcast");
		System.out.println(link);
		
		
	}
}

~~~

##### 19.1.6Vector集合

存储结构是数组

是同步的，安全的，被ArrayList取代了

#### 19.2Set接口

特点：无序，不重复，没有索引

取元素只能采用：迭代器和增强for

##### 19.2.1HashSet

~~~java
package cn.itcast.demo1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
 *  Set接口,特点不重复元素,没索引
 *  
 *  Set接口的实现类,HashSet (哈希表)
 *  特点: 无序集合,存储和取出的顺序不同,没有索引,不存储重复元素
 *  代码的编写上,和ArrayList完全一致
 *
 *   实现过程， 调用hashCode方法比较返回值是否相同，相同再比较equals
 *   的只是否相同，相同就不存入
 */
public class HashSetDemo {
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("cn");
		set.add("heima");
		set.add("java");
		set.add("java");
		set.add("itcast");
		
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println("==============");
		
		for(String s : set){
			System.out.println(s);
		}
	}
}


~~~

##### 19.2.2HashSet的数据结构

什么是哈希表呢？

哈希表底层使用的也是数组机制，数组中也存放对象，而这些对象往数组中存放时的位置比较特殊，当需要把这些对象给数组中存放时，那么会根据这些对象的特有数据结合相应的算法，计算出这个对象在数组中的位置，然后把这个对象存放在数组中。而这样的数组就称为哈希数组，即就是哈希表。

当向哈希表中存放元素时，需要根据元素的特有数据结合相应的算法，这个算法其实就是Object类中的hashCode方法。由于任何对象都是Object类的子类，所以任何对象有拥有这个方法。即就是在给哈希表中存放对象时，会调用对象的hashCode方法，算出对象在表中的存放位置，这里需要注意，如果两个对象hashCode方法算出结果一样，这样现象称为哈希冲突，这时会调用对象的equals方法，比较这两个对象是不是同一个对象，如果equals方法返回的是true，那么就不会把第二个对象存放在哈希表中，如果返回的是false，就会把这个值存放在哈希表中。

总结：保证HashSet集合元素的唯一，其实就是根据对象的hashCode和equals方法来决定的。如果我们往集合中存放自定义的对象，那么保证其唯一，就必须复写hashCode和equals方法建立属于当前对象的比较方式。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps1.jpg)

##### 19.2.3 **HashSet存储JavaAPI中的类型元素**

给HashSet中存储JavaAPI中提供的类型元素时，不需要重写元素的hashCode和equals方法，因为这两个方法，在JavaAPI的每个类中已经重写完毕，如String类、Integer类等。

~~~java
//创建HashSet集合，存储String对象。
public class HashSetDemo {
	public static void main(String[] args) {
		//创建HashSet对象
		HashSet<String> hs = new HashSet<String>();
		//给集合中添加自定义对象
		hs.add("zhangsan");
		hs.add("lisi");
		hs.add("wangwu");
		hs.add("zhangsan");
		//取出集合中的每个元素
		Iterator<String> it = hs.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
	}
}
/*输出结果如下，说明集合中不能存储重复元素：
*wangwu
*lisi
*zhangsan
*/
~~~



##### 19.2.4HashSet的存储过程

![1558759571788](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558759571788.png)

##### 19.2.5HashSet的存储自定义对象

给HashSet中存放自定义类型元素时，需要重写对象中的hashCode和equals方法，建立自己的比较方式，才能保证HashSet集合中的对象唯一

##### 19.2.6自定义对象重写hashCode和equals

~~~java
public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(!(obj instanceof Student)){
			System.out.println("类型错误");
			return false;
		}
		Student other = (Student) obj;
		return this.age ==  other.age && this.name.equals(other.name);
	}
~~~



##### 19.2.7LinkedHashSet集合

继承自HashSet,有序的

~~~java
package cn.itcast.demo1;

import java.util.LinkedHashSet;

/*
 *   LinkedHashSet 基于链表的哈希表实现
 *   继承自HashSet
 *   
 *   LinkedHashSet 自身特性,具有顺序,存储和取出的顺序相同的
 *   线程不安全的集合,运行速度块
 */
public class LinkedHashSetDemo {
	
	public static void main(String[] args) {
		LinkedHashSet<Integer> link = new LinkedHashSet<Integer>();
		link.add(123);
		link.add(44);
		link.add(33);
		link.add(33);
		link.add(66);
		link.add(11);
		System.out.println(link);
	}
}

~~~

