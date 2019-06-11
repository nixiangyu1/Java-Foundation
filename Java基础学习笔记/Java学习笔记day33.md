#### 33.1类加载器

##### 1.1 类的加载

当程序要使用某个类时，如果该类还未被加载到内存中，则系统会通过加载，连接，初始化三步来实现对这个类进行初始化。

-  加载 

就是指将class文件读入内存，并为之创建一个Class对象。

任何类被使用时系统都会建立一个Class对象

- 连接

验证 是否有正确的内部结构，并和其他类协调一致

准备 负责为类的静态成员分配内存，并设置默认初始化值

解析 将类的二进制数据中的符号引用替换为直接引用

- 初始化 

就是我们以前讲过的初始化步骤

##### 1.2 类初始化时机

1. 创建类的实例

2. 类的静态变量，或者为静态变量赋值

3. 类的静态方法

4. 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象

5. 初始化某个类的子类

6. ###### 直接使用java.exe命令来运行某个主类

##### 1.3类加载器

 负责将.class文件加载到内在中，并为之生成对应的Class对象。

虽然我们不需要关心类加载机制，但是了解这个机制我们就能更好的理解程序的运行

##### 1.4类加载器的组成

-  ootstrap ClassLoader 根类加载器

也被称为引导类加载器，负责Java核心类的加载

比如System,String等。在JDK中JRE的lib目录下rt.jar文件中

-  Extension ClassLoader 扩展类加载器

负责JRE的扩展目录中jar包的加载。

在JDK中JRE的lib目录下ext目录

- System ClassLoader 系统类加载器

负责在JVM启动时加载来自java命令的class文件，以及classpath环境变量所指定的jar包和类路径。

#### 33.2反射

JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。

要想解剖一个类,必须先要获取到该类的字节码文件对象。而解剖使用的就是Class类中的方法.所以先要获取到每一个字节码文件对应的Class类型的对象。

~~~java
package cn.itcast.demo1;

public class Person {
	public String name;
	private int age;

	
	/*static{
		System.out.println("静态代码块");
	}*/
	
	public Person(){
	}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	private Person(int age,String name){
		this.name = name;
		this.age = age;
	}
	
	public void eat(){
		System.out.println("人吃饭");
	}

