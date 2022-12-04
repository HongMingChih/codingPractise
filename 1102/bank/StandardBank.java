package tw.com.deyi.d1102.bank;

public class StandardBank {
	// Account用戶
	protected Account account;
	
	public StandardBank() {}
	
	public StandardBank(Account account){
        this.account = account;
    }
	
    // 存款:deposit
	protected void deposit(int amt){
        if(amt>=0) {
        	// 取得餘額
        	double balance = account.getBalance();
            balance += amt;
            // 更新餘額
            account.setBalance(balance);
        } else {
        	System.out.println("不能存0元");
        }
        getBalance();
    }
    
    // 提款:withdraw
    protected double withdraw(double amt){
    	// 取得餘額
    	double balance = account.getBalance();
        if(amt>=0 && balance>=amt) {
            balance -= amt;
            // 更新餘額
            account.setBalance(balance);
        } else {
        	System.out.println("存款餘額不足,您的存款餘額為:" + balance);
        }
        getBalance();
        return balance;//餘額回傳
    }
    
    // 查詢目前餘額:getBalance
    protected void getBalance() {
    	double balance = account.getBalance();
    	System.out.println("您的存款餘額為:"+ balance);		
	}
}
