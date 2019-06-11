package cn.itcast.gjp.view;
/*
 * ��ͼ�㣬�û������Ͳ����Ľ���
 * ���ݴ��ݸ�controller��ʵ��
 * ��Աλ�ã�����controller�����
 * 
 */

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	
	
	
	
	
	
	/*
	 * ʵ�ֽ���Ч��
	 * �����û�����
	 * �������ݣ����ò�ͬ�Ĺ��ܷ���
	 */
	public void run() {
		//����Scanner��Ķ��󣬷�����������
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			//�����û��Ĳ˵�ѡ��
			int choose =sc.nextInt();
			//��ѡ������жϣ����ò�ͬ�Ĺ���
			switch(choose) {
			case 1:
				//ѡ��������񣬵����������ķ���
				addZhangWu();
				break;
			case 2:
				//ѡ��༭���񣬵��ñ༭����ķ���
				editZhangWu();
				break;
			case 3:
				//ѡ��ɾ�����񣬵���ɾ������ķ���
				deleteZhangWu();
				break;
			case 4:
				selectZhangWu();
				//ѡ���ѯ���񣬵��ò�ѯ����ķ���
				break;
			case 5:
				//ѡ���˳�ϵͳ
				System.exit(0);
				break;
			
			}
		}
	}
	/*
	 * ���巽����ʵ������ɾ��
	 * ʵ��˼�룺
	 * �����û�������
	 * ���ݵ���Ϣ����װ��ZhangWu����
	 * ���ÿ��Ʋ�ķ���������ZhangWu����ʵ�ֱ༭
	 * 
	 */
	public void deleteZhangWu() {
		//���ò�ѯ��������Ĺ��ܣ���ʾ����
		//�������������ݣ�����ѡ��һ�У������ϴγ�
		selectAll();
		System.out.println("ѡ�����ɾ�����ܣ��������");
		int zwid = new Scanner(System.in).nextInt();
		//���ÿ��Ʋ㷽������������
		controller.deleteZhangWu(zwid);
		System.out.println("ɾ������ɹ�");
	}
	/*
	 * ���巽����ʵ�ֶ�����ı༭����
	 * ʵ��˼��:
	 * 	�����û�������
	 * 	���ݵ���Ϣ����װ��ZhangWu����
	 * ���ÿ��Ʋ㷽��������ZhangWu����ʵ�ֱ༭
	 */
	public void editZhangWu() {
		/*
		 * ���ò�ѯ�����������ݵĹ��ܣ���ʾ����
		 * �����������ݣ���������ѡ��һ�У������޸�
		 */
		selectAll();
		System.out.println("ѡ����Ǳ༭���ܣ�����������");
		Scanner sc = new Scanner(System.in);
		//�����û�������
		System.out.println("����ID");
		int zwid = sc.nextInt();
		System.out.println("�����������");
		String flname=sc.next();
		System.out.println("������");
		double money =sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu =sc.next();
		System.out.println("��������:��ʽxxxx-xx-xx");
		String createtime = sc.next();
		System.out.println("������������");
		String description =sc.next();
		//�������û���������ݣ���װ��ZhangWu������
		//�����ID�������װ������
		ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		//����controller���еķ�����ʵ�ֱ༭
		controller.editZhangWu(zw);
		System.out.println("����༭�ɹ�");
	}
	
	/*
	 * ���巽�� addZhangWu
	 * �������ķ���,�û��ڽ�����ѡ��˵�1��ʱ�����
	 * ʵ��˼��:
	 * ���ܼ������룬5������,����controller�㷽��
	 */
	public void addZhangWu() {
		System.out.println("ѡ�����������ܣ���������������");
		Scanner sc = new Scanner(System.in);
		System.out.println("�����������");
		String flname=sc.next();
		System.out.println("������");
		double money =sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu =sc.next();
		System.out.println("��������:��ʽxxxx-xx-xx");
		String createtime = sc.next();
		System.out.println("������������");
		String description =sc.next();
		//�����ܵ������ݣ�����controller��ķ��������ݲ���
		//���û���������в�������װ��ZhangWu����
		ZhangWu zw = new ZhangWu(0, flname, money, zhanghu, createtime, description);
		controller.addZhangWu(zw);
		System.out.println("��ϲ���������ɹ�");
	}
	
	
	
	/*
	 * ���巽��selectZhangWu()
	 * ��ʾ��ѯ�ķ�ʽ1.���в�ѯ2.������ѯ
	 * �����û���ѡ��
	 */
	public void selectZhangWu() {
		System.out.println("1.��ѯ����   2.������ѯ");
		Scanner sc= new Scanner(System.in);
		int selectChooser = sc.nextInt();
		//�жϸ����û���ѡ�񣬵��ò�ͬ�Ĺ���
		switch(selectChooser) {
		case 1:
			//ѡ��Ĳ�ѯ���У����ò�ѯ���еķ���
			selectAll();
			break;
		case 2:
			//ѡ���������ѯ�����ò���в�ѯ�����ķ���
			select();
			break;
		}
	}
	
	
	/*
	 * ���巽����ʵ�ֲ�ѯ���е���������
	 */
	
	public void selectAll() {
		//���ÿ��Ʋ�ķ�������ѯ���е���������
		List<ZhangWu> list=controller .selectAll();
		if(list.size()!=0)
			print(list);
		else
			System.out.println("û�в�ѯ������");
		
	}
	
	
	//����������ݷ���������List���ϣ��������ϣ�������
	private void print(List<ZhangWu> list) {
		//�������
		System.out.println("ID\t\t���\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
		//�������ϣ�����������̨
		for(ZhangWu zw:list) {
			System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+
		zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription()
		);
		}
	}
	
	
	/*
	 * ���巽����ʵ��������ѯ��������
	 * �ṩ�û����������ڣ���ʼ���ںͽ�������
	 * ���������ڣ����ݵ�controller��
	 * ����controllerde�����������������ڲ���
	 */
	public void select() {
		System.out.println("ѡ��������ѯ,�������ڸ�ʽxxxx-xx-xx");
		System.out.println("�����뿪ʼ����:");
		Scanner sc = new Scanner(System.in);
		String startDate=sc.nextLine();
		System.out.println("�������������:"); 
		String  endDate = sc.nextLine();
		//����controller��ķ���������2�����ڲ���
		//��ȡ��controller��ѯ�Ľ����
		List<ZhangWu> list=controller.select(startDate, endDate);
		if(list.size()!=0)
			print(list);
		else
			System.out.println("û�в�ѯ������");
	}
}
