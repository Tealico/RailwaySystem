package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Register extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Register(){
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\img\\trainIcon.png"));
		setResizable(false);
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(386, 40, 255, 400);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblLogin = new JLabel("Register");
		lblLogin.setForeground(new Color(100, 149, 237));
		lblLogin.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblLogin.setPreferredSize(new Dimension(50, 40));
		panel_1.add(lblLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 220, 220));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(27, 269, 199, 33);
		panel_4.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnLogin = new JButton("Register");
		btnLogin.setBounds(0, 5, 90, 23);
		panel_6.add(btnLogin);
		
		JLabel lblHaveAnAccount = new JLabel("Have an account?");
		lblHaveAnAccount.setBounds(92, 5, 107, 23);
		lblHaveAnAccount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblHaveAnAccount);
		
		lblHaveAnAccount.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  changeView();
		      }
		    });
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(27, 115, 199, 33);
		panel_4.add(panel_7);
		panel_7.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(88, 8, 101, 19);
		panel_7.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 11, 68, 14);
		panel_7.add(lblPassword);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(27, 165, 199, 31);
		panel_4.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 11, 46, 14);
		panel_8.add(lblAge);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 5, 101, 20);
		panel_8.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(27, 217, 199, 33);
		panel_4.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 11, 46, 14);
		panel_9.add(lblEmail);
		
		textField_2 = new JTextField();
		textField_2.setBounds(89, 8, 100, 20);
		panel_9.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(27, 11, 199, 33);
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 10, 67, 17);
		panel_3.add(lblFirstName);
		
		textField = new JTextField();
		textField.setBounds(87, 8, 102, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(27, 63, 199, 33);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(10, 11, 68, 14);
		panel_5.add(lblLastName);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(88, 8, 101, 20);
		panel_5.add(passwordField_1);
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\high-speed-rail-tgv-train-vector-illustration.jpg"));
		lblNewLabel.setBounds(0, 0, 676, 471);
		contentPane.add(lblNewLabel);
	}
	
	private void changeView() {
		this.hide();
		LogIn frame = new LogIn();
		frame.setVisible(true);
	}
}
