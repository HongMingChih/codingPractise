package tw.com.deyi.d1130;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTreeArrayList {

	public static void main(String[] args) {

		/*
		 * XXXXO 
		 * XXXOOO
		 * XXOOOOO 
		 * XOOOOOOO 
		 * OOOOOOOOO
		 */

		List<List<String>> tree = createChristmasTree(5);
		String str = tree.toString().replaceAll("\\[|\\]| |,", "");
		System.out.println(str);
		
//		for (List<String> list : tree) {
//			for (String list2 : list) {
//				System.out.print(list2);
//			}
//			System.out.println();
//		}
	}

	public static List<List<String>> createChristmasTree(int numbers) {
		List<List<String>> tree = new ArrayList<>();
		List<String> list = new ArrayList<>();
		for (int j = 0; j < numbers; j++) {
			for (int i = 2; i <= numbers-j; i++) {
				list.add("X");
			}
			for (int k = 0; k <= j; k++) {
				if (k > 0 || k > j) {
					list.add("O");
				}
				list.add("O");
			}
			list.add("\n");
		}
		tree.add(list);
		return tree;
	}

}
