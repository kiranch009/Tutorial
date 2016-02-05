package com.sample;

public interface Account {
	public Long getMinBalance();
	public Long getWithDrawLimit();
	public boolean transfer(Account targetAccount);
}
