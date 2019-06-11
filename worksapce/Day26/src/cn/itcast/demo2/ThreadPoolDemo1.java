package cn.itcast.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 实现线程程序的第三个方式，事项Callable接口方式
 */
public class ThreadPoolDemo1 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es= Executors.newFixedThreadPool(2);
		//sumit会返回一个Future接口的实现类
		Future<String> f=es.submit(new ThreadPoolCallabe());
		String s=f.get();
		System.out.println(s);
				
	}
}
