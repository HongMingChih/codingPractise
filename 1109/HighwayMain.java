package tw.com.deyi.d1109;

public class HighwayMain {
	
	public static void main(String[] args) {

		Car2 car1 = new Car2("Toyota", "altis", 1);
		Car2 car2 = new Car2("BMW", "M3", 2);
		Car2 car3 = new Car2("Benz", "C300", 3);
		Car2 car4 = new Car2("Audi", "Q3", 4);
//		Car2 car5 = new Car2("Ford ", "FIESTA", 3);

		Car2[] highway = new Car2[]{
				car1, car4, car3, null, null, null, null, car2, null, null, null, null
			};
		
//		Car2[] highway = new Car2[]{
//		car1, car2, car3, null, null, null, null, null, null, null, null, null
//	};
	
	
//	Car2[] highway = new Car2[]{
//		car3, car2, car1, null, null, null, null, null, null, null, null, null
//	};
	
	// { null, car3, car2, car1, null, null, null, null, null, null, null, null }
	
//		Car2[] highway = new Car2[]{
//		car1, car3, car2, null, null, null, null, null, null, null, null, null, null, null, null
//	};		
		
	//{ null, car1, null, car3, car2, null, null, null, null, null, null, null }
		
		int endNo = 10;//走的秒數
		// 第1秒
		// 0:null
		// 1:"Benz-C300"
		// 2:"BMW-M3"
		// 3:Toyota-altis"
	

		for (int time = 0; time <= endNo; time++) {//迴圈計算秒數
			if (time>0) {
			for (int i = highway.length-1 ; i >= 0; i--) {//逆迴圈抓內容
				if (highway[i]!=null) {//判斷內容不為null
					Car2 carBox=highway[i];//為了換位置 優先準備容器暫時存取
					int carSpeed=highway[i].getSpeed();//取出當前這台車每秒的車速(格數)
					int position=i;//抓到位置
					for (int j = 1; j <=carSpeed; j++) {//當有車 且抓到車速做迴圈移動，空不做
						if (i+j>highway.length-1) {//如果移動的位置超出長度 break
							break;
						}
						else if (highway[position+1]==null) {//如果移動一格的位置是null就做移動
							highway[position+1]=carBox;//移動目前這台車到下一格
							highway[position]=null;//清理前一個位置的資料
							position++;//繼續移動carSpeed格數
						}
					}
				}
			}
		}
			System.out.println("第 "+time+" 秒:");//每秒打印
			
			//每一秒結果
			for (int i = 0; i < highway.length; i++) {
				if (i==highway.length-1) {
					System.out.print(highway[i]);
				}else {
					System.out.print(highway[i]+",");
				}
			}
			System.out.println();
		}
	}
}
	

	
class Car2 {

	private String brand;

	private String type;

	private int speed;

	public Car2(String brand, String type, int speed) {
		this.brand = brand;
		this.type = type;
		this.speed = speed;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "[" + brand + "]";
	}

}
