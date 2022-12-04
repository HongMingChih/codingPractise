package tw.com.deyi.d1104;

public class StringTermArrayCombination {

	public static void main(String[] args) {
		String[] texts = new String[]{"A","B","C","D","E"};

		// i:j:k ~ z、k ~ z、k ~ z、k ~ z
		// 1:4:0 ~ 4
		// 2:3:0 ~ 3、1 ~ 4
		// 3:2:0 ~ 2、1 ~ 3、2 ~ 4
		// 4:1:0 ~ 1、1 ~ 2、2 ~ 3、3 ~ 4
		// 5:0:0、1、2、3、4

		// i:表示每次跑的"群數"
		// j:每一群的數值"範圍"
		// k:每一群的數值"起始"
		// z:每一群的數值"結束"
	int lenthAll =texts.length;
	int j=texts.length-1;
			for (int i = 1; i <= lenthAll; i++) {
				System.out.print("i:"+i+" ");
				for (int k = 0; k < i; k++) {
//					System.out.print("j:"+j+" ");
//					System.out.print("k:"+k+" ");
					int z=k+j;
//					System.out.print("z:"+z+" ");
					for (int q = k; q <= z; q++) {
						System.out.print(texts[q]);
					}
					System.out.print(" ");
				}
				j--;
				System.out.println();
			}

	}

}
