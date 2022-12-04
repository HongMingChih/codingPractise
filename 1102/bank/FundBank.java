package tw.com.deyi.d1102.bank;

public class FundBank extends StandardBank {
	
	public FundBank(Account account) {
		// 1.透過super key word 呼叫父類別StandardBank Constructor		
		super(account);
	}
	
	// 基金投資
	public void investFund(double amt) {
			double balance = account.getBalance();//修改增加代碼 先查詢餘額
				if (balance>amt) {
					// 更新基金投資金額
					account.setFunMoney(amt);
				}
			// 投資基金之手續費1%
				amt = amt * (1 + 0.01);
				System.out.println("基金投資金額(含手續費):" + Math.floor(amt));
			// 2.透過super key word 呼叫父類別所提供的method
			// 為投資基金而提領銀行存款
				super.withdraw(Math.floor(amt));
	}
	
	// 基金收益
	public void incomeFund() {
			// 基金獲利30%
			double incomeMoney = account.getFunMoney() * (1 + 0.3);
			System.out.println("基金投資獲利:" + incomeMoney);
			// 將基金獲利存入帳戶
			super.deposit((int) incomeMoney);
			account.setFunMoney(0);//修改增加代碼 獲利增加後，容器歸零
	}
}
