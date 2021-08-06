package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JDialogAddNewLoan extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField txtCustomerID;
	private JTextField txtAmount;
	private JTextField txtDuration;
	private JTextField txtPeriod;
	private JComboBox cbLoanType;
	private JComboBox cbPaymentTypt;
	private JButton btnAdd;
	private JDateChooser jdatechooserDisbursementDate;
	private JDateChooser jdatechooserEndDate;
	private JTextArea jtxtAreaDiscription;
	private JCheckBox chkStatus;
	private Account account = new Account();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			JDialogAddNewLoan dialog = new JDialogAddNewLoan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public JDialogAddNewLoan() {
		setTitle("Add New Loan");
		setBounds(100, 100, 603, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(34, 40, 44));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			panel.setBackground(new Color(21, 25, 28));
			contentPanel.add(panel);
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(JDialogAddNewLoan.class
						.getResource("/com/aptech/LoanProcessingSystem/images/icons8_add_tab_20px_1.png")));
				panel.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Add New Loan");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34, 40, 44));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(null);

				JLabel lblNewLabel_2 = new JLabel("Customer ID");
				lblNewLabel_2.setForeground(SystemColor.text);
				lblNewLabel_2.setBounds(26, 30, 70, 16);
				panel_1.add(lblNewLabel_2);

				txtCustomerID = new JTextField();
				txtCustomerID.setBounds(111, 24, 122, 28);
				panel_1.add(txtCustomerID);
				txtCustomerID.setColumns(10);
				{
					JLabel lblNewLabel_2_1 = new JLabel("Loan Type");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(41, 84, 70, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Payment Type");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(21, 140, 90, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					txtAmount = new JTextField();
					txtAmount.setColumns(10);
					txtAmount.setBounds(111, 192, 122, 28);
					panel_1.add(txtAmount);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Amount");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(41, 198, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					txtDuration = new JTextField();
					txtDuration.addFocusListener(new FocusAdapter() {
						@Override
						public void focusLost(FocusEvent e) {
							txtDuration_focusLost(e);
						}
					});
					txtDuration.setColumns(10);
					txtDuration.setBounds(111, 250, 122, 28);
					panel_1.add(txtDuration);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Duration");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(41, 256, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					txtPeriod = new JTextField();
					txtPeriod.setColumns(10);
					txtPeriod.setBounds(389, 24, 147, 28);
					panel_1.add(txtPeriod);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Period");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(333, 30, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("End Date");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(319, 84, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Disbursement Date");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(266, 140, 108, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Description");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(304, 198, 70, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Status");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(333, 264, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}

				cbLoanType = new JComboBox();
				cbLoanType.setBounds(111, 79, 122, 26);
				panel_1.add(cbLoanType);

				cbPaymentTypt = new JComboBox();
				cbPaymentTypt.setBounds(111, 135, 122, 26);
				panel_1.add(cbPaymentTypt);

				jdatechooserEndDate = new JDateChooser();
				jdatechooserEndDate.setBounds(392, 84, 144, 28);
				panel_1.add(jdatechooserEndDate);

				jdatechooserDisbursementDate = new JDateChooser();
				jdatechooserDisbursementDate.setBounds(392, 140, 144, 28);
				panel_1.add(jdatechooserDisbursementDate);

				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(392, 198, 144, 53);
				panel_1.add(scrollPane);

				jtxtAreaDiscription = new JTextArea();
				scrollPane.setViewportView(jtxtAreaDiscription);

				chkStatus = new JCheckBox("Public");
				chkStatus.setForeground(SystemColor.text);
				chkStatus.setBounds(389, 263, 104, 18);
				panel_1.add(chkStatus);

				btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnAdd_actionPerformed(e);
					}
				});
				btnAdd.setBounds(237, 303, 90, 28);
				panel_1.add(btnAdd);
			}
		}
		cbLoanType_FillToJComboBox();
		cbPaymentTypt_FillToJComboBox();
	}
	
	public JDialogAddNewLoan(Account account) {
		this();
		this.account = account;
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		if (validation()) {
			Loan loan = new Loan();
		}
	}

	public boolean validation() {
		boolean result = false;
		String errorMsg = "";
		if (!checkCustomerIDExisted()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "This customer ID does not existed!!";
		}

		if (!checkDisbursementDate()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "The disbursment date must larger than today!!";
		}

		if (!checkPeriod()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Period can not larger than duration!!";
		}

		if (!checkAmount()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "The amount must be larger than 1000000!!";
		}
		
		if (txtCustomerID.getText().trim().isEmpty() || 
				txtAmount.getText().trim().isEmpty() ||
				txtDuration.getText().trim().isEmpty() ||
				txtPeriod.getText().trim().isEmpty() ||
				jdatechooserDisbursementDate.getDate() == null) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Please finish all information!!";
		}
		if (errorMsg.isEmpty()) {
			result = true;
		}
		return result;
	}

	public void txtDuration_focusLost(FocusEvent e) {
		countEndDate();
	}

	public void countEndDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Calendar now = Calendar.getInstance();
		int i = Integer.parseInt(txtDuration.getText().trim());
		now.add(Calendar.MONTH, i);
		jdatechooserEndDate.setDate(now.getTime());
	}

	public boolean checkDisbursementDate() {
		Calendar calendar = Calendar.getInstance();
		return jdatechooserDisbursementDate.getDate().after(calendar.getTime());
	}

	public boolean checkAmount() {
		return Integer.parseInt(txtAmount.getText().trim()) > 1000000;
	}

	public boolean checkPeriod() {
		return Integer.parseInt(txtPeriod.getText().trim()) < Integer.parseInt(txtDuration.getText().trim());
	}

	public boolean checkCustomerIDExisted() {
		CustomerModel customer = new CustomerModel();
		return customer.findCustomerByEmail(Integer.parseInt(txtCustomerID.getText().trim()));
	}

	public void cbLoanType_FillToJComboBox() {
		DefaultComboBoxModel<LoanType> boxModel = new DefaultComboBoxModel<LoanType>();
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
			boxModel.addElement(loanType);
		}
		cbLoanType.setModel(boxModel);
		cbLoanType.setRenderer(new cbLoanTypeCellRender());
	}

	public class cbLoanTypeCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			LoanType loanType = (LoanType) value;
			return super.getListCellRendererComponent(list, loanType.getName(), index, isSelected, cellHasFocus);
		}

	}

	public void cbPaymentTypt_FillToJComboBox() {
		DefaultComboBoxModel<PaymentType> boxModel = new DefaultComboBoxModel<PaymentType>();
		PaymentTypeModel paymentTypeModel = new PaymentTypeModel();
		for (PaymentType paymentType : paymentTypeModel.getAllPaymentTypes()) {
			boxModel.addElement(paymentType);
		}
		cbPaymentTypt.setModel(boxModel);
		cbPaymentTypt.setRenderer(new cbPaymentTypt_CellRender());
	}

	public class cbPaymentTypt_CellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			PaymentType paymentType = (PaymentType) value;
			return super.getListCellRendererComponent(list, paymentType.getName(), index, isSelected, cellHasFocus);
		}

	}
}
