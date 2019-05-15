JAVA基础语法

该笔记是编写者java学习过程的记录，主要的目的是为了方便以后java的学习和复习。如果你也看到了这份笔记的话，希望他可以给你帮助。好了，让我们开始吧。

我用的笔记工具是  ：Typora 支持md格式，  大纲模式方便复习

用的编译工具是：Notepad++  ，学习初期比较方便

本地截图不能在github上正常显示，可以将截图保存在有道云笔记上，写成网络地址，但这样在本地就不能好好显示了，所以编写者，这里就偷懒用本地地址了。

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

##### 1.5.4进制

十进制表示方式：正常数字   如 13、25等

二进制表示方式：以0b(0B)开头    如0b1011 、0B1001 

十六进制表示方式：以0x(0X)开头   数字以0-9及A-F组成  如0x23A2、0xa、0x10 

八进制表示方式：以0开头   如01、07、0721

#### 1.6程序概念

程序=数据+逻辑

程序开发离不开数据，程序是用来处理数据的

通常数据是会发生变化的，而数据的处理逻辑不会发生变化

#### 2.1数据类型

变量就是申请内存来存储值，即当创建变量的时候，需要在内存中申请空间。
 内存管理系统根据变量的类型为变量分配存储空间，确定了变量的类型，即确定了数据需分配内存空间的大小，数据在内存的存储方式。

 

Java两大数据类型：内置数据类型/基本数据类型、引用数据类型

- 基本数据类型：都是直接存储在内存中的内存**栈**上，数据本身的值就是存储在栈空间；
- 引用数据类型：引用类型继承与Object类，引用（即指针）是存储在有序的内存栈上，而对象本身的值存储在内存堆中。

##### 2.1.1基本类型四类八种

![1557543329426](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557543329426.png)

##### 2.1.2引用数据类型(三种)

- 引用类型指向一个对象，指向对象的变量是引用变量。这些变量在声明时候被指定为一个特定的类型，声明之后不能改变。
  
- 引用数据类型包括：类（对象）、接口、数组。
  
- 所有引用类型默认值都是null.
  
- 一个引用变量可以用于引用任何与之兼容的类型。



##### 2.1.3变量的创建和类型装换

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

#### 2.6Scanner类，Random随机类

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

##### 4.1.1方法的定义和调用

~~~java
/*
    方法定义格式
	   修饰符  返回值类型  方法的名字(参数列表。。){
		   方法的功能主体
		     循环，判断，变量，比较，运算
			 return ;
	   }
	 修饰符:目前是固定写法 public static
     返回值类型:方法在运算后，结果的数据类型
     方法名：自定义名字，满足标识符规范，方法名字首字母小写，后面每个单词首字母大写
	 参数列表:方法的运算过程中，是否有未知的数据，如果有未知的数据，定义在参数列表上(定义变量)
	 return：方法的返回，将计算的结果返回，结束方法
	 
*/
public class MethodDemo{
	public static void main(String args[]){
		//调用方法，方法执行起来
		//在方法main中，调用方法 getArea
		int area=getArea(5,6);
		System.out.println(area);
	}
	/*
	   要求：计算一个长方形的面子
	   定义方法解决这个要求
	   分析方法定义过程：
	      1.明确方法计算后的结果的数据类型 int  定义格式队对应的就是返回值类型
		  2.方法计算过程中，有没有未知的数据，长和宽，未知数据的数据类型 int
             未知数的变量，定义在方法的小括号内		  
		  	     
	*/
	public static int getArea(int w,int h){
		//实现方法的功能主体
		int area =w*h;
		return area;
	}
}
~~~

##### 4.1.2方法的执行过程

![1557551417139](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557551417139.png)

##### 4.1.3方法调用的内存图

![1557551827743](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557551827743.png)

##### 4.1.4方法调用的练习

~~~java
/*
    方法调用的练习
	 
*/
import java.util.Scanner;
public class MethodDemo{
	public static void main(String args[]){
		
		printRect();
		System.out.println(getNumber());
		printRect2(3,4);
	}
	
	
	
