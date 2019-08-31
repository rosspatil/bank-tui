package com.zensar.bean;

public class Account {
	static int countOfAccount=0;
	private long accountNo=1000000000;
	private int accountBal;
	private String accountType;
	private Transaction txn[]=new Transaction[100];
	
	public Account() {
		this.accountNo+=++countOfAccount;
	}
	
	
	public Account(int accountBal, String accountType) {
		this();
		this.accountBal = accountBal;
		this.accountType = accountType;
	}


	public long getAccountNo() {
		return accountNo;
	}
	public int getAccountBal() {
		return accountBal;
	}
	public void setAccountBal(int accountBal) {
		this.accountBal += accountBal;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Transaction[] getTxn() {
		return txn;
	}
	public void setTxn(Transaction txn1) {
		txn[Transaction.countOfTxn]=txn1;
	}
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", accountBal=" + accountBal
				+ ", accountType=" + accountType + "]";
	}
	
	
}
