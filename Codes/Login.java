package GUIProject;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.AbstractListModel;

public class Login {

	private JFrame frame;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle ("Login Page");
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setBounds(145, 28, 123, 26);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 22));
		frame.getContentPane().add(lblLogin);
		
		JButton btnAdminLogin = new JButton("Menu List");
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAdminLogin)
				{
					MenuList a=new MenuList();
					String[] args=null;
					a.main(args);
				}
			}
		});
		btnAdminLogin.setBounds(101, 77, 168, 42);
		btnAdminLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.getContentPane().add(btnAdminLogin);
		
		JButton btnCustomerLogin = new JButton("Customer Login");
		btnCustomerLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCustomerLogin)
				{
					CustomerLogin c=new CustomerLogin();
					String[] args=null;
					c.main(args);
				}
			}
		});
		btnCustomerLogin.setBounds(100, 130, 168, 42);
		btnCustomerLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		frame.getContentPane().add(btnCustomerLogin);
	}
}
