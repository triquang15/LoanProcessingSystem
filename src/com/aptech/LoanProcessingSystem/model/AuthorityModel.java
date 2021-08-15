package com.aptech.LoanProcessingSystem.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Authority;

public class AuthorityModel {
	public List<Authority> loadAllAuthority() {
		List<Authority> authorities = new ArrayList<Authority>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM authorities");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Authority authority = new Authority();
				authority.setId(resultSet.getInt("Id"));
				authority.setName(resultSet.getString("Name"));
				authorities.add(authority);
			}
		} catch (Exception e) {
			// TODO: handle exception
			authorities = null;
		} finally {
			ConnectDB.disconnect();
		}
		return authorities;
	}
}
