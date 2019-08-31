package com.zensar.bussinesslogic;

import com.zensar.bean.Account;

public interface BankFunctionality {

	public Account addAcount();
	public void addCustomer();
	public void displayCustomer(int custId);
	public void credit(String type, long accNo, int bal);
	public void debit(String type, long accNo, int bal);
	public void moneyTransfer(long accNo1, String type1, long accNo2,String type2, int bal);
	public void viewTransactions(int custId);
	public void viewBalance(int custId, long accNo);

}
