package cn.itcast.demo1;
/*
 * ����Ա����һ�֣��ж��������
 * �̳�Employee,ʵ��VIP����
 */
public class ChuShi extends Employee implements VIP {
	//�ղι��췽��
	public ChuShi() {}
	//���ι��췽��
	public ChuShi(String name,String ID) {
		super(name,ID);
	}
	
	
	
	public void work() {
		System.out.println("��ʦ�ڳ���");
	}
	public void services() {
		System.out.println("��ʦ���˼���");
	}
}
