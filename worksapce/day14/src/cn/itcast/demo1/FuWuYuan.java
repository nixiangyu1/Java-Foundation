package cn.itcast.demo1;

public class FuWuYuan extends Employee implements VIP{
	public FuWuYuan() {}
	public FuWuYuan(String name,String ID) {
		super(name,ID);	
	}
	
	
	
	
	public void work() {
		System.out.println("����Ա���");
	}
	public void services() {
		System.out.println("����Ա����");
	}
}
