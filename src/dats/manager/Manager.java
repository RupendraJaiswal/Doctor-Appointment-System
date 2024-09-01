package dats.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.dbutils.DbConnection;
import dats.gui.Datewise;
import dats.gui.DoctorDetails;
import dats.gui.AllDoctors;
import dats.gui.DoctorIdDatewise;
import dats.gui.Login;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Manager extends JFrame  implements ActionListener,WindowListener
{

	private JPanel menudoctor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manager frame = new Manager();
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
	public Manager() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manager.class.getResource("/dats/images/manager.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		this.addWindowListener(this);
		setTitle("Manager Page");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1550, 848);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mndoctor = new JMenu("Doctor");
		menuBar.add(mndoctor);
		
		JMenuItem miadd = new JMenuItem("Add");
		miadd.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/adds.png")));
		miadd.addActionListener(this);
		mndoctor.add(miadd);
		
		JMenuItem miupdate = new JMenuItem("Update");
		miupdate.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/up.png")));
		miupdate.addActionListener(this);
		mndoctor.add(miupdate);
		
		JMenuItem midelete = new JMenuItem("Delete");
		midelete.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/delete.png")));
		midelete.addActionListener(this);
		mndoctor.add(midelete);
		
		JMenu mnreport = new JMenu("Report");
		menuBar.add(mnreport);
		
		JMenuItem mialldoc = new JMenuItem("All Doctor Details");
		mialldoc.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/rep.png")));
		mialldoc.addActionListener(this);
		mnreport.add(mialldoc);
		
		JMenuItem miidwise = new JMenuItem("Doctor ID Wise");
		miidwise.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/report.png")));
		miidwise.addActionListener(this);
		mnreport.add(miidwise);
		
		JMenuItem midatewise = new JMenuItem("Datewise");
		midatewise.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/rept.png")));
		midatewise.addActionListener(this);
		mnreport.add(midatewise);
		
		JMenuItem mididw = new JMenuItem("Doctor ID & Date Wise");
		mididw.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/status.png")));
		mididw.addActionListener(this);
		mnreport.add(mididw);
		
		menudoctor = new JPanel();
		menudoctor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menudoctor);
		menudoctor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Manager.class.getResource("/dats/images/healthcare.jpg")));
		lblNewLabel.setBounds(0, 0, 1547, 800);
		menudoctor.add(lblNewLabel);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
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
		String caption=e.getActionCommand();
		switch(caption)
		{
		case "Add":
			AddDoctor ad=new AddDoctor();
			ad.setVisible(true);
			break;
		case "Delete":
			DeleteDoctor dd=new DeleteDoctor();
			dd.setVisible(true);
			break;
		case "Update":
			UpdateDoctor ud=new UpdateDoctor();
			ud.setVisible(true);
			break;
		case "All Doctor Details":
			AllDoctors ds=new AllDoctors();
			ds.setVisible(true);
			break;
		case "Doctor ID Wise":
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
