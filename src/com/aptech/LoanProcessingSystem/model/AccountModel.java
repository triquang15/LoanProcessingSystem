package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Account;

public class AccountModel {

	public boolean create(Account account) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into account(Name,Email, Password,  Phone, Address,Gender, DOB, IdentityCard, Status, AuthId) values(?,?,?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, account.getName());
			preparedStatement.setString(2, account.getEmail());
			preparedStatement.setString(3, account.getPassword());
			preparedStatement.setString(4, account.getPhone());
			preparedStatement.setString(5, account.getAddress());
			preparedStatement.setBoolean(6, account.isGender());
			preparedStatement.setDate(7, new java.sql.Date(account.getDob().getTime()));
			preparedStatement.setString(8, account.getIdentityCard());
			preparedStatement.setBoolean(9, true);
			preparedStatement.setInt(10, account.getAuthId());
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
//	public boolean update(Account account) {
//		boolean result = true;
//		try {
//			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
//					"UPDATE account SET Name=?"
//					+ ",Address=?,Phone=?,"
//					+ "Email=?,Gender=?,DOB=?,"
//					+ "IdentityCard=?,Status=? WHERE Id = ?");
//			preparedStatement.setString(1, account.getAuthId());
//			preparedStatement.setString(2, account.getName());
//			preparedStatement.setString(2, account.getName());
//			preparedStatement.setString(, account.getEmail());
//			preparedStatement.setString(3, account.getPassword());
//			preparedStatement.setString(4, account.getPhone());
//			preparedStatement.setString(5, account.getAddress());
//			preparedStatement.setBoolean(6, account.isGender());
//			preparedStatement.setDate(7, new java.sql.Date(account.getDob().getTime()));
//			preparedStatement.setString(8, account.getIdentityCard());
//			preparedStatement.setBoolean(9, true);
//			result = preparedStatement.executeUpdate() > 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = false;
//		} finally {
//			ConnectDB.disconnect();
//		}
//		return result;
//	}

	public Account login(String email, String password) {
		Account account = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from account where Email = ?");
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				String hashPass = resultSet.getString("Password");
				if (BCrypt.checkpw(password, hashPass)) {
					account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setPassword(hashPass);
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			account = null;
		} finally {
			ConnectDB.disconnect();
		}
		return account;
	}
	
	public List<Account> loadAllEmployee() {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from account where AuthId = 1");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public List<Account> loadEmployeeExisted() {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from account where AuthId = 1 and status = true");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public List<Account> loadEmployeeDeleted() {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from account where AuthId = 1 and status = false");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public List<Account> find(String name) {
		List<Account> employeeList = new ArrayList<Account>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from account where AuthId = 1 AND Name like ?");
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
					Account account = new Account();
					account.setId(resultSet.getInt("Id"));
					account.setAuthId(resultSet.getInt("AuthId"));
					account.setDob(resultSet.getDate("DOB"));
					account.setEmail(resultSet.getString("Email"));
					account.setName(resultSet.getString("Name"));
					account.setStatus(resultSet.getBoolean("Status"));
					account.setAddress(resultSet.getString("Address"));
					account.setPhone(resultSet.getString("Phone"));
					account.setIdentityCard(resultSet.getString("IdentityCard"));
					account.setGender(resultSet.getBoolean("Gender"));
					employeeList.add(account);
					}
		} catch (Exception e) {
			employeeList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employeeList;
	}
	
	public boolean delete(int id) {
		boolean result = false;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE account SET status = false "
							+ "WHERE Id = ?");
			preparedStatement.setInt(1, id);
			result  = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			// TODO: handle exception
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

//	// temp
//	public boolean login(String email, String password) {
//		Account account = find(email);
//		if (account != null) {
//			if (BCrypt.checkpw(password, account.getPassword())) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public boolean login2(String email, String password) {
//		Account account = find(email);
//		if (account != null) {
//			if (account.getPassword().equals(password)) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public int checkAuthorization (String email) {
//		int i = -1;
//		try {
//			PreparedStatement preparedStatement = ConnectDB.connection().
//					prepareStatement("Select AuthId From account where Email = ?");
//			preparedStatement.setString(1, email);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				i = resultSet.getInt("AuthId");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			i = -1;
//		} finally {
//			ConnectDB.disconnect();
//		}
//		return i;
//	}
	
	public boolean changePass(Account account) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("update account set Password = ? where email = ?");
			preparedStatement.setString(1, account.getPassword());
			preparedStatement.setString(2, account.getEmail());
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
