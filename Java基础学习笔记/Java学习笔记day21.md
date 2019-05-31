#### 21.1异常

Throwable

Exception 异常  将异常处理掉，可以继续执行

Error  错误  必须修改程序

##### 21.1.1异常产生的过程

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml10056\wps1.jpg)

##### 21.1.2抛出异常throw

~~~JAVA
package cn.itcast.demo;
/*
 *  异常中的关键字
 *    throw,在方法内部,抛出异常的对象
 *    throw 后面,必须写new 对象,必须是异常的对象,必须是Exception或者子类
 *    
 *  方法中声明异常关键字
 *    throws 用于在方法的声明上,标明次方法,可能出现异常
 *    请调用者处理
 *    throws 后面必须写异常类的类名
 *    
 *    调用了一个抛出异常的方法,调用者就必须处理
 *    不处理,编译失败
 */
public class ExceptionDemo {
	public static void main(String[] args) throws Exception {
		int[] arr = {};
		int i = getArray(arr);
		System.out.println(i);
	}
	//对数组的最后索引*2,返回
	public static int getArray(int[] arr) throws Exception {
		//对方法参数进行合法性的判断,进行判断是不是null
		if( arr == null){
			//抛出异常的形式,告诉调用者
			//关键字 throw
			throw new Exception("传递数组不存在");
		}
		
		//对数组进行判断,判断数组中,是不是有元素
		if(arr.length == 0){
			//抛出异常的形式,告诉调用者,数组没有元素
			throw new Exception("数组中没任何元素");
		}
		int i = arr[arr.length-1];
		return i*2;
	}
}

~~~

##### 21.1.3try...catch，多catch异常处理

~~~java
package cn.itcast.demo;
/*
 *  异常的处理方式:
 *    try...catch...finally
 *    格式:
 *      try{
 *        被检测的代码
 *        可能出现异常的代码
 *      }catch(异常类名 变量){
 *         异常的处理方式
 *         循环,判断,调用方法,变量
 *      }finally{
 *         必须要执行代码
 *      }
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
		int[] arr = null;
		try{
			int i = getArray(arr);
			System.out.println(i);
			
		}catch(NullPointerException ex){
			System.out.println("###"+ex);
			
		}catch(ArrayIndexOutOfBoundsException ex){
			
			System.out.println("!!!!!!"+ex);
		}
		System.out.println("Game Over");
	}
	/*
	 * 定义方法,抛出异常
	 * 调用者使用try catch
	 */
	 public static int getArray(int[] arr)throws NullPointerException,ArrayIndexOutOfBoundsException{
		 //对数组判空
		 if( arr == null){
			 //手动抛出异常,抛出空指针异常
			 throw new NullPointerException("数组不存在");
		 }
		 //对数组的索引进行判断
		 if( arr.length < 3){
			 //手动抛出异常,抛出数组的索引越界异常
			 throw new ArrayIndexOutOfBoundsException("数组没有3索引");
		 }
		 return arr[3]+1;
	 }
}



~~~

##### 21.1.4多catch处理细节

~~~java
package cn.itcast.demo;

import java.util.NoSuchElementException;

/*
 *  多catch写在一起
 *  细节:
 *    catch小括号中,写的是异常类的类名
 *    有没有顺序的概念,有
 *    
 *    平级异常: 抛出的异常类之间,没有继承关系,没有顺序
 *      NullPointerException extends RuntimeException
 *      NoSuchElementException extends RuntimeException
 *      ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException extends RuntimeException
 *      
 *    上下级关系的异常
 *      NullPointerException extends RuntimeException extends Exception
 *      越高级的父类,写在下面
 */
public class ExceptionDemo2 {
	public static void main(String[] args) {
		try{
			
		}catch(NullPointerException ex){
			
		}
		catch(Exception ex){
			
		}
	}
	public static void function(int a)throws NullPointerException,Exception{
		if(a == 0){
			throw new NullPointerException();
		}
		if(a == 1){
			throw new Exception();
		}
	}
}

~~~

##### 21.1.5finally代码块

~~~java
package cn.itcast.demo;
/*    try{
*        被检测的代码
*        可能出现异常的代码
*      }catch(异常类名 变量){
*         异常的处理方式
*         循环,判断,调用方法,变量
*      }finally{
*         必须要执行代码
*      }
*      finally,无论程序是否有异常出现,程序必须执行
*      释放资源
*/
public class ExceptionDemo3 {
	public static void main(String[] args) {
		try{
			function(0);
		}catch(Exception ex){
			System.out.println(ex);
		
		}finally{
			System.out.println("代码必须执行");
		}
	}
	
