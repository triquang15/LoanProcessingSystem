package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Fine;

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
			preparedStatement.setDouble(1, fine.getMin());
			preparedStatement.setDouble(1, fine.getMax());
			preparedStatement.setString(1, fine.getDescription());
			preparedStatement.setBoolean(1, fine.isStatus());
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
			preparedStatement.setDouble(1, fine.getMin());
			preparedStatement.setDouble(1, fine.getMax());
			preparedStatement.setString(1, fine.getDescription());
			preparedStatement.setBoolean(1, fine.isStatus());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}