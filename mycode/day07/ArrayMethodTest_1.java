/*
	数组的逆序
	数组中的元素，进行位置上的交换
	逆序 不等于 逆序输出
	就是数组中最远的两个索引，进行位置交换，实现数组的逆序
	使用的是数组的指针思想，就是变量，
	反转 reverse
	
*/

public class ArrayMethodTest_1{
	public static void main(String args[]){
		int[] arr={1,2,3,4};
		reverse(arr);
		printArray(arr);
	
	}


	/*
		定义方法，实现数组的逆序
		返回值：没有返回值
		参数：数组
		
	*/
	
	public static void reverse(int[] arr){
		//循环遍历
		for(int min=0,max=arr.length-1;min<max;min++,max--){
			//对数组中的元素进行位置交换
			//min索引和max索引的元素交换
			//定义变量，作为临时变量
			int temp=arr[min];
			arr[min]=arr[max];
			arr[max]=temp;
			
		}
		
	}
	
	/*
		定义方法，实现功能
		返回值:void
		方法参数：数组
	*/
	public static void printArray(int[] arr){
		//输出半边括号，不要换行
		System.out.print("[");
		//数组遍历
		for(int i=0;i<arr.length;i++){
			//判断数组是不是最后一个元素
			if(i==arr.length-1){
				System.out.print(arr[i]+"]");
				
			}else{
				System.out.print(arr[i]+",");
			}
			
		}
		
	}
}