package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Fine;
import com.aptech.LoanProcessingSystem.entities.Loan;

public class FineModel {

	public List<Fine> getAllFines() {
		List<Fine> fines = null;
		try {
			fines = new ArrayList<>();
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Select * from Fine");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Fine fine = new Fine();
				fine.setId(resultset.getInt("Id"));
				fine.setFineInterest(resultset.getFloat("FineInterest"));
				fine.setMin(resultset.getDouble("Min"));
				fine.setMax(resultset.getDouble("Max"));
				fine.setDescription(resultset.getString("Description"));
				fine.setStatus(resultset.getBoolean("Status"));
				fines.add(fine);
			}
		} catch (Exception e) {
			e.printStackTrace();
			fines = null;
		} finally {
			ConnectDB.disconnect();
		}
		return fines;
	}

	public Boolean createFine(Fine fine) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into Fine(FineInterest, `Min`, `Max`, Description, Status) values(?,?,?,?,?)");
			preparedStatement.setFloat(1, fine.getFineInterest());
			preparedStatement.setDouble(2, fine.getMin());
			preparedStatement.setDouble(3, fine.getMax());
			preparedStatement.setString(4, fine.getDescription());
			preparedStatement.setBoolean(5, fine.isStatus());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Boolean updateFine(Fine fine) {
		Boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("update Fine SET FineInterest = ?, `Min` = ?, `Max` = ?, Description = ?, Status = ?");
			preparedStatement.setFloat(1, fine.getFineInterest());
			preparedStatement.setDouble(2, fine.getMin());
			preparedStatement.setDouble(3, fine.getMax());
			preparedStatement.setString(4, fine.getDescription());
			preparedStatement.setBoolean(5, fine.isStatus());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public Fine find_fine_interest(double installment) {
		Fine fine = new Fine();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("SELECT * FROM fine WHERE ? >= Min and (? < MAX OR MAX IS NULL)");
			statement.setDouble(1, installment);
			statement.setDouble(2, installment);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				fine.setId(resultset.getInt("Id"));
				fine.setFineInterest(resultset.getFloat("FineInterest"));
				fine.setMin(resultset.getDouble("Min"));
				fine.setMax(resultset.getDouble("Max"));
				fine.setDescription(resultset.getString("Description"));
				fine.setStatus(resultset.getBoolean("Status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			fine = null;
		} finally {
			ConnectDB.disconnect();
		}
		return fine;
	}

}