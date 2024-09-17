package applications;

import java.util.ArrayList;
import java.util.Scanner;

import entities.Account;

public class AccountTest {

	public static void main(String[] args) {

		ArrayList<Account> conta = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);

		int op;

		do {
			System.out.println("------Menu------");
			System.out.println("1.Cadastrar");
			System.out.println("2.logar");
			System.out.println("3.Sair");
			System.out.print("Qual operação deseja fazer: ");
			op = sc.nextInt();

			switch (op) {
			case 1:
				Cadastrar(conta, sc);
				break;
			case 2:
				loginAccount(conta, sc);
				break;
			case 3:
				System.out.print("Saindo... ");
				break;
			default:
				System.out.println("Operação invalida... ");
				break;
			}
		} while (op != 3);

		sc.close();
	}

	public static void Cadastrar(ArrayList<Account> conta, Scanner sc) {

		sc.nextLine();
		System.out.print("\nNome do Titular: ");
		String name = sc.nextLine();

		System.out.print("\nCadastre um senha numerica: ");
		int senha = sc.nextInt();

		System.out.print("\nRenda Mensal: ");
		double renda = sc.nextInt();

		sc.nextLine();
		System.out.print("\nDeseja fazer um deposito inicial?(s/n): ");
		char a = sc.nextLine().charAt(0);

		double depInic;

		if (a == 's') {
			System.out.print("\nDeposito inicial: ");
			depInic = sc.nextDouble();
		} else {
			depInic = 0.0;
		}
		Account contaAux = new Account(name, senha, depInic, renda);
		conta.add(contaAux);

		System.out.println("\nID da conta: " + contaAux.getCount());

	}

	public static void loginAccount(ArrayList<Account> contaLogada, Scanner sc) {

		Account acc;

		int op;

		System.out.print("\nNumero da Conta: ");// validação da conta digitada
		acc = SearchForID(contaLogada, sc.nextInt());// conta aux recebe a conta que corresponde aquele id
		if (acc == null) {
			System.out.println("\nConta Não encontrada");
			return;
		}

		sc.nextLine();
		System.out.print("\nInsira a sua senha: ");
		int senha = sc.nextInt();

		if (acc.checaSenha(senha) == true) {
			do {
				System.out.println("------Area Logada------");
				System.out.println("1.Saldo");
				System.out.println("2.Deposito");
				System.out.println("3.Saque");
				System.out.println("4.Deletar Conta");
				System.out.println("5.Trocar Senha");
				System.out.println("6.Sair");
				System.out.print("Qual operação deseja fazer: ");
				op = sc.nextInt();

				switch (op) {
				case 1:
					Conta(acc, sc);
					break;
				case 2:
					Deposito(acc, sc);
					break;
				case 3:
					Saque(acc, sc);
					break;
				case 4:
					deletAccount(contaLogada, acc, sc);
					op = 6;
					break;
				case 5:
					changePassword(acc, sc);
					break;
				case 6:
					System.out.println("\nVoltando ao Menu Inicial...");
					break;
				default:
					System.out.println("Operação invalida... ");
					break;
				}
			} while (op != 6);
		} else {
			System.out.print("\nNUMERO DA CONTA OU SENHA ERRADOS!\n");
		}
	}

	public static void Deposito(Account conta, Scanner sc) {

		System.out.print("\nDigite o valor para deposito: ");
		conta.Deposito(sc.nextDouble());
	}

	public static void Conta(Account conta, Scanner sc) {

		System.out.println("----Imprimindo dados da conta----");
		System.out.print("\n" + conta.toString() + "\n");

	}

	public static void Saque(Account conta, Scanner sc) {

		System.out.print("\nDigite o valor para sacar: ");
		double retira = sc.nextDouble();
		conta.Saque(retira);
	}

	public static void deletAccount(ArrayList<Account> conta, Account acc, Scanner sc) {

		System.out.println("\nQuer mesmo Deletar a Conta?(s/n)");
		sc.nextLine();

		if (sc.nextLine().charAt(0) == 's') {
			conta.remove(acc);
			System.out.println("\nConta Deletada!\n");
		} else {
			System.out.println("\nOperação cancelada!\n");
			return;
		}

	}

	public static void changePassword(Account conta, Scanner sc) {
		System.out.println("Senha antiga: ");
		int oldPass = sc.nextInt();
		System.out.println("Nova senha:");
		int newPass = sc.nextInt();

		if (conta.changePassword(oldPass, newPass) == true) {
			System.out.println("Senha alterada com sucesso!");
		} else {
			System.out.println("Alteração Cancelada!");
		}
	}

	public static Account SearchForID(ArrayList<Account> conta, int id) {
		for (Account contaAux : conta) {
			if (contaAux.getCount() == id && contaAux != null) {
				return contaAux;
			}
		}
		return null;
	}
}
