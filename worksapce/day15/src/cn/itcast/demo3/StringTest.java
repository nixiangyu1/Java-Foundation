package cn.itcast.demo3;

public class StringTest {
	public static void main(String[] args) {
		String s1 = new String(); //����String�����ַ�����û������
		
		byte[] bys = new byte[]{97,98,99,100};
		String s2 = new String(bys); // ����String���󣬰�����Ԫ����Ϊ�ַ���������
		String s3 = new String(bys, 1, 3); //����String���󣬰�һ��������Ԫ����Ϊ�ַ��������ݣ�����offsetΪ����Ԫ�ص���ʼ����λ�ã�����lengthΪҪ����Ԫ��
			
		char[] chs = new char[]{'a','b','c','d','e','f'};
		String s4 = new String(chs); //����String���󣬰�����Ԫ����Ϊ�ַ���������
		String s5 = new String(chs, 0, 3);//����String���󣬰�һ��������Ԫ����Ϊ�ַ��������ݣ�����offsetΪ����Ԫ�ص���ʼ����λ�ã�����countΪҪ����Ԫ��

		String s6 = new String("abc"); //����String�����ַ�������Ϊabc
		System.out.println(s4);
	}
}
