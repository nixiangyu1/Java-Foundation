package cn.itcast.demo03;

public class Android extends Developer{
	public Android(String name, String ID) {
		super(name, ID);
		
	}
	
	public void work() {
		System.out.println(super.getName()+"  "+super.getID()+"  "+"正在开发安卓");
	}
}
