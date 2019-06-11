package cn.itcast.demo04;
/*
 * ����̣߳���Reshource�еĳ�Ա�������
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
				//�жϱ�ǣ���false,�ȴ�
			if(!r.flag)
				try {
					r.wait();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			System.out.println(r.name+".."+r.sex);
			//��Ǹĳ�false,���ѶԷ��߳�
			r.flag=false;
			r.notify();
			
			}
		}
	}

}
