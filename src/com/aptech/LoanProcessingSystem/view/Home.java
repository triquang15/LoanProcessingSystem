package com.aptech.LoanProcessingSystem.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
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

public class Home extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
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

		JMenu mnLoan = new JMenu("Loan");
		mnLoan.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/loan (2).png")));
		mnLoan.setForeground(new Color(248, 248, 255));
		menuBar.add(mnLoan);

		JMenu mnLoanType = new JMenu("Loan Type");
		mnLoanType
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/loan (3).png")));
		mnLoanType.setForeground(new Color(255, 250, 250));
		menuBar.add(mnLoanType);

		JMenu mnStatistical = new JMenu("Statistical");
		mnStatistical.setIcon(
				new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/statistics (1).png")));
		mnStatistical.setForeground(new Color(255, 250, 250));
		menuBar.add(mnStatistical);

		JMenu mnAdmin = new JMenu("Admin");
		mnAdmin.setIcon(new ImageIcon(
				Home.class.getResource("/com/aptech/LoanProcessingSystem/images/unauthorized-person.png")));
		mnAdmin.setForeground(new Color(255, 250, 250));
		menuBar.add(mnAdmin);

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
		toolBar.setBounds(0, 21, 1283, 46);
		getContentPane().add(toolBar);

		JButton btnCustomer = new JButton("");
		btnCustomer.setBackground(Color.DARK_GRAY);
		btnCustomer.setVerticalAlignment(SwingConstants.BOTTOM);
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomer addCustomer = new AddCustomer();
				addCustomer.setVisible(true);
			}
		});
		btnCustomer.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/customer.png")));
		toolBar.add(btnCustomer);

		JButton btnLoan = new JButton("");
		btnLoan.setBackground(Color.DARK_GRAY);
		btnLoan.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/loan.png")));
		toolBar.add(btnLoan);

		JButton btnLoanType = new JButton("");
		btnLoanType.setBackground(Color.DARK_GRAY);
		btnLoanType
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/loan (1).png")));
		toolBar.add(btnLoanType);

		JButton btnLoanHistory = new JButton("");
		btnLoanHistory.setBackground(Color.DARK_GRAY);
		btnLoanHistory
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/magnifying-glass.png")));
		toolBar.add(btnLoanHistory);

		JButton btnPassword = new JButton("");
		btnPassword.setBackground(Color.DARK_GRAY);
		btnPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePass changePass = new ChangePass();
				changePass.setVisible(true);
			}
		});
		btnPassword
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/password.png")));
		toolBar.add(btnPassword);

		JButton btnLogOut = new JButton("");
		btnLogOut.setBackground(Color.DARK_GRAY);
		btnLogOut
				.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/exit (1).png")));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Login login = new Login();
				login.setVisible(true);
				Home.this.dispose();

			}
		});
		toolBar.add(btnLogOut);

		JButton btnExit = new JButton("");
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setIcon(new ImageIcon(Home.class.getResource("/com/aptech/LoanProcessingSystem/images/exit (2).png")));
		toolBar.add(btnExit);

		JSeparator separator_5 = new JSeparator();
		toolBar.add(separator_5);

		JSeparator separator_4 = new JSeparator();
		toolBar.add(separator_4);

		JSeparator separator_3 = new JSeparator();
		toolBar.add(separator_3);

		JSeparator separator_2 = new JSeparator();
		toolBar.add(separator_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.DARK_GRAY);
		toolBar.add(separator_1);

		JSeparator separator = new JSeparator();
		toolBar.add(separator);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.GRAY);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setBounds(0, 66, 1293, 648);
		getContentPane().add(tabbedPane);
		setTitle("Loan Processing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1297, 737);
		setLocationRelativeTo(null);
	}
}
