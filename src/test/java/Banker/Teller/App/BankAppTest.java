package Banker.Teller.App;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BankAppTest {

	Bank bank = new Bank();
	
	@Test
	void bankHave2Accounts() {
		Account a = new Account("0001", "Checking", 500);
		Account b = new Account("0002", "Saving", 10);
		bank.openNewAccount(a.getAccNum(), a);
		bank.openNewAccount(b.getAccNum(), b);
		Assertions.assertFalse(bank.accounts.isEmpty());
		Assertions.assertEquals( 2, bank.accounts.size());
	}
	
	@Test
	void thereIsFunds() {
		Account account = new Account("1234", "Checking", 600);
		bank.openNewAccount(account.getAccNum(), account);
		Assertions.assertTrue(account.accountHasFunds());
	}
	
	@Test
	void thereIsNoFunds() {
		Account account = new Account("1112", "Checking", 0);
		bank.openNewAccount(account.getAccNum(), account);
		Assertions.assertFalse(account.accountHasFunds());
	}
	
	@Test
	void withdrawalMoreThanBalance() {
		Account account = new Account("1234", "Checking", 600);
		bank.openNewAccount(account.getAccNum(), account);
		account.withdrawal(700);
		Assertions.assertEquals(0, account.getBalance());
	}

}
