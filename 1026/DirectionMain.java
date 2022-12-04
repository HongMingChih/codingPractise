package tw.com.deyi.d1026;

import java.util.Iterator;
import java.util.Scanner;

public class DirectionMain {

	public static void main(String[] args) {

		String[][] map = new String[][] { 
//			{ "A", "B", "C", "D", "E" }, 
//			{ "F", "G", "H" }, 
//			{ "K", "L", "M", "N", "O" },
//			{ "P", "Q", "R" }, 
//			{ "U", "V", "W", "X", "Y" },
////			{"I","J","S","T","Z"},
			{"A","B","C"},
			{"D","E","F"},
			{"G","H","I"}
		};

//		String direction = "↓↑←→↘↙↗↖";
//		String direction = "←←←→↘↙↗↖";
		String direction = "←↑→→↓↓←←";
		String[] a = direction.split("");

		int startColumnNo = 1;
		int startRowNo = 1;
		for (int i = 0; i < a.length; i++) {
			switch (a[i]) {
			case "→":
				if (startRowNo + 1 <= map[startColumnNo].length - 1) {
					startRowNo++;
				}
				System.out.println("direction: " +"→"+ "\n"+map[startColumnNo][startRowNo]);
				break;
			case "↓":
				if (startColumnNo + 1 <= map.length - 1 && startRowNo < map[startColumnNo + 1].length) {
					startColumnNo++;
				}
				System.out.println("direction: " +"↓"+ "\n"+map[startColumnNo][startRowNo]);
				break;

			case "↑"://
				if (startColumnNo > 0 && startRowNo < map[startColumnNo + 1].length) {
					startColumnNo--;
				}
				System.out.println("direction: " +"↑"+ "\n"+map[startColumnNo][startRowNo]);	
				break;
			case "←":// startRowNo-1 <=0
				if(startRowNo - 1 >= 0) {
					startRowNo--;
				} 
				System.out.println("direction: " +"←"+ "\n"+map[startColumnNo][startRowNo]);
				break;
			case "↘":

				if (startColumnNo < map.length - 1 && startRowNo < map[startColumnNo + 1].length - 1) {
					startColumnNo++;
					startRowNo++;
				}
				System.out.println("direction: " +"↘"+ "\n"+map[startColumnNo][startRowNo]);
				break;
			case "↗":
				if (startColumnNo > 0 && map[startColumnNo - 1].length > 0
						&& startRowNo < map[startColumnNo - 1].length - 1) {
					startColumnNo--;
					startRowNo++;
				}
				System.out.println("direction: " +"↗"+ "\n"+map[startColumnNo][startRowNo]);
				break;
			case "↖":
				if (startRowNo > 0 && startColumnNo > 0 && startRowNo <= map[startColumnNo - 1].length) {
					startColumnNo--;
					startRowNo--;
				}
				System.out.println("direction: " +"↖"+ "\n"+map[startColumnNo][startRowNo]);
				break;

			case "↙":
				if (startRowNo > 0 && startColumnNo < map.length - 1 && startRowNo <= map[startColumnNo + 1].length) {
					startColumnNo++;
					startRowNo--;
				}
				System.out.println("direction: " +"↙"+ "\n"+map[startColumnNo][startRowNo]);
				break;

			default:
				break;
			}
		}

	}

}
