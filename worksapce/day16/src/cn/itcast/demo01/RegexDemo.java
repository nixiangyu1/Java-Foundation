package cn.itcast.demo01;

public class RegexDemo {
	public static void main(String[] args) {
		cheakQQ();
		checkTell();
	}
	
	
	/*
	 * 检查手机号码是否合法
	 * 1开头 可以是34578 0-9 固定11位
	 * 
	 */
	public static void checkTell() {
		String tellNumber="13772831018";
		//String类的方法matches
		boolean b = tellNumber.matches("1[34578][0-9]{9}");
		System.out.println(b);
	}
	/*
	 * 检查qq号码是否合法 0不能开头，全是胡子，为主5，10 123456
	 */
	public static void cheakQQ() {
		String QQ = "123456";
		boolean b = QQ.matches("[1-9][\\d]{4,9}");
		System.out.println(b);
	}
}