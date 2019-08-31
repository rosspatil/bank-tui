package com.zensar.bean;

import java.util.Date;

public class Transaction {
	static int countOfTxn=0;
	private int txnId=100;
	private Date txtDate;
	private String txnType;
	private long accNo;
	private int amount;
	private int custId;
	public int getCustId() {
		return custId;
	}
	public Transaction() {
		this.txnId+=countOfTxn;
	}
	public Transaction(Date txtDate, String txnType,long accNo,int amount,int custId) {
		this();
		this.txtDate = txtDate;
		this.txnType = txnType;
		this.accNo=accNo;
		this.amount=amount;
		this.custId=custId;
		countOfTxn++;
	}
	@Override
	public String toString() {
		return "Transaction [txnId=" + txnId + ", txtDate=" + txtDate
				+ ", txnType=" + txnType +", Account="+accNo+", Amount="+amount+"]";
	}
	
	
	
}
