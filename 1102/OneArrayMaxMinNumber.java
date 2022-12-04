package tw.com.deyi.d1102;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OneArrayMaxMinNumber {

	public static void main(String[] args) {

//		int minNumber = 0;
//		
//		int maxNumber = 0;

		int[] numbers = new int[] { 5, 10, 20, 7, 20, 5, 2, 6 };
		IntStream intStream = Arrays.stream(numbers);
		OptionalInt optionalInt = intStream.max();
		int maxNumber = optionalInt.getAsInt();
		System.out.println("Maximum number = " + maxNumber);//最大20
		
		IntStream intStream2 = Arrays.stream(numbers);
		OptionalInt optionalInt2 = intStream2.min();
		int minNumber = optionalInt2.getAsInt();
		System.out.println("minNumber:" + minNumber); // 最小 2


	}


}
