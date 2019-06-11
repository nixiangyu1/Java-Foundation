#### 26.1多线程

**线程**与进程相似，但线程是一个比进程更小的执行单位。一个进程在其执行的过程中可以产生多个线程。与进程不同的是同类的多个线程共享同一块内存空间和一组系统资源，所以系统在产生一个线程，或是在各个线程之间作切换工作时，负担要比进程小得多，也正因为如此，线程也被称为轻量级进程。

 

**程序**是含有指令和数据的文件，被存储在磁盘或其他的数据存储设备中，也就是说程序是静态的代码。

 

**进程**是程序的一次执行过程，是系统运行程序的基本单位，因此进程是动态的。系统运行一个程序即是一个进程从创建，运行到消亡的过程。简单来说，一个进程就是一个执行中的程序，它在计算机中一个指令接着一个指令地执行着，同时，每个进程还占有某些系统资源如CPU时间，内存空间，文件，文件，输入输出设备的使用权等等。换句话说，当程序在执行时，将会被操作系统载入内存中。 线程是进程划分成的更小的运行单位。线程和进程最大的不同在于基本上各进程是独立的，而各线程则不一定，因为同一进程中的线程极有可能会相互影响。从另一角度来说，进程属于操作系统的范畴，主要是同一段时间内，可以同时执行一个以上的程序，而线程则是在同一程序内几乎同时执行一个以上的程序段。

##### 26.1.1多线程的概念

进程：进程指正在运行的程序。确切的来说，当一个程序进入内存运行，即变成一个进程，进程是处于运行过程中的程序，并且具有一定独立功能。

线程：线程是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。一个进程中是可以有多个线程的，这个应用程序也可以称之为多线程程序。

简而言之：一个程序运行后至少有一个进程，一个进程中可以包含多个线程

##### 26.1.2程序运行的原理

-  分时调度

所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间。

-  抢占式调度

优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个(线程随机性)，Java使用的为抢占式调度。

##### 26.1.3主线程

JVM启动后，必然有一个执行路径(线程)从main方法开始的，一直执行到main方法结束，这个线程在java中称之为主线程。

##### 26.1.4多线程内存图解

多线程执行时，到底在内存中是如何运行的呢？

以上个程序为例，进行图解说明：

多线程执行时，在栈内存中，其实每一个执行线程都有一片自己所属的栈内存空间。进行方法的压栈和弹栈。

