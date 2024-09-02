package dats.receptionist;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.dbutils.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;

public class Phone_Token extends JFrame implements ActionListener,WindowListener,KeyListener
{

	private JPanel contentPane;
	private JTextField txtappno;
	private JTextField txtphone;
	private JTextField txtpatname;
	private JTextField txtproblem;
	private JTextField txtage;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Phone_Token frame = new Phone_Token();
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
	public Phone_Token() {
		setType(Type.UTILITY);
		con=DbConnection.openConnection();
		this.addWindowListener(this);
		setResizable(false);
		setTitle("Search Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Appointment No");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(29, 21, 149, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(29, 64, 149, 31);
		contentPane.add(lblNewLabel_1);
		
		txtappno = new JTextField();
		txtappno.setForeground(new Color(240, 128, 128));
		txtappno.setToolTipText("Enter Appointment Number.");
		txtappno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtappno.setBounds(185, 21, 163, 31);
		contentPane.add(txtappno);
		txtappno.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.setForeground(new Color(240, 128, 128));
		txtphone.setToolTipText("Enter Phone Number.");
		txtphone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtphone.setColumns(10);
		txtphone.setBounds(185, 64, 163, 31);
		txtphone.addKeyListener(this);
		contentPane.add(txtphone);
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBackground(new Color(240, 230, 140));
		btnsearch.setForeground(new Color(240, 128, 128));
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnsearch.setBounds(358, 41, 118, 31);
		btnsearch.addActionListener(this);
		contentPane.add(btnsearch);
		
		JLabel lblNewLabel_1_1 = new JLabel("Patient Name");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(29, 105, 149, 31);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Problem");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(29, 142, 149, 31);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Age");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_3.setBounds(29, 177, 149, 31);
		contentPane.add(lblNewLabel_1_3);
		
		txtpatname = new JTextField();
		txtpatname.setForeground(new Color(240, 128, 128));
		txtpatname.setEditable(false);
		txtpatname.setToolTipText("Enter Patient Name.");
		txtpatname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtpatname.setColumns(10);
		txtpatname.setBounds(185, 105, 163, 31);
		contentPane.add(txtpatname);
		
		txtproblem = new JTextField();
		txtproblem.setForeground(new Color(240, 128, 128));
		txtproblem.setEditable(false);
		txtproblem.setToolTipText("Enter Your Problem. ");
		txtproblem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtproblem.setColumns(10);
		txtproblem.setBounds(185, 146, 163, 31);
		contentPane.add(txtproblem);
		
		txtage = new JTextField();
		txtage.setForeground(new Color(240, 128, 128));
		txtage.setEditable(false);
		txtage.setToolTipText("Enter Your Age.");
		txtage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtage.setColumns(10);
		txtage.setBounds(185, 183, 163, 31);
		contentPane.add(txtage);
	}
	
	public void searchPatient()
	{
		String pappno=txtappno.getText().trim();
		String pphone=txtphone.getText().trim();
		
		if(pappno.isEmpty()&&pphone.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Please enter valid appointment number & phone number.","Mandatory Fields.",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			String strsearch="select * from patient_appointment where AppointmentNo=? or Phone=?";
			try
			{
				ps=con.prepareStatement(strsearch);
				ps.setString(1,pappno);
				ps.setString(2,pphone);
				rs=ps.executeQuery();

				
				if(rs.next())
				{
					String patientname=rs.getString("PatientName");
					String problem=rs.getString("Problem");
					String age=rs.getString("Age");
					
					txtpatname.setText(patientname);
					txtproblem.setText(problem);
					txtage.setText(age);					
				}
				else
				{
					JOptionPane.showMessageDialog(this,"No such patient available.");
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			
			finally
			{
				try
				{
					if(ps!=null)
						ps.close();
					if(rs!=null)
						rs.close();
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		DbConnection.closeConnection();
		System.out.println("Connection is being closed.");
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		txtpatname.setText("");
		txtproblem.setText("");
		txtage.setText("");
		
		searchPatient();
		System.out.println("Button is being clicked.");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtphone)
		{
			char c=e.getKeyChar();
			if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
			{
				e.consume();
				JOptionPane.showMessageDialog(this,"Phone requires only numbers","Mandatory Field",JOptionPane.WARNING_MESSAGE);
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
