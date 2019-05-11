## JAVA基础语法

该笔记是编写者java学习过程的记录，主要的目的是为了方便以后java的学习和复习。希望能够自己的努力，变得更加优秀，如果你也看到了这份笔记的话，希望他可以给你帮助，让我们一起变得优秀，一起加油。好了，让我们开始吧。

3个~回车是代码段

#### 1.1JDK与JRE

JDK 下载地址：http://www.oracle.com/cn/index.html

JDK安装，安装路径改成自己统一的软件路径

JDK验证：DOS里进入JDK安装路径下bin目录下（如D:\J2EE\jdk1.8.0_181\bin），然后分别输入javac和java.

JDK是JAVA的开发环境，在公司开发中需要统一JDK.

JRE是JAVA的运行环境，给用户用的环境。

JDK包含了JRE

#### 1.2JAVA的特性

JAVA具有跨平台性

JAVA的跨平台需要依靠JAVA的虚拟机JVM

#### 1.3JAVA程序编译的过程

![1557234000386](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557234000386.png)

1. 源文件：编写JAVA源文件，扩展名为.java
2. 编译：通过编译器将源文件转化为字节码文件，字节码文件的扩展名为.class;
3. 运行:最后使用解释器来运行字节码文件。



#### 1.4JAVA的环境配置

右击此电脑，点击属性，高级，环境变量，点击path，编辑，输入JDK的bin目录放在最前面，再输入英文字符“;”完成。

可能会出现找不到主类的情况，这里需要再CLASSPATH中添加以下目录：**.**;%JAVA_HOME%\lib;%JAVA_HOME%\lib\tools.jar;

#### 1.5注释，关键字，标识符，类

1.5.1注释

要养成良好的注释习惯

//单行注释

/*多行注释 

*/

/**文档注释

*/

##### 1.5.2 关键字

关键字public void static  不能作为类的名称，是JAVA自己定义的

##### 1.5.3标识符

JAVA中自己定义的内容，自定义类的名称，比如说HelloWorld称作标识符。

标识符规则：

组成：字母52个A-Z,a-z  数字0-9   下划线_  和美元符号$

注意：不能以数字开头，不能是关键字，不能用其他符号

##### 1.5.4类

类的名字：首字母大写，第二个单词首字母大写  。（为了方面阅读）

1.5.4进制

输出zhen'shu

#### 1.6程序概念

程序=数据+逻辑

程序开发离不开数据，程序是用来处理数据的

通常数据是会发生变化的，而数据的处理逻辑不会发生变化

#### 2.1数据类型

##### 2.1.1基本类型四类八种

![1557543329426](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557543329426.png)

##### 2.1.2变量的创建和类型装换

 整型 浮点型 类型转换

三要素 数据类型 变量名=数据值；

​                int            a    =   100；

变量名满足标识符要求

定义整数默认创建的是int型

如果数据超出int型的范围就会报错，所以

注意定义长整型的时候需要在数据的后面加L

定义浮点数默认创建的是double型

注意定义float类型的时候需要在数据的后面加f

注意强制转化数据类型会造成数据精度损失

~~~java
/*
   定义JAVA中的变量
   定义出所有数据类型的变量
   四类八种
*/


public class Variable{
	public static void main(String args[]){
	    //定义整数类型，字节类型 byte类型
		//内存中1个字节。-128  127  8位
		byte b=100;
		System.out.println(b);
		//定义整数类型，短整型,short类型
		//内存中2个字节，-32768 32767
		short s=200;
		System.out.println(s);
		
		//定义整数类型，整型，int类型
		//内存中4个字节，存储范围为-2147483648～2147483648。
		int i=200002;
		System.out.println(i);
		
		
		//定义整数类型，长整型，int类型
		//内存中个个字节，64位
		long l=20000223123123123L;
		System.out.println(l);
		
		//定义浮点类型 ，单精度 float类型
		//内存中4个字节
		float f=1.0F;
		System.out.println(f);
        
        
      
		//定义浮点类型 ，双精度 double类型
		//内存中8个字节
		double f=1.0;
		System.out.println(f);
        
        
        //被转后的数据类型 变量名=（被转后的数据类型）要被转的数据  
        //注意会造成数据精度损失
        int i =(int)f;
        System.out.println(i);
	}
}

~~~

#### 2.2算术运算符

