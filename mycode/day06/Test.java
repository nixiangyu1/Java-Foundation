/*
	定义测试类
	  同时测试，电饭锅，学生，汽车

*/

public class Test{
	public static void main(String args[]){
		//创建电饭锅的引用类型
		DianFanGuo dfg=new DianFanGuo();
		
		dfg.brand="特斯拉";
		dfg.colour="红色";
		dfg.size=30;
		
		System.out.println(dfg.brand+" "+dfg.colour+" "+dfg.size);
		
		//创建汽车引用
		Car c=new Car();
		c.brand="兰博基尼";
		c.type="超跑";
		c.paiLiang=0.5;
		
		System.out.println(c.brand+" "+c.type+" "+c.paiLiang);
	}
}