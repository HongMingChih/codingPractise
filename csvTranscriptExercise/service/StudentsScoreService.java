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
import java.util.List;

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
		List<StudentsScore> studentsScoreData = new ArrayList<>();
		// 總分、平均(四捨五入小數點第一位)
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		File csv = new File(filePath.toString());
//		System.out.println(csv);
		String line = "";
		String everyLine = "";
		try {
			fis = new FileInputStream(csv);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			int i=0;
			while ((line = br.readLine()) != null) { // 讀取到的內容給line變數
				everyLine = line;
				String[] lineStr=everyLine.split(",");
				StudentsScore st=new StudentsScore(lineStr[0], lineStr[1], lineStr[2], lineStr[3], lineStr[4], lineStr[5], lineStr[6], lineStr[7]);

				if (i==0) {
					st.setAverage("平均");
					st.setSumScore("總分");

				}else {
					int sum=Integer.parseInt(st.getChineseScore())+
							Integer.parseInt(st.getEnglishScore())+
							Integer.parseInt(st.getMathematicsScore())+
							Integer.parseInt(st.getPhysicalScore())+
							Integer.parseInt(st.getHistoryScore())+
							Integer.parseInt(st.getGeographyScore());
					double ave=Math.round((((double)sum)/6) * 10.0) / 10.0;
					st.setSumScore(String.valueOf(sum));
					st.setAverage(String.valueOf(ave));

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
		File csv = new File(reportDir.toString()); // CSV檔案路徑
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		String text="";
		try {
			fos = new FileOutputStream(csv);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw);
			int i=0;
			for (StudentsScore st : studentsScoreDatas) {
				text=(st.getStudentNo() + "," + st.getName() + "," + st.getChineseScore() + ","
						+ st.getEnglishScore() + "," + st.getMathematicsScore() + "," + st.getPhysicalScore() + ","
						+ st.getHistoryScore() + "," + st.getGeographyScore() + "," + st.getSumScore() + ","
						+ st.getAverage());
				System.out.println(text);
			
				if (i==0) {
					bw.write(text+",排名"+"\n");
				}else {
					bw.write(text+","+i+"\n");
				}
				i++;
				bw.flush();
				
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if (bw!=null) {bw.close();} 
			if (osw!=null) {osw.close();}
			if (fos!=null) {fos.close();}
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}

}
