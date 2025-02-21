import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;

 class AddContactForm extends JFrame{
	
		private JLabel lblID;
		private JLabel lblName;
		private JLabel lblPhoneNumber;
		private JLabel lblCompany;
		private JLabel lblSalary;
		private JLabel lblBday;
		
		private JButton btnAdd;
		private JButton btnCancel;
		private JButton btnBack;

		
		private JTextField txtId;	
		private JTextField txtName;	
		private JTextField txtPhoneNumber;	
		private JTextField txtCompany;	
		private JTextField txtSalary;	
		private JTextField txtBday;	
		
	AddContactForm(){
		setTitle("Add Contact");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		setLayout(new BorderLayout());
		
		JPanel tittlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel tittleLabel = new JLabel(" ADD CONTACTS");
		tittleLabel.setFont(new Font("",1,28));
		tittleLabel.setHorizontalAlignment(JLabel.CENTER);
		tittlePanel.add(tittleLabel);
		tittlePanel.setBackground(new Color(173, 216, 230));
		add("North", tittlePanel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(2,1));
		JPanel exitbtnPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		btnAdd=new JButton("Add");
		btnAdd.setFont(new Font("",1,16));	
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtId.getText();
				String name=txtName.getText();
				String phoneNumber=txtPhoneNumber.getText();
				String company=txtCompany.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				String bday=txtBday.getText();
				
				writeContact(id, name, phoneNumber, company, salary, bday);
				JOptionPane.showMessageDialog(null,"Added Success");
				generateId();
				txtName.setText("");
				txtPhoneNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBday.setText("");

			}
		});
		buttonPanel.add(btnAdd);
		
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
		buttonPanel.add(exitbtnPanel);
		
		JPanel backBtnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnBack = new JButton("Back To HomePage");
		btnBack.setFont(new Font("",1,16));
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		backBtnPanel.add(btnBack);
		buttonPanel.add(backBtnPanel);
		
		add("South",buttonPanel);
		
		JPanel lblPanel=new JPanel(new GridLayout(6,1));
		
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
		
		JPanel textPanel=new JPanel(new GridLayout(6,1));
		txtId=new JTextField(6);
		txtId.setEditable(false);
		generateId();
		txtId.setFont(new Font("",1,18));	
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		idTextPanel.add(txtId);
		
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(15);
		txtName.setFont(new Font("",1,18));	
		txtName.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent evt){
				if(txtName.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"empty contact name");
					txtName.requestFocus();
				}
			}
			public void focusGained(FocusEvent arg0) {
				txtName.selectAll();
			}
		});
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		nameTextPanel.add(txtName);
		
		textPanel.add(nameTextPanel);
		
        txtPhoneNumber=new JTextField(15);
		txtPhoneNumber.setFont(new Font("",1,18));
		txtPhoneNumber.addFocusListener(new FocusListener(){
			public void focusLost(FocusEvent evt){
				if(txtPhoneNumber.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"empty Phone Number");
					txtPhoneNumber.requestFocus();
				}
				 if(!isPhoneNumberCorrect(txtPhoneNumber.getText())){
					JOptionPane.showMessageDialog(null,"Invalid Phone Number");
					txtPhoneNumber.requestFocus();
			}
			if(PhoneNumberExist(txtPhoneNumber.getText())){
				JOptionPane.showMessageDialog(null,"Phone Number is Already Exists..");
				txtPhoneNumber.requestFocus();
			}
			
			  
		}
		public void focusGained(FocusEvent arg0) {
				txtPhoneNumber.selectAll();
			}
		});
		JPanel phoneTextPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		phoneTextPanel.add(txtPhoneNumber);
		
		textPanel.add(phoneTextPanel);
		
        txtCompany = new JTextField(15);
        txtCompany.setFont(new Font("", 1, 18));
        JPanel companyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        companyPanel.add(txtCompany);
        textPanel.add(companyPanel);

        txtSalary = new JTextField(15);
        txtSalary.setFont(new Font("", 1, 18));
        JPanel salaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        salaryPanel.add(txtSalary);
        textPanel.add(salaryPanel);
        
        txtBday = new JTextField(15);
        txtBday.setFont(new Font("", 1, 18));
		txtBday.addFocusListener(new FocusListener(){
			public void focusLost( FocusEvent evt){
				if(txtBday.getText().isEmpty()){
					JOptionPane.showMessageDialog(null,"Empty phone number..");
					txtBday.requestFocus();
				}
				if(!validBirthday(txtPhoneNumber.getText())){
					JOptionPane.showMessageDialog(null,"Invalid phone number..");
					txtBday.requestFocus();
				}
			}
			public void focusGained(FocusEvent arg0){
				txtBday.selectAll();
			}
			
		});
        JPanel bdayTextPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bdayTextPanel.add(txtBday);
        
        textPanel.add(bdayTextPanel);
		
		add("Center",textPanel);
		
	}
		
	public void generateId(){
		List contactList = getAllContact();
		if(contactList.size()<=0){
			txtId.setText("B0001");
		}
		else {
			Contact lastContact = contactList.get(contactList.size()-1);
			String lastId = lastContact.getID();
			int lastIdNumber = Integer.parseInt(lastId.substring(1));
			String newID = String.format("B%04d",(lastIdNumber+1));
			txtId.setText(newID);
		}
	
	}
	private void writeContact(String ID, String Name, String phoneNumber, String companyName, double salary, String bday){
		String rowData=ID+","+Name+","+phoneNumber+","+companyName+","+salary+","+bday+"\n";

		try{
			FileWriter fw=new FileWriter("Contact.txt",true);//Appendable file writer
			fw.write(rowData);
			fw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}	
	public  boolean isPhoneNumberCorrect(String phoneNumber){
		if(phoneNumber.charAt(0)=='0' && phoneNumber.length() == 10){
				for(int i =0;i<phoneNumber.length();i++){
				if(!Character.isDigit(phoneNumber.charAt(i))){
					return false;
				}			
			}
			return true;
		}
		else{
			return false;

		}
	}
	public boolean PhoneNumberExist(String phoneNumber){
		List contactList = getAllContact();
		
		for(int i = 0; i<phoneNumber.length(); i++){
			if(phoneNumber.equals(contactList.get(i).getPhoneNumber())){
				return true;
			}
			return false;
		}
		if(phoneNumber.length()==0){
			return false;
		}
		return false;
	}
	public boolean validBirthday(String bday){
		String[] str = bday.split("[- /]");
		
		int year = Integer.parseInt(str[0]);
		int month = Integer.parseInt(str[1]);
		int days = Integer.parseInt(str[2]);
		
		LocalDate currentDate = LocalDate.now();
		int currentyear = currentDate.getYear();
		int currentmonth = currentDate.getMonthValue();
		int currentdate = currentDate.getDayOfMonth();
		
		if(year>currentyear){
			return false;
		}
		else if(month<=0 || month>12){
			return false;
		}
		else if((year%4)!=0 && month==2 && days>28){
			return false;
		}
		else if((year%4)!=0 && month==2 && days<=29){
			return true;
		}
		else if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(days>0 && days <=31){
				return true;
			}
		}
		else if(month==4 || month==6 || month==9 || month==11){
			if(days>0 && days<=30){
				return true;
			}
		}
		else if(month == currentmonth){
			if(days == currentdate){
				return false;
			}
		}
		return false;
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
				String phoneNumber=rowData[2];
				String company=rowData[3];
				double Salary=Double.parseDouble(rowData[4]);
				String bday=rowData[5];
			
				Contact s1=new Contact(id,name,phoneNumber,company,Salary,bday);
				contactList.add(s1);
				line=br.readLine();
			}
			
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return contactList;
	}
}	
