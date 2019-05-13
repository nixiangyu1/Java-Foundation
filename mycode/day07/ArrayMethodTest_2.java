/*
	数组的排序:一般都是升序排序，元素，小到大的排序
	
	
	两种排序方式
		选择排序：数组的每个元素都进行比较
		冒泡排序：数组中相邻元素进行比较
		规则:比较大小，位置交换
*/





public class ArrayMethodTest_2{
	public static void main(String args[]){
		int[] arr={55,123,24,23,3,5,6};
		//调用选择排序方法
		selectSort(arr);
		//调用打印方法
		printArray(arr);
	
	}
	
	
	/*
		定义方法，实现数组的选择排序
		返回值：没有
		参数:数组的排序
		实现步骤:
			1.嵌套循环实现排序
				外循环，控制的是一共比较多少次
				内循环，控制的是每次比较了多少个元素
			2.判断元素的大小值
			  小值，存储到小的索引
				
	*/
	public static void selectSort(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				//数组的元素进行判断
				if(arr[i]>arr[j]){
					//数组换位
					int temp=arr[j];
					arr[j]=arr[i];
					arr[i]=temp;
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