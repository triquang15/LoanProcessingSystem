package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Fine;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.FineModel;
import com.aptech.LoanProcessingSystem.model.LoanAndFineHistoryModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateLoan extends JDialog {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	ButtonGroup bg;
	public String user;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private JTextField txtPeriod;
	private JDateChooser txtEndDate;
	private JDateChooser txtCreateDate;
	private JDateChooser txtDisbursement;
	private JTextArea txtDescription;
	private JComboBox txtDuration_1;
	private JLabel txtVali1;
	private JLabel txtValid3;
	private JTextField txtCustomerId;
	private JComboBox txtPaymentType;
	private JComboBox txtLoanType;
	private JButton btnCheck;
	private JLabel textInterest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			CreateLoan dialog = new CreateLoan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public CreateLoan(String username) {
		this();
		this.user = username;
	}

	/**
	 * Create the dialog.
	 */
	public CreateLoan() {
		bg = new ButtonGroup();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Add Loan");
		setBounds(100, 100, 1054, 547);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(21, 76, 485, 268);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Amount *");
		lblNewLabel_1.setBounds(23, 55, 97, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Period *");
		lblNewLabel_1_1.setBounds(23, 91, 97, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Create Date *");
		lblNewLabel_1_2.setBounds(26, 147, 97, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Disbursement  *");
		lblNewLabel_1_3.setBounds(28, 223, 97, 14);
		panel.add(lblNewLabel_1_3);

		txtAmount = new JTextField();
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
		txtAmount.setBounds(130, 51, 306, 20);
		panel.add(txtAmount);
		txtAmount.setColumns(10);

		txtPeriod = new JTextField();
		
		txtPeriod.setColumns(10);
		txtPeriod.setBounds(130, 87, 306, 20);
		panel.add(txtPeriod);

		txtCreateDate = new JDateChooser();
		txtCreateDate.setBounds(133, 141, 306, 20);
		panel.add(txtCreateDate);

		txtDisbursement = new JDateChooser();
		txtDisbursement.setBounds(133, 220, 306, 20);
		panel.add(txtDisbursement);
		
		txtVali1 = new JLabel("");
		txtVali1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		txtVali1.setForeground(Color.RED);
		txtVali1.setBounds(133, 59, 306, 14);
		panel.add(txtVali1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Customer ID*");
		lblNewLabel_1_4.setBounds(26, 17, 94, 14);
		panel.add(lblNewLabel_1_4);
		
		txtCustomerId = new JTextField();
		txtCustomerId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtCustomerId.setColumns(10);
		txtCustomerId.setBounds(129, 15, 306, 20);
		panel.add(txtCustomerId);
		
		JLabel lblNewLabel_1_5 = new JLabel("Loan Type *");
		lblNewLabel_1_5.setBounds(27, 192, 74, 14);
		panel.add(lblNewLabel_1_5);
		
		txtLoanType = new JComboBox();
		txtLoanType.setBounds(130, 188, 306, 22);
		panel.add(txtLoanType);
		initLoanType();
		String loan_type_name = (String) txtLoanType.getSelectedItem();
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		LoanType loan_type_interest = loanTypeModel.loadLoanType(loan_type_name);
		
		

		{
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(21, 381, 1000, 68);
			contentPanel.add(panel_1);
			panel_1.setLayout(null);

			JButton btnNewButton = new JButton("Back");
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Home home = new Home();
					home.setVisible(true);
					CreateLoan.this.dispose();

				}
			});
			btnNewButton.setIcon(
					new ImageIcon(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/back.png")));
			btnNewButton.setBounds(220, 22, 89, 23);
			panel_1.add(btnNewButton);

			JButton btnSave = new JButton("Save");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String amount = txtAmount.getText();
					Double amount_double = Double.parseDouble(amount);
					String address = txtPeriod.getText();
					String description = txtDescription.getText();
					String customer_id = txtCustomerId.getText();
					int duration = (int) txtDuration_1.getSelectedItem();
					String loan_type_s = (String) txtLoanType.getSelectedItem();
					int loan_type_int;
					Date createDate = txtCreateDate.getDate();
					Date disbursement = txtDisbursement.getDate();
					Date endDate = txtEndDate.getDate();
					boolean status = false;

					
					if (loan_type_s.trim().equals("Home Loan")) {
						loan_type_int = 1;
					} else if (loan_type_s.trim().equals("Vehicle Loan")){
						loan_type_int = 2;
					} else if (loan_type_s.trim().equals("Personal Loan")){
						loan_type_int = 3;
					} else {
						loan_type_int = 4;
					}
					
					double installment = amount_double * Math.pow(1 + loan_type_interest.getInterest(), duration/12) / duration;
					FineModel fineModel = new FineModel();
					Fine fine = new Fine();
					fine = fineModel.find_fine_interest(installment);
					int fine_id = fine.getId();
					double fine_interest = fine.getFineInterest();
					double fine_amount = installment * fine_interest;

//					if ((installment > 1) && (installment <= 5000)) {
//						fine_interest = 0.02;
//						fine_id = 1;
//						fine_amount = installment * fine_interest;
//					} else if ((installment > 5001) && (installment <= 20000)) {
//						fine_interest = 0.05;
//						fine_id = 2;
//						fine_amount = installment * fine_interest;
//					} else {
//						fine_interest = 0.08;
//						fine_id = 3;
//						fine_amount = installment * fine_interest;
//					}
					// Apply the validation logic checking all controls are empty or not
					if (amount.trim().equals("") || amount.trim().equals("Please enter your amount")
							|| address.trim().equals("") || address.trim().equals("Please enter your address")
							|| description.trim().equals("")
							|| description.trim().equals("Please enter your description") || customer_id.trim().equals("")

					) {
						JOptionPane.showMessageDialog(null, "Please enter full information !!!");
					} else if (createDate == null & disbursement == null & endDate == null) {
						JOptionPane.showMessageDialog(null, "Please select Create Date");
						txtCreateDate.grabFocus();

						JOptionPane.showMessageDialog(null, "Please select Disbursement");
						txtDisbursement.grabFocus();

						JOptionPane.showMessageDialog(null, "Please select End Date");
						txtEndDate.grabFocus();

					} else {

						try {

							com.aptech.LoanProcessingSystem.entities.Loan loan = new Loan();
							loan.setAmount(Double.parseDouble(txtAmount.getText()));
							loan.setDescription(txtDescription.getText());
							loan.setInterest(loan_type_interest.getInterest());
							loan.setPeriod(Integer.parseInt(txtPeriod.getText()));
							loan.setCustomerId(Integer.parseInt(txtCustomerId.getText()));
							loan.setPaymentTypeId(1);
							loan.setLoanTypeId(loan_type_int);
							loan.setStatus(status);
							loan.setDuration(duration);
							loan.setCreateDate(txtCreateDate.getDate());
							loan.setDisbursementDate(txtDisbursement.getDate());
							loan.setEndDate(txtEndDate.getDate());
							
							LoanModel loanModel = new LoanModel();

//							CreateLoan.this.dispose();
							
//							if (loanModel.create(loan)) {
//								JOptionPane.showMessageDialog(null, "Successful!");
//
//								CreateLoan.this.dispose();
//							} else {
//								JOptionPane.showMessageDialog(null, "Please try again!");
//							}
							
							com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
							LoanModel lastIdLoanModel = new LoanModel();							
							com.aptech.LoanProcessingSystem.entities.Loan last_loan_row = lastIdLoanModel.find_last_id_with_amount();
							loanAndFineHistory.setLoanId(last_loan_row.getId()+1);
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
							CreateLoan.this.dispose();
		
			
							
						} catch (Exception e2) {
							// TODO: handle exception
							e2.printStackTrace();
						}	

					}

				}
			});
			btnSave.setIcon(new ImageIcon(
					CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/floppy-disk.png")));
			btnSave.setBounds(475, 22, 89, 23);
			panel_1.add(btnSave);

			JButton btnClear = new JButton("Clear");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtCustomerId.setText("");
					txtAmount.setText("");
					txtPeriod.setText("");
					txtDescription.setText("");
					txtDuration_1.setSelectedItem(null);
					txtLoanType.setSelectedItem(null);
					txtCreateDate.setDate(null);
					txtDisbursement.setDate(null);
					txtEndDate.setDate(null);
					txtPaymentType.setSelectedItem(null);
					bg.clearSelection();

				}
			});
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnClear.setIcon(new ImageIcon(
					CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/arrows-circle.png")));
			btnClear.setBounds(733, 22, 95, 23);
			panel_1.add(btnClear);
			
			btnCheck = new JButton("Check");
			btnCheck.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jbuttoncheck_actionPerformed(e);
				}
			});
			btnCheck.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnCheck.setBounds(356, 22, 89, 23);
			panel_1.add(btnCheck);
		}

		{
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(526, 76, 491, 268);
			contentPanel.add(panel_1);

			JLabel lblNewLabel_2 = new JLabel("Duration *");
			lblNewLabel_2.setBounds(36, 56, 62, 14);
			panel_1.add(lblNewLabel_2);

			JLabel lblNewLabel_4 = new JLabel("End Date *");
			lblNewLabel_4.setBounds(32, 87, 83, 14);
			panel_1.add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel("Interest *");
			lblNewLabel_5.setBounds(36, 117, 99, 14);
			panel_1.add(lblNewLabel_5);

			txtDuration_1 = new JComboBox();
			txtDuration_1.setBounds(146, 52, 306, 22);
			panel_1.add(txtDuration_1);
			initDurationValue();
			txtEndDate = new JDateChooser();
			txtEndDate.setBounds(144, 84, 306, 20);
			panel_1.add(txtEndDate);

			JLabel lblNewLabel_6 = new JLabel("Description *");
			lblNewLabel_6.setBounds(36, 185, 83, 14);
			panel_1.add(lblNewLabel_6);

			txtDescription = new JTextArea();
			txtDescription.setBounds(146, 168, 306, 71);
			panel_1.add(txtDescription);
			
			txtValid3 = new JLabel("");
			txtValid3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
			txtValid3.setForeground(Color.RED);
			txtValid3.setBounds(146, 145, 306, 14);
			panel_1.add(txtValid3);
			
			JLabel lblNewLabel_3 = new JLabel("Payment Type *");
			lblNewLabel_3.setBounds(34, 21, 84, 14);
			panel_1.add(lblNewLabel_3);
			
			txtPaymentType = new JComboBox();
			txtPaymentType.setBounds(144, 17, 306, 22);
			panel_1.add(txtPaymentType);
			initPaymentValue();
			
			textInterest = new JLabel("");
			textInterest.setBounds(145, 117, 307, 14);
			panel_1.add(textInterest);
			if (Objects.isNull(loan_type_interest)) {
				textInterest.setText("Please choose payment type");
			} else {
				textInterest.setText(String.valueOf(loan_type_interest.getInterest()));
			}
		}

		JLabel lblNewLabel = new JLabel("New Loan");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setIcon(
				new ImageIcon(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/personal.png")));
		lblNewLabel.setBounds(388, 27, 238, 38);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				JButton cancelButton = new JButton("Close");
				cancelButton.setIcon(new ImageIcon(
						CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						CreateLoan.this.dispose();
					}
				});
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void jbuttoncheck_actionPerformed(ActionEvent e) {
		String loan_type_name = (String) txtLoanType.getSelectedItem();
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		LoanType loan_type_interest = loanTypeModel.loadLoanType(loan_type_name);
		if (Objects.isNull(loan_type_interest)) {
			textInterest.setText("Please choose payment type");
		} else {
			textInterest.setText(String.valueOf(loan_type_interest.getInterest()));
		}
	}

	private void initDurationValue() {

		int[] durations = new int[] { 6, 12, 18, 24, 36, 48, 72};
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
		for (int dur : durations) {
			model.addElement(dur);
		}
		txtDuration_1.setModel(model);
		txtDuration_1.setRenderer(new DurationListCellRenderer());

	}
	
	private void initPaymentValue() {

		PaymentTypeModel paymentTypeModel = new PaymentTypeModel();		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		for (com.aptech.LoanProcessingSystem.entities.PaymentType paymentType : paymentTypeModel.getAllPaymentTypes()) {
			model.addElement(paymentType.getName());
		}
		txtPaymentType.setModel(model);
		txtPaymentType.setRenderer(new PaymentListCellRenderer());

	}
	
	private void initLoanType() {

		LoanTypeModel loanTypeModel = new LoanTypeModel();		
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
		for (com.aptech.LoanProcessingSystem.entities.LoanType loanType : loanTypeModel.loadAllLoanType()) {
			model.addElement(loanType.getName());
		}
		txtLoanType.setModel(model);
		txtLoanType.setRenderer(new LoanListCellRenderer());

	}
	
	private class DurationListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			int item = (int) value;
			return super.getListCellRendererComponent(list, item +" Month", index, isSelected, cellHasFocus);
		}
	}
	
	private class PaymentListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			String item = (String) value;
			return super.getListCellRendererComponent(list, item, index, isSelected, cellHasFocus);
		}
	}
	
	private class LoanListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			String item = (String) value;
			return super.getListCellRendererComponent(list, item, index, isSelected, cellHasFocus);
		}
	}
}
