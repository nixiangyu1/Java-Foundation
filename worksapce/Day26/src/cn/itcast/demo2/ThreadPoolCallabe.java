package cn.itcast.demo2;

import java.util.concurrent.Callable;

/*
 * Callable�ӿڵ�ʵ����
 */
public class ThreadPoolCallabe implements Callable<String>{
	public String call() {
		return "abc"; 
	}
}
