package cn.itcast.demo09;
/*
 * �Զ���������
 * ����USB�ӿڹ淶
 * ʵ��USB,��д���󷽷�
 */
public class Mouse implements USB {
	public void open() {
		System.out.println("�������");
	}
	public void close() {
		System.out.println("�ر����");
	}
}
