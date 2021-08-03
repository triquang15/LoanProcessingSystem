package com.aptech.LoanProcessingSystem.view.admin;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Color;

public class jpanelHomePage extends JPanel {

	/**
	 * Create the panel.
	 */
	public jpanelHomePage() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jpanelHomeTop = new JPanel();
		jpanelHomeTop.setBackground(new Color(21, 25, 28));
		add(jpanelHomeTop);
		FlowLayout fl_jpanelHomeTop = new FlowLayout(FlowLayout.LEFT, 5, 5);
		jpanelHomeTop.setLayout(fl_jpanelHomeTop);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(jpanelHomePage.class.getResource("/com/aptech/LoanProcessingSystem/images/icons8_home_20px_3.png")));
		jpanelHomeTop.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Loan Processing System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(SystemColor.text);
		jpanelHomeTop.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setBackground(new Color(34, 40, 44));
		panel_1.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

	}
}
