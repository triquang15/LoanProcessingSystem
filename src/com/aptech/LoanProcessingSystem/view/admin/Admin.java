package com.aptech.LoanProcessingSystem.view.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;

<<<<<<< HEAD
import com.aptech.LoanProcessingSystem.entities.Account;
=======
>>>>>>> a065563 (add 1st time)

import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> a065563 (add 1st time)
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JPanel jpanelMain;
<<<<<<< HEAD
	private Map<String, Object> data = new HashMap<String, Object>();
	private Account account = new Account();
=======
>>>>>>> a065563 (add 1st time)

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 898, 653);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelRoot = new JPanel();
		contentPane.add(jpanelRoot, BorderLayout.CENTER);
		jpanelRoot.setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelSide = new JPanel();
		jpanelSide.setBackground(new Color(21, 25, 28));
		jpanelSide.setPreferredSize(new Dimension(80, 0));
		jpanelRoot.add(jpanelSide, BorderLayout.WEST);
		FlowLayout fl_jpanelSide = new FlowLayout(FlowLayout.CENTER, 5, 5);
		fl_jpanelSide.setAlignOnBaseline(true);
		jpanelSide.setLayout(fl_jpanelSide);
		
		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnHome_actionPerformed(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(21, 25, 28));
		panel.setPreferredSize(new Dimension(60, 150));
		jpanelSide.add(panel);
		btnHome.setBorderPainted(false);
		btnHome.setBackground(new Color(21, 25, 28));
		btnHome.setIcon(new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_home_20px_3.png")));
		btnHome.setPreferredSize(new Dimension(40, 40));
		jpanelSide.add(btnHome);
		
		JButton btnInterest = new JButton("");
		btnInterest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInterest_actionPerformed(e);
			}
		});
		btnInterest.setIcon(new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_currency_exchange_20px.png")));
		btnInterest.setPreferredSize(new Dimension(40, 40));
		btnInterest.setBorderPainted(false);
		btnInterest.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnInterest);
		
		JButton btnLoanData = new JButton("");
		btnLoanData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLoanData_actionPerformed(e);
			}
		});
		btnLoanData.setIcon(new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_layers_20px.png")));
		btnLoanData.setPreferredSize(new Dimension(40, 40));
		btnLoanData.setBorderPainted(false);
		btnLoanData.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnLoanData);
		
		JButton btnUserProfile = new JButton("");
		btnUserProfile.setIcon(new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_profile_20px.png")));
		btnUserProfile.setPreferredSize(new Dimension(40, 40));
		btnUserProfile.setBorderPainted(false);
		btnUserProfile.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnUserProfile);
		
		JButton btnEmployeeProfile = new JButton("");
		btnEmployeeProfile.setIcon(new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_management_20px.png")));
		btnEmployeeProfile.setPreferredSize(new Dimension(40, 40));
		btnEmployeeProfile.setBorderPainted(false);
		btnEmployeeProfile.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnEmployeeProfile);
		
		JButton btnExit = new JButton("");
		btnExit.setIcon(new ImageIcon(Admin.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_exit_20px.png")));
		btnExit.setPreferredSize(new Dimension(40, 40));
		btnExit.setBorderPainted(false);
		btnExit.setBackground(new Color(21, 25, 28));
		jpanelSide.add(btnExit);
		
		jpanelMain = new JPanel();
		jpanelMain.setBackground(SystemColor.control);
		jpanelRoot.add(jpanelMain, BorderLayout.CENTER);
		jpanelMain.setLayout(new BorderLayout(0, 0));
		
		JButton[] btns = {btnHome, btnExit, btnEmployeeProfile, btnInterest, btnUserProfile, btnLoanData};
		for (JButton jButton : btns) {
			jButton.setBackground(new Color(21, 25, 28));
			jButton.setUI(new BasicButtonUI());
			jButton.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {

				}
				
				@Override
				public void mousePressed(MouseEvent e) {

				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					jButton.setBackground(new Color(21, 25, 28));
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					jButton.setBackground(new Color(54, 81, 207));
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					
				}
			});
		}
	}
	
<<<<<<< HEAD
	public Admin(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	public void loadData() {
		this.account = (Account) this.data.get("users");
	}
	
=======
>>>>>>> a065563 (add 1st time)
	public void btnHome_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelHomePage data = new jpanelHomePage();
		jpanelMain.add(data);
		data.setVisible(true);
	}
	
	public void btnLoanData_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelLoadData jpanelHome = new jpanelLoadData();
		jpanelMain.add(jpanelHome);
		jpanelHome.setVisible(true);
	}
	
	public void btnInterest_actionPerformed(ActionEvent e) {
		clearScreen();
		jpanelLoanType jpanelLoanType = new jpanelLoanType();
		jpanelMain.add(jpanelLoanType);
		jpanelLoanType.setVisible(true);
	}
	
	private void clearScreen () {
		jpanelMain.removeAll();
		jpanelMain.revalidate();
	}
}