	public static void function(int a)throws Exception{
		if( a == 0)
			throw new Exception();
		System.out.println(a);
	}
	
}
~~~

##### 21.1.6调用抛出异常方法try和throws处理方法

~~~java
package cn.itcast.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo4 {
	public static void main(String[] args) {
		try{
			function();
		}catch(ParseException ex){
			
		}
	}
	
	public static void function()throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse("2088-8-8");	
		System.out.println(date);
	}
}
~~~

#### 21.2运行时期异常的特点

~~~java
package cn.itcast.demo1;
/*
 *  异常分为编译异常和运行时期异常
 *    编译异常: 调用了抛出异常的方法,不处理编译失败  (try  throws)
 *    运行异常: 抛出的异常是RuntimeException类,或者是他的子类
 *  
 *  运行异常的特点:
 *     方法内部抛出的异常是运行异常, new XXXException
 *     方法的声明上,不需要throws语句,调用者,不需要处理
 *     设计原因:
 *        运行异常,不能发生,但是如果发生了,程序人员停止程序修改源代码
 *        
 *        运行异常: 一旦发生,不要处理,请你修改源代码, 运行异常一旦发生,后面的代码没有执行的意义
 */
public class RuntimeExceptionDemo {
	public static void main(String[] args) {
			double d = getArea(1);
			System.out.println(d);
	}
	
	/*
	 *  定义方法,计算圆形的面积
	 *  传递参数0,或者负数,计算的时候没有问题
	 *  但是,违反了真实情况
	 *  参数小于=0, 停止程序,不要在计算了
	 */
	public static double getArea(double r){
		if(r <= 0)
			throw new RuntimeException("圆形不存在");
		return r*r*Math.PI;
	}
	
	
	public static void function(){
		int[] arr = {1,2,3};
		//对数组的5索引进行判断,如果5索引大于100,请将5索引上的数据/2,否则除以3
		//索引根本就没有
		if(arr[5] > 100){
			arr[5] = arr[5]/2;
		}else{
			arr[5] = arr[5]/3;
		}
	}
}
~~~

#### 21.3方法重写时候异常的处理

~~~java
package cn.itcast.demo2;
/*
 *  继承后,在子类重写父类方法的时候,异常处理
 *  结论:
 *    父类的方法,如果抛出异常,子类重写后
 *      可以不抛出异常
 *      也可以抛出异常,但是,如果子类要抛,抛出的异常不能大于父类的异常
 *        大于,都指的是继承关系
 *        
 *    父类的方法,没有异常抛出,子类重写后
 *       也不能抛出异常
 *       如果子类中调用了抛出异常的方法,别无选择,只能try..catch处理
 */
public class ExceptionDemo {
	public static void main(String[] args) {
		Fu f = new Zi();
		f.function();
	}
}

class Fu{
	public void function(){
		
	}
}
class Zi extends Fu{
	public void function(){
		
			try {
				method();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	
	}
	public void method()throws Exception{
		
	}
}

~~~

#### 21.4Throwable类的方法

~~~java
package cn.itcast.demo2;
/*
 *  Throwable类中的方法
 *  三个方法,都和异常的信息有关系
 *    String getMessage() 对异常信息的详细描述       异常了!
 *    String toString()   对异常信息的简短描述       java.lang.Exception: 异常了!
 *    void printStackTrace() 将异常信息追踪到标准的错误流  异常信息最全,JVM默认调用方法也是这个方法
 */
public class ExceptionDemo1 {
	public static void main(String[] args) {
	  try{	 
		function();
	  }catch(Exception ex){
		  //System.out.println(ex.toString());
		  ex.printStackTrace();
	  }
	}
	
	public static void function() throws Exception{
		throw new Exception("异常了!");
	}
}
~~~

#### 21.5自定义异常

~~~java
package cn.itcast.demo3;

public class ExceptionDemo {
	public static void main(String[] args) {
		
		int avg = getAvg(50,60,-70,80);
		System.out.println(avg);
		
	}
	/*
	 * 传递成绩,计算成绩的平均数
	 * 成绩没有负数,需要抛出异常,停止运算
	 */
	public static int getAvg(int...source){
		int sum = 0 ;
		for(int s : source){
			if( s < 0){
				throw new FuShuException("成绩错误 "+s);
			}
			sum = sum + s;
		}
		return sum/source.length;
	}
}

~~~

~~~java
package cn.itcast.demo3;
/*
 *  自定义异常
 *    继承Exception,或者继承RuntimeException
 *    构造方法中,super将异常信息,传递给父类
 */
public class FuShuException extends RuntimeException{
	public FuShuException(String s){
		super(s);
	}
	
	public FuShuException(){}
}

~~~