	/*
		    定义无返回值的无参数方法，如打印3行，每行3个*号的矩阵
			为什么没有返回值：
			     打印矩阵，输出效果，不需要将接管返回
				 明确未知数:不需要未知数
		*/
	public static void printRect(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	/*
		 定义有返回值无参数方法，如键盘录入得到一个整数
		 明确方法计算后结果的数据类型int
		 明确有没有未知数
		*/
	public static int getNumber(){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		return number;
	}
	
	
	
	/*
		定义无返回值有参数方法，如打印指定M行，每行N个*号的矩阵
		明确方法计算后结果，控制台输出图像，没有返回值的
		
	
	
	*/
	public static void printRect2(int m,int n){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	/*
	*/
	
}
~~~



##### 4.1.5方法的定义和使用的注意事项

1.方法不能定义在另一个方法的里面。

2.写错方法名字。

3.写错了参数列表

4.方法返回值的void，方法中可以省略return 不写

​    return下面不能有代码

5.方法返回值类型，和return后面数据类型必须匹配

6.方法重复定义问题

7.调用方法的时候，返回值是void,不能写在输出语句中

##### 4.1.6方法的重载特性

~~~java
/*
    方法的重载特性 (overload)
	在同一个类中,允许出现同名的方法,只要方法的参数列表不同即可,这样方法就是重载
	参数列表不同: 参数的个数,数据类型,顺序
*/
public class MethodOverLoadDemo{
	public static void main(String[] args){
		//对于重载的调用,根据参数传递进行区分
		//System.out.println();
		double sum = getSum(2.3,3.5);
		System.out.println(sum);
	}
	/*
	  对参数求和,利用方法的重载特性
	*/
	public static int getSum(int a,int b){
		System.out.println("两个int参数");
		return a+b;
	}
	public static int getSum(int a,int b,int c){
		System.out.println("三个int参数");
		return a+b+c;
	}
	public static double getSum(double a,double b){
		System.out.println("两个double参数");
		return a+b;
	}
	/*
	   定义方法,对参数求和
	   参数,没规定几个,数据类型
	
	public static int getSum(int a ,int b){
		return a+b;
	}
	
	public static double getSumDouble(double a,double b){
		return a+b;
	}
	public static int getSum3(int a,int b, int c){
		return a+b+c;
	}*/
}
~~~

##### 4.1.7方法重载的注意事项

1.参数列表必须不同

2.重载和参数变量名无关

3.重载和返回值类型无关

4.重载和修饰符无关

技巧:重载看方法名和参数列表

##### 4.1.8方法参数是基本类型类型注意事项

![1557556940252](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557556940252.png)

##### 4.1.9方法参数是引用类型注意事项

方法中改变数组的值，会引起中main方法中数组的值的改变，因为引用类型传递的是地址；

![1557556803335](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557556803335.png)

#### 4.2随机点名器

~~~java
/*
	实现随机点名器
	1.存储所有人的姓名
	2.预览所有学生的姓名，遍历数组
	3.随机数最为索引，到数组中找元素
	
	将功能独立出来，做成方法，调用方法即可
	
	定义三个功能,用到同一个姓名数据
	姓名存储到数组中，三个方法，使用一个数组中的数据，方法传递参数
    


*/


import java.util.Random;

public class CallName{
	public static void main(String args[]){
		//定义数组，存储学生姓名
		String[] names=new String[8];
		//调用添加姓名方法
		addStudent(names);
		//调用遍历数组方法
		printStudentName(names);
		//调用随机姓名方法
		System.out.println(randomStudentName(names));
	}
	
	
	/*
		定义方法，实现向数组中添加学生姓名
		返回值？没有
		参数是数组
	
	
	*/
	public static void addStudent(String[] names){
		names[0]="倪翔宇";
		names[1]="刘淑媛";
		names[2]="张三";
		names[3]="李四";
		names[4]="韩五";
		names[5]="李磊";
		names[6]="王六";
		names[7]="刘七";
	}
	
	
	/*
		定义方法，遍历数组
		返回值？没有
		参数？数组
	*/
	public static void printStudentName(String[] names){
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
	}
	
	
	
	/*
		定义方法，随机数，作为索引，在数组中找到学生姓名
		返回值？学生姓名
		参数？  数组
		
	
	*/
	public static String randomStudentName(String[] names){
		Random ran=new Random();
		int index=ran.nextInt(names.length);
		return names[index];
	}
	
}


~~~

#### 4.3库存案例

~~~java
/*
   实现商品的库存管理
     功能:
	    1. 展示用户选择功能清单
		2. 根据选择的功能编号,进行不同的操作
		   A. 展示所有库存
		   B. 修改库存数量
		   
	  分析:
	    1. 展示用户清单:
		   输出语句, 用户输入, 选择功能序号
		2. 根据选择,调用不同的方法
		    switch语句
			  case 1 2 3
		
		   A  展示库存
		     将存储商品的数组,遍历
		   B  修改库存
		        
			  修改所有的库存数量
*/
import java.util.Scanner;
public class Shopp{
	public static void main(String[] args){
		//使用数组,保存商品的信息
		//品名,尺寸,价格,库存数, 定义5个数组
		String[] brand = {"MacBookAir","ThinkpadT450"};
		double[] size = {13.3,15.6};
		double[] price = {9998.97,6789.56};
		int[] count = {0,0};
		while(true){
		int choose = chooseFunction();
		switch(choose){
			case 1:
			  //调用查看库存清单方法
			  printStore(brand,size,price,count);
			break;
			
			case 2:
			  //调用修改库存的方法
			  update(brand,count);
			break;
			
			case 3:
			 return ;
			
			
			default:
			  System.out.println("没有这个功能");
			break;
		}
		}
	}
	/*
	  定义方法,修改所有商品的库存
	    用户输入1个,修改1个
		返回值,没有
		参数, 库存数的数组, 品名数组
	*/
	public static void update(String[] brand, int[] count){
		//遍历数组,遍历到一个,修改一个
		//接受键盘输入
		Scanner sc = new Scanner(System.in);
		//遍历数组
		for(int i = 0; i < brand.length ; i++){
			System.out.println("请输入"+brand[i]+"的库存数");
			//键盘输入,录入库存, 存储到库存的数组中
			int newCount = sc.nextInt();
			count[i] = newCount;
		}
		//int chooseNumber = sc.nextInt();
	}
	
	/*
	   定义方法,展示所有的库存清单,遍历
	   返回值,没有
	   参数, 数组
	*/
	public static void printStore(String[] brand,double[] size,double[] price,int[] count){
		System.out.println("----------商场库存清单----------");
		System.out.println("品牌型号     尺寸    价格    库存数");
		//定义变量,计算总库存数,和总价格
		int totalCount = 0;
		int totalMoney = 0;
		//遍历数组,将数组中所有的商品信息打印出来
		for(int i = 0 ; i < brand.length ; i++){
			System.out.println(brand[i]+"   "+size[i]+"    "+price[i]+"   "+count[i]);
			totalCount += count[i];
			totalMoney += count[i]*price[i];
		}
		System.out.println("总库存数: "+totalCount);
		System.out.println("商品库存总金额: "+totalMoney);
	}
	
	/*
	  定义方法,实现用户的选择功能,功能的需要返回来
	  返回值, int
	  参数, 没有
	*/
	public static int chooseFunction(){
		System.out.println("-------------库存管理------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号：");
		//接受键盘输入
		Scanner sc = new Scanner(System.in);
		int chooseNumber = sc.nextInt();
		return chooseNumber;
	}
}


~~~

#### 5.1引用数据类型分类

- 引用数据类型包括：类（对象）、接口、数组。
  
- 所有引用类型默认值都是null.
  
- 一个引用变量可以用于引用任何与之兼容的类型。

##### 5.1.1类的类型分类

提到引用数据类型（类），其实我们对它并不陌生，如使用过的Scanner类、Random类。

我们可以把类的类型为两种：

l 第一种，Java为我们提供好的类，如Scanner类，Random类等，这些已存在的类中包含了很多的方法与属性，可供我们使用。

l 第二种，我们自己创建的类，按照类的定义标准，可以在类中包含多个方法与属性，来供我们使用。

这里我们主要介绍第二种情况的简单使用。

##### 5.1.2自定义数据类型概述

我们在Java中，将现实生活中的事物抽象成了代码。这时，我们可以使用自定义的数据类型（类）来描述（映射）现实生活中的事物。

类，它是引用数据类型，与之前学习的所有引用数据类型相同，自定义类也是一种数据类型。只是自定义类型并非Java为我们预先提供好的类型，而是我们自己定义的一种引用数据类型用来描述一个事物。

##### 5.1.3类的定义与使用

java代码映射成现实事物的过程就是定义类的过程。

我们就拿一部手机进行分析，它能用来做什么呢？它可以打电话，上网，聊微信等，这些就是手机所提供的功能，也就是方法；手机也有它的特征，如颜色、尺寸大小、品牌型号等，这些就是手机的特征，也就是属性。

目前，我们只关注类中的属性，类中的方法在面向对象部分再进行学习。

##### 5.1.4自定义手机类和测试

~~~java
/*
    定义类:
	  使用类的形式,对现实中的事物进行描述
	  事物: 方法,属性
	    方法: 这个事物具备的功能
		属性: 变量

     格式:
	   public class 类名{
		    属性定义
			  修饰符 数据类型 变量名 = 值
			
			方法定义
			  修饰符 返回值类型  方法名(参数列表){
				  
			  }
	   }
	   
	   要求: 使用Java中的类,描述生活中的手机这个事物
	     手机事物,具备哪些属性, 属于他自己的特性
		   颜色,品牌, 大小
*/
public class Phone{
	/*
	    定义手机的属性
	*/
	String color ;
	String brand ;
	double size ; 
}

~~~

~~~java
/*
   测试,刚定义好的Phone类
   创建引用类型变量的格式
   
     数据类型  变量名 = new 数据类型();
	 
	实现引用类型的步骤
	  1: 导入包 , 类都是在同一个文件夹,不需要导入包
	  2: 创建引用类型的变量
	  3: 变量.类型中的功能
*/

public class TestPhone{
	public static void main(String[] args){
		// 2: 创建引用类型的变量
		Phone p = new Phone();
		//System.out.println(p);  //输出内存的地址
	
     	//3: 变量.类型中的功能
		//变量 p.的方式,调用类中的属性
		//属性就是变量 , 赋值和获取值
		p.color = "土豪金";
		p.brand = "爱立信";
		p.size = 5.0;
		
		//获取属性值
		System.out.println(p.color+"  "+p.brand+"  "+p.size);
	}
}
~~~

~~~java
/*
    测试手机类
	  创建2个手机类的变量
*/
public class TestPhone_1{
	public static void main(String[] args){
		//创建手机类型变量
		Phone p1 = new Phone();
		
		//再次创建手机类型变量
		Phone p2 = new Phone();
		
		p1.color = "白色";
		p1.brand = "锤子";
		p1.size = 4.5;
		
		p2.brand = "华为";
		
		System.out.println(p1.brand);
		System.out.println(p2.brand);
		System.out.println(p2.size);
	}
}
~~~

##### 5.1.5自定义类的内存图

![1557631844291](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557631844291.png)

5.1.6自定义类的练习

~~~java
/*
	定义测试类
	  同时测试，电饭锅，学生，汽车

*/

public class Test{
	public static void main(String args[]){
		//创建电饭锅的引用类型
		DianFanGuo dfg=new DianFanGuo();
		
		dfg.brand="特斯拉";
		dfg.colour="红色";
		dfg.size=30;
		
		System.out.println(dfg.brand+" "+dfg.colour+" "+dfg.size);
		
		//创建汽车引用
		Car c=new Car();
		c.brand="兰博基尼";
		c.type="超跑";
		c.paiLiang=0.5;
		
		System.out.println(c.brand+" "+c.type+" "+c.paiLiang);
	}
}
~~~

~~~java
/*
    电饭锅，包含属性（品牌、容量大小、颜色等）
	定义类,描述事物,电饭锅
	  属性: 品牌,大小 ,颜色
	
	定义类,类名字,电饭锅
	类的范围,定义三个属性
*/

public class DianFanGuo{
	//定义三个属性
	String brand;
	double size;
	String colour;
}
~~~

~~~java
/*
	汽车，包含属性(品牌、排量、类型等)
	定义类，类名 Car
	 属性 品牌 排量 类型 
	 
*/

public class Car{
	//定义汽车三个属性
	String brand;
	double paiLiang;
	String type;
}
~~~

#### 5.2ArrayList集合的使用

| **基本数据类型** | **对应的引用数据类型表示形式** |
| ---------------- | ------------------------------ |
| **byte**         | Byte                           |
| **short**        | Short                          |
| **int**          | Integer                        |
| **long**         | Long                           |
| **float**        | Float                          |
| **double**       | Double                         |
| **char**         | Character                      |
| **boolean**      | Boolean                        |

~~~java
/*
   ArrayList集合的使用
   也是引用数据类型
   步骤:
     1. 导入包 java.util包中
	 2. 创建引用类型的变量
	   数据类型< 集合存储的数据类型>  变量名 = new 数据类型 <集合存储的数据类型>  ();
	   集合存储的数据类型: 要将数据存储到集合的容器中
	   创建集合引用变量的时候,必须要指定好,存储的类型是什么
	   
	   ArrayList<String> array = new ArrayList<String>();
	  
	 3. 变量名.方法 
	 
	 注意: 集合存储的数据,8个基本类型对应8个引用类型
	 存储引用类型,不存储基本类型
*/
import java.util.ArrayList;
public class ArrayListDemo{
	public static void main(String[] args){
		//创建集合容器,指定存储的数据类型
		//存储字符串
		ArrayList<String> array = new ArrayList<String>();
		
		//创建集合容器,存储整数
		ArrayList<Integer> array2 = new ArrayList<Integer>();
		
		//创建集合容器,存储手机类型
		ArrayList<Phone> array3 = new ArrayList<Phone>();
	}
}


~~~

##### 5.2.1ArrayList的常见方法

| **方法声明**                  | **功能描述**                  |
| ----------------------------- | ----------------------------- |
| **boolean add（Object obj）** | 将指定元素obj追加到集合的末尾 |
| **Object get（int index）**   | 返回集合中指定位置上的元素    |
| **int size（）**              | 返回集合中的元素个数          |

~~~java
/*
   ArrayList 集合中的方法
   
   add(参数) 向集合中添加元素,数据存储进去
   方法中的参数类型,定义集合对象时候的类型是一致
   
   ArrayList<Integer> array = new ArrayList<Integer>();
   array.add(3);
   
   get(int index) 取出集合中的元素,get方法的参数,写入索引
   
   size() 返回集合的长度, 集合存储元素的个数
*/
import java.util.ArrayList;
public class ArrayListDemo_1{
	public static void main(String[] args){
		//定义集合,存储字符串元素
		ArrayList<String> array = new ArrayList<String>();
		//调用集合方法add存储元素
		array.add("abc");
		array.add("itcast");
	    array.add("love");
		array.add("java");
		//输出集合的长度,调用集合方法size, size方法的返回值类型 int
		int size = array.size();
		System.out.println(size);
		
		//获取出集合中的一个元素,获取1索引的元素
		//集合的方法get, 获取元素后结果数据类型
		String s = array.get(1);
		System.out.println(s);
		
		
		System.out.println(array.get(0));
		System.out.println(array.get(1));
		System.out.println(array.get(2));
		System.out.println(array.get(3));
	}
}
~~~

##### 5.2.2ArrayList的补充方法

~~~java
/*
   集合ArrayList方法的补充
   
     add(int 索引,存储的元素) 将元素添加到指定的索引上
	 set(int 索引,修改后的元素) 将指定索引的元素,进行修改
	 remove(int 索引) 删除指定索引上的元素
	 clear() 清空集合中的所有元素
*/
import java.util.ArrayList;
public class ArrayListDemo_3{
	public static void main(String[] args){
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		
		//在索引2上,添加元素7
		array.add(2,7);
		
		//将0索引上的元素,修改成10
		array.set(0,10);
		
		//将4索引上的元素,删除
		array.remove(4);
		
		array.clear();
		
		//使用方法 size+get组合进行遍历
		for(int i = 0 ; i < array.size(); i++){
			System.out.println( array.get(i) );
		}
	}
}
~~~

##### 5.2.3随机点名器



~~~java
/*
	随机点名器，集合改进(学生的姓名和年龄)
	现实中有学生这个事物，使用定义类的形式，描述学生事物
	属性:姓名，年龄
	
	姓名储存了数组，将容器转成集合
	String[] s={"",""};
	集合中，存储的是学生的姓名吗？ 应该存储Student类型
	
	
	存储学生:
		学生类型，存储到集合中
	总览:遍历集合
	随机:随机数，作为索引，到集合中找到元素
	
	定义三个功能，共享数据，集合容器;
	定义三个方法，必须参数传递集合;
*/
import java.util.Random;
import java.util.ArrayList;


public class CallName{
	public static void main(String args[]){
		//定义集合，储存的是StudentName类型变量
		ArrayList <StudentName> array=new ArrayList<StudentName>();
		//调用添加方法
		add(array);
		//调用遍历集合
		printArrayList(array);
		randomStudentName(array);
	}
	/*
		随机数，当作集合的索引，到集合中找到元素
	
	*/
	public static void randomStudentName(ArrayList<StudentName> array){
		Random ran=new Random();
		int number=ran.nextInt(array.size());
		//随机数，索引，到集合中get
		StudentName s=array.get(number);
		System.out.println(s.name+" "+s.age);
	}
	
/*
	总览学生信息，遍历集合
*/
	public static void printArrayList(ArrayList<StudentName> array){
		for(int i=0;i<array.size();i++){
		//存储集合的时候，集合.add(sn1) sn1是StudentName
		//获取的时候，集合.get方法，获取出来是什么  还是StudentName类型变量
		    StudentName s=array.get(i);
			System.out.println(s.name+" "+s.age);
		}
	}


/*
	定义方法，实现存储学生的姓名和年龄
	创建StudentName类型变量，存储到集合中
*/
	public static void add(ArrayList<StudentName> array){
	//创建StudentName类型变量
		StudentName sn1=new StudentName();
		StudentName sn2=new StudentName();
		StudentName sn3=new StudentName();
		StudentName sn4=new StudentName();
		StudentName sn5=new StudentName();
	
		sn1.name="张三1";
		sn1.age=201;
	
		sn2.name="张三2";
		sn2.age=202;
	
		sn3.name="张三3";
		sn3.age=203;
	
		sn4.name="张三4";
		sn4.age=204;
	
		sn5.name="张三5";
		sn5.age=205;
		//将StudentName变量，储存到集合中
		array.add(sn1);
		array.add(sn2);
		array.add(sn3);
		array.add(sn4);
		array.add(sn5);
	
	}
}
~~~

~~~java
/*
    描述学生事物的类
	  属性: 姓名和年龄
	学生类型的变量,存储到集合中
	  
*/
public class StudentName{
	String name;
	int age;
}
~~~

##### 5.2.4库存管理

~~~java
/*
	实现库存管理案例:
		1.存储商品信息
			存储商品信息
			将商品类型的变量，存储到集合中
			
		2.查看库存清单
			将集合进行遍历，获取出集合中存储的Goods类型变量
			输出每一个Goods类型的属性
			计算求和:总库存,金额数
		 
		3.修改商品库存
			集合遍历，获取出集合中储存的Goods类型的变量
			变量调用Goods类的属性count,值进行修改(键盘输入)
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Shopp{
	public static void main(String args[]){
		//创建ArrayList集合，存储Goods类型
		ArrayList<Goods> array=new ArrayList<Goods>();
		//调用添加商品信息的方法
		addGoods(array);
		//进入死循环
		while(true){
			//调用选择功能的方法，获取用户输入的序号
			int number=chooseFunction();
			//对序号判断，如果=1 进入查看库存功能 =2进入修改库存功能 =3退出
			switch(number){
				case 1:
				//进入查看库存方法
				printStore(array);
				break;
				
				case 2:
				//进入修改库存功能
				update(array);
				break;
				
				case 3:
				return;
				
				default:
				 System.out.println("无此功能");
				 break;
			}
		}
		
	}
	
	/*
		定义方法，实现选择菜单，用户根据功能选择菜单
	*/
	public static int chooseFunction(){
		System.out.println("-------------库存管理------------");
		System.out.println("1.查看库存清单");
		System.out.println("2.修改商品库存数量");
		System.out.println("3.退出");
		System.out.println("请输入要执行的操作序号：");
		Scanner sc=new Scanner(System.in);
		int number =sc.nextInt();
		return number;
	}
	
	/*
		方法定义，修改库存
		键盘输入，将Goods的属性count，进行修改(键盘输入)
	*/
	public static void update(ArrayList<Goods> array){
		Scanner sc =new Scanner(System.in);
		//遍历集合，获取集合中的每个元素
		for(int i=0;i<array.size();i++){
			//集合方法get获取的是集合的元素,元素类型Goods
			Goods g = array.get(i);
			System.out.println("请输入"+g.brand+"库存数");
			//Goods属性，count进行修改
			g.count=sc.nextInt();
			
		}
	}
	
	
	/*
		定义方法，查看库存清单，遍历集合
	*/
	public static void printStore(ArrayList<Goods> array){
		//输出表头
		System.out.println("--------------商品库存清单-----------------");
		System.out.println("品牌型号    尺寸    价格   库存数");
		
		int totalCount=0;
		double totalMoney=0;
		//遍历集合
		for(int i=0;i<array.size();i++){
			//get(索引)获取出集合中的元素，存储的是Goods类，获取的是Goods类型
			Goods g=array.get(i);
			
			System.out.println(g.brand+" "+g.size+" "+g.price+" "+g.count);
			totalCount=totalCount+g.count;
			totalMoney=totalMoney+g.count*g.price;
		}
		System.out.println("总库存数:"+totalCount);
		System.out.println("商品库存总金额数:"+totalMoney);
		
	}
	
	
	/*
		定义方法，将商品的信息存储到集合中
		集合是所有方法的共享数据，参数传递
	*/
	
	public static void addGoods(ArrayList<Goods> array){
		//创建出商品类型的变量
		Goods g1=new Goods();
		Goods g2=new Goods();
		
		
		g1.size=13.3;
		g1.brand="Macbook";
		g1.price=9999.9;
		g1.count=3;
		
		g2.size=15.6;
		g2.brand="Thinkpad";
		g2.price=7999.9;
		g2.count=1;
		
		array.add(g1);
		array.add(g2);
	}
}
~~~

~~~java
/*
	定义,描述商品的类
	商品4个属性
		商品名字 	大小	价格	库存
		String		double 	double	int
	定义类,类名Goods
*/

public class Goods{
	//定义商品的名字
	String brand;
	//大小属性
	double size;
	//价格属性
	double price;
	//库存属性
	int count;
}
~~~

#### 6.1奇数求和练习

~~~java
/*
	要求:
     计算1-100之间的所有的奇数和
	 1+3+5+7...+99
	 
	 有1个数据,从0变到100  循环 int =0  <= 100  ++
	 从0-100,范围内,找到奇数  数%2==1 奇数
	 所有的奇数求和计算
	 需要变量,保存奇数的求和
	 
	 实现步骤:
	   1. 程序可以使用到的数据,预先定义好变量
	     需要奇数和
	   2. 利用循环,让变量从0变化到100
	   3. 判断变量的变化情况是不是奇数
	   4. 如果是奇数,和预先定义好的变量,求和
*/
public class LoopTest{
	public static void main(String args[]){
		//定义变量，保存求和
		int sum=0;
		//for循环，循环中的变量，0-100
		for(int i=0;i<=100;i++){
			if(i%2==1){
				//对奇数进行求和
				sum+=i;			
			}
		}
		System.out.println(sum);
	}
}
~~~

#### 7.1循环练习

##### 7.1.1水仙花练习

~~~java

/*
   要求: 计算出水仙花数
     三位数 100-999  个位数的立方+十位数的立方+百位数的立方 = 自己本身
	 153 = 1*1*1 + 5*5*5 + 3*3*3
	 已知三位数  123  获取出每个数位 利用 除法,取模运算
	 
	实现步骤:
	 1. 定义变量才存储 三个数位上的整数
	 2. 利用循环,循环中的变量,从100变化到999
	 3. 循环中得到三位数,利用算法,拆解成三个单独数位
	 4. 将三个数位立方的求和计算, 计算后的求和,和他自己进行比较判断
	    想同,就是水仙花
*/
public class LoopTest_1{
	public static void main(String args[]){
		//定义三个变量
		int bai=0;
		int shi=0;
		int ge=0;
		
		//循环，从100-999
		for(int i=100;i<1000;i++){
			//对i进行计算，获取出三个数位
			//获取百位
			bai=i/100;
			//获取十位
			shi=i/10%10;
			//获取个位
			ge=i%10;
			if(bai*bai*bai+shi*shi*shi+ge*ge*ge==i){
				System.out.println(i);
			}
		}
	}
}
~~~

##### 7.1.2ASCII表

数字0-9对应ASCII编码十进制为48-57, 

字母A-Z对应ASCII编码十进制为65-90，

字母a-z对应ASCII编码十进制为97-122。

~~~java
/*
    ASCII编码表演示
	字符Java 数据类型,char
	整数Java 数据类型,int
	
	int 类型和 char 数据类型转换
	char  两个字节, int 四个字节
	
	char转成int类型的时候,类型自动提示,char数据类型,会查询编码表,得到整数
	int转成char类型的时候,强制转换,会查询编码表
	
	char存储汉字,查询Unicode编码表
	
	char可以和int计算,提示为int类型, 内存中两个字节
	char取值范围是0-65535, 无符号的数据类型
*/
public class ASCIIDemo{
	public static void main(String[] args){
		char c = 'a';
		int i = c + 1;
		System.out.println(i);
		
		int j = 90;
		char h = (char)j;
		System.out.println(h);
		
		System.out.println( (char)6 );
		
		char k = '你';
		System.out.println(k);
		
		
	}
}
~~~

##### 7.1.3输出所有英文字符

~~~java

/*
	利用循环，输出字母包含大写小写，52个
	输出A-Z a-zz
	利用编码表实现，字母和数字的对应关系
	A-Z 65-90
	a-z 97-122
	
	
*/




public class LoopTest_2{
	public static void main(String args[]){
		//定义变量，保存2个字母
		char xiaoXie='a';
		char daXie='A';
		
		
		for(int i=0;i<26;i++){
			//输出保存字母的变量
			System.out.println(xiaoXie+" "+daXie);
			xiaoXie++;
			daXie++;
		}
	}
}
~~~

##### 7.1.4九九乘法表

~~~java
/*
    利用嵌套for循环,实现99乘法表示
	实现步骤:
	  1. 定义外循环控制行数
	  2. 内循环控制个数,个数,每次都在递增
	  3. 循环中输出,乘法表的格式   1*3=3
*/
public class LoopTest_3{
	public static void main(String[] args){
		print99(6);
	}
	
