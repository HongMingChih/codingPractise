package tw.com.deyi.d1202.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;




/*
 * 簡潔版
 */

public class PresidentSortMain {

	public static void main(String[] args) {
		
		President p1 = new President(1, "吼XX", "A123456789", 165, 10000);
		President p2 = new President(2, "賴XX", "B123456789", 175, 7000);
		President p3 = new President(3, "柯XX", "C123456789", 166, 10000);
		President p4 = new President(4, "郭XX", "D123456789", 180, 6000);
		President p5 = new President(5, "李XX", "E123456789", 177, 30000);
		President p6 = new President(6, "韓XX", "F123456789", 175, 7000);
		
		List<President> presidents = new ArrayList<>();
		presidents.add(p1);
		presidents.add(p2);
		presidents.add(p3);
		presidents.add(p4);
		presidents.add(p5);
		presidents.add(p6);
		
		comparePresident(presidents);
		
		for(President president : presidents){
			System.out.println(president);
		}

	}

	private static void comparePresident(List<President> presidents) {
		// 實作比較邏輯
		// 主排序:numberOfVotes(票數多)
		// 次排序:height(身高矮)
		// 次次排序:idNumber(字母愈後面的贏)	
		Collections.sort(presidents,new Comparator<President>() {
			@Override
			public int compare(President p1, President p2) {
				int cmp = p2.getNumberOfVotes().compareTo(p1.getNumberOfVotes());
				//身高矮>高
				cmp=(cmp==0)?p1.getHeight().compareTo(p2.getHeight()):cmp;
				//字母A<Z
				cmp=(cmp==0)?p2.getIdNumber().compareTo(p1.getIdNumber()):cmp;
				
				  return cmp;
			}
			
		});
		
	}

}


class President  {

	private Integer candidateNo;

	private String name;

	private String idNumber;

	private Integer height;

	// 得票數
	private Integer numberOfVotes;

	@Override
	public int hashCode() {
		return Objects.hash(height, idNumber, numberOfVotes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		President other = (President) obj;
		return Objects.equals(height, other.height) && Objects.equals(idNumber, other.idNumber)
				&& Objects.equals(numberOfVotes, other.numberOfVotes);
	}

	public President(Integer candidateNo, String name, String idNumber, Integer height, Integer numberOfVotes) {
		this.candidateNo = candidateNo;
		this.name = name;
		this.idNumber = idNumber;
		this.height = height;
		this.numberOfVotes = numberOfVotes;
	}

	@Override
	public String toString() {
		return "候選人 [選號: " + candidateNo + "號 , 姓名: " + name + " , 身分證: " + idNumber + " , 身高: "
				+ height + " 公分 , 得票數:" + numberOfVotes + " 票]";
	}

	public Integer getCandidateNo() {
		return candidateNo;
	}

	public void setCandidateNo(Integer candidateNo) {
		this.candidateNo = candidateNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}


	
	

}