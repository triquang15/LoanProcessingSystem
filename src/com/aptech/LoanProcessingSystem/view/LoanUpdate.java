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
import java.util.concurrent.TimeUnit;

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
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.Box;

public class LoanUpdate extends JDialog {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	ButtonGroup bg;
	public String user;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private JDateChooser txtUpdateDate;
	private JTextArea txtDescription;
	private JLabel txtVali1;
	private JLabel txtValid3;
	private JTextField txtHistoryId;
	private JButton btnCheck;
	private JLabel textAmountLeft;
	private JLabel textFineOverDay;
	private JLabel textFineAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				LoanUpdate dialog = new LoanUpdate();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LoanUpdate(String username) {
		this();
		this.user = username;
	}

	/**
	 * Create the dialog.
	 */
	public LoanUpdate() {
		setMinimumSize(new Dimension(1100, 550));
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
		setTitle("Loan Payment");
		setBounds(100, 100, 1079, 476);
		getContentPane().setLayout(new BorderLayout(0, 0));
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(30, 20, 50, 20));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		contentPanel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
				JPanel panel = new JPanel();
				panel_1.add(panel);
				panel.setBackground(Color.LIGHT_GRAY);
				panel.setLayout(null);
				
						txtVali1 = new JLabel("");
						txtVali1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
						txtVali1.setForeground(Color.RED);
						txtVali1.setBounds(133, 59, 306, 14);
						panel.add(txtVali1);
						
						JPanel panel_2 = new JPanel();
						panel_2.setBackground(Color.LIGHT_GRAY);
						panel_2.setBounds(36, 22, 409, 27);
						panel.add(panel_2);
						panel_2.setLayout(new BorderLayout(0, 0));
						
								txtHistoryId = new JTextField();
								panel_2.add(txtHistoryId, BorderLayout.CENTER);
								txtHistoryId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
								txtHistoryId.setColumns(10);
								
										JLabel lblNewLabel_1_4 = new JLabel("History ID*");
										lblNewLabel_1_4.setBorder(null);
										lblNewLabel_1_4.setBackground(Color.LIGHT_GRAY);
										lblNewLabel_1_4.setPreferredSize(new Dimension(100, 0));
										lblNewLabel_1_4.setAlignmentX(10.0f);
										panel_2.add(lblNewLabel_1_4, BorderLayout.WEST);
										
										JPanel panel_2_1 = new JPanel();
										panel_2_1.setBackground(Color.LIGHT_GRAY);
										panel_2_1.setBounds(36, 70, 409, 27);
										panel.add(panel_2_1);
										panel_2_1.setLayout(new BorderLayout(0, 0));
										
												txtAmount = new JTextField();
												panel_2_1.add(txtAmount, BorderLayout.CENTER);
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
														
																JLabel lblNewLabel_1 = new JLabel("Amount *");
																lblNewLabel_1.setPreferredSize(new Dimension(100, 0));
																lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
																panel_2_1.add(lblNewLabel_1, BorderLayout.WEST);
																
																JPanel panel_2_1_1 = new JPanel();
																panel_2_1_1.setBackground(Color.LIGHT_GRAY);
																panel_2_1_1.setBounds(36, 119, 409, 27);
																panel.add(panel_2_1_1);
																panel_2_1_1.setLayout(new BorderLayout(0, 0));
																
																		JLabel lblNewLabel_1_2 = new JLabel("Update Date *");
																		panel_2_1_1.add(lblNewLabel_1_2, BorderLayout.WEST);
																		lblNewLabel_1_2.setPreferredSize(new Dimension(100, 0));
																		lblNewLabel_1_2.setBackground(Color.LIGHT_GRAY);
																		
																				txtUpdateDate = new JDateChooser();
																				panel_2_1_1.add(txtUpdateDate, BorderLayout.CENTER);
																				txtUpdateDate.getCalendarButton().setBackground(new Color(255, 255, 255));
																						
																						Component horizontalStrut = Box.createHorizontalStrut(20);
																						panel_1.add(horizontalStrut);
																				
