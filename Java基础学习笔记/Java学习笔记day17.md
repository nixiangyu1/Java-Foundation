#### 17.1基本数据类型包装类

8种基本类型对应的包装类如下：

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10284\wps2.jpg)

其中需要注意int对应的是Integer，char对应的Character，其他6个都是基本类型首字母大写即可。

基本数据类型对象包装类特点：用于在基本数据和字符串之间进行转换。

 将字符串转成基本类型： 

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10284\wps3.jpg)

##### 17.1.1Integer类的方法parseInt 和toString

~~~java
/*
 * Integer类,封装基本数据类型int,提高大量方法
 * 将字符串转成基本数据类型int
 * 
 * 
 * Integer i = Integer.valueOf("1");
 * i.intValue()
 */
public class IntegerDemo {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 *  Integer类构造方法
	 *   Integer (String s)
	 *   将数字格式的字符串,传递到Integer类的构造方法中
	 *   创建Integer对象,包装的是一个字符串
	 *   将构造方法中的字符串,转成基本数据类型,调用方法,非静态的, intValue()
	 */
	public static void function_3(){
		Integer in = new Integer("100");
		int i = in.intValue();
		System.out.println(--i);
	}
	
	/*
	 *  如何将基本类型int,变成字符串
	 *  
	 *  int => String  任何类型+"" 变成String类型
	 *  Integer类中的静态方法toString()
	 *  
	 *  toString(int ,int 进制), 将int整数,转成指定进制数
	 *  0-9A-Z
	 */
	public static void function_2(){
		int i = 3;
		String s = i+"";
		System.out.println(s+1);
		
		String s1 = Integer.toString(5,2);
		System.out.println(s1);
	}
	
	
	/*
	 * Integer类静态方法parseInt(String s, int radix)
	 * radix基数,进制
	 * "110",2 含义 前面的数字是二进制的,但是方法parseInt运行结果都是十进制
	 */
	public static void function_1(){
		int i = Integer.parseInt("110", 2);
		System.out.println(i);
	}
	
	/*
	 * Integer类中静态方法 parseInt(String s) 返回基本数据类型
	 * 要求: 字符串必须是数字格式的
	 */
	public static void function(){
		int i = Integer.parseInt("12");
		System.out.println(i/2);
	}
}

~~~

##### 17.1.2Integer类的构造方法

~~~java
package cn.itcast.demo01;
/*
 * Integer类的构造方法
 * Integer (String s)
 * 
 *intValue()返回Interger的基本类型
 */
public class IntegerDemo02 {
	public static void main(String[] args) {
		Integer in = new Integer("100");
		int i = in.intValue();
		System.out.println(i);
	}
	
	
~~~

##### 17.1.3Integer类的其他方法

~~~java
package cn.itcast.demo1;
/*
 *  Integer类中的其他方法
 *  包括三个方法,和2个静态成员变量
 */
public class IntegerDemo1 {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * Integer类的3个静态方法
	 * 做进制的转换
	 * 十进制转成二进制  toBinarString(int)
	 * 十进制转成八进制  toOctalString(int)
	 * 十进制转成十六进制  toHexString(int)
	 * 三个方法,返回值都是以String形式出现
	 */
	public static void function_1(){
		System.out.println(Integer.toBinaryString(99));
		System.out.println(Integer.toOctalString(99));
		System.out.println(Integer.toHexString(999));
	}
	
	/*
	 *   Integer类的静态成员变量
	 *   MAX_VALUE
	 *   MIN_VALUE
	 */
	public static void function(){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
	}
}
~~~

#### 17.2自动装箱和自动拆箱

~~~java
package cn.itcast.demo1;
/*
 *   JDK1.5后出现的特性,自动装箱和自动拆箱
 *   自动装箱: 基本数据类型,直接变成对象
 *   自动拆箱: 对象中的数据变回基本数据类型
 */
public class IntegerDemo2 {
	public static void main(String[] args) {
		function_2();
	}
	/*
	 *  关于自动装箱和拆箱一些题目
	 */
	public static void function_2(){
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		System.out.println(i==j);// false 对象地址
		System.out.println(i.equals(j));// true  继承Object重写equals,比较的对象数据
		
		System.out.println("===================");
		
		Integer a = 500;
		Integer b = 500;
		System.out.println(a==b);//false
		System.out.println(a.equals(b));//true
		
		System.out.println("===================");
		
		
		//数据在byte范围内,JVM不会从新new对象
		Integer aa = 127; // Integer aa = new Integer(127)
		Integer bb = 127; // Integer bb = aa;
		System.out.println(aa==bb); //true
		System.out.println(aa.equals(bb));//true
	}
	
	
	//自动装箱和拆箱弊端,可能出现空指针异常
	public static void function_1(){
	    Integer in =null;	
	    //in = null.intValue()+1
	    in = in + 1;
	    System.out.println(in);
	}
	