	public static void print99(int n){
		//定义外循环,循环9次
		for(int i = 1; i <= n; i++){
			//定义内循环,每次递增,循环条件, <=i
			for(int j = 1; j <= i ;j++){
				//按照标准格式,输出打印
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
	}
}
~~~

#### 7.2数组练习

##### 7.2.1数组遍历

~~~java
/*
	定义方法，实现数组的遍历
	遍历中，输出结果[11,33.565,66,78,89]
	int[] arr={3,4,45,7};
	结果包含字符串，[].
	实现步骤:
		1.定义方法实现数组的遍历
		2.先打印[中括号
		3.遍历数组
			输出数组的元素和逗号
			判断是否遍历到了数组的最后一个元素，如果是最后一个元素，不答应逗号
*/
public class ArrayMethodTest{
	public static void main(String args[]){
		int [] arr={11,22,33,44,55};
		printArray(arr);
		
	}
	
	/*
		定义方法，实现功能
		返回值:void
		方法参数：数组
	*/
	public static void printArray(int[] arr){
		//输出半边括号，不要换行
		System.out.print("[");
		//数组遍历
		for(int i=0;i<arr.length;i++){
			//判断数组是不是最后一个元素
			if(i==arr.length-1){
				System.out.print(arr[i]+"]");
				
			}else{
				System.out.print(arr[i]+",");
			}
			
		}
		
	}
}

~~~



##### 7.2.2数组的逆序

~~~java
/*
	数组的逆序
	数组中的元素，进行位置上的交换
	逆序 不等于 逆序输出
	就是数组中最远的两个索引，进行位置交换，实现数组的逆序
	使用的是数组的指针思想，就是变量，
	反转 reverse
	
*/

public class ArrayMethodTest_1{
	public static void main(String args[]){
		int[] arr={1,2,3,4};
		reverse(arr);
		printArray(arr);
	
	}


	/*
		定义方法，实现数组的逆序
		返回值：没有返回值
		参数：数组
		
	*/
	
	public static void reverse(int[] arr){
		//循环遍历
		for(int min=0,max=arr.length-1;min<max;min++,max--){
			//对数组中的元素进行位置交换
			//min索引和max索引的元素交换
			//定义变量，作为临时变量
			int temp=arr[min];
			arr[min]=arr[max];
			arr[max]=temp;
			
		}
		
	}
	
	/*
		定义方法，实现功能
		返回值:void
		方法参数：数组
	*/
	public static void printArray(int[] arr){
		//输出半边括号，不要换行
		System.out.print("[");
		//数组遍历
		for(int i=0;i<arr.length;i++){
			//判断数组是不是最后一个元素
			if(i==arr.length-1){
				System.out.print(arr[i]+"]");
				
			}else{
				System.out.print(arr[i]+",");
			}
			
		}
		
	}
}
~~~

##### 7.2.3数组的选择排序

~~~java
/*
	数组的排序:一般都是升序排序，元素，小到大的排序
	
	
	两种排序方式
		选择排序：数组的每个元素都进行比较
		冒泡排序：数组中相邻元素进行比较
		规则:比较大小，位置交换
*/





public class ArrayMethodTest_2{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//调用选择排序方法
		selectSort(arr);
		//调用打印方法
		printArray(arr);
	
	}
	
	
	/*
		定义方法，实现数组的选择排序
		返回值：没有
		参数:数组的排序
		实现步骤:
			1.嵌套循环实现排序
				外循环，控制的是一共比较多少次
				内循环，控制的是每次比较了多少个元素
			2.判断元素的大小值
			  小值，存储到小的索引
				
	*/
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				//数组的元素进行判断
				if(arr[i]>arr[j]){
					//数组换位
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
				}
			}
		}
	}
	
	
	
	
	/*
		定义方法，实现功能
		返回值:void
		方法参数：数组
	*/
	public static void printArray(int[] arr){
		//输出半边括号，不要换行
		System.out.print("[");
		//数组遍历
		for(int i=0;i<arr.length;i++){
			//判断数组是不是最后一个元素
			if(i==arr.length-1){
				System.out.print(arr[i]+"]");
				
			}else{
				System.out.print(arr[i]+",");
			}
			
		}
		
	}
}
~~~

