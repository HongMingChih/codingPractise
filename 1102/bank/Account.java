package tw.com.deyi.d1102.bank;

// 1.Data Model 資料模型
// 2.Java Bean
// 3.POJO (Plain Old Java Object)
public class Account {
	
	private double balance; // 餘額	
	
	private double funMoney; // 基金投資金額
	
	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getFunMoney() {
		return funMoney;
	}

	public void setFunMoney(double funMoney) {
		this.funMoney = funMoney;
	}	
	
}
