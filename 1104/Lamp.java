package tw.com.deyi.d1104;

public class Lamp {
	
	private String text; //燈
	
	private int brightSecond;//燈亮的次數
		
	public Lamp(String text, int brightSecond) {
		this.text = text;
		this.brightSecond = brightSecond;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getBrightSecond() {
		return brightSecond;
	}

	public void setBrightSecond(int brightSecond) {
		this.brightSecond = brightSecond;
	}
	
}
