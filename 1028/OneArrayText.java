package tw.com.deyi.d1028;

public class OneArrayText {

	public static void main(String[] args) {
		// 5字結果
		// "A","B","C","D","E"
		// 4字結果
		// "A","B","C","D"
		// "B","C","D","E"
		// 3字結果
		// "A","B","C"
		// "B","C","D"
		// "C","D","E"
		// 2字結果
		// "A","B"
		// "B","C"
		// "C","D"
		// "D","E"
		String[] tests = new String[] { "我", "想", "變", "有", "錢"};// 我想變有錢
		String str = "";// 保存陣列中的字元轉為字串
		String str_whole = "";// 完整字串輸出容器(含符號)
		int control = 1;// 控制打印次數
		StringBuilder sb = new StringBuilder();//準備操作字符串容器
		System.out.println(tests.length + "字結果: ");// 長度開始
		for (int i = 0; i < tests.length; i++) {
			str += tests[i];
			sb.append(tests[i]);
			System.out.print("\"" + tests[i] + "\"");
			if (i == tests.length - 1) {
				System.out.print("");
			} else {
				System.out.print(",");
			}
		}
		System.out.println();
		for (int j = tests.length - 1; j > 0; j--) {
			System.out.println(j + "字結果: ");
			for (int i = 0; i < control + 1; i++) {
				//判斷是否為第一次迴圈做打印
				if (i == 0) {
					//字串切割轉為陣列(為了加入符號)
					String[] str_punctuation = sb.substring(0, j).split("");
					//透過迴圈判斷加入符號
					for (int l = 0; l < str_punctuation.length; l++) {
						if (l == str_punctuation.length - 1) {
							str_whole = "\"" + str_punctuation[l] + "\"";
						} else {
							str_whole = "\"" + str_punctuation[l] + "\"" + ",";
						}
						//加入置完整輸出
						System.out.print(str_whole);
					}
					System.out.println();
					
				} else {//若不是第一次回圈 就將首字母刪除繼續打印後面內容組合
					sb.deleteCharAt(0);
					String[] str_punctuation = sb.substring(0, j).split("");
					for (int k = 0; k < str_punctuation.length; k++) {
						if (k == str_punctuation.length - 1) {
							str_whole = "\"" + str_punctuation[k] + "\"";
						} else {
							str_whole = "\"" + str_punctuation[k] + "\"" + ",";
						}
						System.out.print(str_whole);
					}
					System.out.println();
				}
			}
			control++;
			// sb 重製原句長度
			sb.replace(0, tests.length, str);

		}
	}
}