	//自动装箱,拆箱的 好处: 基本类型和引用类直接运算
	public static void function(){
		//引用类型 , 引用变量一定指向对象
		//自动装箱, 基本数据类型1, 直接变成了对象
		
		Integer in = 1; // Integer in = new Integer(1)
		//in 是引用类型,不能和基本类型运算, 自动拆箱,引用类型in,转换基本类型
		
		//in+1  ==> in.inValue()+1 = 2    
		// in = 2    自动装箱
		in = in + 1;
		
		System.out.println(in);
		
	}
}
/*
    ArrayList<Integer> ar = new ArrayList<Integer>();
    ar. add(1);
 */
~~~

#### 17.3System类

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps2.jpg)

 ~~~java
package cn.itcast.demo2;

public class SystemDemo {
	public static void main(String[] args) {
		function_4();
	}
	/*
	 * System类方法,复制数组
	 * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
	 * Object src, 要复制的源数组
	 * int srcPos, 数组源的起始索引
	 * Object dest,复制后的目标数组
	 * int destPos,目标数组起始索引 
	 * int length, 复制几个
	 */
	public static void function_4(){
		int[] src = {11,22,33,44,55,66};
		int[] desc = {77,88,99,0};
		
		System.arraycopy(src, 1, desc, 1, 2);
		for(int i = 0 ;  i < desc.length ; i++){
			System.out.println(desc[i]);
		}
	}
	
	/*
	 *  获取当前操作系统的属性
	 *  static Properties getProperties() 
	 */
	public static void function_3(){
		System.out.println( System.getProperties() );
	}
	
	/*
	 *  JVM在内存中,收取对象的垃圾
	 *  static void gc()
	 *  会调用finalize方法，所以需要重写finalize
	 */
	public static void function_2(){
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		new Person();
		System.gc();
	}
	
	/*
	 *  退出虚拟机,所有程序全停止
	 *  static void exit(0)
	 */
	public static void function_1(){
		while(true){
			System.out.println("hello");
			System.exit(0);
		}
	}
	/*
	 *  获取系统当前毫秒值
	 *  static long currentTimeMillis()
	 *  对程序执行时间测试
	 */
	public static void function(){
		long start = System.currentTimeMillis();
		for(int i = 0 ; i < 10000; i++){
			System.out.println(i);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
}
 ~~~

练习

~~~java
package cn.itcast.demo02;
//练习一：验证for循环打印数字1-9999所需要使用的时间（毫秒）
public class SystemTest {
	public static void main(String[] args) {
		long start1 =System.currentTimeMillis();
		for(int i=1;i<10000;i++) {
			System.out.println(i);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("耗时："+(end1-start1));
	}
}
~~~

~~~java
package cn.itcast.demo02;
//练习二：将src数组中前3个元素，复制到dest数组的前3个位置上
public class SystemTest02 {
	public static void main(String[] args) {
		int[] src= {1,2,3,4,5};
		int[] dest= {3,4,5,6,7};
		System.arraycopy(src, 0, dest, 0, 3);
		for(int i =0;i<dest.length;i++) {
			System.out.print(dest[i]);
		}
	}
}
~~~

~~~java
package cn.itcast.demo02;

import java.util.Random;

//练习三：循环生成100-999之间的的三位数并进行打印该数，当该数能被10整除时，结束运行的程序
public class SystemTest03 {
	public static void main(String[] args) {
		Random random =new Random();
		while(true) {
			int number = random.nextInt(900)+100;
			System.out.println(number);
			if(number%10==0) {
				System.exit(0);
			}
		}
	}
}
~~~

#### 17.4Math类

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps1.jpg)

~~~java
package cn.itcast.demo3;
/*
 *  数学计算的工具类
 *  java.lang.Math 静态方法组成
 */
public class MathDemo {
	public static void main(String[] args) {
		function_6();
	}
	/*
	 *  static double round(doubl d)
	 *  获取参数的四舍五入,取整数
	 */
	public static void function_6(){
		double d = Math.round(5.4195);
		System.out.println(d);
	}
	
	/*
	 *  static double random() 返回随机数 0.0-1.0之间
	 *  来源,也是Random类
	 */
	public static void function_5(){
		for(int i = 0 ; i < 10 ;i++){
			double d = Math.random();
			System.out.println(d);
		}
	}
	
	/*
	 * static double sqrt(double d)
	 * 返回参数的平方根
	 */
	public static void function_4(){
		double d = Math.sqrt(-2);
		System.out.println(d);
	}
	
	/*0
	 * static double pow(double a, double b)
	 * a的b次方
	 */
	public static void function_3(){
		double d = Math.pow(2, 3);
		System.out.println(d);
	}
	
	/*
	 * static double floor(double d)
	 * 返回小于或者等于参数d的最大整数
	 */
	public static void function_2(){
		double d = Math.floor(1.5);
		System.out.println(d);
	}
	
	/*
	 *  static double ceil(double d)
	 *  返回大于或者等于参数d的最小整数
	 */
	public static void function_1(){
		double d = Math.ceil(5.1);
		System.out.println(d);
	}
	
	/*
	 *  static int abs(int i)
	 *  获取参数的绝对值
	 */
	 public static void function(){
		int i = Math.abs(0);
		System.out.println(i);
	 }
	 
}
~~~

#### 17.5Arrays类

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps3.jpg)

~~~java
package cn.itcast.demo4;

import java.util.Arrays;

/*
 *  数组的工具类,包含数组的操作
 *  java.util.Arrays
 */
public class ArraysDemo {
	public static void main(String[] args) {
		function_2();
		int[] arr = {56,65,11,98,57,43,16,18,100,200};
		int[] newArray = test(arr);
		System.out.println(Arrays.toString(newArray));
	}
	/*
	 *  定义方法,接收输入,存储的是10个人考试成绩
	 *  将最后三个人的成绩,存储到新的数组中,返回新的数组
	 */
	public static int[] test(int[] arr){
		//对数组排序
		Arrays.sort(arr);
		//将最后三个成绩存储到新的数组中
		int[] result = new int[3];
		//成绩数组的最后三个元素,复制到新数组中
	//	System.arraycopy(arr, 0, result, 0, 3);
		for(int i = 0 ;  i < 3 ;i++){
			result[i] = arr[i];
		}
		return result;
	}
	
