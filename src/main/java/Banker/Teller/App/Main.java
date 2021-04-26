package Banker.Teller.App;
import java.util.Scanner;
import java.security.*;

public class Main {
	
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		Bank bank = new Bank();
		
		
		System.out.println("Here are your accounts at our bank:");
		
		// instantiating two accounts
		Account account1 = new Account("1111", "Checking", 2000);
		Account account2 = new Account("2222", "Saving", 100);
		
		// creating two accounts in the bank and storing them in there.
		bank.openNewAccount(account1.getAccNum(), account1);
		bank.openNewAccount(account2.getAccNum(), account2);
		
		for(Account a: bank.getAllAccounts()) {
			a.checkAccountBalance();
		}
		System.out.println();
	
		System.out.println("What you would like to do next?\n"
				 + "Press 1 to deposit\n"
				 + "Press 2 to withdrawal\n"
				 + "Press 3 to check balance\n"
				 + "Press 4 to close an account\n"
				 + "Press 5 to create an account\n"
				 + "Press 0 to exit");
		int response = input.nextInt(); // captures user's choice
		
		// continues in a while loop until the user exits with "0"
		if(response != 0) {
			while(response != 0) {
				switch(response) {
					case 1:
						createDeposit(bank);
						break;
					case 2: 
						withdrawalFromAccount(bank);
						break;
					case 3:
						seeAccountsBalance(bank);
						break;
					case 4:
						closeAnAccount(bank);
						break;
					case 5:
						createAnAccount(bank);
						break;
					case 0:
						
						break;
				} // end of switch
				
				System.out.println();
				System.out.println("What you would like to do next?\n"
				 + "Press 1 to deposit\n"
				 + "Press 2 to withdrawal\n"
				 + "Press 3 to check balance\n"
				 + "Press 4 to close an account\n"
				 + "Press 5 to create an account\n"
				 + "Press 0 to exit");
				response = input.nextInt();
				
			} // end of while
		} // end of if 
		System.out.println("Thanks for coming! Have a nice day.");
		input.close();
	} // end of main class
	
	// creates a new account 
	static void createAnAccount(Bank b) {
		b.newAccount();
		
	}
	
	// depositing into an account
	static void createDeposit(Bank b) {
		Account account;
		System.out.println("You want to deposit");

		System.out.println("Here are your accounts:");		
		for(Account a : b.getAllAccounts()) { // displays ever account that is in the bank
			a.checkAccountBalance();
		}
		
		System.out.println("Type the account number to choose an account to deposit to:");
		String userInput = input.next();
		System.out.println();
		
	
		account = b.getAccount(userInput);
		System.out.println("You have selected " + userInput);
		
		System.out.println("Enter the amount to deposit:");
		account.deposit(input.nextDouble());
		for(Account a : b.getAllAccounts()) { // displays ever account that is in the bank
			a.checkAccountBalance();
		}
		
	} // end of endDeposit
	
	// withdrawaling from an account 
	static void withdrawalFromAccount(Bank b) {
		Account account;
		System.out.println("You want to withdrawal");

		System.out.println("Here are your accounts:");		
		for(Account a : b.getAllAccounts()) { // displays ever account that is in the bank
			a.checkAccountBalance();
		}
		
		System.out.println("Type the account number to choose an account to withdrawal from:");
		String userInput = input.next();
		System.out.println();
		
	
		account = b.getAccount(userInput);
		System.out.println("You have selected " + userInput);
		
		System.out.println("Enter the amount to withdrawal:");
		
		/// NEED TO PUT PRECAUTIONS!!!!
		
		account.withdrawal(input.nextDouble());
		for(Account a : b.getAllAccounts()) { // displays ever account that is in the bank
			a.checkAccountBalance();
		}
		
		
	} // end of create 

	// view all accounts that are stored
	static void seeAccountsBalance(Bank b) {
		System.out.println("Here are your accounts:");		
		for(Account a : b.getAllAccounts()) { // displays ever account that is in the bank
			a.checkAccountBalance();
		}
		
		
	} // end of seeAccountsBalance
	
	// closing an account
	static void closeAnAccount(Bank b) {
		System.out.println("You want to close an account");

		System.out.println("Here are your accounts:");		
		for(Account a : b.getAllAccounts()) { // displays ever account that is in the bank
			a.checkAccountBalance();
		}
		
		System.out.println("Type the account number to choose an account to close:");
		String userInput = input.next();
		System.out.println();
		
		b.closeAccount(userInput);
		

	}
	
} // end of BankTeller class
