#### 27.1线程安全

多线程同时操作一个共享数据，可能会出现安全问题

![1559382276301](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559382276301.png)

##### 27.1.1同步代码块解决线程安全问题

当一个线程进入数据操作的时候，无论是否休眠，其他线程只能等待

加入同步代码块 

**公式:**

synchronized(任意对象){

线程要操作的共享数据

}

注意:同步进程会影响程序速度，但是保证了程序的安全

~~~java
package cn.itcast.demo;
/*
 * 多线程并发访问同一个数据资源
 * 3个线程,对一个票资源,出售
 */
public class ThreadDemo {
	public static void main(String[] args) {
		//创建Runnable接口实现类对象
		Tickets t = new Tickets();
		//创建3个Thread类对象,传递Runnable接口实现类
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t0.start();t1.start();t2.start();
		
	}
}

~~~

~~~java
package cn.itcast.demo;
/*
 *  通过线程休眠,出现安全问题
 *  解决安全问题,Java程序,提供技术,同步技术
 *  公式:
 *    synchronized(任意对象){
 *      线程要操作的共享数据
 *    }
 *    同步代码块
 */
public class Tickets implements Runnable{
	
	//定义出售的票源
	private int ticket = 100;
	private Object obj = new Object();
	
	public void run(){
		while(true){
			//线程共享数据,保证安全,加入同步代码块
			synchronized(obj){
			//对票数判断,大于0,可以出售,变量--操作
				if( ticket > 0){
					try{
					   Thread.sleep(10);
					}catch(Exception ex){}
					System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
				}
			}
		}
	}
}
~~~

##### 27.1.2同步方法解决线程安全问题

将同步代码块提取出来，写在一个方法中

方法声明中加入synchronized,把代码块中的synchronized去掉

同步方法中同步锁，是本类对象引用this

静态方法，同步锁，是本类类名.class属性

~~~java
package cn.itcast.demo1;
/*
 * 多线程并发访问同一个数据资源
 * 3个线程,对一个票资源,出售
 */
public class ThreadDemo {
	public static void main(String[] args) {
		//创建Runnable接口实现类对象
		Tickets t = new Tickets();
		//创建3个Thread类对象,传递Runnable接口实现类
		Thread t0 = new Thread(t);
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t0.start();t1.start();t2.start();
		
	}
}
~~~

~~~java
package cn.itcast.demo1;
/*
 *  采用同步方法形式,解决线程的安全问题
 *  好处: 代码简洁
 *  将线程共享数据,和同步,抽取到一个方法中
 *  在方法的声明上,加入同步关键字
 *  
 *  问题:
 *    同步方法有锁吗,肯定有,同步方法中的对象锁,是本类对象引用 this
 *    如果方法是静态的呢,同步有锁吗,绝对不是this
 *    锁是本类自己.class 属性
 *    静态方法,同步锁,是本类类名.class属性
 */
public class Tickets implements Runnable{

	//定义出售的票源
	private  int ticket = 100;
	
	public void run(){
		while(true){
			payTicket();
		}
	}
	
	public  synchronized void payTicket(){	
			if( ticket > 0){
				try{
				   Thread.sleep(10);
				}catch(Exception ex){}
				System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
			}
		
	}
}

~~~

##### 27.1.3Lock接口

~~~java
package cn.itcast.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 *  使用JDK1.5 的接口Lock,替换同步代码块,实现线程的安全性
 *  Lock接口方法:
 *     lock() 获取锁
 *     unlock()释放锁
 *  实现类ReentrantLock
 */
public class Tickets implements Runnable{
	
	//定义出售的票源
	private int ticket = 100;
	//在类的成员位置,创建Lock接口的实现类对象
	private Lock lock = new ReentrantLock();
	
	public void run(){
		while(true){
			//调用Lock接口方法lock获取锁
		    lock.lock();
			//对票数判断,大于0,可以出售,变量--操作
				if( ticket > 0){
					try{
					   Thread.sleep(10);
					   System.out.println(Thread.currentThread().getName()+" 出售第 "+ticket--);
					}catch(Exception ex){
						
					}finally{
						//释放锁,调用Lock接口方法unlock
						lock.unlock();
					}
				}
	
			
		}
	}
}
~~~

#### 27.2死锁

