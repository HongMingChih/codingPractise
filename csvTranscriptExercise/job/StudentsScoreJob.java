package com.training.session8.job;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import com.training.session8.model.StudentsScore;
import com.training.session8.service.StudentsScoreService;
import com.training.session8.util.SortUtil;

public class StudentsScoreJob {
	public static void main(String[] args) {
		Path filePath = Paths.get("C:/Csv/StudentsScoreData.csv");
//		Path reportDir = Paths.get("dir/session8/StudentsScoreResulet.csv");
		Path reportDir = Paths.get("C:/Csv/StudentsScoreResulet.csv");
		// Step1:使用File輸入串流將來源檔資料讀出
		// Step2:計算每一筆學生成績的總分與平均,並存入collection		
		StudentsScoreService service = new StudentsScoreService();
		List<StudentsScore> studentsScoreDatas = service.inputStudentsScoreData(filePath);
		
		
		if(studentsScoreDatas != null && studentsScoreDatas.size() > 0){
			// Step3:將collection裡的元素依平均分數降幕排序
			SortUtil.sortStudentsScoreByAverage(studentsScoreDatas);	

			// Step4:將處理好的collection使用File輸出串流,將資料產出至結果檔StudentsScoreResulet.csv
			service.outputStudentsScoreData(reportDir, studentsScoreDatas);
		}
	}
}
