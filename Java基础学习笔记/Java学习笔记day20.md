#### 20.1Map接口

我们通过查看Map接口描述，发现Map接口下的集合与Collection接口下的集合，它们存储数据的形式不同，如下图。

- Collection中的集合，元素是孤立存在的（理解为单身），向集合中存储元素采用一个个元素的方式存储。
- Map中的集合，元素是成对存在的(理解为夫妻)。每个元素由键与值两部分组成，通过键可以找对所对应的值。
- Collection中的集合称为单列集合，Map中的集合称为双列集合。
- 需要注意的是，Map中的集合不能包含重复的键，值可以重复；每个键只能对应一个值。

- Map中常用的集合为HashMap集合、LinkedHashMap集合。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps5.jpg)

##### 20.1.1Map接口中常用集合概述

通过查看Map接口描述，看到Map有多个子类，这里我们主要讲解常用的HashMap集合、LinkedHashMap集合。

- **HashMap<K,V>**：存储数据采用的哈希表结构，元素的存取顺序不能保证一致。由于要保证键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。
- **LinkedHashMap<K,V>**：HashMap下有个子类LinkedHashMap，存储数据采用的哈希表结构+链表结构。通过链表结构可以保证元素的存取顺序一致；通过哈希表结构可以保证的键的唯一、不重复，需要重写键的hashCode()方法、equals()方法。
- **注意**：Map接口中的集合都有两个泛型变量<K,V>,在使用时，要为两个泛型变量赋予数据类型。两个泛型变量<K,V>的数据类型可以相同，也可以不同。
- **Key 和Value不能用基本数据类型**

##### 20.1.2Map接口中的常用方法

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps6.jpg)

~~~java
package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Map;

/*
 *  Map接口中的常用方法
 *    使用Map接口的实现类 HashMap
 */
public class MapDemo {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 *  移除集合中的键值对,返回被移除之前的值
	 *  V remove(K)
	 */
	public static void function_2(){
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		System.out.println(map);
		
		String value = map.remove(33);
		System.out.println(value);
		System.out.println(map);
	}
	
	/*
	 * 通过键对象,获取值对象
	 * V get(K)
	 * 如果集合中没有这个键,返回null
	 */
	public static void function_1(){
		//创建集合对象,作为键的对象整数,值的对象存储字符串
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		System.out.println(map);
		
		String value = map.get(4);
		System.out.println(value);
	}
	
	/*
	 *  将键值对存储到集合中
	 *  V put(K,V) K 作为键的对象, V作为值的对象
	 *  存储的是重复的键,将原有的值,覆盖
	 *  返回值一般情况下返回null,
	 *  存储重复键的时候,返回被覆盖之前的值
	 */
	public static void function(){
		//创建集合对象,HashMap,存储对象,键是字符串,值是整数
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 1);
		
		map.put("b", 2);
		
		map.put("c", 3);
		
		System.out.println(map);
	}
}
~~~

##### 20.1.3Map集合遍历方式keySet()键找值

键找值方式：即通过元素中的键，获取键所对应的值+

操作步骤与图解：

 	1.获取Map集合中所有的键，由于键是唯一的，所以返回一个Set集合存储所有的键

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps7.jpg) 

2.遍历键的Set集合，得到每一个键

3.根据键，获取键所对应的值

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps8.jpg)

~~~java
package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 *  Map集合的遍历
 *    利用键获取值
 *    Map接口中定义方法keySet
 *    所有的键,存储到Set集合
 */
public class MapDemo1 {
	public static void main(String[] args) {
		/*
		 *  1. 调用map集合的方法keySet,所有的键存储到Set集合中
		 *  2. 遍历Set集合,获取出Set集合中的所有元素 (Map中的键)
		 *  3. 调用map集合方法get,通过键获取到值
		 */
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 11);
		map.put("b", 12);
		map.put("c", 13);
		map.put("d", 14);
		
