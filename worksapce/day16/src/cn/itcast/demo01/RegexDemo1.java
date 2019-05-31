package cn.itcast.demo01;

public class RegexDemo1 {
	public static void main(String[] args) {
//		split_1(); 
//		split_2(); 
		replaceAll_1();
	}
	
	
	/*
	 * String�෽��split���ַ��������и�
	 * 12-25-36-98 ����-���ַ��������и�
	 */
	public static void split_1() {
		String str="12-25-36-98 ";
		String[] strArr= str.split("-");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	
	/*
	 * String�෽��split���ַ��������и�
	 * 12   25   36  98���տո��и��ַ���
	 */
	public static void split_2() {
		String str="12   25   36  98 ";
		String[] strArr= str.split(" +");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	
	/*
	 * String�෽��split���ַ��������и�
	 * 192.168.105.27���տո��и��ַ���
	 * .��������ʽ������������ַ�
	 * ������ת��\\
	 * 
	 */
	public static void split_3() {
		String str="92.168.105.27";
		String[] strArr= str.split("\\.");
		for(int i=0;i<strArr.length;i++) {
			System.out.println(strArr[i]);
		}
	}
	/*
	 * "Hello12345World6789012"�������滻��
	 * String�෽��replaceAll(��������滻������ַ���)
	 */
	public static void replaceAll_1() {
		String str = "Hello12345World6789012";
		str=str.replaceAll("[\\d+]", "*");
		System.out.println(str);
	}
}
	