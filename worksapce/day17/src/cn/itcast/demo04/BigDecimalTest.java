package cn.itcast.demo04;

import java.math.BigDecimal;

public class BigDecimalTest {
	public static void main(String[] args) {
		function_1();
	}
	//实现 BigDecimal的除法
	public static void function() {
		BigDecimal a = new BigDecimal("134.123");
		BigDecimal b = new BigDecimal("100");
		BigDecimal bigDiv=a.divide(b,2,BigDecimal.ROUND_HALF_UP);
		System.out.println(bigDiv);
		
		
	}
	//实现BigDecimal的乘法
	public static void function_1() {
		BigDecimal a = new BigDecimal("134.123");
		BigDecimal b = new BigDecimal("100");
		BigDecimal bigMul=a.multiply(b);
		System.out.println(bigMul);
		
	}
}
