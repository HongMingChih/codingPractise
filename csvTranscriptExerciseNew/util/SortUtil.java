package com.training.session8.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.training.session8.model.StudentCount;

public class SortUtil {

	public static void sortStudentsScoreByAverage(List<StudentCount> studentsScoreDatas) {
		// 主排序:總分/平均
		// 次排序:國文
		// 次次排序:數學/英文/剩餘依順序

		Collections.sort(studentsScoreDatas, new Comparator<StudentCount>() {

			@Override
			public int compare(StudentCount o1, StudentCount o2) {
					String[] f1=o1.getAllScore().toString().split(",");
					String[] f2=o2.getAllScore().toString().split(",");
					for (int i = 0; i < f1.length&&i < f2.length; i++) {
						int cmp=f2[i].compareTo(f1[i]);
						if (cmp!=0) {
							return cmp;
						}
					}
					return Integer.compare(f1.length,f2.length);
				
			}
		});


	}
}
