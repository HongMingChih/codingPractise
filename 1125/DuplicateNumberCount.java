package tw.com.deyi.d1125;

public class DuplicateNumberCount {

	public static void main(String[] args) {
		// 計算非重複的數字個數 8
		// 8,6,5,9,7,2,0,456
		int[] numbers = new int[] { 8, 6, 6, 5, 9, 6, 5, 7, 2, 0, 0, 5, 456};
		int count = duplicateNumberCount(numbers);
		System.out.println("數字個數: " + count);
	}
	public static int duplicateNumberCount(int[] numbers) {
		StringBuffer sf=new StringBuffer();
		int numlen=0;//長度
		for (int i=0;i<=numbers.length-1;i++) {
			if (!sf.toString().contains(Integer.toString(numbers[i]))) {//判斷StringBuffer內是否不存在
				sf.append(numbers[i]+",");//成立加入StringBuffer
				numlen++;//長度+1
			}
		}
			System.out.println(sf.deleteCharAt(sf.length()-1));//消除最後一個逗號並打印數字結果
		return numlen;//回傳長度
	}
}
