package com.sample;

public class AccountFactory {
	public static Account getAccount(String accountType)
	{
		Account account=null;
		if(accountType.equals("Savings"))
		{
			account=new SavingsAccount();
		}else if(accountType.equals("checking"))
		{
			account=new CheckingAccount();
			
		}
		return account;
	}
}
