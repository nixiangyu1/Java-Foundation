/*
   ʵ�ֲ����ֵ�С��Ϸ
    ���һ�����֣����û���
	����������:
	���ˣ�����,Ц��
   �����:Random
   ��������:Scanner
   �µ����ֺ���������бȽϣ���if���ж�
   ֪������Ϊֹ������ȥ�£�ѭ��while
*/
import java.util.Random;
import java.util.Scanner;
public class GuestNumber{
	public static void main(String args[]){
	System.out.println("��Ϸ��ʼ��ϵͳ��������1-100�����֣��²�������ɣ�");
	System.out.println("���������µ����֣�");
	//����random��Ķ���
	Random ran=new Random();
	//����.ʹ�ù���nextInt()��ȡ1-100�������
	int ranNumber=ran.nextInt(100)+1;
	System.out.println(ranNumber);
	//����Scanner��Ķ���	
	Scanner sc=new Scanner(System.in);
	
	while(true){
		//��ȡ��������
		int number=sc.nextInt();
		if(number>ranNumber){
			System.out.println("�´���");
		}else if(number<ranNumber){
			System.out.println("��С��");
			
		}else{
			System.out.println("������");
			break;
		}
	}
	
	}
}