~~~java
/*
   算数运算符
   + 加法,连接
   - 减法
   * 乘法
   / 除法
   % 取模, 获取余数
   ++ 自增1
   -- 自减1
*/
public class Operator{
	public static void main(String[] args){
		// + 连接作用,将一个字符串和其他数据连接起来
		// + 遇到字符串,变成连接符号"5+5=55"
		// + 任何类型只要和字符串+, 所有的数据都变成了字符串 
		System.out.println("5+5="+5+5);
		
		// 除法运算
		int i = 100;
		int j = 9;
		System.out.println(i/j);
		
		//取模运算,两个数相除,获取的是余数
		int k = 6;
		int m = 4;
		System.out.println(k%m);
		
		
		//自增运算 ++
		int a = 3;
		int b = 4;
		
		a++; // 变量a自己增加1
		System.out.println(a);
		
		++b;
		System.out.println(b);
	}
}
~~~

#### 2.3比较运算符

~~~java
/*
    比较运算符,计算结果只有2个可能,true,false
	结算结果的数据类型, boolean类型
	==  比较符号两边的数据 
	!=  比较符号两边的数据 
	>   比较符号两边的数据   1<2  true  2<2 false
	<   比较符号两边的数据 
	>=  比较符号两边的数据   1>=2 false  2>=2 true 
	<=  比较符号两边的数据 
*/
public class Operator_3{
	public static void main(String[] args){
		int i = 3;
		int j = 4;
		System.out.println(i=j);
		System.out.println(i==j);
		
		System.out.println(2==1);
		System.out.println(2!=1);
	}
}
~~~

#### 2.4三元运算符

~~~java
/*
	三元运算符
	公式:
	   布尔表达式 ? 结果1:结果2;
	   布尔表达式结果是true,三元运算符的结果,就是  结果1
	   布尔表达式结果是false,三元运算符的结果,就是 结果2
*/
public class Operator_5{
	public static void main(String[] args){
		System.out.println(3>5?99:88);
		
		String s = 0==1?"哈哈":"呵呵";
		System.out.println(s);
		
		
		int a = 5;
		int b = 3;
		int c = 1;
		//         T  && T 
		int n2 = (a>b && b>c) ? (c++) : (++c);
		System.out.println(c);
		System.out.println(n2);
	}
}
~~~

#### 2.5商场库存清单案例

##### 2.5.1案例介绍

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml24524\wps1.jpg)

l 观察清单后，可将清单分解为三个部分（清单顶部、清单中部、清单底部）

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml24524\wps2.jpg)

##### 2.5.2案例需求分析 

  

~~~java
/*
      实现商品库存清单案例
	    步骤：
		1.实现表头，是固定数据，直接写输出语句
		2.表格中间，商品数据，采用变量的形式 定义变量，找对数据结构
		   输出所有变量
		3.表格尾巴，一部分是固定数据，另一部分商品数据需要运算
*/
public class Shop{
	public static void main(String args[]){
		//输出表头固定数据
		System.out.println("--------------商品库存清单-----------------");
		System.out.println("品牌型号    尺寸    价格   库存数");
		//定义表格中的数据变量
		//品牌型号，string 尺寸double   价格 double 库存数   int
		String macBrand="MacBookAir";
		double macSize=13.3;
		double macPrice=6988.8;
		int macCount=5;
		
		String thinkBrand="ThinkPadT450";
		double thinkSize=14.0;
		double thinkPrice=5999.9;
		int thinkCount=10;
		
		
		String asusBrand="ASUS-FL5800";
		double asusSize=15.6;
		double asusPrice=4999.5;
		int  asusCount=18;
		
		//对商品信息变量进行打印，变量之间加入一定的字符串空格
	     System.out.println(macBrand+"   "+macSize+"   "+macPrice+"   "+macCount);
	     System.out.println(thinkBrand+" "+thinkSize+"   "+thinkPrice+"   "+thinkCount);
	     System.out.println(asusBrand+"  "+asusSize+"   "+asusPrice+"   "+asusCount);
		
		//计算总库存数，素有商品数求和
		int totalCount=macCount+thinkCount+asusCount;
		//计算所有商品的金额数，每个商品价格*商品数量
		double totalMoney=macCount*macPrice+thinkCount*thinkPrice+asusPrice*asusCount;
		
		//输出库存数
		System.out.println("总库存数："+totalCount);
		//输出库存商品总金额数
		System.out.println("商品库存总金额："+totalMoney);
		
	}
}
~~~

