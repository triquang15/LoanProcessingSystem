package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.BoxLayout;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Insets;
import java.awt.SystemColor;

public class LoanHistoryUpdate extends JDialog {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	ButtonGroup bg;
	public String user;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCustomerName;
	private JTextField txtLoanType;
	private JTextField txtPaymentType;
	private JTextField txtPeriod;
	private JTextField txtLoanAmount;
	private JTextField txtInterest;
	private JTextField txtFineInterest;
	private JTextField txtFineOverdays;
	private String hintName = "Please enter customer name";
	private String hintEmail = "Please enter customer email";
	private String hintAddress = "Please enter customer address";
	private String hintCompany = "Please enter customer company";
	private String hintIdentity = "Please enter customer identity";
	private String hintPhone = "Please enter customer phone";
	private String hintSalary = "Please enter customer salary";
	private String hintJob = "Please enter customer job";
	private JTextField txtDuration;
	private JTextField txtPaymentAmount;
	private JTextField txtFineAmount;
	private JTextField txtAmountLeft;
	private JTextField txtTotalPayment;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				LoanHistoryUpdate dialog = new LoanHistoryUpdate();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LoanHistoryUpdate(int loanHisId) {
		this();
	}

	/**
	 * Create the dialog.
	 */
	public LoanHistoryUpdate() {
		setMinimumSize(new Dimension(1200, 580));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		bg = new ButtonGroup();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoanHistoryUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("New Customer");
		setBounds(100, 100, 1235, 745);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(50, 20, 30, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("New Customer");
		lblNewLabel.setPreferredSize(new Dimension(66, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setIcon(new ImageIcon(
				LoanHistoryUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/customer (2).png")));
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		contentPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(50, 50));
		panel.add(rigidArea_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));

		Component glue_3 = Box.createGlue();
		panel_2.add(glue_3);

		JLabel lblNewLabel_1 = new JLabel("Customer");
		lblNewLabel_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1);

		Component verticalStrut_7 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_7);

		JLabel lblNewLabel_1_1 = new JLabel("Loan type");
		lblNewLabel_1_1.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_1.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_1);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_6);