##### 7.2.4数组的冒泡排序

~~~java
/*
  数组的排序: 一般都是升序排列,元素,小到大的排列
  
  两种排序的方式
     选择排序: 数组的每个元素都进行比较
	 冒泡排序: 数组中相邻元素进行比较
	 规则: 比较大小,位置交换
*/






public class ArrayMethodTest_3{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//调用冒泡排序方法
		bubbleSort(arr);
		//调用打印方法
		printArray(arr);
	
	}
	
	
	/*
		定义方法，实现数组的冒泡排序
		返回值：没有
		参数:数组的排序
		
				
	*/
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			//每次内循环的比较，从0开始
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
				}
			}
		}	
	
	}
	
	
	
	
	/*
		定义方法，实现功能
		返回值:void
		方法参数：数组
	*/
	public static void printArray(int[] arr){
		//输出半边括号，不要换行
		System.out.print("[");
		//数组遍历
		for(int i=0;i<arr.length;i++){
			//判断数组是不是最后一个元素
			if(i==arr.length-1){
				System.out.print(arr[i]+"]");
				
			}else{
				System.out.print(arr[i]+",");
			}
			
		}
		
	}
}
~~~

##### 7.2.5数组的二分查找法

![1557742206691](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557742206691.png)

~~~java
/*
	数组的折半查找(二分查找)
*/

