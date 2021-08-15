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

public class CreateLoan extends JDialog {
	private ButtonGroup bg;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private JTextField txtPeriod;
	private JDateChooser txtEndDate;
	private JDateChooser txtDisbursement;
	private JTextArea txtDescription;
	private JComboBox<Integer> txtDuration_1;
	private JLabel txtVali1;
	private JLabel txtValid3;
	private JTextField txtCustomerName;
	private JComboBox txtPaymentType;
	private JComboBox txtLoanType;
	private JLabel textInterest;
	private String hintAmount = "Please enter amount";
	private String hintPeriod = "Please enter period";
	private Customer customer;

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

		JLabel lblNewLabel_1 = new JLabel("Amount *");
		lblNewLabel_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1.setMaximumSize(new Dimension(100, 30));
		panel_3.add(lblNewLabel_1);

		Component verticalStrut_5_3 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5_3);

		JLabel lblNewLabel_1_1 = new JLabel("Period *");
		lblNewLabel_1_1.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_1.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_1.setMaximumSize(new Dimension(100, 30));
		panel_3.add(lblNewLabel_1_1);

		Component verticalStrut_5_1 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5_1);

		JLabel lblNewLabel_1_5 = new JLabel("Loan Type *");
		lblNewLabel_1_5.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_5.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_5.setMaximumSize(new Dimension(100, 30));
		panel_3.add(lblNewLabel_1_5);

		Component verticalStrut_5 = Box.createVerticalStrut(20);
		panel_3.add(verticalStrut_5);

		JLabel lblNewLabel_1_3 = new JLabel("Disbursement  *");
		lblNewLabel_1_3.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_1_3.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_1_3.setMaximumSize(new Dimension(100, 30));
		panel_3.add(lblNewLabel_1_3);

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

		txtAmount = new JTextField();
		txtAmount.setMaximumSize(new Dimension(1000, 30));
		txtAmount.setMinimumSize(new Dimension(300, 30));
		txtAmount.setPreferredSize(new Dimension(0, 30));
		panel_2.add(txtAmount);
		txtAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {

				try {
					int i = Integer.parseInt(txtAmount.getText());
					txtVali1.setText("");

				} catch (Exception e1) {
					// TODO: handle exception
					txtVali1.setText("Invalid number");

				}

			}
		});

		txtAmount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtAmount.setColumns(10);

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_3);

		txtPeriod = new JTextField();
		txtPeriod.setMaximumSize(new Dimension(1000, 30));
		txtPeriod.setMinimumSize(new Dimension(300, 30));
		txtPeriod.setPreferredSize(new Dimension(0, 30));
		panel_2.add(txtPeriod);

		txtPeriod.setColumns(10);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut_1);

		txtLoanType = new JComboBox();
		txtLoanType.setPreferredSize(new Dimension(29, 30));
		txtLoanType.setMinimumSize(new Dimension(29, 30));
		txtLoanType.setMaximumSize(new Dimension(32767, 30));
		panel_2.add(txtLoanType);

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_2.add(verticalStrut);

		JPanel panel_8 = new JPanel();
		panel_8.setMaximumSize(new Dimension(1000, 30));
		panel_8.setMinimumSize(new Dimension(200, 30));
		panel_8.setPreferredSize(new Dimension(0, 30));
		panel_2.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));

		txtDisbursement = new JDateChooser();
		panel_8.add(txtDisbursement);

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

		JLabel lblNewLabel_3 = new JLabel("Payment Type *");
		lblNewLabel_3.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_3.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_3.setMaximumSize(new Dimension(100, 30));
		panel_5.add(lblNewLabel_3);

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

		JLabel lblNewLabel_5 = new JLabel("Interest *");
		lblNewLabel_5.setPreferredSize(new Dimension(100, 30));
		lblNewLabel_5.setMinimumSize(new Dimension(100, 30));
		lblNewLabel_5.setMaximumSize(new Dimension(100, 30));
		panel_5.add(lblNewLabel_5);

		Component verticalStrut_11 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_11);

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

		txtPaymentType = new JComboBox();
		txtPaymentType.setMaximumSize(new Dimension(1000, 30));
		txtPaymentType.setMinimumSize(new Dimension(200, 30));
		txtPaymentType.setPreferredSize(new Dimension(0, 30));
		panel_4.add(txtPaymentType);

		Component verticalStrut_10 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_10);

		txtDuration_1 = new JComboBox();
		txtDuration_1.setPreferredSize(new Dimension(29, 30));
		txtDuration_1.setMinimumSize(new Dimension(29, 30));
		txtDuration_1.setMaximumSize(new Dimension(32767, 30));
		panel_4.add(txtDuration_1);

		Component verticalStrut_8 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_8);

		JPanel panel_6 = new JPanel();
		panel_6.setMaximumSize(new Dimension(1000, 30));
		panel_6.setMinimumSize(new Dimension(200, 30));
		panel_6.setPreferredSize(new Dimension(0, 30));
		panel_4.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		txtEndDate = new JDateChooser();
		panel_6.add(txtEndDate);

		Component verticalStrut_13 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_13);

		JPanel panel_9 = new JPanel();
		panel_9.setPreferredSize(new Dimension(10, 30));
		panel_9.setMinimumSize(new Dimension(10, 30));
		panel_9.setMaximumSize(new Dimension(32767, 30));
		panel_4.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.X_AXIS));

		textInterest = new JLabel("");
		textInterest.setEnabled(false);
		textInterest.setMinimumSize(new Dimension(300, 30));
		textInterest.setMaximumSize(new Dimension(1000, 30));
		textInterest.setPreferredSize(new Dimension(0, 30));
		panel_9.add(textInterest);

		Component verticalStrut_6 = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut_6);

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

		txtValid3 = new JLabel("");
		buttonPane.add(txtValid3);
		txtValid3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		txtValid3.setForeground(Color.RED);

		txtVali1 = new JLabel("");
		buttonPane.add(txtVali1);
		txtVali1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		txtVali1.setForeground(Color.RED);

		JButton btnSave = new JButton("Save");
		btnSave.setPreferredSize(new Dimension(120, 30));
		buttonPane.add(btnSave);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createAction();
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
		initForm();
		setTextHint(txtAmount, hintAmount);
		setTextHint(txtPeriod, hintPeriod);

	}

	private void initData(int customerId) {
		customer = new CustomerModel().findById(customerId);
		txtCustomerName.setText(customer.getName());
	}

	protected void createAction() {
		Double amountDouble;
		try {
			amountDouble = Double.parseDouble(txtAmount.getText().trim());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Amount invalid!");
			return;
		}

		LoanType loanType = (LoanType) txtLoanType.getSelectedItem();
		PaymentType paymentType = (PaymentType) txtPaymentType.getSelectedItem();
		String period = txtPeriod.getText();
		String description = txtDescription.getText();
		String customer_id = txtCustomerName.getText();
		int duration = (int) txtDuration_1.getSelectedItem();
		Date disbursement = txtDisbursement.getDate();
		Date endDate = txtEndDate.getDate();

		double installment = amountDouble * Math.pow(1 + loanType.getInterest(), duration / 12) / duration;
		FineModel fineModel = new FineModel();
		Fine fine = new Fine();
		fine = fineModel.find_fine_interest(installment);
		int fine_id = fine.getId();
		double fine_interest = fine.getFineInterest();
		double fine_amount = installment * fine_interest;

//			if ((installment > 1) && (installment <= 5000)) {
//				fine_interest = 0.02;
//				fine_id = 1;
//				fine_amount = installment * fine_interest;
//			} else if ((installment > 5001) && (installment <= 20000)) {
//				fine_interest = 0.05;
//				fine_id = 2;
//				fine_amount = installment * fine_interest;
//			} else {
//				fine_interest = 0.08;
//				fine_id = 3;
//				fine_amount = installment * fine_interest;
//			}

		// Apply the validation logic checking all controls are empty or not
		if (period.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Please enter full information !!!");
		} else if (disbursement == null & endDate == null) {
			JOptionPane.showMessageDialog(null, "Please select Disbursement");
			txtDisbursement.grabFocus();

			JOptionPane.showMessageDialog(null, "Please select End Date");
			txtEndDate.grabFocus();

		} else {

			try {

				Loan loan = new Loan();
				loan.setAmount(Double.parseDouble(txtAmount.getText()));
				loan.setDescription(txtDescription.getText());
				loan.setInterest(loanType.getInterest());
				loan.setPeriod(Integer.parseInt(txtPeriod.getText()));
				loan.setCustomerId(Integer.parseInt(txtCustomerName.getText()));
				loan.setPaymentTypeId(paymentType.getId());
				loan.setLoanTypeId(loanType.getId());
				loan.setStatus(0);
				loan.setDuration(duration);
				loan.setCreateDate(new Date());
				loan.setDisbursementDate(txtDisbursement.getDate());
				loan.setEndDate(txtEndDate.getDate());

				LoanModel loanModel = new LoanModel();

				LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
				LoanModel lastIdLoanModel = new LoanModel();
				Loan last_loan_row = lastIdLoanModel.find_last_id_with_amount();

				loanAndFineHistory.setLoanId(last_loan_row.getId() + 1);
				loanAndFineHistory.setFineId(fine_id);
				loanAndFineHistory.setFineInterest(fine_interest);

				Date today = new Date();
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(today);
				loanAndFineHistory.setPaymentDate(today);
				loanAndFineHistory.setAmount(installment);
				loanAndFineHistory.setPaymentAmount(0);
				loanAndFineHistory.setDescription(txtDescription.getText());
				loanAndFineHistory.setStatus(false);
				loanAndFineHistory.setPaymentMethodId(1);
				loanAndFineHistory.setAmountLeft(installment);
				loanAndFineHistory.setFineAmount(0);
				loanAndFineHistory.setFineOverDays(0);
				LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
				try {
					loanModel.create(loan);
					for (int i = 1; i <= duration; i++) {
						calendar.add(calendar.MONTH, 1);
						loanAndFineHistory.setDueDate(calendar.getTime());
						loanAndFineHistoryModel.createLoanAndFineHistory(loanAndFineHistory);
					}
					JOptionPane.showMessageDialog(null, "Successful!");
				} catch (Exception a) {
					JOptionPane.showMessageDialog(null, "Please try again!");
					a.printStackTrace();
				}
				this.dispose();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	private void initForm() {
		txtAmount.setText(hintAmount);
		txtAmount.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtAmount.setForeground(Color.GRAY);
		txtPeriod.setText(hintPeriod);
		txtPeriod.setFont(new Font("Tahoma", Font.ITALIC, 10));
		txtPeriod.setForeground(Color.GRAY);
		initDurationValue();
		initPaymentValue();
		initLoanType();
	}

	private void initDurationValue() {

		int[] durations = new int[] { 6, 12, 18, 24, 36, 48, 72 };
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
		for (int dur : durations) {
			model.addElement(dur);
		}
		txtDuration_1.setModel(model);
		txtDuration_1.setRenderer(new DurationListCellRenderer());

	}

	private void initPaymentValue() {

		PaymentTypeModel paymentTypeModel = new PaymentTypeModel();
		DefaultComboBoxModel<PaymentType> model = new DefaultComboBoxModel<>();
		for (com.aptech.LoanProcessingSystem.entities.PaymentType paymentType : paymentTypeModel.getAllPaymentTypes()) {
			model.addElement(paymentType);
		}
		txtPaymentType.setModel(model);
		txtPaymentType.setRenderer(new PaymentListCellRenderer());

	}

	private void initLoanType() {

		LoanTypeModel loanTypeModel = new LoanTypeModel();
		DefaultComboBoxModel<LoanType> model = new DefaultComboBoxModel<>();
		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
			model.addElement(loanType);
		}
		txtLoanType.setModel(model);
		txtLoanType.setRenderer(new LoanListCellRenderer());

	}

	private class DurationListCellRenderer extends DefaultListCellRenderer {

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
