package cn.itcast.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Luck接口
 * 实现类ReetrantLock
 */
public class Tickets implements Runnable {
	// 定义出售的票源
	private int ticket = 100;
	private Lock lock = new ReentrantLock();

	public void run() {
		// 调用Lock接口方法lock获取锁
		while (true) {
			lock.lock();
			if (ticket > 0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName() + "出售第" + ticket--);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}finally {
					//释放锁，调用Lock接口方法unlook
					lock.unlock();
				}
				
			}

			
		}
	}

	
}
