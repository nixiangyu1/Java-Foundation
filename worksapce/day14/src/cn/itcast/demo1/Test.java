package cn.itcast.demo1;

public class Test {
	public static void main(String[] args) {
		JingLi jl=new JingLi("С��","����001",10000.0);
		jl.work();
		
		
		FuWuYuan f1 = new FuWuYuan("�仨", "����Ա001");
		FuWuYuan f2 = new FuWuYuan("����", "����Ա002");
		f1.work();
		f1.services();
		f2.work();
		f2.services();
		
		ChuShi c1= new ChuShi("���","��ʦ001");
		ChuShi c2= new ChuShi("���","��ʦ002");
		c1.work();
		c1.services();
		c2.work();
		c2.services();
		
	}
}
