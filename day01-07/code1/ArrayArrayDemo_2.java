/*
   二维数组的遍历
*/
import java.util.Random;
public class ArrayArrayDemo_2{
	public static void main(String args[]){
		String[] names={"倪翔宇","刘淑媛","张旭","孙天龙"};
		
		//遍历人名
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
		
		
		//分割线
		System.out.println("=========");
		
		Random ran=new Random();
		int index=ran.nextInt(names.length);
		System.out.println(names[index]);
		
		
	}
}