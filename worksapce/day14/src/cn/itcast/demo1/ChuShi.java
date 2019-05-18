package cn.itcast.demo1;
/*
 * 属于员工的一种，有额外服务功能
 * 继承Employee,实现VIP金额口
 */
public class ChuShi extends Employee implements VIP {
	//空参构造方法
	public ChuShi() {}
	//满参构造方法
	public ChuShi(String name,String ID) {
		super(name,ID);
	}
	
	
	
	public void work() {
		System.out.println("厨师在炒菜");
	}
	public void services() {
		System.out.println("厨师做菜加量");
	}
}
