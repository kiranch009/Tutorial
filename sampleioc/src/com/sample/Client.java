package com.sample;

public class Client {
	public static void main(String[] args) {
		//Take input
		String accountType="";
		Account account=AccountFactory.getAccount(accountType);
		
		System.out.println(account.getMinBalance());
	}
}
