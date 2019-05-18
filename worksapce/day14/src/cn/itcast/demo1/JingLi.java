package cn.itcast.demo1;

public class JingLi extends Employee {
	public JingLi() {
		
	}
	public JingLi(String name,String ID,double money) {
		super(name,ID);
		this.money=money;
	}
	private double money;
	public void work() {
		System.out.println("经理在工作");
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
