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
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Fine;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.FineModel;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import java.util.Calendar;
import java.util.Date;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;

public class CreateLoan extends JDialog {
	private ButtonGroup bg;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private JDateChooser txtEndDate;
	private JDateChooser txtDisbursement;
	private JTextArea txtDescription;
	private JComboBox<Integer> cbbxDuration;
	private JTextField txtCustomerName;
	private JComboBox cbbxPaymentType;
	private JComboBox cbbxLoanType;
	private JLabel txtInterest;
	private String hintAmount = "Please enter amount";
	private String hintPeriod = "Please enter period";
	private Customer customer;
	private JComboBox cbbxPeriod;
	private Date disbursementDate;
	private Date endDate;
	private float interest;
	private int duration;
	private Loan loan = new Loan();
	private LoanType loanType = new LoanType();
	private double amountDouble = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				CreateLoan dialog = new CreateLoan();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CreateLoan(int id) {
		this();
		initData(id);
	}

	/**
	 * Create the dialog.
	 */
	public CreateLoan() {
		getContentPane().setBackground(new Color(105, 105, 105));
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		bg = new ButtonGroup();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("New Loan");
		setBounds(100, 100, 1219, 607);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(30, 20, 30, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		contentPanel.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_1.setPreferredSize(new Dimension(50, 50));
		rigidArea_1.setMaximumSize(new Dimension(50, 50));
		panel.add(rigidArea_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setMaximumSize(new Dimension(100, 32767));
		panel.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.PAGE_AXIS));

		Component glue_3 = Box.createGlue();
		panel_3.add(glue_3);

		JLabel lblNewLabel_1_4 = new JLabel("Customer name");
		lblNewLabel_1_4.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_4.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_4.setMaximumSize(new Dimension(100, 30));
		panel_3.add(lblNewLabel_1_4);

		Component verticalStrut_5_4 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5_4);

		JLabel lblNewLabel_1_5 = new JLabel("Loan Type *");
		lblNewLabel_1_5.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_5.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_5.setMaximumSize(new Dimension(100, 30));
		panel_3.add(lblNewLabel_1_5);

