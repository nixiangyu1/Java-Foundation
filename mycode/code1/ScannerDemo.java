/*
 �����������ͣ�����һ����Scanner
 JAVA���Ѿ������ˣ���Sun��˾Ϊ�������õ��࣬ʹ��
 �����������������͵ı������ͻ������ͱ�������
   int a=1;
   ��ʽ:
   ���� ������=new ����();
   ����������һ��Scanner��ı���
   
   Scanner sc =new Scanner();
   int a=1;
   ÿ���������ͣ������Լ��Ĺ��ܣ����ʹ�ù���
   ��ʽ��
    ����.���ܵ�����();
	
	Scanner������ã����������������н��ܼ��̵�����
	
	ʹ��Scanner��Ĳ��裺
	1.�������ָ�������ڵ��ļ��У��ؼ��� import
	JAVA�ļ���-util�ļ���
	2.��ʽ��������Scanner���͵ı���
	3.����.ʹ��Scanner���еĹ��ܣ���ɼ�������
	
*/
import java.util.Scanner;
public class ScannerDemo{
	public static void main(String args[]){
		//���� ������= new ����();
		//������Scanner�������
		Scanner sc=new Scanner(System.in);
		//����.��������()���ܼ�������
		//���ܣ�nextInt()���ܼ������룬��֤�����������
		//���ܽ��ܵ����ݾ����������������к�Ľ��������������
		
		int i=sc.nextInt();
		System.out.println(i);
		
		
		//Scanner�����һ������  next()���ܼ���������ַ���
		String s=sc.next();
		System.out.println(s);
	}
}