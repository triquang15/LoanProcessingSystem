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
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class jpanelLoadData extends JPanel {
	private JTextField txtSearch;
	private JTable jtable;
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
//		tabbedPane.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				tabbedPane_stateChanged(e);
//			}
//		});
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(SystemColor.controlText);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		panel.add(tabbedPane, BorderLayout.CENTER);

		// tab 1

//		JPanel panel_1 = new JPanel();
//		panel_1.setBorder(null);
//		panel_1.setBackground(new Color(21, 25, 28));
//		panel_1.setForeground(SystemColor.text);
//		tabbedPane.addTab("Home", null, panel_1, null);
//		panel_1.setBackground(new Color(34, 40, 44));
//		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
//
//		JPanel panel_5 = new JPanel();
//		panel_5.setBackground(new Color(21, 25, 28));
//		panel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
//		panel_1.add(panel_5);
//		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
//
//		JPanel panel_7 = new JPanel();
//		panel_7.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
//		flowLayout.setAlignment(FlowLayout.LEFT);
//		panel_5.add(panel_7);
//
//		JLabel lblNewLabel_2 = new JLabel("Search");
//		lblNewLabel_2.setForeground(SystemColor.text);
//		panel_7.add(lblNewLabel_2);
//
//		txtHomeSearch = new JTextField();
//		panel_7.add(txtHomeSearch);
//		txtHomeSearch.setColumns(10);
//
//		JButton btnHomeSearch = new JButton("Search");
//		panel_7.add(btnHomeSearch);
//
//		JButton btnHomeReload = new JButton("");
//		btnHomeReload.setBorderPainted(false);
//		btnHomeReload.setContentAreaFilled(false);
//		btnHomeReload.setFocusPainted(false);
//		btnHomeReload.setIcon(new ImageIcon(
//				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
//		panel_7.add(btnHomeReload);
//
//		JPanel panel_8 = new JPanel();
//		panel_8.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
//		flowLayout_1.setAlignment(FlowLayout.RIGHT);
//		panel_5.add(panel_8);
//
//		JLabel lblNewLabel_3 = new JLabel("Filter");
//		lblNewLabel_3.setForeground(SystemColor.text);
//		panel_8.add(lblNewLabel_3);
//
//		JComboBox cbHomeFilter = new JComboBox();
//		panel_8.add(cbHomeFilter);
//
//		JPanel panel_6 = new JPanel();
//		panel_1.add(panel_6);
//		panel_6.setBackground(new Color(21, 25, 28));
//		panel_6.setLayout(new BorderLayout(0, 0));
//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBackground(new Color(34, 40, 44));
//		panel_6.add(scrollPane, BorderLayout.CENTER);
//
//		jtableHome = new JTable();
//		jtableHome.setBackground(new Color(34, 40, 44));
//		scrollPane.setViewportView(jtableHome);
//
//		JPanel panel_9 = new JPanel();
//		panel_9.setBackground(new Color(34, 40, 44));
//		panel_1.add(panel_9);
//
//		JButton btnHomeAdd = new JButton("Add");
//
//		btnHomeAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnHomeAdd_actionPerformed(e);
//			}
//		});
//		panel_9.add(btnHomeAdd);
//
//		JButton btnHomeUpdate = new JButton("Update");
//		btnHomeUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//			}
//		});
//		panel_9.add(btnHomeUpdate);
//
//		JButton btnHomeDelete = new JButton("Delete");
//		panel_9.add(btnHomeDelete);
//
//		// tab 2
//
//		JPanel panel_2 = new JPanel();
//		panel_2.setBackground(new Color(21, 25, 28));
//		tabbedPane.addTab("Vehicle", null, panel_2, null);
//		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
//
//		JPanel panel_10 = new JPanel();
//		panel_2.add(panel_10);
//		panel_10.setBackground(new Color(21, 25, 28));
//		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.X_AXIS));
//
//		JPanel panel_12 = new JPanel();
//		panel_12.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout_2 = (FlowLayout) panel_12.getLayout();
//		flowLayout_2.setAlignment(FlowLayout.LEFT);
//		panel_10.add(panel_12);
//
//		JLabel lblNewLabel_4 = new JLabel("Search");
//		lblNewLabel_4.setForeground(SystemColor.text);
//		panel_12.add(lblNewLabel_4);
//
//		txtVehicleSearch = new JTextField();
//		panel_12.add(txtVehicleSearch);
//		txtVehicleSearch.setColumns(10);
//
//		JButton btnVehicleSearch = new JButton("Search");
//		panel_12.add(btnVehicleSearch);
//
//		JButton btnVehicleReload = new JButton("");
//		btnVehicleReload.setBorderPainted(false);
//		btnVehicleReload.setFocusPainted(false);
//		btnVehicleReload.setContentAreaFilled(false);
//		btnVehicleReload.setIcon(new ImageIcon(
//				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
//		panel_12.add(btnVehicleReload);
//
//		JPanel panel_13 = new JPanel();
//		panel_13.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout_3 = (FlowLayout) panel_13.getLayout();
//		flowLayout_3.setAlignment(FlowLayout.RIGHT);
//		panel_10.add(panel_13);
//
//		JLabel lblNewLabel_5 = new JLabel("Filter");
//		lblNewLabel_5.setForeground(SystemColor.text);
//		panel_13.add(lblNewLabel_5);
//
//		cbvehicleFilter = new JComboBox();
//		panel_13.add(cbvehicleFilter);
//
//		JPanel panel_11 = new JPanel();
//		panel_11.setBackground(new Color(34, 40, 44));
//		panel_2.add(panel_11);
//		panel_11.setLayout(new BorderLayout(0, 0));
//
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane_1.setBackground(new Color(34, 40, 44));
//		panel_11.add(scrollPane_1, BorderLayout.CENTER);
//
//		jtableVehicle = new JTable();
//		jtableVehicle.setBackground(new Color(34, 40, 44));
//		scrollPane_1.setViewportView(jtableVehicle);
//
//		JPanel panel_14 = new JPanel();
//		panel_14.setBackground(new Color(34, 40, 44));
//		panel_2.add(panel_14);
//
//		btnVehicleAdd = new JButton("Add");
//
//		btnVehicleAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnVehicleAdd_actionPerformed(e);
//			}
//		});
//		panel_14.add(btnVehicleAdd);
//
//		btnVehicleUpdate = new JButton("Update");
//		panel_14.add(btnVehicleUpdate);
//
//		btnVehicleDelete = new JButton("Delete");
//		panel_14.add(btnVehicleDelete);
//
//		// tab 3
//
//		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(21, 25, 28));
//		tabbedPane.addTab("Personal", null, panel_3, null);
//		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
//
//		JPanel panel_15 = new JPanel();
//		panel_15.setBackground(new Color(34, 40, 44));
//		panel_3.add(panel_15);
//		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.X_AXIS));
//
//		JPanel panel_17 = new JPanel();
//		panel_17.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout_4 = (FlowLayout) panel_17.getLayout();
//		flowLayout_4.setAlignment(FlowLayout.LEFT);
//		panel_15.add(panel_17);
//
//		JLabel lblNewLabel_6 = new JLabel("Search");
//		lblNewLabel_6.setForeground(SystemColor.text);
//		panel_17.add(lblNewLabel_6);
//
//		txtPersonalSearch = new JTextField();
//		panel_17.add(txtPersonalSearch);
//		txtPersonalSearch.setColumns(10);
//
//		btnPersonalSearch = new JButton("Search");
//		panel_17.add(btnPersonalSearch);
//
//		JButton btnPersonalReload = new JButton("");
//		btnPersonalReload.setFocusPainted(false);
//		btnPersonalReload.setContentAreaFilled(false);
//		btnPersonalReload.setBorderPainted(false);
//		btnPersonalReload.setIcon(new ImageIcon(
//				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
//		panel_17.add(btnPersonalReload);
//
//		JPanel panel_18 = new JPanel();
//		panel_18.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout_5 = (FlowLayout) panel_18.getLayout();
//		flowLayout_5.setAlignment(FlowLayout.RIGHT);
//		panel_15.add(panel_18);
//
//		JLabel lblNewLabel_7 = new JLabel("Filter");
//		lblNewLabel_7.setForeground(SystemColor.text);
//		panel_18.add(lblNewLabel_7);
//
//		cbPersonalFilter = new JComboBox();
//		panel_18.add(cbPersonalFilter);
//
//		JPanel panel_16 = new JPanel();
//		panel_16.setBackground(new Color(34, 40, 44));
//		panel_3.add(panel_16);
//		panel_16.setLayout(new BorderLayout(0, 0));
//
//		JScrollPane scrollPane_2 = new JScrollPane();
//		scrollPane_2.setBackground(new Color(21, 25, 28));
//		panel_16.add(scrollPane_2, BorderLayout.CENTER);
//
//		jtablePersonal = new JTable();
//		jtablePersonal.setBackground(new Color(34, 40, 44));
//		scrollPane_2.setViewportView(jtablePersonal);
//
//		JPanel panel_19 = new JPanel();
//		panel_19.setBackground(new Color(34, 40, 44));
//		panel_3.add(panel_19);
//
//		btnPersonalAdd = new JButton("Add");
//
//		btnPersonalAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnPersonalAdd_actionPerformed(e);
//			}
//		});
//		panel_19.add(btnPersonalAdd);
//
//		btnPersonaUpdate = new JButton("Update");
//		panel_19.add(btnPersonaUpdate);
//
//		btnPersonalDelete = new JButton("Delete");
//		panel_19.add(btnPersonalDelete);
//
//		// tab 4
//
//		JPanel panel_4 = new JPanel();
//		panel_4.setBackground(new Color(34, 40, 44));
//		tabbedPane.addTab("Educational", null, panel_4, null);
//		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
//
//		JPanel panel_20 = new JPanel();
//		panel_20.setBackground(new Color(34, 40, 44));
//		panel_4.add(panel_20);
//		panel_20.setLayout(new BoxLayout(panel_20, BoxLayout.X_AXIS));
//
//		JPanel panel_23 = new JPanel();
//		panel_23.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout_6 = (FlowLayout) panel_23.getLayout();
//		flowLayout_6.setAlignment(FlowLayout.LEFT);
//		panel_20.add(panel_23);
//
//		JLabel lblNewLabel_8 = new JLabel("Search");
//		lblNewLabel_8.setForeground(SystemColor.text);
//		panel_23.add(lblNewLabel_8);
//
//		txtEducationalSearch = new JTextField();
//		panel_23.add(txtEducationalSearch);
//		txtEducationalSearch.setColumns(10);
//
//		btnEducationalSearch = new JButton("Search");
//		panel_23.add(btnEducationalSearch);
//
//		JButton btnNewButton_16 = new JButton("");
//		btnNewButton_16.setFocusPainted(false);
//		btnNewButton_16.setContentAreaFilled(false);
//		btnNewButton_16.setBorderPainted(false);
//		btnNewButton_16.setIcon(new ImageIcon(
//				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
//		panel_23.add(btnNewButton_16);
//
//		JPanel panel_24 = new JPanel();
//		panel_24.setBackground(new Color(34, 40, 44));
//		FlowLayout flowLayout_7 = (FlowLayout) panel_24.getLayout();
//		flowLayout_7.setAlignment(FlowLayout.RIGHT);
//		panel_20.add(panel_24);
//
//		JLabel lblNewLabel_9 = new JLabel("Filter");
//		lblNewLabel_9.setForeground(SystemColor.text);
//		panel_24.add(lblNewLabel_9);
//
//		cbEducationalFilter = new JComboBox();
//		panel_24.add(cbEducationalFilter);
//
//		JPanel panel_21 = new JPanel();
//		panel_21.setBackground(new Color(34, 40, 44));
//		panel_4.add(panel_21);
//		panel_21.setLayout(new BorderLayout(0, 0));
//
//		JScrollPane scrollPane_3 = new JScrollPane();
//		scrollPane_3.setBackground(new Color(34, 40, 44));
//		panel_21.add(scrollPane_3, BorderLayout.CENTER);
//
//		jtableEducational = new JTable();
//		jtableEducational.setBackground(new Color(34, 40, 44));
//		scrollPane_3.setViewportView(jtableEducational);
//
//		JPanel panel_22 = new JPanel();
//		panel_22.setBackground(new Color(34, 40, 44));
//		panel_4.add(panel_22);
//
//		btnEducationalAdd = new JButton("Add");
//
//		btnEducationalAdd.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnEducationalAdd_actionPerformed(e);
//			}
//		});
//		panel_22.add(btnEducationalAdd);
//
//		btnEducationalUpdate = new JButton("Update");
//		panel_22.add(btnEducationalUpdate);
//
//		btnEducationalDelete = new JButton("Delete");
//		panel_22.add(btnEducationalDelete);
		
		loadAllTabbed();
//		test();

//		tabbedPane.setBackgroundAt(0, new Color(34, 40, 44));
//		tabbedPane.setBackgroundAt(1, new Color(34, 40, 44));
//		tabbedPane.setBackgroundAt(2, new Color(34, 40, 44));
//		tabbedPane.setBackgroundAt(3, new Color(34, 40, 44));

//		tabbedPane.setUI(new TabbedPaneUI());

	}

