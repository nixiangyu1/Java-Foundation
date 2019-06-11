package cn.itcast.demo04;
/*
 * 输出线程，对Reshource中的成员变量输出
 */
public class Output implements Runnable {
	private Resource r;
	public Output(Resource r) {
		this.r=r;
	}
	public Output() {}
	public void run() {
		
		while(true) {
			synchronized(r) {
				//判断标记，是false,等待
			if(!r.flag)
				try {
					r.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			System.out.println(r.name+".."+r.sex);
			//标记改成false,唤醒对方线程
			r.flag=false;
			r.notify();
			
			}
		}
	}

}
