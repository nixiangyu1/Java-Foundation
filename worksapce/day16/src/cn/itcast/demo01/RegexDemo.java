package cn.itcast.demo01;

public class RegexDemo {
	public static void main(String[] args) {
		cheakQQ();
		checkTell();
	}
	
	
	/*
	 * ����ֻ������Ƿ�Ϸ�
	 * 1��ͷ ������34578 0-9 �̶�11λ
	 * 
	 */
	public static void checkTell() {
		String tellNumber="13772831018";
		//String��ķ���matches
		boolean b = tellNumber.matches("1[34578][0-9]{9}");
		System.out.println(b);
	}
	/*
	 * ���qq�����Ƿ�Ϸ� 0���ܿ�ͷ��ȫ�Ǻ��ӣ�Ϊ��5��10 123456
	 */
	public static void cheakQQ() {
		String QQ = "123456";
		boolean b = QQ.matches("[1-9][\\d]{4,9}");
		System.out.println(b);
	}
}