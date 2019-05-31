package cn.itcast.demo02;
//练习一：验证for循环打印数字1-9999所需要使用的时间（毫秒）
public class SystemTest {
	public static void main(String[] args) {
		long start1 =System.currentTimeMillis();
		for(int i=1;i<10000;i++) {
			System.out.println(i);
		}
		long end1 = System.currentTimeMillis();
		System.out.println("耗时："+(end1-start1));
	}
}