		//1. 调用map集合的方法keySet,所有的键存储到Set集合中
		Set<String> set = map.keySet();
		//2. 遍历Set集合,获取出Set集合中的所有元素 (Map中的键)
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			//it.next返回是Set集合元素,也就是Map中的键
			//3. 调用map集合方法get,通过键获取到值
			String key = it.next();
			Integer value = map.get(key);
			System.out.println(key+"...."+value);
		}
		System.out.println("=======================");
		for(String key : map.keySet()){
			Integer value = map.get(key);
			System.out.println(key+"...."+value);
		}
	}
}
~~~

##### 20.1.4Entry键值对对象

在Map类设计时，提供了一个嵌套接口：Entry。Entry将键值对的对应关系封装成了对象。即键值对对象，这样我们在遍历Map集合时，就可以从每一个键值对（Entry）对象中获取对应的键与对应的值。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps9.jpg) 

Entry是Map接口中提供的一个静态内部嵌套接口。

 

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps10.jpg) 

getKey()方法：获取Entry对象中的键

getValue()方法：获取Entry对象中的值

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps11.jpg) 

entrySet()方法：用于返回Map集合中所有的键值对(Entry)对象，以Set集合形式返回。

##### 20.1.5Map集合遍历方式 entrySet()键值对方式

键值对方式：即通过集合中每个键值对(Entry)对象，获取键值对(Entry)对象中的键与值。

操作步骤与图解：

​	1.获取Map集合中，所有的键值对(Entry)对象，以Set集合形式返回。

​	![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps12.jpg)

​	2.遍历包含键值对(Entry)对象的Set集合，得到每一个键值对(Entry)对象

​	3.通过键值对(Entry)对象，获取Entry对象中的键与值。

​	![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps13.jpg)

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps14.jpg)

~~~java
package cn.itcast.demo1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 *  Map集合获取方式
 *  entrySet方法,键值对映射关系(结婚证)获取
 *  实现步骤:
 *    1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
 *        Set<Entry <K,V> >
 *    2. 迭代Set集合
 *    3. 获取出的Set集合的元素,是映射关系对象
 *    4. 通过映射关系对象方法 getKet, getValue获取键值对
 *    
 *    创建内部类对象 外部类.内部类 = new 
 */
public class MapDemo2 {
	public static void main(String[] args) {
		Map<Integer,String> map = new HashMap<Integer, String>();
		map.put(1, "abc");
		map.put(2, "bcd");
		map.put(3, "cde");
		//1. 调用map集合方法entrySet()将集合中的映射关系对象,存储到Set集合
		Set<Map.Entry <Integer,String> >  set = map.entrySet();
		//2. 迭代Set集合
		Iterator<Map.Entry <Integer,String> > it = set.iterator();
		while(it.hasNext()){
			//  3. 获取出的Set集合的元素,是映射关系对象
			// it.next 获取的是什么对象,也是Map.Entry对象
			Map.Entry<Integer, String> entry = it.next();
			//4. 通过映射关系对象方法 getKet, getValue获取键值对
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key+"...."+value);
		}
		
		System.out.println("=========================");
		for(Map.Entry<Integer, String> entry : map.entrySet()){
			System.out.println(entry.getKey()+"..."+entry.getValue());
		}
	}
}

~~~

##### 20.1.6HashMap集合的存储和遍历

~~~java
package cn.itcast.demo2;

import java.util.HashMap;
import java.util.Map;

/*
 *  使用HashMap集合,存储自定义的对象
 *  自定义对象,作为键,出现,作为值出现
 */
public class HashMapDemo {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * HashMap 存储自定义对象Person,作为键出现
	 * 键的对象,是Person类型,值是字符串
	 * 保证键的唯一性,存储到键的对象,重写hashCode equals
	 */
	public static void function_1(){
		HashMap<Person, String> map = new HashMap<Person, String>();
		map.put(new Person("a",20), "里约热内卢");
		map.put(new Person("b",18), "索马里");
		map.put(new Person("b",18), "索马里");
		map.put(new Person("c",19), "百慕大");
		for(Person key : map.keySet()){
			String value = map.get(key);
			System.out.println(key+"..."+value);
		}
		System.out.println("===================");
		for(Map.Entry<Person, String> entry : map.entrySet()){
			System.out.println(entry.getKey()+"..."+entry.getValue());
		}
	}
	
