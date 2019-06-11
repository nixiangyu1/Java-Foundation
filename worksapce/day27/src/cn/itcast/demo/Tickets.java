package cn.itcast.demo;

/*
 * ͬ�����������ȫ����
 * ��ʽ��
 *  	synchronized(�������){
 *  		�߳�Ҫ�����Ĺ�������
 *  }
 */
public class Tickets implements Runnable {
	// ������۵�ƱԴ
	private int ticket = 100;
	Object obj = new Object();

	public void run() {
		while (true) {
			payTicket();
		}
	}

	public synchronized void payTicket() {
		// �̹߳������ݣ�����ͬ�������
		// ��Ʊ�������ж�,����0,���Գ���,����--����

		if (ticket > 0) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "���۵�" + ticket--);

		}
	}
}