import java.util.Scanner;




public class ArrayMethodTest_4{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//调用冒泡排序方法
		bubbleSort(arr);
		//调用打印方法
		printArray(arr);
		System.out.println();
		System.out.println("请输入您要查找的整数，如果在数组中有的话，系统会返回数组下标");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int index=binarySearch(arr,n);
		System.out.println(index);
	
	}
	
	/*
		定义方法，实现，折半查找
		返回值：索引
		参数：数组，被找的元素
		实现步骤：
			1.需要的变量定义
				三个指针
			2.进行循环折半
				可以折半的条件 min<=max
			3.让被找的元素，和中间索引元素进行比较
				元素大于中间索引  min=mid+1
				元素小于中间索引  max=mid-1
				元素等于中间索引  找到了，结束了，返回中间索引
			4.循环结束，无法折半
				元素没有找到，返回-1
		
	*/
	public static int binarySearch(int[] arr,int key){
		//定义三个指针变量
		int min=0;
		int max=arr.length-1;
		int mid=0;
		//循环折半，条件 min<=max
		while(min<=max){
			//公式，计算中间索引
			mid=(min+max)/2;
			//让被找元素和中间元素进行比较
			if(key>arr[mid]){
				min=mid+1;
			}else if(key<arr[mid]){
				max=mid-1;
			}else if(key==arr[mid]){
				//找到元素，返回mid索引
				return mid;
			}
			
		}
		return -1;
	}
	
	/*
		定义方法，实现数组的冒泡排序
		返回值：没有
		参数:数组的排序
		
				
	*/
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			//每次内循环的比较，从0开始
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
				}
			}
		}	
	
	}
	
	
	
	
	/*
		定义方法，实现功能
		返回值:void
		方法参数：数组
	*/
	public static void printArray(int[] arr){
		//输出半边括号，不要换行
		System.out.print("[");
		//数组遍历
		for(int i=0;i<arr.length;i++){
			//判断数组是不是最后一个元素
			if(i==arr.length-1){
				System.out.print(arr[i]+"]");
				
			}else{
				System.out.print(arr[i]+",");
			}
			
		}
		
	}
}
~~~

