import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


class UpdateContactForm extends JFrame{
		private JLabel titleLabel;
		private JLabel lblID;
		private JLabel lblName;
		private JLabel lblPhoneNumber;
		private JLabel lblCompany;
		private JLabel lblSalary;
		private JLabel lblBday;
		
		private JButton btnSearch;
		private JButton btnBack;
		private JButton btnUpdate;
		private JButton btnCancel;
		
		private JTextField txtId;	
		private JTextField txtName;	
		private JTextField txtPhoneNumber;	
		private JTextField txtCompany;	
		private JTextField txtSalary;	
		private JTextField txtBday;
		private JTextField txtSearch;
		
		
		
		UpdateContactForm(){
				
		setTitle("Update Contact");
		setSize(800,600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" UPDATE CONTACTS");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
	
		JPanel lblPanel = new JPanel(new GridLayout(7,1));
		txtSearch = new JTextField(15);
	    txtSearch.setFont(new Font("",1,18));	
		JPanel searchTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
		searchTextPanel.add(txtSearch);
		lblPanel.add(searchTextPanel);
		
		lblID = new JLabel("Contact ID");
	    lblID.setFont(new Font("",1,20));
	    lblPanel.add(lblID);
	    
	    lblName = new JLabel("Name");
	    lblName.setFont(new Font("",1,18));
	    lblPanel.add(lblName);
	    
	    lblPhoneNumber = new JLabel("Contact Number");
	    lblPhoneNumber.setFont(new Font("",1,18));
	    lblPanel.add(lblPhoneNumber);
	    
	    lblCompany = new JLabel("Company");
	    lblCompany.setFont(new Font("",1,18));
	    lblPanel.add(lblCompany);
	    
	    lblSalary = new JLabel("Salary");
	    lblSalary.setFont(new Font("",1,18));
	    lblPanel.add(lblSalary);
	    
	    lblBday = new JLabel("Birthday");
	    lblBday.setFont(new Font("",1,18));
	    lblPanel.add(lblBday);
	    
	    add("West",lblPanel);
	    
	    JPanel textPanel = new JPanel(new GridLayout(7,1));
	    JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	    btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("",1,18));	
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String txt=txtSearch.getText();
				int index=searchContact(txt);
				if(index!=-1){
					List contactList = getAllContact();
					Contact c1=contactList.get(index);
					txtId.setText(c1.getID());
					txtName.setText(c1.getName());
					txtPhoneNumber.setText(c1.getPhoneNumber());
					txtCompany.setText(c1.getCompanyName());
					txtSalary.setText(c1.getSalary()+"");
					txtBday.setText(c1.getBday());
				}else{
					JOptionPane.showMessageDialog(null,"Contact is not exists...");	
				}
			}
		});
		
		searchPanel.add(btnSearch);
	    textPanel.add(searchPanel);
		
		txtId=new JTextField(15);
		txtId.setFont(new Font("",1,18));
		txtId.setEditable(false);	
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		idTextPanel.add(txtId);
		
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,18));	
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameTextPanel.add(txtName);
		
		textPanel.add(nameTextPanel);
		
		txtPhoneNumber=new JTextField(15);
		txtPhoneNumber.setFont(new Font("",1,18));	
		JPanel phoneNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		phoneNumberTextPanel.add(txtPhoneNumber);
		
		textPanel.add(phoneNumberTextPanel);
		
		txtCompany=new JTextField(10);
		txtCompany.setFont(new Font("",1,18));	
		JPanel companyNameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		companyNameTextPanel.add(txtCompany);
		
		textPanel.add(companyNameTextPanel);
		
		txtSalary=new JTextField(10);
		txtSalary.setFont(new Font("",1,18));	
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		salaryTextPanel.add(txtSalary);
		
		textPanel.add(salaryTextPanel);
		
		txtBday=new JTextField(10);
		txtBday.setFont(new Font("",1,18));	
		JPanel bdayTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		bdayTextPanel.add(txtBday);
		
		textPanel.add(bdayTextPanel);
		
		add("Center",textPanel);
		
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("",1,16));
		btnUpdate.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent evt){
			    int index =  searchContact(txtId.getText());
			    String id = txtId.getText();
			    if(index!=-1){
			    String name = txtName.getText();
			    String phoneNumber = txtPhoneNumber.getText();
			    String companyName = txtCompany.getText();
			    double salary = Double.parseDouble(txtSalary.getText());
			    String bday = txtBday.getText();
				Contact c = new Contact (id,name,phoneNumber,companyName,salary,bday);
				List contactList = getAllContact();
				contactList.add(index,c);
				for(int i = 0;i<contactList.size();i++){
					Contact c1 = contactList.get(i);
					writeFile(c1.getID(),c1.getName(),c1.getPhoneNumber(),c1.getCompanyName(),c1.getSalary(),c1.getBday());
				}
				JOptionPane.showMessageDialog(null,"Update Success..");
			}
			else{
				JOptionPane.showMessageDialog(null,id+" is not exists...");	
			}
				
			}
		});		
	   
		buttonPanel.add(btnUpdate);
		
		add("South",buttonPanel);
		
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));	
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});		
	   
		buttonPanel.add(btnBack);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,16));	
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBday.setText("");
			}
		});		
		buttonPanel.add(btnCancel);
		
		add("South",buttonPanel);
		
		
		}
		
		
		
		private int searchContact(String txt){
			List  contactList = getAllContact();
			for(int i = 0 ; i<txt.length();i++){
				if(txt.equalsIgnoreCase(contactList.get(i).getPhoneNumber())){
					return i;
				}
				else if(txt.equalsIgnoreCase(contactList.get(i).getName())){
					return i;
				}
				else if(txt.equalsIgnoreCase(contactList.get(i).getID())){
					return i;
				}
				else{
					return -1;
				}
				
			}
			return -1;
		}
		  private List getAllContact(){
		List contactList=new List(100,0.5);
		try{
			FileReader fr=new FileReader("Contact.txt");
			BufferedReader br=new BufferedReader(fr);
			
			String line=br.readLine();
			while(line!=null){
				String[] rowData=line.split(","); 
				String id=rowData[0];
				String name=rowData[1];
				String phoneNumber = rowData[2];
				String company = rowData[3];
				double Salary = Double.parseDouble(rowData[4]);
				String bday = rowData[5];
			
				Contact s1=new Contact(id,name,phoneNumber,company,Salary,bday);
				contactList.add(s1);
				line=br.readLine();
			}
			
		}catch(IOException ex){
			System.out.println(ex);
		}
		return contactList;
	}
	private void writeFile(String id,String name,String phoneNumber,String company,double salary,String bday){
		String rowData = id+","+name+","+phoneNumber+","+company+","+salary+","+bday+"\n";
		
		try{
			FileWriter fw=new FileWriter("iContact.txt");
			fw.write(rowData);
			fw.close();
		}catch(IOException ex){
			System.out.println(ex);
		}
	}
		
	}
