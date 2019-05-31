#### 18.1ArrayList集合

##### 18.1.1ArrayList存储基本类型和引用数据类型

~~~java
package cn.itcast.demo;

import java.util.ArrayList;
/*
 *  集合体系,
 *    目标  集合本身是一个存储的容器:
 *       必须使用集合存储对象
 *       遍历集合,取出对象
 *       集合自己的特性
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		/*
		 *  集合ArrayList,存储int类型数
		 *  集合本身不接受基本类,自动装箱存储
		 */
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(11);
		array.add(12);
		array.add(13);
		array.add(14);
		array.add(15);
		for(int i = 0 ; i < array.size() ;i++){
			System.out.println(array.get(i));
		}
		/*
		 *  集合存储自定义的Person类的对象
		 */
		ArrayList<Person> arrayPer = new ArrayList<Person>();
		arrayPer.add(new Person("a",20));
		arrayPer.add(new Person("b",18));
		arrayPer.add(new Person("c",22));
		for(int i = 0 ; i < arrayPer.size();i++){
			//get(0),取出的对象Person对象
			//打印的是一个对象,必须调用的toString()
			System.out.println(arrayPer.get(i));
		}
	}
}

~~~



##### 18.1.2集合的继承实现关系

 ![1558664017718](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558664017718.png)

List列表有序，Set集无序

List可以重复，Set不能重复

##### 18.1.3Collection接口

![1558664447784](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558664447784.png)

~~~java
package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Collection;

/*
 *  Collection接口中的方法
 *  是集合中所有实现类必须拥有的方法
 *  使用Collection接口的实现类,程序的演示
 *  ArrayList implements List
 *  List extends Collection
 *  方法的执行,都是实现的重写
 */
public class CollectionDemo {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 * Collection接口方法
	 * boolean remove(Object o)移除集合中指定的元素
	 */
	private static void function_3(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("money");
		coll.add("itcast");
		coll.add("itheima");
		coll.add("money");
		coll.add("123");	
		System.out.println(coll);
		
		boolean b = coll.remove("money");
		System.out.println(b);
		System.out.println(coll);
	}
	
	/*  Collection接口方法
	 *  Object[] toArray() 集合中的元素,转成一个数组中的元素, 集合转成数组
	 *  返回是一个存储对象的数组, 数组存储的数据类型是Object
	 */
	private static void function_2() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("itcast");
		coll.add("itheima");
		coll.add("money");
		coll.add("123");
		
		Object[] objs = coll.toArray();
		for(int i = 0 ; i < objs.length ; i++){
			System.out.println(objs[i]);
		}
	}
	/*
	 * 学习Java中三种长度表现形式
	 *   数组.length 属性  返回值 int
	 *   字符串.length() 方法,返回值int
	 *   集合.size()方法, 返回值int
	 */
	
	/*
	 * Collection接口方法
	 * boolean contains(Object o) 判断对象是否存在于集合中,对象存在返回true
	 * 方法参数是Object类型
	 */
	private static void function_1() {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("itcast");
		coll.add("itheima");
		coll.add("money");
		coll.add("123");
		
		boolean b = coll.contains("itcast");
		System.out.println(b);
	}


	/*
	 * Collection接口的方法
	 * void clear() 清空集合中的所有元素
	 * 集合容器本身依然存在
	 */
	public static void function(){
		//接口多态的方式调用
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("bcd");
		System.out.println(coll);
		
		coll.clear();
		
		System.out.println(coll);
		
	}
}
~~~

#### 18.2Iterator迭代器

帮助做集合遍历

##### 18.2.1迭代器的代码实现

~~~java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 *  集合中的迭代器:
 *    获取集合中元素方式
 *  接口 Iterator : 两个抽象方法
 *     boolean hasNext() 判断集合中还有没有可以被取出的元素,如果有返回true
 *     next() 取出集合中的下一个元素
 *     
 *  Iterator接口,找实现类.
 *    Collection接口定义方法 
 *       Iterator  iterator()
 *    ArrayList 重写方法 iterator(),返回了Iterator接口的实现类的对象
 *    使用ArrayList集合的对象
 *     Iterator it = array.iterator(),运行结果就是Iterator接口的实现类的对象
 *     it是接口的实现类对象,调用方法 hasNext 和 next 集合元素迭代
 */
public class IteratorDemo {
	public static void main(String[] args) {
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc1");
		coll.add("abc2");
		coll.add("abc3");
		coll.add("abc4");
		//迭代器,对集合ArrayList中的元素进行取出
		
		//调用集合的方法iterator()获取出,Iterator接口的实现类的对象
		Iterator<String> it = coll.iterator();
		//接口实现类对象,调用方法hasNext()判断集合中是否有元素
		//boolean b = it.hasNext();
		//System.out.println(b);
		//接口的实现类对象,调用方法next()取出集合中的元素
		//String s = it.next();
		//System.out.println(s);
		
		//迭代是反复内容,使用循环实现,循环的条件,集合中没元素, hasNext()返回了false
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s);
		}
		
		/*for (Iterator<String> it2 = coll.iterator(); it2.hasNext();  ) {
			System.out.println(it2.next());
		}*/
		
	}
}

