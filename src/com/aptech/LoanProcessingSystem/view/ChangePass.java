package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import com.aptech.LoanProcessingSystem.database.ConnectDB;
import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.model.AccountModel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class ChangePass extends JDialog {

	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	
	public String user;

	private final JPanel contentPanel = new JPanel();
	private JPasswordField txtNewPass;
	private JPasswordField txtVerifyPass;
	private JPasswordField txtCurrentPass;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
			ChangePass dialog = new ChangePass();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ChangePass(String username) {
		this();
		this.user = username;
	}

	

	/**
	 * Create the dialog.
	 */
	public ChangePass() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChangePass.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		setFont(new Font("Dialog", Font.BOLD, 14));
		setTitle("Forgot Password ");
		setBounds(100, 100, 782, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(105, 105, 105));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Loan Processing System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 11, 240, 30);
		contentPanel.add(lblNewLabel);
		setLocationRelativeTo(null);
		{
			JLabel lblNewLabel_1 = new JLabel("Version: 4.10.0.RELEASE");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(10, 52, 156, 22);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Build Id: 202103111225");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_2.setForeground(Color.WHITE);
			lblNewLabel_2.setBounds(10, 73, 135, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Copyright (c) 2007 - 2021 Aptech, VN");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(10, 103, 197, 14);
			contentPanel.add(lblNewLabel_3);
		}

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(197, 23, 561, 208);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("New Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4.setBounds(155, 80, 89, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Verify Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_5.setBounds(155, 120, 89, 14);
		panel.add(lblNewLabel_5);

		JButton btnUpdate = new JButton("Update");
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtNewPass.getText().equals(txtVerifyPass.getText())){
					//check whether the email enter same password in both textfield
					try{
						Account account = new Account();
						String password = new String(txtNewPass.getPassword());
						String hash = BCrypt.hashpw(password, BCrypt.gensalt());
						String password1 = new String(txtVerifyPass.getPassword());
						String hash1 = BCrypt.hashpw(password, BCrypt.gensalt());
						account.setPassword(hash1);
						account.setPassword(hash);
						
					String updateQuery = "UPDATE `account` SET `Password`=? WHERE Email=?";
					conn = ConnectDB.connection();
					ps=conn.prepareStatement(updateQuery);
					ps.setString(1, new String(account.getPassword()));
					ps.setString(2, user);
					if(ps.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "Reset Successfully");
					}


					}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex);
					}
					}else{
					JOptionPane.showMessageDialog(null, "Password do not match");
					}
			}
		});
		
		
		btnUpdate.setBackground(Color.GRAY);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnUpdate.setBounds(320, 159, 89, 23);
		panel.add(btnUpdate);

		txtNewPass = new JPasswordField();
		txtNewPass.setBounds(254, 77, 203, 20);
		panel.add(txtNewPass);

		txtVerifyPass = new JPasswordField();
		txtVerifyPass.setBounds(254, 117, 203, 20);
		panel.add(txtVerifyPass);
		
		txtCurrentPass = new JPasswordField();
		txtCurrentPass.setBounds(254, 38, 203, 20);
		panel.add(txtCurrentPass);
		
		JLabel lblNewLabel_4_1 = new JLabel("Current Pass");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_4_1.setBounds(155, 41, 89, 14);
		panel.add(lblNewLabel_4_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel_6.setIcon(
				new ImageIcon(ChangePass.class.getResource("/com/aptech/LoanProcessingSystem/images/secure.png")));
		lblNewLabel_6.setBounds(38, 145, 92, 64);
		contentPanel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.LIGHT_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				JButton cancelButton = new JButton("Cancel");
				cancelButton.setIcon(new ImageIcon(
						ChangePass.class.getResource("/com/aptech/LoanProcessingSystem/images/close (2).png")));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						ChangePass.this.dispose();
					}
				});
				cancelButton.setBackground(Color.GRAY);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