	/*
	 *  static String toString(数组)
	 *  将数组变成字符串
	 */
	public static void function_2(){
		int[] arr = {5,1,4,6,8,9,0};
		String s = Arrays.toString(arr);
		System.out.println(s);
	}
	
	/*
	 *  static int binarySearch(数组, 被查找的元素)
	 *  数组的二分搜索法
	 *  返回元素在数组中出现的索引
	 *  元素不存在, 返回的是  (-插入点-1)
	 */
	public static void function_1(){
		int[] arr = {1,4,7,9,11,15,18};
	    int index =  Arrays.binarySearch(arr, 10);
	    System.out.println(index);
	}
	
	/*
	 *  static void sort(数组)
	 *  对数组升序排列
	 */
	public static void function(){
		int[] arr = {5,1,4,6,8,9,0};
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
}

~~~

练习

~~~java
package cn.itcast.demo03;

import java.util.Arrays;

/*
 * 练习一：定义一个方法，接收一个数组，
 *     数组中存储10个学生考试分数，
 *     该方法要求返回考试分数最低的后三名考试分数。
 */
public class ArrayListTest {
	public static void main(String[] args) {
		double[] arr= {12,33,22,44,55};
		double[] result=function(arr);
		String s=Arrays.toString(result);
		System.out.println(s);
	}
	
	//定义方法
	public static double[] function(double[] arr) {
		double[] result=new double[3];
		Arrays.sort(arr);//对数组进行排序
		System.arraycopy(arr, 0, result, 0, 3);
		return result;
	}
}

~~~

#### 17.6BigInteger类

java中long型为最大整数类型,对于超过long型的数据如何去表示呢.在Java的世界中,超过long型的整数已经不能被称为整数了,它们被封装成BigInteger对象.在BigInteger类中,实现四则运算都是方法来实现,并不是采用运算符.

  BigInteger类的构造方法:推荐用String的构造方法

 ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps4.jpg)

~~~java
//四则运算代码：
public static void main(String[] args) {
		//大数据封装为BigInteger对象
          BigInteger big1 = new BigInteger("12345678909876543210");
          BigInteger big2 = new BigInteger("98765432101234567890");
          //add实现加法运算
          BigInteger bigAdd = big1.add(big2);
          //subtract实现减法运算
          BigInteger bigSub = big1.subtract(big2);
          //multiply实现乘法运算
          BigInteger bigMul = big1.multiply(big2);
          //divide实现除法运算
          BigInteger bigDiv = big2.divide(big1);
}
~~~

#### 17.7BigDecimal类

在程序中执行下列代码,会出现什么问题?

​    System.*out.println(0.09 + 0.01);*

​    System.*out.println(1.0 - 0.32);*

​    System.*out.println(1.015 \* 100);*

​    System.*out.println(1.301 / 100);*

