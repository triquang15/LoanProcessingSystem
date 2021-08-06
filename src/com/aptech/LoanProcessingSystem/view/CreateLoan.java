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

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateLoan extends JDialog {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	ButtonGroup bg;
	public String user;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private JTextField txtPeriod;
	private JTextField txtInterest;
	private JDateChooser txtEndDate;
	private JDateChooser txtCreateDate;
	private JDateChooser txtDisbursement;
	private JTextArea txtDescription;
	private JComboBox txtDuration;
	private JLabel txtVali1;
	private JLabel txtValid2;
	private JLabel txtValid3;

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
		lblNewLabel_1.setBounds(26, 31, 97, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Period *");
		lblNewLabel_1_1.setBounds(26, 87, 97, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Create Date *");
		lblNewLabel_1_2.setBounds(26, 147, 97, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Disbursement  *");
		lblNewLabel_1_3.setBounds(26, 205, 97, 14);
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
		txtAmount.setBounds(133, 28, 306, 20);
		panel.add(txtAmount);
		txtAmount.setColumns(10);

		txtPeriod = new JTextField();
		txtPeriod.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				try {
					int i = Integer.parseInt(txtPeriod.getText());
					txtValid2.setText("");
				
			} catch (Exception e1) {
				// TODO: handle exception
				txtValid2.setText("Invalid number");
				
			}
				
			}
		});
		
		txtPeriod.setColumns(10);
		txtPeriod.setBounds(133, 84, 306, 20);
		panel.add(txtPeriod);

		txtCreateDate = new JDateChooser();
		txtCreateDate.setBounds(133, 141, 306, 20);
		panel.add(txtCreateDate);

		txtDisbursement = new JDateChooser();
		txtDisbursement.setBounds(133, 199, 306, 20);
		panel.add(txtDisbursement);
		
		txtVali1 = new JLabel("");
		txtVali1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		txtVali1.setForeground(Color.RED);
		txtVali1.setBounds(133, 59, 306, 14);
		panel.add(txtVali1);
		
		txtValid2 = new JLabel("");
		txtValid2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		txtValid2.setForeground(Color.RED);
		txtValid2.setBounds(133, 115, 306, 14);
		panel.add(txtValid2);

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
					String address = txtPeriod.getText();
					String description = txtDescription.getText();

					Date createDate = txtCreateDate.getDate();
					Date disbursement = txtDisbursement.getDate();
					Date endDate = txtEndDate.getDate();

					// Apply the validation logic checking all controls are empty or not
					if (amount.trim().equals("") || amount.trim().equals("Please enter your amount")
							|| address.trim().equals("") || address.trim().equals("Please enter your address")
							|| description.trim().equals("")
							|| description.trim().equals("Please enter your description")

					) {
						JOptionPane.showMessageDialog(null, "Please enter full information !!!");
					}

					if (createDate == null & disbursement == null & endDate == null) {
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
							loan.setInterest(Float.parseFloat(txtInterest.getText()));
							loan.setPeriod(Integer.parseInt(txtPeriod.getText()));

							int duration = (int) txtDuration.getSelectedItem();
							loan.setDuration(duration);
							loan.setCreateDate(txtCreateDate.getDate());
							loan.setDisbursementDate(txtDisbursement.getDate());
							loan.setEndDate(txtEndDate.getDate());

							LoanModel loanModel = new LoanModel();
							if (loanModel.create(loan)) {
								JOptionPane.showMessageDialog(null, "Successful!");

								CreateLoan.this.dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Please try again!");
							}

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

					txtAmount.setText("");
					txtPeriod.setText("");
					txtDescription.setText("");
					txtDuration.setSelectedItem(null);
					txtCreateDate.setDate(null);
					txtDisbursement.setDate(null);
					txtEndDate.setDate(null);
					txtInterest.setText("");
					bg.clearSelection();

				}
			});
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnClear.setIcon(new ImageIcon(
					CreateLoan.class.getResource("/com/aptech/LoanProcessingSystem/images/arrows-circle.png")));
			btnClear.setBounds(733, 22, 95, 23);
			panel_1.add(btnClear);
		}

		{
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(526, 76, 491, 268);
			contentPanel.add(panel_1);

			JLabel lblNewLabel_2 = new JLabel("Duration *");
			lblNewLabel_2.setBounds(36, 33, 62, 14);
			panel_1.add(lblNewLabel_2);

			JLabel lblNewLabel_4 = new JLabel("End Date *");
			lblNewLabel_4.setBounds(36, 78, 83, 14);
			panel_1.add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel("Interest *");
			lblNewLabel_5.setBounds(36, 117, 99, 14);
			panel_1.add(lblNewLabel_5);

			txtInterest = new JTextField();
			txtInterest.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					
					try {
						int i = Integer.parseInt(txtInterest.getText());
						txtValid3.setText("");
					
				} catch (Exception e1) {
					// TODO: handle exception
					txtValid3.setText("Invalid number");
					
				}
					
				}
			});
			txtInterest.setColumns(10);
			txtInterest.setBounds(146, 114, 306, 20);
			panel_1.add(txtInterest);

			txtDuration = new JComboBox();
			txtDuration.setBounds(146, 29, 306, 22);
			panel_1.add(txtDuration);
			initDurationValue();
			txtEndDate = new JDateChooser();
			txtEndDate.setBounds(146, 72, 306, 20);
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

	private void initDurationValue() {

		int[] durations = new int[] { 6, 12, 18, 24, 36, 48, 72};
		DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
		for (int dur : durations) {
			model.addElement(dur);
		}
		txtDuration.setModel(model);
		txtDuration.setRenderer(new DurationListCellRenderer());

	}
	private class DurationListCellRenderer extends DefaultListCellRenderer {

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			int item = (int) value;
			return super.getListCellRendererComponent(list, item + " month", index, isSelected, cellHasFocus);
		}

		

	}
}
