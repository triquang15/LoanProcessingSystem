package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class LoanAndFineHistory {
	private int id;
	private int loanId;
	private String customer;
	private int fineId;
	private int paymentMethodId;
	private String paymentMenthodName;
	private double paymentAmount;
	private double amountLeft;
	private Date dueDate;
	private double fineInterest;
	private int fineOverDays;
	private double fineAmount;
	private Date paymentDate;
	private String description;
	private boolean status;
	private double amount;

	public LoanAndFineHistory() {
		super();
	}

	public LoanAndFineHistory(int id, int loanId, String customer, int fineId, int paymentMethodId,
			String paymentMenthodName, double paymentAmount, double amountLeft, Date dueDate, double fineInterest,
			int fineOverDays, double fineAmount, Date paymentDate, String description, boolean status, double amount) {
		super();
		this.id = id;
		this.loanId = loanId;
		this.customer = customer;
		this.fineId = fineId;
		this.paymentMethodId = paymentMethodId;
		this.paymentMenthodName = paymentMenthodName;
		this.paymentAmount = paymentAmount;
		this.amountLeft = amountLeft;
		this.dueDate = dueDate;
		this.fineInterest = fineInterest;
		this.fineOverDays = fineOverDays;
		this.fineAmount = fineAmount;
		this.paymentDate = paymentDate;
		this.description = description;
		this.status = status;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getFineId() {
		return fineId;
	}

	public void setFineId(int fineId) {
		this.fineId = fineId;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentMenthodName() {
		return paymentMenthodName;
	}

	public void setPaymentMenthodName(String paymentMenthodName) {
		this.paymentMenthodName = paymentMenthodName;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getAmountLeft() {
		return amountLeft;
	}

	public void setAmountLeft(double amountLeft) {
		this.amountLeft = amountLeft;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getFineInterest() {
		return fineInterest;
	}

	public void setFineInterest(double fineInterest) {
		this.fineInterest = fineInterest;
	}

	public int getFineOverDays() {
		return fineOverDays;
	}

	public void setFineOverDays(int fineOverDays) {
		this.fineOverDays = fineOverDays;
	}

	public double getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(double fineAmount) {
		this.fineAmount = fineAmount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
