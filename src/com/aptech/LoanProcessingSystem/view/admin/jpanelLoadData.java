package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.util.Calendar;
import java.util.Date;
import java.util.EventObject;
import java.util.List;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.FineModel;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.aptech.LoanProcessingSystem.view.admin.jpanelCustomerProfile.ButtonEditor;
import com.aptech.LoanProcessingSystem.view.admin.jpanelCustomerProfile.LoanInfosPane;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.entities.Fine;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
	private JComboBox<String> cbFilter;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JTable tableLoan;
	private JButton btnReload;
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
		tabbedPane.setBackground(new Color(34, 40, 44));
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

//	public void btnSearch_actionPerformed(ActionEvent e, LoanType loanType) {
//		int CustomerId = Integer.parseInt(txtSearch.getText().trim());
//		LoanModel loanModel = new LoanModel();
//		FillDataToJTable(loanModel.findLoanByLoanType(loanType, CustomerId));
//	}

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
//		btnSearch.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				btnSearch_actionPerformed(e, loanType);
//			}
//		});
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

		JComboBox<String> cbFilter = new JComboBox<String>();
		DefaultComboBoxModel<String> boxModel = new DefaultComboBoxModel<String>();
		boxModel.addElement("Show New");
		boxModel.addElement("Show Open");
		boxModel.addElement("Show Stop");
		boxModel.addElement("Show Fully Paid");
		cbFilter.setModel(boxModel);

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
		tableLoan.setRowHeight(40);
		LoanModel loanModel = new LoanModel();
		tableLoan.setBackground(new Color(34, 40, 44));
		FillDataToJTable(loanModel.getAllLoanHome(loanType), tableLoan);
		cbFilter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = cbFilter.getSelectedIndex();
				LoanModel loanModel = new LoanModel();
				if (i == 0) {
					FillDataToJTable(loanModel.getLoanByStatus(loanType, 0), tableLoan);
				}
				if (i == 1) {
					FillDataToJTable(loanModel.getLoanByStatus(loanType, 1), tableLoan);
				}
				if (i == 2) {
					FillDataToJTable(loanModel.getLoanByStatus(loanType, 3), tableLoan);
				}
				if (i == 3) {
					FillDataToJTable(loanModel.getLoanByStatus(loanType, 2), tableLoan);
				}
			}
		});
		scrollPane.setViewportView(tableLoan);
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_9);

		JButton btnAdd = new JButton("Add");

		btnReload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoanModel loanModel = new LoanModel();
				FillDataToJTable(loanModel.getAllLoanHome(loanType), tableLoan);
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(loanType, tableLoan, scrollPane);
			}
		});
		panel_9.add(btnAdd);
	}

	public void btnAdd_actionPerformed(LoanType loanType, JTable tableLoan, JScrollPane scrollPane) {
		JPanel jpanelMain = (JPanel) this.getParent();
		jpanelMain.removeAll();
		jpanelMain.revalidate();
		jpanelAddNewLoan addNewLoan = new jpanelAddNewLoan(this.account);
		jpanelMain.add(addNewLoan);
		addNewLoan.setVisible(true);
	}

	public void FillDataToJTable(List<Loan> loanList, JTable tableLoan) {
		String statusMask = "";
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

		};
		defaultTableModel.addColumn("Customer ID");
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Loan Type");
		defaultTableModel.addColumn("Interest");
		defaultTableModel.addColumn("Employee ID");
		defaultTableModel.addColumn("Customer");
		defaultTableModel.addColumn("Payment Type");
		defaultTableModel.addColumn("Amount");
		defaultTableModel.addColumn("Period");
		defaultTableModel.addColumn("Duration");
		defaultTableModel.addColumn("Date Created");
		defaultTableModel.addColumn("Date Disbursement");
		defaultTableModel.addColumn("Date End");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Status");
		defaultTableModel.addColumn("Action");
		for (Loan loan : loanList) {
			if (loan.getStatus() == 0) {
				statusMask = "New";
			} else if (loan.getStatus() == 1) {
				statusMask = "Open";
			} else if (loan.getStatus() == 2) {
				statusMask = "Fully Paid";
			} else if (loan.getStatus() == 3) {
				statusMask = "Stop";
			}
			defaultTableModel.addRow(new Object[] { loan.getCustomerId(), loan.getId(),
					loadLoanTypeName(loan.getLoanTypeId()), loan.getInterest(), loadEmployeeName(loan.getAccountId()),
					loadCustomerName(loan.getCustomerId()), loadPaymentTypeName(loan.getPaymentTypeId()),
					loan.getAmount(), loan.getPeriod(), loan.getDuration(), loan.getCreateDate(),
					loan.getDisbursementDate(), loan.getEndDate(), loan.getDescription(), statusMask, "View/Modify" });
		}
