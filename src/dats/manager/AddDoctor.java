package dats.manager;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import dats.dbutils.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Window.Type;

public class AddDoctor extends JFrame implements ItemListener,ActionListener,WindowListener,KeyListener

{

	private JPanel contentPane;
	private JTextField txtdid;
	private JTextField txtfname;
	private JTextField txtmname;
	private JTextField txtlname;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txttiming;
	private JTextField txtfield;
	private JTextField txtexperience;
	private Connection con;
	String days;
	JTextArea txtaddress,txtqualification ;
	JRadioButton rbfemale, rbmale;
	JCheckBox chckbxsunday,chckbxmonday,chckbxtuesday,chckbxwednesday,chckbxthursday,chckbxfriday,chckbxsaturday;
	private final ButtonGroup gender_group = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDoctor frame = new AddDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	void createComponent()
	{
		setTitle("Add Doctor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 518, 739);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Doctor ID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 29, 127, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblFirstName.setBounds(10, 63, 127, 24);
		contentPane.add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblMiddleName.setBounds(10, 97, 127, 24);
		contentPane.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblLastName.setBounds(10, 131, 127, 24);
		contentPane.add(lblLastName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblAddress.setBounds(10, 165, 127, 24);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblEmail.setBounds(10, 249, 127, 24);
		contentPane.add(lblEmail);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblGender.setBounds(10, 283, 127, 24);
		contentPane.add(lblGender);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblPhoneNumber.setBounds(10, 317, 127, 24);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblDays.setBounds(10, 351, 127, 24);
		contentPane.add(lblDays);
		
		JLabel lblTimming = new JLabel("Timing");
		lblTimming.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblTimming.setBounds(10, 458, 95, 24);
		contentPane.add(lblTimming);
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblQualification.setBounds(10, 500, 113, 24);
		contentPane.add(lblQualification);
		
		JLabel lblField = new JLabel("Field");
		lblField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblField.setBounds(10, 570, 95, 24);
		contentPane.add(lblField);
		
		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblExperience.setBounds(10, 604, 95, 24);
		contentPane.add(lblExperience);
		
		txtdid = new JTextField();
		txtdid.setForeground(new Color(240, 128, 128));
		txtdid.setToolTipText("Enter Doctor ID");
		txtdid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtdid.setBounds(240, 29, 180, 24);
		contentPane.add(txtdid);
		txtdid.setColumns(10);
		
		txtfname = new JTextField();
		txtfname.setForeground(new Color(240, 128, 128));
		txtfname.setToolTipText("Enter First Name");
		txtfname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtfname.setColumns(10);
		txtfname.setBounds(240, 63, 180, 24);
		txtfname.addKeyListener(this);
		contentPane.add(txtfname);
		
		
		txtmname = new JTextField();
		txtmname.setForeground(new Color(240, 128, 128));
		txtmname.setToolTipText("Enter Middle Name");
		txtmname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtmname.setColumns(10);
		txtmname.setBounds(240, 97, 180, 24);
		txtmname.addKeyListener(this);
		contentPane.add(txtmname);
		
		txtlname = new JTextField();
		txtlname.setForeground(new Color(240, 128, 128));
		txtlname.setToolTipText("Enter Last Name");
		txtlname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtlname.setColumns(10);
		txtlname.setBounds(240, 131, 180, 24);
		txtlname.addKeyListener(this);
		contentPane.add(txtlname);
		
		txtaddress = new JTextArea();
		txtaddress.setForeground(new Color(240, 128, 128));
		txtaddress.setToolTipText("Enter Address");
		txtaddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtaddress.setBounds(240, 163, 180, 78);
		contentPane.add(txtaddress);
		
		txtemail = new JTextField();
		txtemail.setForeground(new Color(240, 128, 128));
		txtemail.setToolTipText("Enter Email");
		txtemail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtemail.setColumns(10);
		txtemail.setBounds(240, 249, 180, 24);
		contentPane.add(txtemail);
		
		txtphone = new JTextField();
		txtphone.setForeground(new Color(240, 128, 128));
		txtphone.setToolTipText("Enter Phone Number");
		txtphone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtphone.setColumns(10);
		txtphone.setBounds(240, 317, 180, 24);
		txtphone.addKeyListener(this);
		contentPane.add(txtphone);
		
		
		chckbxsunday = new JCheckBox("Sunday");
		chckbxsunday.setBackground(new Color(240, 230, 140));
		chckbxsunday.setForeground(new Color(240, 128, 128));
		chckbxsunday.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		chckbxsunday.setBounds(240, 353, 113, 21);
		contentPane.add(chckbxsunday);
		chckbxsunday.addItemListener(this);
		
		chckbxmonday = new JCheckBox("Monday");
		chckbxmonday.setForeground(new Color(240, 128, 128));
		chckbxmonday.setBackground(new Color(240, 230, 140));
		chckbxmonday.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		chckbxmonday.setBounds(355, 353, 127, 21);
		contentPane.add(chckbxmonday);
		chckbxsunday.addItemListener(this);
		
		chckbxtuesday = new JCheckBox("Tuesday");
		chckbxtuesday.setForeground(new Color(240, 128, 128));
		chckbxtuesday.setBackground(new Color(240, 230, 140));
		chckbxtuesday.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		chckbxtuesday.setBounds(240, 376, 113, 21);
		contentPane.add(chckbxtuesday);
		chckbxsunday.addItemListener(this);
		
		chckbxwednesday = new JCheckBox("Wednesday");
		chckbxwednesday.setForeground(new Color(240, 128, 128));
		chckbxwednesday.setBackground(new Color(240, 230, 140));
		chckbxwednesday.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		chckbxwednesday.setBounds(355, 376, 127, 21);
		contentPane.add(chckbxwednesday);
		chckbxsunday.addItemListener(this);
		
		chckbxthursday = new JCheckBox("Thursday");
		chckbxthursday.setForeground(new Color(240, 128, 128));
		chckbxthursday.setBackground(new Color(240, 230, 140));
		chckbxthursday.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		chckbxthursday.setBounds(240, 399, 113, 21);
		contentPane.add(chckbxthursday);
		chckbxsunday.addItemListener(this);
		
		chckbxfriday = new JCheckBox("Friday");
		chckbxfriday.setForeground(new Color(240, 128, 128));
		chckbxfriday.setBackground(new Color(240, 230, 140));
		chckbxfriday.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		chckbxfriday.setBounds(355, 399, 127, 21);
		contentPane.add(chckbxfriday);
		chckbxsunday.addItemListener(this);
		
		chckbxsaturday = new JCheckBox("Saturday");
		chckbxsaturday.setForeground(new Color(240, 128, 128));
		chckbxsaturday.setBackground(new Color(240, 230, 140));
		chckbxsaturday.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		chckbxsaturday.setBounds(240, 422, 113, 21);
		contentPane.add(chckbxsaturday);
		chckbxsunday.addItemListener(this);
		
		txttiming = new JTextField();
		txttiming.setForeground(new Color(240, 128, 128));
		txttiming.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txttiming.setColumns(10);
		txttiming.setBounds(240, 458, 180, 24);
		contentPane.add(txttiming);
		
		txtfield = new JTextField();
		txtfield.setForeground(new Color(240, 128, 128));
		txtfield.setBackground(new Color(255, 255, 255));
		txtfield.setToolTipText("Enter Field");
		txtfield.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtfield.setColumns(10);
		txtfield.setBounds(240, 570, 180, 24);
		contentPane.add(txtfield);
		
		txtexperience = new JTextField();
		txtexperience.setForeground(new Color(240, 128, 128));
		txtexperience.setToolTipText("Enter Experience");
		txtexperience.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtexperience.setColumns(10);
		txtexperience.setBounds(240, 604, 180, 24);
		contentPane.add(txtexperience);
		
	    txtqualification = new JTextArea();
	    txtqualification.setForeground(new Color(240, 128, 128));
		txtqualification.setToolTipText("Enter Qualification");
		txtqualification.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtqualification.setBounds(240, 492, 180, 69);
		contentPane.add(txtqualification);
		
		rbfemale = new JRadioButton("Female");
		rbfemale.setForeground(new Color(240, 128, 128));
		rbfemale.setBackground(new Color(240, 230, 140));
		gender_group.add(rbfemale);
		rbfemale.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rbfemale.setBounds(240, 285, 89, 21);
		contentPane.add(rbfemale);
		
		rbmale = new JRadioButton("Male");
		gender_group.add(rbmale);
		rbmale.setForeground(new Color(240, 128, 128));
		rbmale.setBackground(new Color(240, 230, 140));
		rbmale.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rbmale.setBounds(344, 285, 76, 21);
		contentPane.add(rbmale);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setForeground(new Color(240, 128, 128));
		btnsubmit.setBackground(new Color(240, 230, 140));
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnsubmit.setBounds(112, 656, 121, 33);
		contentPane.add(btnsubmit);
		btnsubmit.addActionListener(this);
	}
	
	
	void insertdetails()
	{
		String docid = txtdid.getText().trim();
		String fname =txtfname.getText().trim();
		String mname =txtmname.getText().trim();
		String lname =txtlname.getText().trim();
		String address =txtaddress.getText().trim();
		String email = txtemail.getText().trim();
		String phone =txtphone.getText().trim();
		String timing =txttiming.getText().trim();
		String qualification = txtqualification.getText().trim();
		String field =txtfield.getText().trim();
		String experience =txtexperience.getText().trim();
		days="";
		
		// how  to fetch value from radio button
		String status="";
		if(rbfemale.isSelected())
		{
			status=rbfemale.getText();
		}
		if(rbmale.isSelected())
		{
			status=rbmale.getText();
		}
		if(docid.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Doctor ID","MandatoryField",JOptionPane.ERROR_MESSAGE);
			
		}
		
		else  if(fname.isEmpty())
		    {
			   JOptionPane.showMessageDialog(this, "Please enter First Name","MandatoryField",JOptionPane.ERROR_MESSAGE);
		    }
		else if (address.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Address","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if(status.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please select Gender ","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if(email.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Email","MandatoryField",JOptionPane.ERROR_MESSAGE);
			
		}
		
		else  if(phone.isEmpty())
		    {
			   JOptionPane.showMessageDialog(this, "Please enter Phone Number","MandatoryField",JOptionPane.ERROR_MESSAGE);
		    }
		else if (timing.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Timing","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if(qualification.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Qualification ","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if (field.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Field","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if(experience.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Experience ","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
//		else if(days.isEmpty())
//		{
//			JOptionPane.showMessageDialog(this, "Please select Days ","MandatoryField",JOptionPane.ERROR_MESSAGE);
//		}
		else {
			
			
			PreparedStatement ps =null;//it is responsible for communication with database
			
			
			
			if(chckbxsunday.isSelected())
			{
				days=days+chckbxsunday.getText()+",";
			}
			if(chckbxmonday.isSelected())
			{
				days=days+chckbxmonday.getText()+",";
			}
			if(chckbxtuesday.isSelected())
			{
				days=days+chckbxtuesday.getText()+",";
			}
			if(chckbxwednesday.isSelected())
			{
				days=days+chckbxwednesday.getText()+",";
			}
			if(chckbxthursday.isSelected())
			{
				days=days+chckbxthursday.getText()+",";
			}
			if(chckbxfriday.isSelected())
			{
				days=days+chckbxfriday.getText()+",";
			}
			if(chckbxsaturday.isSelected())
			{
				days=days+chckbxsaturday.getText()+",";
			}
			
			String str_insert="insert into doctordetails(DoctorId, FirstName, MiddleName, LastName, Address, Email, Gender, PhoneNumber, Days, Timing, Qualification, Field, Experience) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try 
			{
				ps=con.prepareStatement(str_insert);//it passes the query to RDBMS and RDBMS compiler->compile the query and stores the query into buffer and assign the address or reference to ps
				ps.setString(1, docid);
				ps.setString(2, fname);
				ps.setString(3, mname);
				ps.setString(4, lname);
				ps.setString(5, address);
				ps.setString(6, email);
				ps.setString(7, status);
				ps.setString(8, phone);
				ps.setString(9, days);
				ps.setString(10, timing);
				ps.setString(11, qualification);
				ps.setString(12, field);
				ps.setString(13, experience);
				
				int row_status=ps.executeUpdate();//it will again  passes the query to dbms
				System.out.println("insert status "+row_status);
				if(row_status>0)
				{
					JOptionPane.showMessageDialog(this, "Doctor added successfully");
					txtdid.setText("");
					txtfname.setText("");
					txtmname.setText("");
					txtlname.setText("");
					txtaddress.setText("");
					txtemail.setText("");
					gender_group.clearSelection();
					txtphone.setText("");
					resetCheckbox();
					txttiming.setText("");
					txtqualification.setText("");
					txtfield.setText("");
					txtexperience.setText("");
					
				}
				
				
			}
			catch(SQLException se)
			{
				se.printStackTrace();
				
			}
			finally
			{
				if(ps!=null)
				{
					try 
					{
						ps.close();
					} 
					catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public AddDoctor() {
		setType(Type.UTILITY);
		setResizable(false);
		con=DbConnection.openConnection();//it will connect the frame with database->admission_db
		this.addWindowListener(this);
		createComponent();
	}
	void resetCheckbox()
	{
		chckbxsunday.setSelected(false);
		chckbxmonday.setSelected(false);
		chckbxtuesday.setSelected(false);
		chckbxwednesday.setSelected(false);
		chckbxthursday.setSelected(false);
		chckbxfriday.setSelected(false);
		chckbxsaturday.setSelected(false);
	}
	@Override
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
	/*	
		String s1="";
		
		if(e.getSource()==chckbxsunday)
		{
			if(e.getStateChange()==1)
			{
				s1="Sunday";
			}
		}
		 if(e.getSource()==chckbxmonday)
		{
			if(e.getStateChange()==1)
			{
				s1=s1+","+"Monday";
			}
		}
		 if(e.getSource()==chckbxtuesday)
		{
			if(e.getStateChange()==1)
			{
				s1=s1+","+"Tuesday";
			}
		}
		 if(e.getSource()==chckbxwednesday)
		{
			if(e.getStateChange()==1)
			{
				s1=s1+","+"Wednesday";
			}
		}
		 if(e.getSource()==chckbxthursday)
		{
			if(e.getStateChange()==1)
			{
				s1=s1+","+"Thursday";
			}
		}
		if(e.getSource()==chckbxfriday)
		{
			if(e.getStateChange()==1)
			{
				s1=s1+","+"Friday";
			}
		}
	  if (e.getSource()==chckbxmonday)
		{
			if(e.getStateChange()==1)
			{
				s1=s1+","+"Saturday";
			}
		}
		days=s1;*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		insertdetails();
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		DbConnection.closeConnection();
		System.out.println("connection is being close....");
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtphone)
		{
			char c=e.getKeyChar();
			if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
			{
				e.consume();
				JOptionPane.showMessageDialog(this,"Phone Number requiered only Numbers","MANDATORY",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		if((e.getSource()==txtfname)||(e.getSource()==txtmname)||(e.getSource()==txtlname))
		{
			char c=e.getKeyChar();
			if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(Character.isAlphabetic(c))))
			{
				e.consume();
				JOptionPane.showMessageDialog(this,"Phone Number requiered only Numbers","MANDATORY",JOptionPane.WARNING_MESSAGE);
				
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


