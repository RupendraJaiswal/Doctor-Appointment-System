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

import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.Window.Type;
import java.awt.Toolkit;



public class Datewise extends JFrame implements ItemListener,ActionListener,WindowListener
{

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	private JLabel lblNewLabel;
	JDateChooser dateChooser;
	JButton btnNewButton ;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Datewise frame = new Datewise();
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
	public Datewise() 
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
		scrollPane.setBackground(new Color(244, 164, 96));
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
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(121, 34, 107, 25);
		contentPane.add(lblNewLabel);
		
		
		JButton btnprint = new JButton("Print");
		btnprint.setForeground(new Color(240, 128, 128));
		btnprint.setBackground(new Color(240, 230, 140));
		btnprint.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnprint.setBounds(1004, 10, 89, 25);
		contentPane.add(btnprint);
		btnprint.addActionListener(this);
		
		dateChooser = new JDateChooser();
		dateChooser.setForeground(new Color(240, 128, 128));
		dateChooser.setBackground(new Color(240, 230, 140));
		dateChooser.setBounds(254, 34, 144, 25);
		contentPane.add(dateChooser);
		
		
		
		JButton btnsearch = new JButton("Search");
		btnsearch.setBackground(new Color(240, 230, 140));
		btnsearch.setForeground(new Color(240, 128, 128));
		btnsearch.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnsearch.setBounds(451, 34, 107, 25);
		contentPane.add(btnsearch);
		btnsearch.addActionListener(this);
		
	
		
	}
	public void showDetails() 
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		String strsql="select* from patient_appointment where AppointmentDate=?";
		try 
		{
			ps=con.prepareStatement(strsql);
			ps.setDate(1, sd);
			
			
			rs=ps.executeQuery();
			
			rs.next();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
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
	}
	
	
	
			
	java.sql.Date sd;

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		java.util.Date d=dateChooser.getDate();
		//System.out.println(d);
	    sd= new Date(d.getTime());// long value
		System.out.println(sd);
		//showCourses();
		
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
			System.out.println("Button is being clicked");
			PreparedStatement ps=null;
			ResultSet rs=null;
			String strsql="select * from patient_appointment where AppointmentDate=?";
			try 
			{
				ps=con.prepareStatement(strsql);
				ps.setDate(1,sd);
				
				
				rs=ps.executeQuery();
				
				while(rs.next())
				{
				table.setModel(DbUtils.resultSetToTableModel(rs));
				showDetails();
				
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
		
		//showDetails();
}

	@Override
	public void itemStateChanged(ItemEvent e) {
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
		System.out.println("Connection is being closed");
		
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
