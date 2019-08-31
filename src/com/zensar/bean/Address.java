package com.zensar.bean;

public class Address {

	private int houseNo;
	private String street;
	private String landMark;
	private String city;
	private String state;
	private int zipCode;
	public Address(int houseNo, String street, String landMark, String city,
			String state, int zipCode) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.landMark = landMark;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street
				+ ", landMark=" + landMark + ", city=" + city + ", state="
				+ state + ", zipCode=" + zipCode + "]";
	}



}
