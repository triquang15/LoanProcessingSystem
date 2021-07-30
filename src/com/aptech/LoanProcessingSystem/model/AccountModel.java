package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Account;

public class AccountModel {

	public boolean create(Account account) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into users(name,email, password,  phone, address,gender, dob,salary, identity_card, status) values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, account.getName());
			preparedStatement.setString(2, account.getEmail());
			preparedStatement.setString(3, account.getPassword());
			preparedStatement.setString(4, account.getPhone());
			preparedStatement.setString(5, account.getAddress());
			preparedStatement.setInt(6, account.getGender());
			preparedStatement.setDate(7, new java.sql.Date(account.getDob().getTime()));
			preparedStatement.setString(8, account.getSalary());
			preparedStatement.setString(9, account.getIdentity_card());
			preparedStatement.setBoolean(10, account.isStatus());
			result = preparedStatement.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public Account find(String email) {
		Account account = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from users where email = ?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				account = new Account();
				account.setDob(resultSet.getDate("dob"));
				account.setEmail(resultSet.getString("email"));
				account.setName(resultSet.getString("name"));
				account.setId(resultSet.getInt("id"));
				account.setPassword(resultSet.getString("password"));
				account.setStatus(resultSet.getBoolean("status"));
				account.setAddress(resultSet.getString("address"));
				account.setSalary(resultSet.getString("salary"));
				account.setPhone(resultSet.getString("phone"));
				account.setIdentity_card(resultSet.getString("identity_card"));
				account.setGender(resultSet.getInt("gender"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			account = null;
		} finally {
			ConnectDB.disconnect();
		}
		return account;
	}

	public boolean login(String email, String password) {
		Account account = find(email);
		if (account != null) {
			if (BCrypt.checkpw(password, account.getPassword())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean update(Account account) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
				"update users set password = ?, name = ?, email = ?, dob = ?, status = ?, phone = ?, address = ?, identity_card = ?, salary = ?, gender = ? where email = ?");
			preparedStatement.setString(1, account.getPassword());
			preparedStatement.setString(2, account.getName());
			preparedStatement.setString(3, account.getEmail());
			preparedStatement.setDate(4, new java.sql.Date(account.getDob().getTime()));
			preparedStatement.setBoolean(5, account.isStatus());
			preparedStatement.setString(6, account.getPhone());
			preparedStatement.setString(7, account.getAddress());
			preparedStatement.setString(8, account.getIdentity_card());
			preparedStatement.setString(9, account.getSalary());
			preparedStatement.setInt(10, account.getGender());
			
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

}