//		TableColumnModel tcm = tableLoan.getColumnModel();
//		tableLoan.removeColumn(tcm.getColumn(0));

		tableLoan.setModel(defaultTableModel);
		tableLoan.removeColumn(tableLoan.getColumnModel().getColumn(0));
		tableLoan.getColumnModel().getColumn(13).setCellRenderer(new LoanTableStatusButtonRenderer());
		tableLoan.getColumnModel().getColumn(13).setCellEditor(new ClientsTableRenderer(new JCheckBox()));
		tableLoan.getColumnModel().getColumn(14).setCellRenderer(new LoanTableViewButtonRenderer());
		tableLoan.getColumnModel().getColumn(14).setCellEditor(new ViewClientsTableRenderer(new JCheckBox()));
		tableLoan.getTableHeader().setReorderingAllowed(false);
		tableLoan.setShowHorizontalLines(true);
		tableLoan.setShowVerticalLines(false);
		defaultTableModel.fireTableDataChanged();
	}

	private void loadColorOfButton(String returnStatus, String statusNew, String statusOpen, String statusFully,
			String statusStop, JButton status) {
		status.setForeground(SystemColor.WHITE);
		if (returnStatus.equals(statusNew)) {
			status.setBackground(SystemColor.RED);
		} else if (returnStatus.equals(statusOpen)) {
			status.setBackground(SystemColor.GREEN);
		} else if (returnStatus.equals(statusStop)) {
			status.setForeground(SystemColor.BLACK);
			status.setBackground(SystemColor.YELLOW);
		} else if (returnStatus.equals(statusFully)) {
			status.setBackground(SystemColor.BLUE);
		}
	}

	private String loadLoanTypeName(int id) {
		String str = "";
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		str = loanTypeModel.loadLoanTypeNameById(id);
		return str;
	}

	private String loadPaymentTypeName(int id) {
		String str = "";
		PaymentTypeModel paymentTypeModel = new PaymentTypeModel();
		str = paymentTypeModel.loadPaymentTypeNameById(id);
		return str;
	}

	private String loadEmployeeName(int id) {
		String str = "";
		AccountModel accountModel = new AccountModel();
		str = accountModel.loadEmployeeNameByID(id);
		return str;
	}

	private String loadCustomerName(int id) {
		String str = "";
		CustomerModel customerModel = new CustomerModel();
		str = customerModel.findCustomerNameById(id);
		return str;
	}

	private void updateStatus(int id) {
		int a = JOptionPane.showConfirmDialog(null, "Do you want to inspect this loan", "Warning",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (a == JOptionPane.YES_OPTION) {
			LoanModel loanModel = new LoanModel();
			if (loanModel.accpetLoan(id)) {
				JOptionPane.showMessageDialog(null, "Done");

			} else {
				JOptionPane.showMessageDialog(null, "Fail");
			}
		}
	}

	private void createLoanAndFineHistory(int id) {
		LoanModel loanModel = new LoanModel();
		Loan loan = loanModel.loadLoanByID(id);
		Double amountDouble = loan.getAmount();
		LoanType loanType = loanModel.loadLoanTypeByLoanID(id);
//		PaymentType paymentType = (PaymentType) cbbxPaymentType.getSelectedItem();
//		int period = (int) cbbxPeriod.getSelectedItem();
		int duration = loan.getDuration();
//		String description = txtDescription.getText();
//		Date disbursement = txtDisbursement.getDate();
//		Date endDate = txtEndDate.getDate();
		double installment = amountDouble * Math.pow(1 + loanType.getInterest(), duration / 12) / duration;
		FineModel fineModel = new FineModel();
		Fine fine = new Fine();
		fine = fineModel.find_fine_interest(installment);
		int fine_id = fine.getId();
		double fine_interest = fine.getFineInterest();
		double fine_amount = installment * fine_interest;
		LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
		Date today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);

		loanAndFineHistory.setLoanId(loan.getId());
		loanAndFineHistory.setFineId(fine_id);
		loanAndFineHistory.setFineInterest(fine_interest);
		loanAndFineHistory.setPaymentDate(today);
		loanAndFineHistory.setAmount(installment);
		loanAndFineHistory.setPaymentAmount(0);
		loanAndFineHistory.setDescription(null);
		loanAndFineHistory.setStatus(false);
		loanAndFineHistory.setPaymentMethodId(4);
		loanAndFineHistory.setAmountLeft(loan.getAmount());
		loanAndFineHistory.setFineAmount(0);
		loanAndFineHistory.setFineOverDays(0);
		LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
		for (int i = 1; i <= duration; i++) {
			calendar.add(calendar.MONTH, 1);
			loanAndFineHistory.setDueDate(calendar.getTime());
			loanAndFineHistoryModel.createLoanAndFineHistory(loanAndFineHistory);
		}
	}

	private void callParentPanel(int customerId, int loanId) {
		LoanModel loanModel = new LoanModel();
		Loan loan = loanModel.loadLoanByID(loanId);
		JPanel jpanelMain = (JPanel) this.getParent();
		jpanelMain.removeAll();
		jpanelMain.revalidate();
		CustomerModel customerModel = new CustomerModel();
		jpanelShowLoanDetail detail = new jpanelShowLoanDetail(customerModel.findById(customerId), loan);
		jpanelMain.add(detail);
		detail.setVisible(true);
	}

	class LoanTableStatusButtonRenderer extends JButton implements TableCellRenderer {
		public LoanTableStatusButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setForeground(Color.black);
			setBackground(UIManager.getColor("Button.background"));
			setText((value == null) ? "" : value.toString());
			loadColorOfButton(value.toString(), "New", "Open", "Fully Paid", "Stop", this);
			return this;
		}
	}

	public class ClientsTableRenderer extends DefaultCellEditor {
		private JButton button;
		private String label;
		private boolean clicked;
		private int row, col;
		private JTable table;

		public ClientsTableRenderer(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
					if (button.getText().equals("New")) {
						int id = (int) table.getValueAt(row, 0);
						updateStatus(id);
						createLoanAndFineHistory(id);
					}

					// adding reload table function
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			this.row = row;
			this.col = column;

			button.setForeground(Color.black);
			button.setBackground(UIManager.getColor("Button.background"));
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			clicked = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (clicked) {

			}
			clicked = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			clicked = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

	class LoanTableViewButtonRenderer extends JButton implements TableCellRenderer {
		public LoanTableViewButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setForeground(Color.black);
			setBackground(UIManager.getColor("Button.background"));
			setText((value == null) ? "" : value.toString());
//			loadColorOfButton(value.toString(), "New", "Open", this);
			return this;
		}
	}

	public class ViewClientsTableRenderer extends DefaultCellEditor {
		private JButton button;
		private String label;
		private boolean clicked;
		private int row, col;
		private JTable table;

		public ViewClientsTableRenderer(JCheckBox checkBox) {
			super(checkBox);
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped();
					int loanId = (int) table.getValueAt(row, 0);
					int customerId = (int) table.getModel().getValueAt(row, 0);
					callParentPanel(customerId, loanId);
					// adding reload table function
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			this.row = row;
			this.col = column;

			button.setForeground(Color.black);
			button.setBackground(UIManager.getColor("Button.background"));
			label = (value == null) ? "" : value.toString();
			button.setText(label);
			clicked = true;
			return button;
		}

		public Object getCellEditorValue() {
			if (clicked) {

			}
			clicked = false;
			return new String(label);
		}

		public boolean stopCellEditing() {
			clicked = false;
			return super.stopCellEditing();
		}

		protected void fireEditingStopped() {
			super.fireEditingStopped();
		}
	}

	private void loadDataToComboBox() {

	}
}
