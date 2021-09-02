package GUIProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerLogin frame = new CustomerLogin();
					frame.setVisible(true);
					frame.setTitle ("Customer Login Page");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblCustomerLogin = new JLabel("CUSTOMER LOGIN");
		lblCustomerLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCustomerLogin.setBounds(93, 49, 203, 24);
		contentPane.add(lblCustomerLogin);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblUserName.setBounds(58, 109, 107, 29);
		contentPane.add(lblUserName);
		
		textField = new JTextField();
		textField.setBounds(193, 108, 136, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblPassword.setBounds(60, 160, 80, 29);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setText("12345");
		passwordField.setBounds(193, 157, 136, 29);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnLogin)
				{
					String userText;
					String pwd;
					userText= textField.getText();
					pwd= passwordField.getText();
					if((userText.equalsIgnoreCase("custom"))&&(pwd.equalsIgnoreCase("12345")))
					{
						JOptionPane.showMessageDialog(null, "Login Successful");
						dispose();
						GroceryListGUI gui=new GroceryListGUI();
						String[] args=null;
						gui.main(args);
						
					}
					else
					{
						//if (userText.equalsIgnoreCase("") || pwd.equalsIgnoreCase("")) {
			                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			              
			            
					}
				}
				
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.setBounds(135, 217, 138, 23);
		contentPane.add(btnLogin);
	}

}
