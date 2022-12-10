package com.training.session8.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.training.session8.model.StudentCount;

public class StudentsScoreService {

	/**
	 * Step1:使用File輸入串流將來源檔資料讀出StudentsScoreData.csv <br/>
	 * Step2:計算每一筆學生成績的總分與平均,並存入collection
	 * 
	 * @param fileData
	 * @return List<StudentsScore>
	 */
	public List<StudentCount> inputStudentsScoreData(Path filePath) {
		List<StudentCount> studentsScoreData = null;
		// 總分、平均(四捨五入小數點第一位)
	
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		File csv = new File(filePath.toString());
		String line = "";
		
		try {
			fis = new FileInputStream(csv);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			
			int i = 0;
			while ((line = br.readLine()) != null) { // 讀取到的內容給line變數
				String everyLine = line;
				StudentCount st=new StudentCount();
				if (i == 0) {
					studentsScoreData=new ArrayList<>();
					String title = everyLine + "," + "總分" + "," + "平均";
					String[] tit=everyLine.split(",");
					List<String> li=new ArrayList<>(Arrays.asList(tit));//手動更改比較器使用分數
					li.remove(0);
					li.remove(0);
					li.add(0,"平均");
					li.add(0,"總分");
					st.setAllInfo(title);
					st.setAllScore(li);
				} else {
					String math = "";
					String[] lineCount = everyLine.split(",");
					String group = lineCount[0] + "," + lineCount[1];
					for (int j = 2; j <= lineCount.length - 1; j++) {
						math += lineCount[j] + ",";
					}
					String[] mathCount = math.split(",");
					int sumScore = 0;
					for (int j = 0; j < mathCount.length; j++) {
						//總分
						sumScore += Integer.parseInt(mathCount[j]);
					}
					//平均average
					double	average = Math.round((((double) sumScore) / mathCount.length) * 10.0) / 10.0;
					math = math.substring(0, math.length() - 1);
					String allCount = group + "," + math + "," + sumScore + "," + average;
					String[] mathcou=math.split(",");
					String temp=mathcou[1];
					mathcou[1]=mathcou[2];
					mathcou[2]=temp;
					String mathcou2="";
					for (int j = 0; j < mathcou.length; j++) {
						mathcou2+=mathcou[j]+",";
					}
					mathcou2=mathcou2.replaceFirst(",$","" );
					String Score=String.valueOf(sumScore)+","+String.valueOf(average)+","+mathcou2;
					List<String> li=new ArrayList<>(Arrays.asList(Score));
					st.setAllInfo(allCount);//全部的資料 包含標頭
					st.setAllScore(li);//需比較的分數總分平均
				}
				studentsScoreData.add(st);
				i++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		return studentsScoreData;
	}

	/**
	 * info:將處理好的collection使用File輸出串流,將資料產出至結果檔StudentsScoreResulet.csv
	 * 
	 * @param studentsScoreDatas
	 */
	public void outputStudentsScoreData(Path reportDir, List<StudentCount> studentsScoreDatas) {
		File csv = new File(reportDir.toString()); // CSV檔案路徑
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		String text = "";
		try {
			fos = new FileOutputStream(csv);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
		
			int i = 0;
			for (StudentCount st : studentsScoreDatas) {
				text=st.getAllInfo();
//				System.out.println(text);
			if (i == 0) {
				bw.write(text + ",排名" + "\n");
			} else {
				bw.write(text + "," + i + "\n");
			}
			i++;
			bw.flush();
			}
		} 
			catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
			catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {bw.close();}
				if (osw != null) {osw.close();}
				if (fos != null) {fos.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
