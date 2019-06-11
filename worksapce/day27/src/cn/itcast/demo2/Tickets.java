package cn.itcast.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Luck�ӿ�
 * ʵ����ReetrantLock
 */
public class Tickets implements Runnable {
	// ������۵�ƱԴ
	private int ticket = 100;
	private Lock lock = new ReentrantLock();

	public void run() {
		// ����Lock�ӿڷ���lock��ȡ��
		while (true) {
			lock.lock();
			if (ticket > 0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName() + "���۵�" + ticket--);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}finally {
					//�ͷ���������Lock�ӿڷ���unlook
					lock.unlock();
				}
				
			}

			
		}
	}

	
}