#### 2.6引用数据类型Scanner类，Random随机类

##### 2.6.1Scanner类

~~~java
/*
 引用数据类型，介绍一个类Scanner
 JAVA中已经存在了，是Sun公司为我们做好的类，使用
 他定义引用数据类型的变量，和基本类型变量区别
   int a=1;
   格式:
   类型 变量名=new 类型();
   举例：创建一个Scanner类的变量
   
   Scanner sc =new Scanner();
   int a=1;
   每个引用类型，都有自己的功能，如何使用功能
   公式：
    变量.功能的名字();
	
	Scanner类的作用，让我们在命令行中接受键盘的输入
	
	使用Scanner类的步骤：
	1.导入包，指明类所在的文件夹，关键字 import
	JAVA文件夹-util文件夹
	2.公式，创建出Scanner类型的变量
	3.变量.使用Scanner类中的功能，完成键盘输入
	
*/
import java.util.Scanner;
public class ScannerDemo{
	public static void main(String args[]){
		//类型 变量名= new 类型();
		//创建出Scanner，类变量
		Scanner sc=new Scanner(System.in);
		//变量.功能名字()接受键盘输入
		//功能：nextInt()接受键盘输入，保证输入的是整数
		//功能接受的数据就是整数，功能运行后的结果就是整数类型
		
		int i=sc.nextInt();
		System.out.println(i);
		
		
		//Scanner类的另一个功能  next()接受键盘输入的字符串
		String s=sc.next();
		System.out.println(s);
	}
}
~~~

##### 2.6.2Random随机类

~~~java
/*
    java中已经有的引用类型，Random类，作用，产生随机数
	步骤：同上
	Random类，提供功能，名字 nextInt()产生一个随机数，结果是int类型
	出现随机数的范围，在功能nextInt(写一个整数)，整数:随机出来的范围
	随机数的范围在0-指定的整数之间的随机数  nextInt(100)  0-99
	
    产生浮点的随机数:功能名字 nextDouble() 随机数的范围0.0-0.999
	
	随机数:伪随机数，虚拟机根据人写好的一个算法，生成出来的
*/

import java.util.Random;
public class RandomDemo{
	public static void main(String args[]){
		//创建出Random类型的变量
		Random ran=new Random();
		//调用Random类中的功能产生随机数
		//Random类中的，产生随机数的功能
		int i=ran.nextInt(50);
		System.out.println(i);
		
		
		double d=ran.nextDouble();
		System.out.println(d);
	}
}
~~~

#### 2.7流程控制语句

##### 2.7.1if语句与三元运算符的转换

~~~java
/*
   if语句和三元运算符的替换
   要求: 已经知道两个数,计算最大值
   两个整数,比较大小
   
   使用if还是三元
     判断条件多,使用if
	 三元,必须有结果的, if 可以没有结果的
*/
public class IfElseDemo_1{
	public static void main(String[] args){
		int i = 15;
		int j = 6;
		//使用if语句,判断出最大值
		if(i>j){
			System.out.println(i+" 是最大值");
		}else{
			System.out.println(j+" 是最大值");
		}
		
		//使用三元运算实现
		int k = i>j ? i : j;
		System.out.println(k+" 是最大值");
	}
}
~~~

##### 2.7.2switch语句

~~~java
/*
  选择语句  switch 语句
  编写格式
      switch(表达式){
		  case 常量1:
			要执行的语句;
		  break; 
		  
		  case 常量2:
			要执行的语句;
		  break;
		  
		  
		  case 常量3:
			要执行的语句;
		  break;
		  
		  default:
			要执行的语句
		  break;
	  }
	  
	  执行流程；表达式和case后面的常量进行比较
	  和哪个case的常量相同，就执行哪个case后面的程序，遇到break就全结束。
	  
	   
	如果等于1，则输出星期一
	如果等于2，则输出星期二
	如果等于3，则输出星期三
	如果等于4，则输出星期四
	如果等于5，则输出星期五
	如果等于6，则输出星期六
	如果等于7，则输出星期天
	  
	switch语句中的表达式的数据类型,是有要求的
	JDK1.0 - 1.4  数据类型接受 byte short int char
	JDK1.5   数据类型接受 byte short int char enum(枚举)
	JDK1.7   数据类型接受 byte short int char enum(枚举), String
*/
public class SwitchDemo{
	public static void main(String args[]){
		//定义变量，保存星期几的整数
		int week=6;
		//switch语句
		switch(week){
			case 1:
				System.out.println("星期一");
				break;
			case 2:
				System.out.println("星期二");
				break;
			case 3:
				System.out.println("星期三");
				break;
				
			case 4:
				System.out.println("星期四");
				break;
				
			case 5:
				System.out.println("星期五");
				break;
				
			case 6:
				System.out.println("星期六");
				break;
				
			case 7:
				System.out.println("星期日");
				break;
		}
	}
}
~~~

