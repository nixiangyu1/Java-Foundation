/*
   实现猜数字的小游戏
    随机一个数字，让用户猜
	结果三种情况:
	中了，大了,笑了
   随机数:Random
   接盘输入:Scanner
   猜的数字和随机数进行比较，用if做判断
   知道猜中为止，反复去猜，循环while
*/
import java.util.Random;
import java.util.Scanner;
public class GuestNumber{
	public static void main(String args[]){
	System.out.println("游戏开始，系统将会生产1-100的数字，猜猜这个数吧！");
	System.out.println("请输入您猜的数字：");
	//创建random类的对象
	Random ran=new Random();
	//变量.使用功能nextInt()获取1-100的随机数
	int ranNumber=ran.nextInt(100)+1;
	System.out.println(ranNumber);
	//创建Scanner类的对象	
	Scanner sc=new Scanner(System.in);
	
	while(true){
		//获取键盘输入
		int number=sc.nextInt();
		if(number>ranNumber){
			System.out.println("猜大了");
		}else if(number<ranNumber){
			System.out.println("猜小了");
			
		}else{
			System.out.println("猜中了");
			break;
		}
	}
	
	}
}

