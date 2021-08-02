package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.border.EmptyBorder;

import com.aptech.LoanProcessingSystem.model.AccountModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
import javax.swing.UIManager;

import java.awt.Toolkit;
import java.awt.event.MouseMotionAdapter;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel txtMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
//		try {
//			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//		} catch (Throwable e) {
//			e.printStackTrace();
//		}
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 12));
	
		setTitle("Login");
		setBounds(100, 100, 688, 357);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(224, 255, 255));
		contentPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			setLocationRelativeTo(null);
			panel.setBackground(Color.DARK_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.GRAY);
				panel_1.setBounds(212, 25, 442, 233);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Usename");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel.setBounds(66, 37, 82, 20);
					panel_1.add(lblNewLabel);
				}
				{
					txtUsername = new JTextField();
					txtUsername.setFont(new Font("Tahoma", Font.ITALIC, 11));
					txtUsername.setForeground(new Color(255, 0, 0));
					txtUsername.addFocusListener(new FocusAdapter() {
						@Override
						public void focusGained(FocusEvent e) {
							if (txtUsername.getText().equals("Enter your email")) {
								txtUsername.setText("");
							} else {
								txtUsername.selectAll();
							}
						}

						@Override
						public void focusLost(FocusEvent e) {
							if (txtUsername.getText().equals(""))
								txtUsername.setText("Enter your email");
						}
					});
					txtUsername.setBounds(158, 34, 263, 23);
					panel_1.add(txtUsername);
					txtUsername.setColumns(10);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Password");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel_1.setBounds(66, 95, 71, 16);
					panel_1.add(lblNewLabel_1);
				}
				{
					txtPassword = new JPasswordField();
					txtPassword.setFont(new Font("Tahoma", Font.ITALIC, 11));
					txtPassword.setForeground(new Color(255, 0, 0));
					txtPassword.addFocusListener(new FocusAdapter() {
						@Override
						public void focusGained(FocusEvent e) {
							if (txtPassword.getText().equals("Enter your password")) {
								txtPassword.setEchoChar('●');
								txtPassword.setText("");
							} else {
								txtPassword.selectAll();
							}

						}

						@Override
						public void focusLost(FocusEvent e) {
							if (txtPassword.getText().equals("")) {
								txtPassword.setText("Enter your password");
								txtPassword.setEchoChar((char) 0);
							}
						}
					});
					txtPassword.setBounds(158, 90, 263, 21);
					panel_1.add(txtPassword);
				}
				{
					JButton btnNewButton = new JButton("Login");
					btnNewButton.setBackground(Color.LIGHT_GRAY);
					btnNewButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							
							
							AccountModel accountModel = new AccountModel();
							String username = txtUsername.getText().trim();
							String password = new String(txtPassword.getPassword());
							if (accountModel.login(username,password)) {
								txtMessage.setText("");
								JOptionPane.showMessageDialog(null, "Login Successful");
								Map<String, Object> data = new HashMap<String, Object>();
								data.put("username", username);
								data.put("users", accountModel.find(username));
								
								Home home = new Home();
								home.setVisible(true);
								
								Login.this.dispose();

							} else if (txtUsername.getText().equals("")
									|| txtUsername.getText().equals("Enter your email")
									|| txtPassword.getText().equals("")
									|| txtPassword.getText().equals("Enter your password")) {
								txtMessage.setText("Please enter full information");
							} else {
								txtMessage.setText("Incorrect username or password");
							}
						}
					});
					btnNewButton.setIcon(
							new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/enter.png")));
					btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
					btnNewButton.setBounds(158, 159, 108, 23);
					panel_1.add(btnNewButton);
				}
				{
					JButton btnNewButton_1 = new JButton("Sign Up");
					btnNewButton_1.setBackground(Color.LIGHT_GRAY);
					btnNewButton_1.setIcon(
							new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/unauthorized-person.png")));
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							SignUp signUp = new SignUp();
							signUp.setVisible(true);
							Login.this.dispose();
						}
					});
					btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnNewButton_1.setBounds(313, 159, 108, 23);
					panel_1.add(btnNewButton_1);
				}
				{
					txtMessage.setFont(new Font("Tahoma", Font.ITALIC, 10));
					txtMessage.setForeground(new Color(255, 0, 0));
					txtMessage.setBounds(158, 129, 263, 20);
					panel_1.add(txtMessage);
				}
				{
					JLabel txtForgotPass = new JLabel("Forgot Password ?");
					txtForgotPass.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							SendCode send_Code = new SendCode();
							send_Code.setVisible(true);
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
				}
			}
			{
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(
						new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (1).png")));
				lblNewLabel_2.setBounds(35, 25, 161, 227);
				panel.add(lblNewLabel_2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.setBackground(Color.GRAY);
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close Application ?",
								"Confirm", JOptionPane.YES_NO_OPTION) == 0);
					Login.this.dispose();
							
					}
				});
				cancelButton.setIcon(
						new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