																						{
																							JPanel panel_1_1 = new JPanel();
																							panel_1.add(panel_1_1);
																							panel_1_1.setLayout(null);
																							panel_1_1.setBackground(Color.LIGHT_GRAY);
																				
																							txtValid3 = new JLabel("");
																							txtValid3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
																							txtValid3.setForeground(Color.RED);
																							txtValid3.setBounds(146, 145, 306, 14);
																							panel_1_1.add(txtValid3);
																							
																							JPanel panel_2_1_2 = new JPanel();
																							panel_2_1_2.setBackground(Color.LIGHT_GRAY);
																							panel_2_1_2.setBounds(36, 23, 409, 27);
																							panel_1_1.add(panel_2_1_2);
																							panel_2_1_2.setLayout(new BorderLayout(0, 0));
																							
																										textAmountLeft = new JLabel("");
																										panel_2_1_2.add(textAmountLeft, BorderLayout.CENTER);
																										
																													JLabel lblNewLabel_3 = new JLabel("Amount Left *");
																													lblNewLabel_3.setPreferredSize(new Dimension(100, 0));
																													lblNewLabel_3.setBackground(Color.LIGHT_GRAY);
																													panel_2_1_2.add(lblNewLabel_3, BorderLayout.WEST);
																													
																													JPanel panel_2_1_3 = new JPanel();
																													panel_2_1_3.setBackground(Color.LIGHT_GRAY);
																													panel_2_1_3.setBounds(36, 71, 409, 27);
																													panel_1_1.add(panel_2_1_3);
																													panel_2_1_3.setLayout(new BorderLayout(0, 0));
																													
																																textFineOverDay = new JLabel("");
																																panel_2_1_3.add(textFineOverDay, BorderLayout.CENTER);
																																
																																			JLabel lblNewLabel_2 = new JLabel("FineOverDay *");
																																			lblNewLabel_2.setPreferredSize(new Dimension(100, 0));
																																			lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
																																			panel_2_1_3.add(lblNewLabel_2, BorderLayout.WEST);
																																			
																																			JPanel panel_2_1_4 = new JPanel();
																																			panel_2_1_4.setBackground(Color.LIGHT_GRAY);
																																			panel_2_1_4.setBounds(36, 119, 409, 27);
																																			panel_1_1.add(panel_2_1_4);
																																			panel_2_1_4.setLayout(new BorderLayout(0, 0));
																																			
																																						textFineAmount = new JLabel("");
																																						panel_2_1_4.add(textFineAmount, BorderLayout.CENTER);
																																						
																																									JLabel lblNewLabel_4 = new JLabel("Fine Amount *");
																																									lblNewLabel_4.setPreferredSize(new Dimension(100, 0));
																																									lblNewLabel_4.setBackground(Color.LIGHT_GRAY);
																																									panel_2_1_4.add(lblNewLabel_4, BorderLayout.WEST);
																																									
																																									JPanel panel_2_1_4_1 = new JPanel();
																																									panel_2_1_4_1.setBackground(Color.LIGHT_GRAY);
																																									panel_2_1_4_1.setBounds(36, 165, 409, 75);
																																									panel_1_1.add(panel_2_1_4_1);
																																									panel_2_1_4_1.setLayout(new BorderLayout(0, 0));
																																									
																																												txtDescription = new JTextArea();
																																												txtDescription.setPreferredSize(new Dimension(5, 200));
																																												panel_2_1_4_1.add(txtDescription, BorderLayout.CENTER);
																																												
																																															JLabel lblNewLabel_6 = new JLabel("Description *");
																																															lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
																																															lblNewLabel_6.setPreferredSize(new Dimension(100, 13));
																																															panel_2_1_4_1.add(lblNewLabel_6, BorderLayout.WEST);
																						}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			FlowLayout fl_buttonPane = new FlowLayout(FlowLayout.CENTER);
			fl_buttonPane.setVgap(20);
			fl_buttonPane.setHgap(20);
			buttonPane.setLayout(fl_buttonPane);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				JButton btnCancel = new JButton("Cancel");
				btnCancel.setPreferredSize(new Dimension(120, 30));
				btnCancel.setIcon(new ImageIcon(
						CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						LoanUpdate.this.dispose();
					}
				});
							
										JButton btnSave = new JButton("Save");
										btnSave.setPreferredSize(new Dimension(120, 30));
										buttonPane.add(btnSave);
										btnSave.setFont(new Font("Tahoma", Font.BOLD, 10));
										btnSave.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												Integer history_id = Integer.parseInt(txtHistoryId.getText());
												LoanAndFineHistory loanAndFineHistory = new LoanAndFineHistory();
												LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
												loanAndFineHistory = loanAndFineHistoryModel.search_history_based_on_id(history_id);
												if (Objects.isNull(loanAndFineHistory)) {
													JOptionPane.showMessageDialog(null, "No Id");
												} else {
													String amount = txtAmount.getText();
													Double amount_double = Double.parseDouble(amount);
													String description = txtDescription.getText();
													Double amount_left = loanAndFineHistory.getAmount() - amount_double;
													Date update_date = txtUpdateDate.getDate();
													long difference_In_Time = update_date.getTime() - loanAndFineHistory.getDueDate().getTime();
													long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
													Double fine_amount = loanAndFineHistory.getFineInterest() * loanAndFineHistory.getAmount();
													// Apply the validation logic checking all controls are empty or not
													if (txtAmount.getText().trim().equals("") || txtUpdateDate.getDate() == null
															|| txtHistoryId.getText().trim().equals("")) {
														JOptionPane.showMessageDialog(null, "Please enter full information !!!");
													} else {

														try {
															com.aptech.LoanProcessingSystem.entities.LoanAndFineHistory loanAndFineHistory_update = new LoanAndFineHistory();
															Date today = new Date();
															loanAndFineHistory_update.setId(history_id);
															loanAndFineHistory_update.setPaymentDate(today);
															loanAndFineHistory_update.setPaymentAmount(amount_double);
															loanAndFineHistory_update.setDescription(description);
															loanAndFineHistory_update.setAmountLeft(amount_left);
															if (difference_In_Days > 0) {
																loanAndFineHistory_update.setFineAmount(fine_amount);
																loanAndFineHistory_update.setFineOverDays((int) difference_In_Days);
															} else {
																loanAndFineHistory_update.setFineAmount(0);
																loanAndFineHistory_update.setFineOverDays(0);
															}

															try {
																loanAndFineHistoryModel.update_payment(loanAndFineHistory_update);
																JOptionPane.showMessageDialog(null, "Successful!");
															} catch (Exception a) {
																JOptionPane.showMessageDialog(null, "Please try again!");
																a.printStackTrace();
															}
															LoanUpdate.this.dispose();

														} catch (Exception e2) {
															// TODO: handle exception
															e2.printStackTrace();
														}

													}
												}

											}
										});
										btnSave.setIcon(new ImageIcon(
												CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/floppy-disk.png")));
							
										btnCheck = new JButton("Check");
										btnCheck.setIcon(new ImageIcon(LoanUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_review_20.png")));
										btnCheck.setPreferredSize(new Dimension(120, 30));
										buttonPane.add(btnCheck);
										btnCheck.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												jbuttoncheck_actionPerformed(e);
											}
										});
										btnCheck.setFont(new Font("Tahoma", Font.BOLD, 10));
				
							JButton btnClear = new JButton("Clear");
							btnClear.setPreferredSize(new Dimension(120, 30));
							buttonPane.add(btnClear);
							btnClear.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									txtHistoryId.setText("");
									txtAmount.setText("");
									txtDescription.setText("");
									txtUpdateDate.setDate(null);
									textAmountLeft.setText("");
									textFineOverDay.setText("");
									textFineAmount.setText("");
									bg.clearSelection();

								}
							});
							btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
							btnClear.setIcon(new ImageIcon(LoanUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));
				btnCancel.setBackground(Color.GRAY);
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		
		JLabel lblNewLabel = new JLabel("Loan Payment");
		lblNewLabel.setIcon(new ImageIcon(LoanUpdate.class.getResource("/com/aptech/LoanProcessingSystem/images/loan (2).png")));
		lblNewLabel.setBackground(new Color(105, 105, 105));
		lblNewLabel.setPreferredSize(new Dimension(64, 50));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
	}

	public void jbuttoncheck_actionPerformed(ActionEvent e) {
		Integer history_id = Integer.parseInt(txtHistoryId.getText());
		LoanAndFineHistoryModel loanAndFineHistoryModel = new LoanAndFineHistoryModel();
		LoanAndFineHistory loanAndFineHistory = loanAndFineHistoryModel.search_history_based_on_id(history_id);
		if (Objects.isNull(loanAndFineHistory)) {
			JOptionPane.showMessageDialog(null, "No Id");
		} else {
			if (txtAmount.getText().trim().equals("") || txtUpdateDate.getDate() == null
					|| txtHistoryId.getText().trim().equals("")

			) {
				JOptionPane.showMessageDialog(null, "Please enter full information !!!");
			} else {
				String amount = txtAmount.getText();
				Double amount_double = Double.parseDouble(amount);
				String amount_left = String.valueOf(loanAndFineHistory.getAmount() - amount_double);
				Date update_date = txtUpdateDate.getDate();
				long difference_In_Time = update_date.getTime() - loanAndFineHistory.getDueDate().getTime();
				long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time) % 365;
				String fine_amount = String
						.valueOf(loanAndFineHistory.getFineInterest() * loanAndFineHistory.getAmount());

				if (difference_In_Days > 0) {
					textFineAmount.setText(fine_amount);
					textFineOverDay.setText(String.valueOf(difference_In_Days));
				} else {
					textFineAmount.setText("0");
					textFineOverDay.setText("0");
				}

				textAmountLeft.setText(amount_left);
			}

		}

	}
	

	private void cancelAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
}
