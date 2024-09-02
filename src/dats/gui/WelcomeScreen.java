package dats.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

public class WelcomeScreen {

	private JFrame frmWelcomeScreen;
	private JTextField txtrhc;
	private JTextField txtwelcome;
	private JTextField txtquote;
	private JTextField txtquote1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frmWelcomeScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
		showFrame();
	}
	
	public void showFrame()
	{
		Thread t=new Thread(
				new Runnable() {
					
					@Override
					public void run() {
						try 
						{
							Thread.sleep(5000);
							
							Login login=new Login();
							login.setVisible(true);
							frmWelcomeScreen.dispose();
						} 
						catch (InterruptedException e) 
						{
							e.printStackTrace();
						}
						
					}
				}
				
				);//constructor of thread class closed
		t.start();//start the thread
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcomeScreen = new JFrame();
		frmWelcomeScreen.setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomeScreen.class.getResource("/dats/images/wel.png")));
		frmWelcomeScreen.setTitle("Welcome Screen");
		frmWelcomeScreen.setBounds(100, 100, 838, 541);
		frmWelcomeScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeScreen.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/dats/images/doc.jpg")));
		lblNewLabel.setBounds(10, 62, 225, 225);
		frmWelcomeScreen.getContentPane().add(lblNewLabel);
		
		txtrhc = new JTextField();
		txtrhc.setForeground(new Color(240, 128, 128));
		txtrhc.setBackground(new Color(176, 224, 230));
		txtrhc.setEditable(false);
		txtrhc.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		txtrhc.setText("RAPID HEALTHCARE!!!");
		txtrhc.setBounds(245, 66, 310, 51);
		frmWelcomeScreen.getContentPane().add(txtrhc);
		txtrhc.setColumns(10);
		
		txtwelcome = new JTextField();
		txtwelcome.setForeground(new Color(240, 128, 128));
		txtwelcome.setBackground(new Color(176, 224, 230));
		txtwelcome.setEditable(false);
		txtwelcome.setText("WELCOMES YOU!!!");
		txtwelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		txtwelcome.setColumns(10);
		txtwelcome.setBounds(515, 142, 288, 51);
		frmWelcomeScreen.getContentPane().add(txtwelcome);
		
		txtquote = new JTextField();
		txtquote.setBackground(new Color(176, 224, 230));
		txtquote.setForeground(new Color(240, 128, 128));
		txtquote.setEditable(false);
		txtquote.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		txtquote.setText("Medicine cure diseases but");
		txtquote.setBounds(26, 318, 491, 42);
		frmWelcomeScreen.getContentPane().add(txtquote);
		txtquote.setColumns(10);
		
		txtquote1 = new JTextField();
		txtquote1.setForeground(new Color(240, 128, 128));
		txtquote1.setBackground(new Color(176, 224, 230));
		txtquote1.setText("only doctors can cure patients!!!!!");
		txtquote1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		txtquote1.setEditable(false);
		txtquote1.setColumns(10);
		txtquote1.setBounds(294, 386, 491, 42);
		frmWelcomeScreen.getContentPane().add(txtquote1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(WelcomeScreen.class.getResource("/dats/images/Welcome.jpg")));
		lblNewLabel_1.setBounds(0, 0, 824, 504);
		frmWelcomeScreen.getContentPane().add(lblNewLabel_1);
	}
}
