import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * ���й���ϵͳ��ʵ�֣�
 * 	1.��Ʒ���ݵĳ�ʼ��
 *  2.�û��Ĳ˵�ѡ��
 *  3.����ѡ��ִ�в�ͬ�Ĺ���
 *  	3.1Read  �鿴��Ʒ
 *  	3.2Creat  �����Ʒ
 *  	3.3Delete	ɾ����Ʒ	
 *  	3.4Update	�޸���Ʒ
 * 
 * */
public class Shopp {
	public static void main(String[] args) {
		// ����ArrayList����
		ArrayList<FruitItem> array = new ArrayList<FruitItem>();
		// ������Ʒ��ʼ�����������ݼ���
		init(array);
		// System.out.println(array);

		while (true) {
			// ���ò˵�����
			mainMenu();
			// �����û�ѡ����ŷ���
			int choose = chooseFunction();
			switch (choose) {
			case 1:
				// ���û����嵥
				showFruitList(array);
				break;
			case 2:
				addFruit(array);
				// ��ӻ���
			case 3:
				deleteFruit(array);
				// ɾ������
			case 4:
				updataFruit(array);
				// �޸Ļ���
			default:
				System.out.println("��������û��");
				break;
			}
		}
	}

	/*
	 * ���巽������Ʒ�޸Ĺ��� ����ֵ���� ����:����
	 * 
	 * 
	 * ��ʾ�û�ѡ������޸Ĺ��� 
	 * ��ʾ�û�������Ҫ�޸ĵ���Ʒ���
	 *  �������ϣ���ȡÿ��FruitItem���� ��������ID���ԣ�
	 *  ���Ժ��û�����ı�űȽ�
	 *   �����ͬ��
	 * �޸�FruitItem�е�����ֵ ��������
	 * 
	 * 
	 * 
	 */
	public static void updataFruit(ArrayList<FruitItem> array) {
		System.out.println("ѡ�������Ʒ�޸Ĺ���");
		System.out.println("��������Ʒ�ı��");
		Scanner sc = new Scanner(System.in);
		int ID=sc.nextInt();
		//��������
		for(int i=0;i<array.size();i++) {
			FruitItem item=array.get(i);
			//��ȡFruitItem��ID,���û������ID�Ƚ�
			if(ID==item.ID) {
				System.out.println("�������µ���Ʒ���");
				item.ID=sc.nextInt();
				System.out.println("�������µ���Ʒ����");
				item.name=sc.next();
				System.out.println("�������µ���Ʒ�۸�");
				item.price=sc.nextDouble();
				return;
				
			}	
		}
		System.out.println("�������Ʒ��Ų�����");
	}

	/*
	 * ���巽�������°���Ʒ��ӹ��� ��ʾ�û�ѡ����������Ʒ����
	 * 
	 * �����ؼ�FruitItem������������������ �������ÿ����Ʒ���Խ��и�ֵ
	 * 
	 * 
	 */
	public static void addFruit(ArrayList<FruitItem> array) {
		System.out.println("ѡ����������Ʒ����");
		// ����Scanner����
		Scanner sc = new Scanner(System.in);
		// ������Ʒ�ı��
		System.out.println("��������Ʒ�ı��");
		int ID = sc.nextInt();
		// �����Ʒ������
		System.out.println("��������Ʒ������");
		String name = sc.next();
		// ������Ʒ�ĵ���
		System.out.println("��������Ʒ�ĵ���");
		double price = sc.nextDouble();

		// ����FruitItem���͵ı���
		FruitItem item = new FruitItem();
		// item����
		item.ID = ID;
		item.name = name;
		item.price = price;
		array.add(item);
	}

	/*
	 * ���巽����������Ʒ��ɾ������ ����ֵ��
	 * 
	 * 
	 * ɾ������������Ʒ�ı�� ��ʾ�û�ѡ�����ɾ������ ����������Ʒ�ı�� �������ϣ���ȡ����ÿ��FruitItem���� ������������
	 * ID,���û�����ı�ŶԱȣ���ͬ��ɾ��
	 * 
	 * 
	 */
	public static void deleteFruit(ArrayList<FruitItem> array) {
		System.out.println("ѡ�����ɾ������");
		System.out.println("��������Ʒ�ı��");
		Scanner sc = new Scanner(System.in);

		int ID = sc.nextInt();
		// ��������
		for (int i = 0; i < array.size(); i++) {
			FruitItem item = array.get(i);
			// ��������id���ԣ����û�����ı�űȽ�
			if (item.ID == ID) {
				// �Ƴ������е�Ԫ��
				// ���ϵķ���removeʵ��
				array.remove(i);
				System.out.println("ɾ���ɹ�");
				return;
			}
		}
		System.out.println("���������Ʒ������");
	}

	/*
	 * ���巽������ʾ�����嵥���� ����ֵ �� ���� ���� �������ϣ���ȡ������ÿ��FruitItem������������������
	 * 
	 * 
	 */
	public static void showFruitList(ArrayList<FruitItem> array) {
		System.out.println();
		System.out.println("================��Ʒ����嵥================");
		System.out.println("��Ʒ���         ��Ʒ����                ��Ʒ����");
		// ��������
		for (int i = 0; i < array.size(); i++) {
			// ����get��������ȡ��ÿ��FruitItem����
			FruitItem item = array.get(i);
			// ��������
			System.out.println(item.ID + "      " + item.name + "           " + item.price);
		}
	}

	/*
	 * ���巽���������û��������� ���ر��
	 * 
	 * 
	 */
	public static int chooseFunction() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	/*
	 * ���巽������ʾ���˵� �ṩ���û���Щ��ѡ�� ����ֵ���� ����ֵ����
	 * 
	 * 
	 */
	public static void mainMenu() {
		System.out.println();
		System.out.println("============��ӭ����ItCast����============");
		System.out.println("1: ���� �嵥   2: ��ӻ���   3: ɾ������   4: �޸Ļ���  5: �˳�");
		System.out.println("��������Ҫ�����Ĺ������");
	}

	/*
	 * ���巽����ʵ�����ݳ�ʼ�� �Ƚ�һ�������ݣ��洢�������� ����ֵ:�� ����:���� ������:init
	 * 
	 * 
	 */
	public static void init(ArrayList<FruitItem> array) {
		// ���������FruitItem���ͣ����Ҹ�ֵ
		FruitItem f1 = new FruitItem();
		f1.ID = 9527;
		f1.name = "�������ֱ�";
		f1.price = 12.7;

		FruitItem f2 = new FruitItem();
		f2.ID = 9008;
		f2.name = "�п�����ĵ����";
		f2.price = 14.7;

		FruitItem f3 = new FruitItem();
		f3.ID = 9520;
		f3.name = "�½����ܹ�";
		f3.price = 122.7;
		// ������3��FruitInem������ӵ�������
		array.add(f1);
		array.add(f2);
		array.add(f3);
	}
}