~~~java
/*
   switch特性: case 穿透性
   案例: 星期1-5输出 工作日 , 星期6-7  输出休息日
   case 1 case 2... case5 输出结果相同
   
   case 后面的常量,和switch中数据相同 ,没有break,一直向下穿透
   case 后面没有break, 程序就会一直向下穿透
*/
public class SwitchDemo_1{
	public static void main(String[] args){
		int week = 30;
		
		switch(week){
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			  System.out.println("工作日");
			break;
			
			case 6:
			case 7:
			  System.out.println("休息日");
			break;
		}
	}
}
~~~



#### 2.8循环语句

##### 2.8.1while循环

~~~java
/*
   循环语句: 可以让一部分代码,反复执行
   
   while循环:
       编写格式:
	   
	      while(条件){
			  循环体
		  }
		  条件: 当条件是true,就执行循环体,执行完循环体后
		  程序再次执行while中的条件,如果条件还是true,继续执行循环体
		  直到条件是false的时候,循环就结束
*/
public class WhileDemo{
	public static void main(String[] args){
		//输出 1-4之间的整数
		//定义变量,整数类型, 循环的条件
		int i = 1;
		while( i < 5 ){
			System.out.println(i);
			i++;
		}
	}
}


~~~

##### 2.8.2for循环

~~~java
/*
   for循环
     编写格式
	   for(初始化变量 ; 条件 ; 增量){
		   循环体
	   }
	   初始化变量: 定义变量,作用,控制循环的次数
	   条件: 当条件是true,执行循环体,条件是false,结束循环
	   增量: 变量自增情况
*/
public class ForDemo{
	public static void main(String[] args){
		//for循环,输出0-10
		for(int i = 0 ; i < 11 ; i++){
			System.out.println(i);
		}
	}
}
~~~

##### 2.8.3do..while循环

~~~java
/*
   do...while循环
     编写格式:
	 
	   do{
		   循环体
	   }while(条件);
	特点: 无条件先执行一次
*/
public class DoWhileDemo{
	public static void main(String[] args){
		int i = 0; 
		do{
			System.out.println(i);
			i++;
		}while( i <  5);
	}
}
~~~

#### 2.9猜数字案例

![1557398306755](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557398306755.png)

~~~java
/*
   实现猜数字的小游戏
    随机一个数字，让用户猜
	结果三种情况:
	中了，大了,笑了
   随机数:Random
   接盘输入:Scanner
   猜的数字和随机数进行比较，用if做判断
   知道猜中为止，反复去猜，循环while
*/
import java.util.Random;
import java.util.Scanner;
public class GuestNumber{
	public static void main(String args[]){
	System.out.println("游戏开始，系统将会生产1-100的数字，猜猜这个数吧！");
	System.out.println("请输入您猜的数字：");
	//创建random类的对象
	Random ran=new Random();
	//变量.使用功能nextInt()获取1-100的随机数
	int ranNumber=ran.nextInt(100)+1;
	System.out.println(ranNumber);
	//创建Scanner类的对象	
	Scanner sc=new Scanner(System.in);
	
	while(true){
		//获取键盘输入
		int number=sc.nextInt();
		if(number>ranNumber){
			System.out.println("猜大了");
		}else if(number<ranNumber){
			System.out.println("猜小了");
			
		}else{
			System.out.println("猜中了");
			break;
		}
	}
	
	}
}


~~~

#### 3.1一维数组

##### 3.1.1一维数组内存图

![1557488992749](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557488992749.png)

##### 3.1.2一维数组的length属性

