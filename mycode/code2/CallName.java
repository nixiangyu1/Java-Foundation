/*
	ʵ�����������
	1.�洢�����˵�����
	2.Ԥ������ѧ������������������
	3.�������Ϊ����������������Ԫ��
	
	�����ܶ������������ɷ��������÷�������
	
	������������,�õ�ͬһ����������
	�����洢�������У�����������ʹ��һ�������е����ݣ��������ݲ���
    


*/


import java.util.Random;

public class CallName{
	public static void main(String args[]){
		//�������飬�洢ѧ������
		String[] names=new String[8];
		//����������������
		addStudent(names);
		//���ñ������鷽��
		printStudentName(names);
		//���������������
		System.out.println(randomStudentName(names));
	}
	
	
	/*
		���巽����ʵ��������������ѧ������
		����ֵ��û��
		����������
	
	
	*/
	public static void addStudent(String[] names){
		names[0]="������";
		names[1]="������";
		names[2]="����";
		names[3]="����";
		names[4]="����";
		names[5]="����";
		names[6]="����";
		names[7]="����";
	}
	
	
	/*
		���巽������������
		����ֵ��û��
		����������
	*/
	public static void printStudentName(String[] names){
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
	}
	
	
	
	/*
		���巽�������������Ϊ���������������ҵ�ѧ������
		����ֵ��ѧ������
		������  ����
		
	
	*/
	public static String randomStudentName(String[] names){
		Random ran=new Random();
		int index=ran.nextInt(names.length);
		return names[index];
	}
	
}



