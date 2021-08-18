package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.aptech.LoanProcessingSystem.entities.Account;
import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.entities.PaymentType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class jDialogAddNewCustomer extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtSalary;
	private JTextField txtJob;
	private JButton btnAdd;
	private JDateChooser jdatechooserDOB;
	private JCheckBox chkStatus;
	private Customer customer = new Customer();
	private JTextField txtIdDCard;
	private JTextField txtAdress;
	private JTextField txtPhone;
	private JTextField txtCompany;
	private JRadioButton rdMale;
	private JRadioButton rdFemale;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			jDialogAddNewCustomer dialog = new jDialogAddNewCustomer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public jDialogAddNewCustomer() {
		setTitle("Add New Loan");
		setBounds(100, 100, 603, 497);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(34, 40, 44));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			panel.setBackground(new Color(21, 25, 28));
			contentPanel.add(panel);
			{
				JLabel lblNewLabel_1 = new JLabel("Add New Customer");
				lblNewLabel_1.setIcon(new ImageIcon(jDialogAddNewCustomer.class
						.getResource("/com/aptech/LoanProcessingSystem/images/icons8_profile_20px.png")));
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
				panel.add(lblNewLabel_1);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34, 40, 44));
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(null);

				JLabel lblNewLabel_2 = new JLabel("Name");
				lblNewLabel_2.setForeground(SystemColor.text);
				lblNewLabel_2.setBounds(26, 30, 70, 16);
				panel_1.add(lblNewLabel_2);

				txtName = new JTextField();
				txtName.setBounds(111, 24, 122, 28);
				panel_1.add(txtName);
				txtName.setColumns(10);
				{
					JLabel lblNewLabel_2_1 = new JLabel("Address");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(26, 96, 70, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Phone");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(26, 140, 90, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					txtEmail = new JTextField();
					txtEmail.setColumns(10);
					txtEmail.setBounds(111, 192, 122, 28);
					panel_1.add(txtEmail);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Email");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(26, 198, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					txtSalary = new JTextField();
					txtSalary.setColumns(10);
					txtSalary.setBounds(111, 250, 122, 28);
					panel_1.add(txtSalary);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Salary");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(26, 256, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					txtJob = new JTextField();
					txtJob.setColumns(10);
					txtJob.setBounds(389, 24, 147, 28);
					panel_1.add(txtJob);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Job");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(347, 30, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("DOB");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(347, 84, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Company");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(319, 140, 108, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("ID card");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(332, 198, 70, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("Status");
					lblNewLabel_2_1.setForeground(SystemColor.text);
					lblNewLabel_2_1.setBounds(333, 296, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}

				jdatechooserDOB = new JDateChooser();
				jdatechooserDOB.setBounds(392, 84, 144, 28);
				panel_1.add(jdatechooserDOB);

				chkStatus = new JCheckBox("Public");
				chkStatus.setForeground(SystemColor.text);
				chkStatus.setBounds(389, 295, 104, 18);
				panel_1.add(chkStatus);

				btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnAdd_actionPerformed(e);
					}
				});
				btnAdd.setBounds(237, 359, 90, 28);
				panel_1.add(btnAdd);

				txtIdDCard = new JTextField();
				txtIdDCard.setBounds(389, 192, 147, 28);
				panel_1.add(txtIdDCard);
				txtIdDCard.setColumns(10);

				JLabel lblNewLabel = new JLabel("Gender");
				lblNewLabel.setForeground(SystemColor.text);
				lblNewLabel.setBounds(333, 250, 55, 16);
				panel_1.add(lblNewLabel);

				rdFemale = new JRadioButton("Female");
				rdFemale.setSelected(true);
				rdFemale.setForeground(SystemColor.text);
				rdFemale.setBounds(396, 251, 76, 18);
				panel_1.add(rdFemale);
				{
					rdMale = new JRadioButton("Male");
					rdMale.setForeground(SystemColor.text);
					rdMale.setBounds(487, 251, 70, 18);
					panel_1.add(rdMale);
				}
				{
					txtAdress = new JTextField();
					txtAdress.setBounds(111, 84, 122, 28);
					panel_1.add(txtAdress);
					txtAdress.setColumns(10);
				}
				{
					txtPhone = new JTextField();
					txtPhone.setBounds(111, 134, 122, 28);
					panel_1.add(txtPhone);
					txtPhone.setColumns(10);
				}
				{
					txtCompany = new JTextField();
					txtCompany.setBounds(389, 134, 147, 28);
					panel_1.add(txtCompany);
					txtCompany.setColumns(10);
				}
				{
					JLabel lblNewLabel_2_1 = new JLabel("ID");
					lblNewLabel_2_1.setForeground(Color.WHITE);
					lblNewLabel_2_1.setBounds(26, 303, 55, 16);
					panel_1.add(lblNewLabel_2_1);
				}
				{
					txtId = new JTextField();
					txtId.setEnabled(false);
					txtId.setEditable(false);
					txtId.setColumns(10);
					txtId.setBounds(111, 297, 122, 28);
					panel_1.add(txtId);
				}
			}
		}
		ButtonGroup G = new ButtonGroup();
		G.add(rdFemale);
		G.add(rdMale);
	}

	public jDialogAddNewCustomer(Customer customer) {
		this();
		this.customer = customer;
		loadData();
	}
	
	private void loadData() {
		txtName.setText(this.customer.getName());
		txtAdress.setText(this.customer.getAddress());
		txtPhone.setText(this.customer.getPhone());
		txtEmail.setText(this.customer.getEmail());
		txtSalary.setText(String.valueOf(this.customer.getSalary()));
		txtJob.setText(this.customer.getJob());
		jdatechooserDOB.setDate(this.customer.getDob());
		txtCompany.setText(this.customer.getCompany());
		txtIdDCard.setText(this.customer.getIdentityCard());
		txtId.setText(String.valueOf(this.customer.getId()));
		if (this.customer.isGender()) {
			rdMale.setSelected(true);
		}
		if (this.customer.isStatus()) {
			chkStatus.setSelected(true);
		}
	}

	public void btnAdd_actionPerformed(ActionEvent e) {
		if (validation().isEmpty()) {
			CustomerModel customerModel = new CustomerModel();
			Customer customer = new Customer();
			customer.setId(Integer.parseInt(txtId.getText().trim()));
			customer.setName(txtName.getText().trim());
			customer.setAddress(txtAdress.getText().trim());
			customer.setPhone(txtPhone.getText().trim());
			customer.setEmail(txtEmail.getText().trim());
			customer.setGender(rdMale.isSelected());
			customer.setDob(jdatechooserDOB.getDate());
			customer.setSalary(Float.parseFloat(txtSalary.getText().trim()));
			customer.setJob(txtJob.getText().trim());
			customer.setCompany(txtCompany.getText().trim());
			customer.setIdentityCard(txtIdDCard.getText().trim());
			customer.setStatus(chkStatus.isSelected());
			if (txtId.getText().trim().isEmpty()) {
				if (customerModel.create(customer)) {
					JOptionPane.showMessageDialog(null, "Done");
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			} else {
				if (customerModel.update(customer)) {
					JOptionPane.showMessageDialog(null, "Done update");
					this.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Failed update");
				}
			}
			
		} else {
			JOptionPane.showMessageDialog(null, validation());
		}
	}

	public String validation() {
		String errorMsg = "";
		if (txtName.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
				|| txtSalary.getText().trim().isEmpty() || txtJob.getText().trim().isEmpty()
				|| txtAdress.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
				|| txtPhone.getText().trim().isEmpty() || txtCompany.getText().trim().isEmpty()
				|| txtIdDCard.getText().trim().isEmpty()) {
			if (!errorMsg.isEmpty()) {
				errorMsg += "\n";
			}
			errorMsg += "Please finish all information!!";
		} else {
			if (txtName.getText().trim().length() > 50) {
				errorMsg += "Customer name must not be larger than 50 characters!!";
			}

			if (!checkPhone(txtPhone.getText().trim())) {
				if (!errorMsg.isEmpty()) {
					errorMsg += "\n";
				}
				errorMsg += "Phone number must be 10 digits and be numbers!!";
			}

			if (!checkSalary(txtSalary.getText().trim())) {
				if (!errorMsg.isEmpty()) {
					errorMsg += "\n";
				}
				errorMsg += "Salary must be a number!!";
			}

			if (!checkEmail(txtEmail.getText().trim())) {
				if (!errorMsg.isEmpty()) {
					errorMsg += "\n";
				}
				errorMsg += "Your Email is not true!!";
			}

			if (jdatechooserDOB.getDate() != null) {
				if (!checkDOB()) {
					if (!errorMsg.isEmpty()) {
						errorMsg += "\n";
					}
					errorMsg += "The birthday must not be larger than today!!";
				}
			} else {
				if (!errorMsg.isEmpty()) {
					errorMsg += "\n";
				}
				errorMsg += "You must enter your birthday!!";
			}
		}
		return errorMsg;
	}

	public boolean checkDOB() {
		Calendar calendar = Calendar.getInstance();
		return jdatechooserDOB.getDate().before(calendar.getTime());
	}

	public boolean checkEmail(String text) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return text.matches(regex);
	}

	public boolean checkPhone(String text) {
		Pattern pattern = Pattern.compile("^\\d{10}$");
		Matcher matcher = pattern.matcher(text);
		return matcher.matches();
	}

	public boolean checkSalary(String text) {
		Pattern pattern = Pattern.compile("[+]?[0-9]+");
		Matcher matcher = pattern.matcher(text);
		return matcher.matches();
	}
}
