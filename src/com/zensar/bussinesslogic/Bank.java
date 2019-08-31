package com.zensar.bussinesslogic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import com.zensar.bean.Account;
import com.zensar.bean.Address;
import com.zensar.bean.Customer;
import com.zensar.bean.Transaction;
import com.zensar.exceptions.BalanceLowException;
import com.zensar.exceptions.CustomerNotFoundException;


public class Bank implements BankFunctionality{

	Scanner sc=new Scanner(System.in);
	static ArrayList<Customer> custArr=new ArrayList<>();
	static ArrayList<Transaction> txnArr=new ArrayList<>();
	Address add=null;
	Account ac=null;

	public Account addAcount(){
		System.out.println("Enter Type:");
		String accountType=sc.next();
		System.out.println("Enter Balance:");
		int accountBal=sc.nextInt();
		return new Account(accountBal, accountType);
	}

	public Address addAddress(){
		System.out.println("Enter flat no:");
		int houseNo=sc.nextInt();
		System.out.println("Enter street:");
		String street=sc.next();
		System.out.println("Enter Landmark:");
		String landMark=sc.next();
		System.out.println("Enter city:");
		String city=sc.next();
		System.out.println("Enter state:");
		String state=sc.next();
		System.out.println("Enter zipcode:");
		int zipCode=sc.nextInt();		
		return new Address(houseNo, street, landMark, city, state, zipCode);
	}

	public void addCustomer() {
		System.out.println("Enter name:");
		String name=sc.next();
		System.out.println("Enter gender:");
		String gender=sc.next();
		System.out.println("Enter Contact:");
		String contact=sc.next();
		custArr.add(new Customer(name, gender, contact, addAddress()));
		System.out.println("Customer added successfully.........");
	}

	public void setAccount(int custId) {
		for (int i = 0; i < custArr.size(); i++) {
			Customer cust=custArr.get(i);
			if(cust.getCustId()==custId){
				ac=addAcount();
				if(ac.getAccountType().equalsIgnoreCase("saving")){
					cust.setSaving(ac);
				}else if(ac.getAccountType().equalsIgnoreCase("current")){
					cust.setCurrent(ac);
				}
				return;
			}
		}
		try{
			throw new CustomerNotFoundException("Customer not found");
		}catch(CustomerNotFoundException e){
			System.err.println(e.getMessage());
		}

	}

	public void displayCustomer(int custId) {
		for (Customer cust : custArr) {
			if(cust.getCustId()==custId){
				System.out.println(cust);
				if(cust.getSaving()!=null){
					System.out.println(cust.getSaving());
				}
				if(cust.getCurrent()!=null){
					System.out.println(cust.getCurrent());
				}
				return;
			}
		}
		try{
			throw new CustomerNotFoundException("Customer not found");
		}catch(CustomerNotFoundException e){
			System.err.println(e.getMessage());
		}

	}

	public boolean checkAccount(int custId,long accNo) {
		boolean status=false;
		for (Customer cust : custArr) {			
			if(cust.getCustId()==custId){
				Account ac1=cust.getSaving();
				Account ac2=cust.getCurrent();
				if(ac1!=null && ac1.getAccountNo()==accNo ){
					status=true;
					break;

				}else if(ac2!=null && ac2.getAccountNo()==accNo ){
					status=true;
					break;
				}
			}
		}
		return status;
	}

	public void credit(String type, long accNo, int bal) {
		for (int i = 0; i < custArr.size(); i++) {
			Customer cust=custArr.get(i);
			if(checkAccount(cust.getCustId(),accNo) && type.equalsIgnoreCase("saving") ){
				if(cust.getSaving().getAccountBal()<bal){
					try {
						throw new BalanceLowException("Insuffucient Balance!\nBal="+cust.getSaving().getAccountBal());
					} catch (BalanceLowException e) {
						System.err.println(e.getMessage());
					}
					break;
				}
				cust.getSaving().setAccountBal(bal);
				txnArr.add(new Transaction(Calendar.getInstance().getTime(), "Credited", accNo, bal,cust.getCustId()));
				return;
			}else if(checkAccount(cust.getCustId(),accNo)&&type.equalsIgnoreCase("current")){
				if(cust.getCurrent().getAccountBal()<bal){
					try {
						throw new BalanceLowException("Insuffucient Balance!\nBal="+cust.getCurrent().getAccountBal());
					} catch (BalanceLowException e) {
						System.err.println(e.getMessage());
					}
					break;
				}
				cust.getCurrent().setAccountBal(bal);
				txnArr.add(new Transaction(Calendar.getInstance().getTime(), "Credited", accNo, bal,cust.getCustId()));
				return;
			}
		}



	}

	public void debit(String type, long accNo, int bal) {
		for (int i = 0; i < custArr.size(); i++) {
			Customer cust=custArr.get(i);			
			if(checkAccount(cust.getCustId(),accNo) && type.equalsIgnoreCase("saving")){
				cust.getSaving().setAccountBal(-bal);
				System.out.println("New balance="+(cust.getSaving().getAccountBal()));
				txnArr.add(new Transaction(Calendar.getInstance().getTime(), "Debited", accNo, bal,cust.getCustId()));
				return;
			}else if(checkAccount(cust.getCustId(),accNo)&&type.equalsIgnoreCase("current")){
				cust.getCurrent().setAccountBal(-bal);
				System.out.println("New balance="+(cust.getCurrent().getAccountBal()));
				txnArr.add(new Transaction(Calendar.getInstance().getTime(), "Debited", accNo, bal,cust.getCustId()));
				return;
			}
		}

	}

	public void moneyTransfer(long accNo1, String type1, long accNo2,String type2, int bal) {
		debit(type1, accNo1, bal);
		credit(type2, accNo2, bal);
	}

	public void viewBalance(int custId, long accNo) {
		for (Customer cust : custArr) {
			if(cust.getCustId()==custId){
				if(cust.getSaving()!=null && cust.getSaving().getAccountNo()==accNo){
					System.out.println("Balance:"+cust.getSaving().getAccountBal());
				}
				if(cust.getCurrent()!=null && cust.getCurrent().getAccountNo()==accNo){
					System.out.println("Balance:"+cust.getCurrent().getAccountBal());
				}
				return;
			}
		} 

	}

	public void viewTransactions(int custId) {
		for (Transaction txn : txnArr) {
			if(custId==txn.getCustId()){
				System.out.println(txn);
			}
		}


	}






}