package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;

public class LoanModel {

	public List<Loan> getAllLoans() {
		List<Loan> loans = null;
		try {
			loans = new ArrayList<Loan>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from Loan");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getDouble("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}
	
	public List<Loan> getAllLoansByCustomerID(int id) {
		List<Loan> loans = null;
		try {
			loans = new ArrayList<Loan>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement(""
					+ "Select * from loan where CustomerId = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getDouble("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}
	
	public List<Loan> getAllLoanHome(LoanType loanType) {
		List<Loan> loans = null;
		try {
			loans = new ArrayList<Loan>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from Loan where LoanTypeId = ?");
			statement.setInt(1, loanType.getId());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getDouble("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}
	
	public List<Loan> findLoanByLoanType(LoanType loanType, int id) {
		List<Loan> loans = null;
		try {
			loans = new ArrayList<Loan>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement(""
					+ "Select * from Loan where CustomerId = ? AND LoanTypeId = ?");
			statement.setInt(1, id);
			statement.setInt(2, loanType.getId());
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Loan loan = new Loan();
				loan.setId(resultset.getInt("Id"));
				loan.setLoanTypeId(resultset.getInt("LoanTypeId"));
				loan.setAccountId(resultset.getInt("AccountId"));
				loan.setCustomerId(resultset.getInt("CustomerId"));
				loan.setPaymentTypeId(resultset.getInt("PaymentTypeId"));
				loan.setAmount(resultset.getDouble("Amount"));
				loan.setPeriod(resultset.getInt("Period"));
				loan.setCreateDate(resultset.getDate("CreateDate"));
				loan.setDisbursementDate(resultset.getDate("DisbursementDate"));
				loan.setDuration(resultset.getInt("Duration"));
				loan.setEndDate(resultset.getDate("EndDate"));
				loan.setInterest(resultset.getDouble("Interest"));
				loan.setDescription(resultset.getString("Description"));
				loan.setStatus(resultset.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public Boolean createLoan(Loan loan) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into Loan(LoanTypeId, AccountId, PaymentTypeId, CustomerId, Amount, Period, CreateDate, DisbursementDate, EndDate, Duration, Interest, Status, Description) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, loan.getLoanTypeId());
			preparedStatement.setInt(2, loan.getAccountId());
			preparedStatement.setInt(3, loan.getPaymentTypeId());
			preparedStatement.setInt(4, loan.getCustomerId());
			preparedStatement.setDouble(5, loan.getAmount());
			preparedStatement.setInt(6, loan.getPeriod());
			preparedStatement.setDate(7, new java.sql.Date(loan.getCreateDate().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(loan.getDisbursementDate().getTime()));
			preparedStatement.setDate(9, new java.sql.Date(loan.getEndDate().getTime()));
			preparedStatement.setInt(10, loan.getDuration());
			preparedStatement.setDouble(11, loan.getInterest());
			preparedStatement.setInt(12, loan.getStatus());
			preparedStatement.setString(13, loan.getDescription());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Boolean updateLoan(Loan loan) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update Loan SET LoanTypeId = ?, AccountId = ?, PaymentTypeId = ?, CustomerId = ?, Amount = ?, Period = ?, CreateDate = ?, DisbursementDate = ?, EndDate = ?, Duration = ?, Interest = ?, Status = ?, Description = ?");
			preparedStatement.setInt(1, loan.getLoanTypeId());
			preparedStatement.setInt(2, loan.getAccountId());
			preparedStatement.setInt(3, loan.getPaymentTypeId());
			preparedStatement.setInt(4, loan.getCustomerId());
			preparedStatement.setDouble(5, loan.getAmount());
			preparedStatement.setInt(6, loan.getPeriod());
			preparedStatement.setDate(7, new java.sql.Date(loan.getCreateDate().getTime()));
			preparedStatement.setDate(8, new java.sql.Date(loan.getDisbursementDate().getTime()));
			preparedStatement.setDate(9, new java.sql.Date(loan.getEndDate().getTime()));
			preparedStatement.setInt(10, loan.getDuration());
			preparedStatement.setDouble(11, loan.getInterest());
			preparedStatement.setInt(12, loan.getStatus());
			preparedStatement.setString(13, loan.getDescription());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public Boolean findLoanByID(int id) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(""
					+ "SELECT Id FROM loan WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	//temp
	public Boolean findCustomerByID  (int id) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT Id From customer WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	//temp
}