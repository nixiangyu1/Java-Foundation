package cn.itcast.demo02;

import java.util.Random;

//��ϰ����ѭ������100-999֮��ĵ���λ�������д�ӡ�������������ܱ�10����ʱ���������еĳ���
public class SystemTest03 {
	public static void main(String[] args) {
		Random random =new Random();
		while(true) {
			int number = random.nextInt(900)+100;
			System.out.println(number);
			if(number%10==0) {
				System.exit(0);
			}
		}
	}
}
