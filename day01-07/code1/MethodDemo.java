/*
    方法调用的练习
	 
*/
import java.util.Scanner;
public class MethodDemo{
	public static void main(String args[]){
		
		printRect();
		System.out.println(getNumber());
		printRect2(3,4);
	}
	
	
	
	/*
		    定义无返回值的无参数方法，如打印3行，每行3个*号的矩阵
			为什么没有返回值：
			     打印矩阵，输出效果，不需要将接管返回
				 明确未知数:不需要未知数
		*/
	public static void printRect(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	
	/*
		 定义有返回值无参数方法，如键盘录入得到一个整数
		 明确方法计算后结果的数据类型int
		 明确有没有未知数
		*/
	public static int getNumber(){
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		return number;
	}
	
	
	
	/*
		定义无返回值有参数方法，如打印指定M行，每行N个*号的矩阵
		明确方法计算后结果，控制台输出图像，没有返回值的
		
	
	
	*/
	public static void printRect2(int m,int n){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}