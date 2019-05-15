package cn.itcast.demo01;

public class Test {

	public static void main(String[] args) {
		//创建研发员工类的对象
		Develop d=new Develop();
		//字类的对象，d能否调用父类中的成员
		d.name="张三";
		d.print();
	}

}
