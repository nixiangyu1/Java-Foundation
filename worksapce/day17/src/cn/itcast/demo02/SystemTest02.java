package cn.itcast.demo02;
//练习二：将src数组中前3个元素，复制到dest数组的前3个位置上
public class SystemTest02 {
	public static void main(String[] args) {
		int[] src= {1,2,3,4,5};
		int[] dest= {3,4,5,6,7};
		System.arraycopy(src, 0, dest, 0, 3);
		for(int i =0;i<dest.length;i++) {
			System.out.print(dest[i]);
		}
	}
}
