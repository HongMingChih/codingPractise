package tw.com.deyi.d1121;


public class NumberDonut {

	public static void main(String[] args) {
		
//		int[][] numberDonuts = buildNumberDonut(2);
//		for (int[] numberDonut : numberDonuts) {
//			for (int Donut : numberDonut) {
//				System.out.print(Donut);
//			}
//			System.out.println();
//		}
		
		//2-9所有甜甜圈
		for (int i = 9; i > 1; i--) {
			System.out.println("------傳入值:"+i+"------");
			int[][] numberDonuts = buildNumberDonut(i);
			for (int[] numberDonut : numberDonuts) {
				for (int Donut : numberDonut) {
					System.out.print(Donut);
				}
				
				System.out.println();
			}
		}
		
		System.out.println("--------end--------");
		/*
		   222
		   212
		   222
		*/
		/*
		  33333
		  32223
		  32123
		  32223
		  33333
		*/
		/*
		 4444444
		 4333334
		 4322234
		 4321234
		 4322234
		 4333334
		 4444444
		*/
	}
	
	public static int[][] buildNumberDonut(int number){
			if (number>9||number<=1) {
				System.out.println("請輸入數字2-9");
				return new int[][]{};
			}
			int[][] numberDonuts=new int[number*2-1][number*2-1];//先抓出陣列顯示大小
			int descNumber=number;//向內遞減數字
			int scope=0;//控制遞減數字顯示範圍
			for (int num = number; num > 0; num--) {//第一圈為最外層顯示數字
				for (int i = 0+scope; i < numberDonuts[0].length-scope; i++) {//第二第三圈顯示依序遞減範圍
					for (int j = 0+scope; j <numberDonuts.length-scope; j++) {
						numberDonuts[i][j]=descNumber;
					}
				}
				scope++;//最外圈結束後向內圈覆蓋遞減數字
				descNumber--;//遞減數字
			}
			return numberDonuts;
	}
	
}
