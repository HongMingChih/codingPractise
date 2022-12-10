//package com.training.session8.model;
//
//import java.util.Objects;
//
//public class StudentsScore {
//	// 座號
//	private String studentNo;
//	// 姓名
//	private String name;
//	// 國文分數
//	private String chineseScore;
//	// 英文分數
//	private String englishScore;
//	// 數學分數
//	private String mathematicsScore;
//	// 理化
//	private String physicalScore;
//	// 歷史
//	private String historyScore;
//	// 地理
//	private String geographyScore;
//	// 物理
////	private String xxxxScore;
//	// 總分
//	private String sumScore;
//	// 平均
//	private String average;
//	
//	
//	public StudentsScore(String studentNo, String name, String chineseScore, String englishScore,
//			String mathematicsScore, String physicalScore, String historyScore, String geographyScore) {
//		this.studentNo = studentNo;
//		this.name = name;
//		this.chineseScore = chineseScore;
//		this.englishScore = englishScore;
//		this.mathematicsScore = mathematicsScore;
//		this.physicalScore = physicalScore;
//		this.historyScore = historyScore;
//		this.geographyScore = geographyScore;
//		
//	}
//	
//	@Override
//	public int hashCode() {
//		return Objects.hash(average, chineseScore, englishScore, geographyScore, historyScore, mathematicsScore,
//				physicalScore, sumScore);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		StudentsScore other = (StudentsScore) obj;
//		return Objects.equals(average, other.average) && Objects.equals(chineseScore, other.chineseScore)
//				&& Objects.equals(englishScore, other.englishScore)
//				&& Objects.equals(geographyScore, other.geographyScore)
//				&& Objects.equals(historyScore, other.historyScore)
//				&& Objects.equals(mathematicsScore, other.mathematicsScore)
//				&& Objects.equals(physicalScore, other.physicalScore) && Objects.equals(sumScore, other.sumScore);
//	}
//
//	public String getStudentNo() {
//		return studentNo;
//	}
//	public void setStudentNo(String studentNo) {
//		this.studentNo = studentNo;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getChineseScore() {
//		return chineseScore;
//	}
//	public void setChineseScore(String chineseScore) {
//		this.chineseScore = chineseScore;
//	}
//	public String getEnglishScore() {
//		return englishScore;
//	}
//	public void setEnglishScore(String englishScore) {
//		this.englishScore = englishScore;
//	}
//	public String getMathematicsScore() {
//		return mathematicsScore;
//	}
//	public void setMathematicsScore(String mathematicsScore) {
//		this.mathematicsScore = mathematicsScore;
//	}
//	public String getPhysicalScore() {
//		return physicalScore;
//	}
//	public void setPhysicalScore(String physicalScore) {
//		this.physicalScore = physicalScore;
//	}
//	public String getHistoryScore() {
//		return historyScore;
//	}
//	public void setHistoryScore(String historyScore) {
//		this.historyScore = historyScore;
//	}
//	public String getGeographyScore() {
//		return geographyScore;
//	}
//	public void setGeographyScore(String geographyScore) {
//		this.geographyScore = geographyScore;
//	}
//	public String getSumScore() {
//		return sumScore;
//	}
//	public void setSumScore(String sumScore) {
//		this.sumScore = sumScore;
//	}
//	public String getAverage() {
//		return average;
//	}
//	public void setAverage(String average) {
//		this.average = average;
//	}	
//}
// 
