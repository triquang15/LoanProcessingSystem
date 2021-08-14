package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.service.ShareData;
import com.toedter.calendar.JDateChooser;
import javax.swing.BoxLayout;
import java.awt.Dimension;

public class AddCustomer extends JDialog {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	ButtonGroup bg;
	public String user;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtSalary;
	private JTextField txtJob;
	private JTextField txtCompany;
	private JTextField txtIdentity;
	private JDateChooser txtDob;
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			if (ShareData.accountLogin == null) {
				Login login = new Login();
				login.setVisible(true);
			} else {
				AddCustomer dialog = new AddCustomer();
				dialog.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public AddCustomer(String username) {
		this();
		this.user = username;
	}

	/**
	 * Create the dialog.
	 */
	public AddCustomer() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				cancelAction();
			}
		});
		bg = new ButtonGroup();
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("New Customer");
		setBounds(100, 100, 1054, 576);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(21, 76, 485, 298);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Name *");
		lblNewLabel_1.setBounds(26, 31, 97, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Address *");
		lblNewLabel_1_1.setBounds(26, 78, 97, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Email *");
		lblNewLabel_1_2.setBounds(26, 125, 97, 14);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Phone *");
		lblNewLabel_1_3.setBounds(26, 172, 97, 14);
		panel.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Gender *");
		lblNewLabel_1_4.setBounds(26, 221, 97, 14);
		panel.add(lblNewLabel_1_4);

		txtName = new JTextField();
		txtName.setBounds(133, 28, 306, 20);
		panel.add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setColumns(10);
		txtAddress.setBounds(133, 75, 306, 20);
		panel.add(txtAddress);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 122, 306, 20);
		panel.add(txtEmail);

		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		txtPhone.setBounds(133, 169, 306, 20);
		panel.add(txtPhone);

		JRadioButton rdbMale = new JRadioButton("Male");
		rdbMale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbMale.setBounds(133, 218, 111, 20);
		panel.add(rdbMale);
		bg.add(rdbMale);
		bg.add(rdbFemale);
		rdbMale.setSelected(true);

		JRadioButton rdbFemale = new JRadioButton("Female");
		rdbFemale.setHorizontalAlignment(SwingConstants.CENTER);
		rdbFemale.setBounds(326, 218, 111, 20);
		panel.add(rdbFemale);
		bg.add(rdbMale);
		bg.add(rdbFemale);
		rdbMale.setSelected(true);

		{
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBackground(Color.LIGHT_GRAY);
			panel_1.setBounds(526, 76, 491, 298);
			contentPanel.add(panel_1);

			JLabel lblNewLabel_2 = new JLabel("Salary *");
			lblNewLabel_2.setBounds(36, 33, 49, 14);
			panel_1.add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Job *");
			lblNewLabel_3.setBounds(36, 74, 49, 14);
			panel_1.add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("Company *");
			lblNewLabel_4.setBounds(36, 115, 83, 14);
			panel_1.add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel("Identity Card *");
			lblNewLabel_5.setBounds(36, 157, 99, 14);
			panel_1.add(lblNewLabel_5);

			JLabel lblNewLabel_7 = new JLabel("Dob *");
			lblNewLabel_7.setBounds(36, 202, 49, 14);
			panel_1.add(lblNewLabel_7);

			txtSalary = new JTextField();
			txtSalary.setBounds(146, 30, 306, 20);
			panel_1.add(txtSalary);
			txtSalary.setColumns(10);

			txtJob = new JTextField();
			txtJob.setColumns(10);
			txtJob.setBounds(146, 71, 306, 20);
			panel_1.add(txtJob);

			txtCompany = new JTextField();
			txtCompany.setColumns(10);
			txtCompany.setBounds(146, 112, 306, 20);
			panel_1.add(txtCompany);

			txtIdentity = new JTextField();
			txtIdentity.setColumns(10);
			txtIdentity.setBounds(146, 154, 306, 20);
			panel_1.add(txtIdentity);

			txtDob = new JDateChooser();
			txtDob.setBounds(146, 196, 306, 20);
			panel_1.add(txtDob);
		}

		JLabel lblNewLabel = new JLabel("New Customer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setIcon(new ImageIcon(
				AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/customer (2).png")));
		lblNewLabel.setBounds(388, 27, 238, 38);
		contentPanel.add(lblNewLabel);
		{
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

					String name = txtName.getText();
					String email = txtEmail.getText();
					String address = txtAddress.getText();
					String phone = txtPhone.getText();
					String company = txtCompany.getText();
					String job = txtJob.getText();
					String salary = txtSalary.getText();
					String identity_card = txtIdentity.getText();
					String gender = "Male";
					if (rdbFemale.isShowing()) {
						gender = "Female";
					}

					Date dob = txtDob.getDate();

					// Apply the validation logic checking all controls are empty or not
					if (name.trim().equals("") || name.trim().equals("Please enter your name")
							|| email.trim().equals("") || email.trim().equals("Please enter your email")
							|| salary.trim().equals("") || salary.trim().equals("Please enter your salary")
							|| job.trim().equals("") || job.trim().equals("Please enter your Job")
							|| phone.trim().equals("") || phone.trim().equals("Please enter your phone")
							|| address.trim().equals("") || address.trim().equals("Please enter your address")
							|| company.trim().equals("") || company.trim().equals("Please enter your Company")
							|| identity_card.trim().equals("")
							|| identity_card.trim().equals("Please enter your identity_card")

					) {
						JOptionPane.showMessageDialog(null, "Please enter full information !!!");
					}

					if (dob == null) {
						JOptionPane.showMessageDialog(null, "Please select Date of Birthday");
						txtDob.grabFocus();

					} else {

						try {

							Customer customer = new Customer();
							customer.setName(txtName.getText());
							customer.setEmail(txtEmail.getText());
							customer.setJob(txtJob.getText());
							customer.setSalary(Float.parseFloat(txtSalary.getText()));
							customer.setCompany(txtCompany.getText());
							customer.setPhone(txtPhone.getText());
							customer.setAddress(txtAddress.getText());
							customer.setGender(rdbMale.isSelected());
							customer.setDob(txtDob.getDate());
							customer.setIdentityCard(txtIdentity.getText());

							CustomerModel customerModel = new CustomerModel();
							if (customerModel.create(customer)) {
								JOptionPane.showMessageDialog(null, "Successful!");

								AddCustomer.this.dispose();
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
					AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/floppy-disk.png")));

			JButton btnClear = new JButton("Clear");
			btnClear.setPreferredSize(new Dimension(120, 30));
			buttonPane.add(btnClear);
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					txtName.setText("");
					txtEmail.setText("");
					txtAddress.setText("");
					txtCompany.setText("");
					txtPhone.setText("");
					txtSalary.setText("");
					txtDob.setDate(null);
					txtIdentity.setText("");
					txtJob.setText("");

					bg.clearSelection();

				}
			});
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 10));
			btnClear.setIcon(new ImageIcon(AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/ic_refresh_16.png")));

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
					new ImageIcon(AddCustomer.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		}
	}


	protected void cancelAction() {
		if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel?", "Confirm",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			this.dispose();
		}
	}
}
