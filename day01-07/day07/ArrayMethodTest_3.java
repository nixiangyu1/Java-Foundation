/*
  数组的排序: 一般都是升序排列,元素,小到大的排列
  
  两种排序的方式
     选择排序: 数组的每个元素都进行比较
	 冒泡排序: 数组中相邻元素进行比较
	 规则: 比较大小,位置交换
*/






public class ArrayMethodTest_3{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//调用冒泡排序方法
		bubbleSort(arr);
		//调用打印方法
		printArray(arr);
	
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