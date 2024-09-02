package dats.receptionist;

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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Color;

public class UpdatePatient extends JFrame implements ActionListener,WindowListener,ItemListener,KeyListener
{

	private JPanel contentPane;
	private JTextField txtpatname;
	private JTextField txtphone;
	private JTextField txtpatvisit;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePatient frame = new UpdatePatient();
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
	JComboBox cmbappno;
	
	public void fillcombo()
	{
		PreparedStatement ps=null;
		ResultSet rs=null;
		String strsql="select AppointmentNo from patient_appointment where PatientVisit=?";
		try
		{
			ps=con.prepareStatement(strsql);
			ps.setString(1, "No");
			rs=ps.executeQuery();
			while(rs.next())
			{
				String appno=rs.getString("AppointmentNo");
				cmbappno.addItem(appno);
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
	JButton btnupdate;
	public UpdatePatient() {
		setType(Type.UTILITY);
		setResizable(false);
		con=DbConnection.openConnection();
		this.addWindowListener(this);
		setTitle("Update Patient");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 333);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Appointment Number");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 26, 194, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(10, 72, 194, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Phone");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_1.setBounds(10, 120, 194, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Patient Visit Status");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1_2.setBounds(10, 170, 194, 34);
		contentPane.add(lblNewLabel_1_2);
		
		txtpatname = new JTextField();
		txtpatname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtpatname.setForeground(new Color(240, 128, 128));
		txtpatname.setEditable(false);
		txtpatname.setColumns(10);
		txtpatname.setBounds(231, 72, 173, 36);
		contentPane.add(txtpatname);
		
		txtphone = new JTextField();
		txtphone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtphone.setForeground(new Color(240, 128, 128));
		txtphone.setEditable(false);
		txtphone.setColumns(10);
		txtphone.setBounds(231, 122, 173, 36);
		contentPane.add(txtphone);
		
		txtpatvisit = new JTextField();
		txtpatvisit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtpatvisit.setForeground(new Color(240, 128, 128));
		txtpatvisit.setColumns(10);
		txtpatvisit.setBounds(231, 168, 173, 36);
		txtpatvisit.addKeyListener(this);
		contentPane.add(txtpatvisit);
		
		btnupdate = new JButton("Update");
		btnupdate.setBackground(new Color(240, 230, 140));
		btnupdate.setForeground(new Color(240, 128, 128));
		btnupdate.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnupdate.setBounds(165, 232, 120, 34);
		
		contentPane.add(btnupdate);
		btnupdate.addActionListener(this);
		
		cmbappno = new JComboBox();
		cmbappno.setForeground(new Color(240, 128, 128));
		cmbappno.setBackground(new Color(240, 230, 140));
		cmbappno.setModel(new DefaultComboBoxModel(new String[] {"--Select Appointment Number--"}));
		cmbappno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cmbappno.setBounds(231, 26, 173, 36);
		fillcombo();
		cmbappno.addItemListener(this);
		contentPane.add(cmbappno);
	}
	
	void updatepat()
	{
		
		String pvisit=txtpatvisit.getText().trim();
	
		if(pvisit.isEmpty()||cappno.equalsIgnoreCase("--Select Appointment Number--"))
		{
			JOptionPane.showMessageDialog(this,"Please fill valid data for updation.","Mandatory Fields.",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			PreparedStatement ps=null;
			String strup="update patient_appointment set PatientVisit=? where AppointmentNo=?";
			
			try
			{
				ps=con.prepareStatement(strup);
				ps.setString(1,pvisit);
				ps.setString(2,cappno);
				 
				int rowstatus=ps.executeUpdate();
				System.out.println("insert status"+rowstatus);
				if(rowstatus>0)
				{
					JOptionPane.showMessageDialog(this,"Patient status updated successfully.");
					
					txtpatname.setText("");
					txtphone.setText("");
					txtpatvisit.setText("");
					cmbappno.setSelectedIndex(0);
					
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
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
		}
	}

	String cappno;
	@Override
	public void itemStateChanged(ItemEvent e) {
		int state=e.getStateChange();
		
		if(state==1)
		{
			cappno=(String)cmbappno.getSelectedItem();
			if(cappno.equalsIgnoreCase("--Select Appointment Number--"))
			{
				JOptionPane.showMessageDialog(this,"Please select valid appointment number");
			}
			else
			{
				System.out.println(cappno);
				
				PreparedStatement ps=null;
				ResultSet rs=null;
				String strsql="select * from patient_appointment where AppointmentNo=?";
				try
				{
					ps=con.prepareStatement(strsql);
					ps.setString(1,cappno);
					rs=ps.executeQuery();
					rs.next();
					
					String name=rs.getString("PatientName");
					String phone=rs.getString("Phone");
					String visit=rs.getString("PatientVisit");
					
					txtpatname.setText(name);
					txtphone.setText(phone);
					txtpatvisit.setText(visit);
					
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
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		DbConnection.closeConnection();
		System.out.println("Connection is being closed.");
		
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
		updatepat();
		System.out.println("button is being clicked");
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtpatvisit)
		{
			char c=e.getKeyChar();
			if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_TAB)||(Character.isLetter(c))))
			{
				e.consume();
				JOptionPane.showMessageDialog(this,"Patient visit requires only alphabets","Mandatory Field",JOptionPane.WARNING_MESSAGE);
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
