package cn.itcast.demo2;

public class ThreadPoolRunnable implements Runnable{
	public void run() {
		System.out.println(Thread.currentThread()+"线程提交的任务");
	}
}
