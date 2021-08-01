package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import org.mindrot.jbcrypt.BCrypt;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.model.AccountModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;

public class SignUp extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;
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
	private String hintName = "Please enter your name";
	private String hintEmail = "Please enter your email";
	private String hintPassword = "Please enter your password";
	private String hintConfirmPass = "Please enter your confirm password";
	private String hintPhone = "Please enter your phone";
	private String hintAddress = "Please enter your address";
	private String hintIdentityCard = "Please enter your identity card";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		Add theme
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
					frame.addWindowListener(new java.awt.event.WindowAdapter() {
						@Override
						public void windowClosing(java.awt.event.WindowEvent windowEvent) {
							if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close Application ?",
									"Confirm", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								System.exit(0);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));

		bg = new ButtonGroup();

		setFont(new Font("Dialog", Font.BOLD, 12));

		setTitle("Sign Up");
		setBounds(100, 100, 1057, 587);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		setLocationRelativeTo(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(192, 34, 824, 437);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Register Now");
		lblNewLabel.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/registered.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(294, 11, 271, 74);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Full Name *");
		lblNewLabel_1.setBounds(8, 108, 76, 17);
		panel_1.add(lblNewLabel_1);

		txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(13, 35));
		txtName.setBounds(140, 97, 195, 29);
		panel_1.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Email *");
		lblNewLabel_3.setBounds(8, 150, 76, 14);
		panel_1.add(lblNewLabel_3);

		txtEmail = new JTextField();
		txtEmail.setPreferredSize(new Dimension(13, 35));
		txtEmail.setBounds(140, 138, 195, 29);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Password *");
		lblNewLabel_4.setBounds(8, 189, 76, 14);
		panel_1.add(lblNewLabel_4);

		txtPassword = new JPasswordField();
		txtPassword.setPreferredSize(new Dimension(13, 35));
		txtPassword.setBounds(140, 177, 195, 29);
		panel_1.add(txtPassword);

		JLabel lblNewLabel_5 = new JLabel("Confirm Password *");
		lblNewLabel_5.setBounds(8, 230, 120, 14);
		panel_1.add(lblNewLabel_5);

		txtConfirmPass = new JPasswordField();
		txtConfirmPass.setPreferredSize(new Dimension(13, 35));
		txtConfirmPass.setBounds(140, 218, 195, 29);
		panel_1.add(txtConfirmPass);

		JLabel lblNewLabel_6 = new JLabel("Phone *");
		lblNewLabel_6.setBounds(404, 191, 76, 17);
		panel_1.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Gender *");
		lblNewLabel_7.setBounds(8, 280, 76, 14);
		panel_1.add(lblNewLabel_7);

		rdbMale = new JRadioButton("Male");
		rdbMale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbMale.setBounds(144, 271, 76, 23);
		panel_1.add(rdbMale);
		bg.add(rdbMale);
		bg.add(rdbFemale);
		rdbMale.setSelected(true);

		rdbFemale = new JRadioButton("Female");
		rdbFemale.setHorizontalAlignment(SwingConstants.LEFT);
		rdbFemale.setBounds(259, 271, 76, 23);
		panel_1.add(rdbFemale);
		bg.add(rdbMale);
		bg.add(rdbFemale);
		rdbMale.setSelected(true);

		JLabel lblNewLabel_8 = new JLabel("Dob *");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_8.setBounds(8, 333, 76, 14);
		panel_1.add(lblNewLabel_8);

		txtCalendar = new JDateChooser();
		txtCalendar.setBounds(140, 318, 195, 29);
		panel_1.add(txtCalendar);

		JLabel lblNewLabel_9 = new JLabel("Address *");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_9.setBounds(404, 109, 88, 14);
		panel_1.add(lblNewLabel_9);

		txtPhone = new JTextField();
		txtPhone.setPreferredSize(new Dimension(13, 35));
		txtPhone.setColumns(10);
		txtPhone.setBounds(516, 180, 195, 29);
		panel_1.add(txtPhone);

		txtAdress = new JTextField();
		txtAdress.setPreferredSize(new Dimension(13, 35));
		txtAdress.setColumns(10);
		txtAdress.setBounds(516, 97, 195, 29);
		panel_1.add(txtAdress);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpAction(e);
			}

		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignUp.setForeground(Color.BLUE);
		btnSignUp.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/sign-up.png")));
		btnSignUp.setBounds(516, 344, 109, 36);
		panel_1.add(btnSignUp);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initForm();
			}
		});
		btnReset.setForeground(Color.RED);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReset.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/rotation-lock.png")));
		btnReset.setBounds(660, 344, 109, 36);
		panel_1.add(btnReset);

		JLabel lblNewLabel_11 = new JLabel("Identity Card");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_11.setBounds(404, 153, 88, 14);
		panel_1.add(lblNewLabel_11);

		txtIdentity = new JTextField();
		txtIdentity.setPreferredSize(new Dimension(13, 35));
		txtIdentity.setBounds(516, 141, 195, 29);
		panel_1.add(txtIdentity);
		txtIdentity.setColumns(10);

		lblNewLabel_2.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (1).png")));
		lblNewLabel_2.setBounds(28, 131, 161, 227);
		panel.add(lblNewLabel_2);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(110, 35));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		cancelButton.setIcon(
				new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		initForm();

		txtName.setText(hintName);
		setTextHint(txtName, hintName);

		txtEmail.setText(hintEmail);
		setTextHint(txtEmail, hintEmail);

		txtPassword.setText(hintPassword);
		setTextHint(txtPassword, hintPassword);

		txtConfirmPass.setText(hintConfirmPass);
		setTextHint(txtConfirmPass, hintConfirmPass);

		txtAdress.setText(hintAddress);
		setTextHint(txtAdress, hintAddress);

		txtIdentity.setText(hintIdentityCard);
		setTextHint(txtIdentity, hintIdentityCard);

		txtPhone.setText(hintPhone);
		setTextHint(txtPhone, hintPhone);
	}

	protected void initForm() {
		txtName.setText(hintName);
		txtName.setForeground(new Color(255, 192, 203));
		txtEmail.setText(hintEmail);
		txtEmail.setForeground(new Color(255, 192, 203));
		txtPassword.setText(hintPassword);
		txtPassword.setForeground(new Color(255, 192, 203));
		txtPassword.setEchoChar((char) 0);
		txtConfirmPass.setText(hintConfirmPass);
		txtConfirmPass.setForeground(new Color(255, 192, 203));
		txtConfirmPass.setEchoChar((char) 0);
		txtPhone.setText(hintPhone);
		txtPhone.setForeground(new Color(255, 192, 203));
		txtAdress.setText(hintAddress);
		txtAdress.setForeground(new Color(255, 192, 203));
		txtCalendar.setDate(new Date());
		txtIdentity.setText(hintIdentityCard);
		txtIdentity.setForeground(new Color(255, 192, 203));
		bg.clearSelection();
	}

	protected void signUpAction(ActionEvent e) {
		String name = txtName.getText();
		String email = txtEmail.getText();
		String password = new String(txtPassword.getPassword());
		String confirm_pass = new String(txtConfirmPass.getPassword());
		String phone = txtPhone.getText();
		String address = txtAdress.getText();
		String identityCard = txtIdentity.getText();
		String gender = "Male";
		if (rdbFemale.isShowing()) {
			gender = "Female";
		}

		Date dob = txtCalendar.getDate();

		// Apply the validation logic checking all controls are empty or not
		if (name.trim().equals(hintName) || email.trim().equals(hintEmail) || password.trim().equals(hintPassword)
				|| confirm_pass.trim().equals(hintConfirmPass) || phone.trim().equals(hintPhone)
				|| address.trim().equals(hintAddress) || identityCard.trim().equals(hintIdentityCard)) {

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
					account.setGender(rdbMale.isSelected());
					account.setDob(txtCalendar.getDate());
					account.setIdentityCard(txtIdentity.getText());

					AccountModel accountModel = new AccountModel();
					if (accountModel.create(account)) {
						JOptionPane.showMessageDialog(null, "Successful account registration!");
						Login login = new Login();
						login.setVisible(true);
						this.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Please try again!");
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		} else {
			JOptionPane.showMessageDialog(null, "Password and Confirm Password must be same !");
			txtPassword.setText("");
			txtConfirmPass.setText("");
		}
	}

	protected void setTextHint(JTextField textField, String hint) {
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textField.getText().equals(hint)) {
					textField.setText("");
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
					textField.setForeground(new Color(255, 192, 203));
					if (textField instanceof JPasswordField) {
						((JPasswordField) textField).setEchoChar((char) 0);
					}
				}
			}
		});
	}

}
