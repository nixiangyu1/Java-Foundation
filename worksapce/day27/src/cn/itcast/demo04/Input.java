package cn.itcast.demo04;

/*
 * ������̣߳�����Դ����Resource�еĳ�Ա������ֵ
 * 
 */
public class Input implements Runnable {
	private Resource r;

	public Input(Resource r) {
		this.r = r;
	}

	public Input() {
	}

	public void run() {
		int i = 0;
		while (true) {
			synchronized (r) {
				// ���Ϊtrue,����ȴ�
				if (r.flag)
					try {
						r.wait();
					} catch (InterruptedException e) {

						e.printStackTrace();
					}
				if (i % 2 == 0) {
					r.name = "����";
					r.sex = "��";
				} else {
					r.name = "lisi";
					r.sex = "nv";
				}
				//���Է��̻߳���,��Ǹ�Ϊtrue
				r.flag=true;
				r.notify();
				
				
				
				
				i++;

			}
		}
	}

}