~~~java
/*
   定义数组容器
    定义数组容器，要素，强制数据类型的语言
	必须有数据类型，大小，就是存储数据的个数
	定义数组公式:
	  数据类型[] 变量名 = new 数据类型[存储元素的个数];
	  
	  数据类型:数组中存储元素的数据类型
	  [] 表示数组的意思
	  变量名  自定义标识符
	  
	  new 创建容器关键字
	  数组类型：数组中存储元素的数据类型
	  []表示数组的意思
	  元素个数，就是数组中，可以存储多少个数(恒定，定长)
	  
	  数组是一个容器:存储到数组中的每个元素，都有自己的自动编号
	  自动编号，最小值是0，最大值是长度-1
	  自动标号专业名字:索引(index),下标，角标
	  访问数组存储的元素，必须依赖于索引， 公式 数据名[索引]
	  
	  
	  
	  Java提供一个属性，操作索引的
	  数组中的一个属性，就是数组的长度，属性的的名字 length
	  使用属性:数组名.length  数据类型 int

*/
public class ArrayDemo{
	public static void main(String args[]){
		//定义数组，存储整数，容器的长度，3个
		//数据类型[]变量名=new 数据类型[存储元素的个数];
		int[] arr=new int[3];
		System.out.println(arr);
		
		
		//通过索引的方式访问数组中的每个元素
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		
		
		System.out.println(arr.length);
	}
}
~~~

##### 3.1.3一维数组的定义

~~~java
/*
  数组的两个定义方式
     数据类型[]  变量名 = new 数据类型[]{元素1,元素2,元素3};
	 注意事项: new 后面的中括号中,不允许写任何内容,写了就编译失败
	 
	 数据类型[]  变量名 = {元素1,元素2,元素3};
*/
public class ArrayDemo_2{
	public static void main(String[] args){
	    //定义数组,定义的同时,对元素进行赋值
		int[] arr = new int[]{1,2,4,5,7,9};
		System.out.println(arr.length);
		System.out.println(arr[5]);
		
		
		System.out.println("==================");
		//定义数组,直接大括号赋值
		int[] arr2 = {0,2,4,6,8};
		System.out.println(arr2.length);
		System.out.println(arr2[1]);
	}
}
~~~

##### 3.1.4一维数组元素赋值

