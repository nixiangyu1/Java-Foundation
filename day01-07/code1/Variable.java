/*
   定义JAVA中的变量
   定义出所有数据类型的变量
   四类八种
*/


public class Variable{
	public static void main(String args[]){
	    //定义整数类型，字节类型 byte类型
		//内存中1个字节。-128  127
		byte b=100;
		System.out.println(b);
		//定义整数类型，短整型,short类型
		//内存中2个字节，-32768 32767
		short s=200;
		System.out.println(s);
		
		//定义整数类型，整型，int类型
		//内存中4个字节，
		int i=200002;
		System.out.println(i);
		
		
		//定义整数类型，长整型，int类型
		//内存中4个字节，
		long l=20000223123123123L;
		System.out.println(l);
		
		//定义浮点类型 ，单精度 float类型
		//内存中4个字节
		float f=1.0F;
		System.out.println(f);
		
		
		 //被转后的数据类型 变量名=（被转后的数据类型）要被转的数据
        i =(int)f;
        System.out.println(i);
	}
}