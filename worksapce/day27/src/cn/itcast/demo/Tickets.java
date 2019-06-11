package cn.itcast.demo;

/*
 * 同步技术解决安全问题
 * 公式：
 *  	synchronized(任意对象){
 *  		线程要操作的共享数据
 *  }
 */
public class Tickets implements Runnable {
	// 定义出售的票源
	private int ticket = 100;
	Object obj = new Object();

	public void run() {
		while (true) {
			payTicket();
		}
	}

	public synchronized void payTicket() {
		// 线程共享数据，加入同步代码块
		// 对票数进行判断,大于0,可以出售,变量--操作

		if (ticket > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "出售第" + ticket--);

		}
	}
}
