/*
   ����JAVA�еı���
   ����������������͵ı���
   �������
*/


public class Variable{
	public static void main(String args[]){
	    //�����������ͣ��ֽ����� byte����
		//�ڴ���1���ֽڡ�-128  127
		byte b=100;
		System.out.println(b);
		//�����������ͣ�������,short����
		//�ڴ���2���ֽڣ�-32768 32767
		short s=200;
		System.out.println(s);
		
		//�����������ͣ����ͣ�int����
		//�ڴ���4���ֽڣ�
		int i=200002;
		System.out.println(i);
		
		
		//�����������ͣ������ͣ�int����
		//�ڴ���4���ֽڣ�
		long l=20000223123123123L;
		System.out.println(l);
		
		//���帡������ �������� float����
		//�ڴ���4���ֽ�
		float f=1.0F;
		System.out.println(f);
		
		
		 //��ת����������� ������=����ת����������ͣ�Ҫ��ת������
        i =(int)f;
        System.out.println(i);
	}
}