/*
    java���Ѿ��е��������ͣ�Random�࣬���ã����������
	���裺ͬ��
	Random�࣬�ṩ���ܣ����� nextInt()����һ��������������int����
	����������ķ�Χ���ڹ���nextInt(дһ������)������:��������ķ�Χ
	������ķ�Χ��0-ָ��������֮��������  nextInt(100)  0-99
	
    ��������������:�������� nextDouble() ������ķ�Χ0.0-0.999
	
	�����:α������������������д�õ�һ���㷨�����ɳ�����
*/

import java.util.Random;
public class RandomDemo{
	public static void main(String args[]){
		//������Random���͵ı���
		Random ran=new Random();
		//����Random���еĹ��ܲ��������
		//Random���еģ�����������Ĺ���
		int i=ran.nextInt(50);
		System.out.println(i);
		
		
		double d=ran.nextDouble();
		System.out.println(d);
	}
}