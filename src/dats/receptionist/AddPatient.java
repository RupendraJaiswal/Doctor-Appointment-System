package dats.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dats.dbutils.DbConnection;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

public class AddPatient extends JFrame implements ActionListener,WindowListener,ItemListener,KeyListener
{

	private JPanel contentPane;
	private JTextField txtappno;
	private JTextField txtpatientname;
	private JTextField txtage;
	private JTextField txtproblem;
	private JTextField txtphone;
	private final ButtonGroup visit_group = new ButtonGroup();
	private final ButtonGroup appmode_group = new ButtonGroup();
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient frame = new AddPatient();
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
	JDateChooser txtdate,txtappdate;
	JRadioButton rdyes,rdno,rdphone,rdwalk;
	JComboBox cmbdocid;
	
	public AddPatient() {
		setType(Type.UTILITY);
		setResizable(false);
		setTitle("Add Patient");
		con=DbConnection.openConnection();
		this.addWindowListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(244, 164, 96));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(33, 122, 160, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Appointment Date");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setBounds(33, 165, 160, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Appoinment No");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setBounds(33, 79, 160, 33);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Doctor ID");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(33, 208, 160, 33);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Patient Name");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(33, 251, 160, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Age");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setBounds(33, 294, 160, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Problem");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_7.setBounds(33, 337, 160, 33);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Appontment Mode");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_8.setBounds(33, 380, 160, 33);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Patient Visit");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_9.setBounds(33, 423, 160, 33);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Phone");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_10.setBounds(33, 466, 160, 33);
		contentPane.add(lblNewLabel_10);
		
		JButton btnsubmit = new JButton("Submit");
		btnsubmit.setForeground(new Color(240, 128, 128));
		btnsubmit.setBackground(new Color(240, 230, 140));
		btnsubmit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		btnsubmit.setBounds(171, 517, 125, 36);
		btnsubmit.addActionListener(this);
		contentPane.add(btnsubmit);
		
		txtappno = new JTextField();
		txtappno.setForeground(new Color(240, 128, 128));
		txtappno.setBackground(new Color(255, 255, 255));
		txtappno.setEditable(false);
		txtappno.setToolTipText("Please Enter Patient Appointment Number.");
		txtappno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtappno.setColumns(10);
		txtappno.setBounds(220, 79, 180, 33);
		contentPane.add(txtappno);
		
		txtpatientname = new JTextField();
		txtpatientname.setForeground(new Color(240, 128, 128));
		txtpatientname.setToolTipText("Please Enter Patient Name.");
		txtpatientname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtpatientname.setColumns(10);
		txtpatientname.setBounds(220, 260, 180, 33);
		txtpatientname.addKeyListener(this);
		contentPane.add(txtpatientname);
		
		txtage = new JTextField();
		txtage.setForeground(new Color(240, 128, 128));
		txtage.setToolTipText("Please Enter Patient Age.");
		txtage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtage.setColumns(10);
		txtage.setBounds(220, 303, 180, 33);
		txtage.addKeyListener(this);
		contentPane.add(txtage);
		
		txtproblem = new JTextField();
		txtproblem.setForeground(new Color(240, 128, 128));
		txtproblem.setToolTipText("Please Enter Patient Problem.");
		txtproblem.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtproblem.setColumns(10);
		txtproblem.setBounds(220, 346, 180, 33);
		contentPane.add(txtproblem);
		
		txtphone = new JTextField();
		txtphone.setForeground(new Color(240, 128, 128));
		txtphone.setToolTipText("Please Enter Patient Phone Number.");
		txtphone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		txtphone.setColumns(10);
		txtphone.setBounds(220, 466, 180, 33);
		txtphone.addKeyListener(this);
		contentPane.add(txtphone);
		
		txtdate = new JDateChooser();
		txtdate.setForeground(new Color(240, 128, 128));
		txtdate.setBackground(new Color(255, 255, 255));
		txtdate.setBounds(220, 130, 180, 33);
		contentPane.add(txtdate);
		
		txtappdate = new JDateChooser();
		txtappdate.setForeground(new Color(240, 128, 128));
		txtappdate.setBackground(new Color(255, 255, 255));
		txtappdate.setBounds(220, 173, 180, 33);
		contentPane.add(txtappdate);
		
		rdyes = new JRadioButton("Yes");
		rdyes.setForeground(new Color(240, 128, 128));
		rdyes.setBackground(new Color(240, 230, 140));
		visit_group.add(rdyes);
		rdyes.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rdyes.setBounds(220, 431, 107, 25);
		contentPane.add(rdyes);
		
		rdno = new JRadioButton("No");
		rdno.setBackground(new Color(240, 230, 140));
		rdno.setForeground(new Color(240, 128, 128));
		visit_group.add(rdno);
		rdno.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rdno.setBounds(329, 431, 93, 25);
		contentPane.add(rdno);
		
		rdphone = new JRadioButton("By Phone");
		rdphone.setForeground(new Color(240, 128, 128));
		rdphone.setBackground(new Color(240, 230, 140));
		appmode_group.add(rdphone);
		rdphone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rdphone.setBounds(220, 392, 107, 33);
		contentPane.add(rdphone);
		
		rdwalk = new JRadioButton("Walk In");
		rdwalk.setBackground(new Color(240, 230, 140));
		rdwalk.setForeground(new Color(240, 128, 128));
		appmode_group.add(rdwalk);
		rdwalk.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		rdwalk.setBounds(329, 392, 93, 33);
		contentPane.add(rdwalk);
		
		JLabel lblhead = new JLabel("Patient Appointment Form");
		lblhead.setForeground(new Color(240, 128, 128));
		lblhead.setBackground(new Color(240, 230, 140));
		lblhead.setHorizontalAlignment(SwingConstants.CENTER);
		lblhead.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblhead.setBounds(33, 25, 387, 36);
		contentPane.add(lblhead);
		
		cmbdocid = new JComboBox();
		cmbdocid.setForeground(new Color(240, 128, 128));
		cmbdocid.setBackground(new Color(240, 230, 140));
		cmbdocid.setModel(new DefaultComboBoxModel(new String[] {"--Select Doctor ID--"}));
		cmbdocid.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		cmbdocid.setToolTipText("Please select valid Doctor ID.");
		cmbdocid.setBounds(220, 220, 180, 33);
		fillCombo();
		contentPane.add(cmbdocid);
		cmbdocid.addItemListener(this);
		
		long n=(long)Math.floor(Math.random()*9_000_000_0L);
		String appno="AI"+n;
		txtappno.setText(appno);
	}
	
	java.sql.Date d1,d2;
	void validatepatient()
	{
		java.util.Date d=txtdate.getDate();
		String date=d.toString().trim();
		java.util.Date appd=txtappdate.getDate();
		d1=new Date(d.getTime());
		System.out.println(d1);
		
		String appdate=appd.toString().trim();
		String appno=txtappno.getText().trim();
		d2=new Date(appd.getTime());
		System.out.println(d2);
		String patname=txtpatientname.getText().trim();
		String age=txtage.getText().trim();
		int Age =Integer.parseInt(age);
		String problem=txtproblem.getText().trim();
		String phone=txtphone.getText().trim();
		
		String visit="";
		if(rdyes.isSelected())
		{
			visit=rdyes.getText();
		}
		if(rdno.isSelected())
		{
			visit=rdno.getText();
		}
		
		String mode="";
		if(rdphone.isSelected())
		{
			mode=rdphone.getText();
		}
		if(rdwalk.isSelected())
		{
			mode=rdwalk.getText();
		}
		
		if(appno.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please Enter Appointment Number.","MandatoryField",JOptionPane.ERROR_MESSAGE);
			
		}
		else if(date.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Please Choose Date of Calling/Visiting","Mandatory Field",JOptionPane.ERROR_MESSAGE);
		}
		else if(appdate.isEmpty())
		{
			JOptionPane.showMessageDialog(this,"Please Choose Date of Appointment","Mandatory Field",JOptionPane.ERROR_MESSAGE);
		}
		else  if(patname.isEmpty())
		    {
			   JOptionPane.showMessageDialog(this, "Please Enter Patient Name","MandatoryField",JOptionPane.ERROR_MESSAGE);
		    }
		else if (age.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please Enter Age","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if(problem.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please Enter Your Problem","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if(mode.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please Select Any One Option","MandatoryField",JOptionPane.ERROR_MESSAGE);
			
		}
		
		else  if(visit.isEmpty())
		    {
			   JOptionPane.showMessageDialog(this, "Please Select Patient Status","MandatoryField",JOptionPane.ERROR_MESSAGE);
		    }
		else if (phone.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please Enter Phone Number","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		else if (!(Age>0&&Age<=120))
		{
			JOptionPane.showMessageDialog(this, "Please Enter Age between 1 to 120 years.","MandatoryField",JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{
			PreparedStatement ps=null;
			String str_insert="insert into patient_appointment(Date, AppointmentDate, AppointmentNo, DoctorId, PatientName, Age, Problem, AppointmentMode, PatientVisit, Phone)values(?,?,?,?,?,?,?,?,?,?)";
			
			try
			{
				ps=con.prepareStatement(str_insert);
				
				ps.setDate(1,d1);
				ps.setDate(2,d2);
				ps.setString(3,appno);
				ps.setString(4,DocID);
				ps.setString(5,patname);
				ps.setString(6,age);
				ps.setString(7,problem);
				ps.setString(8,mode);
				ps.setString(9,visit);
				ps.setString(10,phone);
				
				int row_status=ps.executeUpdate();
				System.out.println("insert status "+row_status);
				if(row_status>0)
				{
					JOptionPane.showMessageDialog(this,"Patient Appointment Done Successfully");
					txtdate.setCalendar(null);
					txtappdate.setCalendar(null);
					txtappno.setText("");
					txtpatientname.setText("");
					cmbdocid.setSelectedIndex(0);
					txtage.setText("");
					txtproblem.setText("");
					visit_group.clearSelection();
					appmode_group.clearSelection();
					txtphone.setText("");
					
					
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
					catch (SQLException se) 
					{
						se.printStackTrace();
					}
				}
			}
		}
		
	}
		
	String name;
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
					name=rs.getString("DoctorId");
					//System.out.println(name);
					cmbdocid.addItem(name);//add data into combo box
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

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		validatepatient();
		
	}

	String DocID;
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int state =e.getStateChange();

		if (state==1)
		{
			DocID=(String)cmbdocid.getSelectedItem();//fetch the value from combo box
			if(DocID.equalsIgnoreCase("---Select Doctor ID---"))
			{
				JOptionPane.showMessageDialog(this,"Please select valid ID");
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtpatientname)
		{
			char c=e.getKeyChar();
			if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_TAB)||(c==KeyEvent.VK_SPACE)||(Character.isLetter(c))))
			{
				e.consume();
				JOptionPane.showMessageDialog(this,"Patient name requires only alphabets","Mandatory Field",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource()==txtage)
		{
			char c=e.getKeyChar();
			if(!((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_TAB)||(Character.isDigit(c))))
			{
				e.consume();
				JOptionPane.showMessageDialog(this,"Age requires only numbers","Mandatory Field",JOptionPane.WARNING_MESSAGE);
			}
		}
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
