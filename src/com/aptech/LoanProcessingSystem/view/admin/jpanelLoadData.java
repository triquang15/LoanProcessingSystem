package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.AbstractCellEditor;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.SystemColor;
import java.util.EventObject;
import java.util.List;

import java.awt.SystemColor;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.aptech.LoanProcessingSystem.entities.Loan;
import com.aptech.LoanProcessingSystem.entities.LoanType;
import com.aptech.LoanProcessingSystem.model.CustomerModel;
import com.aptech.LoanProcessingSystem.model.LoanModel;
import com.aptech.LoanProcessingSystem.model.LoanTypeModel;
import com.aptech.LoanProcessingSystem.view.admin.jpanelCustomerProfile.ButtonEditor;
import com.aptech.LoanProcessingSystem.view.admin.jpanelCustomerProfile.LoanInfosPane;
import com.aptech.LoanProcessingSystem.entities.Account;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class jpanelLoadData extends JPanel {
	private JTextField txtSearch;
//	private JTextField txtVehicleSearch;
//	private JTable jtableVehicle;
//	private JTextField txtPersonalSearch;
//	private JTable jtablePersonal;
//	private JTextField txtEducationalSearch;
//	private JTable jtableEducational;
	private JComboBox cbFilter;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnSearch;
	private JTable tableLoan;
//	private JComboBox cbPersonalFilter;
//	private JButton btnPersonalAdd;
//	private JButton btnPersonaUpdate;
//	private JButton btnPersonalDelete;
//	private JButton btnEducationalSearch;
//	private JComboBox cbEducationalFilter;
//	private JButton btnEducationalAdd;
//	private JButton btnEducationalUpdate;
//	private JButton btnEducationalDelete;
	private Account account = new Account();
	private JTabbedPane tabbedPane;

	/**
	 * Create the panel.
	 */
	public jpanelLoadData(Account account) {
		this();
		this.account = account;
	}

	public jpanelLoadData() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel jpanelHomeTop = new JPanel();
		jpanelHomeTop.setBackground(new Color(21, 25, 28));
		add(jpanelHomeTop);
		FlowLayout fl_jpanelHomeTop = new FlowLayout(FlowLayout.LEFT, 5, 5);
		jpanelHomeTop.setLayout(fl_jpanelHomeTop);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_layers_20px.png")));
		jpanelHomeTop.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Loan Data");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(SystemColor.text);
		jpanelHomeTop.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(34, 40, 44));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(34,40,44));
		tabbedPane.setBorder(null);
		tabbedPane.setForeground(SystemColor.controlText);
		tabbedPane.setBackground(SystemColor.inactiveCaption);
		panel.add(tabbedPane, BorderLayout.CENTER);

		loadAllTabbed();
	}

	private void loadAllTabbed() {
		LoanTypeModel loanTypeModel = new LoanTypeModel();
		for (LoanType loanType : loanTypeModel.loadAllLoanType()) {
			addNewTabbed(loanType);
		}
	}
	
//	public void btnSearch_actionPerformed(ActionEvent e, LoanType loanType) {
//		int CustomerId = Integer.parseInt(txtSearch.getText().trim());
//		LoanModel loanModel = new LoanModel();
//		FillDataToJTable(loanModel.findLoanByLoanType(loanType, CustomerId));
//	}
	
//	private void test() {
//		panel_1 = (JPanel) tabbedPane.inde();
//		btnSearch.setText("open");
//		jtable = (JTable) tabbedPane.getComponentAt(1);
//		filltable(list)
//	}
	private void addNewTabbed(LoanType loanType) {
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(21, 25, 28));
		panel_1.setForeground(SystemColor.text);
		tabbedPane.addTab(loanType.getName(), null, panel_1, null);
		panel_1.setBackground(new Color(34, 40, 44));
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(21, 25, 28));
		panel_5.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(34, 40, 44));
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_7);

		JLabel lblNewLabel_2 = new JLabel("Search");
		lblNewLabel_2.setForeground(SystemColor.text);
		panel_7.add(lblNewLabel_2);

		txtSearch = new JTextField();
		panel_7.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
//		btnSearch.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				btnSearch_actionPerformed(e, loanType);
//			}
//		});
		panel_7.add(btnSearch);

		JButton btnReload = new JButton("");
		btnReload.setBorderPainted(false);
		btnReload.setContentAreaFilled(false);
		btnReload.setFocusPainted(false);
		btnReload.setIcon(new ImageIcon(
				jpanelLoadData.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_refresh_20px.png")));
		panel_7.add(btnReload);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(34, 40, 44));
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_5.add(panel_8);

		JLabel lblNewLabel_3 = new JLabel("Filter");
		lblNewLabel_3.setForeground(SystemColor.text);
		panel_8.add(lblNewLabel_3);

		JComboBox cbFilter = new JComboBox();
		panel_8.add(cbFilter);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setBackground(new Color(21, 25, 28));
		panel_6.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(34, 40, 44));
		panel_6.add(scrollPane, BorderLayout.CENTER);

		JTable tableLoan = new JTable();
		tableLoan.setForeground(SystemColor.text);
		tableLoan.setRowHeight(40);
		LoanModel loanModel = new LoanModel();
		tableLoan.setBackground(new Color(34, 40, 44));
		FillDataToJTable(loanModel.getAllLoanHome(loanType), tableLoan);
		scrollPane.setViewportView(tableLoan);
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(34, 40, 44));
		panel_1.add(panel_9);

		JButton btnAdd = new JButton("Add");

		btnReload.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				btnReload_actionPerformed(e, loanType);
				LoanModel loanModel = new LoanModel();
				FillDataToJTable(loanModel.getAllLoanHome(loanType), tableLoan);
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(loanType, tableLoan, scrollPane);
			}
		});
		panel_9.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
