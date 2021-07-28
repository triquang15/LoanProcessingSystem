package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

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
		setFont(new Font("Dialog", Font.BOLD, 12));
		setLocationRelativeTo(null);
		setTitle("Login");
		setBounds(100, 100, 688, 357);
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
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(212, 25, 442, 233);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JLabel lblNewLabel = new JLabel("Usename");
					lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel.setBounds(66, 51, 82, 20);
					panel_1.add(lblNewLabel);
				}
				{
					txtUsername = new JTextField();
					txtUsername.setForeground(new Color(255, 192, 203));
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
					txtUsername.setBounds(158, 43, 263, 28);
					panel_1.add(txtUsername);
					txtUsername.setColumns(10);
				}
				{
					JLabel lblNewLabel_1 = new JLabel("Password");
					lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					lblNewLabel_1.setBounds(66, 114, 71, 16);
					panel_1.add(lblNewLabel_1);
				}
				{
					txtPassword = new JPasswordField();
					txtPassword.setForeground(new Color(255, 192, 203));
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
					txtPassword.setBounds(158, 101, 263, 28);
					panel_1.add(txtPassword);
				}
				{
					JButton btnNewButton = new JButton("Login");
					btnNewButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (txtUsername.getText().equals("admin") && txtPassword.getText().equals("1234567")) {
								txtMessage.setText("");
								JOptionPane.showMessageDialog(null, "Login Successful");

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
					btnNewButton.setBounds(158, 171, 122, 28);
					panel_1.add(btnNewButton);
				}
				{
					JButton btnNewButton_1 = new JButton("Sign Up");
					btnNewButton_1.setIcon(
							new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/exit.png")));
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnNewButton_1.setBounds(299, 171, 122, 28);
					panel_1.add(btnNewButton_1);
				}
				{
					txtMessage.setForeground(new Color(255, 0, 0));
					txtMessage.setBounds(158, 140, 263, 20);
					panel_1.add(txtMessage);
				}
			}
			{
				JLabel lblNewLabel_2 = new JLabel("");
				lblNewLabel_2.setIcon(
						new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (1).png")));
				lblNewLabel_2.setBounds(39, 47, 161, 227);
				panel.add(lblNewLabel_2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if (JOptionPane.showConfirmDialog(null, "Are you sure you want to close Application ?",
								"Confirm", JOptionPane.YES_NO_OPTION) == 0)
							Login.this.dispose();
					}
				});
				cancelButton.setIcon(
						new ImageIcon(Login.class.getResource("/com/aptech/LoanProcessingSystem/images/close.png")));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
