package cn.itcast.demo2;
/*
 * ��ϰ��int[] arr = {34,12,89,68};��һ��int[]��Ԫ��ת���ַ���  ��ʽ [34,12,89,68]
 */
public class StringTest {
	public static void main(String[] args) {
		int[] arr = {34,12,89,68};
		toString(arr);
	}
	public static void toString(int[] arr) {
		StringBuffer buffer=new StringBuffer();
		buffer.append("[");
		for(int i=0;i<arr.length;i++) {
			
			if(i==arr.length-1) {
				buffer.append(arr[i]+"]");
			}else {
				buffer.append(arr[i]+",");
			}
		}

		System.out.println(buffer);
	}
}