//	public void Home_FillDataToJTable(List<Loan> loanList) {
//		DefaultTableModel defaultTableModel = new DefaultTableModel() {
//
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				// TODO Auto-generated method stub
//				return super.isCellEditable(row, column);
//			}
//
//		};
//		defaultTableModel.addColumn("Id");
//		defaultTableModel.addColumn("Loan Type");
//		defaultTableModel.addColumn("Interest");
//		defaultTableModel.addColumn("Employee ID");
//		defaultTableModel.addColumn("Customer ID");
//		defaultTableModel.addColumn("Payment Type");
//		defaultTableModel.addColumn("Amount");
//		defaultTableModel.addColumn("Period");
//		defaultTableModel.addColumn("Duration");
//		defaultTableModel.addColumn("Date Created");
//		defaultTableModel.addColumn("Date Disbursement");
//		defaultTableModel.addColumn("Date End");
//		defaultTableModel.addColumn("Description");
//		defaultTableModel.addColumn("Status");
//		for (Loan loan : loanList) {
//			defaultTableModel.addRow(new Object[] { loan.getId(), loan.getLoanTypeId(), loan.getInterest(),
//					loan.getAccountId(), loan.getCustomerId(), loan.getPaymentTypeId(), loan.getAmount(),
//					loan.getPeriod(), loan.getDuration(), loan.getCreateDate(), loan.getDisbursementDate(),
//					loan.getEndDate(), loan.getDescription(), loan.getStatus() });
//		}
//		jtableHome.setModel(defaultTableModel);
//		jtableHome.getTableHeader().setReorderingAllowed(false);
//	}
//
//	public void Personal_FillDataToJTable(List<Loan> loanList) {
//		DefaultTableModel defaultTableModel = new DefaultTableModel() {
//
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				// TODO Auto-generated method stub
//				return super.isCellEditable(row, column);
//			}
//
//		};
//		defaultTableModel.addColumn("Id");
//		defaultTableModel.addColumn("Loan Type");
//		defaultTableModel.addColumn("Interest");
//		defaultTableModel.addColumn("Employee ID");
//		defaultTableModel.addColumn("Customer ID");
//		defaultTableModel.addColumn("Payment Type");
//		defaultTableModel.addColumn("Amount");
//		defaultTableModel.addColumn("Period");
//		defaultTableModel.addColumn("Duration");
//		defaultTableModel.addColumn("Date Created");
//		defaultTableModel.addColumn("Date Disbursement");
//		defaultTableModel.addColumn("Date End");
//		defaultTableModel.addColumn("Description");
//		defaultTableModel.addColumn("Status");
//		for (Loan loan : loanList) {
//			defaultTableModel.addRow(new Object[] { loan.getId(), loan.getLoanTypeId(), loan.getInterest(),
//					loan.getAccountId(), loan.getCustomerId(), loan.getPaymentTypeId(), loan.getAmount(),
//					loan.getPeriod(), loan.getDuration(), loan.getCreateDate(), loan.getDisbursementDate(),
//					loan.getEndDate(), loan.getDescription(), loan.getStatus() });
//		}
//		jtablePersonal.setModel(defaultTableModel);
//		jtablePersonal.getTableHeader().setReorderingAllowed(false);
//	}
//
//	public void Vehicle_FillDataToJTable(List<Loan> loanList) {
//		DefaultTableModel defaultTableModel = new DefaultTableModel() {
//
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				// TODO Auto-generated method stub
//				return super.isCellEditable(row, column);
//			}
//
//		};
//		defaultTableModel.addColumn("Id");
//		defaultTableModel.addColumn("Loan Type");
//		defaultTableModel.addColumn("Interest");
//		defaultTableModel.addColumn("Employee ID");
//		defaultTableModel.addColumn("Customer ID");
//		defaultTableModel.addColumn("Payment Type");
//		defaultTableModel.addColumn("Amount");
//		defaultTableModel.addColumn("Period");
//		defaultTableModel.addColumn("Duration");
//		defaultTableModel.addColumn("Date Created");
//		defaultTableModel.addColumn("Date Disbursement");
//		defaultTableModel.addColumn("Date End");
//		defaultTableModel.addColumn("Description");
//		defaultTableModel.addColumn("Status");
//		for (Loan loan : loanList) {
//			defaultTableModel.addRow(new Object[] { loan.getId(), loan.getLoanTypeId(), loan.getInterest(),
//					loan.getAccountId(), loan.getCustomerId(), loan.getPaymentTypeId(), loan.getAmount(),
//					loan.getPeriod(), loan.getDuration(), loan.getCreateDate(), loan.getDisbursementDate(),
//					loan.getEndDate(), loan.getDescription(), loan.getStatus() });
//		}
//		jtableVehicle.setModel(defaultTableModel);
//		jtableVehicle.getTableHeader().setReorderingAllowed(false);
//	}
//
	public void FillDataToJTable(List<Loan> loanList) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
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
		jtable.setModel(defaultTableModel);
		jtable.getTableHeader().setReorderingAllowed(false);
	}