		JLabel lblNewLabel_1_2 = new JLabel("Payment type");
		lblNewLabel_1_2.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_2.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_2.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_2);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_5);

		JLabel lblNewLabel_1_3 = new JLabel("Period");
		lblNewLabel_1_3.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_3.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_3.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_3);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_4);

		JLabel lblNewLabel_1_4 = new JLabel("Duration");
		lblNewLabel_1_4.setMinimumSize(new Dimension(50, 30));
		lblNewLabel_1_4.setMaximumSize(new Dimension(100, 30));
		lblNewLabel_1_4.setPreferredSize(new Dimension(100, 30));
		panel_2.add(lblNewLabel_1_4);
					
								Component verticalStrut_10_3 = Box.createVerticalStrut(20);
								panel_2.add(verticalStrut_10_3);
		
					JLabel lblNewLabel_2 = new JLabel("Loan amount");
					panel_2.add(lblNewLabel_2);
					lblNewLabel_2.setPreferredSize(new Dimension(100, 30));
					lblNewLabel_2.setMinimumSize(new Dimension(50, 30));
					lblNewLabel_2.setMaximumSize(new Dimension(100, 30));
					
								Component verticalStrut_10_2 = Box.createVerticalStrut(20);
								panel_2.add(verticalStrut_10_2);
		
					JLabel lblNewLabel_3 = new JLabel("Interest");
					panel_2.add(lblNewLabel_3);
					lblNewLabel_3.setPreferredSize(new Dimension(100, 30));
					lblNewLabel_3.setMinimumSize(new Dimension(50, 30));
					lblNewLabel_3.setMaximumSize(new Dimension(100, 30));

		Component glue_4 = Box.createGlue();
		panel_2.add(glue_4);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.activeCaptionBorder);
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.PAGE_AXIS));

		Component glue_1 = Box.createGlue();
		panel_3.add(glue_1);

		txtCustomerName = new JTextField();
		txtCustomerName.setEnabled(false);
		txtCustomerName.setEditable(false);
		txtCustomerName.setPreferredSize(new Dimension(7, 30));
		txtCustomerName.setMinimumSize(new Dimension(7, 30));
		txtCustomerName.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtCustomerName);
		txtCustomerName.setColumns(10);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_2);

		txtLoanType = new JTextField();
		txtLoanType.setEnabled(false);
		txtLoanType.setEditable(false);
		txtLoanType.setPreferredSize(new Dimension(7, 30));
		txtLoanType.setMinimumSize(new Dimension(7, 30));
		txtLoanType.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtLoanType);
		txtLoanType.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_1);

		txtPaymentType = new JTextField();
		txtPaymentType.setEnabled(false);
		txtPaymentType.setEditable(false);
		txtPaymentType.setPreferredSize(new Dimension(7, 30));
		txtPaymentType.setMinimumSize(new Dimension(7, 30));
		txtPaymentType.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtPaymentType);
		txtPaymentType.setColumns(10);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut);

		txtPeriod = new JTextField();
		txtPeriod.setEnabled(false);
		txtPeriod.setEditable(false);
		txtPeriod.setPreferredSize(new Dimension(7, 30));
		txtPeriod.setMinimumSize(new Dimension(7, 30));
		txtPeriod.setMaximumSize(new Dimension(2147483647, 30));
		panel_3.add(txtPeriod);
		txtPeriod.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_3);
		
		txtDuration = new JTextField();
		txtDuration.setEnabled(false);
		txtDuration.setEditable(false);
		txtDuration.setText("Please enter customer phone");
		txtDuration.setPreferredSize(new Dimension(7, 30));
		txtDuration.setMinimumSize(new Dimension(7, 30));
		txtDuration.setMaximumSize(new Dimension(2147483647, 30));
		txtDuration.setForeground(Color.GRAY);
		txtDuration.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtDuration.setColumns(10);
		panel_3.add(txtDuration);
					
								Component verticalStrut_9_2 = Box.createVerticalStrut(20);
								panel_3.add(verticalStrut_9_2);
		
					txtLoanAmount = new JTextField();
					txtLoanAmount.setEnabled(false);
					panel_3.add(txtLoanAmount);
					txtLoanAmount.setEditable(false);
					txtLoanAmount.setMaximumSize(new Dimension(2147483647, 30));
					txtLoanAmount.setPreferredSize(new Dimension(7, 30));
					txtLoanAmount.setColumns(10);
					setTextHint(txtLoanAmount, hintSalary);
					
								Component verticalStrut_9_1 = Box.createVerticalStrut(20);
								panel_3.add(verticalStrut_9_1);
		
					txtInterest = new JTextField();
					panel_3.add(txtInterest);
					txtInterest.setEnabled(false);
					txtInterest.setEditable(false);
					txtInterest.setMaximumSize(new Dimension(2147483647, 30));
					txtInterest.setPreferredSize(new Dimension(7, 30));
					txtInterest.setColumns(10);
					setTextHint(txtInterest, hintJob);

		Component glue = Box.createGlue();
		panel_3.add(glue);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(50, 50));
		panel.add(rigidArea_2);

		Component glue_2 = Box.createGlue();
		panel.add(glue_2);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(50, 20));
		panel_1.add(rigidArea);

		{
			JPanel panel_1_1 = new JPanel();
			panel_1.add(panel_1_1);
			panel_1_1.setBackground(SystemColor.activeCaptionBorder);
			panel_1_1.setLayout(new BoxLayout(panel_1_1, BoxLayout.X_AXIS));

			Component rigidArea_1_1 = Box.createRigidArea(new Dimension(20, 20));
			rigidArea_1_1.setPreferredSize(new Dimension(50, 50));
			panel_1_1.add(rigidArea_1_1);

			JPanel panel_7 = new JPanel();
			panel_7.setBackground(SystemColor.activeCaptionBorder);
			panel_1_1.add(panel_7);
			panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.PAGE_AXIS));

			Component glue_7 = Box.createGlue();
			panel_7.add(glue_7);
			
			JLabel lblNewLabel_4_1 = new JLabel("Payment amount");
			lblNewLabel_4_1.setPreferredSize(new Dimension(100, 30));
			lblNewLabel_4_1.setMinimumSize(new Dimension(50, 30));
			lblNewLabel_4_1.setMaximumSize(new Dimension(100, 30));
			panel_7.add(lblNewLabel_4_1);
			
			Component verticalStrut_10_2_1 = Box.createVerticalStrut(20);
			panel_7.add(verticalStrut_10_2_1);

			JLabel lblNewLabel_4 = new JLabel("Due date");
			lblNewLabel_4.setPreferredSize(new Dimension(100, 30));
			lblNewLabel_4.setMinimumSize(new Dimension(50, 30));
			lblNewLabel_4.setMaximumSize(new Dimension(100, 30));
			panel_7.add(lblNewLabel_4);

			Component verticalStrut_10_1 = Box.createVerticalStrut(20);
			panel_7.add(verticalStrut_10_1);
			
						JLabel lblNewLabel_5 = new JLabel("Fine over days");
						lblNewLabel_5.setPreferredSize(new Dimension(100, 30));
						lblNewLabel_5.setMinimumSize(new Dimension(50, 30));
						lblNewLabel_5.setMaximumSize(new Dimension(100, 30));
						panel_7.add(lblNewLabel_5);
			
			Component verticalStrut_10_1_1 = Box.createVerticalStrut(20);
			panel_7.add(verticalStrut_10_1_1);
			
						JLabel lblNewLabel_7 = new JLabel("Fine interest");
						lblNewLabel_7.setPreferredSize(new Dimension(100, 30));
						lblNewLabel_7.setMinimumSize(new Dimension(50, 30));
						lblNewLabel_7.setMaximumSize(new Dimension(100, 30));
						panel_7.add(lblNewLabel_7);

			Component verticalStrut_10 = Box.createVerticalStrut(20);
			panel_7.add(verticalStrut_10);
			
			JLabel lblNewLabel_7_1 = new JLabel("Fine amount");
			lblNewLabel_7_1.setPreferredSize(new Dimension(100, 30));
			lblNewLabel_7_1.setMinimumSize(new Dimension(50, 30));
			lblNewLabel_7_1.setMaximumSize(new Dimension(100, 30));
			panel_7.add(lblNewLabel_7_1);
			
			Component verticalStrut_10_4 = Box.createVerticalStrut(20);
			panel_7.add(verticalStrut_10_4);
			
			JLabel lblNewLabel_7_1_1 = new JLabel("Amount left");
			lblNewLabel_7_1_1.setPreferredSize(new Dimension(100, 30));
			lblNewLabel_7_1_1.setMinimumSize(new Dimension(50, 30));
			lblNewLabel_7_1_1.setMaximumSize(new Dimension(100, 30));
			panel_7.add(lblNewLabel_7_1_1);
			
			Component verticalStrut_10_4_1 = Box.createVerticalStrut(20);
			panel_7.add(verticalStrut_10_4_1);
			
			JLabel lblNewLabel_7_1_1_1 = new JLabel("Amount left");
			lblNewLabel_7_1_1_1.setPreferredSize(new Dimension(100, 30));
			lblNewLabel_7_1_1_1.setMinimumSize(new Dimension(50, 30));
			lblNewLabel_7_1_1_1.setMaximumSize(new Dimension(100, 30));
			panel_7.add(lblNewLabel_7_1_1_1);

			Component glue_8 = Box.createGlue();
			panel_7.add(glue_8);

			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			panel_1_1.add(horizontalStrut_1);

			JPanel panel_5 = new JPanel();
			panel_5.setBackground(SystemColor.activeCaptionBorder);
			panel_1_1.add(panel_5);
			panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.PAGE_AXIS));

			Component glue_5 = Box.createGlue();
			panel_5.add(glue_5);
			
			txtPaymentAmount = new JTextField();
			txtPaymentAmount.setText("Please enter customer identity");
			txtPaymentAmount.setPreferredSize(new Dimension(7, 30));
			txtPaymentAmount.setMaximumSize(new Dimension(2147483647, 30));
			txtPaymentAmount.setForeground(Color.GRAY);
			txtPaymentAmount.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtPaymentAmount.setColumns(10);
			panel_5.add(txtPaymentAmount);
			
			Component verticalStrut_9_4 = Box.createVerticalStrut(20);
			panel_5.add(verticalStrut_9_4);
			
			JPanel panel_4 = new JPanel();
			panel_4.setMinimumSize(new Dimension(10, 30));
			panel_4.setMaximumSize(new Dimension(32767, 30));
			panel_5.add(panel_4);
			panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
			
			JDateChooser txtDueDate = new JDateChooser();
			txtDueDate.getCalendarButton().setSize(new Dimension(0, 30));
			txtDueDate.getCalendarButton().setPreferredSize(new Dimension(21, 30));
			txtDueDate.getCalendarButton().setOpaque(false);
			txtDueDate.getCalendarButton().setMinimumSize(new Dimension(100, 30));
			txtDueDate.getCalendarButton().setMaximumSize(new Dimension(21, 30));
			txtDueDate.getCalendarButton().setEnabled(false);
			txtDueDate.getCalendarButton().setAlignmentX(0.5f);
			panel_4.add(txtDueDate);

			Component verticalStrut_9 = Box.createVerticalStrut(20);
			panel_5.add(verticalStrut_9);
			
						txtFineOverdays = new JTextField();
						txtFineOverdays.setEditable(false);
						txtFineOverdays.setEnabled(false);
						txtFineOverdays.setMaximumSize(new Dimension(2147483647, 30));
						txtFineOverdays.setPreferredSize(new Dimension(7, 30));
						panel_5.add(txtFineOverdays);
						txtFineOverdays.setColumns(10);
						setTextHint(txtFineOverdays, hintIdentity);
			
			Component verticalStrut_9_3 = Box.createVerticalStrut(20);
			panel_5.add(verticalStrut_9_3);
			
						txtFineInterest = new JTextField();
						txtFineInterest.setEditable(false);
						txtFineInterest.setEnabled(false);
						txtFineInterest.setMaximumSize(new Dimension(2147483647, 30));
						txtFineInterest.setPreferredSize(new Dimension(7, 30));
						panel_5.add(txtFineInterest);
						txtFineInterest.setColumns(10);
						setTextHint(txtFineInterest, hintCompany);

			Component verticalStrut_8 = Box.createVerticalStrut(20);
			panel_5.add(verticalStrut_8);
			
			txtFineAmount = new JTextField();
			txtFineAmount.setText("Please enter customer company");
			txtFineAmount.setPreferredSize(new Dimension(7, 30));
			txtFineAmount.setMaximumSize(new Dimension(2147483647, 30));
			txtFineAmount.setForeground(Color.GRAY);
			txtFineAmount.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtFineAmount.setEnabled(false);
			txtFineAmount.setEditable(false);
			txtFineAmount.setColumns(10);
			panel_5.add(txtFineAmount);
			
			Component verticalStrut_10_5 = Box.createVerticalStrut(20);
			panel_5.add(verticalStrut_10_5);
			
			txtAmountLeft = new JTextField();
			txtAmountLeft.setText("Please enter customer company");
			txtAmountLeft.setPreferredSize(new Dimension(7, 30));
			txtAmountLeft.setMaximumSize(new Dimension(2147483647, 30));
			txtAmountLeft.setForeground(Color.GRAY);
			txtAmountLeft.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtAmountLeft.setEnabled(false);
			txtAmountLeft.setEditable(false);
			txtAmountLeft.setColumns(10);
			panel_5.add(txtAmountLeft);
			
			Component verticalStrut_10_4_2 = Box.createVerticalStrut(20);
			panel_5.add(verticalStrut_10_4_2);
			
			txtTotalPayment = new JTextField();
			txtTotalPayment.setText("Please enter customer company");
			txtTotalPayment.setPreferredSize(new Dimension(7, 30));
			txtTotalPayment.setMaximumSize(new Dimension(2147483647, 30));
			txtTotalPayment.setForeground(Color.GRAY);
			txtTotalPayment.setFont(new Font("Tahoma", Font.ITALIC, 10));
			txtTotalPayment.setEnabled(false);
			txtTotalPayment.setEditable(false);
			txtTotalPayment.setColumns(10);
			panel_5.add(txtTotalPayment);

			Component glue_6 = Box.createGlue();
			panel_5.add(glue_6);

			Component horizontalStrut_2 = Box.createHorizontalStrut(20);
			panel_1_1.add(horizontalStrut_2);

			Component glue_10 = Box.createGlue();
			panel_1_1.add(glue_10);

			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

			JButton btnSave = new JButton("Save");
			btnSave.setPreferredSize(new Dimension(120, 30));
			buttonPane.add(btnSave);
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));

			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addCustomerAction();
				}
			});
			btnSave.setIcon(new ImageIcon(
					LoanHistoryUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/floppy-disk.png")));

			JButton btnClear = new JButton("Clear");
			btnClear.setPreferredSize(new Dimension(120, 30));
			buttonPane.add(btnClear);
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					initForm();
				}
			});
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnClear.setIcon(new ImageIcon(
					LoanHistoryUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));

			JButton btnNewButton = new JButton("Cancel");
			btnNewButton.setPreferredSize(new Dimension(120, 30));
			buttonPane.add(btnNewButton);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cancelAction();
				}
			});
			btnNewButton.setIcon(new ImageIcon(
					LoanHistoryUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		}
		initForm();
		setTextHint(txtCustomerName, hintName);
		setTextHint(txtPaymentType, hintEmail);
		setTextHint(txtLoanType, hintAddress);
		setTextHint(txtPeriod, hintPhone);
	}

	protected void addCustomerAction() {

		String name = txtCustomerName.getText().trim();
		String email = txtPaymentType.getText().trim();
		String address = txtLoanType.getText().trim();
		String phone = txtPeriod.getText().trim();
		String company = txtFineInterest.getText().trim();
		String job = txtInterest.getText().trim();
		String salary = txtLoanAmount.getText();
		String identity_card = txtFineOverdays.getText().trim();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 16);
		Date dateCheck = calendar.getTime();
		boolean isPhoneValid = Pattern.matches("^[0-9]{10}$", txtPeriod.getText().trim());
		boolean isIdentityValid = Pattern.matches("^[a-zA-Z0-9]{11}$", txtFineOverdays.getText().trim());
		boolean isEmailValid = Pattern.matches("^[a-zA-Z0-9]+(.+)+[@]{1}+(.+)+[.]{1}+[a-zA-Z0-9]+$",
				txtPaymentType.getText().trim());
		boolean isSalaryValid = Pattern.matches("^\\d+", txtLoanAmount.getText().trim());
		// Apply the validation logic checking all controls are empty or not
		if (!isPhoneValid) {

			JOptionPane.showMessageDialog(null, "Phone invalid!");

		} else if (!isIdentityValid) {

			JOptionPane.showMessageDialog(null, "Identity card invalid!");

		} else if (!isEmailValid) {

			JOptionPane.showMessageDialog(null, "Email invalid!");

		} else if (!isSalaryValid) {

			JOptionPane.showMessageDialog(null, "Salary invalid!");

		} else if (name.trim().equals(hintName) || job.trim().equals(hintJob) || address.trim().equals(hintAddress)
				|| company.trim().equals(hintCompany)) {

			JOptionPane.showMessageDialog(null, "Please enter full information !!!");

		} else {
			try {
				Customer customer = new Customer();
				customer.setName(name);
				customer.setEmail(email);
				customer.setJob(job);
				customer.setSalary(Float.parseFloat(salary));
				customer.setCompany(company);
				customer.setPhone(phone);
				customer.setAddress(address);
				customer.setIdentityCard(identity_card);

				CustomerModel customerModel = new CustomerModel();
				if (customerModel.create(customer)) {
					JOptionPane.showMessageDialog(null, "Successful!");

					LoanHistoryUpdate.this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Please try again!");
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	private void initForm() {
		txtCustomerName.setText(hintName);
		txtCustomerName.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtCustomerName.setForeground(Color.GRAY);
		txtPaymentType.setText(hintEmail);
		txtPaymentType.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtPaymentType.setForeground(Color.GRAY);
		txtLoanType.setText(hintAddress);
		txtLoanType.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtLoanType.setForeground(Color.GRAY);
		txtFineInterest.setText(hintCompany);
		txtFineInterest.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtFineInterest.setForeground(Color.GRAY);
		txtFineOverdays.setText(hintIdentity);
		txtFineOverdays.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtFineOverdays.setForeground(Color.GRAY);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 16);
		txtPeriod.setText(hintPhone);
		txtPeriod.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtPeriod.setForeground(Color.GRAY);
		txtLoanAmount.setText(hintSalary);
		txtLoanAmount.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtLoanAmount.setForeground(Color.GRAY);
		txtInterest.setText(hintJob);
		txtInterest.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtInterest.setForeground(Color.GRAY);
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

	private void cancelAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
}
