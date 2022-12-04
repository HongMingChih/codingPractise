package tw.com.deyi.d1125;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class NumberReverse {

//	private static final BigDecimal cuurentYearTax = null;
//	private static final BigDecimal lastTax = null;

	public static void main(String[] args) {
		// 4321.4231->1234.1234
		/*
		 * 整數部分 小數部分
		 * 
		 * 4*1=4 3*10=30 2*100=200 1*1000=1000
		 * 
		 * 
		 * 4/10000=0.0004 3/1000=0.003 2/100=0.0 2/100=0.2 1/10=0.1
		 * 
		 */

		// 1234
		// Create two new BigDecimals
		String number = "456.123456789";

		BigDecimal numberReverse = numberReverse(number);
		// 984.127
		System.out.println(numberReverse);// 印出結果2984.5127
	}

	public static BigDecimal numberReverse(String number) {
//		StringBuilder sb = new StringBuilder();
//		sb.reverse();
		String[] numberArray = number.split("[.]");

		String[] pInteger = numberArray[0].split("");// 左整數

		String[] pFloat = numberArray[1].split("");// 右小數

		BigDecimal Intresult = new BigDecimal("0");
		
		for (int j = 0; j < pInteger.length; j++) {

			String u = pInteger[j];
			String d = String.valueOf((int) Math.pow(10, j));
			BigDecimal u_d = new BigDecimal(u).multiply(new BigDecimal(d));

			System.out.println(u + "*" + d + "=" + u_d);

			Intresult = Intresult.add(u_d);
			//

		}

		System.out.println("-------------------------------------");
		
		BigDecimal Floatresult = new BigDecimal("0");// 小數點右邊
		
		int k = pFloat.length;
		if (k>9) {
			System.out.println("請輸入 9 位以內浮點數。"+"當前位數: "+k);
			BigDecimal r_e= new BigDecimal(0);
			return r_e;
		}
		for (int i = 0; i < pFloat.length; i++) {

			String s = pFloat[i];
			
			String b = String.valueOf((int) Math.pow(10, k));
			BigDecimal u_d = new BigDecimal(s).divide(new BigDecimal(b));
			

			System.out.println(s + "/" + b + "=" + u_d.toPlainString());

			Floatresult = Floatresult.add(u_d);
			k--;
		}
		System.out.println("------------------------");

		return Intresult.add(Floatresult);

	}

}

//
//
