package cn.itcast.demo06;
/*
 * 定义类开发工程师类
 * 		EE开发工程师
 * 		Android开发工程师
 * 
 * 		根据共性进行抽取，然后形成一个父类Develop
 * 		定义方法，工作:怎么工作，具体干什么
 * 
 * 
 * 		抽象类，不能实例化对象，不能new
 * 		抽象类的使用方式:定义类继承抽象类，将抽象类方法进行重写，创建子类的对象
 */
public abstract class Develop {
	//定义方法工作方法，但是怎么工作，说不清楚
	//不说,方法是没有主题的方法，必须使用关键字abstract修饰
	//抽象的方法，必须存在抽象的类中，类也必须用abstract修饰
	public abstract void work();
}
