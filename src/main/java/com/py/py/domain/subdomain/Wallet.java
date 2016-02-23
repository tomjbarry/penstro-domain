package com.py.py.domain.subdomain;

public interface Wallet {

	String getIdAsString();
	void setIdAsString(String id);
	
	Balance getBalance();
	void setBalance(Balance balance);
}
