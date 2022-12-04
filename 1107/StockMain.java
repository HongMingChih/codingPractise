package tw.com.deyi.d1107;

public class StockMain {

	public static void main(String[] args) {
		int[] stockPrices = new int[] { 25, 12, 22, 20, 18, 30, 23, 17, 29 };
		//

//		int[] stockPrices = new int[]{25, 12,22,20,18,13,23,17,18};
		// 23 - 12 = 11

//		int[] stockPrices = new int[]{1,2,3,4,5};
		// 5 - 1 = 4

//		int[] stockPrices = new int[]{6,2,1,4,5};
		// 5 - 1 = 4

		int deviationMax = 0;// 最大差
		int max = 0;// 成立最大值
		int min = 0;// 成立最小值
		for (int j = 1; j < stockPrices.length; j++) {
			for (int i = stockPrices.length - 1; i >= 0; i--) {//從stockPrices最後開始取值
				if (0 != i) {//預防(i-1)超出範圍
					int a = stockPrices[stockPrices.length - j];//將最後的值紀錄
					int b = stockPrices[i - 1];//紀錄倒數第二個值 依序往前推
					if (a > b && (a - b) > deviationMax) {//判斷最後值依序減前面數的最大正數差值，且是否大於暫存最大差
						deviationMax = a - b;//迴圈紀錄最大差值
						min = b;//紀錄最小值
						max = a;//紀錄最大值
					}
				}
			}
		}
		System.out.println(max + " - " + min + " = " + deviationMax);
	}

}
