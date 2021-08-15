package com.aptech.LoanProcessingSystem.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.service.MessageDialog;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;

public class CustomerInfo extends JPanel {

	private Home mainForm;
	private DefaultTableModel tblModel = new DefaultTableModel();
	private JTable table;
	private JTextField txtSearch;
	List<Customer> list = new ArrayList<>();

	public CustomerInfo() {
		initComponents();

		initTable();

		CustomerModel customerModel = new CustomerModel();
		loadDataToTable(customerModel.findAll());
	}

	private void initTable() {
		tblModel.setColumnIdentifiers(new String[] { "Id", "Name", "Email", "Phone", "Gender", "Dob", "Salary", "Job",
				"Company", "Identity", "Address", "Status" });
		table.setModel(tblModel);
	}

	private void loadDataToTable(List<Customer> list) {
		try {
			tblModel.setRowCount(0);
			for (Customer customer : list) {
				tblModel.addRow(new Object[] { customer.getId(), customer.getName(), customer.getEmail(),
						customer.getPhone(), customer.isGender() ? "Male" : "Female", customer.getDob(),
						customer.getSalary(), customer.getJob(), customer.getCompany(), customer.getIdentityCard(),
						customer.getAddress(), customer.isStatus() ? "Active" : "Inactive"

				});

			}
			tblModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.showErrorMessage(mainForm, e.getMessage(), "Error");

		}
	}

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public void initComponents() {

		setBackground(new Color(112, 128, 144));
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(112, 128, 144));
		add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setIntercellSpacing(new Dimension(10, 1));
		table.setRequestFocusEnabled(false);
		table.setRowHeight(30);
		table.setForeground(Color.BLACK);
		table.setBackground(new Color(112, 128, 144));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(Color.darkGray);
		table.getTableHeader().setForeground(Color.lightGray);
		Font bigFont = new Font("sansserif", Font.BOLD, 17);
		table.getTableHeader().setFont(bigFont);
		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setAlignmentY(10.0f);
		panel.setAlignmentX(10.0f);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

		txtSearch = new JTextField();
		panel_3.add(txtSearch);
		txtSearch.setMinimumSize(new Dimension(200, 19));
		txtSearch.setMargin(new Insets(2, 20, 2, 20));
		txtSearch.setPreferredSize(new Dimension(350, 31));
		txtSearch.setForeground(Color.RED);
		txtSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtSearch.setColumns(30);

		JButton btnSearch = new JButton("");
		panel_3.add(btnSearch);
		btnSearch.setPreferredSize(new Dimension(30, 30));
		btnSearch.setMargin(new Insets(2, 20, 2, 20));
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/search.png")));

		JButton btnRefresh = new JButton("");
		btnRefresh.setPreferredSize(new Dimension(30, 30));
		btnRefresh.setIcon(new ImageIcon(
				CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));
		panel_3.add(btnRefresh);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 20));

		JButton btnCreateLoan = new JButton("New Loan");
		btnCreateLoan.setAlignmentY(10.0f);
		btnCreateLoan.setAlignmentX(20.0f);
		panel_4.add(btnCreateLoan);
		btnCreateLoan.setPreferredSize(new Dimension(120, 30));
		btnCreateLoan.setMargin(new Insets(2, 20, 2, 20));

		btnCreateLoan.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnCreateLoan.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/add.png")));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setAlignmentY(10.0f);
		btnDelete.setAlignmentX(20.0f);
		panel_4.add(btnDelete);
		btnDelete.setPreferredSize(new Dimension(120, 30));
		btnDelete.setMargin(new Insets(2, 20, 2, 20));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));

		JButton btnPrint = new JButton("Print");
		btnPrint.setAlignmentY(10.0f);
		btnPrint.setAlignmentX(20.0f);
		panel_4.add(btnPrint);
		btnPrint.setPreferredSize(new Dimension(120, 30));
		btnPrint.setMargin(new Insets(2, 20, 2, 20));
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.setIcon(
				new ImageIcon(CustomerInfo.class.getResource("/com/aptech/LoanProcessingSystem/images/print.png")));

		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("List Customer");
				MessageFormat footer = new MessageFormat("Page{0, number, integer}");

				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
						CustomerModel customerModel = new CustomerModel();
						if (customerModel.delete(id)) {
							JOptionPane.showMessageDialog(null, "Successful Delete");
							loadDataToTable(customerModel.findAll());
						} else {
							JOptionPane.showMessageDialog(null, "Failed");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = txtSearch.getText().trim();
				loadDataToTable(new CustomerModel().search(keyword));
			}
		});

		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
				loadDataToTable(new CustomerModel().findAll());
			}
		});
		btnCreateLoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
					CreateLoan createLoan = new CreateLoan(id);
					createLoan.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}

			}
		});
	}

}
