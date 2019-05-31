#### 10.1继承

继承是使用已存在的类的定义作为基础建立新类的技术，新类的定义可以增加新的数据或新的功能，也可以用父类的功能，但不能选择性地继承父类。通过使用继承我们能够非常方便地复用以前的代码。

 extends

**关于继承如下 3 点请记住：**

 

1. 子类拥有父类对象所有的属性和方法（包括私有属性和私有方法），但是父类中的私有属性和方法子类是无法访问，**只是拥有**。
2. 子类可以拥有自己属性和方法，即子类可以对父类进行扩展。
3. 子类可以用自己的方式实现父类的方法。（以后介绍）。

一个类只能由一个父类，不能有多个父类

只允许单继承，不允许多继承，多继承有安全问题

#### 10.2重写 Override

子类中，出现了和父类一模一样的方法的时候，子类重写父类的方法，覆盖

重写：方法的名字相同，参数列表也相同

重载：方法的名字相同，参数列表不同

子类重写父类方法时，子类的权限要大于等于父类的权限

public   >protected  >defort> pravite

#### 10.3抽象类

共性抽取 abstract

1. 抽象类和抽象方法都需要被abstract修饰。抽象的方法没有主体，必须存放在抽象的类中
2. 抽象不能直接创建对象，因为没有方法主体
3. 只有重写了父类中**所有的**抽象方法后，其子类才可以创建对象，否则子类还是一个抽象类

~~~java
package cn.itcast.demo06;
/*
 * 定义类开发工程师类
 * 		EE开发工程师
 * 		Android开发工程师
 * 
 * 		根据共性进行抽取，然后形成一个父类Develop
 * 		定义方法，工作:怎么工作，具体干什么
 * 
 * 
 * 		抽象类，不能实例化对象，不能new
 * 		抽象类的使用方式:定义类继承抽象类，将抽象类方法进行重写，创建子类的对象
 */
public abstract class Develop {
	//定义方法工作方法，但是怎么工作，说不清楚
	//不说,方法是没有主题的方法，必须使用关键字abstract修饰
	//抽象的方法，必须存在抽象的类中，类也必须用abstract修饰
	public abstract void work();
}
~~~

抽象类的设计思想：

抽象类的作用:继承的体系，抽象类，强制子类重写所有的抽象方法

#### 10.4综合案例--员工类系列定义

某IT公司有多名员工，按照员工负责的工作不同，进行了部门的划分（研发部员工、维护部员工）。研发部根据所需研发的内容不同，又分为JavaEE工程师、Android工程师；维护部根据所需维护的内容不同，又分为网络维护工程师、硬件维护工程师。

公司的每名员工都有他们自己的员工编号、姓名，并要做它们所负责的工作。

工作内容：

JavaEE工程师：员工号为xxx的 xxx员工，正在研发淘宝网站

Android工程师：员工号为xxx的 xxx员工，正在研发淘宝手机客户端软件

 网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通

硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机

请根据描述，完成员工体系中所有类的定义，并指定类之间的继承关系。进行XX工程师类的对象创建，完成工作方法的调用。

~~~java
package cn.itcast.demo08;
/*
 * 定义员工类
 * 		内容，都是所有子类的共性抽取
 * 			属性:姓名，工号
 * 			方法：工作
 */
public abstract class Employee {
		//定义成员变量姓名
	private String name;
	//定义成员变量工号
	private String Id;
	
	//定义工作方法
	public abstract void work();
	
	public void setName(String name) {
		this.name=name;
	}
	public void setId(String Id) {
		this.Id=Id;
	}
	public String getName() {
		return this.name;
	}
	public String getId() {
		return this.Id;
	}
	
}
~~~

~~~java
package cn.itcast.demo08;
/*
 * 定义研发员工类
 * 	属于员工
 */
public abstract class Develop extends Employee{

}
~~~

~~~java
package cn.itcast.demo08;
/*
 * 描述JavaEE开发工程师类
 * 		工号，姓名，工作方法
 * 其他员工，也具备这些共性，抽取到父类中，自己就不需要定义了
 * 是研发部员工的一种，继承研发部类
 */

public class JavaEE extends Develop {
	//重写父类的父类的抽象方法
	public void work() {
		System.out.println("JavaEE工程师在工作");
	}
}
~~~

~~~java
package cn.itcast.demo08;

public class Test {
	public static void main(String[] args) {
		JavaEE ee=new JavaEE();
		
		ee.setName("张三");
		ee.setId("研发部01");
		System.out.println(ee.getName()+".."+ee.getId());
		ee.work();
	}
}

~~~

#### 11.1接口概念

接口是功能的集合，接口只描述所应该具备的方法，并没有具体实现，具体的实现由接口的实现类（相当于接口的子类）来完成。这样将功能的定义和实现分离，优化了程序设计

记住:一切事物均有功能，一切事物均有接口

#### 11.2接口的定义

interface关键字

~~~java
package cn.itcast.demo01;
/*
 * 定义接口
 * 	使用关键字interface 接口名字
 * 接口定义:
 * 		成员方法，全抽象
 * 		不能定义带有方法体的方法
 * 
 * 定义抽象方法:固定格式
 * 	public abstract 返回值类型 方法名字(参数列表)
 * 
 * 接口成员变量的定义
 * 	成员变量的定义，具体要求
 * 	要求:必须定义为常量
 * 固定格式:
 * 	public static final 数据类型 变量值=值
 * 
 */
public interface MyInterface {
	//在接口中，定义抽象的方法
	public abstract void function();
	
}
~~~

11.3实现类

~~~java
/*
 * 定义接口
 * 	使用关键字interface 接口名字
 * 接口定义:
 * 		成员方法，全抽象
 * 		不能定义带有方法体的方法
 * 
 * 定义抽象方法:固定格式
 * 	public abstract 返回值类型 方法名字(参数列表)
 * 
 * 接口成员变量的定义
 * 	成员变量的定义，具体要求
 * 	要求:必须定义位常量
 * 固定格式:
 * 	public static final 数据类型 变量值=值
 * 
 */
public interface MyInterface {
	//在接口中，定义抽象的方法
	public abstract void function();
	
}
~~~

~~~java
package cn.itcast.demo01;
/*
 * 定义类，实现接口，重写接口中的抽象方法
 * 创建实现类的对象
 * 
 * 类实现接口，可以理解为继承
 * 
 * 关键字 implements
 * 
 */
