package cn.itcast.demo2;

import java.util.concurrent.Callable;

/*
 * Callable接口的实现类
 */
public class ThreadPoolCallabe implements Callable<String>{
	public String call() {
		return "abc"; 
	}
}