	/*
	 * HashMap 存储自定义的对象Person,作为值出现
	 * 键的对象,是字符串,可以保证唯一性
	 */
	public static void function(){
		HashMap<String, Person> map = new HashMap<String, Person>();
		map.put("beijing", new Person("a",20));
		map.put("tianjin", new Person("b",18));
		map.put("shanghai", new Person("c",19));
		for(String key : map.keySet()){
			Person value = map.get(key);
			System.out.println(key+"..."+value);
		}
		System.out.println("=================");
		for(Map.Entry<String, Person> entry : map.entrySet()){
			String key = entry.getKey();
			Person value = entry.getValue();
			System.out.println(key+"..."+value);
		}
	}
}

~~~

##### 20.1.7LinkedHashMap的特点

~~~java
package cn.itcast.demo03;

import java.util.LinkedHashMap;
//HashMap的key和value不能使用基本数据类型
/*
 * LinkedHashMap继承HashMap
 * 保证的迭代的顺序
 */
public class LinkedHashMapDemo01 {
	public static void main(String[] args) {
		LinkedHashMap<String, String> link=new LinkedHashMap<String,String>();
		link.put("倪翔宇", "21");
		link.put("刘淑媛","21");
		link.put("旭宝宝","13");
		System.out.println(link);
	}
}
~~~

##### 20.1.8Hashtable的特点

线程安全，运行速度慢，不能存Null值

~~~java
package cn.itcast.demo2;

import java.util.Hashtable;
import java.util.Map;

/*
 *  Map接口实现类 Hashtable
 *  底层数据结果哈希表,特点和HashMap是一样的
 *  Hashtable 线程安全集合,运行速度慢
 *  HashMap 线程不安全的集合,运行速度快
 *  
 *  Hashtable命运和Vector是一样的,从JDK1.2开始,被更先进的HashMap取代
 *  
 *  HashMap 允许存储null值,null键
 *  Hashtable 不允许存储null值,null键
 *  
 *  Hashtable他的孩子,子类 Properties 依然活跃在开发舞台
 */
public class HashtableDemo {
	public static void main(String[] args) {
		Map<String,String> map = new Hashtable<String,String>();
		map.put(null, null);
		System.out.println(map);
	}
}
~~~

#### 20.2静态导入

~~~java
package cn.itcast.demo3;
/*
 * JDK1.5新特性,静态导入
 * 减少开发的代码量
 * 标准的写法,导入包的时候才能使用
 * 
 * import static java.lang.System.out;最末尾,必须是一个静态成员
 */
import static java.lang.System.out;
import static java.util.Arrays.sort;


public class StaticImportDemo {
	public static void main(String[] args) {
		out.println("hello");
		
		int[] arr = {1,4,2};
		sort(arr);
	}
}
~~~

#### 20.3方法的可变参数

~~~java
package cn.itcast.demo3;
/*
 *  JDK1.5新的特性,方法的可变参数
 *  前提: 方法参数数据类型确定,参数的个数任意
 *  可变参数语法: 数据类型...变量名
 *  可变参数,本质就是一个数组
 */
public class VarArgumentsDemo {
	public static void main(String[] args) {
		//调用一个带有可变参数的方法,传递参数,可以任意
	//	getSum();
		int sum = getSum(5,34,3,56,7,8,0);
		System.out.println(sum);
		
		function(1,2,3);
	}
	/*
	 * 可变参数的注意事项
	 * 1. 一个方法中,可变参数只能有一个
	 * 2. 可变参数,必须写在参数列表的最后一位
	 */
	 public static void function(Object...o){
		 
	 }
	
	/*
	 * 定义方法,计算10个整数和
	 * 方法的可变参数实现
	 */
	public static int getSum(int...a){
		int sum = 0 ;
		for(int i : a){
			sum = sum + i;
		}
		return sum;
	}
	
	
}

~~~

#### 20.4Collections工具类