public class MyInterfaceImpl implements MyInterface{
	public void function() {
		System.out.println("实现类，重写接口抽象方法");
	}
}
~~~

~~~java
package cn.itcast.demo01;

public class Test {
	public static void main(String[] args) {
		//创建接口的实现类的对象
		MyInterfaceImpl my =new MyInterfaceImpl();
		my.function();
				
	}
}
~~~

#### 11.3接口中成员变量的特点

接口中成员变量的特点，没有变量，都是常量

固定格式:public static final 数据类型 变量名=值

public 权限

static  可以被类名直接.调用

final   最终，固定住变量的值

注意:public static final 修饰符可以不写

但是不写不代表没有

#### 11.4接口中的成员方法特点：

接口中成员方法的特点：

public abstract 返回值类型 方法名(参数列表)

#### 11.5实现类

实现类需要全部重写抽象类的全部方法，不然不能建立对象

实现类只重写了一部分抽象方法，实现类还是抽象类

#### 11.6接口的多实现

public class C implements A,B{}

一个实现类  对应多个接口

接口多实现没有安全隐患，因为接口中的方法都是抽象的，没有主体

注意：两个接口中的方法名相同，返回值不同会出现报错

解决了单继承的局限性

#### 11.7类继承类的同时实现多接口

public class C extends D implements A,B{

}

#### 11.8接口的多继承

- 类与类之间是继承关系
- 接口与类之间是实现关系
- 接口与接口之间继承关系
- 一个接口可以继承多个接口

#### 11.9抽象类和接口的区别

- 抽象类为部分方法提供实现，避免子类中重复实现这些方法，提高了代码的重用性，接口只能包含抽象方法
- 一个类只能继承一个直接父类（可能是抽象类），却可以实现多个接口
- 抽象类是这个事物中应该具备的内容
- 接口是这个事物中额外的内容

两者选用的关系：

优先选用接口，尽量少用抽象类；

需要定义子类的行为，又要为子类提供共性功能时才选用抽象类

#### 11.10多态

People p=new Student();

多态体现为： 父类引用变量可以指向子类对象

多态的前提 ：必须有子父类关系或类实现接口关系，否则无法完成多态

在使用多态后的父类引用变量调用方法时，**会调用子类重写后的非静态方法****

成员变量：编译的时候，参考父类中有没有这个变量，如果有，编译成功，运行的是父类中的变量，没有编译失败，运行的时候，

成员方法：编译的时候，参考父类中有没有这个方法，如果有，编译成功，没有编译失败，运行的时候，运行的是子类的重写方法



多态调用中，

编译都看=左边的父类，父类有编译成功，父类没有编译失败

运行，静态方法，运行父类中的静态方法

运行，非静态方法，运行子类的重写方法

成员变量，运行编译都是父类

#### 11.11instanceof关键字

运算符  比较运算符  结果真假值

关键字 instanceof,比较引用数据类型

p变量，是Student类型变量，还是Teacher类型变量



引用变量 instanceof 类名

p instanceof Student 判断，p是不是Student类型对象

如果是，返回true

#### 11.12多态中的转型

多态的转型分为向上转型与向下转型两种：

向上转型：当有子类对象赋值给一个父类引用时，便是向上转型，多态本身就是向上转型的过程。

使用格式：

父类类型  变量名 = new 子类类型();

如：Person p = new Student();

向下转型：一个已经向上转型的子类对象可以使用强制类型转换的格式，将父类引用转为子类引用，这个过程是向下转型。如果是直接创建父类对象，是无法向下转型的！

使用格式：

子类类型 变量名 = (子类类型) 父类类型的变量;

如:Student stu = (Student) p;  //变量p 实际上指向Student对象

#### 11.13笔记本电脑案例

定义USB接口（具备开启功能、关闭功能），笔记本要使用USB设备，即笔记本在生产时需要预留可以插入USB设备的USB接口，即就是笔记本具备使用USB设备的功能，但具体是什么USB设备，笔记本并不关心，只要符合USB规格的设备都可以。鼠标和键盘要想能在电脑上使用，那么鼠标和键盘也必须遵守USB规范，不然鼠标和键盘的生产出来无法使用

进行描述笔记本类，实现笔记本使用USB鼠标、USB键盘

- USB接口，包含开启功能、关闭功能
-  笔记本类，包含运行功能、关机功能、使用USB设备功能
- l鼠标类，要符合USB接口
-  键盘类，要符合USB接口

~~~java
package cn.itcast.demo09;
/*
 * 自定义的USB接口类
 * 规范，抽象方法
 * 开，关
 */
public interface USB {
	public abstract void open();
	public abstract void close();
	
}
~~~



~~~java
package cn.itcast.demo09;

public class Keyboard implements USB{
	public void open(){
		System.out.println("开启键盘");
	}
	public void close(){
		System.out.println("关闭键盘");
	}
}

~~~



~~~java
package cn.itcast.demo09;
/*
 * 自定义的鼠标类
 * 满足USB接口规范
 * 实现USB,重写抽象方法
 */
public class Mouse implements USB {
	public void open() {
		System.out.println("开启鼠标");
	}
	public void close() {
		System.out.println("关闭鼠标");
	}
}

~~~

~~~java
package cn.itcast.demo09;
/*
 * 定义笔记本类
 * 功能：开机 关机，使用USB设备
 */
public class Computer {
	public void openComputer() {
			System.out.println("笔记本开机");
	}
	public void closeComputer(){
			System.out.println("笔记本关机");
	}
	
	//使用USB设备，哪个设备
	//方法的参数，就是USB设备
	public void useUSB(USB usb){
		usb.open();
		usb.close();
		
	}
}


~~~

~~~java
package cn.itcast.demo09;

public class Test {
	public static void main(String[] args) {
		//创建笔记本对象，拥有笔记本功能
		Computer com =new Computer();
		com.openComputer();
		
		//调用笔记本使用USB设备的方法
		//参数，是USB接口类型，接口不能建立对象
		//调用方法，传递USB接口的实现类对象
		com.useUSB(new Mouse());
		//使用USB设备，使用键盘
		com.useUSB(new Keyboard());
		
		com.closeComputer();
	}
}
~~~

#### 12.1构造方法

创建对象的时候初始化属性值

构造方法的定义格式

 	权限 方法名（参数列表）{

​    }

​	方法的名字必须和类的名字一致

每个class都必须有构造方法 构造方法不写也有

**一旦写了构造方法，默认的空参构造方法就没有了**

构造方法可以重载，你可以写多个构造方法

