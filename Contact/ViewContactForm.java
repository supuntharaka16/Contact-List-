import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class ViewContactForm extends JFrame{
		private JButton btnName;
		private JButton btnSalary;
		private JButton btnBday;
		private JButton btnCancel;
		
		private JLabel titleLabel;
		
		
		ViewContactForm(){
		setTitle("CONTACTS LIST");
		setSize(700,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" CONTACTS LIST");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
		JPanel btnPanel = new JPanel(new GridLayout(3,1));
		
		JPanel namebtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnName = new JButton("List By Name");
		btnName.setFont(new Font("",1,16));	
		btnName.setPreferredSize(new Dimension(200,100));
		btnName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ShortNameForm().setVisible(true);
			}
		});		
	   
		namebtn.add(btnName);
		btnPanel.add(namebtn);
		
		JPanel salarybtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnSalary = new JButton("List By Salary");
		btnSalary.setFont(new Font("",1,16));	
		btnSalary.setPreferredSize(new Dimension(200,100));
		btnSalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SortSalaryForm().setVisible(true);
			}
		});	
	   
		salarybtn.add(btnSalary);
		btnPanel.add(salarybtn);
		
		JPanel bdaybtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnBday = new JButton("List By Birthday");
		btnBday.setPreferredSize(new Dimension(200,100));
		btnBday.setFont(new Font("",1,16));	
		btnBday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				 new SortBirthdayForm().setVisible(true);
			}
		});	
	   
		bdaybtn.add(btnBday);
		btnPanel.add(bdaybtn);
		
		add("Center",btnPanel);
		
		JPanel canclePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnCancel = new JButton("Back To HomePage");
		btnCancel.setFont(new Font("",1,16));	
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		canclePanel.add(btnCancel);
		add("South",canclePanel);
		
		
		
	}	
}
