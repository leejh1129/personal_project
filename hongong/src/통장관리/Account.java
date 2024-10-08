package 통장관리;

public class Account {

	private String ano;
	private String owners;
	private int balance;
	
	public Account() {
		
	}
	
	public Account(String ano, int depositAmt) {
		this.ano = ano;
		this.balance = depositAmt;
	}
	
	public Account(String ano, String owners, int balance) {
		this.ano = ano;
		this.owners = owners;
		this.balance = balance;
	}
	
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwners() {
		return owners;
	}

	public void setOwners(String owners) {
		this.owners = owners;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "계좌번호 : " + ano +  "\t" + " 계좌주 : " + owners + "\t" + "잔고 : " + balance;
	}
	
	
	
}