#### 12.2this()在构造方法之间的调用

this（参数）,必须写在构造函数的第一行

~~~java
public Person(){
    this("李四","30");
}
public Person(String name,int age){
    this.name=name;
    this.age=age;
}
~~~

#### 12.3super关键字

super（），必须写在构造函数第一行

在子类中可以用super()的方法，调用父类的构造方法

注意：子类空参数构造方法的第一行，有一个隐式的代码 super（）

即默认调用父类的构造方法

注意：

​	1.父类没有写构造函数（系统默认有一个无参构造函数），子类可以不写	构造函数（可以理解为：子类的系统默认构造函数，默认调用了  super();）

​    2.如果父类有无参构造函数，子类可以不写构造函数（同上理解）
​    3.如果父类有有参构造函数，则子类必须在自己的构造函数中显示的调用  父类的构造函数即super(参数名)
​    4.如果父类的构造函数只有一个，且修饰符是private，则不可以被继承。

#### 12.4super应用

练习：描述学生和工人这两个类，将他们的共性name和age抽取出来存放在父类中，并提供相应的get和set方法，同时需要在创建学生和工人对象就必须明确姓名和年龄

~~~java
package cn.itcast.demo02;

public class People {
	String name;
	int age;
	public People(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAge() {
		return this.age;
	}
	public void getAge(int age) {
		this.age=age;
	}
}
~~~

~~~java
package cn.itcast.demo02;

public class Worker extends People{
	public Worker(String name,int age) {
		super(name,age);
	}
}
~~~

~~~java
package cn.itcast.demo02;

public class Student extends People {
	public Student(String name,int age) {
		super(name, age);
		
	}
}
~~~

~~~java
package cn.itcast.demo02;

public class Test {

	public static void main(String[] args) {
		Worker w=new Worker("光头强",30);
		Student s=new Student("李阳",14);
		System.out.println(w.getName());
		System.out.println(w.getAge());
	}

}
~~~

#### 12.5完整员工案例

某IT公司有多名员工，按照员工负责的工作不同，进行了部门的划分（研发部员工、维护部员工）。研发部根据所需研发的内容不同，又分为JavaEE工程师、Android工程师；维护部根据所需维护的内容不同，又分为网络维护工程师、硬件维护工程师。

公司的每名员工都有他们自己的员工编号、姓名，并要做它们所负责的工作。

工作内容

-  JavaEE工程师：员工号为xxx的 xxx员工，正在研发淘宝网站
- Android工程师：员工号为xxx的 xxx员工，正在研发淘宝手机客户端软件
- 网络维护工程师：员工号为xxx的 xxx员工，正在检查网络是否畅通
- 硬件维护工程师：员工号为xxx的 xxx员工，正在修复打印机

请根据描述，完成员工体系中所有类的定义，并指定类之间的继承关系。进行XX工程师类的对象创建，完成工作方法的调用。

~~~java
package cn.itcast.demo03;

public abstract class Employee {
	private String name;
	private String ID;
	public abstract void work();
	
	public Employee(String name,String ID) {
		this.name=name;
		this.ID=ID;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setID(String ID) {
		this.ID=ID;
	}
	public String getID() {
		return this.ID;
	}
}
~~~

~~~java
package cn.itcast.demo03;

public abstract class Developer extends Employee{
	public Developer(String name,String ID) {
		super(name,ID);
	}
}
~~~

~~~java
package cn.itcast.demo03;

public abstract class Maintainer extends Employee {
	public Maintainer(String name,String ID) {
		super(name,ID);
	}
}

~~~

~~~java
package cn.itcast.demo03;

public class JavaEE extends Developer {
	public JavaEE(String name,String ID) {
		super(name,ID);
	}
	public void work() {
		System.out.println(super.getName()+"  "+super.getID()+"  "+"正在开发淘宝");
	}
}
~~~

~~~java
package cn.itcast.demo03;

public class Android extends Developer{
	public Android(String name, String ID) {
		super(name, ID);
		
	}
	
	public void work() {
		System.out.println(super.getName()+"  "+super.getID()+"  "+"正在开发安卓");
	}
}

~~~

~~~java
package cn.itcast.demo03;

public class Test {
	public static void main(String[] args) {
		JavaEE ee=new JavaEE("倪翔宇","开发部001");
		Android an=new Android("刘淑媛","开发部002");
		ee.work();
		an.work();
	}
}
~~~

#### 13.1final关键字

表示最终的

可以用来修饰除了构造方法的其他的东西

- final用来修饰类的时候，该类不能被继承
- final用来修饰方法的时候，该方法不能被重写
- final用来修饰局部变量的时候，该变量不能被修改
- final修饰成员变量，成员变量需要被赋值一次（手动赋值和构造方法赋值）且不能被修改

#### 13.2static关键字

静态的，共享数据

在方法压栈之前，静态数据已经进入共享区域

静态数据生命周期在非静态数据之前

静态数据优先于对象创建

![1558087070921](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558087070921.png)

注意

​	静态方法不能调用非静态数据，只能访问静态数据

#### 13.3定义静态常量

在类中定义静态常量，通常使用public static final 修饰的变量来完成定义

变量名全部大写，多个单词中间用_连接起来

#### 13.4匿名对象

匿名对象是指创建对象时，只有创建对象的语句，没有把对象地址的值赋值给某个变量

#### 13.5内部类

内部类：将类写在其他类的内部，可以写在其他类的成员位置和局部位置

内部类，可以使用外部类成员，包括私有

