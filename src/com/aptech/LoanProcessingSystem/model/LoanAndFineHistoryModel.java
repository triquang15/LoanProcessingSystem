package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.swing.JOptionPane;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.entities.MyLoanAndFineHistory;

public class LoanAndFineHistoryModel {

	public List<MyLoanAndFineHistory> getAllLoanAndFineHistorys() {
		List<MyLoanAndFineHistory> loanAndFineHistorys = null;
		try {
			loanAndFineHistorys = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select a.*, c.Name as 'CName', d.Name as 'PMName' from LoanAndFineHistory a\r\n"
					+ "left JOIN loan b on a.LoanId = b.Id\r\n"
					+ "left join customer c on c.id = b.CustomerId\r\n"
					+ "left join paymentmethod d on d.id = a.PaymentMethodId");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				MyLoanAndFineHistory loanAndFineHistory = new MyLoanAndFineHistory();
				loanAndFineHistory.setId(resultset.getInt("Id"));
				loanAndFineHistory.setCustomer(resultset.getString("CName"));
				loanAndFineHistory.setAmount(resultset.getDouble("Amount"));
				loanAndFineHistory.setPaymentMethod(resultset.getString("PMName"));
				loanAndFineHistory.setPaymentAmount(resultset.getDouble("PaymentAmount"));
				loanAndFineHistory.setAmountLeft(resultset.getDouble("AmountLeft"));
				loanAndFineHistory.setDueDate(resultset.getDate("DueDate"));
				loanAndFineHistory.setFineInterest(resultset.getFloat("FineInterest"));
				loanAndFineHistory.setFineOverDays(resultset.getInt("FineOverDays"));
				loanAndFineHistory.setFineAmount(resultset.getDouble("FineAmount"));
				loanAndFineHistory.setPaymentDate(resultset.getDate("PaymentDate"));
				loanAndFineHistory.setDescription(resultset.getString("Description"));
				loanAndFineHistory.setStatus(resultset.getBoolean("Status"));
				loanAndFineHistorys.add(loanAndFineHistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loanAndFineHistorys = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanAndFineHistorys;
	}

	public Boolean createLoanAndFineHistory(LoanAndFineHistory loanAndFineHistory) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into LoanAndFineHistory(FineId, PaymentMethodId, PaymentAmount, AmountLeft, DueDate, FineInterest, FineOverDays, FineAmount, PaymentDate, Description, Status, LoanId, Amount) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, loanAndFineHistory.getFineId());
			preparedStatement.setInt(2, loanAndFineHistory.getPaymentMethodId());
			preparedStatement.setDouble(3, loanAndFineHistory.getPaymentAmount());
			preparedStatement.setDouble(4, loanAndFineHistory.getAmountLeft());
			preparedStatement.setDate(5, new java.sql.Date(loanAndFineHistory.getDueDate().getTime()));
			preparedStatement.setDouble(6, loanAndFineHistory.getFineInterest());
			preparedStatement.setInt(7, loanAndFineHistory.getFineOverDays());
			preparedStatement.setDouble(8, loanAndFineHistory.getFineAmount());
			preparedStatement.setDate(9, new java.sql.Date(loanAndFineHistory.getPaymentDate().getTime()));
			preparedStatement.setString(10, loanAndFineHistory.getDescription());
			preparedStatement.setBoolean(11, loanAndFineHistory.isStatus());
			preparedStatement.setInt(12, loanAndFineHistory.getLoanId());
			preparedStatement.setDouble(13, loanAndFineHistory.getAmount());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Boolean updateLoanAndFineHistory(LoanAndFineHistory loanAndFineHistory) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update LoanAndFineHistory SET LoanId = ?, FineId = ?, PaymentMethodId = ?, PaymentAmount = ?, AmountLeft = ?, DueDate = ?, FineInterest = ?, FineOverDays = ?, FineAmount = ?, PaymentDate = ?, Description = ?, Status = ?)");
			preparedStatement.setInt(1, loanAndFineHistory.getLoanId());
			preparedStatement.setInt(2, loanAndFineHistory.getFineId());
			preparedStatement.setInt(3, loanAndFineHistory.getPaymentMethodId());
			preparedStatement.setDouble(4, loanAndFineHistory.getPaymentAmount());
			preparedStatement.setDouble(5, loanAndFineHistory.getAmountLeft());
			preparedStatement.setDate(6, new java.sql.Date(loanAndFineHistory.getDueDate().getTime()));
			preparedStatement.setDouble(7, loanAndFineHistory.getFineInterest());
			preparedStatement.setInt(8, loanAndFineHistory.getFineOverDays());
			preparedStatement.setDouble(9, loanAndFineHistory.getFineAmount());
			preparedStatement.setDate(10, new java.sql.Date(loanAndFineHistory.getPaymentDate().getTime()));
			preparedStatement.setString(11, loanAndFineHistory.getDescription());
			preparedStatement.setBoolean(12, loanAndFineHistory.isStatus());
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
				.prepareStatement("delete from LoanAndFineHistory where id = ?");
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public LoanAndFineHistory search_history_based_on_id (int keyword) {
		LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from LoanAndFineHistory where id = ?");
			preparedStatement.setInt(1, keyword);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				loanAndFineHistory.setId(rs.getInt("Id"));
				loanAndFineHistory.setLoanId(rs.getInt("LoanId"));
				loanAndFineHistory.setFineId(rs.getInt("FineId"));
				loanAndFineHistory.setPaymentMethodId(rs.getInt("PaymentMethodId"));
				loanAndFineHistory.setPaymentAmount(rs.getDouble("PaymentAmount"));
				loanAndFineHistory.setAmount(rs.getDouble("Amount"));
				loanAndFineHistory.setAmountLeft(rs.getDouble("AmountLeft"));
				loanAndFineHistory.setDueDate(rs.getDate("DueDate"));
				loanAndFineHistory.setFineInterest(rs.getFloat("FineInterest"));
				loanAndFineHistory.setFineOverDays(rs.getInt("FineOverDays"));
				loanAndFineHistory.setFineAmount(rs.getDouble("FineAmount"));
				loanAndFineHistory.setPaymentDate(rs.getDate("PaymentDate"));
				loanAndFineHistory.setDescription(rs.getString("Description"));
				loanAndFineHistory.setStatus(rs.getBoolean("Status"));
			} else {
				loanAndFineHistory = null;
			}
		} catch (Exception e) {
			loanAndFineHistory = null;
		} finally {
			ConnectDB.disconnect();
		}

		return loanAndFineHistory;
	}
	
	public Boolean update_payment(LoanAndFineHistory loanAndFineHistory) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"update LoanAndFineHistory SET PaymentAmount = ?, AmountLeft = ?, FineOverDays = ?, FineAmount = ?, PaymentDate = ?, Description = ? WHERE Id = ?");
			preparedStatement.setDouble(1, loanAndFineHistory.getPaymentAmount());
			preparedStatement.setDouble(2, loanAndFineHistory.getAmountLeft());
			preparedStatement.setInt(3, loanAndFineHistory.getFineOverDays());
			preparedStatement.setDouble(4, loanAndFineHistory.getFineAmount());
			preparedStatement.setDate(5, new java.sql.Date(loanAndFineHistory.getPaymentDate().getTime()));
			preparedStatement.setString(6, loanAndFineHistory.getDescription());
			preparedStatement.setInt(7, loanAndFineHistory.getId());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
	public List<MyLoanAndFineHistory> search(String keyword) {
		List<MyLoanAndFineHistory> loanAndFineHistorys = null;
		try {
			loanAndFineHistorys = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select a.*, c.Name as 'CName', d.Name as 'PMName' from LoanAndFineHistory a\r\n"
					+ "left JOIN loan b on a.LoanId = b.Id\r\n"
					+ "left join customer c on c.id = b.CustomerId\r\n"
					+ "left join paymentmethod d on d.id = a.PaymentMethodId\r\n "
					+ "where c.Name like ?");
			statement.setString(1, "%" + keyword + "%");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				MyLoanAndFineHistory loanAndFineHistory = new MyLoanAndFineHistory();
				loanAndFineHistory.setId(resultset.getInt("Id"));
				loanAndFineHistory.setCustomer(resultset.getString("CName"));
				loanAndFineHistory.setAmount(resultset.getDouble("Amount"));
				loanAndFineHistory.setPaymentMethod(resultset.getString("PMName"));
				loanAndFineHistory.setPaymentAmount(resultset.getDouble("PaymentAmount"));
				loanAndFineHistory.setAmountLeft(resultset.getDouble("AmountLeft"));
				loanAndFineHistory.setDueDate(resultset.getDate("DueDate"));
				loanAndFineHistory.setFineInterest(resultset.getFloat("FineInterest"));
				loanAndFineHistory.setFineOverDays(resultset.getInt("FineOverDays"));
				loanAndFineHistory.setFineAmount(resultset.getDouble("FineAmount"));
				loanAndFineHistory.setPaymentDate(resultset.getDate("PaymentDate"));
				loanAndFineHistory.setDescription(resultset.getString("Description"));
				loanAndFineHistory.setStatus(resultset.getBoolean("Status"));
				loanAndFineHistorys.add(loanAndFineHistory);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loanAndFineHistorys = null;
		} finally {
			ConnectDB.disconnect();
		}
		return loanAndFineHistorys;
	}
}