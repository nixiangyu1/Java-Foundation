/*
      ʵ����Ʒ����嵥����
	    ���裺
		1.ʵ�ֱ�ͷ���ǹ̶����ݣ�ֱ��д������
		2.����м䣬��Ʒ���ݣ����ñ�������ʽ ����������Ҷ����ݽṹ
		   ������б���
		3.���β�ͣ�һ�����ǹ̶����ݣ���һ������Ʒ������Ҫ����
*/
public class Shop{
	public static void main(String args[]){
		//�����ͷ�̶�����
		System.out.println("--------------��Ʒ����嵥-----------------");
		System.out.println("Ʒ���ͺ�    �ߴ�    �۸�   �����");
		//�������е����ݱ���
		//Ʒ���ͺţ�string �ߴ�double   �۸� double �����   int
		String macBrand="MacBookAir";
		double macSize=13.3;
		double macPrice=6988.8;
		int macCount=5;
		
		String thinkBrand="ThinkPadT450";
		double thinkSize=14.0;
		double thinkPrice=5999.9;
		int thinkCount=10;
		
		
		String asusBrand="ASUS-FL5800";
		double asusSize=15.6;
		double asusPrice=4999.5;
		int  asusCount=18;
		
		//����Ʒ��Ϣ�������д�ӡ������֮�����һ�����ַ����ո�
	     System.out.println(macBrand+"   "+macSize+"   "+macPrice+"   "+macCount);
	     System.out.println(thinkBrand+" "+thinkSize+"   "+thinkPrice+"   "+thinkCount);
	     System.out.println(asusBrand+"  "+asusSize+"   "+asusPrice+"   "+asusCount);
		
		//�����ܿ������������Ʒ�����
		int totalCount=macCount+thinkCount+asusCount;
		//����������Ʒ�Ľ������ÿ����Ʒ�۸�*��Ʒ����
		double totalMoney=macCount*macPrice+thinkCount*thinkPrice+asusPrice*asusCount;
		
		//��������
		System.out.println("�ܿ������"+totalCount);
		//��������Ʒ�ܽ����
		System.out.println("��Ʒ����ܽ�"+totalMoney);
		
	}
}