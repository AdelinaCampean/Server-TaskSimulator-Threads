package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class ViewI extends JFrame {
	
	private JFrame frame=new JFrame("Threads");
	private JFrame frame2 = new JFrame("ACTIVITY LOG");
	private JTextField minim = new JTextField();
	private JTextField maxim = new JTextField();
	private JTextField minim2= new JTextField();
	private JTextField maxim2 = new JTextField();
	private JTextField simu = new JTextField();
	private JButton start = new JButton("START");
	private JTextField tsk= new JTextField();;
	private JTextField server1 = new JTextField();
	private JTextField server2 = new JTextField();
	private JTextField server3 = new JTextField();
	private JTextField server4 = new JTextField();
	private JTextArea textArea = new JTextArea();
	private JTextField avg = new JTextField();

	private JComboBox comboBox = new JComboBox(new String[]
			{
				"1", "2", "3", "4"
			});
	
	public ViewI() {
		getContentPane().setLayout(null);
		
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 600);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);	
		
		minim.setBounds(130, 80, 145, 36);
		panel.add(minim);

		maxim.setBounds(400, 80, 145, 36);
		panel.add(maxim);
		
		minim2.setBounds(130, 200, 145, 36);
		panel.add(minim2);
		
		JLabel minl = new JLabel("MIN");
		minl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minl.setBounds(30, 80, 90, 36);
		panel.add(minl);
		
		JLabel minl2 = new JLabel("MIN");
		minl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		minl2.setBounds(30, 200, 90, 36);
		panel.add(minl2);
			
		maxim2.setBounds(400, 200, 145, 36);
		panel.add(maxim2);
		
		JLabel maxl = new JLabel("MAX");
		maxl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maxl.setBounds(315, 80, 90, 36);
		panel.add(maxl);
		
		JLabel maxl2 = new JLabel("MAX");
		maxl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maxl2.setBounds(315, 200, 90, 36);
		panel.add(maxl2);
		
		JLabel serv = new JLabel("Interval of Service Time");
		serv.setFont(new Font("Tahoma", Font.PLAIN, 16));
		serv.setBounds(12, 151, 189, 36);
		panel.add(serv);
		
		JLabel arr = new JLabel("Interval of Arriving Time");
		arr.setFont(new Font("Tahoma", Font.PLAIN, 16));
		arr.setBounds(12, 31, 189, 36);
		panel.add(arr);
		
		
		comboBox.setMaximumRowCount(5);
		comboBox.setBounds(130, 297, 150, 45);
		
		panel.add(comboBox);
		
		JLabel nrq = new JLabel("Nr. of Servers");
		nrq.setFont(new Font("Tahoma", Font.PLAIN, 16));
		nrq.setBounds(12, 301, 108, 36);
		panel.add(nrq);
		
		JLabel sim = new JLabel("Simulation Time");
		sim.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sim.setBounds(12, 416, 121, 36);
		panel.add(sim);
		
		simu.setBounds(130, 417, 145, 36);
		panel.add(simu);
		
		
		start.setBounds(366, 444, 165, 68);
		panel.add(start);
		
		frame.getContentPane().add(panel);
		
		tsk.setBounds(400, 301, 145, 36);
		panel.add(tsk);
	
		JLabel clients = new JLabel("Nr. of Tasks");
		clients.setFont(new Font("Tahoma", Font.PLAIN, 16));
		clients.setBounds(292, 311, 113, 31);
		panel.add(clients);
		frame.setVisible(true);
		
	}
	


	public void frame2()
	{

		frame2.setResizable(false);
		frame2.setBounds(100, 100, 1220, 1100);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		frame2.getContentPane().add(panel2);
		
		server1.setBounds(36, 205, 555, 55);
		panel2.add(server1);
		
		JLabel q1 = new JLabel("SERVER 1");
		q1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q1.setBounds(36, 155, 195, 35);
		panel2.add(q1);
		
		JLabel q2 = new JLabel("SERVER 2");
		q2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q2.setBounds(36, 280, 195, 35);
		panel2.add(q2);
		
		server2.setBounds(36, 330, 555, 55);
		panel2.add(server2);
		
		JLabel q3 = new JLabel("SERVER 3");
		q3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q3.setBounds(36, 405, 195, 35);
		panel2.add(q3);
		
		server3.setBounds(36, 455, 555, 55);
		panel2.add(server3);
		
		JLabel q4 = new JLabel("SERVER 4");
		q4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		q4.setBounds(36, 530, 195, 35);
		panel2.add(q4);
		
		server4.setBounds(36, 580, 555, 55);
		panel2.add(server4);
	
		JLabel info = new JLabel("LOG OF EVENTS");
		info.setForeground(Color.RED);
		info.setFont(new Font("Tahoma", Font.BOLD, 35));
		info.setBounds(84, 57, 286, 43);
		panel2.add(info);
		
		textArea.setBounds(600, 35, 590, 1000);
		panel2.add(textArea);
		
		JLabel av = new JLabel("Average Waiting Time");
		av.setFont(new Font("Tahoma", Font.PLAIN, 24));
		av.setBounds(160, 700, 240, 40);
		panel2.add(av);
		
		avg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		avg.setBounds(214, 763, 124, 66);
		panel2.add(avg);

		
		frame2.setVisible(true);
		
	}


	public int getAvg() {
		return Integer.parseInt(avg.getText());
	}
	
	 public  void setAvg(float avg) {
		this.avg.setText(Float.toString(avg));
	}
	
	public String getTextArea() {
		return textArea.getText();
	}

	  public synchronized void setTextArea(String textArea) {
		this.textArea.setText(textArea);
	}

	public int getTask() {
		return Integer.parseInt(tsk.getText());
	}


	public void setTask(String task) {
		this.tsk.setText(task);
	}

	public String getServer1() {
		return server1.getText();
	}

	public  void setServer1(String server1) {
		this.server1.setText(server1);
	}

	public String getServer2() {
		return server2.getText();
	}

	public  void setServer2(String server2) {
		this.server2.setText(server2);
	}

	public String getServer3() {
		return server3.getText();
	}

	public  void setServer3(String server3) {
		this.server3.setText(server3);
	}

	public String getServer4() {
		return server4.getText();
	}

	public  void setServer4(String server4) {
		this.server4.setText(server4);
	}

	public int getMinim() {
		return Integer.parseInt(minim.getText());
	}


	public void setMinim(JTextField minim) {
		this.minim = minim;
	}



	public void setMaxim(JTextField maxim) {
		this.maxim = maxim;
	}


	public int getMinim2() {
		return Integer.parseInt(minim2.getText());
	}


	public void setMinim2(JTextField minim2) {
		this.minim2 = minim2;
	}


	public int getMaxim2() {
		return Integer.parseInt(maxim2.getText());
	}


	public int getSim() {
		return Integer.parseInt(simu.getText());
	}

	public int getMaxim(){
		return Integer.parseInt(maxim.getText());
		}
	
	public void setSimu(JTextField minim3) {
		this.simu = minim3;
	}


	public int getComboBox() {
		return Integer.parseInt(comboBox.getSelectedItem().toString());
	}
	

 

	public void addListenerButon(ActionListener st) {
		// TODO Auto-generated method stub
		start.addActionListener(st);
	}
}
