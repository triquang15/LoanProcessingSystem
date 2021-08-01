package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class Account {

	private int id, accountTypeId;
	private String name, email, password, phone, address, identityCard;
	private int gender;

	private Date dob;
	private boolean status;

	public Account() {
		super();
	}

	public Account(int accountTypeId, String name, String email, String password, String phone, String address,
			String identityCard, int gender, Date dob, boolean status) {
		this.accountTypeId = accountTypeId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.identityCard = identityCard;
		this.gender = gender;
		this.dob = dob;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountTypeId=" + accountTypeId + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", identityCard="
				+ identityCard + ", gender=" + gender + ", dob=" + dob + ", status=" + status + "]";
	}

}