 外部类如果要调用内部类：

外部类名.内部类名 变量名 = new 外部类名().new 内部类名();

变量名.内部类方法



匿名内部类，简化问题：定义实现类，重写方法，建立实现类对象，合并为一步完成。

#### 13.6包

Java中的包，其实就是我们电脑系统中的文件夹，包里存放的是类文件

导入包，网址反写 cn.itast

#### 13.7访问修饰符

在Java中提供了四种访问权限，使用不同的访问权限时，被修饰的内容会有不同的访问权限，以下表来说明不同权限的访问能力：

|                        | public | protected | default | private |
| ---------------------- | ------ | --------- | ------- | ------- |
| 同一类中               | √      | √         | √       | √       |
| 同一包中(子类与无关类) | √      | √         | √       |         |
| 不同包的子类           | √      | √         |         |         |
| 不同包中的无关类       | √      |           |         |         |

​	归纳一下：在日常开发过程中，编写的类、方法、成员变量的访问

- 要想仅能在本类中访问使用private修饰；
- 要想本包中的类都可以访问不加修饰符即可；
- 要想本包中的类与其他包中的子类可以访问使用protected修饰（只给子类调用，不给子类对象调用！）
- 要想所有包中的所有类都可以访问使用public修饰。
- 注意：如果类用public修饰，则类名必须与文件名相同。一个文件中只能有一个public修饰的类。

#### 13.8代码块

静态代码块，只执行一次

构造代码块，new一次，就执行一次，优于构造方法

构造方法，new一次，就执行一次

~~~{

static{
  System.out.println("我是静态代码块");
}
{
	System.out.println("我是构造代码块");
}
~~~

#### 14.1Eclipse的应用

##### 14.1.1常用的快捷键

Ctrl+T：查看继承关系

Ctrl+鼠标左击：查看源代码

Alt+Shift+s:快速添加get 和set

##### 14.1.2Java中的文档注释和制作

/**回车

#### 14.2酒店案例

某五星级酒店，资金雄厚，要招聘多名员工（经理、厨师、服务员）。入职的员工需要记录个人信息（姓名、工号、经理特有奖金属性）。他们都有自己的工作要做。

本案例要完成如下需求：

-  获取酒店幸运员工；
- 酒店开设VIP服务，酒店的厨师与服务员可以提供VIP服务。（厨师做菜加量、服务员给顾客倒酒）。
-  编写测试类

1. 向酒店中，增加多名员工（其中包含1名经理，1名厨师、2名服务员）；
2.  调用酒店员工的工作功能
3.  调用酒店员工的VIP服务功能

代码见day10 demo1

#### 15.1API的概念

API:Application (应用) Programming(程序) interface(接口)

#### 15.2Object

Object类是Java语言中的根类，即所有类的父类。

#### 15.4equals方法

equals()是一个方法，只能比较引用数据类型。重写前比较的是地址值，重写后比一般是比较对象的属性。

```java
//默认的equals方法
public boolean equals(Object obj){
    return this==obj;
}
```

重写equals方法

```java
public boolean equals(Object obj) {
		//判断当前调用equals方法的对象和传递进来的对象是否是同一个
		if(this == obj){
			return true;
		}
		//判断传递进来的对象是否是Person类型
		if(!(obj instanceof Person)){
			return false;
		}
		//将obj向下转型为Perosn引用，访问其属性
		Person p = (Person)obj;
		return this.age == p.age;
	}
```

#### 15.5toString方法

toString方法返回该对象的字符串表示，

输出语句中，写的是一个对象，默认调用对象的toString方法

其实该字符串内容就是对象的类型+@+内存地址值。

由于toString方法返回的结果是内存地址，而在开发中，经常需要按照对象的属性得到相应的字符串表现形式，因此也需要重写它。

```java
class Person extends Object{
	String name;
	int age ;

	//根据Person类的属性重写toString方法

	public String toString() {

		return name+age;

	}

}
```

#### 15.6String类

 String类特点:

- ​	一切都是对象，字符串事物""也是对象
- ​	类是描述事物，String类，描述字符串对象的类
- ​	所有的""都是String类的对象

String类重写过toString方法

String类重写过equals方法

String类有很多构造方法

```java
String s1 = new String(); //创建String对象，字符串中没有内容
	
byte[] bys = new byte[]{97,98,99,100};
String s2 = new String(bys); // 创建String对象，把数组元素作为字符串的内容
String s3 = new String(bys, 1, 3); //创建String对象，把一部分数组元素作为字符串的内容，参数offset为数组元素的起始索引位置，参数length为要几个元素
	
char[] chs = new char[]{’a’,’b’,’c’,’d’,’e’};
String s4 = new String(chs); //创建String对象，把数组元素作为字符串的内容
String s5 = new String(chs, 0, 3);//创建String对象，把一部分数组元素作为字符串的内容，参数offset为数组元素的起始索引位置，参数count为要几个元素

String s6 = new String(“abc”); //创建String对象，字符串内容为abc
```

String类的方法查找

获取字符串的长度

```java
String str = "abcde";
int len = str.length();
System.out.println("len="+len);
```

获取部分字符串

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml2832\wps1.jpg) 



```java
String str = "abcde";

String s1 = str.substring(1); //返回一个新字符串，内容为指定位置开始到字符串末尾的所有字符

String s2 = str.substring(2, 4);//返回一个新字符串，内容为指定位置开始到指定位置结束所有字符

System.out.println("str="+str);

System.out.println("s1="+s1);

System.out.println("s2="+s2);

```

获取指定位置字符

```java
char ch =str.charAt(i)
```

将字符串转成大写

```java
String big = start.toUpperCase();
```

将字符串转成小写

```java
String small = end.toLowerCase();
```





获取指定字符串中，大写字母、小写字母、数字的个数

```java
public static void method(String str){
	int bigCount = 0; //大写字母的个数
	int smallCount = 0; //小写字母的个数
	int numberCount = 0; //数字的个数
	for (int i=0; i < str.length(); i++) {
         char ch = str.charAt(i); //获取指定位置上的字符
        //65-90
		if (ch>=’A’ && ch<=’Z’) {
			bigCount++;
            //97-122
} else if (ch>=’a’ && ch<=’z’) {
smallCount++;
            //48-57
} else if (ch>=’0’ && ch<=’9’) {
	    numberCount++;
}
}
System.out.println("大写字母个数："+bigCount);
System.out.println("小写字母个数："+smallCount);
System.out.println("数字个数："+numberCount);
}
```

将字符串中，第一个字母转换成大写，其他字母转换成小写，并打印改变后的字符串。

```java
public static String convert(String str){
	//获取第一部分为字符串
	String start = str.substring(0,1);
	//获取第二部分为字符串
	String end = str.substring(1);
	//把第一部分字符串转换成大写字母，把第二部分字符串转换成小写字母
	String big = start.toUpperCase();
	String small = end.toLowerCase();
//把两部分字符串连接在一起，得到一个完整的字符串
	return big+small;
}
```

查询大字符串中，出现指定小字符串的次数。如“hellojava,nihaojava,javazhenbang”中查询出现“java”的次数。

![1558165735847](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558165735847.png)

```java
public static int getCount(String big, String small){
	int count = 0; //出现小串的次数
	int index = -1;//出现小串的位置
	/*
		while的循环条件三步骤：
		步骤一. big.indexOf(small) 获取小串在大串中出现的位置
		步骤二. 把小串出现的位置，赋值给变量index
		步骤三. 判断出现的位置是否为-1， 如果位置等于-1，说明大串中         已经查询不到小串了；如果位置不等于-1，那么，进行循环，完成次		 数累加与修改大串的操作
*/
	while ((index = big.indexOf(small)) != -1 ){
		count++;//出现次数+1
		//更改大串内容
		big = big.substring(index+1);
}
```

#### 15.7字符串缓冲区StringBuffer类

StringBuffer又称为可变字符序列，它是一个类似于 String 的字符串缓冲区，通过某些方法调用可以改变该序列的长度和内容。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml2832\wps2.jpg)

StringBuilder 运行速度快，但是线程不安全

练习：int[] arr = {34,12,89,68};将一个int[]中元素转成字符串  格式 [34,12,89,68]

```java
package cn.itcast.demo2;
/*
 * 练习：int[] arr = {34,12,89,68};将一个int[]中元素转成字符串  格式 [34,12,89,68]
 */
public class StringTest {
	public static void main(String[] args) {
		int[] arr = {34,12,89,68};
		toString(arr);
	}
	public static void toString(int[] arr) {
		StringBuffer buffer=new StringBuffer();
		buffer.append("[");
		for(int i=0;i<arr.length;i++) {
			
			if(i==arr.length-1) {
				buffer.append(arr[i]+"]");
			}else {
				buffer.append(arr[i]+",");
			}
		}

		System.out.println(buffer);
	}
}
```

#### 16.1正则表达式

**正则表达式**（英语：Regular Expression，在代码中常简写为regex）。

正则表达式是一个字符串，使用单个字符串来描述、用来定义匹配规则，匹配一系列符合某个句法规则的字符串。在开发中，正则表达式通常被用来检索、替换那些符合某个规则的文本。

##### 16.1.1语法规则

**字符：x**

含义：代表的是字符x

例如：匹配规则为 **"a"**，那么需要匹配的字符串内容就是 ”a”

 

**字符：****\\**

含义：代表的是反斜线字符'\'

例如：匹配规则为**"\\" ，**那么需要匹配的字符串内容就是 ”\”

 

**字符：****\t**

含义：制表符

例如：匹配规则为**"\t**" ，那么对应的效果就是产生一个制表符的空间

 

**字符：****\n**

含义：换行符

例如：匹配规则为**"\n"**，那么对应的效果就是换行,光标在原有位置的下一行

 

**字符：****\r**

含义：回车符

例如：匹配规则为**"\r"** ，那么对应的效果就是回车后的效果,光标来到下一行行首

 

**字符类：****[abc]**

含义：代表的是字符a、b 或 c

例如：匹配规则为**"[abc]"** ，那么需要匹配的内容就是字符a，或者字符b，或字符c的一个

 

**字符类：****[^abc]**

含义：代表的是除了 a、b 或 c以外的任何字符

例如：匹配规则为**"[^abc]"**，那么需要匹配的内容就是不是字符a，或者不是字符b，或不是字符c的任意一个字符

 

**字符类：****[a-zA-Z]**

含义：代表的是a 到 z 或 A 到 Z，两头的字母包括在内

例如：匹配规则为**"[a-zA-Z]"**，那么需要匹配的是一个大写或者小写字母

 

**字符类：****[0-9]**

含义：代表的是 0到9数字，两头的数字包括在内

例如：匹配规则为**"[0-9]"**，那么需要匹配的是一个数字

 

**字符类：****[a-zA-Z_0-9]**

含义：代表的字母或者数字或者下划线(即单词字符)

例如：匹配规则为**" [a-zA-Z_0-9] "**，那么需要匹配的是一个字母或者是一个数字或一个下滑线

 

**预定义字符类：****.**

含义：代表的是任何字符

例如：匹配规则为**" . "**，那么需要匹配的是一个任意字符。如果，就想使用 . 的话，使用匹配规则"\\."来实现

 

**预定义字符类：****\d**

含义：代表的是 0到9数字，两头的数字包括在内，相当于[0-9]

例如：匹配规则为**"\d "**，那么需要匹配的是一个数字

 

**预定义字符类：****\****w**

含义：代表的字母或者数字或者下划线(即单词字符)，相当于**[a-zA-Z_0-9]**

例如：匹配规则为**"\w "**，，那么需要匹配的是一个字母或者是一个数字或一个下滑线

 

**边界匹配器：****^**

含义：代表的是行的开头

例如：匹配规则为**^[abc][0-9]$** ，那么需要匹配的内容从[abc]这个位置开始, 相当于左双引号

 

**边界匹配器：****$**

含义：代表的是行的结尾

例如：匹配规则为**^[abc][0-9]$** ，那么需要匹配的内容以[0-9]这个结束, 相当于右双引号

 

**边界匹配器：****\b**

含义：代表的是单词边界

例如：匹配规则为**"\b[abc]\b"** ，那么代表的是字母a或b或c的左右两边需要的是非单词字符(**[a-zA-Z_0-9]**)

 

**数量词：****X?**

含义：代表的是X出现一次或一次也没有

例如：匹配规则为**"a?"**，那么需要匹配的内容是一个字符a，或者一个a都没有

 

**数量词：****X\***

含义：代表的是X出现零次或多次

例如：匹配规则为**"a\*"** ，那么需要匹配的内容是多个字符a，或者一个a都没有

 

**数量词：****X+**

含义：代表的是X出现一次或多次

例如：匹配规则为**"a+"**，那么需要匹配的内容是多个字符a，或者一个a

 

**数量词：****X{n}**

含义：代表的是X出现恰好 n 次

例如：匹配规则为**"a{5}"**，那么需要匹配的内容是5个字符a

 

**数量词：****X{n,}**

含义：代表的是X出现至少 n 次

例如：匹配规则为**"a{5, }"**，那么需要匹配的内容是最少有5个字符a

 

**数量词：****X{n,m}**

含义：代表的是X出现至少 n 次，但是不超过 m 次

例如：匹配规则为**"a{5,8}"**，那么需要匹配的内容是有5个字符a 到 8个字符a之间

##### 16.1.2正则表达式匹配练习

请写出满足如下匹配规则的字符串:

规则："[0-9]{6,12}"

该规则需要匹配的内容是：**长度为****6位到12位的数字。**

如：使用数据"123456789"进行匹配结果为true；

​		使用数据"12345"进行匹配结果为false。

 

规则："1[3,4,5,7,8] [0-9]{9}"

该规则需要匹配的内容是：**11位的手机号码，第1位为1，第2位为3、4、5、7、8中的一个，后面9位为0到9之间的任意数字**。

如：使用数据"12345678901"进行匹配结果为false；

​		使用数据"13312345678"进行匹配结果为true。

 

规则："a*b"

该规则需要匹配的内容是：**在多个a或零个a后面有个b；b必须为最后一个字符。**

如：使用数据"aaaaab"进行匹配结果为true；

​		使用数据"abc"进行匹配结果为false。

##### 16.1.3字符串类中涉及正则表达式的常用方法

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml3152\wps1.jpg)

![1558182423605](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558182423605.png)

##### 16.1.4正则表达式匹配练习

```java
package cn.itcast.demo01;

public class RegexDemo {
	public static void main(String[] args) {
		cheakQQ();
		checkTell();
	}
	
	
	/*
	 * 检查手机号码是否合法
	 * 1开头 可以是34578 0-9 固定11位
	 * 
	 */
	public static void checkTell(){
		String tellNumber="13772831018";
		//String类的方法matches
		boolean b = tellNumber.matches("1[34578][0-9]{9}");
		System.out.println(b);
	}
	/*
	 * 检查qq号码是否合法 0不能开头，全是数字，为主5，10 123456
	 */
	public static void cheakQQ() {
		String QQ = "123456";
		boolean b = QQ.matches("[1-9][\\d]{4,9}");
		System.out.println(b);
	}
}
```

```java
package cn.itcast.demo01;

public class RegexDemo1 {
	public static void main(String[] args) {
//		split_1(); 
//		split_2(); 
		replaceAll_1();
	}
	
	
	/*
	 * String类方法split对字符串进行切割
	 * 12-25-36-98 按照-对字符串进行切割
	 */
	public static void split_1() {
		String str="12-25-36-98 ";
		String[] strArr= str.split("-");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	
	/*
	 * String类方法split对字符串进行切割
	 * 12   25   36  98按照空格切割字符串
	 */
	public static void split_2() {
		String str="12   25   36  98 ";
		String[] strArr= str.split(" +");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	
	/*
	 * String类方法split对字符串进行切割
	 * 192.168.105.27按照空格切割字符串
	 * .在正则表达式里面代表任意字符
	 * 所以用转义\\
	 * 
	 */
	public static void split_3() {
		String str="92.168.105.27";
		String[] strArr= str.split("\\.");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	/*
	 * "Hello12345World6789012"将数字替换掉
	 * String类方法replaceAll(正则规则，替换后的新字符串)
	 */
	public static void replaceAll_1() {
		String str = "Hello12345World6789012";
		str=str.replaceAll("[\\d+]", "*");
		System.out.println(str);
	}
}
	
```

##### 16.1.5正则表达式练习

1. 匹配正确的数字

   匹配规则：

   ​	匹配正整数：”\\d+”

   ​	匹配正小数：”\\d+\\.\\d+”  

   ​	匹配负整数：”-\\d+”	匹配负小数：”-\\d+\\.\\d+”

   ​	匹配保留两位小数的正数：”\\d+\\.\\d{2}”

   ​	匹配保留1-3位小数的正数：”\\d+\\.\\d{1,3}”

   

2.  匹配合法的邮箱

   匹配规则：

   ​	”[a-zA-Z_0-9]+@[a-zA-Z_0-9]+(\\.[a-zA-Z_0-9]+)+”

   ​	”\\w+@\\w+(\\.\\w+)+”

   ```java
   package cn.itcast.demo01;
   
   public class RegexDemo2 {
   	public static void main(String[] args) {
   		checkMail();
   	}
   	
   	/*
   	 * 检查邮箱地址是否合法
   	 * 规则:
   	 * 	123456@qq.com
   	 * 	mym_1il@163.com
   	 * 	wodemail@yahoo.com.cn
   	 * 
   	 * 	@: 前 数字字母  个数不能少于1个
   	 * 	@： 后 数字字母  个数不能少于1个
   	 * 	.：后面 字母
   	 */
   	public static void checkMail() {
   		String email = "abc123@sina.com";
   		boolean b = email.matches("[a-zA-Z0-9_]+@[0-9a-z]+(\\.[a-z]+)+");
   		System.out.println(b);
   	}
   }
   ```

   

3.  获取IP地址(192.168.1.100)中的每段数字

   匹配规则：

   ​	”\\.”

#### 16.2Date

##### 16.2.1Date类的概念

类 Date 表示特定的瞬间，精确到毫秒。

继续查阅Date类的描述，发现Date拥有多个构造函数，只是部分已经过时，但是其中有未过时的构造函数可以把毫秒值转成日期对象。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml5532\wps1.jpg)

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml5532\wps2.jpg) 

把日期对象转换成对应的时间毫秒值

##### 16.2.2Date类的方法

```java
package cn.itcast.demo02;

import java.util.Date;

/*
 * 时间和日期类
 * 	 java.util.Date
 * 
 * 毫秒概念： 1000毫秒=1秒
 * 
 * 毫秒的0点：
 * 		System.currentTimeMillis()返回值long类型参数
 * 		获取当前日期的毫秒值	
 * 		时间原点;公元1970年1月1日,午夜0:0:0   毫秒值就是0
 * 	
 * 重要:时间和日期的计算,必须依赖毫秒值
 *    XXX-XXX-XX= 毫秒
 */
public class DateDemo {
	public static void main(String[] args) {
		long time = System.currentTimeMillis();
		System.out.println(time);
		function();
		function_1();
		function_2();
		function_3();
	}
	/*
	 * Date类方法setTime(long)传递毫秒值
	 * 将日期对象，设置到指定毫秒值上
	 * 毫秒值转成日期对象
	 */
	public static void function_3() {
		Date date=new Date();
		System.out.println(date);
		
		date.setTime(0);
		System.out.println(date);
	}
	/*
	 * 	Date类方法getTime() 返回值long
	 * 	返回值是毫秒值
	 */
	public static void function_2() {
		Date date=new Date();
		long time = date.getTime();
		System.out.println(time);
	}
	
	/*
	 * Date类的long参数的构造方法
	 * Date(long)表示毫秒值
	 * 传递毫秒值，将毫秒值转成对应的日期对象
	 */
	public static void function_1() {
		Date date =new Date(0);
		System.out.println(date);
	}
	
	
	
	/*
	 * Date类空参数构造方法
	 * 获取到的是当前操作系统中的时间和日期
	 */
	public static void function() {
		Date date =new Date();
		System.out.println(date);
	}
}
```

##### 16.2.3DateFormat日期格式化   format

DateFormat类的作用：即可以将一个Date对象转换为一个符合指定格式的字符串，也可以将一个符合指定格式的字符串转为一个Date对象。

指定格式的具体规则我们可参照SimpleDateFormat类的说明，这里做简单介绍，规则是在一个字符串中，会将以下字母替换成对应时间组成部分，剩余内容原样输出：

当出现y时，会将y替换成年

当出现M时，会将M替换成月

当出现d时，会将d替换成日

 当出现H时，会将H替换成时

 当出现m时，会将m替换成分

当出现s时，会将s替换成秒

```java
package cn.itcast.demo02;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 对日期进行格式化(自定义)
 * 	对日期格式化的类 java.text.DateFormat 抽象类，普通方法，也有抽象的方法
 * 	实际使用的是子类 java.text.SimpleDateFormat 可以使用父类的普通方法，重写了抽象方法
 */
public class SimpleDateFormatDemo {
	public static void main(String[] args) {
		function();
	}
	
	
	/*
	 * 如何对日期格式化
	 * 步骤:
	 * 	1.创建SimpleDateFormat对象
	 * 	  在类构造方法中，写入字符串的日期进行格式化（自己定义）
	 *  2.SimpleDateFormat调用方法foramt对日期进行格式化
	 *  	String format(Date date) 传递日期对象，返回字符串
	 *  	日期模式:
	 *  		yyyy    年份
	 *  		MM    月份
	 *  		dd     月份中的天数
	 *          HH     0-23小时
	 *          mm     小时中的分钟
	 *          ss     秒
	 *          
	 */ 	
	public static void function() {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月份dd日HH点mm分钟ss秒");
		String date=sdf.format(new Date());
		System.out.println(date);
	}
}
```

##### 16.2.4字符串转成日期对象  parse

```java
package cn.itcast.demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 *   DateFormat类方法 parse
 *   将字符串解析为日期对象
 *   Date parse(String s) 字符串变成日期对象
 *   String => Date parse
 *   Date => String format
 *   
 */
public class SimpleDateFormatDemo1 {
	public static void main(String[] args) throws Exception{
		function();
	}
	/*
	 *  将字符串转成Date对象
	 *  DateFormat类方法 parse
	 *  步骤:
	 *    1. 创建SimpleDateFormat的对象
	 *       构造方法中,指定日期模式
	 *    2. 子类对象,调用方法 parse 传递String,返回Date
	 *    
	 *    注意: 时间和日期的模式yyyy-MM-dd, 必须和字符串中的时间日期匹配
	 *                     1995-5-6
	 *    
	 *    但是,日期是用户键盘输入, 日期根本不能输入
	 *    用户选择的形式
	 */
	public static void function() throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("1995-5-6");
		System.out.println(date);
	}
}
```

##### 16.2.5Calendar类

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10284\wps1.jpg)

```java
package cn.itcast.demo03;

import java.util.Calendar;

/*
 *   日历类 java.util.Calendar
 *   抽象类,使用他的子类对象
 *   
 *   Calendar类写了静态方法 getInstance() 直接返回了子类的对象
 *   不需要直接new 子类的对象,通过静态方法直接获取
 */
public class CalendarDemo {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		System.out.println(c);
	}
}

```

```java
package cn.itcast.demo03;

import java.util.Calendar;
import java.util.Date;

public class CalendarDemo1 {
	public static void main(String[] args) {
		function_3();
	}
	/*
	 * Calendar类的方法getTime()
	 * 把日历对象,转成Date日期对象
	 */
	public static void function_3(){
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		System.out.println(date);
	}
	

	/*
	 * Calendar类方法add 日历的偏移量,
	 * 可以指定一个日历中的字段,
	 * 进行整数的偏移 add(int field, int value)
	 */
	public static void function_2() {
		Calendar c = Calendar.getInstance();
		// 让日历中的天数,向后偏移280天
		c.add(Calendar.DAY_OF_MONTH, -280);
		// 获取年份
		int year = c.get(Calendar.YEAR);
		// 获取月份
		int month = c.get(Calendar.MONTH) + 1;
		// 获取天数
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "年" + month + "月" + day + "日");
	}

	/*
	 * Calendar类的set方法 设置日历 set(int field,int value)        field 设置的是哪个日历字段 value
	 * 设置后的具体数值
	 * 
	 * set(int year,int month,int day) 传递3个整数的年,月,日
	 */
	public static void function_1() {
		Calendar c = Calendar.getInstance();
		// 设置,月份,设置到10月分
		// c.set(Calendar.MONTH, 9);

		// 设置年,月,日
		c.set(2099, 4, 1);

		// 获取年份
		int year = c.get(Calendar.YEAR);
		// 获取月份
		int month = c.get(Calendar.MONTH) + 1;
		// 获取天数
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "年" + month + "月" + day + "日");
	}

	/*
	 * Calendar类的get方法 获取日历字段的值 int get(int) 参数int,获取的哪个日历字段 返回值,就表示日历字段的具体数值
	 */
	public static void funtion() {
		Calendar c = Calendar.getInstance();
		// 获取年份
		int year = c.get(Calendar.YEAR);
		// 获取月份
		int month = c.get(Calendar.MONTH) + 1;
		// 获取天数
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "年" + month + "月" + day + "日");
	}
}
```

##### 16.2.6日期练习

1.求出自己已经出生多少天

2.闰年计算

```java
package cn.itcast.demo04;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateTest {
	public static void main(String[] args) throws Exception {
		function();
		function_1();
	}
	/*
	 * 计算活了多少天
	 * 生日  今天的日期
	 * 两个日期,变成毫秒值,减法
	 */
	public static void function() throws Exception {
		System.out.println("请输入出生日期 格式YYYY-MM-dd");
		//获取出生日期，键盘输入
		String birthdayString =new Scanner(System.in).next();
		//将字符串日期转成Date对象
		//创建SimpleDateFormat对象,写日期模式
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		//调用方法parse,字符串转成日期对象
		Date birthdayDate = sdf.parse(birthdayString);
		
		//获取今天的日期对象
		Date todayDate = new Date();
		
		//将两个日期转成毫秒值，Date类的方法发getTime
		long birthdaySecond = birthdayDate.getTime();
		long todaySecond = todayDate.getTime();
		long second = todaySecond-birthdaySecond;
		System.out.println(second/1000/60/60/24);
		
	  }
	/*
	 * 闰年计算
	 * 2000 3000
	 * 高级算法:日历设置到指定年份的3月1日,add向前偏移1天，获取天数，29润年
	 * 
	 */
	
	public static void function_1() {
		Calendar c = Calendar.getInstance();
		//将日历设置到指定年的3月1日
		c.set(2000, 2,1);
		//日历add方法，向前偏移1天
		c.add(Calendar.DAY_OF_MONTH, -1);
		//get 方法获取天数
		int day =c.get(Calendar.DAY_OF_MONTH);
		System.out.println(day);
	}
}	
	
```

#### 17.1基本数据类型包装类

8种基本类型对应的包装类如下：

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10284\wps2.jpg)

其中需要注意int对应的是Integer，char对应的Character，其他6个都是基本类型首字母大写即可。

基本数据类型对象包装类特点：用于在基本数据和字符串之间进行转换。

 将字符串转成基本类型： 

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10284\wps3.jpg)

##### 17.1.1Integer类的方法parseInt 和toString

```java
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

```

##### 17.1.2Integer类的构造方法

```java
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
	
	
```

##### 17.1.3Integer类的其他方法

```java
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
```

#### 17.2自动装箱和自动拆箱

```java
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
```

#### 17.3System类

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps2.jpg)

```java
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
```

练习

```java
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
```

```java
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
```

```java
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
```

#### 17.4Math类

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps1.jpg)

```java
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
```

#### 17.5Arrays类

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps3.jpg)

```java
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

```

练习

```java
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

```

#### 17.6BigInteger类

java中long型为最大整数类型,对于超过long型的数据如何去表示呢.在Java的世界中,超过long型的整数已经不能被称为整数了,它们被封装成BigInteger对象.在BigInteger类中,实现四则运算都是方法来实现,并不是采用运算符.

  BigInteger类的构造方法:推荐用String的构造方法

 ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps4.jpg)

```java
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
```

#### 17.7BigDecimal类

在程序中执行下列代码,会出现什么问题?

​    System.*out.println(0.09 + 0.01);*

​    System.*out.println(1.0 - 0.32);*

​    System.*out.println(1.015 \* 100);*

​    System.*out.println(1.301 / 100);*

 double和float类型在运算中很容易丢失精度,造成数据的不准确性,Java提供我们BigDecimal类可以实现浮点数据的高精度运算

   构造方法如下:推荐用String

   ![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml30980\wps7.jpg)

```java
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



```

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

#### 18.1ArrayList集合

##### 18.1.1ArrayList存储基本类型和引用数据类型

```java
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

```



##### 18.1.2集合的继承实现关系

 ![1558664017718](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558664017718.png)

List列表有序，Set集无序

List可以重复，Set不能重复

##### 18.1.3Collection接口

![1558664447784](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558664447784.png)

```java
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
```

#### 18.2Iterator迭代器

帮助做集合遍历

##### 18.2.1迭代器的代码实现

```java
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

```

##### 18.2.2迭代器的执行过程

![1558675742060](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558675742060.png)

##### 18.2.3集合迭代中的转型

```java
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
```

```java
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
```

#### 18.3增强for循环遍历数组

增强for没有索引，不改变容器内容的，用增强for

```java
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

```

#### 18.4泛型

```java
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

```

##### 18.4.1泛型类

```java
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
```

##### 18.4.2泛型的方法

```java
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

```

##### 18.4.3泛型接口

```java
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

```

##### 18.4.4泛型的好处

- 避免了类型强转的麻烦
- 将错误从运行时期提前到了编译时期

带来了增强for的使用 

##### 18.4.5泛型的通配符

```java
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

```

18.4.6泛类的限定

```java
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

```

#### 18.5课后作业 统计集合中元素个数 集合元素排序

```java
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
```

```java
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
```

#### 19.1List接口

三个特点：有序，索引，可以重复元素

List接口的常用子类有：

ArrayList集合

LinkedList集合

##### 19.1.1接口中常用的方法

![1558694142117](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558694142117.png)

```java
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
```

##### 19.1.2迭代器的并发修改异常

```java
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

```

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

```java
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

```

##### 19.1.6Vector集合

存储结构是数组

是同步的，安全的，被ArrayList取代了

#### 19.2Set接口

特点：无序，不重复，没有索引

取元素只能采用：迭代器和增强for

##### 19.2.1HashSet

```java
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


```

##### 19.2.2HashSet的数据结构

什么是哈希表呢？

哈希表底层使用的也是数组机制，数组中也存放对象，而这些对象往数组中存放时的位置比较特殊，当需要把这些对象给数组中存放时，那么会根据这些对象的特有数据结合相应的算法，计算出这个对象在数组中的位置，然后把这个对象存放在数组中。而这样的数组就称为哈希数组，即就是哈希表。

当向哈希表中存放元素时，需要根据元素的特有数据结合相应的算法，这个算法其实就是Object类中的hashCode方法。由于任何对象都是Object类的子类，所以任何对象有拥有这个方法。即就是在给哈希表中存放对象时，会调用对象的hashCode方法，算出对象在表中的存放位置，这里需要注意，如果两个对象hashCode方法算出结果一样，这样现象称为哈希冲突，这时会调用对象的equals方法，比较这两个对象是不是同一个对象，如果equals方法返回的是true，那么就不会把第二个对象存放在哈希表中，如果返回的是false，就会把这个值存放在哈希表中。

总结：保证HashSet集合元素的唯一，其实就是根据对象的hashCode和equals方法来决定的。如果我们往集合中存放自定义的对象，那么保证其唯一，就必须复写hashCode和equals方法建立属于当前对象的比较方式。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml1296\wps1.jpg)

##### 19.2.3 **HashSet存储JavaAPI中的类型元素**

给HashSet中存储JavaAPI中提供的类型元素时，不需要重写元素的hashCode和equals方法，因为这两个方法，在JavaAPI的每个类中已经重写完毕，如String类、Integer类等。

```java
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
```



##### 19.2.4HashSet的存储过程

![1558759571788](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1558759571788.png)

##### 19.2.5HashSet的存储自定义对象

给HashSet中存放自定义类型元素时，需要重写对象中的hashCode和equals方法，建立自己的比较方式，才能保证HashSet集合中的对象唯一

##### 19.2.6自定义对象重写hashCode和equals

```java
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
```



##### 19.2.7LinkedHashSet集合

继承自HashSet,有序的

```java
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

```

