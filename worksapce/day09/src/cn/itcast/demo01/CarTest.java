package cn.itcast.demo01;

/**
 * 测试，自定义的类Car
 * 创建出Car类的变量
 * 变量，调用属性，成员变量
 * 变量，调用方法
 *
 */
public class CarTest {

	public static void main(String[] args) {
		//创建出Car类的对象
		Car c=new Car();
		//对象.调用类中的属性和方法
		c.colour="无色";
		c.count=5;
		c.run();
	}

}