~~~

##### 18.2.2迭代器的执行过程

![1558675742060](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558675742060.png)

##### 18.2.3集合迭代中的转型

~~~java
//存储时提升了Object。取出时要使用元素的特有内容，必须向下转型。
 Collection coll = new ArrayList();
 coll.add("abc");
 coll.add("aabbcc");
 coll.add("shitcast");
 Iterator it = coll.iterator();
 while (it.hasNext()) {
  //由于元素被存放进集合后全部被提升为Object类型
 //当需要使用子类对象特有方法时，需要向下转型
  String str = (String) it.next();
  System.out.println(str.length());
 }
 //注意：如果集合中存放的是多个对象，这时进行向下转型会发生类型转换异常。
~~~

~~~java
//Iterator接口也可以使用<>来控制迭代元素的类型的。代码演示如下：
 Collection<String> coll = new ArrayList<String>();
 coll.add("abc");
 coll.add("aabbcc");
 coll.add("shitcast");
 Iterator<String> it = coll.iterator();
 while (it.hasNext()) {
  String str =  it.next(); 
 //当使用Iterator<String>控制元素类型后，就不需要强转了。获取到的元素直接就是String类型
  System.out.println(str.length());
 }
~~~

#### 18.3增强for循环遍历数组

增强for没有索引，不改变容器内容的，用增强for

~~~java
package cn.itcast.demo2;
import java.util.ArrayList;

/*
 *  JDK1.5新特性,增强for循环
 *  JDK1.5版本后,出现新的接口 java.lang.Iterable
 *    Collection开是继承Iterable
 *    Iterable作用,实现增强for循环
 *    
 *    格式:
 *      for( 数据类型  变量名 : 数组或者集合 ){
 *         sop(变量);
 *      }
 */
import cn.itcast.demo.Person;
public class ForEachDemo {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 *  增强for循环遍历集合
	 *  存储自定义Person类型
	 */
	public static void function_2(){
		ArrayList<Person> array = new ArrayList<Person>();
		array.add(new Person("a",20));
		array.add(new Person("b",10));
		for(Person p : array){
			System.out.println(p);
		}
	}
	
	
	public static void function_1(){
		//for对于对象数组遍历的时候,能否调用对象的方法呢
		String[] str = {"abc","itcast","cn"};
		for(String s : str){
			System.out.println(s.length());
		}
	}
	
	/*
	 *  实现for循环,遍历数组
	 *  好处: 代码少了,方便对容器遍历
	 *  弊端: 没有索引,不能操作容器里面的元素
	 */
	public static void function(){
		int[] arr = {3,1,9,0};
		for(int i : arr){
			System.out.println(i+1);
		}
		System.out.println(arr[0]);
	}
}

~~~

#### 18.4泛型

~~~java
package cn.itcast.demo3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/*
 * JDK1.5 出现新的安全机制,保证程序的安全性
 *   泛型: 指明了集合中存储数据的类型  <数据类型>
 */

public class GenericDemo {
	public static void main(String[] args) {
		function();
	}
	
	public static void function(){
		Collection<String> coll = new ArrayList<String>();
		coll.add("abc");
		coll.add("rtyg");
		coll.add("43rt5yhju");
//		coll.add(1);
		
		Iterator<String> it = coll.iterator();
		while(it.hasNext()){
			String s = it.next();
			System.out.println(s.length());
		}
	}
}

~~~

##### 18.4.1泛型类

~~~java
package cn.itcast.demo3;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *  带有泛型的类
 *    ArrayList
 *    E: Element 元素, 实际思想就是一个变量而已 
 *    ArrayList<Integer> , E 接受到类型,就是Integer类型
 *    public class ArrayList<E>{
 *    
 *       public boolean add(Integer e){
 *          elementData[size++] = e;
 *       }
 *       
 *       public boolean add(E e){}
 *    }
 *    
 *    Iterator<E> 
 *    E next()
 *    
 *    Iterator<Integer> 
 *    Integer next()
 *   
 */
public class GenericDemo1 {
	public static void main(String[] args) {
		ArrayList<Integer>  array = new ArrayList<Integer> ();
		array.add(123);
		array.add(456);
		// ArrayList集合,自己有个方法
		// <T> T[] toArray(T[] a) 
		Integer[] i = new Integer[array.size()];
		Integer [] j = array.toArray(i);
		for(Integer k : j){
			System.out.println(k);
		}

	}
}
~~~

##### 18.4.2泛型的方法

~~~java
package cn.itcast.demo3;

import java.util.ArrayList;
import java.util.Iterator;

/*
 *  带有泛型的类
 *    ArrayList
 *    E: Element 元素, 实际思想就是一个变量而已 
 *    ArrayList<Integer> , E 接受到类型,就是Integer类型
 *    public class ArrayList<E>{
 *    
 *       public boolean add(Integer e){
 *          elementData[size++] = e;
 *       }
 *       
 *       public boolean add(E e){}
 *    }
 *    
 *    Iterator<E> 
 *    E next()
 *    
 *    Iterator<Integer> 
 *    Integer next()
 *   
 */
