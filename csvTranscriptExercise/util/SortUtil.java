package com.training.session8.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.training.session8.model.StudentsScore;

public class SortUtil {

	public static void sortStudentsScoreByAverage(List<StudentsScore> studentsScoreDatas) {
		// 主排序:總分
		// 次排序:國文
		// 次次排序:數學
		Collections.sort(studentsScoreDatas, new Comparator<StudentsScore>() {
			@Override
			public int compare(StudentsScore o1, StudentsScore o2) {
				int cmp = o2.getSumScore().compareTo(o1.getSumScore());
//				//國文
				cmp = (cmp == 0) ? o2.getChineseScore().compareTo(o1.getChineseScore()) : cmp;
//				//數學
				cmp = (cmp == 0) ? o2.getMathematicsScore().compareTo(o1.getMathematicsScore()) : cmp;
				//理化
				cmp = (cmp == 0) ? o2.getPhysicalScore().compareTo(o1.getPhysicalScore()) : cmp;
				//歷史
				cmp = (cmp == 0) ? o2.getHistoryScore().compareTo(o1.getHistoryScore()) : cmp;
				//地理
				cmp = (cmp == 0) ? o2.getGeographyScore().compareTo(o1.getGeographyScore()) : cmp;
				//座號
				cmp = (cmp == 0) ? o1.getStudentNo().compareTo(o2.getStudentNo()) : cmp;
				return cmp;
			}
		});

		
		
		
	}

}
