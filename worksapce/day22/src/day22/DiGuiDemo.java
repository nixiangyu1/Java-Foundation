package day22;

public class DiGuiDemo {

	public static void main(String[] args) {
//		int sum=getSum(100);
//		System.out.println(sum);
		System.out.println(getFBNQ(12));
	}
	//≤ªÀ¿…ÒÕ√ 
	public static int getFBNQ(int month) {
		if(month==1) {
			return 1;
		}
		if(month==2) {
			return 1;
		}
		return getFBNQ(month-1)+getFBNQ(month-2);
	}
	
	
	
	///
	public static int getJieCheng(int n) {
		if(n==1)
			return n;
		return n*getJieCheng(n-1);
	
	}
	
	
	
	public static int getSum(int n) {
		if(n==1)
			return n ;
		return n+getSum(n-1);
	}
	
	
}
