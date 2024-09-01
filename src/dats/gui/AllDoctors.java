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
import java.awt.print.PrinterException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Window.Type;

public class AllDoctors extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTable table;
	private Connection con;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllDoctors frame = new AllDoctors();
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
	public AllDoctors() 
	{
		setType(Type.UTILITY);
		setResizable(false);
		con=DbConnection.openConnection();
		setTitle("All available courses");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1117, 531);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 100, 1083, 325);
		contentPane.add(scrollPane);
		
		table = new JTable();
		JTableHeader header = table.getTableHeader();//we are getting the reference of TableHeader
		header.setBackground(new Color(240, 230, 140));
		header.setForeground(new Color(200, 135, 135));
		header.setFont(new Font("Times New Roman",Font.PLAIN,20));
		table.setForeground(new Color(240, 128, 128));
		table.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		showDetails();
		scrollPane.setViewportView(table);
		
		
		JButton btnprint = new JButton("Print");
		btnprint.setForeground(new Color(240, 128, 128));
		btnprint.setBackground(new Color(240, 230, 140));
		btnprint.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnprint.setBounds(821, 10, 89, 25);
		contentPane.add(btnprint);
		btnprint.addActionListener(this);
		
	}
	public void showDetails() 
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		String strsql="select* from doctordetails";
		try 
		{
			ps=con.prepareStatement(strsql);
			
			
			rs=ps.executeQuery();
			
			rs.next();
			
			
			table.setModel(DbUtils.resultSetToTableModel(rs));
			

		/*	try {
				table.print();
				
			} catch (PrinterException e) {
				// TODO: handle exception
				e.printStackTrace();
			}*/

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
	
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		try {
			table.print();
			
		} catch (PrinterException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
