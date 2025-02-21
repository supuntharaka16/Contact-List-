import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


	public class HomePageForm extends JFrame {
		

	
		private JButton btnAdd;
		private JButton btnupdate;
		private JButton btndelete;
		private JButton btnSearch;
		private JButton btnList;
		private JButton btnExit;
		
		private JLabel titleLabel;
		private JLabel titleLabel1;
		private JLabel HomeLabel;
		private JLabel pic;
		
		
		
		HomePageForm(){
			
		setTitle("IFRIEND CONTACT MANAGER");
		setSize(700,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel titlePanel=new JPanel(new GridLayout(2,2));
		
		titleLabel=new JLabel("IFRIEND");
		titleLabel.setFont(new Font("",1,24));
		titleLabel.setHorizontalAlignment(JLabel.LEFT);
		titlePanel.add(titleLabel);
		
		HomeLabel = new JLabel("HOME PAGE");
		HomeLabel.setFont(new Font("",1,24));
		HomeLabel.setHorizontalAlignment(JLabel.CENTER);
		titlePanel.add(HomeLabel);
		
		titleLabel1=new JLabel("CONTACT MANAGER");
		titleLabel1.setFont(new Font("",1,24));
		titleLabel1.setHorizontalAlignment(JLabel.LEFT);
		titlePanel.add(titleLabel1);
		
		titlePanel.setBackground(new Color(173, 216, 230));
		add("North",titlePanel);
		
		
		 ImageIcon icon = new ImageIcon("D:\\ICM114\\OOP\\Contact\\ifriendcontact.png");
		 Image img = icon.getImage().getScaledInstance(400, 500, Image.SCALE_SMOOTH);
		 ImageIcon resizedIcon = new ImageIcon(img);
		 JLabel imgLabel = new JLabel(resizedIcon);
       
        
        add("West",imgLabel);
        
    	JPanel buttonPanel=new JPanel(new GridLayout(5,1));
		
		btnAdd=new JButton("Add New Contacts");
		btnAdd.setFont(new Font("",1,16));	
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new AddContactForm().setVisible(true);
			}
		});		
		buttonPanel.add(btnAdd);
		
		btnupdate=new JButton("Update Contacts");
		btnupdate.setFont(new Font("",1,16));	
		btnupdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new UpdateContactForm().setVisible(true);
			}
		});	
		buttonPanel.add(btnupdate);
		
		btndelete=new JButton("Delete Contacts");
		btndelete.setFont(new Font("",1,16));	
		btndelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new DeleteContactForm().setVisible(true);
			}
		});	
		buttonPanel.add(btndelete);
		
		btnSearch=new JButton("Search Contacts");
		btnSearch.setFont(new Font("",1,16));	
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new SearchContactForm().setVisible(true);
			}
		});		
		buttonPanel.add(btnSearch);
		
		btnList=new JButton("List Contacts");
		btnList.setFont(new Font("",1,16));	
		btnList.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ViewContactForm().setVisible(true);
			}
		});	
		buttonPanel.add(btnList);
		
		
		add("Center",buttonPanel);
		
		JPanel exitPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("",1,16));	
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
		exitPanel.add(btnExit);
		
		add("South",exitPanel);
			
		
	}
}
