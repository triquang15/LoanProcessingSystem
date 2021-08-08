package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.util.List;

import java.awt.SystemColor;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.plaf.TabbedPaneUI;

import javax.swing.table.DefaultTableModel;

import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;

import com.aptech.LoanProcessingSystem.entities.Account;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class jpanelLoadData extends JPanel {
	private JTextField txtSearch;
//	private JTextField txtVehicleSearch;
//	private JTable jtableVehicle;
//	private JTextField txtPersonalSearch;
//	private JTable jtablePersonal;
//	private JTextField txtEducationalSearch;
//	private JTable jtableEducational;
	private JComboBox cbFilter;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
//	private JComboBox cbPersonalFilter;
//	private JButton btnPersonalAdd;
//	private JButton btnPersonaUpdate;
//	private JButton btnPersonalDelete;
//	private JButton btnEducationalSearch;
//	private JComboBox cbEducationalFilter;
//	private JButton btnEducationalAdd;
//	private JButton btnEducationalUpdate;
//	private JButton btnEducationalDelete;
	private Account account = new Account();
	private JTabbedPane tabbedPane;

	/**
	 * Create the panel.
	 */
	public jpanelLoadData(Account account) {
		this();
		this.account = account;
	}

	public jpanelLoadData() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel jpanelHomeTop = new JPanel();
		jpanelHomeTop.setBackground(new Color(21, 25, 28));
		add(jpanelHomeTop);
		FlowLayout fl_jpanelHomeTop = new FlowLayout(FlowLayout.LEFT, 5, 5);
		jpanelHomeTop.setLayout(fl_jpanelHomeTop);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_layers_20px.png")));
		jpanelHomeTop.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Loan Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(SystemColor.text);
		jpanelHomeTop.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 40, 44));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		tabbedPane.setBorder(null);
		tabbedPane.setForeground(SystemColor.controlText);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		panel.add(tabbedPane, BorderLayout.CENTER);

		loadAllTabbed();
	}

	private void loadAllTabbed() {
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
			addNewTabbed(loanType);
		}
	}

	private void addNewTabbed(LoanType loanType) {
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(21, 25, 28));
		panel_1.setForeground(SystemColor.text);
		tabbedPane.addTab(loanType.getName(), null, panel_1, null);
		panel_1.setBackground(new Color(34, 40, 44));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(21, 25, 28));
		panel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(34, 40, 44));
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_7);

		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setForeground(SystemColor.text);
		panel_7.add(lblNewLabel_2);

		txtSearch = new JTextField();
		panel_7.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		panel_7.add(btnSearch);

		JButton btnReload = new JButton("");
		btnReload.setBorderPainted(false);
		btnReload.setContentAreaFilled(false);
		btnReload.setFocusPainted(false);
		btnReload.setIcon(new ImageIcon(
				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
		panel_7.add(btnReload);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(34, 40, 44));
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_5.add(panel_8);

		JLabel lblNewLabel_3 = new JLabel("Filter");
		lblNewLabel_3.setForeground(SystemColor.text);
		panel_8.add(lblNewLabel_3);

		JComboBox cbFilter = new JComboBox();
		panel_8.add(cbFilter);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(21, 25, 28));
		panel_6.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(34, 40, 44));
		panel_6.add(scrollPane, BorderLayout.CENTER);

		JTable tableLoan = new JTable();
		tableLoan.setForeground(SystemColor.text);
		LoanModel loanModel = new LoanModel();
		tableLoan.setBackground(new Color(34, 40, 44));
		FillDataToJTable(loanModel.getAllLoanHome(loanType), tableLoan, scrollPane);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_9);

		JButton btnAdd = new JButton("Add");

		btnReload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				btnReload_actionPerformed(e, loanType);
				LoanModel loanModel = new LoanModel();
				FillDataToJTable(loanModel.getAllLoanHome(loanType), tableLoan, scrollPane);
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(loanType, tableLoan, scrollPane);
			}
		});
		panel_9.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
//		btnUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnUpdate_actionPerformed(e, loanType);
//			}
//		});
		panel_9.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
//		btnDelete.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				btnDelete_actionPerformed(e, loanType);
//			}
//		});
		panel_9.add(btnDelete);
	}

	public void btnAdd_actionPerformed(LoanType loanType, JTable tableLoan, JScrollPane scrollPane) {
		JDialogAddNewLoan addNewLoan = new JDialogAddNewLoan(this.account);
		addNewLoan.setVisible(true);
		addNewLoan.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosed(WindowEvent e) {
				FillDataToJTable(new LoanModel().getAllLoanHome(loanType), tableLoan, scrollPane);
				super.windowClosed(e);
			}
		});
	}

	public void FillDataToJTable(List<Loan> loanList, JTable tableLoan, JScrollPane scrollPaneLoan) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Loan Type");
		defaultTableModel.addColumn("Interest");
		defaultTableModel.addColumn("Employee ID");
		defaultTableModel.addColumn("Customer ID");
		defaultTableModel.addColumn("Payment Type");
		defaultTableModel.addColumn("Amount");
		defaultTableModel.addColumn("Period");
		defaultTableModel.addColumn("Duration");
		defaultTableModel.addColumn("Date Created");
		defaultTableModel.addColumn("Date Disbursement");
		defaultTableModel.addColumn("Date End");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Status");
		for (Loan loan : loanList) {
			defaultTableModel.addRow(new Object[] { loan.getId(), loan.getLoanTypeId(), loan.getInterest(),
					loan.getAccountId(), loan.getCustomerId(), loan.getPaymentTypeId(), loan.getAmount(),
					loan.getPeriod(), loan.getDuration(), loan.getCreateDate(), loan.getDisbursementDate(),
					loan.getEndDate(), loan.getDescription(), loan.getStatus() });
		}
		tableLoan.setModel(defaultTableModel);
		tableLoan.getTableHeader().setReorderingAllowed(false);
		scrollPaneLoan.setViewportView(tableLoan);
	}

}