27.2.1死锁的原理

多个进程在执行过程中，因为竞争资源会造成相互等待的局面。如果没有外力作用，这些

进程将永远无法向前推进。此时称系统处于死锁状态或者系统产生了死锁。

![1559388221943](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559388221943.png)

~~~java
package cn.itcast.demo3;

public class DeadLockDemo {
	public static void main(String[] args) {
		DeadLock dead = new DeadLock();
		Thread t0 = new Thread(dead);
		Thread t1 = new Thread(dead);
		t0.start();
		t1.start();
	}
}
~~~

~~~java
package cn.itcast.demo3;

public class DeadLock implements Runnable{
	private int i = 0;
	public void run(){
		while(true){
			if(i%2==0){
				//先进入A同步,再进入B同步
				synchronized(LockA.locka){
					System.out.println("if...locka");
					synchronized(LockB.lockb){
						System.out.println("if...lockb");
					}
				}
			}else{
				//先进入B同步,再进入A同步
				synchronized(LockB.lockb){
					System.out.println("else...lockb");
					synchronized(LockA.locka){
						System.out.println("else...locka");
					}
				}
			}
			i++;
		}
	}
}
~~~

~~~java
package cn.itcast.demo3;

public class LockA {
	private LockA(){}
	
	public  static final LockA locka = new LockA();
}
~~~

~~~java
package cn.itcast.demo3;

public class LockB {
	private LockB(){}
	
	public static final LockB lockb = new LockB();
}

~~~

##### 27.2.1等待唤醒机制

等待唤醒机制所涉及到的方法：

- wait（） :等待，将正在执行的线程释放其执行资格 和 执行权，并存储到线程池中。
- notify（）：唤醒，唤醒线程池中被wait（）的线程，一次唤醒一个，而且是任意的。
- notifyAll（）： 唤醒全部：可以将线程池中的所有wait() 线程都唤醒。

**注意**：这些方法，需要锁对象来调用

27.2.2线程等待与唤醒案例

![1559392786100](C:\Users\请\AppData\Roaming\Typora\typora-user-images\1559392786100.png)

~~~java
package cn.itcast.demo4;
/*
 *  开启输入线程和输出线程,实现赋值和打印值
 */
public class ThreadDemo{
	public static void main(String[] args) {
		
		Resource r = new Resource();
		
		Input in = new Input(r);
		Output out = new Output(r);
		
		Thread tin = new Thread(in);
		Thread tout = new Thread(out);
		
		tin.start();
		tout.start();
	}
}

~~~

~~~java
package cn.itcast.demo4;
/*
 *  定义资源类,有2个成员变量
 *  name,sex
 *  同时有2个线程,对资源中的变量操作
 *  1个对name,age赋值
 *  2个对name,age做变量的输出打印
 */
public class Resource {
	public String name;
	public String sex;
	public boolean flag = false;
}

~~~

~~~java
package cn.itcast.demo4;
/*
 *  输入的线程,对资源对象Resource中成员变量赋值
 *  一次赋值 张三,男
 *  下一次赋值 lisi,nv
 */
public class Input implements Runnable {
	private Resource r ;
	
	public Input(Resource r){
		this.r = r;
	}
	
	public void run() {
		int i = 0 ;
		while(true){
		  synchronized(r){
			  //标记是true,等待
			    if(r.flag){
			    	try{r.wait();}catch(Exception ex){}
			    }
			  
				if(i%2==0){
					r.name = "张三";
					r.sex = "男";
				}else{
					r.name = "lisi";
					r.sex = "nv";
				}
				//将对方线程唤醒,标记改为true
				r.flag = true;
				r.notify();
		  }
			i++;
		}
	}

}

~~~

~~~java
package cn.itcast.demo4;
/*
 *  输出线程,对资源对象Resource中成员变量,输出值
 */
public class Output implements Runnable {
	private Resource r ;
	
	public Output(Resource r){
		this.r = r;
	}
	public void run() {
		while(true){
		  synchronized(r){	
			  //判断标记,是false,等待
			if(!r.flag){
				try{r.wait();}catch(Exception ex){}
		    }
			System.out.println(r.name+".."+r.sex);
			//标记改成false,唤醒对方线程
			r.flag = false;
			r.notify();
		  }
		}
	}

}
~~~

