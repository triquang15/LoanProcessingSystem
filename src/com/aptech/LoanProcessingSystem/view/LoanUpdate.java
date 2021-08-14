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
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close Application ?", "Confirm",
						JOptionPane.YES_NO_OPTION) == 0) {
					System.exit(0);
				}
			}
		});
		bg = new ButtonGroup();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Loan Payment");
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

		JLabel lblNewLabel_1_2 = new JLabel("Update Date *");
		lblNewLabel_1_2.setBounds(26, 147, 97, 14);
		panel.add(lblNewLabel_1_2);

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

		txtUpdateDate = new JDateChooser();
		txtUpdateDate.setBounds(133, 141, 306, 20);
		panel.add(txtUpdateDate);

		txtVali1 = new JLabel("");
		txtVali1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		txtVali1.setForeground(Color.RED);
		txtVali1.setBounds(133, 59, 306, 14);
		panel.add(txtVali1);

		JLabel lblNewLabel_1_4 = new JLabel("History ID*");
		lblNewLabel_1_4.setBounds(26, 17, 94, 14);
		panel.add(lblNewLabel_1_4);

		txtHistoryId = new JTextField();
		txtHistoryId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 10));
		txtHistoryId.setColumns(10);
		txtHistoryId.setBounds(129, 15, 306, 20);
		panel.add(txtHistoryId);

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

					LoanDetail loanDetail = new LoanDetail();
					loanDetail.setVisible(true);
					LoanUpdate.this.dispose();

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
			btnSave.setBounds(475, 22, 89, 23);
			panel_1.add(btnSave);

			JButton btnClear = new JButton("Clear");
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

			JLabel lblNewLabel_2 = new JLabel("FineOverDay *");
			lblNewLabel_2.setBounds(36, 56, 79, 14);
			panel_1.add(lblNewLabel_2);

			JLabel lblNewLabel_4 = new JLabel("Fine Amount *");
			lblNewLabel_4.setBounds(32, 87, 83, 14);
			panel_1.add(lblNewLabel_4);

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

			JLabel lblNewLabel_3 = new JLabel("Amount Left *");
			lblNewLabel_3.setBounds(34, 21, 84, 14);
			panel_1.add(lblNewLabel_3);

			textAmountLeft = new JLabel("");
			textAmountLeft.setBounds(142, 21, 307, 14);
			panel_1.add(textAmountLeft);

			textFineOverDay = new JLabel("");
			textFineOverDay.setBounds(143, 56, 307, 14);
			panel_1.add(textFineOverDay);

			textFineAmount = new JLabel("");
			textFineAmount.setBounds(141, 88, 307, 14);
			panel_1.add(textFineAmount);
		}

		JLabel lblNewLabel = new JLabel("Loan Payment");
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

						LoanUpdate.this.dispose();
					}
				});
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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
}
