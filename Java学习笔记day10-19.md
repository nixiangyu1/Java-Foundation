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
3. 只有覆盖了抽象类中所有的抽象方法后，其子类才可以创建对象，否则子类还是一个抽象类

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

抽象类的作用:继承的体系，抽象类，强制子类重写抽象的方法

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

- 抽象类为部分方法提供实现，避免之类中重复实现这些方法，提高了代码的重用性，接口只能包含抽象方法
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

在使用多态后的父类引用变量调用方法时，会调用子**类重写后的方法**

成员变量：编译的时候，参考父类中有没有这个变量，如果有，便故意成功，没有编译失败，运行的时候，运行的时父类中的变量

成员方法：编译的时候，参考父类中有没有这个方法，如果有，编译成功，没有编译失败，运行的时候，运行的是子类的重写方法

#### 11.11instanceof关键字

运算符  比较运算符  结果真假值

关键字 instanceof,比较引用数据类型

p变量，是Student类型变量，还是Teacher类型变量



引用变量 instanceof 类名

p instanceof Student 判断，p是不是Student类型对象

如果是，返回true

#### 11.12多态中的转型