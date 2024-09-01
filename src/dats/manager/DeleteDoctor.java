package dats.manager;
import java.awt.BorderLayout;
import java.sql.*;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.dbutils.DbConnection;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DeleteDoctor extends JFrame implements ActionListener,KeyListener,WindowListener,ItemListener
{

	private JPanel contentPane;
	private Connection con;
	private JTextField txtfname;
	private JTextField txtmname;
	private JTextField txtlname;
	private JTextField txtfield;
	JComboBox cmbid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDoctor frame = new DeleteDoctor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
      void delete()
      {
    	this.addWindowListener(this);
  		setTitle("Delete Course");
  		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  		setBounds(100, 100, 474, 381);
  		contentPane = new JPanel();
  		contentPane.setBackground(new Color(244, 164, 96));
  		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
  		setLocationRelativeTo(null);//to do child screen in center
  		setContentPane(contentPane);
  		contentPane.setLayout(null);
  		
  		JLabel lblcn = new JLabel("Doctor ID");
  		lblcn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		lblcn.setForeground(Color.BLACK);
  		lblcn.setBounds(31, 20, 129, 36);
  		contentPane.add(lblcn);
  		
  		JButton btndelete = new JButton("Delete");
  		btndelete.setBackground(new Color(240, 230, 140));
  		btndelete.setForeground(new Color(240, 128, 128));
  		btndelete.setIcon(null);
  		btndelete.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		btndelete.setBounds(93, 263, 129, 42);
  		contentPane.add(btndelete);
  		
  		cmbid = new JComboBox();
  		cmbid.setForeground(new Color(240, 128, 128));
  		cmbid.setBackground(new Color(240, 230, 140));
  		cmbid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		cmbid.setModel(new DefaultComboBoxModel(new String[] {"--Select--"}));
  		cmbid.setBounds(190, 23, 217, 31);
  		fillCombo();
  		cmbid.addItemListener(this);
  		contentPane.add(cmbid);
  		
  		JLabel lblFirstName = new JLabel("First Name");
  		lblFirstName.setForeground(Color.BLACK);
  		lblFirstName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		lblFirstName.setBounds(31, 66, 129, 36);
  		contentPane.add(lblFirstName);
  		
  		JLabel lblMiddlename = new JLabel("MiddleName");
  		lblMiddlename.setForeground(Color.BLACK);
  		lblMiddlename.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		lblMiddlename.setBounds(31, 112, 129, 36);
  		contentPane.add(lblMiddlename);
  		
  		JLabel lblLastName = new JLabel("Last Name");
  		lblLastName.setForeground(Color.BLACK);
  		lblLastName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		lblLastName.setBounds(31, 158, 129, 36);
  		contentPane.add(lblLastName);
  		
  		JLabel lblField = new JLabel("Field");
  		lblField.setForeground(Color.BLACK);
  		lblField.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		lblField.setBounds(31, 204, 129, 36);
  		contentPane.add(lblField);
  		
  		txtfname = new JTextField();
  		txtfname.setForeground(new Color(240, 128, 128));
  		txtfname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		txtfname.setEditable(false);
  		txtfname.setBounds(190, 64, 217, 36);
  		contentPane.add(txtfname);
  		txtfname.setColumns(10);
  		
  		txtmname = new JTextField();
  		txtmname.setForeground(new Color(240, 128, 128));
  		txtmname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		txtmname.setEditable(false);
  		txtmname.setColumns(10);
  		txtmname.setBounds(190, 112, 217, 36);
  		contentPane.add(txtmname);
  		
  		txtlname = new JTextField();
  		txtlname.setForeground(new Color(240, 128, 128));
  		txtlname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		txtlname.setEditable(false);
  		txtlname.setColumns(10);
  		txtlname.setBounds(190, 158, 217, 36);
  		contentPane.add(txtlname);
  		
  		txtfield = new JTextField();
  		txtfield.setForeground(new Color(240, 128, 128));
  		txtfield.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
  		txtfield.setEditable(false);
  		txtfield.setColumns(10);
  		txtfield.setBounds(190, 204, 217, 36);
  		contentPane.add(txtfield);
  		btndelete.addActionListener(this);
  		btndelete.addKeyListener(this);

      }
	/**
	 * Create the frame.
	 */
	public DeleteDoctor() //constructor
	{
		con=DbConnection.openConnection();//it will connect the frame with database->admission_db
		delete();
	}
    String DocID;
	void deletecourse()
	{
		DocID=(String)cmbid.getSelectedItem();//fetch the value from combo box
		if(DocID.equalsIgnoreCase("--Select Course--"))
		{
			JOptionPane.showMessageDialog(this, "please enter valid course");
		}
		//type cast with string because we have added string items
		
		else
		{ 
			
			int choice=JOptionPane.showConfirmDialog(this, "Are you sure wish to delete"+DocID);
			//System.out.println(choice);
			PreparedStatement ps =null;//it is responsible for communication with database
			String str_delete="delete from doctordetails where DoctorID=?";
			if(choice==0)
			{
			try
			{
				ps=con.prepareStatement(str_delete);
				ps.setString(1, DocID);
				int row_status=ps.executeUpdate();
				if(row_status>0)
				{
					JOptionPane.showMessageDialog(this, "Doctor deleted successfully","deletion",JOptionPane.PLAIN_MESSAGE);
				   
				   
				    if(cmbid.getSelectedIndex()>-1)
				    {
				    	
				    	cmbid.removeItemAt(cmbid.getSelectedIndex());//to remove value from combobox which is deleted
				    	 txtfname.setText("");
						 txtmname.setText("");
						 txtlname.setText("");
						 txtfield.setText("");
				    	cmbid.setSelectedIndex(0);//to set the combobox at initial index 
				  
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "No such doctor present","Unavailability",JOptionPane.ERROR_MESSAGE);
				}
			}
			}
			catch (SQLException se) 
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
						
						e.printStackTrace();
					}
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
				String DID=rs.getString("DoctorId");
//				String fname=rs.getString("FirstName");
//				String mname=rs.getString("MiddleName");
//				String lname=rs.getString("LastName");
//				String field=rs.getString("Field);
				cmbid.addItem(DID);//add data into combo box
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	     deletecourse();
	    // System.out.println("button is being clicked");
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();//it return the AScII Value
		//System.out.println(code);
		if(code==10)//enter key code is 10
		{
			deletecourse();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
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
		System.out.println("connection is being closing....");
		
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
	public void itemStateChanged(ItemEvent e) 
	{
		// TODO Auto-generated method stub
		
		int state =e.getStateChange();
		
		String DocID;
		if (state ==1)
		{
			DocID=(String)cmbid.getSelectedItem();//fetch the value from combo box
			if(DocID.equalsIgnoreCase("--Select Course--"))
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
    			String mname=rs.getString("MiddleName");
    			String lname =rs.getString("LastName");
    			String field=rs.getString("Field");
    			    			
    			txtfname.setText(fname);
    			txtmname.setText(mname);
    			txtlname.setText(lname);
    			txtfield.setText(field);
    			
    		
				
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
