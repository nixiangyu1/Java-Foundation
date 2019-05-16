package cn.itcast.demo09;

public class Test {
	public static void main(String[] args) {
		//创建笔记本对象，拥有笔记本功能
		Computer com =new Computer();
		com.openComputer();
		
		//调用笔记本使用USB设备的方法
		//参数，是USB接口类型，接口不能建立对象
		//调用方法，传递USB接口的实现类对象
		com.useUSB(new Mouse());
		//使用USB设备，使用键盘
		com.useUSB(new Keyboard());
		
		com.closeComputer();
	}
}
