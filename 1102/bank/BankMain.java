package tw.com.deyi.d1102.bank;

public class BankMain {
	public static void main(String[] args) {		
		
		System.out.println("=======================StandardBank=======================");
		Account tomAccount = new Account(1000);
		StandardBank standardBank = new StandardBank(tomAccount);
		standardBank.withdraw(200);
		standardBank.deposit(100);
		standardBank.withdraw(1100);
		
		System.out.println("=======================UndergroundBank=======================");
		Account caseyAccount = new Account(1000);
		UndergroundBank bndergroundBank = new UndergroundBank(caseyAccount);
		bndergroundBank.withdraw(200);
		bndergroundBank.deposit(100);
		// 以下為UndergroundBank才有的method
		bndergroundBank.overWithdraw(1100);
		bndergroundBank.debtCollection();//bug 當餘額為正數 討債反向虧錢 修正於UndergroundBank 30行
//		bndergroundBank.deposit(500);
		bndergroundBank.debtCollection();
		bndergroundBank.debtCollection();
		
		System.out.println("=======================FundBank=======================");
		Account kevinAccount = new Account(1000);
		FundBank fundBank = new FundBank(kevinAccount);
		fundBank.withdraw(200);
		fundBank.deposit(100);
//		// 以下為FundBank才有的method
		fundBank.investFund(500);
		fundBank.investFund(1000);// bug 修改回傳值 StandardBank 28-39行
		fundBank.incomeFund(); //bug 修改 獲利歸零 FundBank 32行
//		fundBank.incomeFund();
		
	}
}
