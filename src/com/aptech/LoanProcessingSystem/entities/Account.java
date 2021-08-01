package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class Account {

	private int id, AccountTypeId;
	private String name, email, password, phone, address, identity_card;
	private int gender;

	private Date dob;
	private boolean status;

	public Account() {
		super();
	}

	public Account(String name, String email, String password, String phone, String address, String identity_card,
			int gender, int AccountTypeId, Date dob, boolean status) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.identity_card = identity_card;
		this.gender = gender;
		this.dob = dob;
		this.status = status;
		this.AccountTypeId = AccountTypeId;
	}

	public int getAccountTypeId() {
		return AccountTypeId;
	}

	public void setAccountTypeId(int accountTypeId) {
		AccountTypeId = accountTypeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getIdentity_card() {
		return identity_card;
	}

	public void setIdentity_card(String identity_card) {
		this.identity_card = identity_card;
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
		return "Account [id=" + id + ", AccountTypeId=" + AccountTypeId + ", name=" + name + ", email=" + email
				+ ", password=" + password + ", phone=" + phone + ", address=" + address + ", identity_card="
				+ identity_card + ", gender=" + gender + ", dob=" + dob + ", status=" + status + "]";
	}

}