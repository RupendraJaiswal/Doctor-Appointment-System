
package dats.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.dbutils.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Window.Type;

public class DoctorDetails extends JFrame implements WindowListener,ItemListener
{

	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField txtphone,txtfname,txtmname,txtlname;
	private JTextField txttiming;
	private JTextField txtqualification;
	private JTextField txtfield;
	private JTextField txtexperience;
	private JTextField txtdays;
	private JTextField txtgender;;
	private Connection con;
	JComboBox cmbid;
	JTextArea txtaddress;
	String days;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorDetails frame = new DoctorDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillCombo()
	{
		PreparedStatement ps=null;
		ResultSet rs=null;//it will hold the reference of the resultant data return by select query
		String strsql="select DoctorId from doctordetails";
		try
		{
			ps=con.prepareStatement(strsql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("DoctorId");
				//System.out.println(name);
				cmbid.addItem(name);//add data into combo box
			}
		} 
		catch (SQLException se) 
		{
			// TODO: handle exception
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
			} catch (SQLException se) 
			{
				// TODO: handle exception
				se.printStackTrace();
			}
		}
		
	}
	void createComponent()
	{
		{
			setTitle(" Doctor Details");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 569, 602);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(244, 164, 96));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setLocationRelativeTo(null);
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Doctor ID");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(33, 29, 100, 24);
			contentPane.add(lblNewLabel);
			
			JLabel lblFirstName = new JLabel("First Name");
			lblFirstName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblFirstName.setBounds(33, 73, 95, 24);
			contentPane.add(lblFirstName);
			
			JLabel lblMiddleName = new JLabel("Middle Name");
			lblMiddleName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblMiddleName.setBounds(33, 107, 113, 24);
			contentPane.add(lblMiddleName);
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblLastName.setBounds(33, 141, 95, 24);
			contentPane.add(lblLastName);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblAddress.setBounds(33, 175, 100, 24);
			contentPane.add(lblAddress);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblEmail.setBounds(33, 265, 100, 24);
			contentPane.add(lblEmail);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblPhoneNumber.setBounds(33, 333, 133, 24);
			contentPane.add(lblPhoneNumber);
			
			JLabel lblDays = new JLabel("Days");
			lblDays.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblDays.setBounds(33, 367, 100, 24);
			contentPane.add(lblDays);
			
			JLabel lblTiming = new JLabel("Timing");
			lblTiming.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblTiming.setBounds(33, 401, 100, 24);
			contentPane.add(lblTiming);
			
			JLabel lblQualification = new JLabel("Qualification");
			lblQualification.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblQualification.setBounds(33, 435, 121, 24);
			contentPane.add(lblQualification);
			
			JLabel lblField = new JLabel("Field");
			lblField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblField.setBounds(33, 469, 100, 24);
			contentPane.add(lblField);
			
			JLabel lblExperience = new JLabel("Experience");
			lblExperience.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblExperience.setBounds(33, 503, 100, 24);
			contentPane.add(lblExperience);
			
			
			cmbid = new JComboBox();
			cmbid.setBackground(new Color(240, 230, 140));
			cmbid.setForeground(new Color(240, 128, 128));
			cmbid.setModel(new DefaultComboBoxModel(new String[] {"---Select---"}));
			cmbid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			cmbid.setBounds(219, 29, 287, 24);
			fillCombo();
			contentPane.add(cmbid);
			cmbid.addItemListener(this);
			
			txtfname = new JTextField();
			txtfname.setForeground(new Color(240, 128, 128));
			txtfname.setEditable(false);
			txtfname.setToolTipText("");
			txtfname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtfname.setColumns(10);
			txtfname.setBounds(219, 73, 287, 24);
			contentPane.add(txtfname);
			
			txtmname = new JTextField();
			txtmname.setForeground(new Color(240, 128, 128));
			txtmname.setEditable(false);
			txtmname.setToolTipText("");
			txtmname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtmname.setColumns(10);
			txtmname.setBounds(219, 107, 287, 24);
			contentPane.add(txtmname);
			
			txtlname = new JTextField();
			txtlname.setForeground(new Color(240, 128, 128));
			txtlname.setEditable(false);
			txtlname.setToolTipText("");
			txtlname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtlname.setColumns(10);
			txtlname.setBounds(219, 141, 287, 24);
			contentPane.add(txtlname);
			
			txtaddress = new JTextArea();
			txtaddress.setForeground(new Color(240, 128, 128));
			txtaddress.setEditable(false);
			txtaddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtaddress.setBounds(219, 173, 287, 75);
			contentPane.add(txtaddress);
			
			txtemail = new JTextField();
			txtemail.setForeground(new Color(240, 128, 128));
			txtemail.setEditable(false);
			txtemail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtemail.setToolTipText("");
			txtemail.setBounds(219, 265, 287, 24);
			contentPane.add(txtemail);
			txtemail.setColumns(10);
			
			txtphone = new JTextField();
			txtphone.setForeground(new Color(240, 128, 128));
			txtphone.setEditable(false);
			txtphone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtphone.setToolTipText("");
			txtphone.setColumns(10);
			txtphone.setBounds(219, 333, 287, 24);
			contentPane.add(txtphone);
			
			txttiming = new JTextField();
			txttiming.setForeground(new Color(240, 128, 128));
			txttiming.setEditable(false);
			txttiming.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txttiming.setToolTipText("");
			txttiming.setColumns(10);
			txttiming.setBounds(219, 401, 287, 24);
			contentPane.add(txttiming);
			
			txtqualification = new JTextField();
			txtqualification.setForeground(new Color(240, 128, 128));
			txtqualification.setEditable(false);
			txtqualification.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtqualification.setToolTipText("");
			txtqualification.setColumns(10);
			txtqualification.setBounds(219, 435, 287, 24);
			contentPane.add(txtqualification);
			
			txtfield = new JTextField();
			txtfield.setForeground(new Color(240, 128, 128));
			txtfield.setEditable(false);
			txtfield.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtfield.setToolTipText("");
			txtfield.setColumns(10);
			txtfield.setBounds(219, 469, 287, 24);
			contentPane.add(txtfield);
			
			txtexperience = new JTextField();
			txtexperience.setForeground(new Color(240, 128, 128));
			txtexperience.setEditable(false);
			txtexperience.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtexperience.setToolTipText("");
			txtexperience.setColumns(10);
			txtexperience.setBounds(219, 503, 287, 24);
			contentPane.add(txtexperience);
			
			txtdays = new JTextField();
			txtdays.setForeground(new Color(240, 128, 128));
			txtdays.setEditable(false);
			txtdays.setToolTipText("");
			txtdays.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtdays.setColumns(10);
			txtdays.setBounds(219, 367, 287, 24);
			contentPane.add(txtdays);
			
			JLabel lblGender = new JLabel("Gender");
			lblGender.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblGender.setBounds(33, 299, 100, 24);
			contentPane.add(lblGender);
			
			txtgender = new JTextField();
			txtgender.setForeground(new Color(240, 128, 128));
			txtgender.setToolTipText("");
			txtgender.setFont(new Font("Times New Roman", Font.PLAIN, 20));
			txtgender.setEditable(false);
			txtgender.setColumns(10);
			txtgender.setBounds(219, 299, 287, 24);
			contentPane.add(txtgender);
			
		}
	}


	/**
	 * Create the frame.
	 */
	public  DoctorDetails() {
		setType(Type.UTILITY);
		setResizable(false);
		con=DbConnection.openConnection();//it will connect the frame with database->admission_db
		this.addWindowListener(this);
		createComponent();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
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
	String DocID,Days="";
	
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		
		int state =e.getStateChange();
		
		
		if (state ==1)
		{
			DocID=(String)cmbid.getSelectedItem();//fetch the value from combo box
			if(DocID.equalsIgnoreCase("---Select Course---"))
			{
				JOptionPane.showMessageDialog(this, "please enter valid course");
			}
			//type cast with string because we have added string items
			
			else
			{
			System.out.println(DocID);
		    PreparedStatement ps=null;
    		ResultSet rs=null;
    		String strsearch="select*from doctordetails where DoctorID=?";
    		try 
    		{
    			ps=con.prepareStatement(strsearch);
    			ps.setString(1,DocID);
    			
    			rs=ps.executeQuery();
    			
    			rs.next();// it will move the cursor inside the dataset 
    			String fname =rs.getString("FirstName");
    			String mname =rs.getString("MiddleName");
    			String lname =rs.getString("LastName");
    			String address =rs.getString("Address");
    			String email=rs.getString("Email");
    			String gender =rs.getString("Gender");
    			String phone =rs.getString("PhoneNumber");
    			String days =rs.getString("Days");
    			String timing=rs.getString("Timing");
    			String qualification=rs.getString("Qualification");
    			String field=rs.getString("Field");
    			String experience=rs.getString("Experience");
    			
    			txtfname.setText(fname);
    			txtmname.setText(mname);
    			txtlname.setText(lname);
    			txtaddress.setText(address);
    			txtemail.setText(email);
    			txtgender.setText(gender);
    			txtphone.setText(phone);
    			txtdays.setText(days);
    			txttiming.setText(timing);
    			txtqualification.setText(qualification);
    			txtfield.setText(field);
    			txtexperience.setText(experience);
    			



    			
				
			} 
    		catch (SQLException se) 
    		{
				// TODO: handle exception
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
    			catch (SQLException se) 
    			{
					// TODO: handle exception
    				se.printStackTrace();
				}
    		}
    		
    	
			}
			}
			
		}
}

