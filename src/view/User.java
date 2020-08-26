package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class User {

	private JFrame frmHome;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User window = new User();
					window.frmHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public User() {
		initialize();
	}

	
	private void initialize() {
		frmHome = new JFrame();
		frmHome.setTitle("Home");
		frmHome.getContentPane().setForeground(new Color(100, 149, 237));
		frmHome.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\trainIcon.png"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		frmHome.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(0, 0, 285, 453);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("  Home");
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setBounds(10, 55, 126, 37);
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\home.png"));
		btnNewButton_4.setFont(new Font("Stencil", Font.PLAIN, 15));
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Profile");
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\icons8-test-account-30.png"));
		btnNewButton_5.setFont(new Font("Stencil", Font.PLAIN, 15));
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_5.setBounds(135, 55, 144, 37);
		panel_1.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 139));
		panel_2.setBounds(10, 103, 269, 273);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("  Trip");
		btnNewButton_3.setBounds(10, 110, 249, 47);
		panel_2.add(btnNewButton_3);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\distance.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton = new JButton("  Reservation");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\icons8-reservation-30.png"));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 34, 249, 47);
		panel_2.add(btnNewButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(151, 405, 118, 37);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\icons8-sign-out-30.png"));
		btnLogOut.setBounds(0, 0, 118, 37);
		panel_3.add(btnLogOut);
		frmHome.setBounds(100, 100, 676, 492);
		frmHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
