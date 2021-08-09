package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class jpanelCustomerProfile extends JPanel {
	private JTable jtableCustomer;
	private JTextField txtSearch;
	private JComboBox<String> cbFilter;
	private JButton btnSearch;

	/**
	 * Create the panel.
	 */
	public jpanelCustomerProfile() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpanelHomeTop = new JPanel();
		jpanelHomeTop.setBackground(new Color(21, 25, 28));
		add(jpanelHomeTop);
		FlowLayout fl_jpanelHomeTop = new FlowLayout(FlowLayout.LEFT, 5, 5);
		jpanelHomeTop.setLayout(fl_jpanelHomeTop);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(jpanelCustomerProfile.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_profile_20px.png")));
		jpanelHomeTop.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Customer Profile Management");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(SystemColor.text);
		jpanelHomeTop.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 40, 44));
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_3.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setForeground(Color.WHITE);
		panel_3.add(lblNewLabel_2);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		panel_3.add(txtSearch);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch_actionPerformed(e);
			}
		});
		panel_3.add(btnSearch);
		
		JButton btnReload = new JButton("");
		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReload_actionPerformed(e);
			}
		});
		btnReload.setIcon(new ImageIcon(jpanelCustomerProfile.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
		btnReload.setFocusPainted(false);
		btnReload.setContentAreaFilled(false);
		btnReload.setBorderPainted(false);
		panel_3.add(btnReload);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_4.setBackground(new Color(30, 40, 44));
		panel_1.add(panel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Filter");
		lblNewLabel_3.setForeground(SystemColor.text);
		panel_4.add(lblNewLabel_3);
		
		cbFilter = new JComboBox();
//		cbFilter.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				cbFilter_actionPerformed(e);
//			}
//		});
		panel_4.add(cbFilter);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		panel.setBackground(new Color(34, 40, 44));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(34, 40, 44));
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		jtableCustomer = new JTable();
		jtableCustomer.setGridColor(SystemColor.activeCaption);
		jtableCustomer.setForeground(SystemColor.text);
		jtableCustomer.setBackground(new Color(34, 40, 44));
		scrollPane.setViewportView(jtableCustomer);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 40, 44));
		add(panel_2);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
			}
		});
		panel_2.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_actionPerformed(e);
			}
		});
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_actionPerformed(e);
			}
		});
		panel_2.add(btnDelete);
		
		btnReload_actionPerformed(null);
		fillComboBox();
		CustomerModel customerModel = new CustomerModel();
		fillDataToJTable(customerModel.findAll());
	}
	
	public void btnSearch_actionPerformed(ActionEvent e) {
		String keyValue = txtSearch.getText().trim();
		CustomerModel customerModel = new CustomerModel();
		fillDataToJTable(customerModel.search(keyValue));
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		jDialogAddNewCustomer addNewCustomer = new jDialogAddNewCustomer();
		addNewCustomer.setVisible(true);
	}
	
	public void fillDataToJTable (List<Customer> customerList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
			
		};
		defaultTableModel.addColumn("ID");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Email");
		defaultTableModel.addColumn("Gender");
		defaultTableModel.addColumn("DOB");
		defaultTableModel.addColumn("Salary");
		defaultTableModel.addColumn("Job");
		defaultTableModel.addColumn("Company");
		defaultTableModel.addColumn("Id Card");
		defaultTableModel.addColumn("Status");
		for (Customer customer : customerList) {
			defaultTableModel.addRow(new Object[] {
					customer.getId(), customer.getName(), customer.getAddress(),
					customer.getPhone(), customer.getEmail(), customer.isGender() ? "Male" : "Female",
					customer.getDob(), customer.getSalary(), customer.getJob(),
					customer.getCompany(), customer.getIdentityCard(), customer.isStatus() 
			});
		}
		jtableCustomer.setModel(defaultTableModel);
		jtableCustomer.getTableHeader().setReorderingAllowed(false);
	}
	
	public void btnReload_actionPerformed(ActionEvent e) {
		CustomerModel customerModel = new CustomerModel();
		fillDataToJTable(customerModel.findAll());
	}
	
	public void btnUpdate_actionPerformed(ActionEvent e) {
		int i = jtableCustomer.getSelectedRow();
		if (i > -1) {
			int id = (int) (jtableCustomer.getValueAt(i, 0));
			CustomerModel customerModel = new CustomerModel();
			Customer customer = customerModel.findById(id);
			jDialogAddNewCustomer addNewCustomer = new jDialogAddNewCustomer(customer);
			addNewCustomer.setVisible(true);
		}
	}
	
	public void btnDelete_actionPerformed(ActionEvent e) {
		int i = jtableCustomer.getSelectedRow();
		if ( i  > -1 ) {
			int id = (int) jtableCustomer.getValueAt(i, 0);
			CustomerModel customerModel = new CustomerModel();
			int a = JOptionPane.showConfirmDialog(null, "Do you want to delete"
					+ " this customer?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
			if (a == JOptionPane.YES_OPTION) {
				if (customerModel.delete(id)) {
					JOptionPane.showMessageDialog(null, "Done");
					btnReload_actionPerformed(e);
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}
		}
	}
	
//	public void cbFilter_actionPerformed(ActionEvent e) {
//		int i = cbFilter.getSelectedIndex();
//		CustomerModel customerModel = new CustomerModel();
//		if (i == 0) {
//			fillDataToJTable(customerModel.sortInterestLowToHigh());
//		} else if (i == 1) {
//			fillDataToJTable(customerModel.sortInterestHighToLow());
//		}
//	}
//	
	public void fillComboBox() {
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		boxModel.addElement("Interest from low to high");
		boxModel.addElement("Interest from high to low");
		cbFilter.setModel(boxModel);
	}
}
