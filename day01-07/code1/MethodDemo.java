/*
    �������õ���ϰ
	 
*/
import java.util.Scanner;
public class MethodDemo{
	public static void main(String args[]){
		
		printRect();
		System.out.println(getNumber());
		printRect2(3,4);
	}
	
	
	
	/*
		    �����޷���ֵ���޲������������ӡ3�У�ÿ��3��*�ŵľ���
			Ϊʲôû�з���ֵ��
			     ��ӡ�������Ч��������Ҫ���ӹܷ���
				 ��ȷδ֪��:����Ҫδ֪��
		*/
	public static void printRect(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	/*
		 �����з���ֵ�޲��������������¼��õ�һ������
		 ��ȷ���������������������int
		 ��ȷ��û��δ֪��
		*/
	public static int getNumber(){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		return number;
	}
	
	
	
	/*
		�����޷���ֵ�в������������ӡָ��M�У�ÿ��N��*�ŵľ���
		��ȷ�����������������̨���ͼ��û�з���ֵ��
		
	
	
	*/
	public static void printRect2(int m,int n){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}