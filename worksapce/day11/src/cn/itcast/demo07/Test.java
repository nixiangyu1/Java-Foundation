package cn.itcast.demo07;
/*
 * �����  �Ƚ������  ������ֵ
 * �ؼ��� instanceof,�Ƚ�������������
 * p��������Student���ͱ���������Teacher���ͱ���
 * 
 * 	���ñ��� instanceof ����
 * 	p instanceof Student �Ƚϣ�p�ǲ���Student���Ͷ���
 *  ����ǣ�����true
 */
public class Test {
	public static void main(String[] args) {
		People p= new Student();
		p.sleep();
	}
}
