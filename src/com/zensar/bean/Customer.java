package com.zensar.bean;


public class Customer {
	static int countOfCust=0;
	private String name;
	private int custId=100;
	private String gender;
	private String contact;
	private Address add;
	private Account saving;
	private Account current;
	public Customer(String name, String gender, String contact,
			Address add) {
		countOfCust++;
		this.name = name;
		this.custId+=countOfCust;
		this.gender = gender;
		this.contact = contact;
		this.add = add;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Address getAdd() {
		return add;
	}
	public void setAdd(Address add) {
		this.add = add;
	}
	
	
	public Account getSaving() {
		return saving;
	}
	public void setSaving(Account saving) {
		this.saving = saving;
	}
	public Account getCurrent() {
		return current;
	}
	public void setCurrent(Account current) {
		this.current = current;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", custId=" + custId + ", gender="
				+ gender + ", contact=" + contact + ", add=" + add +  "]";
	}
	
	
	@Override
	public boolean equals(Object obj) {
		Customer cs=(Customer) obj;
		return this.getCustId()==cs.getCustId();
	}
	

}