		Component verticalStrut_5_3 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5_3);

		JLabel lblNewLabel_5 = new JLabel("Interest *");
		panel_3.add(lblNewLabel_5);
		lblNewLabel_5.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_5.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_5.setMaximumSize(new Dimension(100, 30));

		Component verticalStrut_5_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5_1);

		JLabel lblNewLabel_1 = new JLabel("Amount *");
		lblNewLabel_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(100, 30));
		panel_3.add(lblNewLabel_1);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5);

		JLabel lblNewLabel_1_1 = new JLabel("Period *");
		panel_3.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1.setMaximumSize(new Dimension(100, 30));

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_11);

		JLabel lblNewLabel_3 = new JLabel("Payment Type *");
		panel_3.add(lblNewLabel_3);
		lblNewLabel_3.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_3.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_3.setMaximumSize(new Dimension(100, 30));

		Component glue_2 = Box.createGlue();
		panel_3.add(glue_2);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel.add(horizontalStrut);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.PAGE_AXIS));

		Component glue_1 = Box.createGlue();
		panel_2.add(glue_1);

		txtCustomerName = new JTextField();
		txtCustomerName.setEditable(false);
		txtCustomerName.setMaximumSize(new Dimension(1000, 30));
		txtCustomerName.setMinimumSize(new Dimension(300, 30));
		txtCustomerName.setPreferredSize(new Dimension(0, 30));
		panel_2.add(txtCustomerName);
		txtCustomerName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtCustomerName.setColumns(10);

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_4);

		cbbxLoanType = new JComboBox();
		cbbxLoanType.setPreferredSize(new Dimension(29, 30));
		cbbxLoanType.setMinimumSize(new Dimension(29, 30));
		cbbxLoanType.setMaximumSize(new Dimension(32767, 30));
		panel_2.add(cbbxLoanType);

		cbbxLoanType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setInterestValue();
			}
		});

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_3);

		JPanel panel_9 = new JPanel();
		panel_2.add(panel_9);
		panel_9.setPreferredSize(new Dimension(10, 30));
		panel_9.setMinimumSize(new Dimension(10, 30));
		panel_9.setMaximumSize(new Dimension(32767, 30));
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

		txtInterest = new JLabel("");
		txtInterest.setEnabled(false);
		txtInterest.setMinimumSize(new Dimension(300, 30));
		txtInterest.setMaximumSize(new Dimension(1000, 30));
		txtInterest.setPreferredSize(new Dimension(0, 30));
		panel_9.add(txtInterest);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1);

		txtAmount = new JTextField();
		txtAmount.setMaximumSize(new Dimension(1000, 30));
		txtAmount.setMinimumSize(new Dimension(300, 30));
		txtAmount.setPreferredSize(new Dimension(0, 30));
		panel_2.add(txtAmount);

		txtAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtAmount.setColumns(10);
		setTextHint(txtAmount, hintAmount);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut);

		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setMinimumSize(new Dimension(10, 30));
		panel_7.setMaximumSize(new Dimension(32767, 30));
		panel_7.setPreferredSize(new Dimension(10, 30));
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));

		cbbxPeriod = new JComboBox();
		panel_7.add(cbbxPeriod);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_6);

		cbbxPaymentType = new JComboBox();
		panel_2.add(cbbxPaymentType);
		cbbxPaymentType.setMaximumSize(new Dimension(1000, 30));
		cbbxPaymentType.setMinimumSize(new Dimension(200, 30));
		cbbxPaymentType.setPreferredSize(new Dimension(0, 30));

		Component glue = Box.createGlue();
		panel_2.add(glue);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		rigidArea.setPreferredSize(new Dimension(50, 50));
		rigidArea.setMaximumSize(new Dimension(50, 50));
		panel.add(rigidArea);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_4.setPreferredSize(new Dimension(50, 50));
		contentPanel.add(rigidArea_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		contentPanel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setPreferredSize(new Dimension(50, 50));
		rigidArea_3.setMaximumSize(new Dimension(50, 50));
		panel_1.add(rigidArea_3);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setMaximumSize(new Dimension(100, 32767));
		panel_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.PAGE_AXIS));

		Component glue_6 = Box.createGlue();
		panel_5.add(glue_6);

		JLabel lblNewLabel_1_3 = new JLabel("Disbursement  *");
		panel_5.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_3.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_3.setMaximumSize(new Dimension(100, 30));

		Component verticalStrut_11_3 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_11_3);

		JLabel lblNewLabel_2 = new JLabel("Duration *");
		lblNewLabel_2.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_2.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_2.setMaximumSize(new Dimension(100, 30));
		panel_5.add(lblNewLabel_2);

		Component verticalStrut_12 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_12);

		JLabel lblNewLabel_4 = new JLabel("End Date *");
		lblNewLabel_4.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_4.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_4.setMaximumSize(new Dimension(100, 30));
		panel_5.add(lblNewLabel_4);

		Component verticalStrut_11_1 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_11_1);

		JLabel lblNewLabel_6 = new JLabel("Description *");
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setPreferredSize(new Dimension(100, 90));
		lblNewLabel_6.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_6.setMaximumSize(new Dimension(100, 30));
		panel_5.add(lblNewLabel_6);

		Component glue_7 = Box.createGlue();
		panel_5.add(glue_7);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.PAGE_AXIS));

		Component glue_4 = Box.createGlue();
		panel_4.add(glue_4);

		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		panel_8.setMaximumSize(new Dimension(1000, 30));
		panel_8.setMinimumSize(new Dimension(200, 30));
		panel_8.setPreferredSize(new Dimension(0, 30));
		panel_8.setLayout(new BorderLayout(0, 0));

		txtDisbursement = new JDateChooser();
		txtDisbursement.getCalendarButton().setVerifyInputWhenFocusTarget(false);
		txtDisbursement.getCalendarButton().setRequestFocusEnabled(false);

		panel_8.add(txtDisbursement);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_10);

		cbbxDuration = new JComboBox();
		cbbxDuration.setPreferredSize(new Dimension(29, 30));
		cbbxDuration.setMinimumSize(new Dimension(29, 30));
		cbbxDuration.setMaximumSize(new Dimension(32767, 30));
		panel_4.add(cbbxDuration);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_8);

		JPanel panel_6 = new JPanel();
		panel_6.setMaximumSize(new Dimension(1000, 30));
		panel_6.setMinimumSize(new Dimension(200, 30));
		panel_6.setPreferredSize(new Dimension(0, 30));
		panel_4.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		txtEndDate = new JDateChooser();
		txtEndDate.getCalendarButton().setVisible(false);
		txtEndDate.getCalendarButton().setEnabled(false);
		panel_6.add(txtEndDate);

		Component verticalStrut_13 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_13);

		txtDescription = new JTextArea();
		txtDescription.setMaximumSize(new Dimension(1000, 30));
		txtDescription.setMinimumSize(new Dimension(200, 30));
		txtDescription.setPreferredSize(new Dimension(0, 90));
		panel_4.add(txtDescription);

		Component glue_5 = Box.createGlue();
		panel_4.add(glue_5);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_2.setPreferredSize(new Dimension(50, 50));
		rigidArea_2.setMaximumSize(new Dimension(50, 50));
		panel_1.add(rigidArea_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

		JButton btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createLoanAction();
			}
		});
		btnSave.setIcon(
				new ImageIcon(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/floppy-disk.png")));

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
				CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));

		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelAction();
			}
		});
		btnNewButton.setIcon(
				new ImageIcon(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));

		JLabel lblNewLabel = new JLabel("New Loan");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBackground(new Color(105, 105, 105));
		lblNewLabel.setPreferredSize(new Dimension(45, 80));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setIcon(
				new ImageIcon(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/personal.png")));

		JTextFieldDateEditor disburEditor = (JTextFieldDateEditor) txtDisbursement.getDateEditor();
		disburEditor.setEditable(false);

		JTextFieldDateEditor endDateEditor = (JTextFieldDateEditor) txtEndDate.getDateEditor();
		endDateEditor.setEditable(false);
		initForm();

		cbbxDuration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setEndDateValue();
			}
		});

		txtDisbursement.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				setEndDateValue();
			}
		});
	}

	private void initData(int customerId) {
		customer = new CustomerModel().findById(customerId);
		txtCustomerName.setText(customer.getName());
	}

	protected void createLoanAction() {
		boolean isAmountValid = Pattern.matches("^\\d+", txtAmount.getText().trim());

		try {
			disbursementDate = txtDisbursement.getDate();
			System.out.println("disbursementDate: " + disbursementDate);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please select disbursement valid 1");
			txtDisbursement.grabFocus();
		}
		try {
			endDate = txtEndDate.getDate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please select end date valid");

		}

		Calendar nowCalendar = Calendar.getInstance();
		nowCalendar.setTime(new Date());
		nowCalendar.set(Calendar.HOUR_OF_DAY, 0);
		nowCalendar.set(Calendar.MINUTE, 0);
		nowCalendar.set(Calendar.SECOND, 0);
		Date now = nowCalendar.getTime();

		Calendar disburCalendar = Calendar.getInstance();
		disburCalendar.setTime(disbursementDate);

		boolean checkYear = !(disburCalendar.get(Calendar.YEAR) <= nowCalendar.get(Calendar.YEAR));
		boolean checkMonth = !(disburCalendar.get(Calendar.MONTH) <= nowCalendar.get(Calendar.MONTH));
		boolean checkDay = !(disburCalendar.get(Calendar.DAY_OF_MONTH) < nowCalendar.get(Calendar.DAY_OF_MONTH));
		boolean checkDate = checkYear
				|| ((disburCalendar.get(Calendar.YEAR) == nowCalendar.get(Calendar.YEAR)) && checkMonth)
				|| ((disburCalendar.get(Calendar.YEAR) == nowCalendar.get(Calendar.YEAR))
						&& (disburCalendar.get(Calendar.MONTH) == nowCalendar.get(Calendar.MONTH)) && checkDay);
		if (!checkDate) {
			JOptionPane.showMessageDialog(null, "Disbursement invalid");
			txtDisbursement.grabFocus();
		} else if (!isAmountValid) {
			JOptionPane.showMessageDialog(null, "Amount invalid!");
		} else {

			LoanType loanType = (LoanType) cbbxLoanType.getSelectedItem();
			PaymentType paymentType = (PaymentType) cbbxPaymentType.getSelectedItem();
			int period = (int) cbbxPeriod.getSelectedItem();
			int duration = (int) cbbxDuration.getSelectedItem();
			String description = txtDescription.getText();

			try {

				loan.setAmount(Double.parseDouble(txtAmount.getText()));
				loan.setDescription(txtDescription.getText());
				loan.setInterest(loanType.getInterest());
				loan.setPeriod(period);
				loan.setCustomerId(customer.getId());
				loan.setPaymentTypeId(paymentType.getId());
				loan.setLoanTypeId(loanType.getId());
				loan.setStatus(0);
				loan.setDuration(duration);
				loan.setCreateDate(new Date());
				loan.setDisbursementDate(disbursementDate);
				loan.setEndDate(endDate);

				LoanModel loanModel = new LoanModel();
				int id = loanModel.createResultId(loan);

				if (id != -1) {
					createLoanHistory(id);
				}

				this.dispose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	private void createLoanHistory(int loanId) {

//		FineModel fineModel = new FineModel();
//		Fine fine = new Fine();
//		fine = fineModel.find_fine_interest(installment);
//		int fine_id = fine.getId();
//		double fineInterest = fine.getFineInterest();
//		double fineAmount = installment * fineInterest;
		LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
		loanAndFineHistory.setLoanId(loanId);
		loanAndFineHistory.setPaymentMethodId(1);
		loanAndFineHistory.setPaymentAmount(0);
		loanAndFineHistory.setDescription(txtDescription.getText());
		loanAndFineHistory.setStatus(false);
		loanAndFineHistory.setFineAmount(0);
		loanAndFineHistory.setFineOverDays(0);
		loanAndFineHistory.setAmount(amountDouble);

		Calendar dueDateCalendar = Calendar.getInstance();
		dueDateCalendar.setTime(disbursementDate);

		Calendar disbursementCalendar = Calendar.getInstance();
		disbursementCalendar.setTime(disbursementDate);

		double installment = amountDouble * Math.pow(1 + loanType.getInterest(), duration / 12) / duration;
		double amountInAmount = amountDouble / duration;
		double amountLeft = amountDouble;
		int period = (int) cbbxPeriod.getSelectedItem();

		LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
		try {
			for (int i = period; i <= duration; i += period) {
				dueDateCalendar.set(Calendar.MONTH, disbursementCalendar.get(Calendar.MONTH) + i);
				Date dueDate = dueDateCalendar.getTime();
				double paymentAmount = amountLeft * loanType.getInterest();
				amountLeft = amountLeft - (amountInAmount * period);
				loanAndFineHistory.setPaymentAmount(paymentAmount);
				loanAndFineHistory.setAmountLeft(amountLeft);
				loanAndFineHistory.setDueDate(dueDate);
				if (!loanAndFineHistoryModel.createLoanAndFineHistory(loanAndFineHistory)) {
					loanAndFineHistoryModel.deleteWithLoanId(loanId);
					new LoanModel().delete(loanId);
					JOptionPane.showMessageDialog(null, "Please try again!");
					return;
				}
			}
			JOptionPane.showMessageDialog(null, "Successful!");
		} catch (Exception a) {
			JOptionPane.showMessageDialog(null, "Please try again!");
			a.printStackTrace();
		}

	}

	private void initForm() {
		txtAmount.setText(hintAmount);
		txtAmount.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtAmount.setForeground(Color.GRAY);
		txtDisbursement.setDate(new Date());
		initDurationValue();
		initPaymentValue();
		initLoanType();
		initPeriodValue();
		setInterestValue();
		setEndDateValue();

	}

	private void setInterestValue() {
		loanType = (LoanType) cbbxLoanType.getSelectedItem();
		txtInterest.setText(String.valueOf(loanType.getInterest() * 100) + " %");
	}

	private void setEndDateValue() {
		try {
			duration = (int) cbbxDuration.getSelectedItem();
			disbursementDate = txtDisbursement.getDate();
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(disbursementDate);
			calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + duration);
			endDate = calendar.getTime();
			txtEndDate.setDate(endDate);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Disbursement or end date is invalid!");
		}
	}

	private void initPeriodValue() {

		int[] durations = new int[] { 1, 3, 6 };
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
		for (int dur : durations) {
			model.addElement(dur);
		}
		cbbxPeriod.setModel(model);
		cbbxPeriod.setRenderer(new PeriodListCellRenderer());

	}

	private void initDurationValue() {

		int[] durations = new int[] { 6, 12, 18, 24, 36, 48, 72 };
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
		for (int dur : durations) {
			model.addElement(dur);
		}
		cbbxDuration.setModel(model);
		cbbxDuration.setRenderer(new DurationListCellRenderer());

	}

	private void initPaymentValue() {

		PaymentTypeModel paymentTypeModel = new PaymentTypeModel();
		DefaultComboBoxModel<PaymentType> model = new DefaultComboBoxModel<>();
		for (com.aptech.LoanProcessingSystem.entities.PaymentType paymentType : paymentTypeModel.getAllPaymentTypes()) {
			model.addElement(paymentType);
		}
		cbbxPaymentType.setModel(model);
		cbbxPaymentType.setRenderer(new PaymentListCellRenderer());

	}

	private void initLoanType() {

		LoanTypeModel loanTypeModel = new LoanTypeModel();
		DefaultComboBoxModel<LoanType> model = new DefaultComboBoxModel<>();
		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
			model.addElement(loanType);
		}
		cbbxLoanType.setModel(model);
		cbbxLoanType.setRenderer(new LoanListCellRenderer());

	}

	private class DurationListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			int item = (int) value;
			return super.getListCellRendererComponent(list, item + " Month", index, isSelected, cellHasFocus);
		}
	}

	private class PeriodListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			int item = (int) value;
			return super.getListCellRendererComponent(list, item + " Month", index, isSelected, cellHasFocus);
		}
	}

	private class PaymentListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			PaymentType item = (PaymentType) value;
			return super.getListCellRendererComponent(list, item.getName(), index, isSelected, cellHasFocus);
		}
	}

	private class LoanListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			LoanType item = (LoanType) value;
			return super.getListCellRendererComponent(list, item.getName(), index, isSelected, cellHasFocus);
		}
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

	protected void cancelAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}

}
