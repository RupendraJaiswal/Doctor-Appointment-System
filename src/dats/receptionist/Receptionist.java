package dats.receptionist;


import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.gui.AllDoctors;
import dats.gui.Datewise;
import dats.gui.DoctorDetails;

import dats.gui.DoctorIdDatewise;
import dats.gui.Login;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Receptionist extends JFrame implements ActionListener,WindowListener 
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receptionist frame = new Receptionist();
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
	public Receptionist() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Receptionist.class.getResource("/dats/images/receptionist.png")));
		this.addWindowListener(this);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Receptionist Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnpatient = new JMenu("Patient");
		menuBar.add(mnpatient);
		
		JMenuItem miadd = new JMenuItem("Add");
		miadd.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/add.png")));
		miadd.addActionListener(this);
		mnpatient.add(miadd);
		
		JMenuItem miupdate = new JMenuItem("Update");
		miupdate.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/update.png")));
		miupdate.addActionListener(this);
		mnpatient.add(miupdate);
		
		JMenu mi = new JMenu("Search");
		menuBar.add(mi);
		
		JMenuItem miphonetoken = new JMenuItem("Phone/Token");
		miphonetoken.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/phonetoken.png")));
		miphonetoken.addActionListener(this);
		mi.add(miphonetoken);
		
		JMenu mnreport = new JMenu("Report");
		menuBar.add(mnreport);
		
		JMenuItem mialldoc = new JMenuItem("All Doctor Details");
		mialldoc.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/rep.png")));
		mialldoc.addActionListener(this);
		mnreport.add(mialldoc);
		
		JMenuItem miidwise = new JMenuItem("Doctor ID wise");
		miidwise.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/report.png")));
		miidwise.addActionListener(this);
		mnreport.add(miidwise);
		
		JMenuItem midatewise = new JMenuItem("Datewise");
		midatewise.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/rept.png")));
		midatewise.addActionListener(this);
		mnreport.add(midatewise);
		
		JMenuItem mididw = new JMenuItem("Doctor ID & Date Wise");
		mididw.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/status.png")));
		mididw.addActionListener(this);
		mnreport.add(mididw);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Receptionist.class.getResource("/dats/images/health.jpg")));
		lblNewLabel.setBounds(0, 0, 1544, 788);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Login l=new Login();
		l.setVisible(true);
		
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
		String caption=e.getActionCommand();
		switch(caption)
		{
		case "Add":
			AddPatient ap=new AddPatient();
			ap.setVisible(true);
			break;
		case "Update":
			UpdatePatient up=new UpdatePatient();
			up.setVisible(true);
			break;
		case "Phone/Token":
			Phone_Token pt=new Phone_Token();
			pt.setVisible(true);
			break;
		case "All Doctor Details":
			AllDoctors ds=new AllDoctors();
			ds.setVisible(true);
			break;
		case "Doctor ID wise":
			DoctorDetails dw=new DoctorDetails();
			dw.setVisible(true);
			break;
		case "Datewise":
			Datewise dt=new Datewise();
			dt.setVisible(true);
			break;
		case "Doctor ID & Date Wise":
			DoctorIdDatewise di=new DoctorIdDatewise();
			di.setVisible(true);
			break;
		}
	}
}
