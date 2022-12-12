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
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.training.session8.model.StudentsScore;

public class StudentsScoreService {

	/**
	 * Step1:使用File輸入串流將來源檔資料讀出StudentsScoreData.csv <br/>
	 * Step2:計算每一筆學生成績的總分與平均,並存入collection
	 * 
	 * @param fileData
	 * @return List<StudentsScore>
	 */
	public List<StudentsScore> inputStudentsScoreData(Path filePath) {
		List<StudentsScore> studentsScoreData = null;
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
			// 讀取到的內容給line變數
			int i = 0;
			while ((line = br.readLine()) != null) { 
				String everyLine = line;
				StudentsScore st=new StudentsScore();
				if (i == 0) {
					studentsScoreData=new ArrayList<>();
					String title = everyLine + "," + "總分" + "," + "平均";
					String[] tit=everyLine.split(",");
					List<String> li=new ArrayList<>(Arrays.asList(tit));//更改比較器使用分數
					
					li=li.subList(2, li.size());
					String secondElement =li.get(1);
					String thirdElement=li.get(2);
					li.set(1, thirdElement);
					li.set(2, secondElement);
					li.addAll(0,Arrays.asList("總分", "平均"));
					st.setAllInfo(title);
					st.setAllScore(li);//比較器使用順序
				} 
				else {
					String[] lineCount = everyLine.split(",");
					String group = lineCount[0] + "," + lineCount[1];
					String math = Arrays.stream(lineCount, 2, lineCount.length)
					                    .map(String::valueOf)
					                    .collect(Collectors.joining(","));
					String[] mathCount = math.split(",");
					int sumScore = Arrays.stream(mathCount)
					                     .mapToInt(Integer::parseInt)
					                     .sum();
					
					//平均average
					double average = Math.round((((double) sumScore) / mathCount.length) * 10.0) / 10.0;
					math = Arrays.stream(mathCount)
		                    .map(String::valueOf)//map()轉字串
		                    .collect(Collectors.joining(","));//Collectors.joining()連接字串
					String allCount = group + "," + math + "," + sumScore + "," + average;
					String[] mathcou = math.split(",");
					String temp = mathcou[1];
					mathcou[1] = mathcou[2];
					mathcou[2] = temp;
					String mathcou2 = String.join(",", mathcou);
					String Score = String.valueOf(sumScore) + "," + String.valueOf(average) + "," + mathcou2;
					List<String> li = Collections.singletonList(Score);
					st.setAllInfo(allCount); // 全部的資料，包含標頭
					st.setAllScore(li); // 需比較的分數總分平均
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
	public void outputStudentsScoreData(Path reportDir, List<StudentsScore> studentsScoreDatas) {
		 try (BufferedWriter bw = Files.newBufferedWriter(reportDir)) {
		        int i = 0;
		        for (StudentsScore st : studentsScoreDatas) {
		            String text = st.getAllInfo();
		            bw.write(text + (i == 0 ? ",排名" : "," + i) + "\n");
		            i++;
		        }
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		
		

	}

}
