package com.training.session8.model;

import java.util.List;

public class StudentsScore {
	
	private List<String> AllScore;//比較器使用的總分平均分數
	
	private String allInfo;//全部資料

	public List<String> getAllScore() {
		return AllScore;
	}

	public void setAllScore(List<String> allScore) {
		AllScore = allScore;
	}

	public String getAllInfo() {
		return allInfo;
	}

	public void setAllInfo(String allInfo) {
		this.allInfo = allInfo;
	}
	
}
 
