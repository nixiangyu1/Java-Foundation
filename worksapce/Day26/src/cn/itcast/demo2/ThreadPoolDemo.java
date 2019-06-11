package cn.itcast.demo2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

	public static void main(String[] args) {
		//调用工厂类的方法，创建线程池对象
		//返回线程池对象，是返回的接口
		ExecutorService es=Executors.newFixedThreadPool(2);
		// 
		es.submit(new ThreadPoolRunnable());
		es.submit(new ThreadPoolRunnable());
	}

}