public class GenericDemo1 {
	public static void main(String[] args) {
		ArrayList<Integer>  array = new ArrayList<Integer> ();
		array.add(123);
		array.add(456);
		// ArrayList集合,自己有个方法
		// <T> T[] toArray(T[] a) 
		Integer[] i = new Integer[array.size()];
		Integer [] j = array.toArray(i);
		for(Integer k : j){
			System.out.println(k);
		}

	}
}

~~~

##### 18.4.3泛型接口

~~~java
package cn.itcast.demo3;
/*
 *  带有泛型的接口
 *  
 *  public interface List <E>{
 *    abstract boolean add(E e);
 *  }
 *  实现类,先实现接口,不理会泛型
 *  public class ArrayList<E> implements List<E>{
 *  }
 *  调用者 : new ArrayList<String>() 后期创建集合对象的时候,指定数据类型
 *  
 *  实现类,实现接口的同时,也指定了数据类型
 *  public class XXX implements List<String>{
 *  }
 *  new XXX()
 */
public class GenericDemo2 {

}

~~~

##### 18.4.4泛型的好处

- 避免了类型强转的麻烦
- 将错误从运行时期提前到了编译时期

带来了增强for的使用 

##### 18.4.5泛型的通配符

~~~java
package cn.itcast.demo4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/*
 *  泛型的通配符
 */
public class GenericDemo {
	public static void main(String[] args) {
		ArrayList<String> array = new ArrayList<String>();
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		array.add("123");
		array.add("456");
		
		set.add(789);
		set.add(890);
		
		iterator(array);
		iterator(set);
	}
	/*
	 *  定义方法,可以同时迭代2个集合
	 *  参数: 怎么实现 , 不能写ArrayList,也不能写HashSet
	 *  参数: 或者共同实现的接口
	 *  泛型的通配,匹配所有的数据类型  ?
	 */
	public static void iterator(Collection<?> coll){
		Iterator<?> it = coll.iterator();
		while(it.hasNext()){
			//it.next()获取的对象,什么类型
			System.out.println(it.next());
		}
	}
}

~~~

18.4.6泛类的限定

~~~java
package cn.itcast.hotel;
/*
 *  将的酒店员工,厨师,服务员,经理,分别存储到3个集合中
 *  定义方法,可以同时遍历3集合,遍历三个集合的同时,可以调用工作方法
 */
import java.util.ArrayList;
import java.util.Iterator;
public class GenericTest {
	public static void main(String[] args) {
		//创建3个集合对象
		ArrayList<ChuShi> cs = new ArrayList<ChuShi>();
		ArrayList<FuWuYuan> fwy = new ArrayList<FuWuYuan>();
		ArrayList<JingLi> jl = new ArrayList<JingLi>();
		
		//每个集合存储自己的元素
		cs.add(new ChuShi("张三", "后厨001"));
		cs.add(new ChuShi("李四", "后厨002"));
		
		fwy.add(new FuWuYuan("翠花", "服务部001"));
		fwy.add(new FuWuYuan("酸菜", "服务部002"));
		
		jl.add(new JingLi("小名", "董事会001", 123456789.32));
		jl.add(new JingLi("小强", "董事会002", 123456789.33));
		
//		ArrayList<String> arrayString = new ArrayList<String>();
		iterator(jl);
		iterator(fwy);
		iterator(cs);
	
	}
	/*
	 * 定义方法,可以同时遍历3集合,遍历三个集合的同时,可以调用工作方法 work
	 * ? 通配符,迭代器it.next()方法取出来的是Object类型,怎么调用work方法
	 * 强制转换:  it.next()=Object o ==> Employee
	 * 方法参数: 控制,可以传递Employee对象,也可以传递Employee的子类的对象
	 * 泛型的限定  本案例,父类固定Employee,但是子类可以无限?
	 *   ? extends Employee 限制的是父类, 上限限定, 可以传递Employee,传递他的子类对象
	 *   ? super   Employee 限制的是子类, 下限限定, 可以传递Employee,传递他的父类对象
	 */
	public static void iterator(ArrayList<? extends Employee> array){
		
		 Iterator<? extends Employee> it = array.iterator();
		 while(it.hasNext()){
			 //获取出的next() 数据类型,是什么Employee
			 Employee e = it.next();
			 e.work();
		 }
	}
}

~~~

#### 18.5课后作业 统计集合中元素个数 集合元素排序

~~~java
package cn.itcast.demo;

import java.util.ArrayList;
import java.util.Iterator;

//定义方法统计集合中指定元素出现的次数，如"a" 3,"b" 2,"c" 1
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
	
	//实现方法，计算个数
	public static String function(ArrayList<String> list,String s) {
		Iterator<String> it =list.iterator();
		int count=0;
		while(it.hasNext()) {
			if(it.next().equals(s)) {
				count++;
			}
		}
		
		return list+"中"+s+"有"+count+"个";
				
	}
}
~~~

~~~java
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
~~~

