package cn.itcast.demo08;

public class Test {
	public static void main(String[] args) {
		JavaEE ee=new JavaEE();
		
		ee.setName("����");
		ee.setId("�з���01");
		System.out.println(ee.getName()+".."+ee.getId());
		ee.work();
	}
}
