/*
*Copyright (c) 2020,2022, HFU and/or its affiliates. All rights reserved.
*
*
*/


package tw.com.deyi.d1019;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
*
*
*
*<br>author: MingChih Hong
*@since 11.0<br>
*TODO:
*
*/
public class 魷魚遊戲 {
	

	public static void main(String[] args) {
		//△:3 ○:1 □:4 ☆:10
		//輸出邊相加和
		int numTr = 0;//3
		int numRo =0;//1
		int numSq =0;//4
		int numSt =0;//10
		int sum=0;
		
		String symbol="△○□☆";
//		String symbol="△△△";//9
//		String symbol="△□□";//11
		String[] graphics ={"△","□","○","☆"};
		for (int i= 0;i<graphics.length;i++) {
		Pattern tr = Pattern.compile(graphics[i]);
		
		Matcher sb = tr.matcher(symbol);
		
			while (sb.find()) {
				if (!"".equals(sb.group()))
						if(sb.group().equals("△")) {
							numTr=3;
							sum+=numTr;
							System.out.println("圖形為: "+ sb.group()+" 邊數為: "+numTr);
						}else if(sb.group().equals("○")){
							numRo=1;
							sum+=numRo;
							System.out.println("圖形為: "+ sb.group()+" 邊數為: "+numRo);
						}else if (sb.group().equals("□")) {
							numSq=4;
							sum+=numSq;
							System.out.println("圖形為: "+ sb.group()+" 邊數為: "+numSq);
						}else if (sb.group().equals("☆")) {
							numSt=10;
							sum+=numSt;
							System.out.println("圖形為: "+ sb.group()+" 邊數為: "+numSt);
						}else {
							System.out.println("圖形不正確");
						}
				
				
			}
		}
		
		System.out.println("圖形邊總和為: "+sum);
		
	}

}
