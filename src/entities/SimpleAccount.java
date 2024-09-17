package entities;

public class SimpleAccount extends Account {
	
	public SimpleAccount() {
		super();
	}

	public SimpleAccount(String name, int senha, double balance, double renda) {
		super(name, senha, balance, renda);
	}

	@Override
	public void Saque(double saque) {
		if (super.getBalance() - saque < 0) {
			System.out.println("Saque nao pode ser realizado!");
		} else {
			super.Saque(saque);
		}
	}
	
	public String toString() {
		return super.toString();
	}
}
