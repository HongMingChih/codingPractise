package tw.com.deyi.d1028;

public class SearchTextCount {

	public static void main(String[] args) {

		String text = "想要有直昇機想要和妳飛到宇宙去";
		text += "想要和妳融化在一起融化在銀河裡";
		text += "我每天每天每天在想想想想著妳";
		text += "這樣的甜蜜讓我開始相信命運";
		text += "感謝地心引力讓我碰到妳";
		text += "漂亮的讓我面紅的可愛女人";
		text += "溫柔的讓我心疼的可愛女人";
		text += "透明的讓我感動的可愛女人";
		text += "壞壞的讓我瘋狂的可愛女人";
		text += "漂亮的讓我面紅的可愛女人";
		text += "溫柔的讓我心疼的可愛女人";
		text += "透明的讓我感動的可愛女人";
		text += "壞壞的讓我瘋狂的可愛女人";
		text += "讓我面紅的讓我面紅的";
		text += "讓我心疼的讓我心疼的";
		text += "讓我感動的讓我感動的";
		text += "讓我瘋狂的讓我瘋狂的";
		text += "讓我面紅的讓我面紅的";
		text += "讓我心疼的讓我心疼的";
		text += "讓我感動的讓我感動的";
		text += "讓我瘋狂的讓我瘋狂的";
		text += "想要有直昇機想要和妳飛到宇宙去(想要和妳)";
		text += "想要和妳融化在一起(想要和妳)融化在銀河裡";

		String[] searchKeyWord = new String[] { "可愛女人", "讓我感動", "每天", "漂亮", "壞壞", "面紅" };
		for (int i = 0; i < searchKeyWord.length; i++) {
			int keywordCount = getMaches(text, searchKeyWord[i]);//使用比較方法傳入文章+關鍵字
			System.out.println("\"" + searchKeyWord[i] + "\"出現次數 " + keywordCount + " 次");
		}
	}
	public static int getMaches(String text, String searchKeyWord) {
		int keywordCount = 0;// count用來接收子字串searchKeyWord在字串text中出現的次數
		int i = 0;
		while (text.indexOf(searchKeyWord, i) != -1) {//判斷searchKeyWord中的內容是否出現
			keywordCount++;//出現一次count+1
			i = text.indexOf(searchKeyWord, i) + searchKeyWord.length();//判斷在第幾欄出現關鍵字 沒找到為-1
		}
		return keywordCount;
	}

}
