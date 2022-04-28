package prob5;

public class Account {

	private String accountNo; 
	private int balance;
	
	
	public Account(String accountNo) {
		// TODO Auto-generated constructor stub
		this.accountNo = accountNo;
		this.balance=0;
		System.out.println(accountNo + " 계좌가 개설되었습니다.");
	}

	public void save(int balance) {
		// TODO Auto-generated method stub
		this.balance+=balance;
		System.out.println(accountNo + " 계좌에 " + balance + "만원이 입금되었습니다.");
	}

	public void deposit(int balance) {
		// TODO Auto-generated method stub
		this.balance-=balance;
		System.out.println(accountNo + " 계좌에 " + balance + "만원이 출금되었습니다.");
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	
}