	public void sleep(String s, int a,double d){
		System.out.println("人在睡觉"+s+"....."+a+"....."+d);
	}
	private void playGame(){
		System.out.println("人在打游戏");
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
~~~



##### 2.1Class类

~~~java
package cn.itcast.demo1;
/*
 *  获取一个类的class文件对象的三种方式
 *   1. 对象获取
 *   2. 类名获取
 *   3. Class类的静态方法获取
 */
public class ReflectDemo {
	public static void main(String[] args)throws ClassNotFoundException {
		//1. 对象获取
		Person p = new Person();
		//调用Person类的父类的方法 getClass
		Class c = p.getClass();
		System.out.println(c);
		
		//2. 类名获取
	    //每个类型,包括基本和引用,都会赋予这个类型一个静态的属性,属性名字class
		Class c1 = Person.class;
		System.out.println(c1);
		
		//3. Class类的静态方法获取 forName(字符串的类名)包名.类名
		Class c2 = Class.forName("cn.itcast.demo1.Person");
		System.out.println(c2);
	}
}

~~~

##### 2.2通过反射获取空参数构造方法并使用

~~~java
package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 *  通过反射获取class文件中的构造方法,运行构造方法
 *  运行构造方法,创建对象
 *    获取class文件对象
 *    从class文件对象中,获取需要的成员
 *    
 *  Constructor 描述构造方法对象类
 */
public class ReflectDemo1 {
	public static void main(String[] args) throws Exception {
	
		Class c = Class.forName("cn.itcast.demo1.Person");
		//使用class文件对象,获取类中的构造方法
		//  Constructor[]  getConstructors() 获取class文件对象中的所有公共的构造方法
		/*Constructor[] cons = c.getConstructors();
		for(Constructor con : cons){
			System.out.println(con);
		}*/
		//获取指定的构造方法,空参数的构造方法
		Constructor con =  c.getConstructor();
		//运行空参数构造方法,Constructor类方法 newInstance()运行获取到的构造方法
		Object obj = con.newInstance();
		System.out.println(obj.toString());
	}
}

~~~

##### 2.3通过反射获取有参数构造方法并使用

~~~java
package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 *  通过反射,获取有参数的构造方法并运行
 *  方法getConstructor,传递可以构造方法相对应的参数列表即可
 */
public class ReflectDemo2 {
	public static void main(String[] args)throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		//获取带有,String和int参数的构造方法
		//Constructor<T> getConstructor(Class<?>... parameterTypes)  
		//Class<?>... parameterTypes 传递要获取的构造方法的参数列表
		Constructor con = c.getConstructor(String.class,int.class);
		//运行构造方法
		// T newInstance(Object... initargs)  
		//Object... initargs 运行构造方法后,传递的实际参数
		Object obj = con.newInstance("张三",20);
		System.out.println(obj);
	}
}

~~~

##### 2.4通过反射获取构造方法并运行，快捷方式

~~~java
package cn.itcast.demo1;
/*
 * 反射获取构造方法并运行,有快捷点的方式
 * 有前提:
 *   被反射的类,必须具有空参数构造方法
 *   构造方法权限必须public
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		Class c = Class.forName("cn.itcast.demo1.Person");
		// Class类中定义方法, T newInstance() 直接创建被反射类的对象实例
		Object obj = c.newInstance();
		System.out.println(obj);
	}
}

~~~

##### 2.5反射获取私有的构造方法并运行

~~~java
package cn.itcast.demo1;

import java.lang.reflect.Constructor;

/*
 *  反射获取私有的构造方法运行
 *  不推荐,破坏了程序的封装性,安全性
 *  暴力反射
 */
public class ReflectDemo4 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("cn.itcast.demo1.Person");
		//Constructor[] getDeclaredConstructors()获取所有的构造方法,包括私有的
		/*Constructor[] cons = c.getDeclaredConstructors();
		for(Constructor con : cons){
			System.out.println(con);
		}*/
		//Constructor getDeclaredConstructor(Class...c)获取到指定参数列表的构造方法
		Constructor con = c.getDeclaredConstructor(int.class,String.class);
		
		//Constructor类,父类AccessibleObject,定义方法setAccessible(boolean b)
		con.setAccessible(true);
		
		Object obj = con.newInstance(18,"lisi");
		System.out.println(obj);
	}
}

~~~

##### 2.6反射获取成员变量并改值

~~~java
package cn.itcast.demo1;

import java.lang.reflect.Field;

/*
 *  反射获取成员变量,并修改值
 *  Person类中的成员String name
 */
public class ReflectDemo5 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
		//获取成员变量 Class类的方法 getFields() class文件中的所有公共的成员变量
		//返回值是Field[]    Field类描述成员变量对象的类
		/*Field[] fields = c.getFields();
		for(Field f : fields){
			System.out.println(f);
		}*/
		
		//获取指定的成员变量 String name
		//Class类的方法  Field getField(传递字符串类型的变量名) 获取指定的成员变量
		Field field = c.getField("name");
	   
		//Field类的方法 void set(Object obj, Object value) ,修改成员变量的值
		//Object obj 必须有对象的支持,  Object value 修改后的值
		field.set(obj,"王五");
		System.out.println(obj);
		
	}
}

~~~

##### 2.7反射获取空参数成员方法并运行

~~~java
package cn.itcast.demo1;

import java.lang.reflect.Method;

/*
 *  反射获取成员方法并运行
 *  public void eat(){}
 */
