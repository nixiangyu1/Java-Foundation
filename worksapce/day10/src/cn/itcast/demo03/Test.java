package cn.itcast.demo03;
/*
 * 子类的对象，调用方法的时候
 * 	子类自己有，使用子类
 * 	子类自己没有，调用父类的
 * 
 * 
 * 方法的重写  Override
 * 	子类中，出现了和父类一模一样的方法的时候，子类重写父类的方法发
 */
public class Test {
	public static void main(String[] args) {
		Zi z=new Zi();
		z.show();
		z.show2();
	}
}
