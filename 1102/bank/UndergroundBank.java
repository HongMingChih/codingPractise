package tw.com.deyi.d1102.bank;

public class UndergroundBank extends StandardBank {

	public UndergroundBank(Account account) {
		// 透過super key word 呼叫父類別StandardBank Constructor
		super(account);
	}
	
    // 超額借款:overWithdraw
    public void overWithdraw(int amt) {
    	// 取得餘額
    	double balance = account.getBalance();
    	if(balance >= amt){
    		// 帳戶餘額大於借款金額，執行一般扣款作業
    		super.withdraw(amt);
    	} else {
    		// 超額借款作業
        	System.out.println("超額借款金額:" + amt);
        	balance -= amt;
            account.setBalance(balance);
    	}    	
        // 透過super key word 呼叫父類別所提供的method
        super.getBalance();
    }
    
    // 暴力討債 = 本金+高額利息
    public void debtCollection() {
    	double balance = account.getBalance();
    	if (balance<0) {//修改代碼 餘額不能大於0 
    		// 高額利息30%
    		double sum = balance * (1 + 0.3);    	
    		System.out.println("執行暴力討債金額:"+Math.floor(sum));//修改代碼 無條件捨去於數 
    		// 更新餘額
    		account.setBalance(Math.floor(sum));
    		// 印出目前所欠款金額
    		super.getBalance();
		}
    }
}