//		btnUpdate.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				btnUpdate_actionPerformed(e, loanType);
//			}
//		});
		panel_9.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
//		btnDelete.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				btnDelete_actionPerformed(e, loanType);
//			}
//		});
		panel_9.add(btnDelete);
	}

	public void btnAdd_actionPerformed(LoanType loanType, JTable tableLoan, JScrollPane scrollPane) {
		JPanel jpanelMain = (JPanel) this.getParent();
		jpanelMain.removeAll();
		jpanelMain.revalidate();
		jpanelAddNewLoan addNewLoan = new jpanelAddNewLoan(this.account);
		jpanelMain.add(addNewLoan);
		addNewLoan.setVisible(true);
//		addNewLoan.addWindowListener(new WindowAdapter() {
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//				FillDataToJTable(new LoanModel().getAllLoanHome(loanType), tableLoan);
//				super.windowClosed(e);
//			}
//		});
	}

	public void FillDataToJTable(List<Loan> loanList, JTable tableLoan) {
		String statusMask = "";
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
			statusMask = loadStatus(loan.getStatus());
			System.out.println(statusMask);
			defaultTableModel.addRow(new Object[] { loan.getId(), loan.getLoanTypeId(), loan.getInterest(),
					loan.getAccountId(), loan.getCustomerId(), loan.getPaymentTypeId(), loan.getAmount(),
					loan.getPeriod(), loan.getDuration(), loan.getCreateDate(), loan.getDisbursementDate(),
					loan.getEndDate(), loan.getDescription(), loadStatus(loan.getStatus()) });
		}
		tableLoan.setModel(defaultTableModel);
		LoanInfosPane infosPane = new LoanInfosPane();
		infosPane.loan.setText(statusMask);
		tableLoan.getColumnModel().getColumn(13).setCellRenderer(infosPane);
		tableLoan.getColumnModel().getColumn(13).setCellEditor(new ButtonEditor());
		tableLoan.getTableHeader().setReorderingAllowed(false);
		tableLoan.addNotify();
	}
	
	public String loadStatus (int status) {
		String str = "";
		if (status == 0) {
			str = "Inspect";
		} else if (status == 1) {
			str = "open";
		} else if (status == 2) {
			str = "update";
		} else if (status == 3) {
			str = "fully paid";
		}
		return str;
	}
	
	public class LoanInfosPane extends JPanel implements TableCellRenderer {

        private JButton loan;
//        private JButton info;
        private String state;
        private String mask;

        public LoanInfosPane() {
        	setBackground(new Color(34,40,44));
            setLayout(new GridBagLayout());
            loan = new JButton();
            loan.setBackground(SystemColor.RED);
            loan.setActionCommand("loans");
//            info = new JButton("Infos");
//            info.setActionCommand("infos");

            add(loan);
//            add(info);

            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    state = e.getActionCommand();
                    if (state.equals("loans")) {
                    	
                    } else {
                    	jDialogAddNewCustomer addNewCustomer  = new jDialogAddNewCustomer();
                    	addNewCustomer.setVisible(true);
                    }
                }
            };

            loan.addActionListener(listener);
//            info.addActionListener(listener);
        }

        public void addActionListener(ActionListener listener) {
        	loan.addActionListener(listener);
//        	info.addActionListener(listener);
        }

        public String getState() {
            return state;
        }

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			return this;
		}
    }


	class ButtonRenderer extends DefaultTableCellRenderer  {

		private LoanInfosPane loanInfosPane;
		
		public ButtonRenderer() {
			loanInfosPane = new LoanInfosPane();
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (isSelected) {
				loanInfosPane.setBackground(table.getSelectionBackground());
            } else {
            	loanInfosPane.setBackground(table.getBackground());
            }
			return loanInfosPane;
		}
	}

	class ButtonEditor extends AbstractCellEditor implements TableCellEditor {
		
		private LoanInfosPane loanInfosPane;

		public ButtonEditor() {
			loanInfosPane = new LoanInfosPane();
			loanInfosPane.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					SwingUtilities.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							stopCellEditing();
							
						}
					});
					
				}
			});
		}

		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			if (isSelected) {
				loanInfosPane.setBackground(table.getSelectionBackground());
			} else {
				loanInfosPane.setBackground(table.getBackground());
			}
			return loanInfosPane;
		}

		public Object getCellEditorValue() {
			return loanInfosPane.getState();
		}
		
		@Override
		public boolean isCellEditable(EventObject e) {
			return true;
		}
	}
}