~~~java
package cn.itcast.demo4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *  集合操作的工具类
 *    Collections
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 * Collections.shuffle方法
	 * 对List集合中的元素,进行随机排列
	 */
	public static void function_2(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(9);
		list.add(11);
		list.add(8);
		list.add(10);
		list.add(15);
		list.add(20);	
		System.out.println(list);
		
		//调用工具类方法shuffle对集合随机排列
		Collections.shuffle(list);
		System.out.println(list);
	}
	
	/*
	 * Collections.binarySearch静态方法
	 * 对List集合进行二分搜索,方法参数,传递List集合,传递被查找的元素
	 */
	public static void function_1(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(5);
		list.add(8);
		list.add(10);
		list.add(15);
		list.add(20);
		//调用工具类静态方法binarySearch
		int index = Collections.binarySearch(list, 16);
		System.out.println(index);
	}
	
	/*
	 *  Collections.sort静态方法
	 *  对于List集合,进行升序排列
	 */
	public static void function(){
		//创建List集合
		List<String> list = new ArrayList<String>();
		list.add("ewrew");
		list.add("qwesd");
		list.add("Qwesd");
		list.add("bv");
		list.add("wer");
		System.out.println(list);
		//调用集合工具类的方法sort
		Collections.sort(list);
		System.out.println(list);
	}
}
~~~

#### 20.5集合嵌套

集合嵌套并不是一个新的知识点，仅仅是集合内容又是集合，如Collection集合嵌套、Collection集合与Map集合相互嵌套、Map集合嵌套。

- ArrayList嵌套 ArrayList

  ~~~java
  ArrayList< ArrayList<String> >
  Collection< ArrayList<Integer> >
  ~~~

  

- Map嵌套 ArrayList

  ~~~java
  HashMap<String, ArrayList<Person>>
  ArrayList< HashMap<String, String>>
  ~~~

  

- Map集合嵌套

  ~~~java
  HashMap<String, HashMap<String,String>>
  HashMap<String, HashMap<Person,String>>
  ~~~

  

#### 20.6模拟斗地主洗牌发牌

~~~java
package cn.itcast.demo04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/*
 * 实现模拟斗地主的功能
 * 1.组合牌
 * 2.洗牌
 * 3.发牌
 * 4.看牌
 * 
 */
public class DouDiZhu {

	public static void main(String[] args) {
		// 1.组合牌
		// 创建Map集合，键是编号，值是牌
		HashMap<Integer, String> pooker = new HashMap<Integer, String>();
		// 创建List集合，存储编号
		ArrayList<Integer> pookerNumber = new ArrayList<Integer>();
		// 定义出13个点数的数组
		String[] numbers = { "2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3" };
		String[] colours = { "♠", "♣", "♥", "♦" };
		int index = 2;
		pookerNumber.add(0);
		pooker.put(0, "大王 ");
		pookerNumber.add(1);
		pooker.put(1, "小王");
		for (String number : numbers) {
			for (String colour : colours) {
				pookerNumber.add(index);
				pooker.put(index, colour + number);
				index++;
			}
		}
		// System.out.println(pooker);

		// 洗牌，将牌的编号打乱给
		Collections.shuffle(pookerNumber);
		// System.out.println(pookerNumber);

		// 发牌,将牌的编号一一发给玩家集合,底牌集合
		ArrayList<Integer> player1 = new ArrayList<Integer>();
		ArrayList<Integer> player2 = new ArrayList<Integer>();
		ArrayList<Integer> player3 = new ArrayList<Integer>();
		ArrayList<Integer> bottom = new ArrayList<Integer>();
		for (int i = 0; i < pookerNumber.size(); i++) {
			if (i < 3) {
				bottom.add(pookerNumber.get(i));
			} else if (i % 3 == 0) {
				player1.add(pookerNumber.get(i));
			} else if (i % 3 == 1) {
				player2.add(pookerNumber.get(i));

			} else {
				player3.add(pookerNumber.get(i));
			}

		}
		Collections.sort(player1);
		Collections.sort(player2);
		Collections.sort(player3);
		Collections.sort(player1);
		look("player1",player1,pooker);
		look("player2",player2,pooker);
		look("player3",player3,pooker);
		look("底牌",bottom,pooker);

	}

	// 看牌，将玩家集合中的元素当作key，去pooker集合中找键
	public static void look(String name,ArrayList<Integer> player, HashMap<Integer, String> pooker) {
			System.out.print(name+" ");
			for(Integer key:player) {
				String value = pooker.get(key);
				System.out.print(value+" ");
				
			}
			System.out.println();
	}
}
~~~

