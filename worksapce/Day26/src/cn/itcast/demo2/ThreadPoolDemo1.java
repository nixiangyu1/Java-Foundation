package cn.itcast.demo2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * ʵ���̳߳���ĵ�������ʽ������Callable�ӿڷ�ʽ
 */
public class ThreadPoolDemo1 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es= Executors.newFixedThreadPool(2);
		//sumit�᷵��һ��Future�ӿڵ�ʵ����
		Future<String> f=es.submit(new ThreadPoolCallabe());
		String s=f.get();
		System.out.println(s);
				
	}
}
