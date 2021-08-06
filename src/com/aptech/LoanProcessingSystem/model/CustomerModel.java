package com.aptech.LoanProcessingSystem.model;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Customer;

public class CustomerModel {

	public boolean create(Customer customer) {
		boolean rs = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"insert into customer(name, address, phone, email, gender, dob, salary, job, company, IdentityCard) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getPhone());
			ps.setString(4, customer.getEmail());
			ps.setBoolean(5, customer.isGender());
			ps.setDate(6, new java.sql.Date(customer.getDob().getTime()));
			ps.setFloat(7, customer.getSalary());
			ps.setString(8, customer.getJob());
			ps.setString(9, customer.getCompany());
			ps.setString(10, customer.getIdentityCard());

			rs = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			rs = false;
		} finally {
			ConnectDB.disconnect();
		}
		return rs;
	}

	public java.util.List<Customer> findAll() {
		java.util.List<Customer> customers = new ArrayList<Customer>();

		try {

			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setName(rs.getString("Name"));
				customer.setAddress(rs.getString("Address"));
				customer.setPhone(rs.getString("Phone"));
				customer.setEmail(rs.getString("Email"));
				customer.setGender(rs.getBoolean("Gender"));
				customer.setDob(rs.getDate("DOB"));
				customer.setSalary(rs.getFloat("Salary"));
				customer.setJob(rs.getString("Job"));
				customer.setCompany(rs.getString("Company"));
				customer.setIdentityCard(rs.getString("IdentityCard"));
				customer.setStatus(rs.getBoolean("Status"));
				customers.add(customer);
			}

		} catch (Exception e) {
			customers = null;

		} finally {
			ConnectDB.disconnect();
		}
		return customers;
	}
	
	public java.util.List<Customer> search(String keyword) {
		java.util.List<Customer> customers = new ArrayList<Customer>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from customer where name like ?");
			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setName(rs.getString("Name"));
				customer.setAddress(rs.getString("Address"));
				customer.setPhone(rs.getString("Phone"));
				customer.setEmail(rs.getString("Email"));
				customer.setGender(rs.getBoolean("Gender"));
				customer.setDob(rs.getDate("DOB"));
				customer.setSalary(rs.getFloat("Salary"));
				customer.setJob(rs.getString("Job"));
				customer.setCompany(rs.getString("Company"));
				customer.setIdentityCard(rs.getString("IdentityCard"));
				customer.setStatus(rs.getBoolean("Status"));
				customers.add(customer);
			}
		} catch (Exception e) {
			customers = null;
		} finally {
			ConnectDB.disconnect();
		}
		return customers;
	}
	public Customer findById(String CustomerId) {
		Customer customers = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("select * from customer where id ?");
			preparedStatement.setString(1, CustomerId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("Id"));
				customer.setName(rs.getString("Name"));
				customer.setAddress(rs.getString("Address"));
				customer.setPhone(rs.getString("Phone"));
				customer.setEmail(rs.getString("Email"));
				customer.setGender(rs.getBoolean("Gender"));
				customer.setDob(rs.getDate("DOB"));
				customer.setSalary(rs.getFloat("Salary"));
				customer.setJob(rs.getString("Job"));
				customer.setCompany(rs.getString("Company"));
				customer.setIdentityCard(rs.getString("IdentityCard"));
				customer.setStatus(rs.getBoolean("Status"));
			
			}
		} catch (Exception e) {
			customers = null;
		} finally {
			ConnectDB.disconnect();
		}
		return customers;
	}
	
	public boolean findCustomerByEmail (int id) {
		boolean result = false;
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
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
				.prepareStatement("delete from customer where id = ?");
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
