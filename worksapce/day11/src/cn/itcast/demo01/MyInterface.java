package cn.itcast.demo01;
/*
 * 定义接口
 * 	使用关键字interface 接口名字
 * 接口定义:
 * 		成员方法，全抽象
 * 		不能定义带有方法体的方法
 * 
 * 定义抽象方法:固定格式
 * 	public abstract 返回值类型 方法名字(参数列表)
 * 
 * 接口成员变量的定义
 * 	成员变量的定义，具体要求
 * 	要求:必须定义位常量
 * 固定格式:
 * 	public static final 数据类型 变量值=值
 * 
 */
public interface MyInterface {
	//在接口中，定义抽象的方法
	public abstract void function();
	
}
