package tw.com.deyi.d1116;

import java.math.BigDecimal;

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
//		String number = "4892.7215";
		String number = "123456.123456";

		BigDecimal numberReverse = numberReverse(number);
		System.out.println(numberReverse);
		// 984.127
		// System.out.println(numberReverse);
	}

	public static BigDecimal numberReverse(String number) {
//		StringBuilder sb = new StringBuilder();
//		sb.reverse();

		String[] numberArray = number.split("[.]");

		String[] pInteger = numberArray[0].split("");

		String[] pFloat = numberArray[1].split("");

		 BigDecimal Intresult = new BigDecimal("0");

		
		int[] num = new int[pInteger.length];
		String text="1";
		for (int i = 0; i <pInteger.length; i++) {
			if(i==0) {
				num[i]=Integer.parseInt(text);
			}else {
				text+="0";
				num[i]=Integer.parseInt(text);
			}
		}
		text="10";
		for (int j = 0; j < num.length; j++) {
			String u = pInteger[j];

			BigDecimal un = new BigDecimal(u).multiply(new BigDecimal(num[j]));

			System.out.println(u + "*" + num[j] + "=" + un);

			 Intresult=Intresult.add(un);
			}
		System.out.println("----------------------------");
//			
		BigDecimal Floatresult = new BigDecimal("0");
//			
//			
//			//int f= pFloat.length;
//					
		int[] doubleNum = new int[pFloat.length] ;
		
		for (int i = 0; i < doubleNum.length; i++) {
			if(i==0) {
				doubleNum[i]=Integer.parseInt(text);
			}else {
				text+="0";
				doubleNum[i]=Integer.parseInt(text);
			}
		}
		int doulen=doubleNum.length-1;
		for (int i = 0; i < doubleNum.length; i++) {

		String unit = pFloat[i];
		
		BigDecimal un1 = new BigDecimal(unit).divide(new BigDecimal(doubleNum[doulen]));
	
		System.out.println(unit + "/" + doubleNum[doulen] + "=" + un1.toPlainString());
		doulen--;
				Floatresult = Floatresult.add(un1);
				
				}
				System.out.println("------------------------");
				doulen--;
//				System.out.println(Intresult.add(Floatresult));
				

				 return Intresult.add(Floatresult);
			
	}
			
			

}


	


