package tw.com.deyi.d1102;

public class MirrorWorld {

	public static void main(String[] args) {
//		String [][] mirror = new String[][]{
//			{"O","O","O","O","O","O","O","O","O","O"},
//			{"O","X","X","X","X","O","O","O","O","O"},
//			{"O","X","O","O","O","O","O","O","O","O"},
//			{"O","X","O","O","O","O","O","O","O","O"},
//			{"O","X","O","O","O","O","O","O","O","O"},
//			{"O","X","O","O","O","O","O","O","O","O"},
//			{"O","X","O","O","O","O","O","O","O","O"},
//			{"O","X","O","O","O","O","O","O","O","O"},
//			{"O","X","X","X","X","O","O","O","O","O"},
//			{"O","O","O","O","O","O","O","O","O","O"},
//		};
		String[][] mirror = new String[][] {
{ "□", "□", "□", "□", "□", "□", "□", "□", "□", "□" },
{ "□", "□", "●", "□", "□", "□", "□", "□", "□", "□" },
{ "□", "●", "□", "●", "□", "□", "□", "□", "□", "□" },
{ "●", "□", "□", "□", "●", "□", "□", "□", "□", "□" },
{ "●", "□", "□", "□", "□", "□", "□", "□", "□", "□" },
{ "●", "□", "□", "□", "□", "□", "□", "□", "□", "□" },
{ "□", "●", "□", "□", "□", "□", "□", "□", "□", "□" },
{ "□", "□", "●", "□", "□", "□", "□", "□", "□", "□" },
{ "□", "□", "□", "●", "□", "□", "□", "□", "□", "□" },
{ "□", "□", "□", "□", "●", "□", "□", "□", "□", "□" },
{ "□", "□", "□", "□", "□", "□", "□", "□", "□", "□" }, };
		String str = new String();
		for (int j = 0; j < mirror.length; j++) {//直的長度
			for (int i = 0; i < mirror[i].length / 2; i++) {//橫向只取一半
				str += mirror[j][i];//將半邊陣列放入string容器中
			}
			str += ",";//區隔每行
		}
		String[] str2 = str.split(",");//切割原圖半邊 生成新陣列
		for (int i = 0; i < str2.length; i++) {//依序輸出新陣列
			StringBuilder sb = new StringBuilder();
			sb.append(str2[i]);//將每行新陣列放入StringBuilder中
			for (int k = str2[i].length() - 1; k >= 0; k--) {//透過每行判斷式鏡向輸入結果至StringBuilder
					sb.append(sb.charAt(k));
			}
			System.out.println(sb.toString());//依序打印每行鏡像更新過後的結果
		}
	}
}