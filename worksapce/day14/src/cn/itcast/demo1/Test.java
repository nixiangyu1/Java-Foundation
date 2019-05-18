package cn.itcast.demo1;

public class Test {
	public static void main(String[] args) {
		JingLi jl=new JingLi("小明","经理001",10000.0);
		jl.work();
		
		
		FuWuYuan f1 = new FuWuYuan("翠花", "服务员001");
		FuWuYuan f2 = new FuWuYuan("明珠", "服务员002");
		f1.work();
		f1.services();
		f2.work();
		f2.services();
		
		ChuShi c1= new ChuShi("猪大","厨师001");
		ChuShi c2= new ChuShi("猪二","厨师002");
		c1.work();
		c1.services();
		c2.work();
		c2.services();
		
	}
}