#### 8.1Eclipse的安装与使用

- 下载 <http://www.eclipse.org>

- 安装 (只需要解压后就能使用)

- 卸载（只需要将文件夹删除就可以了）

-  注意： 开发软件的安装目录中，尽量不要出现空格与中文
-  注意:下载的eclipse

##### 8.1.1Eclipse的使用

点击开启，选择工作空间，用来存放将来编写的java源文件

##### 8.1.2Eclipse的快捷键

~~~java
/*
 * 快捷键
 * 	Alt +/  自动补全
 * 		写程序是的时候，只写出一部分
 *  	syso
 *  	类名Scanner
 * 		起名字
 * 
 *  Ctrl + Shift + F  代码格式化
 *  
 *  Ctrl +  /单行注释
 * 
 * Alt + Shift +J 添加注释文档
   
 * Ctrl + Shift + \多行注释
 * Ctrl + Shift + \取消多行注释
 * 
 * Ctrl + Shift + o 导入包快捷键
 * 
 * Alt +上下箭头 移动当前行代码
 * 
 * Ctrl +Alt + 上下箭头  赋值当前代码行  支持大面积代码
 * 
 * Ctrl +D 删除当前行
 * 
 * Ctrl +1 意见提示功能
 *
 * Ctrl +2 +L 接受返回值
 * 
 * Ctrl +2 +R 重命名
 *
 * */
public class Demo {
	public static void main(String args[]) {
		System.out.println("hello world!");
	}
}
~~~

##### 8.1.3断点调试

- 断点： 就是一个标记

-  如何设置断点

  ​	代码区域左边的空白位置 双击即可

- 在哪里加

  ​	想看哪个语句的执行结果就在该语句前面加

- 怎么运行断点的程序

  ​	代码区域右键 -- Debug as -- Java Application

-  显示一个页面，提示是否进入调试页面？ 是否记住当前操作？是(Yes)是（勾选复选框）

- ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml5612\wps1.jpg) 

-  弹出了断点页面

- ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml5612\wps2.jpg) 

-  点哪里

   	点击 工具栏中的Step Over (执行下一行)

- 快捷键F6 看到每一步程序的执行过程

- 看哪里

  ​	看代码区域： 对照看程序执行步骤

-  看Debug区域： 对照看程序执行步骤

-  看varable区域： 观察变量的创建、复制、销毁

- 如何消除断点

  ​	把设置断点的方式再执行一遍

- 切换到Debug视图，选择 Breakpoints -- Remove All Breakpoints 就是2个XX的图标

##### 8.1.4项目的导入

