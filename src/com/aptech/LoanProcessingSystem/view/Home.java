package com.aptech.LoanProcessingSystem.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

import com.aptech.LoanProcessingSystem.database.ShareData;
import com.aptech.LoanProcessingSystem.entities.Account;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Home extends JFrame {

	private LoanDetail loanDetail;
	private CustomerInfo customerInfo;
	private Statistic statistic;
	private Account account;
	private JTabbedPane tabbedHome = new JTabbedPane(JTabbedPane.TOP);
	private JLabel lblLogin;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (ShareData.accountLogin == null) {
						Login login = new Login();
						login.setVisible(true);
					} else {

						Home frame = new Home();
						frame.setVisible(true);
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

		setForeground(Color.GRAY);
		setBackground(Color.GRAY);
		setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/bank (4).png")));
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(224, 255, 255));
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1283, 22);
		getContentPane().add(menuBar);

		JMenu mnHome = new JMenu("Home");
		mnHome.setBackground(Color.DARK_GRAY);
		mnHome.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/house.png")));
		mnHome.setForeground(new Color(255, 0, 0));
		menuBar.add(mnHome);

		JMenuItem mntmNewMenuItem = new JMenuItem("Log out");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();

				login.setVisible(true);

				Home.this.dispose();
			}
		});
		mntmNewMenuItem
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/logout.png")));
		mnHome.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_1.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/remove-button.png")));
		mnHome.add(mntmNewMenuItem_1);

		JMenu mnAdmin = new JMenu("Admin");
		mnAdmin.setIcon(new ImageIcon(
				Home.class.getResource("/com/aptech/LoanProcessingSystem/images/unauthorized-person.png")));
		mnAdmin.setForeground(new Color(248, 248, 255));
		menuBar.add(mnAdmin);

		JMenu mnCustomerInfo = new JMenu("Customer Info");
		mnCustomerInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (customerInfo == null) {
					customerInfo = new CustomerInfo();

					ImageIcon icon = new ImageIcon(
							getClass().getResource("/com/aptech/LoanProcessingSystem/images/customer (1).png"));
					tabbedHome.addTab("Customer Info", icon, customerInfo, "Customer Info");
				}

				tabbedHome.setSelectedComponent(customerInfo);
			}
		});

		mnCustomerInfo.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/customer (3).png")));
		mnCustomerInfo.setForeground(new Color(255, 250, 250));
		menuBar.add(mnCustomerInfo);

		JMenu mnStatistic = new JMenu("Statistic");
		mnStatistic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Statistic statistic = new Statistic();
				statistic.setVisible(true);
			}
		});

		mnStatistic.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/statistics (1).png")));
		mnStatistic.setForeground(new Color(255, 250, 250));
		menuBar.add(mnStatistic);

		JMenu mnAbout = new JMenu("About");
		mnAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				About about = new About();
				about.setVisible(true);
			}
		});
		mnAbout.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/info.png")));
		mnAbout.setForeground(new Color(255, 250, 250));
		menuBar.add(mnAbout);

		JMenu mnHelp = new JMenu("Help");
		mnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Help help = new Help();
				help.setVisible(true);
			}
		});
		mnHelp.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/help.png")));
		mnHelp.setForeground(new Color(255, 250, 250));
		menuBar.add(mnHelp);

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.DARK_GRAY);
		toolBar.setBounds(0, 21, 950, 46);
		getContentPane().add(toolBar);

		JButton btnCustomer = new JButton("");
		btnCustomer.setToolTipText("New Customer");
		btnCustomer.setBackground(Color.DARK_GRAY);
		btnCustomer.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer addCustomer = new AddCustomer();
				addCustomer.setVisible(true);
			}
		});
		btnCustomer
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/customer.png")));
		toolBar.add(btnCustomer);

		JButton btnLoan = new JButton("");
		btnLoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (loanDetail == null) {
					loanDetail = new LoanDetail();

					ImageIcon icon = new ImageIcon(
							getClass().getResource("/com/aptech/LoanProcessingSystem/images/loan.png"));
					tabbedHome.addTab("Loan Detail", icon, loanDetail, "Loan Detail");
				}

				tabbedHome.setSelectedComponent(loanDetail);

			}
		});
		btnLoan.setBackground(Color.DARK_GRAY);
		btnLoan.setToolTipText("Loan");
		btnLoan.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/loan.png")));
		toolBar.add(btnLoan);

		JButton btnLoanType = new JButton("");
		btnLoanType.setToolTipText("Loan Type");
		btnLoanType.setBackground(Color.DARK_GRAY);
		btnLoanType
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/loan (1).png")));
		toolBar.add(btnLoanType);

		JButton btnSearch = new JButton("");
		btnSearch.setToolTipText("Search");
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/magnifying-glass.png")));
		toolBar.add(btnSearch);

		JButton btnPassword = new JButton("");
		btnPassword.setToolTipText("Change Password");
		btnPassword.setBackground(Color.DARK_GRAY);
		btnPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePass changePass = new ChangePass(account);
				changePass.setVisible(true);
			}
		});
		btnPassword
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/password.png")));
		toolBar.add(btnPassword);

		JButton btnLogOut = new JButton("");
		btnLogOut.setToolTipText("Log out");
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/exit (1).png")));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logoutAction();
			}
		});

		JButton btnClock = new JButton("");
		btnClock.setToolTipText("Clock");
		btnClock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clock clock = new Clock();
				clock.setVisible(true);
			}
		});
		btnClock.setBackground(Color.DARK_GRAY);
		btnClock.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/clock (1).png")));
		toolBar.add(btnClock);
		toolBar.add(btnLogOut);

		JButton btnExit = new JButton("");
		btnExit.setToolTipText("Exit");
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/exit (2).png")));
		toolBar.add(btnExit);

		tabbedHome.setForeground(Color.GRAY);
		tabbedHome.setBackground(Color.LIGHT_GRAY);
		tabbedHome.setBounds(0, 66, 1283, 648);
		getContentPane().add(tabbedHome);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(949, 21, 334, 46);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblClock = new JLabel("New label");
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblClock.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/clock.png")));
		lblClock.setForeground(Color.WHITE);
		lblClock.setBounds(10, 11, 109, 24);
		panel.add(lblClock);

		lblLogin = new JLabel("");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblLogin.setIcon(new ImageIcon(
				Home.class.getResource("/com/aptech/LoanProcessingSystem/images/unauthorized-person.png")));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(129, 11, 195, 24);
		panel.add(lblLogin);
		setTitle("Loan Processing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1293, 737);
		setLocationRelativeTo(null);
		lblLogin.setText(ShareData.accountLogin.getEmail());

	}

	protected void logoutAction() {
		Login login = new Login();
		login.setVisible(true);
		Home.this.setVisible(false);
	}
}
