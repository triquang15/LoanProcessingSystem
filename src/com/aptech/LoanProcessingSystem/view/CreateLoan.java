package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

public class CreateLoan extends JDialog {

	private JPanel contentPane;
	private JRadioButton rdbMale;
	private JRadioButton rdbFemale;
	private ButtonGroup bg;
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

	/**
	 * Create the frame.
	 */
	public CreateLoan() {
		setForeground(Color.GRAY);
		setBackground(Color.GRAY);
		setBounds(100, 100, 654, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