public class ReflectDemo6 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
		//获取class对象中的成员方法
		// Method[] getMethods()获取的是class文件中的所有公共成员方法,包括继承的
		// Method类是描述成员方法的对象
		/*Method[] methods = c.getMethods();
		for(Method m : methods){
			System.out.println(m);
		}*/
		
		//获取指定的方法eat运行
		// Method getMethod(String methodName,Class...c)
		// methodName获取的方法名  c 方法的参数列表
		Method method = c.getMethod("eat");
		//使用Method类中的方法,运行获取到的方法eat
		//Object invoke(Object obj, Object...o)
		method.invoke(obj);
	}
}

~~~

##### 2.8反射获取有参数的成员方法并运行

~~~java
package cn.itcast.demo1;

import java.lang.reflect.Method;

/*
 *  反射获取有参数的成员方法并执行
 *  public void sleep(String,int,double){}
 */
public class ReflectDemo7 {
	public static void main(String[] args) throws Exception{
		Class c = Class.forName("cn.itcast.demo1.Person");
		Object obj = c.newInstance();
		//调用Class类的方法getMethod获取指定的方法sleep
		Method method = c.getMethod("sleep", String.class,int.class,double.class);
		//调用Method类的方法invoke运行sleep方法
		method.invoke(obj, "休眠",100,888.99);
	}
}
~~~

##### 2.9泛型擦出

ArrayList的对象array进行操作，对ArrayList.class进行操作

~~~java
package cn.itcast.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 *   定义集合类,泛型String
 *   要求向集合中添加Integer类型
 *   
 *   反射方式,获取出集合ArrayList类的class文件对象
 *   通过class文件对象,调用add方法
 *   
 *   对反射调用方法是否理解
 */
public class ReflectTest {
	public static void main(String[] args)throws Exception {
		ArrayList<String> array  = new ArrayList<String>();
		array.add("a");
		//反射方式,获取出集合ArrayList类的class文件对象
		Class c = array.getClass();
		//获取ArrayList.class文件中的方法add
		Method method = c.getMethod("add",Object.class);
		//使用invoke运行ArrayList方法add
		method.invoke(array, 150);
		method.invoke(array, 1500);
		method.invoke(array, 15000);
		System.out.println(array);
		
		
	}
}

~~~

##### 2.10反射通过配置文件运行的步骤

~~~java
package cn.itcast.demo3;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/*
 *  调用Person方法,调用Student方法,调用Worker方法
 *  类不清楚,方法也不清楚
 *  通过配置文件实现此功能
 *    运行的类名和方法名字,以键值对的形式,写在文本中
 *    运行哪个类,读取配置文件即可
 *  实现步骤:
 *    1. 准备配置文件,键值对
 *    2. IO流读取配置文件  Reader
 *    3. 文件中的键值对存储到集合中 Properties
 *        集合保存的键值对,就是类名和方法名
 *    4. 反射获取指定类的class文件对象
 *    5. class文件对象,获取指定的方法
 *    6. 运行方法
 */
public class Test {
	public static void main(String[] args) throws Exception{
		//IO流读取配置文件
		FileReader r = new FileReader("config.properties");
		//创建集合对象
		Properties pro = new Properties();
		//调用集合方法load,传递流对象
		pro.load(r);
		r.close();
		//通过键获取值
		String className = pro.getProperty("className");
		String methodName = pro.getProperty("methodName");
		//反射获取指定类的class文件对象
		Class c = Class.forName(className);
		Object obj = c.newInstance();
		//获取指定的方法名
		Method method = c.getMethod(methodName);
		method.invoke(obj);
	}
}

~~~

~~~java
package cn.itcast.demo3;

public class Student {
	public void study(){
		System.out.println("学生在学习");
	}
}

~~~

~~~properties
className=cn.itcast.demo3.Student
methodName=study
#className=cn.itcast.demo3.Person
#methodName=eat
#className=cn.itcast.demo3.Worker
#methodName=job
~~~