//	public void fillComboBox() {
//		DefaultComboBoxModel<LoanType> boxModel = new DefaultComboBoxModel<LoanType>();
//		LoanTypeModel loanTypeModel = new LoanTypeModel();
//		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
//			boxModel.addElement(loanType);
//		}
//	}

	public jpanelLoadData(Account account) {
		this();
		this.account = account;
	}
	
//	public void tabbedPane_stateChanged(ChangeEvent e) {
//		JTabbedPane jTabbedPane = (JTabbedPane) e.getSource();
//		jTabbedPane.get
//	}

//	public void btnHomeAdd_actionPerformed(ActionEvent e) {
//		jpanelLoadData data = new jpanelLoadData();
//		LoanTypeModel loanTypeModel = new LoanTypeModel();
//		JDialogAddNewLoan addNewLoan = new JDialogAddNewLoan(this.account, loanTypeModel.loadLoanType(id));
//		addNewLoan.setVisible(true);
//	}

//	public void btnEducationalAdd_actionPerformed(ActionEvent e) {
//		jpanelLoadData data = new jpanelLoadData();
//		JDialogAddNewLoan addNewLoan = new JDialogAddNewLoan(this.account);
//		addNewLoan.setVisible(true);
//	}
//
//	public void btnPersonalAdd_actionPerformed(ActionEvent e) {
//		jpanelLoadData data = new jpanelLoadData();
//		JDialogAddNewLoan addNewLoan = new JDialogAddNewLoan(this.account);
//		addNewLoan.setVisible(true);
//	}
//
//	public void btnVehicleAdd_actionPerformed(ActionEvent e) {
//		jpanelLoadData data = new jpanelLoadData();
//		JDialogAddNewLoan addNewLoan = new JDialogAddNewLoan(this.account);
//		addNewLoan.setVisible(true);
//	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		JDialogAddNewLoan addNewLoan = new JDialogAddNewLoan(this.account);
		addNewLoan.setVisible(true);
	}
	
