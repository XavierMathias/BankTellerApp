package Banker.Teller.App;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.security.SecureRandom;
import java.util.Scanner;

public class Bank {

	
	Scanner input = new Scanner(System.in);
	Account account;
	private SecureRandom sr = new SecureRandom();
	Map<String, Account> accounts = new HashMap<>();
	ArrayList<Account> accountValues = new ArrayList<>(accounts.values());
	Collection<Account> allAccounts = accountValues;
	

	public Collection<Account> getAllAccounts(){
		
		if(allAccounts.isEmpty()) {
			System.out.println("You have no accounts with us. Create a new account");
			newAccount();
			return allAccounts;
		} else {

			return allAccounts;
		}
		
	} // end of getAllAccounts
	
	// creating a new account and adding accoun2t to accounts 
	public void newAccount() {
		String accountType = "";
		System.out.println("What kind of account would you like to open?\n" // prompts the user what kind of account they would like
				+ "1. Checking\n"
				+ "2. Saving\n");
		int accountSelection = input.nextInt();
		
		switch(accountSelection) {
				case 1: accountType = "Checking";
					break;
				case 2: accountType = "Saving";
					break;
				default: accountType = "Checking";
		} // end of switch 
		
		String newAccountNum = Integer.toString(sr.nextInt(9999));
		System.out.println("This is your new account number:" + newAccountNum);
		
		System.out.println("How much would you be depositing into the " + accountType + " account (" + newAccountNum + ")?");
		double depositAmount = input.nextDouble();
		
		Account newAccount = new Account(newAccountNum, accountType, depositAmount);
		accounts.put(newAccountNum, newAccount);
		allAccounts.add(newAccount);
		
		for(Account a: getAllAccounts()) {
			a.checkAccountBalance();
		}
		
	} // end of openNewAccount
	
	// creates accounts once the program is running
	public void openNewAccount(String accNum, Account a) {
		accounts.put(accNum, a);
		accountValues.add(a);
		
		
	} // end of openNewAccount
	
	// get an account information
	public Account getAccount(String accountNumber) {
		return accounts.get(accountNumber);
		
	} // end of get Account
	
	void closeAccount(String accountNumber) {
		System.out.println("You are closing account " + accountNumber);
		
		// checks if there is still funds in the account before closing the account
		if(accounts.get(accountNumber).accountHasFunds()) {
			System.out.println("Sorry, you cannot close this account due to exisiting funds"
					+ "\nPlease choose another task");
			
		} else {
			allAccounts.remove(accounts.get(accountNumber));
			accounts.remove(accountNumber);
			System.out.println("Here are your remaining accounts");
			for(Account account: accounts.values()) {
				account.checkAccountBalance();
			} // end of enhanced for
		} // end of if...else
		
		

	} // end of closeAccount
	
	
} // end of Bank
