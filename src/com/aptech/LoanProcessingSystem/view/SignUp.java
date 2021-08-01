package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.mindrot.jbcrypt.BCrypt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class SignUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignUp dialog = new SignUp();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	ButtonGroup bg;
	private JLabel lblNewLabel_2 = new JLabel("");
	private JTextField txtIdentity;
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPass;
	private JTextField txtPhone;
	private JDateChooser txtCalendar;
	private JTextField txtAdress;
	private JCheckBox txtStatus;

	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));

		bg = new ButtonGroup();

		setFont(new Font("Dialog", Font.BOLD, 12));
		
		setTitle("Sign Up");
		setBounds(100, 100, 1057, 587);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(176, 224, 230));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			setLocationRelativeTo(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(192, 34, 824, 437);
				panel.add(panel_1);
				panel_1.setLayout(null);

				JLabel lblNewLabel = new JLabel("Register Now");
				lblNewLabel.setIcon(new ImageIcon(
						SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/registered.png")));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setForeground(Color.RED);
				lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
				lblNewLabel.setBounds(294, 11, 271, 74);
				panel_1.add(lblNewLabel);
				{
					JLabel lblNewLabel_1 = new JLabel("Full Name *");
					lblNewLabel_1.setBounds(10, 108, 76, 17);
					panel_1.add(lblNewLabel_1);
				}

				txtName = new JTextField();
				txtName.setBounds(140, 106, 195, 20);
				panel_1.add(txtName);
				txtName.setColumns(10);

				JLabel lblNewLabel_3 = new JLabel("Email *");
				lblNewLabel_3.setBounds(10, 150, 76, 14);
				panel_1.add(lblNewLabel_3);

				txtEmail = new JTextField();
				txtEmail.setBounds(140, 147, 195, 20);
				panel_1.add(txtEmail);
				txtEmail.setColumns(10);

				JLabel lblNewLabel_4 = new JLabel("Password *");
				lblNewLabel_4.setBounds(10, 189, 76, 14);
				panel_1.add(lblNewLabel_4);

				txtPassword = new JPasswordField();
				txtPassword.setBounds(140, 186, 195, 20);
				panel_1.add(txtPassword);

				JLabel lblNewLabel_5 = new JLabel("Confirm Password *");
				lblNewLabel_5.setBounds(10, 230, 120, 14);
				panel_1.add(lblNewLabel_5);

				txtConfirmPass = new JPasswordField();
				txtConfirmPass.setBounds(140, 227, 195, 20);
				panel_1.add(txtConfirmPass);

				JLabel lblNewLabel_6 = new JLabel("Phone *");
				lblNewLabel_6.setBounds(404, 229, 76, 17);
				panel_1.add(lblNewLabel_6);

				JLabel lblNewLabel_7 = new JLabel("Gender *");
				lblNewLabel_7.setBounds(10, 280, 76, 14);
				panel_1.add(lblNewLabel_7);

				rdbMale = new JRadioButton("Male");
				rdbMale.setHorizontalAlignment(SwingConstants.CENTER);
				rdbMale.setBounds(143, 276, 76, 23);
				panel_1.add(rdbMale);
				bg.add(rdbMale);
				bg.add(rdbFemale);
				rdbMale.setSelected(true);

				rdbFemale = new JRadioButton("Female");
				rdbFemale.setHorizontalAlignment(SwingConstants.CENTER);
				rdbFemale.setBounds(258, 276, 76, 23);
				panel_1.add(rdbFemale);
				bg.add(rdbMale);
				bg.add(rdbFemale);
				rdbMale.setSelected(true);

				JLabel lblNewLabel_8 = new JLabel("Dob *");
				lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_8.setBounds(10, 333, 76, 14);
				panel_1.add(lblNewLabel_8);

				txtCalendar = new JDateChooser();
				txtCalendar.setBounds(140, 327, 195, 20);
				panel_1.add(txtCalendar);

				JLabel lblNewLabel_9 = new JLabel("Address *");
				lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_9.setBounds(404, 109, 88, 14);
				panel_1.add(lblNewLabel_9);

				txtPhone = new JTextField();
				txtPhone.setColumns(10);
				txtPhone.setBounds(516, 227, 195, 20);
				panel_1.add(txtPhone);

				txtAdress = new JTextField();
				txtAdress.setColumns(10);
				txtAdress.setBounds(516, 106, 195, 20);
				panel_1.add(txtAdress);

				JButton btnSignUp = new JButton("Sign Up");
				btnSignUp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						String name = txtName.getText();
						String email = txtEmail.getText();
						String password = txtPassword.getText();
						String confirm_pass = txtConfirmPass.getText();
						String phone = txtPhone.getText();
						String address = txtAdress.getText();
						String identity_card = txtIdentity.getText();
						String gender = "Male";
						if (rdbFemale.isShowing()) {
							gender = "Female";
						}

						Date dob = txtCalendar.getDate();

						// Apply the validation logic checking all controls are empty or not
						if (name.trim().equals("") || name.trim().equals("Please enter your name")
								|| email.trim().equals("") || email.trim().equals("Please enter your email")
								|| email.trim().equals("") || name.trim().equals("Please enter your name")
								|| password.trim().equals("") || password.trim().equals("Please enter your password")
								|| confirm_pass.trim().equals("")
								|| confirm_pass.trim().equals("Please enter your confirm_pass")
								|| phone.trim().equals("") || phone.trim().equals("Please enter your phone")
								|| address.trim().equals("") || address.trim().equals("Please enter your address")
								|| identity_card.trim().equals("")
								|| identity_card.trim().equals("Please enter your identity_card")

						) {
							JOptionPane.showMessageDialog(null, "Please enter full information !!!");
						} else if (password.equals(confirm_pass)) {

							if (dob == null) {
								JOptionPane.showMessageDialog(null, "Please select Date of Birthday");
								txtCalendar.grabFocus();

							} else {

								try {

									Account account = new Account();
									account.setName(txtName.getText());
									account.setEmail(txtEmail.getText());
									String pass = new String(txtPassword.getPassword());
									String hash = BCrypt.hashpw(pass, BCrypt.gensalt());
									account.setPassword(hash);
									String pass1 = new String(txtConfirmPass.getPassword());
									String hash1 = BCrypt.hashpw(pass1, BCrypt.gensalt());
									account.setPassword(hash1);
									account.setPhone(txtPhone.getText());
									account.setAddress(txtAdress.getText());
									account.setGender(rdbMale.isSelected() ? 1 : 0);
									account.setDob(txtCalendar.getDate());
									account.setIdentityCard(txtIdentity.getText());
									account.setStatus(txtStatus.isSelected());
									
									AccountModel accountModel = new AccountModel();
									if (accountModel.create(account)) {
										JOptionPane.showMessageDialog(null, "Successful account registration!");
										Login login = new Login();
										login.setVisible(true);
										SignUp.this.dispose();
									}else {
										JOptionPane.showMessageDialog(null, "Please try again!");
									}

								} catch (Exception e2) {
									// TODO: handle exception
									e2.printStackTrace();
								}

							}
						} else {
							JOptionPane.showMessageDialog(null, "Password and Confirm Password must be same !");
							txtPassword.setText("");
							txtConfirmPass.setText("");
						}
					}

				
				});
				btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnSignUp.setForeground(Color.BLUE);
				btnSignUp.setIcon(new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/sign-up.png")));
				btnSignUp.setBounds(447, 349, 109, 29);
				panel_1.add(btnSignUp);

				JButton btnReset = new JButton("Reset");
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						txtName.setText("");
						txtEmail.setText("");
						txtPassword.setText("");
						txtConfirmPass.setText("");
						txtPhone.setText("");
						txtAdress.setText("");
						txtCalendar.setDate(null);
						txtIdentity.setText("");

						bg.clearSelection();

					}
				});
				btnReset.setForeground(Color.RED);
				btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnReset.setIcon(new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/rotation-lock.png")));
				btnReset.setBounds(660, 351, 109, 29);
				panel_1.add(btnReset);

				JLabel lblNewLabel_11 = new JLabel("Identity Card");
				lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_11.setBounds(404, 153, 88, 14);
				panel_1.add(lblNewLabel_11);

				txtStatus = new JCheckBox("Status");
				txtStatus.setBounds(574, 185, 99, 23);
				panel_1.add(txtStatus);

				txtIdentity = new JTextField();
				txtIdentity.setBounds(516, 150, 195, 20);
				panel_1.add(txtIdentity);
				txtIdentity.setColumns(10);
			}
			{
				lblNewLabel_2.setIcon(new ImageIcon(
						SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (1).png")));
				lblNewLabel_2.setBounds(28, 131, 161, 227);
				panel.add(lblNewLabel_2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Login login = new Login();
						login.setVisible(true);
						SignUp.this.dispose();
					}
				});
				cancelButton.setIcon(
						new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