//	public void btnUpdate_actionPerformed (ActionEvent e, LoanType loanType) {
//		
//	}
	
//	public void btnReload_actionPerformed(ActionEvent e, LoanType loanType) {
//		LoanModel loanModel = new LoanModel();
//		FillDataToJTable(loanModel.getAllLoanHome(loanType));
//	}
	
//	public void btnDelete_actionPerformed(ActionEvent e, LoanType loanType) {
//		int i = jtable.getSelectedRow();
//		if ( i  > -1 ) {
//			int id = (int) jtable.getValueAt(i, 0);
//			CustomerModel customerModel = new CustomerModel();
//			int a = JOptionPane.showConfirmDialog(null, "Do you want to delete"
//					+ " this loan type?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
//			if (a == JOptionPane.YES_OPTION) {
//				if (customerModel.delete(id)) {
//					JOptionPane.showMessageDialog(null, "Done");
//					btnReload_actionPerformed(null, loanType);
//				} else {
//					JOptionPane.showMessageDialog(null, "Failed");
//				}
//			}
//		}
//	}
	
	private void loadAllTabbed() {
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
			addNewTabbed(loanType);
		}
//		for (int i = 0; i < loanTypeModel.loadAllLoanType().size(); i++) {
//			addNewTabbed(loanTypeModel.loadAllLoanType().get(i));
//		}
	}
	
//	private void test() {
//		panel_1 = (JPanel) tabbedPane.inde();
//		btnSearch.setText("open");
//		jtable = (JTable) tabbedPane.getComponentAt(1);
//		filltable(list)
//	}
	
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
		btnReload.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				btnReload_actionPerformed(e, loanType);
				LoanModel loanModel = new LoanModel();
				FillDataToJTable(loanModel.getAllLoanHome(loanType));
			}
		});

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

		jtable = new JTable();
		jtable.setForeground(SystemColor.text);
		LoanModel loanModel = new LoanModel();
		FillDataToJTable(loanModel.getAllLoanHome(loanType));
		jtable.setBackground(new Color(34, 40, 44));
		scrollPane.setViewportView(jtable);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_9);

		JButton btnAdd = new JButton("Add");

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
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
}
