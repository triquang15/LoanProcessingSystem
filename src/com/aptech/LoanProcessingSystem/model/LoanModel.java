package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;

public class LoanModel {

	public List<Loan> findAll() {
		java.util.List<Loan> loans = new ArrayList<Loan>();
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
				loan.setInterest(resultset.getFloat("Interest"));
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

	public boolean create(Loan loan) {
		boolean rs = false;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"insert into loan(Amount, Period, CreateDate, DisbursementDate, Duration, EndDate, Interest, Description, status) values(?,?,?,?,?,?,?,?,?)");
			ps.setDouble(1, loan.getAmount());
			ps.setInt(2, loan.getPeriod());
			ps.setDate(3, new java.sql.Date(loan.getCreateDate().getTime()));
			ps.setDate(4, new java.sql.Date(loan.getDisbursementDate().getTime()));
			ps.setInt(5, loan.getDuration());
			ps.setDate(6, new java.sql.Date(loan.getEndDate().getTime()));
			ps.setFloat(7, loan.getInterest());
			ps.setString(8, loan.getDescription());
			ps.setInt(9, 0);
			rs = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return rs;
	}

	public boolean updateLoan(Loan loan) {
		boolean result = false;
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
			preparedStatement.setFloat(11, loan.getInterest());
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

	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("delete from loan where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public List<Loan> search(String keyword) {
		java.util.List<Loan> loans = new ArrayList<Loan>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from loan where id like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Loan loan = new Loan();
				loan.setId(rs.getInt("Id"));
				loan.setLoanTypeId(rs.getInt("LoanTypeId"));
				loan.setAccountId(rs.getInt("AccountId"));
				loan.setCustomerId(rs.getInt("CustomerId"));
				loan.setPaymentTypeId(rs.getInt("PaymentTypeId"));
				loan.setAmount(rs.getDouble("Amount"));
				loan.setPeriod(rs.getInt("Period"));
				loan.setCreateDate(rs.getDate("CreateDate"));
				loan.setDisbursementDate(rs.getDate("DisbursementDate"));
				loan.setEndDate(rs.getDate("EndDate"));
				loan.setDuration(rs.getInt("Duration"));
				loan.setStatus(rs.getInt("Status"));
				loans.add(loan);
			}
		} catch (Exception e) {
			loans = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loans;
	}

	public Boolean findLoanByID(int id) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("" + "SELECT Id FROM loan WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	// temp
	public Boolean findCustomerByID(int id) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT Id From customer WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}