/*
	ʵ�ֿ�������:
		1.�洢��Ʒ��Ϣ
			�洢��Ʒ��Ϣ
			����Ʒ���͵ı������洢��������
			
		2.�鿴����嵥
			�����Ͻ��б�������ȡ�������д洢��Goods���ͱ���
			���ÿһ��Goods���͵�����
			�������:�ܿ��,�����
		 
		3.�޸���Ʒ���
			���ϱ�������ȡ�������д����Goods���͵ı���
			��������Goods�������count,ֵ�����޸�(��������)
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Shopp{
	public static void main(String args[]){
		//����ArrayList���ϣ��洢Goods����
		ArrayList<Goods> array=new ArrayList<Goods>();
		//���������Ʒ��Ϣ�ķ���
		addGoods(array);
		//������ѭ��
		while(true){
			//����ѡ���ܵķ�������ȡ�û���������
			int number=chooseFunction();
			//������жϣ����=1 ����鿴��湦�� =2�����޸Ŀ�湦�� =3�˳�
			switch(number){
				case 1:
				//����鿴��淽��
				printStore(array);
				break;
				
				case 2:
				//�����޸Ŀ�湦��
				update(array);
				break;
				
				case 3:
				return;
				
				default:
				 System.out.println("�޴˹���");
				 break;
			}
		}
		
	}
	
	/*
		���巽����ʵ��ѡ��˵����û����ݹ���ѡ��˵�
	*/
	public static int chooseFunction(){
		System.out.println("-------------������------------");
		System.out.println("1.�鿴����嵥");
		System.out.println("2.�޸���Ʒ�������");
		System.out.println("3.�˳�");
		System.out.println("������Ҫִ�еĲ�����ţ�");
		Scanner sc=new Scanner(System.in);
		int number =sc.nextInt();
		return number;
	}
	
	/*
		�������壬�޸Ŀ��
		�������룬��Goods������count�������޸�(��������)
	*/
	public static void update(ArrayList<Goods> array){
		Scanner sc =new Scanner(System.in);
		//�������ϣ���ȡ�����е�ÿ��Ԫ��
		for(int i=0;i<array.size();i++){
			//���Ϸ���get��ȡ���Ǽ��ϵ�Ԫ��,Ԫ������Goods
			Goods g = array.get(i);
			System.out.println("������"+g.brand+"�����");
			//Goods���ԣ�count�����޸�
			g.count=sc.nextInt();
			
		}
	}
	
	
	/*
		���巽�����鿴����嵥����������
	*/
	public static void printStore(ArrayList<Goods> array){
		//�����ͷ
		System.out.println("--------------��Ʒ����嵥-----------------");
		System.out.println("Ʒ���ͺ�    �ߴ�    �۸�   �����");
		
		int totalCount=0;
		double totalMoney=0;
		//��������
		for(int i=0;i<array.size();i++){
			//get(����)��ȡ�������е�Ԫ�أ��洢����Goods�࣬��ȡ����Goods����
			Goods g=array.get(i);
			
			System.out.println(g.brand+" "+g.size+" "+g.price+" "+g.count);
			totalCount=totalCount+g.count;
			totalMoney=totalMoney+g.count*g.price;
		}
		System.out.println("�ܿ����:"+totalCount);
		System.out.println("��Ʒ����ܽ����:"+totalMoney);
		
	}
	
	
	/*
		���巽��������Ʒ����Ϣ�洢��������
		���������з����Ĺ������ݣ���������
	*/
	
	public static void addGoods(ArrayList<Goods> array){
		//��������Ʒ���͵ı���
		Goods g1=new Goods();
		Goods g2=new Goods();
		
		
		g1.size=13.3;
		g1.brand="Macbook";
		g1.price=9999.9;
		g1.count=3;
		
		g2.size=15.6;
		g2.brand="Thinkpad";
		g2.price=7999.9;
		g2.count=1;
		
		array.add(g1);
		array.add(g2);
	}
}