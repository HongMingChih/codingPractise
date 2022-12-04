package tw.com.deyi.d1104;

public class LampMain {

	public static void main(String[] args) {
		
		Lamp L1 = new Lamp("綠燈", 2);
		Lamp L2 = new Lamp("黃燈", 8);
		Lamp L3 = new Lamp("紅燈", 3);
//		Lamp L4 = new Lamp("紫燈", 6);
		// String[] texts = new String[]{"A"};
		Lamp[] lamps = new Lamp[]{L1, L2, L3};
		int endSecond = 120;
		int[] bright=new int[lamps.length];//保存燈次數的容器
		int multiple=0;//計算出倍數的容器
		// 12
		// 綠燈:2*6 = 12
		// 黃燈:4*3 = 12
		// 紅燈:6*2 = 12
		// 24
		// 綠燈:2*12 = 24
		// 黃燈:4*6 = 24
		// 綠燈:6*4 = 24
		int i=0;
		for (Lamp lamp : lamps) {
			int brightOne=lamp.getBrightSecond();//把一個一個燈取出
			bright[i]=brightOne;//裝入燈的容器
			int multipleAll = multiple(bright, 0);//將取出的燈數放入計算方法 從0開始計算
			i++;
			multiple+=multipleAll;//取得的公倍數裝入容器中
		}
		for (int j = multiple; j <=endSecond;j+=multiple) {
			System.out.println(j);
			for (int k = 0; k < bright.length; k++) {
					System.out.println(
						lamps[k].getText()+
						":"+lamps[k].getBrightSecond()+
						"*"+j/lamps[k].getBrightSecond()+
						"="+j);
				}
			}
		}
	public static int divisor(int x,int y){//求2個數的最大公約數
        int min = x < y ? x : y ;//取兩個數較小的那個
        for(int divisorMax = min ; divisorMax > 0 ; divisorMax--){
            if(x%divisorMax==0&&y%divisorMax==0){    
            	//從較小的數開始往後尋找 直到可以同時整除2個數的數 即最大公約數
                return divisorMax;
            }
        }
        return 1;
    }
    public static int multiple(int a[],int count){//傳入燈數
        //count從第一個數開始 0
        int divisorMax=divisor(a[count],a[count+1]);    
        //求count-1與count最大公約數
        int multipleMin=a[count]/divisorMax*a[count+1];
        //求這兩個數的最小公倍數    
        //不能是int multipleMin=a[count]*a[count+1]/divisorMax；
        //雖然結果一樣，但是先把2個int相乘可能會超過int的範圍，所以先除，在乘，可以防止越界
        a[count+1]=multipleMin;        
        //把兩個數的最小公倍數附值給後面的數也就是count+2
        count++;    //標記轉到count+2
        if(count!=a.length-1){    //如果count不是在倒數第二個
            return multiple(a,count);
            //再找count+1與count+2的最小公倍數
        }
        return multipleMin;    //返回最小公倍數
    }
}
