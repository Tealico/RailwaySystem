package view;

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
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class LogIn extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogIn frame = new LogIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LogIn() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("\\img\\trainIcon.png"));
		setResizable(false);
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 502);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(398, 102, 242, 266);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 242, 50);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(90, 11, 65, 34);
		lblLogin.setForeground(new Color(100, 149, 237));
		lblLogin.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblLogin.setPreferredSize(new Dimension(50, 40));
		panel_1.add(lblLogin);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 50, 242, 216);
		panel_2.setBackground(new Color(220, 220, 220));
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(29, 20, 191, 34);
		panel_4.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(10, 11, 75, 14);
		panel_3.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(95, 8, 86, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(29, 70, 191, 34);
		panel_4.add(panel_5);
		panel_5.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(95, 8, 88, 20);
		panel_5.add(passwordField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 11, 73, 14);
		panel_5.add(lblPassword);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(29, 120, 191, 33);
		FlowLayout flowLayout = (FlowLayout) panel_6.getLayout();
		flowLayout.setAlignment(FlowLayout.LEADING);
		flowLayout.setHgap(11);
		panel_4.add(panel_6);
		
		JButton btnLogin = new JButton("Login");
		panel_6.add(btnLogin);
		
		JLabel lblCreateAccount = new JLabel("Create account");
		lblCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_6.add(lblCreateAccount);
		
		lblCreateAccount.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  changeView();
		      }
		    });
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Tea\\Desktop\\java\\New folder\\RailwaySystem\\img\\high-speed-rail-tgv-train-vector-illustration.jpg"));
		lblNewLabel.setBounds(10, 10, 656, 450);
		contentPane.add(lblNewLabel);
	}
	
	private void changeView() {
		this.hide();
		Register frame = new Register();
  	  	frame.setVisible(true);
	}
	
}
