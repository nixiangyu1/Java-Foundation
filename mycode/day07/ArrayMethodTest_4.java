/*
	数组的折半查找
*/

import java.util.Scanner;




public class ArrayMethodTest_4{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//调用冒泡排序方法
		bubbleSort(arr);
		//调用打印方法
		printArray(arr);
		System.out.println();
		System.out.println("请输入您要查找的整数，如果在数组中有的话，系统会返回数组下标");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int index=binarySearch(arr,n);
		System.out.println(index);
	
	}
	
	/*
		定义方法，实现，折半查找
		返回值：索引
		参数：数组，被找的元素
		实现步骤：
			1.需要的变量定义
				三个指针
			2.进行循环折半
				可以折半的条件 min<=max
			3.让被找的元素，和中间索引元素进行比较
				元素大于中间索引  min=mid+1
				元素小于中间索引  max=mid-1
				元素等于中间索引  找到了，结束了，返回中间索引
			4.循环结束，无法折半
				元素没有找到，返回-1
		
	*/
	public static int binarySearch(int[] arr,int key){
		//定义三个指针变量
		int min=0;
		int max=arr.length-1;
		int mid=0;
		//循环折半，条件 min<=max
		while(min<=max){
			//公式，计算中间索引
			mid=(min+max)/2;
			//让被找元素和中间元素进行比较
			if(key>arr[mid]){
				min=mid+1;
			}else if(key<arr[mid]){
				max=mid-1;
			}else if(key==arr[mid]){
				//找到元素，返回mid索引
				return mid;
			}
			
		}
		return -1;
	}
	
	/*
		定义方法，实现数组的冒泡排序
		返回值：没有
		参数:数组的排序
		
				
	*/
	public static void bubbleSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			//每次内循环的比较，从0开始
			for(int j=0;j<arr.length-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					
				}
			}
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