package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class JFrameAddNewLoan extends JFrame {

	private JPanel contentPane;
	private JCheckBox chkStatus;
	private JTextField txtCustomerID;
	private JTextField txtAmount;
	private JTextField txtPeriod;
	private JTextField txtDuration;
	private JComboBox cbLoanType;
	private JComboBox cbPayment;
	private JTextArea txtAreaDescription;
	private JDateChooser jdatechooserDisbursementDate;
	private JDateChooser jdatechooserEndDate;
	private JButton btnAddNewLoanType;
	private double interest = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameAddNewLoan frame = new JFrameAddNewLoan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameAddNewLoan() {
		setTitle("Add New ");
		setBounds(100, 100, 742, 496);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.setBackground(new Color(21, 25, 28));
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameAddNewLoan.class
				.getResource("/com/aptech/LoanProcessingSystem/images/icons8_add_tab_20px_1.png")));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Add New Loan");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(SystemColor.text);
		panel.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(34, 40, 44));
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2_1 = new JLabel("Loan Type");
		lblNewLabel_2_1.setForeground(SystemColor.text);
		lblNewLabel_2_1.setBounds(57, 49, 73, 16);
		panel_2.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_3 = new JLabel("Description");
		lblNewLabel_2_3.setForeground(SystemColor.text);
		lblNewLabel_2_3.setBounds(432, 234, 73, 16);
		panel_2.add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Status");
		lblNewLabel_2_4.setForeground(SystemColor.text);
		lblNewLabel_2_4.setBounds(460, 288, 55, 16);
		panel_2.add(lblNewLabel_2_4);

		btnAddNewLoanType = new JButton("Add");
		btnAddNewLoanType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddNewLoanType_actionPerformed(e);
			}
		});

		btnAddNewLoanType.setBounds(316, 360, 90, 28);
		panel_2.add(btnAddNewLoanType);

		chkStatus = new JCheckBox("Public");
		chkStatus.setForeground(SystemColor.text);
		chkStatus.setBounds(542, 287, 104, 18);
		panel_2.add(chkStatus);

		cbLoanType = new JComboBox();
		cbLoanType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbLoanType_actionPerformed(e);
			}
		});
		cbLoanType.setBounds(167, 44, 122, 26);
		panel_2.add(cbLoanType);

		JLabel lblNewLabel_2_2_1 = new JLabel("Customer ID");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setBounds(57, 111, 90, 16);
		panel_2.add(lblNewLabel_2_2_1);

		txtCustomerID = new JTextField();
		txtCustomerID.setColumns(10);
		txtCustomerID.setBounds(167, 105, 122, 28);
		panel_2.add(txtCustomerID);

		JLabel lblNewLabel_2_2_2 = new JLabel("Payment ");
		lblNewLabel_2_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2_2.setBounds(57, 175, 55, 16);
		panel_2.add(lblNewLabel_2_2_2);

		JLabel lblNewLabel_2_2_3 = new JLabel("Amount");
		lblNewLabel_2_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_2_3.setBounds(57, 234, 55, 16);
		panel_2.add(lblNewLabel_2_2_3);

		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		txtAmount.setBounds(167, 228, 122, 28);
		panel_2.add(txtAmount);

		JLabel lblNewLabel_2_2_4 = new JLabel("Period");
		lblNewLabel_2_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_2_4.setBounds(57, 289, 55, 16);
		panel_2.add(lblNewLabel_2_2_4);

		txtPeriod = new JTextField();
		txtPeriod.setColumns(10);
		txtPeriod.setBounds(167, 283, 122, 28);
		panel_2.add(txtPeriod);

		JLabel lblNewLabel_2_2_5 = new JLabel("Duration");
		lblNewLabel_2_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_2_5.setBounds(450, 49, 55, 16);
		panel_2.add(lblNewLabel_2_2_5);

		txtDuration = new JTextField();
		txtDuration.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				txtDuration_focusLost(e);
			}
		});
		txtDuration.setColumns(10);
		txtDuration.setBounds(542, 37, 122, 28);
		panel_2.add(txtDuration);

		JLabel lblNewLabel_2_2_5_1 = new JLabel("End Date");
		lblNewLabel_2_2_5_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_5_1.setBounds(445, 111, 55, 16);
		panel_2.add(lblNewLabel_2_2_5_1);

		JLabel lblNewLabel_2_2_5_2 = new JLabel("Disbursement Date");
		lblNewLabel_2_2_5_2.setForeground(Color.WHITE);
		lblNewLabel_2_2_5_2.setBounds(393, 175, 122, 16);
		panel_2.add(lblNewLabel_2_2_5_2);

		cbPayment = new JComboBox();
		cbPayment.setBounds(167, 170, 122, 26);
		panel_2.add(cbPayment);

		jdatechooserDisbursementDate = new JDateChooser();

		jdatechooserDisbursementDate.setBounds(545, 170, 119, 28);
		panel_2.add(jdatechooserDisbursementDate);

		jdatechooserEndDate = new JDateChooser();
		jdatechooserEndDate.setBounds(545, 105, 119, 28);
		panel_2.add(jdatechooserEndDate);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(543, 221, 121, 54);
		panel_2.add(scrollPane);

		txtAreaDescription = new JTextArea();
		scrollPane.setViewportView(txtAreaDescription);
		cbLoanType_FillToJComboBox();
