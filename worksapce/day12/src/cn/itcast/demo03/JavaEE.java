package cn.itcast.demo03;

public class JavaEE extends Developer {
	public JavaEE(String name,String ID) {
		super(name,ID);
	}
	public void work() {
		System.out.println(super.getName()+"  "+super.getID()+"  "+"正在开发淘宝");
	}
}
