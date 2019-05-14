package cn.itcast.demo01;

/**
 * 类的方式,描述显示中的事物 小汽车
 * 
 * 		小汽车  属性和功能
 * 			属性：颜色  轮胎个数  变量定义
 * 			功能：跑  方法
 *		属性和方法，都属于类的成员
 *
 */
public class Car {
	//定义Car类中的属性
		
		//定义颜色属性
		String colour;
		//定义轮胎个数
		int count;
		
	//定义Car类中的方法
		public void run() {
			System.out.println("小汽车车在跑..."+colour+"..."+count);
			
		}
		
}