- 在左侧的PackageExplorer区域右键，选择 import
- 选择 General -- Existing Projects into Workspace
- 选择后，点击 next
- 在新的窗口中，点击 Browse 找到需要导入的项目（注意，找到项目的名字位置就可以了），选中要导入的项目，点击Copy复选框，点击Finish完成。
- 注意事项
- Eclipse中已经存在的同名项目不能再次导入

#### 8.2超市管理系统

~~~java
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 超市管理系统主实现：
 * 	1.商品数据的初始化
 *  2.用户的菜单选择
 *  3.更具选择执行不同的功能
 *  	3.1Read  查看商品
 *  	3.2Creat  添加商品
 *  	3.3Delete	删除商品	
 *  	3.4Update	修改商品
 * 
 * */
public class Shopp {
	public static void main(String[] args) {
		// 创建ArrayList集合
		ArrayList<FruitItem> array = new ArrayList<FruitItem>();
		// 调用商品初始化方法，传递集合
		init(array);
		// System.out.println(array);

		while (true) {
			// 调用菜单方法
			mainMenu();
			// 调用用户选择序号方法
			int choose = chooseFunction();
			switch (choose) {
			case 1:
				// 调用货物清单
				showFruitList(array);
				break;
			case 2:
				addFruit(array);
				// 添加货物
			case 3:
				deleteFruit(array);
				// 删除货物
			case 4:
				updataFruit(array);
				// 修改货物
			default:
				System.out.println("输入的序号没有");
				break;
			}
		}
	}

	/*
	 * 定义方法，商品修改功能 返回值：无 参数:集合
	 * 
	 * 
	 * 提示用户选择的是修改功能 
	 * 提示用户输入需要修改的商品编号
	 *  遍历集合，获取每个FruitItem变量 变量调用ID属性，
	 *  属性和用户输入的编号比较
	 *   如果相同：
	 * 修改FruitItem中的属性值 键盘输入
	 * 
	 * 
	 * 
	 */
	public static void updataFruit(ArrayList<FruitItem> array) {
		System.out.println("选择的是商品修改功能");
		System.out.println("请输入商品的编号");
		Scanner sc = new Scanner(System.in);
		int ID=sc.nextInt();
		//遍历集合
		for(int i=0;i<array.size();i++) {
			FruitItem item=array.get(i);
			//获取FruitItem的ID,和用户输入的ID比较
			if(ID==item.ID) {
				System.out.println("请输入新的商品编号");
				item.ID=sc.nextInt();
				System.out.println("请输入新的商品名字");
				item.name=sc.next();
				System.out.println("请输入新的商品价格");
				item.price=sc.nextDouble();
				return;
				
			}	
		}
		System.out.println("输入的商品编号不存在");
	}

	/*
	 * 定义方法，是新啊商品添加功能 提示用户选择的是添加商品功能
	 * 
	 * 出啊关键FruitItem变量，变量调用属性 将输入的每个商品属性进行赋值
	 * 
	 * 
	 */
	public static void addFruit(ArrayList<FruitItem> array) {
		System.out.println("选择的是添加商品功能");
		// 创建Scanner变量
		Scanner sc = new Scanner(System.in);
		// 输入商品的编号
		System.out.println("请输入商品的编号");
		int ID = sc.nextInt();
		// 输出商品的名字
		System.out.println("请输入商品的名字");
		String name = sc.next();
		// 输入商品的单价
		System.out.println("请输入商品的单价");
		double price = sc.nextDouble();

		// 创建FruitItem类型的变量
		FruitItem item = new FruitItem();
		// item属性
		item.ID = ID;
		item.name = name;
		item.price = price;
		array.add(item);
	}

	/*
	 * 定义方法，事项商品的删除功能 返回值无
	 * 
	 * 
	 * 删除依靠的是商品的编号 提示用户选择的是删除功能 键盘输入商品的编号 遍历集合，获取集合每个FruitItem变量 变量调用属性
	 * ID,和用户输入的编号对比，相同就删除
	 * 
	 * 
	 */
	public static void deleteFruit(ArrayList<FruitItem> array) {
		System.out.println("选择的是删除功能");
		System.out.println("请输入商品的编号");
		Scanner sc = new Scanner(System.in);

		int ID = sc.nextInt();
		// 遍历集合
		for (int i = 0; i < array.size(); i++) {
			FruitItem item = array.get(i);
			// 变量调用id属性，和用户输入的编号比较
			if (item.ID == ID) {
				// 移除集合中的元素
				// 集合的方法remove实现
				array.remove(i);
				System.out.println("删除成功");
				return;
			}
		}
		System.out.println("您输入的商品不存在");
	}

	/*
	 * 定义方法，显示货物清单功能 返回值 无 参数 集合 遍历集合，获取集合中每个FruitItem变量，变量调用属性
	 * 
	 * 
	 */
	public static void showFruitList(ArrayList<FruitItem> array) {
		System.out.println();
		System.out.println("================商品库存清单================");
		System.out.println("商品编号         商品名称                商品单价");
		// 遍历集合
		for (int i = 0; i < array.size(); i++) {
			// 集合get方法，获取出每个FruitItem变量
			FruitItem item = array.get(i);
			// 调用属性
			System.out.println(item.ID + "      " + item.name + "           " + item.price);
		}
	}

	/*
	 * 定义方法，接受用户键盘输入 返回编号
	 * 
	 * 
	 */
	public static int chooseFunction() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	/*
	 * 定义方法，显示主菜单 提供给用户哪些先选择 返回值：无 参数值：无
	 * 
	 * 
	 */
	public static void mainMenu() {
		System.out.println();
		System.out.println("============欢迎光临ItCast超市============");
		System.out.println("1: 货物 清单   2: 添加货物   3: 删除货物   4: 修改货物  5: 退出");
		System.out.println("请您输入要操作的功能序号");
	}

	/*
	 * 定义方法，实现数据初始化 先将一部分数据，存储到集合中 返回值:无 参数:集合 方法名:init
	 * 
	 * 
	 */
	public static void init(ArrayList<FruitItem> array) {
		// 创建出多个FruitItem类型，并且赋值
		FruitItem f1 = new FruitItem();
		f1.ID = 9527;
		f1.name = "少林寺酥饼";
		f1.price = 12.7;

		FruitItem f2 = new FruitItem();
		f2.ID = 9008;
		f2.name = "尚康杂粮牡丹饼";
		f2.price = 14.7;

		FruitItem f3 = new FruitItem();
		f3.ID = 9520;
		f3.name = "新疆哈密瓜";
		f3.price = 122.7;
		// 创建的3个FruitInem对象，添加到集合中
		array.add(f1);
		array.add(f2);
		array.add(f3);
	}
}
~~~

~~~java
/*
 * 自定义类，描述商品信息
 *  商品属性
 *  编号 int
 *  品名 String
 *  价格 double
 *  数量  int
 *  总价 double

 * 
 * */
public class FruitItem {
   int ID;
   String name;
   double price;
   int number;
   double money;
   
}