![img](file:///C:\Users\请\AppData\Local\Temp\ksohtml8420\wps1.jpg) 

当执行线程的任务结束了，线程自动在栈内存中释放了。但是当所有的执行线程都结束了，那么进程就结束了。

##### 26.1.5Thread类的方法sleep

静态方法，直接类名调用

~~~java
Thread.sleep(1000)//休眠一秒
~~~

##### 26.1.6线程实现方式Runnable接口

1. 创建一个类实现Runnable接口    SubRunnable  Class implements Runnable{}
2. 创建这个类的对象SubRunnable sr =  new SubRunnable()
3. 创建一个Thread类的对象，Thread t = new Thread(sr)

好处：

实现Runnable接口避免了单继承的局限性，所以较为常用。实现Runnable接口的方式，更加的符合面向对象，线程分为两部分，一部分线程对象，一部分线程任务。继承Thread类，线程对象和线程任务耦合在一起。一旦创建Thread类的子类对象，既是线程对象，有又有线程任务。实现runnable接口，将线程任务单独分离出来封装成对象，类型就是Runnable接口类型。Runnable接口对线程对象和线程任务进行解耦。

##### 26.1.7匿名内部类实现线程程序

~~~java
package cn.itcast.demo4;
/*
 *  使用匿名内部类,实现多线程程序
 *  前提: 继承或者接口实现
 *  new 父类或者接口(){
 *     重写抽象方法
 *  }
 */
public class ThreadDemo {
	public static void main(String[] args) {
		//继承方式  XXX extends Thread{ public void run(){}}
		new Thread(){
			public void run(){
				System.out.println("!!!");
			}
		}.start();
		
		//实现接口方式  XXX implements Runnable{ public void run(){}}
		
		Runnable r = new Runnable(){
			public void run(){
				System.out.println("###");
			}
		};
		new Thread(r).start();
		
		
		new Thread(new Runnable(){
			public void run(){
				System.out.println("@@@");
			}
		}).start();
		
	}
}
~~~

##### 26.1.8线程状态图

![1559371067470](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559371067470.png)

 

#### 16.2线程池

##### 16.2.1线程池原理

 用来存放线程的一个集合

![1559371875365](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559371875365.png)

##### 16.2.2实现线程的Runnable方式（没有返回值）

~~~java
package cn.itcast.demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *  JDK1.5新特性,实现线程池程序
 *  使用工厂类 Executors中的静态方法创建线程对象,指定线程的个数
 *   static ExecutorService newFixedThreadPool(int 个数) 返回线程池对象
 *   返回的是ExecutorService接口的实现类 (线程池对象)
 *   
 *   接口实现类对象,调用方法submit (Ruunable r) 提交线程执行任务
 *          
 */
public class ThreadPoolDemo {
	public static void main(String [] args) {
		//调用工厂类的静态方法,创建线程池对象
		//返回线程池对象,是返回的接口
		ExecutorService es = Executors.newFixedThreadPool(2);
	    //调用接口实现类对象es中的方法submit提交线程任务
		//将Runnable接口实现类对象,传递
		es.submit(new ThreadPoolRunnable());
		es.submit(new ThreadPoolRunnable());
		es.submit(new ThreadPoolRunnable());
	
	}
}
~~~

~~~java
package cn.itcast.demo5;

public class ThreadPoolRunnable implements Runnable {
	public void run(){
		System.out.println(Thread.currentThread().getName()+" 线程提交任务");
	}
}

~~~



##### 16.2.3实现线程的Callable接口方式（线程有返回值的）

创建线程的时候 会自动调用Callable接口中的Call方法，返回的是可能抛出异常的任务

submit提交的是一个未决结果的任务

Future表示异步计算的结果

~~~java
package cn.itcast.demo5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 *  实现线程程序的第三个方式,实现Callable接口方式
 *  实现步骤
 *    工厂类 Executors静态方法newFixedThreadPool方法,创建线程池对象
 *    线程池对象ExecutorService接口实现类,调用方法submit提交线程任务
 *    submit(Callable c)
 */
public class ThreadPoolDemo1 {
	public static void main(String[] args)throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2);
		//提交线程任务的方法submit方法返回 Future接口的实现类
		Future<String> f = es.submit(new ThreadPoolCallable());
		String s = f.get();
		System.out.println(s);
	}
}

~~~

~~~java
package cn.itcast.demo5;
/*
 * Callable 接口的实现类,作为线程提交任务出现
 * 使用方法返回值
 */

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String>{
	public String call(){
		return "abc";
	}
~~~

##### 16.2.4线程实现异步计算

~~~java
package cn.itcast.demo6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 使用多线程技术,求和
 * 两个线程,1个线程计算1+100,另一个线程计算1+200的和
 * 多线程的异步计算
 */
public class ThreadPoolDemo {
	public static void main(String[] args)throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> f1 =es.submit(new GetSumCallable(100));
		Future<Integer> f2 =es.submit(new GetSumCallable(200));
		System.out.println(f1.get());
		System.out.println(f2.get());
		es.shutdown();
	}
}

~~~

~~~java
package cn.itcast.demo6;

import java.util.concurrent.Callable;

public class GetSumCallable implements Callable<Integer>{
	private int a;
	public GetSumCallable(int a){
		this.a=a;
	}
	
	public Integer call(){
		int sum = 0 ;
		for(int i = 1 ; i <=a ; i++){
			sum = sum + i ;
		}
		return sum;
	}
}
~~~

