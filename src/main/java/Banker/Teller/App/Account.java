package Banker.Teller.App;
import java.util.Scanner;

public class Account {

	private String accountNumber = "";
	private String accountType = "";
	private double accountBalance = 0.0; 
	private boolean hasFunds = false;
	Scanner input = new Scanner(System.in);
	
	Account(String accountNumber, String accountType, double accountBalance){
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		if(this.accountBalance > 0) {
			hasFunds = true;
		}
		
		
		
	} // end of constructor
	
	// adding funds to the account
	protected void deposit(double amount) {
		accountBalance += amount;
		hasFunds = true;
		System.out.println("You desposited " + amount);
		System.out.println("Your updated balance on account " + accountNumber + " is now " + accountBalance);
	} // end of deposit
	
	// retrieving funds
	protected void withdrawal(double amount) {
		
		if(hasFunds) { // checks if there is still funds in the account
			
			if(amount > accountBalance) { // checks if the withdrawal amount is greater than the account's balance
				System.out.println("Your withdrawal demand is greater than what you have in this account"
						+ "\nWould you like to withdrawal all your funds from the account?"
						+ "\nType 'Yes' or 'No");
				String response = input.next();
				if(response.equals("Yes")) {
					accountBalance = 0;
					hasFunds = false;
					System.out.println("The account is empty.");	
				}
				
					
				
			} else {
				
				accountBalance -= amount;
				if(accountBalance == 0) {
					hasFunds = false;
				}
				System.out.println("You withdrew " + amount);
				System.out.println("Your updated balance on account " + accountNumber + " is now " + accountBalance);
			}
			
			
		} else {
			System.out.println("There is no funds in this account");
		} 
		
	} // end of withdrawal
	
	// returns if the account has any funds
	public boolean accountHasFunds() {
		return hasFunds;
	}
	
	// displays available funds
	protected void checkAccountBalance() {
		System.out.printf("(%s) %s $%f%n", accountNumber, accountType, accountBalance);
	} // end of checkAccountBalance 
	
	protected String getAccNum() {
		return accountNumber;
	}
	
	protected double getBalance() {
		return accountBalance;
	}
	
} // end of Account class

