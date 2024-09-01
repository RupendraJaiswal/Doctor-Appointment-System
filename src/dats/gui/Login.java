package dats.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.manager.Manager;
import dats.receptionist.Receptionist;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.Window.Type;

public class Login extends JFrame implements ActionListener,KeyListener
{

	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setType(Type.UTILITY);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/dats/images/Logged.png")));
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/dats/images/Doctor.png")));
		lblNewLabel.setBounds(28, 130, 243, 208);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User ID");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/dats/images/User.png")));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(301, 130, 125, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/dats/images/Pass.png")));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(301, 190, 125, 37);
		contentPane.add(lblNewLabel_2);
		
		txtid = new JTextField();
		txtid.setForeground(new Color(240, 128, 128));
		txtid.setToolTipText("Please enter user id.");
		txtid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtid.setBounds(436, 130, 156, 37);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.setForeground(new Color(240, 128, 128));
		btnlogin.setBackground(new Color(240, 230, 140));
		btnlogin.setIcon(new ImageIcon(Login.class.getResource("/dats/images/Login.png")));
		btnlogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnlogin.setBounds(390, 267, 137, 37);
		btnlogin.addActionListener(this);
		btnlogin.addKeyListener(this);
		contentPane.add(btnlogin);
		
		JLabel lblNewLabel_3 = new JLabel("\u201CPeople pay the doctor for his trouble;");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setForeground(new Color(200, 115, 135));
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(28, 21, 398, 46);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("for his kindness they still remain in his debt.\u201D");
		lblNewLabel_4.setForeground(new Color(200, 115, 135));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(140, 77, 452, 46);
		contentPane.add(lblNewLabel_4);
		
		txtpass = new JPasswordField();
		txtpass.setForeground(new Color(240, 128, 128));
		txtpass.setToolTipText("Please Enter your password.");
		txtpass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtpass.setBounds(436, 190, 156, 37);
		contentPane.add(txtpass);
	}
	
	public void check()
	{
		String user=txtid.getText().trim();
		char[]password=txtpass.getPassword();
		String pass=String.valueOf(password);
		
		if(user.isEmpty()||pass.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Please Enter Valid ID & Password.");
		}
		else
		{
			if(user.equalsIgnoreCase("Manager") && pass.equals("Manager123"))
			{
				Manager mn=new Manager();//create object of that frame class
				mn.setVisible(true);//it will show the frame
			}
			
			else if(user.equalsIgnoreCase("Receptionist") && pass.equals("Recept123"))
			{
				Receptionist rc=new Receptionist();
				rc.setVisible(true);
			}
			
			else
			{
				JOptionPane.showMessageDialog(this,"Invalid UserID/Password");
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		if(code==10)
		{
			check();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button is pressed.");
		check();
		
	}
}
