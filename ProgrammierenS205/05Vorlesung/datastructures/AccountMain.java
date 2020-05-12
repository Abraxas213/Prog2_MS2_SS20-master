package datastructures;

import java.util.HashSet;
import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {

		HashSet<Account> account = new HashSet<Account>();
		account.add(new Account("Uwe", 1337));
		account.add(new Account("Test", 1234));
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Erstellung ihres Accounts. Bitte geben sie einen Benutzernamen an:");
		String name = scan.nextLine();
		System.out.println("Bitte geben sie ihre Handynummer an:");
		int nummer = scan.nextInt();
		scan.close();
		
		Account newAcc = new Account(name,nummer);
		
		for(Account acc : account) {
			if(newAcc.equals(acc)) {
				System.out.println("ERROR! Nutzer schon vorhanden!");
			}else {
				System.out.println("Erfolg! Willkommen " + newAcc.getUser());
				account.add(newAcc);
			}
		}
		
		for (Account acc : account) {
			System.out.println("Benutzer: " + acc.getUser() + ", Handy: " + acc.getNumber() );
		}
		
	}

}
