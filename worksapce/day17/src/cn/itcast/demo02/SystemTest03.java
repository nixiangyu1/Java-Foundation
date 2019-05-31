package cn.itcast.demo02;

import java.util.Random;

//练习三：循环生成100-999之间的的三位数并进行打印该数，当该数能被10整除时，结束运行的程序
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
