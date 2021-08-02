package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.model.AccountModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel txtMessage = new JLabel("");

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 12));

		setTitle("Login");
		setBounds(100, 100, 688, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		setLocationRelativeTo(null);
		panel.setBackground(new Color(176, 224, 230));
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(212, 25, 442, 233);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usename");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(66, 37, 82, 20);
		panel_1.add(lblNewLabel);

		String hintUserName = "Enter your email";
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(255, 192, 203));
		setTextHint(txtUsername, hintUserName);
		txtUsername.setBounds(158, 34, 263, 28);
		txtUsername.setText(hintUserName);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(66, 95, 71, 16);
		panel_1.add(lblNewLabel_1);

		String hintPassword = "Enter your password";
		txtPassword = new JPasswordField();
		txtPassword.setForeground(new Color(255, 192, 203));

		setTextHint(txtPassword, hintPassword);
		txtPassword.setBounds(158, 90, 263, 28);
		txtPassword.setText(hintPassword);
		txtPassword.setEchoChar((char) 0);
		panel_1.add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginAction(e);
			}
		});
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/enter.png")));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setBounds(158, 151, 122, 36);
		panel_1.add(btnLogin);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setIcon(new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/exit.png")));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
				signUp.setVisible(true);
				Login.this.dispose();
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignUp.setBounds(299, 151, 122, 36);
		panel_1.add(btnSignUp);

		txtMessage.setForeground(new Color(255, 0, 0));
		txtMessage.setBounds(158, 129, 263, 20);
		panel_1.add(txtMessage);

		JLabel txtForgotPass = new JLabel("Forgot Password ?");
		txtForgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SendCode sendCode = new SendCode();
				sendCode.setVisible(true);
				Login.this.dispose();
			}

		});
		txtForgotPass.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				txtForgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		txtForgotPass.setForeground(Color.BLUE);
		txtForgotPass.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtForgotPass.setBounds(238, 198, 122, 20);
		panel_1.add(txtForgotPass);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(
				new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (1).png")));
		lblNewLabel_2.setBounds(28, 31, 161, 227);
		panel.add(lblNewLabel_2);

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

	protected void loginAction(MouseEvent agr) {
		AccountModel accountModel = new AccountModel();
		String username = txtUsername.getText().trim();
		String password = new String(txtPassword.getPassword());
		if (accountModel.login(username, password)) {
			txtMessage.setText("");
			JOptionPane.showMessageDialog(null, "Login Successful");
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("username", username);
			data.put("users", accountModel.find(username));
			Home home = new Home();
			home.setVisible(true);
			this.dispose();
		} else if (txtUsername.getText().equals("") || txtUsername.getText().equals("Enter your email")
				|| txtPassword.getText().equals("") || txtPassword.getText().equals("Enter your password")) {
			txtMessage.setText("Please enter full information");
		} else {
			txtMessage.setText("Incorrect username or password");
		}
	}
}
