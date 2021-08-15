package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class MyLoan {
	private int id;
	private int loanTypeId;
	private String loanType;
	private String account;
	private int accountId;
	private String customer;
	private int customerId;
	private String paymentType;
	private int paymentTypeId;
	private double amount;
	private int period;
	private Date createDate;
	private Date disbursementDate;
	private int duration;
	private Date endDate;
	private float interest;
	private String description;
	private boolean status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(int loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDisbursementDate() {
		return disbursementDate;
	}

	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public MyLoan(int id, int loanTypeId, String loanType, String account, int accountId, String customer,
			int customerId, String paymentType, int paymentTypeId, double amount, int period, Date createDate,
			Date disbursementDate, int duration, Date endDate, float interest, String description, boolean status) {
		super();
		this.id = id;
		this.loanTypeId = loanTypeId;
		this.loanType = loanType;
		this.account = account;
		this.accountId = accountId;
		this.customer = customer;
		this.customerId = customerId;
		this.paymentType = paymentType;
		this.paymentTypeId = paymentTypeId;
		this.amount = amount;
		this.period = period;
		this.createDate = createDate;
		this.disbursementDate = disbursementDate;
		this.duration = duration;
		this.endDate = endDate;
		this.interest = interest;
		this.description = description;
		this.status = status;
	}

	public MyLoan() {
		super();
	}

}
