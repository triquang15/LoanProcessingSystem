package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class MyLoanAndFineHistory {
	private int id;
	private String customer;
	private double amount;
	private String paymentMethod;
	private double paymentAmount;
	private double amountLeft;
	private Date dueDate;
	private double fineInterest;
	private int fineOverDays;
	private double fineAmount;
	private Date paymentDate;
	private String description;
	private boolean status;

	public MyLoanAndFineHistory(int id, String customer, double amount, String fine, String paymentMethod,
			double paymentAmount, double amountLeft, Date dueDate, double fineInterest, int fineOverDays,
			double fineAmount, Date paymentDate, String description, boolean status) {
		super();
		this.id = id;
		this.customer = customer;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentAmount = paymentAmount;
		this.amountLeft = amountLeft;
		this.dueDate = dueDate;
		this.fineInterest = fineInterest;
		this.fineOverDays = fineOverDays;
		this.fineAmount = fineAmount;
		this.paymentDate = paymentDate;
		this.description = description;
		this.status = status;
	}

	public MyLoanAndFineHistory() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
	
}
