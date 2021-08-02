package com.aptech.LoanProcessingSystem.entities;

import java.util.Date;

public class LoanAndFindHistory {
	private int id;
	private int loanId;
	private int fineId;
	private int paymentMethodId;
	private double paymentAmount;
	private double amountLeft;
	private Date dueDate;
	private float fineInterest;
	private int fineOverDays;
	private double fineAmount;
	private Date paymentDate;
	private String description;
	private boolean status;

	public LoanAndFindHistory() {
		super();
	}

	public LoanAndFindHistory(int id, int loanId, int fineId, int paymentMethodId, double paymentAmount,
			double amountLeft, Date dueDate, float fineInterest, int fineOverDays, double fineAmount, Date paymentDate,
			String description, boolean status) {
		super();
		this.id = id;
		this.loanId = loanId;
		this.fineId = fineId;
		this.paymentMethodId = paymentMethodId;
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

	public float getFineInterest() {
		return fineInterest;
	}

	public void setFineInterest(float fineInterest) {
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