~~~

#### 9.1面向对象编程OOP

面向过程：是一个执行者

面向对象:是一个指挥者，遇到问题找人做

比如：

将大象放入冰箱中

面向过程:开门  放大象 关门

面向对象

1。创建类

先创建一个类描述大象

  再 创建一个类描述冰箱

  冰箱类中写冰箱属性和方法

开门，储存，关门

2.使用对象

​    创建大象对象

​    创建冰箱对象

​    调用冰箱的方法

  	xxx.开门 xxx.储存(大象)  xxx.关门

#### 9.2测试汽车类

~~~java
package cn.itcast.demo01;

/**
 * 类的方式,描述显示中的事物 小汽车
 * 
 * 		小汽车  属性和功能
 * 			属性：颜色  轮胎个数  变量定义
 * 			功能：跑  方法
 *		属性和方法，都属于类的成员
 *
 */
public class Car {
	//定义Car类中的属性
		
		//定义颜色属性
		String colour;
		//定义轮胎个数
		int count;
		
	//定义Car类中的方法
		public void run() {
			System.out.println("小汽车车在跑..."+colour+"..."+count);
			
		}
		
}
~~~

~~~java
package cn.itcast.demo01;

/**
 * 测试，自定义的类Car
 * 创建出Car类的变量
 * 变量，调用属性，成员变量
 * 变量，调用方法
 *
 */
public class CarTest {

	public static void main(String[] args) {
		//创建出Car类的对象
		Car c=new Car();
		//对象.调用类中的属性和方法
		c.colour="无色";
		c.count=5;
		c.run();
	}

}
~~~

#### 9.3对象的内存图

![1557819163497](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557819163497.png)

#### 9.4类和对象的区别

类是对某一类事物的抽象描述

对象用于表示现实中该类事物的个体

#### 9.5局部变量和成员变量的区别

1. 定义位置上的区别

   成员变量：写在类中的，方法外的变量.

   局部变量：写在方法中，语句中的变量

  2.作用域不同

​		成员变量，作用范围是整个类

​		局部变量，作用范围是方法内，语句内

3.默认值不同

​		成员变量，有自己的默认值

​		局部变量，没有默认值，不赋值不能用

#### 9.6private关键字

出现安全问题:age问题，可以会出现赋值为负数的情况

负数不会导致程序问题，但违反了生活中的真实情况

为了提高安全问题：让外面的类，不允许直接调用我的成员变量

private 私有 属于成员变量修饰符，不能修饰局部变量

被private修饰的成员，只能在自己的本类中被使用



对私有变量，提供公共的访问方式：方法

定义方法对age进行赋值，方法名字，必须set开头

原理：可以在方法里对变量参数进行范围限制

#### 9.7私有化Person带get和set方法

~~~java
package cn.itcast.demo05;
/*
 * 类描述人：
 *  	属性：姓名和年龄
 *  	方法：说话
 *  
 *  
 *  私有化所有的属性(成员变量)，必须写对应的get/set方法
 *  凡是自定义的类，自定义的成员变量，应该私有化，提供get/set
 *  
 */
public class Person {
	private String name;
	private int age;
	
	//set方法，变量name,age赋值
	public void setAge(int a) {
		age=a;
	}
	public void setName(String n) {
		name=n;
	}
	
	//get方法，变量name,age获取值
	public int getAge() {
		return age;
		
	}
	public String getName() {
		return name;
		
	}
	
	public void speak() {
		System.out.println("人在说话"+name+"..."+age);
	}
}
~~~

~~~java
package cn.itcast.demo05;

public class PersonTest {

	public static void main(String[] args) {
		Person p =new Person();
		//调用set方法，对成员变量赋值
		p.setAge(18);
		p.setName("旺财");
		p.speak();
		
		//调用get方法，获取成员变量的值
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
~~~

#### 9.8this关键字和内存图

用来区分成员变量和局部变量的同名问题

不用this，采用的是就近原则，采用局部变量

this.成员变量  this 表示的是本类的对象的地址

内存图

![1557837101557](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1557837101557.png)

#### 9.9this的年龄比较

~~~java
package cn.itcast.demo06;

public class Person {
	private int age;
	
	
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	
	/*
	 * 定义方法:比较是否同龄人，是就返回true，不是就返回false
	 * 谁和谁比，我自己和别人比
	 * 方法的返回值  true  false
	 * 方法的参数：别人
	 */
	public boolean compare(Person p) {
		//自己和别人比年龄，自己是this.p
		return this.age==p.age;
	}
}
~~~

~~~java
package cn.itcast.demo06;

public class PersonTest {
	public static void main(String[] args) {
		//测试Person类中的比较功能
		//创建出两个Person对象
		Person p1=new Person();
		Person p2=new Person();
		
		p1.setAge(15);
		p2.setAge(16);
		
		//p1对象调用自己的方法compare出传递p2对象
		boolean b=p1.compare(p2);
		System.out.println(b);
	}
}
~~~

#### 9.10随机点名器重构

~~~java
package cn.itcast.demo07;
/*
 * 学生类:
 * 	属性:姓名，年龄
 */
public class Student {
		private String name;
		private int age;
		
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}

~~~

~~~java
package cn.itcast.demo07;

import java.util.ArrayList;
import java.util.Random;

/*
 * 随机点名器案例
 * 1.建立集合，将Student对象存储到集合中
 * 2.总览所有学生的信息
 * 	将存储到集合中的Student对象遍历出来
 * 3.随机学生
 * 	随机数，作为索引，到集合中区查找找匀速
 */
public class CallName {

	public static void main(String[] args) {
		ArrayList<Student> array=new ArrayList<Student>();
		addStudent(array);
		printStudent(array);
		randomStudent(array);
		
	}
	
	
	/*
	 * 定义方法，总览学生信息
	 * 遍历集合
	 */
	public static void printStudent(ArrayList<Student> array) {
		for(int i=0;i<array.size();i++) {
			Student s=array.get(i);
			System.out.println(s.getName()+"  "+s.getAge());
		}
	}
	
	
	/*
	 * 随机数生成学生信息
	 */
	
	public static void randomStudent(ArrayList<Student> array) {
		Random ra=new Random();
		int index=ra.nextInt(array.size());
		Student s=array.get(index);
		System.out.println(s.getName());
	}
	
	/*
	 * 定义方法，存储Student对象，到集合中
	 */
	public static void addStudent(ArrayList<Student> array) {
		Student s1=new Student();
		s1.setName("李一");
		s1.setAge(11);
		
		Student s2=new Student();
		s2.setName("李二");
		s2.setAge(12);
		
		Student s3=new Student();
		s3.setName("李三");
		s3.setAge(13);
		
		Student s4=new Student();
		s4.setName("李四");
		s4.setAge(14);
		
		Student s5=new Student();
		s5.setName("李五");
		s5.setAge(15);
		
		array.add(s1	array.add(s2);
		array.add(s3);
		array.add(s4);
		array.add(s5);
	}
}
~~~

