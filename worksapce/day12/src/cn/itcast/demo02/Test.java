package cn.itcast.demo02;

public class Test {

	public static void main(String[] args) {
		Worker w=new Worker("光头强",30);
		Student s=new Student("李阳",14);
		System.out.println(w.getName());
		System.out.println(w.getAge());
	}

}
