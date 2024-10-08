package 이주현;

public class Account {

	private String ano;
	private String owner;
	private int balance;
	
	
	Account(String ano, String owner, int balence){
		this.ano = ano;
		this.owner = owner;
		this.balance = balence;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balence) {
		this.balance = balence;
	}

	
	public static Account acCheck(Account[] accounts, String ano) {
		for(Account ac : accounts) {
			if(ac != null && ac.getAno().equals(ano)) {				
				return ac;
			}
		}
		return null;
	}
	
	
}
