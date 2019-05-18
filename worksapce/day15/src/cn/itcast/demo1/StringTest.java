package cn.itcast.demo1;

public class StringTest {
	public static void main(String[] args) {
		System.out.println(getStringCount("hellojava,nihaojava,javazhenbang", "java"));
	}
	public static int getStringCount(String str,String key){
		int count=0;
		int index=0;
		while((index=str.indexOf(key))!=-1) {
			count++;
			str=str.substring(index+key.length());
		}
		
		return count;
	}
}