~~~java
/*
    数组的操作, 使用索引,对数组中的元素赋值
*/
public class ArrayDemo_1{
	public static void main(String[] args){
	    //定义数组,存储int类型数组,长度就是5
		int[] arr = new int[5];
		
		//将1索引上的元素,赋值3
		arr[1] = 3;
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
}
~~~

3.1.5一维数组的遍历

~~~java
/*
   数组遍历:
     将所有的数组元素,全获取
	 依靠索引, 规律从0开始,一直在自动增长1, 到达length-1
	 循环来实现
	   for    知道循环次数, 计数器思想
	   while  不确定循环次数
*/

public class ArrayDemo_3{
	public static void main(String[] args){
		int[] arr = {2,1,3,5,7,0,4};
		
		for(int i = 0 ; i < arr.length; i++){
			System.out.println(arr[i]);
		}
	}
}
~~~

##### 3.1.5一维数组常见的异常

~~~java
/*
  数组操作中,常见的两个异常
     数组的索引越界异常
	 空指针异常
*/
public class ArrayDemo_4{
	public static void main(String[] args){
		//数组的索引越界异常
		//int[] arr = {5,2,1};
		//数组中3个元素,索引 0,1,2
		//System.out.println(arr[3]);//java.lang.ArrayIndexOutOfBoundsException: 3
		
		//空指针异常
		int[] arr2 = {1,5,8};
		System.out.println(arr2[2]);
		arr2 = null; // arr2 不在保存数组的地址了
		System.out.println(arr2[2]);//java.lang.NullPointerException
	}
}
~~~

##### 3.1.6获取一维数组中的最大值

~~~java
/*
    计算数组中的最大值
	数组  {4,1,7,5}; 做比较
*/
public class ArrayDemo_5{
	public static void main(String[] args){
		//定义数组,int类型
		int[] arr = {5,1,12,4,6,8,0,3};
		//定义变量,记录数组中0索引上的元素
		int max = arr[0];
		
		//遍历数组,获取所有的元素,和变量max比较
		for(int i = 1; i < arr.length ; i++){
			//变量max,和数组中的每个元素进行比较
			//如果max,小于了数组中的一个元素
			if( max < arr[i] ){
				//较大的数组的元素,赋值给max
				max = arr[i];
			}
		}
		// 遍历完成,变量max,就是数组最大值
		System.out.println(max);
	}
}
~~~



#### 3.2二维数组

##### 3.2.1二维数组的定义

~~~java
/*
    二维数组
	  数组中的数组,数组里面存储的还是数组
	  
	定义方式和一维数组很相似
	
	int[][] arr = new int[3][4];
	定义一个二维数组
	[3]  表示: 二维数组中,有三个一维数组
	[4]  表示: 三个一维数组中,每个数组的长度是4
*/
public class ArrayArrayDemo{
	public static void main(String[] args){
		int[][] arr = new int[3][4];
		System.out.println(arr);
		
		System.out.println(arr[1]);
		System.out.println(arr[2][3]);
	}
}
~~~

##### 3.2.2二维数组内存图

![1557497141627](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557497141627.png)

##### 3.2.3二维数组定义

~~~java
/*
     int[][] arr = new int[3][] 不推荐
	 二维数组中定义三个一维数组,每个一维数组长度,没有指定
	 arr[0]
	 arr[1]
	 arr[2]
	 必须要new
	   arr[0] = new int[5];
	   arr[1] = new int[4];
	   
	 最简单的二维数组定义方式
	   int[][] arr = { {1,4} ,{3,6,8}, {0,9,8} };
*/

public class ArrayArrayDemo_1{
	public static void main(String[] args){
		int[][] arr = { {1,2,3},{4,5},{6,7,8,9},{0} };
		
		//问题: 打印7,是数组中的元素0
		
		System.out.println(arr[2][1]);
		
		//问题: 输出结果
		System.out.println(arr[3][0]);
	}
}
~~~

##### 3.2.4二维数组的遍历

~~~java
/*
  二维数组的遍历
    二维数组中,存储4个一维数组,每个一维数组的长度不同

	遍历: for循环,遍历二维数组
	      遍历过程中, for遍历一维数组

*/
public class ArrayArrayDemo_2{
	public static void main(String[] args){
		int[][] arr = { {1,2,3},{4,5},{6,7,8,9},{0} };
		
		//外循环,遍历二维数组
		for(int i = 0 ; i < arr.length ;i++){
			//内循环,遍历每个一维数组 arr[0] arr[1] arr[i]
			for(int j = 0 ; j < arr[i].length; j++){
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}
}
~~~



#### 3.3JVM的内存划分

![1557488538390](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557488538390.png)

#### 3.4公司销售总和练习

~~~java
/*
   二维数组的遍历求和
    第一小组销售额为{11, 12}万元    
    第二小组销售额为{21, 22, 23}万元
    第三小组销售额为{31, 32, 33, 34}万元。
	每个小组就是一个数组, 三个数组存储到一个数组中,形成二维数组
	求和:
	  每个小组求和
	  所有元素求和
*/

public class ArrayArrayDemo_3{
	public static void main(String[] args){
		int[][] arr = {  {11,12} , {21,22,23} ,{31,32,33,34} };
		//定义变量,保存2个求和的值
		int sum = 0 ; //所有元素的求和
		int groupSum = 0 ; //每个一维数组的求和
		
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[i].length ; j++){
				//将一维数组的元素求和
				groupSum += arr[i][j];
			}
			System.out.println("每个小组总金额 "+groupSum);
			
			//将每个一维数组的总和在相加
			sum += groupSum;
			//每个唯一数组求和,清空
			groupSum = 0;
		}
		System.out.println("本公司总金额 "+sum);
	}
}
~~~

#### 3.5随机点名器

~~~java
/*
   随机点名器:
     1  存储姓名
	 2. 预览所有人的姓名
	 3. 随机出一个人的姓名
*/
import java.util.Random;
public class CallName{
	public static void main(String[] args){
		//存储姓名,姓名存储到数组中
		//数组存储姓名,姓名的数据类型,String
		String[] names = {"张三","李四","王五","李蕾","韩梅梅","小名","老王","小华","约翰逊","爱丽丝"};
		
		//预览: 遍历数组,打印所有姓名
		for(int i = 0 ; i < names.length ; i++){
			System.out.println(names[i]);
		}
		System.out.println("=============");
		
		//随机出一个人的名
		//利用随机数,生成一个整数,作为索引,到数组中找到对应的元素
		Random ran = new Random();
		//随机数,范围必须是0-数组的最大索引
		int index = ran.nextInt(names.length);//index 就是随机数,作为索引
		System.out.println(names[index]);
	}
}
~~~

#### 4.1方法

在Java中，方法就是用来完成解决某件事情或实现某个功能的办法。

#### 