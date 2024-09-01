package dats.manager;

import java.awt.BorderLayout;
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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Window.Type;

public class UpdateDoctor extends JFrame implements ActionListener,WindowListener,ItemListener,KeyListener
{

	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txttiming;
	private JTextField txtqualification;
	private JTextField txtfield;
	private JTextField txtexperience;
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
					UpdateDoctor frame = new UpdateDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	void updatedetails()
	{
		
		
		String address =txtaddress.getText().trim();
		String email = txtemail.getText().trim();
		String phone =txtphone.getText().trim();
		String timing =txttiming.getText().trim();
		String qualification = txtqualification.getText().trim();
		String field =txtfield.getText().trim();
		String experience =txtexperience.getText().trim();
		days=txtdays.getText().trim();
		
		
		if (address.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Address","MandatoryField",JOptionPane.ERROR_MESSAGE);
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
		else if(days.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please enter Days ","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else {
			
			
			PreparedStatement ps =null;//it is responsible for communication with database
			
			
			
		
			
			String strupdate="update doctordetails set Address=?,Email=?, PhoneNumber=?, Days=?, Timing=?, Qualification=?, Field=?, Experience =?where DoctorId=?";
			
			try 
			{
				ps=con.prepareStatement(strupdate);//it passes the query to RDBMS and RDBMS compiler->compile the query and stores the query into buffer and assign the address or reference to ps
				
				ps.setString(1, address);
				ps.setString(2, email);
				ps.setString(3, phone);
				ps.setString(4, days);
				ps.setString(5, timing);
				ps.setString(6, qualification);
				ps.setString(7, field);
				ps.setString(8, experience);
				ps.setString(9, DocID);
				
				int row_status=ps.executeUpdate();//it will again  passes the query to dbms
				System.out.println("insert status "+row_status);
				if(row_status>0)
				{
					JOptionPane.showMessageDialog(this, "Doctor details updated successfully");
					
					txtaddress.setText("");
					txtemail.setText("");
					
					txtphone.setText("");
					txtdays.setText("");
					txttiming.setText("");
					txtqualification.setText("");
					txtfield.setText("");
					txtexperience.setText("");
					cmbid.setSelectedIndex(0);
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
			setTitle("Update Doctor Details");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 545, 600);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(244, 164, 96));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setLocationRelativeTo(null);
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Doctor ID");
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblNewLabel.setBounds(33, 29, 133, 24);
			contentPane.add(lblNewLabel);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblAddress.setBounds(33, 168, 133, 24);
			contentPane.add(lblAddress);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblEmail.setBounds(33, 261, 133, 24);
			contentPane.add(lblEmail);
			
			JLabel lblPhoneNumber = new JLabel("Phone Number");
			lblPhoneNumber.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblPhoneNumber.setBounds(33, 295, 133, 24);
			contentPane.add(lblPhoneNumber);
			
			JLabel lblDays = new JLabel("Days");
			lblDays.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblDays.setBounds(33, 329, 133, 24);
			contentPane.add(lblDays);
			
			JLabel lblTiming = new JLabel("Timing");
			lblTiming.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblTiming.setBounds(33, 363, 133, 24);
			contentPane.add(lblTiming);
			
			JLabel lblQualification = new JLabel("Qualification");
			lblQualification.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblQualification.setBounds(33, 391, 133, 24);
			contentPane.add(lblQualification);
			
			JLabel lblField = new JLabel("Field");
			lblField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblField.setBounds(33, 425, 133, 24);
			contentPane.add(lblField);
			
			JLabel lblExperience = new JLabel("Experience");
			lblExperience.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblExperience.setBounds(33, 459, 133, 24);
			contentPane.add(lblExperience);
			
			JButton btnupdate = new JButton("Update");
			btnupdate.setBackground(new Color(240, 230, 140));
			btnupdate.setForeground(new Color(240, 128, 128));
			btnupdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			btnupdate.setBounds(163, 506, 121, 33);
			contentPane.add(btnupdate);
			btnupdate.addActionListener(this);
			
			cmbid = new JComboBox();
			cmbid.setBackground(new Color(240, 230, 140));
			cmbid.setForeground(new Color(240, 128, 128));
			cmbid.setModel(new DefaultComboBoxModel(new String[] {"---Select---"}));
			cmbid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			cmbid.setBounds(200, 29, 287, 24);
			fillCombo();
			contentPane.add(cmbid);
			cmbid.addItemListener(this);
			
			txtaddress = new JTextArea();
			txtaddress.setForeground(new Color(240, 128, 128));
			txtaddress.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtaddress.setBounds(200, 166, 287, 82);
			contentPane.add(txtaddress);
			
			txtemail = new JTextField();
			txtemail.setForeground(new Color(240, 128, 128));
			txtemail.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtemail.setToolTipText("Enter Email");
			txtemail.setBounds(200, 261, 287, 24);
			contentPane.add(txtemail);
			txtemail.setColumns(10);
			
			txtphone = new JTextField();
			txtphone.setForeground(new Color(240, 128, 128));
			txtphone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtphone.setToolTipText("Enter Phone Number");
			txtphone.setColumns(10);
			txtphone.setBounds(200, 295, 287, 24);
			contentPane.add(txtphone);
			txtphone.addKeyListener(this);
			
			txttiming = new JTextField();
			txttiming.setForeground(new Color(240, 128, 128));
			txttiming.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txttiming.setToolTipText("Enter Timing");
			txttiming.setColumns(10);
			txttiming.setBounds(200, 363, 287, 24);
			contentPane.add(txttiming);
			
			txtqualification = new JTextField();
			txtqualification.setForeground(new Color(240, 128, 128));
			txtqualification.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtqualification.setToolTipText("Enter Qualification");
			txtqualification.setColumns(10);
			txtqualification.setBounds(200, 397, 287, 24);
			contentPane.add(txtqualification);
			
			txtfield = new JTextField();
			txtfield.setForeground(new Color(240, 128, 128));
			txtfield.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtfield.setToolTipText("Enter Field");
			txtfield.setColumns(10);
			txtfield.setBounds(200, 431, 287, 24);
			contentPane.add(txtfield);
			
			txtexperience = new JTextField();
			txtexperience.setForeground(new Color(240, 128, 128));
			txtexperience.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtexperience.setToolTipText("Enter Experience");
			txtexperience.setColumns(10);
			txtexperience.setBounds(200, 465, 287, 24);
			contentPane.add(txtexperience);
			
			txtdays = new JTextField();
			txtdays.setForeground(new Color(240, 128, 128));
			txtdays.setToolTipText("Enter Phone Number");
			txtdays.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtdays.setColumns(10);
			txtdays.setBounds(200, 329, 287, 24);
			contentPane.add(txtdays);
			
			txtfname = new JTextField();
			txtfname.setForeground(new Color(240, 128, 128));
			txtfname.setEditable(false);
			txtfname.setToolTipText("Enter Email");
			txtfname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtfname.setColumns(10);
			txtfname.setBounds(200, 63, 287, 24);
			contentPane.add(txtfname);
			
			txtmname = new JTextField();
			txtmname.setForeground(new Color(240, 128, 128));
			txtmname.setEditable(false);
			txtmname.setToolTipText("Enter Email");
			txtmname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtmname.setColumns(10);
			txtmname.setBounds(200, 97, 287, 24);
			contentPane.add(txtmname);
			
			txtlname = new JTextField();
			txtlname.setForeground(new Color(240, 128, 128));
			txtlname.setEditable(false);
			txtlname.setToolTipText("Enter Email");
			txtlname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			txtlname.setColumns(10);
			txtlname.setBounds(200, 131, 287, 24);
			contentPane.add(txtlname);
			
			JLabel lblFirstName = new JLabel("First Name");
			lblFirstName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblFirstName.setBounds(33, 66, 133, 24);
			contentPane.add(lblFirstName);
			
			JLabel lblMiddleName = new JLabel("Middle Name");
			lblMiddleName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblMiddleName.setBounds(33, 100, 133, 24);
			contentPane.add(lblMiddleName);
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			lblLastName.setBounds(32, 134, 121, 24);
			contentPane.add(lblLastName);
			txtdays.addKeyListener(this);
			
		}
	}


	/**
	 * Create the frame.
	 */
	public UpdateDoctor() {
		setType(Type.UTILITY);
		setResizable(false);
		con=DbConnection.openConnection();//it will connect the frame with database->admission_db
		this.addWindowListener(this);
		createComponent();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		updatedetails();
		
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
	private JTextField txtdays;
	private JTextField txtfname;
	private JTextField txtmname;
	private JTextField txtlname;;
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
		if((e.getSource()==txtdays))
		{
			char c=e.getKeyChar();
			if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_ENTER)||(c==KeyEvent.VK_TAB)||(c==KeyEvent.VK_COMMA)||(Character.isAlphabetic(c))))
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
