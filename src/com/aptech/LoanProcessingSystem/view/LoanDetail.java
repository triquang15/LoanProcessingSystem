package com.aptech.LoanProcessingSystem.view;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.entities.MyLoanAndFineHistory;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.service.MessageDialog;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class LoanDetail extends JPanel {

	private Home mainForm;
	private DefaultTableModel tblModel = new DefaultTableModel();
	private JTable table;
	private JTextField txtSearch;
	private String loanPage = "LOAN_PAGE";
	private String historyPage = "HISTORY_PAGE";
	private String pageState = loanPage;
	private JButton btnBack;
	private JButton btnDetail;
	private String hintSearch = "Please enter customer name!";
	private int loanSelectedId;

	public LoanDetail() {
		initComponents();
		loadLoanToTable(new LoanModel().findAll());
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
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));

		txtSearch = new JTextField();
		txtSearch.setMargin(new Insets(2, 20, 2, 20));
		txtSearch.setPreferredSize(new Dimension(300, 30));
		panel_1.add(txtSearch);
		txtSearch.setForeground(Color.RED);
		txtSearch.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtSearch.setColumns(30);

		JButton btnSearch = new JButton("");
		btnSearch.setFocusPainted(false);
		btnSearch.setPreferredSize(new Dimension(30, 30));
		btnSearch.setMargin(new Insets(2, 20, 2, 20));
		panel_1.add(btnSearch);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSearch.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/search.png")));

		JButton btnRefesh = new JButton("");
		btnRefesh.setFocusPainted(false);
		btnRefesh.setPreferredSize(new Dimension(30, 30));
		btnRefesh.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));
		panel_1.add(btnRefesh);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel.add(panel_2);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.TRAILING, 20, 20);
		panel_2.setLayout(fl_panel_2);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_update_20.png")));
		btnUpdate.setPreferredSize(new Dimension(120, 30));
		btnUpdate.setMargin(new Insets(2, 20, 2, 20));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_2.add(btnUpdate);

		btnDetail = new JButton("Detail");

		btnDetail.setPreferredSize(new Dimension(120, 30));
		btnDetail.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnDetail);

		btnDetail.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDetail.setIcon(new ImageIcon(
				LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_detail_16.png")));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(120, 30));
		btnDelete.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnDelete);

		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnDelete.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));

		JButton btnPrint = new JButton("Print");
		btnPrint.setPreferredSize(new Dimension(120, 30));
		btnPrint.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnPrint);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPrint.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/print.png")));

		btnBack = new JButton("Back");

		btnBack.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/back.png")));
		btnBack.setPreferredSize(new Dimension(120, 30));
		btnBack.setMargin(new Insets(2, 20, 2, 20));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel_2.add(btnBack);
		initForm();
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

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAction();
			}
		});

		btnRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshAction();
			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteAction();
			}
		});

		btnDetail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					loanSelectedId = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
					pageState = historyPage;
					initPage();
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}
			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageState = loanPage;
				initPage();
			}
		});
	}

	private void initPage() {
		if (pageState.equals(loanPage)) {
			btnDetail.setVisible(true);
			btnBack.setVisible(false);
			txtSearch.setVisible(true);
			loadLoanToTable(new LoanModel().findAllActive());
		} else {
			btnDetail.setVisible(false);
			btnBack.setVisible(true);
			txtSearch.setVisible(false);
			loadHistoryToTable(new LoanAndFineHistoryModel().searchByLoanId(loanSelectedId));
		}
	}

	protected void deleteAction() {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
			if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Confirm",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				if (pageState.equals(loanPage)) {
					
					if (new LoanAndFineHistoryModel().deleteWithLoanId(id)) {
						
						if (new LoanModel().delete(id)) {
							
							JOptionPane.showMessageDialog(null, "Successful Delete");
							loadLoanToTable(new LoanModel().findAll());
							
						} else {
							JOptionPane.showMessageDialog(null, "Delete failed, please try again!");
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Delete failed, please try again!");
					}
					
				} else {
					if (new LoanAndFineHistoryModel().delete(id)) {
						JOptionPane.showMessageDialog(null, "Successful Delete");
						loadHistoryToTable(new LoanAndFineHistoryModel().searchByLoanId(loanSelectedId));
					} else {
						JOptionPane.showMessageDialog(null, "Delete failed, please try again!");
					}
				}
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please choose a value!");
		}
	}

	private void refreshAction() {
		if (pageState.equals(loanPage)) {
			loadLoanToTable(new LoanModel().findAllActive());
		} else {
			loadHistoryToTable(new LoanAndFineHistoryModel().getAllLoanAndFineHistorys());
		}
	}

	private void searchAction() {
		String keyword = txtSearch.getText().trim();
		if (pageState.equals(loanPage)) {
			loadLoanToTable(new LoanModel().searchByCustomerName(keyword));
		} else {
			loadHistoryToTable(new LoanAndFineHistoryModel().search(keyword));
		}
	}

	private void loadLoanToTable(List<Loan> list) {

		tblModel.setColumnIdentifiers(new String[] { "Id", "Customer", "Loan type", "Payment type", "Period", "Amount",
				"Disbursement", "Duration", "End date", "Interest", "Description", "Status" });

		table.setModel(tblModel);
		try {
			tblModel.setRowCount(0);
			for (Loan loans : list) {
				tblModel.addRow(new Object[] { loans.getId(), loans.getCustomerName(), loans.getLoanTypeName(),
						loans.getPaymentTypeName(), loans.getPeriod(), loans.getAmount(), loans.getDisbursementDate(),
						loans.getDuration(), loans.getEndDate(), loans.getInterest(), loans.getDescription(),
						loans.getStatus() == 0 ? "New" : (loans.getStatus() == 1 ? "Active" : "Update") });

			}
			tblModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.showErrorMessage(mainForm, e.getMessage(), "Error");
		}
	}

	private void loadHistoryToTable(List<LoanAndFineHistory> list) {
		tblModel.setColumnIdentifiers(
				new String[] { "Id", "Customer", "Payment Amount", "Amount", "Amount Left", "Due Date", "Fine Interest",
						"Fine Over Days", "Fine Amount", "Payment Date", "Description", "Status" });
		table.setModel(tblModel);
		try {

			tblModel.setRowCount(0);
			for (LoanAndFineHistory loanAndFineHistory : list) {
				tblModel.addRow(new Object[] { loanAndFineHistory.getId(), loanAndFineHistory.getCustomer(),
						loanAndFineHistory.getPaymentAmount(), loanAndFineHistory.getAmount(),
						loanAndFineHistory.getAmountLeft(), loanAndFineHistory.getDueDate(),
						loanAndFineHistory.getFineInterest(), loanAndFineHistory.getFineOverDays(),
						loanAndFineHistory.getFineAmount(), loanAndFineHistory.getPaymentDate(),
						loanAndFineHistory.getDescription(), loanAndFineHistory.isStatus() });
			}
			tblModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.showErrorMessage(mainForm, e.getMessage(), "Error");
		}
	}

	private void initForm() {
		txtSearch.setText(hintSearch);
		txtSearch.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtSearch.setForeground(Color.GRAY);
		setTextHint(txtSearch, hintSearch);
		initPage();
	}

	private void setTextHint(JTextField textField, String hint) {
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(hint)) {
					textField.setText("");
					textField.setFont(new Font("Tahoma", Font.PLAIN, 10));
					if (textField instanceof JPasswordField) {
						((JPasswordField) textField).setEchoChar('●');
					}
					textField.setForeground(Color.DARK_GRAY);
				} else {
					textField.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textField.getText().equals("")) {
					textField.setText(hint);
					textField.setFont(new Font("Tahoma", Font.ITALIC, 10));
					textField.setForeground(Color.GRAY);
					if (textField instanceof JPasswordField) {
						((JPasswordField) textField).setEchoChar((char) 0);
					}
				}
			}
		});
	}
}
