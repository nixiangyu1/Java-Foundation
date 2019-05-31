/*
	实现随机点名器
	1.存储所有人的姓名
	2.预览所有学生的姓名，遍历数组
	3.随机数最为索引，到数组中找元素
	
	将功能独立出来，做成方法，调用方法即可
	
	定义三个功能,用到同一个姓名数据
	姓名存储到数组中，三个方法，使用一个数组中的数据，方法传递参数
    


*/


import java.util.Random;

public class CallName{
	public static void main(String args[]){
		//定义数组，存储学生姓名
		String[] names=new String[8];
		//调用添加姓名方法
		addStudent(names);
		//调用遍历数组方法
		printStudentName(names);
		//调用随机姓名方法
		System.out.println(randomStudentName(names));
	}
	
	
	/*
		定义方法，实现向数组中添加学生姓名
		返回值？没有
		参数是数组
	
	
	*/
	public static void addStudent(String[] names){
		names[0]="倪翔宇";
		names[1]="刘淑媛";
		names[2]="张三";
		names[3]="李四";
		names[4]="韩五";
		names[5]="李磊";
		names[6]="王六";
		names[7]="刘七";
	}
	
	
	/*
		定义方法，遍历数组
		返回值？没有
		参数？数组
	*/
	public static void printStudentName(String[] names){
		for(int i=0;i<names.length;i++){
			System.out.println(names[i]);
		}
	}
	
	
	
	/*
		定义方法，随机数，作为索引，在数组中找到学生姓名
		返回值？学生姓名
		参数？  数组
		
	
	*/
	public static String randomStudentName(String[] names){
		Random ran=new Random();
		int index=ran.nextInt(names.length);
		return names[index];
	}
	
}