 double和float类型在运算中很容易丢失精度,造成数据的不准确性,Java提供我们BigDecimal类可以实现浮点数据的高精度运算

   构造方法如下:推荐用String

   ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps7.jpg)

~~~java
package cn.itcast.demo5;

import java.math.BigDecimal;
/*
 * 计算结果,未知
 * 原因: 计算机二进制中,表示浮点数不精确造成
 * 超级大型的浮点数据,提供高精度的浮点运算, BigDecimal
System.out.println(0.09 + 0.01);//0.09999999999999999
System.out.println(1.0 - 0.32);//0.6799999999999999
System.out.println(1.015 * 100);//101.49999999999999
System.out.println(1.301 / 100);//0.013009999999999999 
*/
public class BigDecimalDemo {
	public static void main(String[] args) {
		function_1();
	}
	/*
	 * BigDecimal实现除法运算
	 * divide(BigDecimal divisor, int scale, int roundingMode) 
	 * int scale : 保留几位小数
	 * int roundingMode : 保留模式
	 * 保留模式 阅读API文档
	 *   static int ROUND_UP  向上+1
	 *   static int ROUND_DOWN 直接舍去
	 *   static int ROUND_HALF_UP  >= 0.5 向上+1
	 *   static int ROUND_HALF_DOWN   > 0.5 向上+1 ,否则直接舍去
	 */
	public static void function_1(){
		BigDecimal b1 = new BigDecimal("1.0301");
		BigDecimal b2 = new BigDecimal("100");
		//计算b1/b2的商,调用方法divied
		BigDecimal bigDiv = b1.divide(b2,2,BigDecimal.ROUND_HALF_UP);//0.01301
		System.out.println(bigDiv);
	}
	
	/*
	 *  BigDecimal实现三则运算
	 *  + - *
	 */
	public static void function(){
		BigDecimal b1 =  new BigDecimal("0.09");
		BigDecimal b2 =  new BigDecimal("0.01");
		//计算b1+b2的和,调用方法add
		BigDecimal bigAdd = b1.add(b2);
		System.out.println(bigAdd);
		
		BigDecimal b3 = new BigDecimal("1");
		BigDecimal b4 = new BigDecimal("0.32");
		//计算b3-b2的差,调用方法subtract
		BigDecimal bigSub = b3.subtract(b4);
		System.out.println(bigSub);
		
		BigDecimal b5 = new BigDecimal("1.015");
		BigDecimal b6 = new BigDecimal("100");
		//计算b5*b6的成绩,调用方法 multiply
		BigDecimal bigMul = b5.multiply(b6);
		System.out.println(bigMul);
	}
}



~~~

#### 17.8课后作业不死神兔

```java
package cn.itcast.homework;

import java.math.BigDecimal;
import java.util.ArrayList;

/*
 *  用循环实现不死神兔
	故事得从西元1202年说起，话说有一位意大利青年，名叫斐波那契。
	在他的一部著作中提出了一个有趣的问题：假设一对刚出生的小兔一个月后就能长成大兔，
	再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，一年内没有发生死亡，
	问：一对刚出生的兔子，一年内繁殖成多少对兔子?
	
	 1 1 2 3 5 8 13 21
 */
public class homework1 {

	public static void main(String[] args) {
		function_1();
	}
	//12个月繁衍多少只
	public static void function() {
		int[] arr =new int[12];
		arr[0]=1;
		arr[1]=1;
		int number=0;
		for(int i=2;i<arr.length;i++) {
			arr[i]=arr[i-1]+arr[i-2];
			
		}
		System.out.println(arr[11]);
	}
	//100个月繁衍多少只
	public static void function_1() {
		ArrayList <BigDecimal> arr=new ArrayList<BigDecimal>();
		BigDecimal a=new BigDecimal(1);
		BigDecimal b=new BigDecimal(2);
		arr.add(a);
		arr.add(b);
		for(int i=2;i<100;i++) {
			BigDecimal c1=arr.get(i-1);
			BigDecimal c2=arr.get(i-2);
			BigDecimal c3=c1.add(c2);
			arr.add(c3);		
		}
		System.out.println(arr.get(99));
		
	}
}
```

