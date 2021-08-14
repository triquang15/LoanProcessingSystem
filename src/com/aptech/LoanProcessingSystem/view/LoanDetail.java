package com.aptech.LoanProcessingSystem.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.service.MessageDialog;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;

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

public class LoanDetail extends JPanel {

	private Home mainForm;
	private DefaultTableModel tblModel = new DefaultTableModel();
	private JTable table;
	private JTextField txtSearch;
	List<com.aptech.LoanProcessingSystem.entities.Loan> list = new ArrayList<>();

	public LoanDetail() {
		initComponents();

		initTable();

		LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
		loadDataToTable(loanAndFineHistoryModel.getAllLoanAndFineHistorys());
	}

	 private void loadDataToTable(List<com.aptech.LoanProcessingSystem.entities.MyLoanAndFineHistory> list) {
	        try {
	         
	            tblModel.setRowCount(0);
	            for (com.aptech.LoanProcessingSystem.entities.MyLoanAndFineHistory myLoanAndFineHistory : list) {
	                tblModel.addRow(new Object[]{
	                		myLoanAndFineHistory.getId(), myLoanAndFineHistory.getCustomer(), myLoanAndFineHistory.getPaymentAmount(),  myLoanAndFineHistory.getAmount(), myLoanAndFineHistory.getAmountLeft(), myLoanAndFineHistory.getDueDate(),
	                		myLoanAndFineHistory.getFineInterest(), myLoanAndFineHistory.getFineOverDays(), myLoanAndFineHistory.getFineAmount(), myLoanAndFineHistory.getPaymentDate(), myLoanAndFineHistory.getDescription()
	                	, myLoanAndFineHistory.isStatus()
	                });

	            }
	            tblModel.fireTableDataChanged();

	        } catch (Exception e) {
	            e.printStackTrace();
	            MessageDialog.showErrorMessage(mainForm, e.getMessage(), "Error");
	        }
	    }
	
	private void initTable() {
		tblModel.setColumnIdentifiers(new String[] { "Id", "Customer", "Payment Amount", "Amount", "Amount Left", "Due Date", "Fine Interest", "Fine Over Days", "Fine Amount",
				"Payment Date", "Description", "Status" });
		table.setModel(tblModel);
	}

	

	/**
	 * Create the panel.
	 * 
	 * @return
	 */
	public void initComponents() {

		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 1283, 463);
		add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(0, 0, 255));
		table.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(table);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoanUpdate loanUpdate = new LoanUpdate();
				loanUpdate.setVisible(true);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/add.png")));
		btnUpdate.setBounds(544, 506, 103, 23);
		add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, "Confirm", "Are you sure?", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					int selectedRow = table.getSelectedRow();
					int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
					LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
					if (loanAndFineHistoryModel.delete(id)) {
						JOptionPane.showMessageDialog(null, "Successful Delete");
						loadDataToTable(loanAndFineHistoryModel.getAllLoanAndFineHistorys());
					} else {
						JOptionPane.showMessageDialog(null, "Failed");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		btnDelete.setBounds(751, 506, 89, 23);
		add(btnDelete);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String keyword = txtSearch.getText().trim();
				LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
				loadDataToTable(loanAndFineHistoryModel.search(keyword));
			
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/search.png")));
		btnSearch.setBounds(67, 506, 89, 23);
		add(btnSearch);

		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat("Loan Detail");
				MessageFormat footer = new MessageFormat("Page{0, number, integer}");

				try {
					table.print(JTable.PrintMode.NORMAL, header, footer);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/print.png")));
		btnPrint.setBounds(945, 506, 89, 23);
		add(btnPrint);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				LoanDetail.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/back.png")));
		btnNewButton.setBounds(1129, 506, 89, 23);
		add(btnNewButton);

		txtSearch = new JTextField();
		txtSearch.setForeground(Color.RED);
		txtSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtSearch.setColumns(10);
		txtSearch.setBounds(193, 508, 231, 20);
		add(txtSearch);

	}

	
}
