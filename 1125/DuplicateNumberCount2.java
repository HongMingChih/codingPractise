package tw.com.deyi.d1125;

import java.util.Arrays;

public class DuplicateNumberCount2 {

	public static void main(String[] args) {

		// 計算非重複的數字個數 8
		// 8,6,5,9,7,2,0,456
		int[] numbers = new int[] { 8, 6, 6, 5, 9, 6, 5, 7, 2, 0, 0, 5, 456 };
//		int[] numbers = new int[] { 8,6,6,8,7};
		
		int count = duplicateNumberCount(numbers);
		System.out.println("數字個數: "+count);

	}

	public static int duplicateNumberCount(int[] numbers) {
		Arrays.sort(numbers); 
		int numlen = numbers.length;
		if (numlen == 0 || numlen == 1) {
			return numlen;
		}
		int[] newNumbers = new int[numlen];
		int j = 0;
		for (int i = 0; i < numlen - 1; i++) {
			if (numbers[i] != numbers[i + 1]) {
				newNumbers[j++] = numbers[i];
			}
		}
		newNumbers[j++] = numbers[numlen - 1];
		for (int i = 0; i < j; i++) {
			numbers[i] = newNumbers[i];
			if (i==j-1) {
				System.out.print(numbers[i]);
			}else {
				System.out.print(numbers[i]+",");
			}
		}
		System.out.println();
		
		return j;
	}
}
