package com.aptech.LoanProcessingSystem.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CustomerInfo extends JPanel {
	private JTable table;
	private JTextField txtSearchByEmail;

	/**
	 * Create the panel.
	 */
	public CustomerInfo() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		table.setBounds(0, 0, 1120, 558);
		add(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(23, 595, 1068, 76);
		add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/back.png")));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(56, 28, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setIcon(new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/statistics (1).png")));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(202, 28, 89, 23);
		panel.add(btnNewButton_1);
		
		txtSearchByEmail = new JTextField();
		txtSearchByEmail.setText("Search By Id");
		txtSearchByEmail.setBounds(361, 29, 300, 20);
		panel.add(txtSearchByEmail);
		txtSearchByEmail.setColumns(10);

	}
}