//		cbPayment_FillToJComboBox();
	}
	
	public boolean validation() {
		boolean result = false;
		String errorMsg = "";
		
		if (!checkExistedCustomerID()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "This customer ID does not existed!!!";
		}
		
		if (!checkAmount()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Amount must be larger than 1000000";
		}
		
		if (!checkPeriod()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Period can not larger than duration";
		}
		
		if (!checkDisbursementDate()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Disbursement Date must be later today";
		}
		if (errorMsg.isEmpty()) {
			result = true;
		}
		return result;
	}
	
	public void btnAddNewLoanType_actionPerformed(ActionEvent e) {
		if (validation()) {
			
		}
	}

	public void cbLoanType_actionPerformed(ActionEvent e) {
		LoanType loanType = (LoanType) cbLoanType.getSelectedItem();
		interest = loanType.getInterest();
		System.out.println(interest);
	}

	public void cbLoanType_FillToJComboBox() {
		DefaultComboBoxModel<LoanType> boxModel = new DefaultComboBoxModel<LoanType>();
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		for (LoanType loantype : loanTypeModel.loadAllLoanType()) {
			boxModel.addElement(loantype);
		}
		cbLoanType.setModel(boxModel);
		cbLoanType.setRenderer(new LoanTypeCellRender());
	}

	public void cbPayment_FillToJComboBox() {
		DefaultComboBoxModel<PaymentType> boxModel = new DefaultComboBoxModel<PaymentType>();
		PaymentTypeModel model = new PaymentTypeModel();
		for (PaymentType paymentType : model.getAllPaymentTypes()) {
			boxModel.addElement(paymentType);
		}
		cbPayment.setModel(boxModel);
		cbPayment.setRenderer(new PaymentTypeCellRender());
	}

	public class PaymentTypeCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			PaymentType paymentType = (PaymentType) value;
			return super.getListCellRendererComponent(list, paymentType.getName(), index, isSelected, cellHasFocus);
		}

	}

	public class LoanTypeCellRender extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			LoanType loanType = (LoanType) value;
			return super.getListCellRendererComponent(list, loanType.getName(), index, isSelected, cellHasFocus);
		}

	}

	public void txtDuration_focusLost(FocusEvent e) {
		countEndDate();
	}

	public void countEndDate () {
		if (!txtDuration.getText().trim().equals("")) {
			Calendar cal = Calendar.getInstance();
			int i = Integer.parseInt(txtDuration.getText().trim());
			cal.add(Calendar.MONTH, i);
			Date date = cal.getTime();
			jdatechooserEndDate.setDate(date);
		}
	}
	
	public boolean checkDisbursementDate() {
		Calendar now = Calendar.getInstance();
		Date disbursementDate = jdatechooserDisbursementDate.getDate();
		Calendar disbursmentCal = Calendar.getInstance();
		disbursmentCal.setTime(disbursementDate);
		if (!now.after(disbursmentCal)) {
			return true;
		}
		return false;
	}
	
	public boolean checkExistedCustomerID() {
		LoanModel loanModel = new LoanModel();
		if (loanModel.findCustomerByID(Integer.parseInt(txtCustomerID.getText().trim()))) {
			return true;
		}
		return false;
	}
	
	public boolean checkAmount () {
		if (Double.parseDouble(txtAmount.getText().trim()) > 1000000) {
			return true;
		}
		return false;
	}
	
	public boolean checkPeriod () {
		if (Integer.parseInt(txtPeriod.getText().trim()) < Integer.parseInt(txtDuration.getText().trim())) {
			return true;
		}
		return false;
	}
}
