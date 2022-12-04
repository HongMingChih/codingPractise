/*
*Copyright (c) 2020,2022, HFU and/or its affiliates. All rights reserved.
*
*
*/

package tw.com.deyi.d1024;

/**
 *
 *
 *
 *
 * <br>
 * author: MingChih Hong
 * 
 * @since 11.0<br>
 *        TODO:
 *
 */
public class ariPro {

	public static void main(String[] args) {
		// "X,X,9,X,X,21,X" 等差數列填入X
		// X,X,9,X ,X ,21,X"
		// 1,5,9,13,17,21,25

//		String arithmetic = "X,X,9,X,X,21,X";
		String arithmetic = "X,5,X,X,X,X,25,X";
		String[] a = arithmetic.split(",");
		int x = 0;
		int tolerance = 0;// 公差
		int first_item = 0;// 首項
		int[] c = new int[arithmetic.length()];
		int y = 0;
		int i = 0;
		int j = 0;
		for (String b : a) {
			if (b.equals("X")) {
				x += 1;
			} else {
				c[i] = Integer.parseInt(b);
				y = x;
				x = 0;
				i++;
			}
		}
		x = 0;
		tolerance = ((c[1] - c[0]) / (y + 1));
		System.out.println("公差" + tolerance);
		for (String b : a) {
			if (b.equals("X")) {
				x += 1;
			} else if (j == 0 && !b.equals("X")) {
				y = x;
				j++;
			}
		}
		first_item = c[0] - tolerance * y;
		System.out.println("首項" + first_item);
		System.out.println("長度: " + arithmetic.length());
		for (int k = 0; k < (arithmetic.length()+1) / 2; k++) {
			if (k == (arithmetic.length() / 2-1) ) {
				System.out.print(first_item);
			} else {
				System.out.print(first_item + ",");
			}

			first_item += tolerance;
		}

	}

}
