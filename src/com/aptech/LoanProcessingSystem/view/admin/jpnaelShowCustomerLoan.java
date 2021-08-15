package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.aptech.LoanProcessingSystem.entities.Customer;
import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.model.PaymentTypeModel;
import com.aptech.LoanProcessingSystem.service.ShareData;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class jpnaelShowCustomerLoan extends JPanel {
	private JTable tblLoanDetail;
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblAddress;
	private JLabel lblPhone;
	private JLabel lblCompany;
	private JLabel lblIDCard;
	private JLabel lblJob;
	private JLabel lblSalary;
	private JLabel lblDOB;
	private JLabel lblGender;
	private JLabel lblEmail;
	private Customer customer = new Customer();

	/**
	 * Create the panel.
	 */
	public jpnaelShowCustomerLoan() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(21, 25, 28));
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			add(panel);
			{
				JLabel lblNewLabel = new JLabel("View Customer");
				lblNewLabel.setForeground(SystemColor.text);
				lblNewLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(34,40,44));
			add(panel);
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("ID:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblId = new JLabel("New label");
						lblId.setForeground(SystemColor.text);
						panel_2.add(lblId);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Name:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblName = new JLabel("New label");
						lblName.setForeground(SystemColor.text);
						panel_2.add(lblName);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Address:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblAddress = new JLabel("New label");
						lblAddress.setForeground(SystemColor.text);
						panel_2.add(lblAddress);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JButton btnAddLoan = new JButton("Add Loan");
						btnAddLoan.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								btnAddLoan_actionPerformed(e);
								
							}
						});
						panel_2.add(btnAddLoan);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34,40,44));
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Phone:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblPhone = new JLabel("New label");
						lblPhone.setForeground(SystemColor.text);
						panel_2.add(lblPhone);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Email:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblEmail = new JLabel("New label");
						lblEmail.setForeground(SystemColor.text);
						panel_2.add(lblEmail);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Gender:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblGender = new JLabel("New label");
						lblGender.setForeground(SystemColor.text);
						panel_2.add(lblGender);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("DOB:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblDOB = new JLabel("New label");
						lblDOB.setForeground(SystemColor.text);
						panel_2.add(lblDOB);
					}
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(new Color(34,40,44));
				panel.add(panel_1);
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Salary:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblSalary = new JLabel("New label");
						lblSalary.setForeground(SystemColor.text);
						panel_2.add(lblSalary);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Job:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblJob = new JLabel("New label");
						lblJob.setForeground(SystemColor.text);
						panel_2.add(lblJob);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("Company:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblCompany = new JLabel("New label");
						lblCompany.setForeground(SystemColor.text);
						panel_2.add(lblCompany);
					}
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(34,40,44));
					panel_1.add(panel_2);
					{
						JLabel lblNewLabel_1 = new JLabel("ID Card:");
						lblNewLabel_1.setForeground(SystemColor.text);
						panel_2.add(lblNewLabel_1);
					}
					{
						lblIDCard = new JLabel("New label");
						lblIDCard.setForeground(SystemColor.text);
						panel_2.add(lblIDCard);
					}
				}
			}
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.controlDkShadow);
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBackground(SystemColor.controlText);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					tblLoanDetail = new JTable();
					tblLoanDetail.setBackground(new Color(34, 40, 44));
					tblLoanDetail.setForeground(SystemColor.text);
					scrollPane.setViewportView(tblLoanDetail);
				}
			}
		}
		LoanModel loanModel = new LoanModel();
		FillDataToJTable(loanModel.getAllLoansByCustomerID(this.customer.getId()), 
				tblLoanDetail);
	}
	
	public jpnaelShowCustomerLoan(Customer customer) {
		this();
		this.customer = customer;
		loadData();
		LoanModel loanModel = new LoanModel();
		FillDataToJTable(loanModel.getAllLoansByCustomerID(this.customer.getId()), 
				tblLoanDetail);
	}
	
	public void btnAddLoan_actionPerformed(ActionEvent e) {
		JPanel jpanelMain = (JPanel) this.getParent();
		jpanelMain.removeAll();
		jpanelMain.revalidate();
		jpanelAddNewLoan addNewLoan = new jpanelAddNewLoan(ShareData.accountLogin, 
				this.customer.getId());
		jpanelMain.add(addNewLoan);
		addNewLoan.setVisible(true);
	}
	
	private void loadData() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		lblId.setText(String.valueOf(this.customer.getId()));
		lblName.setText(this.customer.getName());
		lblAddress.setText(this.customer.getAddress());
		lblCompany.setText(this.customer.getCompany());
		lblEmail.setText(this.customer.getEmail());
		lblIDCard.setText(this.customer.getIdentityCard());
		lblJob.setText(this.customer.getJob());
		lblGender.setText(this.customer.isGender() ? "Male" : "Female");
		lblDOB.setText(dateFormat.format(this.customer.getDob()));
		lblPhone.setText(this.customer.getPhone());
		lblSalary.setText(String.valueOf(this.customer.getSalary()));
	}
	public void FillDataToJTable(List<Loan> loanList, JTable tableLoan) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				return super.isCellEditable(row, column);
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Loan Type");
		defaultTableModel.addColumn("Interest");
		defaultTableModel.addColumn("Employee ID");
		defaultTableModel.addColumn("Customer ID");
		defaultTableModel.addColumn("Payment Type");
		defaultTableModel.addColumn("Amount");
		defaultTableModel.addColumn("Period");
		defaultTableModel.addColumn("Duration");
		defaultTableModel.addColumn("Date Created");
		defaultTableModel.addColumn("Date Disbursement");
		defaultTableModel.addColumn("Date End");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Status");
		for (Loan loan : loanList) {
			defaultTableModel.addRow(new Object[] { loan.getId(), loadLoanTypeName(loan.getLoanTypeId()), loan.getInterest(),
					loan.getAccountId(), loan.getCustomerId(), loadPaymentTypeName(loan.getPaymentTypeId()), loan.getAmount(),
					loan.getPeriod(), loan.getDuration(), loan.getCreateDate(), loan.getDisbursementDate(),
					loan.getEndDate(), loan.getDescription(), loan.getStatus() });
		}
		tableLoan.setModel(defaultTableModel);
		tableLoan.getTableHeader().setReorderingAllowed(false);
		tableLoan.addNotify();
	}
	
	private String loadLoanTypeName(int id) {
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		return loanTypeModel.loadLoanTypeNameById(id);
	}
	
	private String loadPaymentTypeName(int id) {
		PaymentTypeModel model = new PaymentTypeModel();
		return model.loadPaymentTypeNameById(id);
	}
}
