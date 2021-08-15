package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class Loan {
	private int id;
	private int loanTypeId;
	private int accountId;
	private int customerId;
	private int paymentTypeId;
	private double amount;
	private int period;
	private Date createDate;
	private Date disbursementDate;
	private int duration;
	private Date endDate;
	private double interest;
	private String description;
	private int status;

	public Loan() {
		super();
	}

	public Loan(int id, int loanTypeId, int accountId, int customerId, int paymentTypeId, Double amount, int period,
			Date createDate, Date disbursementDate, int duration, Date endDate, Float interest, String description,
			int status) {
		super();
		this.id = id;
		this.loanTypeId = loanTypeId;
		this.accountId = accountId;
		this.customerId = customerId;
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

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getPaymentTypeId() {
		return paymentTypeId;
	}

	public void setPaymentTypeId(int paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
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

	public Double getInterest() {
		return interest;
	}

	public void setInterest(Double interest) {
		this.interest = interest;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
