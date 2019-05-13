/*
	定义方法，实现数组的遍历
	遍历中，输出结果[11,33.565,66,78,89]
	int[] arr={3,4,45,7};
	结果包含字符串，[].
	实现步骤:
		1.定义方法实现数组的遍历
		2.先打印[中括号
		3.遍历数组
			输出数组的元素和逗号
			判断是否遍历到了数组的最后一个元素，如果是最后一个元素，不答应逗号
*/
public class ArrayMethodTest{
	public static void main(String args[]){
		int [] arr={11,22,33,44,55};
		printArray(arr);
		
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

	