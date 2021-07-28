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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPass;
	private JTextField txtPhone;
	private JTextField txtAdress;
	private JTextField txtSalary;
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
//	ButtonGroup bg;

	public SignUp() {

//		bg = new ButtonGroup();
//		bg.add(rdbMale);
//		bg.add(rdbFemale);
//		rdbMale.setSelected(true);

		setFont(new Font("Dialog", Font.BOLD, 12));
		setLocationRelativeTo(null);
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
				lblNewLabel_6.setBounds(10, 271, 76, 17);
				panel_1.add(lblNewLabel_6);

				JLabel lblNewLabel_7 = new JLabel("Gender *");
				lblNewLabel_7.setBounds(10, 313, 76, 14);
				panel_1.add(lblNewLabel_7);

				rdbMale = new JRadioButton("Male");
				rdbMale.setHorizontalAlignment(SwingConstants.CENTER);
				rdbMale.setBounds(141, 309, 76, 23);
				panel_1.add(rdbMale);
				rdbMale.setSelected(true);

				rdbFemale = new JRadioButton("Female");
				rdbFemale.setHorizontalAlignment(SwingConstants.CENTER);
				rdbFemale.setBounds(259, 309, 76, 23);
				panel_1.add(rdbFemale);

				JLabel lblNewLabel_8 = new JLabel("Dob *");
				lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_8.setBounds(400, 313, 76, 14);
				panel_1.add(lblNewLabel_8);

				JDateChooser txtCalendar = new JDateChooser();
				txtCalendar.setBounds(516, 307, 195, 20);
				panel_1.add(txtCalendar);

				JLabel lblNewLabel_9 = new JLabel("Address *");
				lblNewLabel_9.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_9.setBounds(400, 109, 80, 14);
				panel_1.add(lblNewLabel_9);

				txtPhone = new JTextField();
				txtPhone.setColumns(10);
				txtPhone.setBounds(140, 269, 195, 20);
				panel_1.add(txtPhone);

				JButton btnImage = new JButton("Image *");
				btnImage.setHorizontalAlignment(SwingConstants.LEFT);
				btnImage.setIcon(new ImageIcon(
						SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/document (2).png")));
				btnImage.setBounds(387, 238, 109, 20);
				panel_1.add(btnImage);

				txtAdress = new JTextField();
				txtAdress.setColumns(10);
				txtAdress.setBounds(516, 106, 195, 20);
				panel_1.add(txtAdress);

				JLabel lblNewLabel_10 = new JLabel("Salary *");
				lblNewLabel_10.setHorizontalAlignment(SwingConstants.LEFT);
				lblNewLabel_10.setBounds(400, 162, 96, 17);
				panel_1.add(lblNewLabel_10);

				txtSalary = new JTextField();
				txtSalary.setColumns(10);
				txtSalary.setBounds(516, 147, 195, 20);
				panel_1.add(txtSalary);

				JButton btnSignUp = new JButton("Sign Up");
				btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnSignUp.setForeground(Color.BLUE);
				btnSignUp.setIcon(new ImageIcon(
						SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/register.png")));
				btnSignUp.setBounds(226, 357, 109, 34);
				panel_1.add(btnSignUp);

				JButton btnReset = new JButton("Reset");
				btnReset.setForeground(Color.RED);
				btnReset.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnReset.setIcon(new ImageIcon(
						SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/arrows-circle.png")));
				btnReset.setBounds(467, 357, 109, 34);
				panel_1.add(btnReset);

				JLabel txtImage = new JLabel("Image");
				txtImage.setIcon(
						new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/user.png")));
				txtImage.setHorizontalAlignment(SwingConstants.CENTER);
				txtImage.setBounds(565, 189, 120, 99);
				panel_1.add(txtImage);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("");
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
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setIcon(
						new ImageIcon(SignUp.class.getResource("/com/aptech/LoanProcessingSystem/images/close.png")));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
