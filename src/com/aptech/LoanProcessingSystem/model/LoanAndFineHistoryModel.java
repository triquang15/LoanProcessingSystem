package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;

public class LoanAndFineHistoryModel {

	public List<LoanAndFineHistory> getAllLoanAndFineHistorys() {
		List<LoanAndFineHistory> loanAndFineHistorys = null;
		try {
			loanAndFineHistorys = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from LoanAndFineHistory");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
				loanAndFineHistory.setId(resultset.getInt("Id"));
				loanAndFineHistory.setLoanId(resultset.getInt("LoanId"));
				loanAndFineHistory.setFineId(resultset.getInt("FineId"));
				loanAndFineHistory.setPaymentMethodId(resultset.getInt("PaymentMethodId"));
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
					"insert into LoanAndFineHistory(LoanId, FineId, PaymentMethodId, PaymentAmount, AmountLeft, DueDate, FineInterest, FineOverDays, FineAmount, PaymentDate, Description, Status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setInt(1, loanAndFineHistory.getLoanId());
			preparedStatement.setInt(2, loanAndFineHistory.getFineId());
			preparedStatement.setInt(3, loanAndFineHistory.getPaymentMethodId());
			preparedStatement.setDouble(4, loanAndFineHistory.getPaymentAmount());
			preparedStatement.setDouble(5, loanAndFineHistory.getAmountLeft());
			preparedStatement.setDate(6, new java.sql.Date(loanAndFineHistory.getDueDate().getTime()));
			preparedStatement.setFloat(7, loanAndFineHistory.getFineInterest());
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
			preparedStatement.setFloat(7, loanAndFineHistory.getFineInterest());
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

}