package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;


public class Admin {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Admin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(100, 149, 237));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
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
		panel_2.setBounds(10, 103, 269, 282);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("  Trains\r\n");
		btnNewButton.setBounds(10, 11, 249, 47);
		panel_2.add(btnNewButton);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\train.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_1 = new JButton("  Locations");
		btnNewButton_1.setBounds(10, 84, 249, 47);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\icons8-location-30.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_2 = new JButton("  Users");
		btnNewButton_2.setBounds(10, 162, 249, 47);
		panel_2.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\icons8-user-group-30.png"));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnNewButton_3 = new JButton("  Trip");
		btnNewButton_3.setBounds(10, 235, 249, 47);
		panel_2.add(btnNewButton_3);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\distance.png"));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(151, 405, 118, 37);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\icons8-sign-out-30.png"));
		btnLogOut.setBounds(0, 0, 118, 37);
		panel_3.add(btnLogOut);
		frame.setBounds(100, 100, 676, 492);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
