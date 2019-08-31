package com.zensar.bussinesslogic;

import java.util.Scanner;

public class BanKDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Bank cust=new Bank();
		int ch;

		while(true){
			System.out.println("***** Bank of India *****");
			System.out.println("1.New Customer\n2.Add Account\n3.View Customer\n4.Credit amount\n5.Debit amount\n6.Money Transfer\n7.View Balance\n8.Exit");
			ch=sc.nextInt();

			switch (ch) {
			case 1:{
				cust.addCustomer();
			}				
			break;

			case 2:{
				System.out.println("Enter CustId:");
				int custId=sc.nextInt();
				cust.setAccount(custId);
			}
			break;
			case 3:{
				System.out.println("Enter CustId:");
				int custId=sc.nextInt();
				cust.displayCustomer(custId);
				System.out.println("Do you want to see Transactions for this account?[y/n]");
				String ans=sc.next();
				if(ans.equalsIgnoreCase("y")){
					cust.viewTransactions(custId);
				}
				break;
			}
			case 4:{
				System.out.println("Enter CustId:");
				int custId=sc.nextInt();
				System.out.println("Enter account No:");
				long accNo=sc.nextLong();
				if(cust.checkAccount(custId,accNo)){
					System.out.println("Enter type:");
					String type=sc.next();
					System.out.println("Enter amount: ");
					int bal=sc.nextInt();
					cust.credit(type,accNo,bal);

				}
				break;
			}
			case 5:{

				System.out.println("Enter CustId:");
				int custId=sc.nextInt();
				System.out.println("Enter account No:");
				long accNo=sc.nextLong();
				if(cust.checkAccount(custId,accNo)){
					System.out.println("Enter type:");
					String type=sc.next();
					System.out.println("Enter amount: ");
					int bal=sc.nextInt();
					cust.debit(type,accNo,bal);				
				}
				break;
			}

			case 6:{
				System.out.println("Enter debit account No:");
				long accNo1=sc.nextLong();
				System.out.println("Enter type:");
				String type1=sc.next();
				System.out.println("Enter credit account No:");
				long accNo2=sc.nextLong();
				System.out.println("Enter type:");
				String type2=sc.next();
				System.out.println("Enter amount: ");
				int bal=sc.nextInt();
				cust.moneyTransfer(accNo1, type1, accNo2, type2,bal);
				break;
			}
			
			
			case 7:{
				System.out.println("Enter CustId:");
				int custId=sc.nextInt();
				System.out.println("Enter account No:");
				long accNo=sc.nextLong();
				cust.viewBalance(custId, accNo);
				break;
			}
			case 8:{
				System.out.println("Thankyou for banking with us :)");
				System.exit(0);
				break;
			}

			}
		}

	}

}
