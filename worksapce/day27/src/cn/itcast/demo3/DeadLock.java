package cn.itcast.demo3;

import javax.sql.rowset.spi.SyncFactory;

public class DeadLock implements Runnable{
	private int i =0;
	public void run() {
		while(true) {
			if(i%2==0) {
				synchronized (LockA.locka) {
					System.out.println("if....locka");
					synchronized (LockB.lockb) {
						System.out.println("if....lockb");
					}
				}
			}else {
				synchronized (LockB.lockb) {
					System.out.println("if...lockb");
					synchronized (LockA.locka) {
						System.out.println("if....locka");
					}
				}
				
			}
			i++;
		}
	}
}
