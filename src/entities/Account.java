package entities;

import java.time.LocalDateTime;

public class Account {

	private static int lastId = 0;
	static LocalDateTime hoje = LocalDateTime.now();
	
	private String name;
	private int count;
	private int senha = 0000;
	private double balance;
	private Date openingDate; 
	private double limit;

	public Account() {

	}

	public Account(String name, int senha, double balance, double renda) {
		setName(name);
		changePassword(this.senha, senha);
		setCount(++Account.lastId);
		Deposito(balance);
		calcLimit(renda, balance);
		this.openingDate = new Date(hoje.getMonthValue(), hoje.getDayOfMonth(), hoje.getYear());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = 1000 + count;
	}

	public double getBalance() {
		return balance;
	}

	public double getLimit() {
		return limit;
	}
	
	public Date getDate() {
		return openingDate;
	}

	public void calcLimit(double renda, double balance) {
		this.limit = (renda * 0.25) + (balance * 0.05);
	}

	public void Deposito(double balance) {
		this.balance += balance;
	}

	public void Saque(double saque) {
		if (saque <= limit) {
			this.balance -= saque;
			System.out.println("\nSaque Realizado...");
		} else {
			System.out.println("Operação cancelada, limite excedido");
		}
	}

	public String toString() {
		return "Titular: " + name + "\nData de abertura: "+ openingDate + "\nID: " + count + "\nSaldo: R$ " + balance + "\nLimite: R$ " + limit + "\n";
	}

	public boolean checaSenha(int senha) {

		if (this.senha == senha) {
			return true;
		}
		return false;
	}

	public boolean changePassword(int oldPassword, int newPassword) {
		if (oldPassword != this.senha) {
			return false;
		}
		this.senha = newPassword;
		return true;
	}
}
