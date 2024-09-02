package dats.gui;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import dats.dbutils.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.print.PrinterException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import java.awt.Window.Type;


public class DoctorIdDatewise extends JFrame implements ItemListener,ActionListener,WindowListener
{

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private JLabel lblNewLabel;
	JDateChooser dateChooser;
	JButton btnNewButton ;
	JComboBox cmbid;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorIdDatewise frame = new DoctorIdDatewise();
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
	public DoctorIdDatewise() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		con=DbConnection.openConnection();
		setTitle("Datewise");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1117, 520);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1093, 373);
		contentPane.add(scrollPane);
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();//we are getting the reference of TableHeader
		header.setBackground(new Color(240, 230, 140));
		header.setForeground(new Color(200, 135, 135));
		header.setFont(new Font("Times New Roman",Font.PLAIN,20));		
		table.setForeground(new Color(240, 128, 128));
		table.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(121, 34, 107, 25);
		contentPane.add(lblNewLabel);
		
		
		JButton btnprint = new JButton("Print");
		btnprint.setBackground(new Color(240, 230, 140));
		btnprint.setForeground(new Color(240, 128, 128));
		btnprint.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnprint.setBounds(1004, 10, 89, 25);
		contentPane.add(btnprint);
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(240, 128, 128));
		dateChooser.setBackground(new Color(240, 230, 140));
		dateChooser.setBounds(254, 34, 144, 25);
		contentPane.add(dateChooser);
		
		
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setForeground(new Color(240, 128, 128));
		btnsearch.setBackground(new Color(240, 230, 140));
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnsearch.setBounds(864, 34, 107, 25);
		contentPane.add(btnsearch);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDoctorId.setBounds(451, 34, 128, 25);
		contentPane.add(lblDoctorId);
		
		cmbid = new JComboBox();
		cmbid.setForeground(new Color(240, 128, 128));
		cmbid.setBackground(new Color(240, 230, 140));
		cmbid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cmbid.setBounds(609, 34, 151, 25);
		cmbid.setModel(new DefaultComboBoxModel(new String[] {"---Select---"}));
		contentPane.add(cmbid);
		fillCombo();
		cmbid.addItemListener(this);
		btnsearch.addActionListener(this);
		
		btnprint.addActionListener(this);
		
	}
/*	public void showDetails() 
	{
		PreparedStatement ps1=null;
		ResultSet rs1=null;
		String strsearch="select* from patient_appointment where AppointmentDate=? and DoctorId=?";
		try 
		{
			ps1=con.prepareStatement(strsearch);
			ps1.setDate(1,sd);
			ps1.setString(2,DocID);
			
			rs1=ps1.executeQuery();
			
			rs1.next();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs1));
			
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
				if(ps1!=null)
					ps1.close();
				if(rs1!=null)
					rs1.close();
			} 
			catch (SQLException se) 
			{
			    se.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	*/
	
			
	java.sql.Date sd;

	@Override
	public void actionPerformed(ActionEvent ae) {
		java.util.Date d=dateChooser.getDate();
		//System.out.println(d);
	    sd= new Date(d.getTime());// long value
		System.out.println(sd);
		
		
		String caption = ae.getActionCommand();
		switch(caption)
		{
		case "Print":
		{
			try {
				table.print();
				
			} catch (PrinterException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		
			break;
		}
		case "Search":
		{
			PreparedStatement ps=null;
			ResultSet rs=null;
			String strsql="select* from patient_appointment where AppointmentDate=? and DoctorId=?";
			try 
			{
				ps=con.prepareStatement(strsql);
				ps.setDate(1,sd);
				ps.setString(2,DocID);
				
				rs=ps.executeQuery();
				
				if(!(rs==null))
				{
				while(rs.next())
				
				{
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}
				}
				else 
				{
					System.out.println("No data fetched");
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
				} 
				catch (SQLException se) 
				{
				    se.printStackTrace();
					// TODO: handle exception
				}
			}
			break;
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
				String id=rs.getString("DoctorId");
				//System.out.println(name);
				cmbid.addItem(id);//add data into combo box
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
	String DocID;


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
         int state =e.getStateChange();
		
		
		if (state ==1)
		{
			DocID=(String)cmbid.getSelectedItem();//fetch the value from combo box
			if(DocID.equalsIgnoreCase("---Select---"))
			{
				JOptionPane.showMessageDialog(this, "please enter valid course");
			}
			//type cast with string because we have added string items
			
			else
			{
			System.out.println(DocID);
		    PreparedStatement ps=null;
    		ResultSet rs=null;
    		String strsearch="select*from patient_appointment where DoctorID=? and AppointmentDate=?";
    		 
    		try
    		{
    			ps=con.prepareStatement(strsearch);
    			ps.setString(1,DocID);
    			ps.setDate(2,sd);

    			
    			rs=ps.executeQuery();
    			while(rs.next())
    			{
    				
    			table.setModel(DbUtils.resultSetToTableModel(rs));
    				
    			}
    			

    				}
    		
    		catch (SQLException se) 
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
    			catch (SQLException se) 
    			{
					
    				se.printStackTrace();
				}
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
		// TODO Auto-generated method stub
		DbConnection.closeConnection();
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
}
