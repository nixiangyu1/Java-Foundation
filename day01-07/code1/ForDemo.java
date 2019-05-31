/*
   利用for循环，计算1到4的结果；
*/
public class ForDemo{
	public static void main(String agrs[]){
		//定义变量，用来记录和的数据
		int sum=0;
		//利用循环，将变量从1变化到4
		for(int i=1;i<5;i++){
			sum+=i;
		}
		System.out.println(sum);
	}
}