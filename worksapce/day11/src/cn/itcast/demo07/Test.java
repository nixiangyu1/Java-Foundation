package cn.itcast.demo07;
/*
 * 运算符  比较运算符  结果真假值
 * 关键字 instanceof,比较引用数据类型
 * p变量，是Student类型变量，还是Teacher类型变量
 * 
 * 	引用变量 instanceof 类名
 * 	p instanceof Student 比较，p是不是Student类型对象
 *  如果是，返回true
 */
public class Test {
	public static void main(String[] args) {
		People p= new Student();
		p.sleep();
	}
}
