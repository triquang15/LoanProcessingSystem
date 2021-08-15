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
				tblModel.addRow(new Object[] { myLoanAndFineHistory.getId(), myLoanAndFineHistory.getCustomer(),
						myLoanAndFineHistory.getPaymentAmount(), myLoanAndFineHistory.getAmount(),
						myLoanAndFineHistory.getAmountLeft(), myLoanAndFineHistory.getDueDate(),
						myLoanAndFineHistory.getFineInterest(), myLoanAndFineHistory.getFineOverDays(),
						myLoanAndFineHistory.getFineAmount(), myLoanAndFineHistory.getPaymentDate(),
						myLoanAndFineHistory.getDescription(), myLoanAndFineHistory.isStatus() });

			}
			tblModel.fireTableDataChanged();

		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.showErrorMessage(mainForm, e.getMessage(), "Error");
		}
	}

	private void initTable() {
		tblModel.setColumnIdentifiers(
				new String[] { "Id", "Customer", "Payment Amount", "Amount", "Amount Left", "Due Date", "Fine Interest",
						"Fine Over Days", "Fine Amount", "Payment Date", "Description", "Status" });
		table.setModel(tblModel);
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
		btnUpdate.setPreferredSize(new Dimension(120, 30));
		btnUpdate.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnUpdate);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoanUpdate loanUpdate = new LoanUpdate();
				loanUpdate.setVisible(true);
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnUpdate.setIcon(
				new ImageIcon(LoanDetail.class.getResource("/com/aptech/LoanProcessingSystem/images/add.png")));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(120, 30));
		btnDelete.setMargin(new Insets(2, 20, 2, 20));
		panel_2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					int result = JOptionPane.showConfirmDialog(null, "Are you sure?", "Confirm", 
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.YES_OPTION) {
						int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
						LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
						if (loanAndFineHistoryModel.delete(id)) {
							JOptionPane.showMessageDialog(null, "Successful Delete");
							loadDataToTable(loanAndFineHistoryModel.getAllLoanAndFineHistorys());
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please choose a value!");
				}
			}
		});
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
				String keyword = txtSearch.getText().trim();
				LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
				loadDataToTable(loanAndFineHistoryModel.search(keyword));
			}
		});

		btnRefesh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtSearch.setText("");
				loadDataToTable(new LoanAndFineHistoryModel().getAllLoanAndFineHistorys());
			}
		});

	}
}
